package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.ala.player.d;
import com.baidu.tieba.sdk.d.a;
/* loaded from: classes2.dex */
public class LivePlayerActivity extends MAActivity {
    private a jOJ;
    d jOK = new d() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.d
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.a.d dVar = null;
        if (BdBaseApplication.getInst() != null && (dVar = com.baidu.tieba.sdk.c.a.cCJ().cCN()) != null) {
            dVar.a(this);
        }
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        com.baidu.tieba.sdk.a.cCF().cCH();
        this.jOJ = com.baidu.tieba.sdk.a.cCF().a(this);
        this.jOJ.a(this.jOK);
        if (dVar != null) {
            dVar.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.jOJ.onStart();
        com.baidu.tieba.sdk.a.d cCN = com.baidu.tieba.sdk.c.a.cCJ().cCN();
        if (cCN != null) {
            cCN.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jOJ.onResume();
        com.baidu.tieba.sdk.a.d cCN = com.baidu.tieba.sdk.c.a.cCJ().cCN();
        if (cCN != null) {
            cCN.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jOJ.onPause();
        com.baidu.tieba.sdk.a.d cCN = com.baidu.tieba.sdk.c.a.cCJ().cCN();
        if (cCN != null) {
            cCN.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.jOJ.onStop();
        com.baidu.tieba.sdk.a.d cCN = com.baidu.tieba.sdk.c.a.cCJ().cCN();
        if (cCN != null) {
            cCN.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.jOJ != null) {
            this.jOJ.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.jOJ.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jOJ.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jOJ.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.sdk.a.d cCN = com.baidu.tieba.sdk.c.a.cCJ().cCN();
        if (cCN != null) {
            cCN.g(this);
        }
        super.onDestroy();
        if (this.jOJ != null) {
            this.jOJ.onDestroy();
        }
        if (cCN != null) {
            cCN.h(this);
        }
    }
}
