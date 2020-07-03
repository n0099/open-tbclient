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
    private a lnS;
    c lnT = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar = null;
        if (BdBaseApplication.getInst() != null && (dVar = com.baidu.tieba.sdk.d.a.daO().daT()) != null) {
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
        com.baidu.tieba.sdk.a.daK().daM();
        this.lnS = com.baidu.tieba.sdk.a.daK().a(this);
        this.lnS.a(this.lnT);
        if (dVar != null) {
            dVar.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lnS.onStart();
        d daT = com.baidu.tieba.sdk.d.a.daO().daT();
        if (daT != null) {
            daT.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lnS.onResume();
        d daT = com.baidu.tieba.sdk.d.a.daO().daT();
        if (daT != null) {
            daT.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.lnS.onPause();
        d daT = com.baidu.tieba.sdk.d.a.daO().daT();
        if (daT != null) {
            daT.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.lnS.onStop();
        d daT = com.baidu.tieba.sdk.d.a.daO().daT();
        if (daT != null) {
            daT.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.lnS != null) {
            this.lnS.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lnS.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lnS.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lnS != null) {
            this.lnS.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d daT = com.baidu.tieba.sdk.d.a.daO().daT();
        if (daT != null) {
            daT.g(this);
        }
        super.onDestroy();
        if (this.lnS != null) {
            this.lnS.onDestroy();
        }
        if (daT != null) {
            daT.h(this);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.lnS;
    }
}
