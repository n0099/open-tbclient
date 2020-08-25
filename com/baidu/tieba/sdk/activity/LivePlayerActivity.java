package com.baidu.tieba.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.BdPageContextSupport;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.player.c;
import com.baidu.tieba.sdk.b.d;
import com.baidu.tieba.sdk.util.b;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class LivePlayerActivity extends MAActivity implements BdPageContextSupport {
    private a lMC;
    private com.baidu.tieba.sdk.e.a lMD;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c lME = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar;
        if (BdBaseApplication.getInst() != null) {
            dVar = com.baidu.tieba.sdk.d.a.dpo().dpt();
            if (dVar != null) {
                dVar.a(this);
            }
        } else {
            dVar = null;
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
        com.baidu.tieba.sdk.a.dpk().dpm();
        this.lMD = com.baidu.tieba.sdk.a.dpk().a(this);
        this.lMD.a(this.lME);
        if (dVar != null) {
            dVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.lMC = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dpJ());
            registerReceiver(this.lMC, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        mR(false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        mR(false);
        super.onNewIntent(intent);
    }

    public void mR(boolean z) {
        if (this.lMD != null) {
            this.lMD.mR(z);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lMD.onStart();
        d dpt = com.baidu.tieba.sdk.d.a.dpo().dpt();
        if (dpt != null) {
            dpt.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lMD.onResume();
        d dpt = com.baidu.tieba.sdk.d.a.dpo().dpt();
        if (dpt != null) {
            dpt.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.lMD.onPause();
        d dpt = com.baidu.tieba.sdk.d.a.dpo().dpt();
        if (dpt != null) {
            dpt.d(this);
        }
    }

    protected void mS(boolean z) {
        this.lMD.mS(z);
        d dpt = com.baidu.tieba.sdk.d.a.dpo().dpt();
        if (dpt != null) {
            dpt.f(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        mS(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.lMD != null) {
            this.lMD.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lMD.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lMD.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lMD != null) {
            this.lMD.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d dpt = com.baidu.tieba.sdk.d.a.dpo().dpt();
        if (dpt != null) {
            dpt.g(this);
        }
        super.onDestroy();
        if (this.lMD != null) {
            this.lMD.onDestroy();
        }
        if (dpt != null) {
            dpt.h(this);
        }
        if (this.lMC != null && this.mReceiverTag) {
            unregisterReceiver(this.lMC);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.lMD;
    }

    /* loaded from: classes7.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dpJ(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().mR(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().mR(true);
                    this.reference.get().mS(true);
                }
            }
        }
    }
}
