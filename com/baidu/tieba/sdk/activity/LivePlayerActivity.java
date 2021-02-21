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
/* loaded from: classes11.dex */
public class LivePlayerActivity extends LiveBaseActivity implements BdPageContextSupport {
    private a nda;
    private com.baidu.tieba.sdk.e.a ndb;
    private boolean mReceiverTag = false;
    private boolean mIsFromH5 = false;
    c ndc = new c() { // from class: com.baidu.tieba.sdk.activity.LivePlayerActivity.1
        @Override // com.baidu.tieba.ala.player.c
        public void a(boolean z, boolean z2, long j) {
            LivePlayerActivity.this.finish();
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.baidu.tieba.sdk.b.c cVar;
        if (BdBaseApplication.getInst() != null) {
            cVar = com.baidu.tieba.sdk.d.a.dFB().dFI();
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
        com.baidu.tieba.sdk.a.dFx().dFz();
        this.ndb = com.baidu.tieba.sdk.a.dFx().a(this);
        this.ndb.a(this.ndc);
        if (cVar != null) {
            cVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.nda = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dGa());
            registerReceiver(this.nda, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
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
        if (this.ndb != null) {
            this.ndb.pb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ndb.onStart();
        com.baidu.tieba.sdk.b.c dFI = com.baidu.tieba.sdk.d.a.dFB().dFI();
        if (dFI != null) {
            dFI.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ndb.onResume();
        com.baidu.tieba.sdk.b.c dFI = com.baidu.tieba.sdk.d.a.dFB().dFI();
        if (dFI != null) {
            dFI.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ndb.onPause();
        com.baidu.tieba.sdk.b.c dFI = com.baidu.tieba.sdk.d.a.dFB().dFI();
        if (dFI != null) {
            dFI.d(this);
        }
    }

    protected void pc(boolean z) {
        this.ndb.pc(z);
        com.baidu.tieba.sdk.b.c dFI = com.baidu.tieba.sdk.d.a.dFB().dFI();
        if (dFI != null) {
            dFI.f(this);
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
        if (this.ndb != null) {
            this.ndb.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ndb.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ndb.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ndb != null) {
            this.ndb.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.sdk.b.c dFI = com.baidu.tieba.sdk.d.a.dFB().dFI();
        if (dFI != null) {
            dFI.g(this);
        }
        super.onDestroy();
        if (this.ndb != null) {
            this.ndb.onDestroy();
        }
        if (dFI != null) {
            dFI.h(this);
        }
        if (this.nda != null && this.mReceiverTag) {
            unregisterReceiver(this.nda);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.ndb;
    }

    /* loaded from: classes11.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<LivePlayerActivity> reference;

        public a(LivePlayerActivity livePlayerActivity) {
            this.reference = new WeakReference<>(livePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dGa(), intent.getAction())) {
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
