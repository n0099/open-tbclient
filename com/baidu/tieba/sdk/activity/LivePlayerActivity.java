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
    private a lMP;
    private com.baidu.tieba.sdk.e.a lMQ;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c lMR = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar;
        if (BdBaseApplication.getInst() != null) {
            dVar = com.baidu.tieba.sdk.d.a.dpr().dpw();
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
        com.baidu.tieba.sdk.a.dpn().dpp();
        this.lMQ = com.baidu.tieba.sdk.a.dpn().a(this);
        this.lMQ.a(this.lMR);
        if (dVar != null) {
            dVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.lMP = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dpM());
            registerReceiver(this.lMP, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        mT(false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        mT(false);
        super.onNewIntent(intent);
    }

    public void mT(boolean z) {
        if (this.lMQ != null) {
            this.lMQ.mT(z);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lMQ.onStart();
        d dpw = com.baidu.tieba.sdk.d.a.dpr().dpw();
        if (dpw != null) {
            dpw.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lMQ.onResume();
        d dpw = com.baidu.tieba.sdk.d.a.dpr().dpw();
        if (dpw != null) {
            dpw.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.lMQ.onPause();
        d dpw = com.baidu.tieba.sdk.d.a.dpr().dpw();
        if (dpw != null) {
            dpw.d(this);
        }
    }

    protected void mU(boolean z) {
        this.lMQ.mU(z);
        d dpw = com.baidu.tieba.sdk.d.a.dpr().dpw();
        if (dpw != null) {
            dpw.f(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        mU(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.lMQ != null) {
            this.lMQ.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lMQ.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lMQ.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lMQ != null) {
            this.lMQ.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d dpw = com.baidu.tieba.sdk.d.a.dpr().dpw();
        if (dpw != null) {
            dpw.g(this);
        }
        super.onDestroy();
        if (this.lMQ != null) {
            this.lMQ.onDestroy();
        }
        if (dpw != null) {
            dpw.h(this);
        }
        if (this.lMP != null && this.mReceiverTag) {
            unregisterReceiver(this.lMP);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.lMQ;
    }

    /* loaded from: classes7.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dpM(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().mT(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().mT(true);
                    this.reference.get().mU(true);
                }
            }
        }
    }
}
