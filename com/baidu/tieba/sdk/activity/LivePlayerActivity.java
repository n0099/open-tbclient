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
import com.baidu.tieba.sdk.b.d;
import com.baidu.tieba.sdk.e.a;
/* loaded from: classes3.dex */
public class LivePlayerActivity extends MAActivity implements BdPageContextSupport {
    private a kSQ;
    c kSR = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar = null;
        if (BdBaseApplication.getInst() != null && (dVar = com.baidu.tieba.sdk.d.a.cWj().cWo()) != null) {
            dVar.a(this);
        }
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null && TbConfig.sdkInitCallback != null) {
            TbConfig.sdkInitCallback.initSdk();
        }
        if (BdBaseApplication.getInst() == null) {
            super.onCreate(bundle);
            super.finish();
            return;
        }
        com.baidu.tieba.sdk.a.cWf().cWh();
        this.kSQ = com.baidu.tieba.sdk.a.cWf().a(this);
        this.kSQ.a(this.kSR);
        if (dVar != null) {
            dVar.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.kSQ.onStart();
        d cWo = com.baidu.tieba.sdk.d.a.cWj().cWo();
        if (cWo != null) {
            cWo.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.kSQ.onResume();
        d cWo = com.baidu.tieba.sdk.d.a.cWj().cWo();
        if (cWo != null) {
            cWo.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.kSQ.onPause();
        d cWo = com.baidu.tieba.sdk.d.a.cWj().cWo();
        if (cWo != null) {
            cWo.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.kSQ.onStop();
        d cWo = com.baidu.tieba.sdk.d.a.cWj().cWo();
        if (cWo != null) {
            cWo.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.kSQ != null) {
            this.kSQ.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.kSQ.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.kSQ.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.kSQ != null) {
            this.kSQ.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d cWo = com.baidu.tieba.sdk.d.a.cWj().cWo();
        if (cWo != null) {
            cWo.g(this);
        }
        super.onDestroy();
        if (this.kSQ != null) {
            this.kSQ.onDestroy();
        }
        if (cWo != null) {
            cWo.h(this);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.kSQ;
    }
}
