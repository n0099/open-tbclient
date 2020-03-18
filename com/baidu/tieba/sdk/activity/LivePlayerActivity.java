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
    private a jRv;
    c jRw = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar = null;
        if (BdBaseApplication.getInst() != null && (dVar = com.baidu.tieba.sdk.c.a.cEH().cEL()) != null) {
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
        com.baidu.tieba.sdk.a.cED().cEF();
        this.jRv = com.baidu.tieba.sdk.a.cED().a(this);
        this.jRv.a(this.jRw);
        if (dVar != null) {
            dVar.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.jRv.onStart();
        d cEL = com.baidu.tieba.sdk.c.a.cEH().cEL();
        if (cEL != null) {
            cEL.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.jRv.onResume();
        d cEL = com.baidu.tieba.sdk.c.a.cEH().cEL();
        if (cEL != null) {
            cEL.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.jRv.onPause();
        d cEL = com.baidu.tieba.sdk.c.a.cEH().cEL();
        if (cEL != null) {
            cEL.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.jRv.onStop();
        d cEL = com.baidu.tieba.sdk.c.a.cEH().cEL();
        if (cEL != null) {
            cEL.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.jRv != null) {
            this.jRv.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.jRv.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jRv.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.jRv.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d cEL = com.baidu.tieba.sdk.c.a.cEH().cEL();
        if (cEL != null) {
            cEL.g(this);
        }
        super.onDestroy();
        if (this.jRv != null) {
            this.jRv.onDestroy();
        }
        if (cEL != null) {
            cEL.h(this);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.jRv;
    }
}
