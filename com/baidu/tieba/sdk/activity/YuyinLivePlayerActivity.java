package com.baidu.tieba.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.BdPageContextSupport;
import com.baidu.live.adp.base.IScrollable;
import com.baidu.live.adp.widget.listview.IPreLoadListView;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.searchbox.live.base.LiveBaseActivity;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.sdk.b.g;
import com.baidu.tieba.sdk.e.d;
import com.baidu.tieba.sdk.util.b;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class YuyinLivePlayerActivity extends LiveBaseActivity implements BdPageContextSupport, IScrollable {
    private a mSt;
    private d mSu;
    private boolean mReceiverTag = false;
    com.baidu.live.e.a mSv = new com.baidu.live.e.a() { // from class: com.baidu.tieba.sdk.activity.YuyinLivePlayerActivity.1
        @Override // com.baidu.live.e.a
        public void a(boolean z, boolean z2, long j) {
            YuyinLivePlayerActivity.this.finish();
        }
    };

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        g gVar;
        requestWindowFeature(1);
        if (BdBaseApplication.getInst() != null) {
            gVar = com.baidu.tieba.sdk.d.a.dHl().dHs();
            if (gVar != null) {
                gVar.a(this);
            }
        } else {
            gVar = null;
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
        com.baidu.tieba.sdk.a.dHh().dHj();
        this.mSu = com.baidu.tieba.sdk.a.dHh().b(this);
        this.mSu.a(this.mSv);
        if (gVar != null) {
            gVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.mSt = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dHJ());
            registerReceiver(this.mSt, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mSu.onStart();
        g dHs = com.baidu.tieba.sdk.d.a.dHl().dHs();
        if (dHs != null) {
            dHs.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mSu.onResume();
        g dHs = com.baidu.tieba.sdk.d.a.dHl().dHs();
        if (dHs != null) {
            dHs.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mSu.onPause();
        g dHs = com.baidu.tieba.sdk.d.a.dHl().dHs();
        if (dHs != null) {
            dHs.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mSu.onStop();
        g dHs = com.baidu.tieba.sdk.d.a.dHl().dHs();
        if (dHs != null) {
            dHs.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mSu != null) {
            this.mSu.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mSu.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mSu.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mSu != null) {
            this.mSu.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g dHs = com.baidu.tieba.sdk.d.a.dHl().dHs();
        if (dHs != null) {
            dHs.g(this);
        }
        super.onDestroy();
        if (this.mSu != null) {
            this.mSu.onDestroy();
        }
        if (dHs != null) {
            dHs.h(this);
        }
        if (this.mSt != null && this.mReceiverTag) {
            unregisterReceiver(this.mSt);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.mSu;
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public BdUniqueId getUniqueId() {
        return null;
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public boolean isScroll() {
        return false;
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public void setIsScroll(boolean z) {
    }

    @Override // com.baidu.live.adp.base.IScrollable
    public void onPreLoad(IPreLoadListView iPreLoadListView) {
    }

    /* loaded from: classes4.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<YuyinLivePlayerActivity> reference;

        public a(YuyinLivePlayerActivity yuyinLivePlayerActivity) {
            this.reference = new WeakReference<>(yuyinLivePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dHJ(), intent.getAction()) && TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                this.reference.get().onStop();
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mSu != null) {
            this.mSu.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
