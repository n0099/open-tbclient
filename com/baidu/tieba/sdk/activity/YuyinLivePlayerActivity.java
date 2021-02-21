package com.baidu.tieba.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.base.BdPageContextSupport;
import com.baidu.live.adp.base.IScrollable;
import com.baidu.live.adp.widget.listview.IPreLoadListView;
import com.baidu.live.audiolive.b;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.searchbox.live.base.LiveBaseActivity;
import com.baidu.tbadk.browser.WebViewBroadcastReceiver;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.sdk.b.g;
import com.baidu.tieba.sdk.e.d;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class YuyinLivePlayerActivity extends LiveBaseActivity implements BdPageContextSupport, IScrollable {
    private a nde;
    private d ndf;
    private boolean mReceiverTag = false;
    b ndg = new b() { // from class: com.baidu.tieba.sdk.activity.YuyinLivePlayerActivity.1
        @Override // com.baidu.live.audiolive.b
        public void a(boolean z, boolean z2, long j) {
            YuyinLivePlayerActivity.this.finish();
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        g gVar;
        requestWindowFeature(1);
        if (BdBaseApplication.getInst() != null) {
            gVar = com.baidu.tieba.sdk.d.a.dFB().dFJ();
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
            super.finish();
            return;
        }
        com.baidu.tieba.sdk.a.dFx().dFz();
        this.ndf = com.baidu.tieba.sdk.a.dFx().b(this);
        this.ndf.a(this.ndg);
        if (gVar != null) {
            gVar.b(this);
        }
        if (!this.mReceiverTag) {
            this.nde = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(com.baidu.tieba.sdk.util.b.dGa());
            registerReceiver(this.nde, intentFilter, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW, null);
            this.mReceiverTag = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.ndf.onStart();
        g dFJ = com.baidu.tieba.sdk.d.a.dFB().dFJ();
        if (dFJ != null) {
            dFJ.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ndf.onResume();
        g dFJ = com.baidu.tieba.sdk.d.a.dFB().dFJ();
        if (dFJ != null) {
            dFJ.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ndf.onPause();
        g dFJ = com.baidu.tieba.sdk.d.a.dFB().dFJ();
        if (dFJ != null) {
            dFJ.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.ndf.onStop();
        g dFJ = com.baidu.tieba.sdk.d.a.dFB().dFJ();
        if (dFJ != null) {
            dFJ.f(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.ndf != null) {
            this.ndf.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ndf.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.ndf.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ndf != null) {
            this.ndf.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g dFJ = com.baidu.tieba.sdk.d.a.dFB().dFJ();
        if (dFJ != null) {
            dFJ.g(this);
        }
        super.onDestroy();
        if (this.ndf != null) {
            this.ndf.onDestroy();
        }
        if (dFJ != null) {
            dFJ.h(this);
        }
        if (this.nde != null && this.mReceiverTag) {
            unregisterReceiver(this.nde);
            this.mReceiverTag = false;
        }
    }

    @Override // com.baidu.live.adp.base.BdPageContextSupport, com.baidu.live.tbadk.TbPageContextSupport
    public BdPageContext getPageContext() {
        return this.ndf;
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

    /* loaded from: classes11.dex */
    private static class a extends BroadcastReceiver {
        WeakReference<YuyinLivePlayerActivity> reference;

        public a(YuyinLivePlayerActivity yuyinLivePlayerActivity) {
            this.reference = new WeakReference<>(yuyinLivePlayerActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals(com.baidu.tieba.sdk.util.b.dGa(), intent.getAction()) && TextUtils.equals(intent.getStringExtra("DetailLifecycle"), MissionEvent.MESSAGE_START)) {
                this.reference.get().onStop();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.ndf != null) {
            this.ndf.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
