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
import com.baidu.tieba.sdk.b.h;
import com.baidu.tieba.sdk.e.d;
import com.baidu.tieba.sdk.util.b;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class YuyinLivePlayerActivity extends MAActivity implements BdPageContextSupport, IScrollable {
    private a lVN;
    private d lVO;
    private boolean mReceiverTag = false;
    com.baidu.live.c.a lVP = new com.baidu.live.c.a() { // from class: com.baidu.tieba.sdk.activity.YuyinLivePlayerActivity.1
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        h hVar;
        requestWindowFeature(1);
        if (BdBaseApplication.getInst() != null) {
            hVar = com.baidu.tieba.sdk.d.a.dtb().dti();
            if (hVar != null) {
                hVar.a(this);
            }
        } else {
            hVar = null;
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
        this.lVO = com.baidu.tieba.sdk.a.dsX().b(this);
        this.lVO.a(this.lVP);
        if (hVar != null) {
            hVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.lVN = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.dtz());
            registerReceiver(this.lVN, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
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
        this.lVO.onStart();
        h dti = com.baidu.tieba.sdk.d.a.dtb().dti();
        if (dti != null) {
            dti.e(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.lVO.onResume();
        h dti = com.baidu.tieba.sdk.d.a.dtb().dti();
        if (dti != null) {
            dti.c(this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.lVO.onPause();
        h dti = com.baidu.tieba.sdk.d.a.dtb().dti();
        if (dti != null) {
            dti.d(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.lVO.onStop();
        h dti = com.baidu.tieba.sdk.d.a.dtb().dti();
        if (dti != null) {
            dti.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.lVO != null) {
            this.lVO.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.lVO.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lVO.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lVO != null) {
            this.lVO.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        h dti = com.baidu.tieba.sdk.d.a.dtb().dti();
        if (dti != null) {
            dti.g(this);
        }
        super.onDestroy();
        if (this.lVO != null) {
            this.lVO.onDestroy();
        }
        if (dti != null) {
            dti.h(this);
        }
        if (this.lVN != null && this.mReceiverTag) {
            unregisterReceiver(this.lVN);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.lVO;
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
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(b.dtz(), intent.getAction()) && TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                this.reference.get().onStop();
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.lVO != null) {
            this.lVO.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
