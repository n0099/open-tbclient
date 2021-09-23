package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
/* loaded from: classes8.dex */
public class RemotePaySplashActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64007a;

    /* renamed from: b  reason: collision with root package name */
    public PrecashierCreateOrderResponse f64008b;

    public RemotePaySplashActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void getInstentDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = getIntent();
            if (intent == null) {
                StatisticManager.onEvent("remoteSplashActivityExFinish");
                PayCallBackManager.callBackClientCancel(this.mAct, "RemotePaySplashActivity.getIntent() is null");
                finish();
                return;
            }
            this.f64007a = intent.getIntExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 0);
            this.f64008b = (PrecashierCreateOrderResponse) intent.getSerializableExtra(BaiduPay.PRECASHIER_PAY_RESPONSE);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_activity_for_remote_splash"));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            StatisticManager.onEvent("remoteEnterSplashActivity");
            setFlagPaySdk();
            initView();
            getInstentDatas();
            startWelcomeActivity();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            super.onNewIntent(intent);
            StatisticManager.onEvent("remoteEnterSplashActivity");
            getInstentDatas();
            startWelcomeActivity();
        }
    }

    public void startWelcomeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, this.f64007a);
            PrecashierCreateOrderResponse precashierCreateOrderResponse = this.f64008b;
            if (precashierCreateOrderResponse != null) {
                intent.putExtra(BaiduPay.PRECASHIER_PAY_RESPONSE, precashierCreateOrderResponse);
            }
            startActivity(intent);
        }
    }
}
