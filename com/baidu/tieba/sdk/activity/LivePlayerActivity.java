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
import com.baidu.searchbox.live.base.LiveBaseActivity;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ala.player.c;
import com.baidu.tieba.sdk.util.b;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class LivePlayerActivity extends LiveBaseActivity implements BdPageContextSupport {
    private a mDS;
    private com.baidu.tieba.sdk.e.a mDT;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c mDU = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void a(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.b.c cVar;
        if (BdBaseApplication.getInst() != null) {
            cVar = com.baidu.tieba.sdk.d.a.dCw().dCC();
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
        com.baidu.tieba.sdk.a.dCs().dCu();
        this.mDT = com.baidu.tieba.sdk.a.dCs().a(this);
        this.mDT.a(this.mDU);
        if (cVar != null) {
            cVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.mDS = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dCU());
            registerReceiver(this.mDS, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        oa(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        oa(false);
        super.onNewIntent(intent);
    }

    public void oa(boolean z) {
        if (this.mDT != null) {
            this.mDT.oa(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mDT.onStart();
        com.baidu.tieba.sdk.b.c dCC = com.baidu.tieba.sdk.d.a.dCw().dCC();
        if (dCC != null) {
            dCC.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mDT.onResume();
        com.baidu.tieba.sdk.b.c dCC = com.baidu.tieba.sdk.d.a.dCw().dCC();
        if (dCC != null) {
            dCC.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mDT.onPause();
        com.baidu.tieba.sdk.b.c dCC = com.baidu.tieba.sdk.d.a.dCw().dCC();
        if (dCC != null) {
            dCC.d(this);
        }
    }

    protected void ob(boolean z) {
        this.mDT.ob(z);
        com.baidu.tieba.sdk.b.c dCC = com.baidu.tieba.sdk.d.a.dCw().dCC();
        if (dCC != null) {
            dCC.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ob(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mDT != null) {
            this.mDT.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mDT.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mDT.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mDT != null) {
            this.mDT.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.sdk.b.c dCC = com.baidu.tieba.sdk.d.a.dCw().dCC();
        if (dCC != null) {
            dCC.g(this);
        }
        super.onDestroy();
        if (this.mDT != null) {
            this.mDT.onDestroy();
        }
        if (dCC != null) {
            dCC.h(this);
        }
        if (this.mDS != null && this.mReceiverTag) {
            unregisterReceiver(this.mDS);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.mDT;
    }

    /* loaded from: classes4.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dCU(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().oa(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().oa(true);
                    this.reference.get().ob(true);
                }
            }
        }
    }
}
