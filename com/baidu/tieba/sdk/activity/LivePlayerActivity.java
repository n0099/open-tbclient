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
/* loaded from: classes10.dex */
public class LivePlayerActivity extends LiveBaseActivity implements BdPageContextSupport {
    private a nff;
    private com.baidu.tieba.sdk.e.a nfg;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c nfh = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void a(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.b.c cVar;
        if (BdBaseApplication.getInst() != null) {
            cVar = com.baidu.tieba.sdk.d.a.dFJ().dFQ();
            if (cVar != null) {
                cVar.a(this);
            }
        } else {
            cVar = null;
        }
        if (BdBaseApplication.getInst() == null) {
            super.onCreate(bundle);
            super.finish();
            return;
        }
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null && TbConfig.sdkInitCallback != null) {
            TbConfig.sdkInitCallback.initSdk();
        }
        com.baidu.tieba.sdk.a.dFF().dFH();
        this.nfg = com.baidu.tieba.sdk.a.dFF().a(this);
        this.nfg.a(this.nfh);
        if (cVar != null) {
            cVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.nff = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dGi());
            registerReceiver(this.nff, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
        pb(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        pb(false);
        super.onNewIntent(intent);
    }

    public void pb(boolean z) {
        if (this.nfg != null) {
            this.nfg.pb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.nfg.onStart();
        com.baidu.tieba.sdk.b.c dFQ = com.baidu.tieba.sdk.d.a.dFJ().dFQ();
        if (dFQ != null) {
            dFQ.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.nfg.onResume();
        com.baidu.tieba.sdk.b.c dFQ = com.baidu.tieba.sdk.d.a.dFJ().dFQ();
        if (dFQ != null) {
            dFQ.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nfg.onPause();
        com.baidu.tieba.sdk.b.c dFQ = com.baidu.tieba.sdk.d.a.dFJ().dFQ();
        if (dFQ != null) {
            dFQ.d(this);
        }
    }

    protected void pc(boolean z) {
        this.nfg.pc(z);
        com.baidu.tieba.sdk.b.c dFQ = com.baidu.tieba.sdk.d.a.dFJ().dFQ();
        if (dFQ != null) {
            dFQ.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        pc(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.nfg != null) {
            this.nfg.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.nfg.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.nfg.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.nfg != null) {
            this.nfg.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.sdk.b.c dFQ = com.baidu.tieba.sdk.d.a.dFJ().dFQ();
        if (dFQ != null) {
            dFQ.g(this);
        }
        super.onDestroy();
        if (this.nfg != null) {
            this.nfg.onDestroy();
        }
        if (dFQ != null) {
            dFQ.h(this);
        }
        if (this.nff != null && this.mReceiverTag) {
            unregisterReceiver(this.nff);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.nfg;
    }

    /* loaded from: classes10.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dGi(), intent.getAction())) {
                if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_STOP)) {
                    this.reference.get().pb(false);
                    this.reference.get().onStart();
                } else if (TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                    this.reference.get().pb(true);
                    this.reference.get().pc(true);
                }
            }
        }
    }
}
