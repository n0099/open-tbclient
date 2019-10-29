package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.ala.player.d;
import com.baidu.tieba.sdk.d.a;
/* loaded from: classes6.dex */
public class LivePlayerActivity extends MAActivity {
    private a iRB;
    d iRC = new d() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.d
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.a.d chF = com.baidu.tieba.sdk.c.a.chB().chF();
        if (chF != null) {
            chF.a(this);
        }
        super.onCreate(bundle);
        com.baidu.tieba.sdk.a.chx().chz();
        this.iRB = com.baidu.tieba.sdk.a.chx().a(this);
        this.iRB.a(this.iRC);
        if (chF != null) {
            chF.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.iRB.onStart();
        com.baidu.tieba.sdk.a.d chF = com.baidu.tieba.sdk.c.a.chB().chF();
        if (chF != null) {
            chF.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.iRB.onResume();
        com.baidu.tieba.sdk.a.d chF = com.baidu.tieba.sdk.c.a.chB().chF();
        if (chF != null) {
            chF.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.iRB.onPause();
        com.baidu.tieba.sdk.a.d chF = com.baidu.tieba.sdk.c.a.chB().chF();
        if (chF != null) {
            chF.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.iRB.onStop();
        com.baidu.tieba.sdk.a.d chF = com.baidu.tieba.sdk.c.a.chB().chF();
        if (chF != null) {
            chF.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.iRB != null) {
            this.iRB.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.iRB.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.iRB.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.iRB.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.sdk.a.d chF = com.baidu.tieba.sdk.c.a.chB().chF();
        if (chF != null) {
            chF.g(this);
        }
        super.onDestroy();
        this.iRB.onDestroy();
        if (chF != null) {
            chF.h(this);
        }
    }
}
