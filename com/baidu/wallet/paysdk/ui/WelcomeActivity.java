package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.presenter.g;
import com.baidu.wallet.paysdk.presenter.k;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.statistics.api.StatisticManager;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes5.dex */
public class WelcomeActivity extends PayBaseBeanActivity {

    /* renamed from: a  reason: collision with root package name */
    public k f26024a;

    private void a() {
        setContentView(ResUtils.layout(getActivity(), "wallet_base_layout_loading"));
        AnimationDrawable animationDrawable = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setImmersiveActivityMargeinTop();
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        k kVar = this.f26024a;
        if (kVar != null) {
            kVar.a(i2, i3, str, obj);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 0);
        if (4 == intExtra) {
            BindCardEntry.setLoadingUi(this);
            BindCardEntry.innerRun();
        } else {
            k a2 = g.a(intExtra, this);
            this.f26024a = a2;
            if (a2 != null) {
                a2.a();
                if (!this.f26024a.a(bundle)) {
                    return;
                }
            }
        }
        a();
        PassUtil.onCreate();
        if (this.f26024a != null) {
            if (intExtra == 3) {
                this.f26024a.a(intent.getStringExtra("orderExtraInfo"));
            }
            PrecashierCreateOrderResponse precashierCreateOrderResponse = (PrecashierCreateOrderResponse) intent.getSerializableExtra(BaiduPay.PRECASHIER_PAY_RESPONSE);
            if (precashierCreateOrderResponse != null) {
                this.f26024a.a(precashierCreateOrderResponse);
            } else {
                this.f26024a.b();
            }
            this.f26024a.g();
        }
        if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_WELCOME_ACTIVITY, MissionEvent.MESSAGE_CREATE);
        } else {
            StatisticManager.onEvent(StatServiceEvent.ENTER_WELCOME_ACTIVITY, MissionEvent.MESSAGE_CREATE);
        }
        if (ImmersiveOSUtils.isSupportStatusBarDarkFont()) {
            ImmersiveStatusBarManager.setMiuiFlymeBarDark(this.mAct.getActivity(), true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k kVar = this.f26024a;
        if (kVar != null) {
            kVar.d();
            this.f26024a = null;
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !event.mEventKey.equals("ev_bean_execut_err_content")) {
            return;
        }
        Object obj = event.mEventObj;
        if (obj instanceof BeanErrorContent) {
            BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
            onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
            EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k kVar = this.f26024a;
        if (kVar != null) {
            kVar.b();
        }
        if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_WELCOME_ACTIVITY, "onNewIntent");
        } else {
            StatisticManager.onEvent(StatServiceEvent.ENTER_WELCOME_ACTIVITY, "onNewIntent");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        k kVar = this.f26024a;
        if (kVar != null) {
            kVar.a(i2, dialog);
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    public void setImmersiveActivityMargeinTop() {
        BeanActivity beanActivity;
        if (Build.VERSION.SDK_INT >= 19 && (beanActivity = this.mAct) != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(ResUtils.id(beanActivity, "welcome_page"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, StatusBarUtils.getStatusBarHeight(this.mAct), 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }
}
