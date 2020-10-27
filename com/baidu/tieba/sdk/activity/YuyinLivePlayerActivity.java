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
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.sdk.b.g;
import com.baidu.tieba.sdk.e.d;
import com.baidu.tieba.sdk.util.b;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class YuyinLivePlayerActivity extends MAActivity implements BdPageContextSupport, IScrollable {
    private a mxV;
    private d mxW;
    private boolean mReceiverTag = false;
    com.baidu.live.c.a mxX = new com.baidu.live.c.a() { // from class: com.baidu.tieba.sdk.activity.YuyinLivePlayerActivity.1
        @Override // com.baidu.live.c.a
        public void a(boolean z, boolean z2, long j) {
            YuyinLivePlayerActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        g gVar;
        requestWindowFeature(1);
        if (BdBaseApplication.getInst() != null) {
            gVar = com.baidu.tieba.sdk.d.a.dzU().dAb();
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
        com.baidu.tieba.sdk.a.dzQ().dzS();
        this.mxW = com.baidu.tieba.sdk.a.dzQ().b(this);
        this.mxW.a(this.mxX);
        if (gVar != null) {
            gVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.mxV = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dAs());
            registerReceiver(this.mxV, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mxW.onStart();
        g dAb = com.baidu.tieba.sdk.d.a.dzU().dAb();
        if (dAb != null) {
            dAb.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mxW.onResume();
        g dAb = com.baidu.tieba.sdk.d.a.dzU().dAb();
        if (dAb != null) {
            dAb.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mxW.onPause();
        g dAb = com.baidu.tieba.sdk.d.a.dzU().dAb();
        if (dAb != null) {
            dAb.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mxW.onStop();
        g dAb = com.baidu.tieba.sdk.d.a.dzU().dAb();
        if (dAb != null) {
            dAb.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mxW != null) {
            this.mxW.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mxW.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mxW.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mxW != null) {
            this.mxW.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        g dAb = com.baidu.tieba.sdk.d.a.dzU().dAb();
        if (dAb != null) {
            dAb.g(this);
        }
        super.onDestroy();
        if (this.mxW != null) {
            this.mxW.onDestroy();
        }
        if (dAb != null) {
            dAb.h(this);
        }
        if (this.mxV != null && this.mReceiverTag) {
            unregisterReceiver(this.mxV);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.mxW;
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
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dAs(), intent.getAction()) && TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                this.reference.get().onStop();
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mxW != null) {
            this.mxW.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
