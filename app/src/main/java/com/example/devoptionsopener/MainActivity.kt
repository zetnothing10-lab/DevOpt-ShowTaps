package com.example.devoptionsopener

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS).apply {
                // Built-in Settings feature: scroll to this row and highlight it.
                // "show_touches" is the key of the "Show taps" setting.
                putExtra(":settings:fragment_args_key", "show_touches")
                putExtra(
                    ":settings:show_fragment_args",
                    Bundle().apply { putString(":settings:fragment_args_key", "show_touches") }
                )
            }
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Developer options is off. In About phone, tap Build number 7 times.",
                Toast.LENGTH_LONG
            ).show()
            try {
                startActivity(Intent(Settings.ACTION_DEVICE_INFO_SETTINGS))
            } catch (_: Exception) {
            }
        }
        finish()
    }
}
