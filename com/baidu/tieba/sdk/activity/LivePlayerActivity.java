package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.ala.player.d;
import com.baidu.tieba.sdk.d.a;
/* loaded from: classes2.dex */
public class LivePlayerActivity extends MAActivity {
    private a jLd;
    d jLe = new d() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.d
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (BdBaseApplication.getInst() == null) {
            super.finish();
            return;
        }
        com.baidu.tieba.sdk.a.d cBG = com.baidu.tieba.sdk.c.a.cBC().cBG();
        if (cBG != null) {
            cBG.a(this);
        }
        super.onCreate(bundle);
        com.baidu.tieba.sdk.a.cBx().cBz();
        this.jLd = com.baidu.tieba.sdk.a.cBx().a(this);
        this.jLd.a(this.jLe);
        if (cBG != null) {
            cBG.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.jLd.onStart();
        com.baidu.tieba.sdk.a.d cBG = com.baidu.tieba.sdk.c.a.cBC().cBG();
        if (cBG != null) {
            cBG.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jLd.onResume();
        com.baidu.tieba.sdk.a.d cBG = com.baidu.tieba.sdk.c.a.cBC().cBG();
        if (cBG != null) {
            cBG.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jLd.onPause();
        com.baidu.tieba.sdk.a.d cBG = com.baidu.tieba.sdk.c.a.cBC().cBG();
        if (cBG != null) {
            cBG.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.jLd.onStop();
        com.baidu.tieba.sdk.a.d cBG = com.baidu.tieba.sdk.c.a.cBC().cBG();
        if (cBG != null) {
            cBG.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.jLd != null) {
            this.jLd.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.jLd.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jLd.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jLd.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.sdk.a.d cBG = com.baidu.tieba.sdk.c.a.cBC().cBG();
        if (cBG != null) {
            cBG.g(this);
        }
        super.onDestroy();
        this.jLd.onDestroy();
        if (cBG != null) {
            cBG.h(this);
        }
    }
}
