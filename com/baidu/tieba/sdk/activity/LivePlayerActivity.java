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
import com.baidu.tieba.sdk.util.b;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class LivePlayerActivity extends MAActivity implements BdPageContextSupport {
    private a mxR;
    private com.baidu.tieba.sdk.e.a mxS;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c mxT = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void a(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.b.c cVar;
        if (BdBaseApplication.getInst() != null) {
            cVar = com.baidu.tieba.sdk.d.a.dzU().dAa();
            if (cVar != null) {
                cVar.a(this);
            }
        } else {
            cVar = null;
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
        com.baidu.tieba.sdk.a.dzQ().dzS();
        this.mxS = com.baidu.tieba.sdk.a.dzQ().a(this);
        this.mxS.a(this.mxT);
        if (cVar != null) {
            cVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.mxR = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dAs());
            registerReceiver(this.mxR, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        nR(false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        nR(false);
        super.onNewIntent(intent);
    }

    public void nR(boolean z) {
        if (this.mxS != null) {
            this.mxS.nR(z);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mxS.onStart();
        com.baidu.tieba.sdk.b.c dAa = com.baidu.tieba.sdk.d.a.dzU().dAa();
        if (dAa != null) {
            dAa.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mxS.onResume();
        com.baidu.tieba.sdk.b.c dAa = com.baidu.tieba.sdk.d.a.dzU().dAa();
        if (dAa != null) {
            dAa.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mxS.onPause();
        com.baidu.tieba.sdk.b.c dAa = com.baidu.tieba.sdk.d.a.dzU().dAa();
        if (dAa != null) {
            dAa.d(this);
        }
    }

    protected void nS(boolean z) {
        this.mxS.nS(z);
        com.baidu.tieba.sdk.b.c dAa = com.baidu.tieba.sdk.d.a.dzU().dAa();
        if (dAa != null) {
            dAa.f(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        nS(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mxS != null) {
            this.mxS.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mxS.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mxS.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mxS != null) {
            this.mxS.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.sdk.b.c dAa = com.baidu.tieba.sdk.d.a.dzU().dAa();
        if (dAa != null) {
            dAa.g(this);
        }
        super.onDestroy();
        if (this.mxS != null) {
            this.mxS.onDestroy();
        }
        if (dAa != null) {
            dAa.h(this);
        }
        if (this.mxR != null && this.mReceiverTag) {
            unregisterReceiver(this.mxR);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.mxS;
    }

    /* loaded from: classes4.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dAs(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().nR(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().nR(true);
                    this.reference.get().nS(true);
                }
            }
        }
    }
}
