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
/* loaded from: classes4.dex */
public class LivePlayerActivity extends MAActivity implements BdPageContextSupport {
    private a lvn;
    c lvo = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar = null;
        if (BdBaseApplication.getInst() != null && (dVar = com.baidu.tieba.sdk.d.a.ddW().deb()) != null) {
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
        com.baidu.tieba.sdk.a.ddS().ddU();
        this.lvn = com.baidu.tieba.sdk.a.ddS().a(this);
        this.lvn.a(this.lvo);
        if (dVar != null) {
            dVar.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lvn.onStart();
        d deb = com.baidu.tieba.sdk.d.a.ddW().deb();
        if (deb != null) {
            deb.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lvn.onResume();
        d deb = com.baidu.tieba.sdk.d.a.ddW().deb();
        if (deb != null) {
            deb.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.lvn.onPause();
        d deb = com.baidu.tieba.sdk.d.a.ddW().deb();
        if (deb != null) {
            deb.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.lvn.onStop();
        d deb = com.baidu.tieba.sdk.d.a.ddW().deb();
        if (deb != null) {
            deb.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.lvn != null) {
            this.lvn.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lvn.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lvn.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lvn != null) {
            this.lvn.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d deb = com.baidu.tieba.sdk.d.a.ddW().deb();
        if (deb != null) {
            deb.g(this);
        }
        super.onDestroy();
        if (this.lvn != null) {
            this.lvn.onDestroy();
        }
        if (deb != null) {
            deb.h(this);
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.lvn;
    }
}
