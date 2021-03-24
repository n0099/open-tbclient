package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
/* loaded from: classes5.dex */
public class RemotePaySplashActivity extends PayBaseBeanActivity {

    /* renamed from: a  reason: collision with root package name */
    public int f26793a;

    /* renamed from: b  reason: collision with root package name */
    public PrecashierCreateOrderResponse f26794b;

    public void getInstentDatas() {
        Intent intent = getIntent();
        if (intent == null) {
            StatisticManager.onEvent(StatServiceEvent.REMOTE_SPLASH_ACTIVITY_EX_FINISH);
            PayCallBackManager.callBackClientCancel(this.mAct, "RemotePaySplashActivity.getIntent() is null");
            finish();
            return;
        }
        this.f26793a = intent.getIntExtra("fromType", 0);
        this.f26794b = (PrecashierCreateOrderResponse) intent.getSerializableExtra(BaiduPay.PRECASHIER_PAY_RESPONSE);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    public void initView() {
        setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_activity_for_remote_splash"));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_SPLASH_ACTIVITY);
        setFlagPaySdk();
        initView();
        getInstentDatas();
        startWelcomeActivity();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_SPLASH_ACTIVITY);
        getInstentDatas();
        startWelcomeActivity();
    }

    public void startWelcomeActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("fromType", this.f26793a);
        PrecashierCreateOrderResponse precashierCreateOrderResponse = this.f26794b;
        if (precashierCreateOrderResponse != null) {
            intent.putExtra(BaiduPay.PRECASHIER_PAY_RESPONSE, precashierCreateOrderResponse);
        }
        startActivity(intent);
    }
}
