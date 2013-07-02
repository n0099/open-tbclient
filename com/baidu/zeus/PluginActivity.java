package com.baidu.zeus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class PluginActivity extends Activity {
    static final String INTENT_EXTRA_CLASS_NAME = "android.webkit.plugin.CLASS_NAME";
    static final String INTENT_EXTRA_NPP_INSTANCE = "android.webkit.plugin.NPP_INSTANCE";
    static final String INTENT_EXTRA_PACKAGE_NAME = "android.webkit.plugin.PACKAGE_NAME";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        String stringExtra = intent.getStringExtra(INTENT_EXTRA_PACKAGE_NAME);
        String stringExtra2 = intent.getStringExtra(INTENT_EXTRA_CLASS_NAME);
        int intExtra = intent.getIntExtra(INTENT_EXTRA_NPP_INSTANCE, -1);
        PluginStub pluginStub = PluginUtil.getPluginStub(this, stringExtra, stringExtra2);
        if (pluginStub != null) {
            View fullScreenView = pluginStub.getFullScreenView(intExtra, this);
            if (fullScreenView != null) {
                setContentView(fullScreenView);
                return;
            } else {
                finish();
                return;
            }
        }
        finish();
    }
}
