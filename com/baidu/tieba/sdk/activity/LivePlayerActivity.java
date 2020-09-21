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
/* loaded from: classes4.dex */
public class LivePlayerActivity extends MAActivity implements BdPageContextSupport {
    private a lVJ;
    private com.baidu.tieba.sdk.e.a lVK;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c lVL = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar;
        if (BdBaseApplication.getInst() != null) {
            dVar = com.baidu.tieba.sdk.d.a.dtb().dth();
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
        com.baidu.tieba.sdk.a.dsX().dsZ();
        this.lVK = com.baidu.tieba.sdk.a.dsX().a(this);
        this.lVK.a(this.lVL);
        if (dVar != null) {
            dVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.lVJ = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dtz());
            registerReceiver(this.lVJ, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        mX(false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        mX(false);
        super.onNewIntent(intent);
    }

    public void mX(boolean z) {
        if (this.lVK != null) {
            this.lVK.mX(z);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.lVK.onStart();
        d dth = com.baidu.tieba.sdk.d.a.dtb().dth();
        if (dth != null) {
            dth.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lVK.onResume();
        d dth = com.baidu.tieba.sdk.d.a.dtb().dth();
        if (dth != null) {
            dth.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.lVK.onPause();
        d dth = com.baidu.tieba.sdk.d.a.dtb().dth();
        if (dth != null) {
            dth.d(this);
        }
    }

    protected void mY(boolean z) {
        this.lVK.mY(z);
        d dth = com.baidu.tieba.sdk.d.a.dtb().dth();
        if (dth != null) {
            dth.f(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        mY(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.lVK != null) {
            this.lVK.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lVK.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lVK.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lVK != null) {
            this.lVK.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d dth = com.baidu.tieba.sdk.d.a.dtb().dth();
        if (dth != null) {
            dth.g(this);
        }
        super.onDestroy();
        if (this.lVK != null) {
            this.lVK.onDestroy();
        }
        if (dth != null) {
            dth.h(this);
        }
        if (this.lVJ != null && this.mReceiverTag) {
            unregisterReceiver(this.lVJ);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.lVK;
    }

    /* loaded from: classes4.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dtz(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().mX(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().mX(true);
                    this.reference.get().mY(true);
                }
            }
        }
    }
}
