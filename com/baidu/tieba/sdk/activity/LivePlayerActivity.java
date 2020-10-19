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
    private a mlq;
    private com.baidu.tieba.sdk.e.a mlr;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c mls = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void b(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.b.c cVar;
        if (BdBaseApplication.getInst() != null) {
            cVar = com.baidu.tieba.sdk.d.a.dwM().dwS();
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
        com.baidu.tieba.sdk.a.dwI().dwK();
        this.mlr = com.baidu.tieba.sdk.a.dwI().a(this);
        this.mlr.a(this.mls);
        if (cVar != null) {
            cVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.mlq = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dxk());
            registerReceiver(this.mlq, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        nA(false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        nA(false);
        super.onNewIntent(intent);
    }

    public void nA(boolean z) {
        if (this.mlr != null) {
            this.mlr.nA(z);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mlr.onStart();
        com.baidu.tieba.sdk.b.c dwS = com.baidu.tieba.sdk.d.a.dwM().dwS();
        if (dwS != null) {
            dwS.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mlr.onResume();
        com.baidu.tieba.sdk.b.c dwS = com.baidu.tieba.sdk.d.a.dwM().dwS();
        if (dwS != null) {
            dwS.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mlr.onPause();
        com.baidu.tieba.sdk.b.c dwS = com.baidu.tieba.sdk.d.a.dwM().dwS();
        if (dwS != null) {
            dwS.d(this);
        }
    }

    protected void nB(boolean z) {
        this.mlr.nB(z);
        com.baidu.tieba.sdk.b.c dwS = com.baidu.tieba.sdk.d.a.dwM().dwS();
        if (dwS != null) {
            dwS.f(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        nB(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mlr != null) {
            this.mlr.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mlr.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mlr.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mlr != null) {
            this.mlr.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.baidu.tieba.sdk.b.c dwS = com.baidu.tieba.sdk.d.a.dwM().dwS();
        if (dwS != null) {
            dwS.g(this);
        }
        super.onDestroy();
        if (this.mlr != null) {
            this.mlr.onDestroy();
        }
        if (dwS != null) {
            dwS.h(this);
        }
        if (this.mlq != null && this.mReceiverTag) {
            unregisterReceiver(this.mlq);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.mlr;
    }

    /* loaded from: classes4.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dxk(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().nA(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().nA(true);
                    this.reference.get().nB(true);
                }
            }
        }
    }
}
