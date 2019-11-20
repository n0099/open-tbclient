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
    private a iQK;
    d iQL = new d() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.d
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.a.d chD = com.baidu.tieba.sdk.c.a.chz().chD();
        if (chD != null) {
            chD.a(this);
        }
        super.onCreate(bundle);
        com.baidu.tieba.sdk.a.chv().chx();
        this.iQK = com.baidu.tieba.sdk.a.chv().a(this);
        this.iQK.a(this.iQL);
        if (chD != null) {
            chD.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.iQK.onStart();
        com.baidu.tieba.sdk.a.d chD = com.baidu.tieba.sdk.c.a.chz().chD();
        if (chD != null) {
            chD.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.iQK.onResume();
        com.baidu.tieba.sdk.a.d chD = com.baidu.tieba.sdk.c.a.chz().chD();
        if (chD != null) {
            chD.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.iQK.onPause();
        com.baidu.tieba.sdk.a.d chD = com.baidu.tieba.sdk.c.a.chz().chD();
        if (chD != null) {
            chD.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.iQK.onStop();
        com.baidu.tieba.sdk.a.d chD = com.baidu.tieba.sdk.c.a.chz().chD();
        if (chD != null) {
            chD.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.iQK != null) {
            this.iQK.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.iQK.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.iQK.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.iQK.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.sdk.a.d chD = com.baidu.tieba.sdk.c.a.chz().chD();
        if (chD != null) {
            chD.g(this);
        }
        super.onDestroy();
        this.iQK.onDestroy();
        if (chD != null) {
            chD.h(this);
        }
    }
}
