package com.baidu.tieba.sdk.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.BdPageContextSupport;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.ala.player.c;
import com.baidu.tieba.sdk.a.d;
import com.baidu.tieba.sdk.d.a;
/* loaded from: classes3.dex */
public class LivePlayerActivity extends MAActivity implements BdPageContextSupport {
    private a jPF;
    c jPG = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar = null;
        if (BdBaseApplication.getInst() != null && (dVar = com.baidu.tieba.sdk.c.a.cEk().cEo()) != null) {
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
        com.baidu.tieba.sdk.a.cEg().cEi();
        this.jPF = com.baidu.tieba.sdk.a.cEg().a(this);
        this.jPF.a(this.jPG);
        if (dVar != null) {
            dVar.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.jPF.onStart();
        d cEo = com.baidu.tieba.sdk.c.a.cEk().cEo();
        if (cEo != null) {
            cEo.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jPF.onResume();
        d cEo = com.baidu.tieba.sdk.c.a.cEk().cEo();
        if (cEo != null) {
            cEo.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jPF.onPause();
        d cEo = com.baidu.tieba.sdk.c.a.cEk().cEo();
        if (cEo != null) {
            cEo.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.jPF.onStop();
        d cEo = com.baidu.tieba.sdk.c.a.cEk().cEo();
        if (cEo != null) {
            cEo.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.jPF != null) {
            this.jPF.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.jPF.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jPF.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jPF.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d cEo = com.baidu.tieba.sdk.c.a.cEk().cEo();
        if (cEo != null) {
            cEo.g(this);
        }
        super.onDestroy();
        if (this.jPF != null) {
            this.jPF.onDestroy();
        }
        if (cEo != null) {
            cEo.h(this);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.jPF;
    }
}
