package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.f;
import com.baidu.wallet.paysdk.beans.n;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.LivingVerifyResultModel;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PayResponse;
import com.baidu.wallet.paysdk.datamodel.QueryPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.dxmpay.wallet.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
/* loaded from: classes8.dex */
public abstract class PayBaseActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QUERY_DELTA_FOR_EASY = 3000;
    public static final int QUERY_TIME_FOR_EASY = 20000;
    public static final int REQUEST_CODE = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public v f62987a;

    /* renamed from: b  reason: collision with root package name */
    public PayQueryRequest f62988b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62989c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f62990d;

    /* renamed from: e  reason: collision with root package name */
    public long f62991e;

    /* renamed from: f  reason: collision with root package name */
    public ErrorContentResponse.LivingParam f62992f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62993g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f62994h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f62995i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f62996j;
    public int mBeanId;
    public ErrorContentResponse mErrorContent;
    public ErrorContentResponse.Guidance mGuidance;
    public int mPayErrorCode;

    public PayBaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBeanId = -1;
        this.f62989c = false;
        this.f62991e = 0L;
        this.f62993g = false;
        this.f62994h = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayBaseActivity f63012a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f63012a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ErrorContentResponse.Operations[] operationsArr = this.f63012a.mGuidance.operations;
                    if (operationsArr.length < 1) {
                        return;
                    }
                    int i4 = operationsArr.length >= 3 ? 2 : 0;
                    this.f63012a.b(i4);
                    this.f63012a.onNegativeBtnClick();
                    if (this.f63012a.mGuidance.operations[i4].getAction() != null) {
                        n action = this.f63012a.mGuidance.operations[i4].getAction();
                        PayBaseActivity payBaseActivity = this.f63012a;
                        action.a(payBaseActivity.mGuidance.operations[i4], payBaseActivity.mAct);
                    }
                }
            }
        };
        this.f62995i = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayBaseActivity f63013a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f63013a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    PayBaseActivity payBaseActivity = this.f63013a;
                    if (payBaseActivity.mGuidance.operations.length < 2) {
                        return;
                    }
                    payBaseActivity.b(1);
                    if (this.f63013a.mGuidance.operations[1].getAction() != null) {
                        n action = this.f63013a.mGuidance.operations[1].getAction();
                        PayBaseActivity payBaseActivity2 = this.f63013a;
                        action.a(payBaseActivity2.mGuidance.operations[1], payBaseActivity2.mAct);
                    }
                }
            }
        };
        this.f62996j = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayBaseActivity f63014a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f63014a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ErrorContentResponse.Operations[] operationsArr = this.f63014a.mGuidance.operations;
                    if (operationsArr.length < 2) {
                        return;
                    }
                    int i4 = operationsArr.length >= 3 ? 0 : 1;
                    this.f63014a.b(i4);
                    if (this.f63014a.mGuidance.operations[i4].getAction() != null) {
                        n action = this.f63014a.mGuidance.operations[i4].getAction();
                        PayBaseActivity payBaseActivity = this.f63014a;
                        action.a(payBaseActivity.mGuidance.operations[i4], payBaseActivity.mAct);
                    }
                }
            }
        };
    }

    public void addDoPayorCheckCardStatistics(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            int i2 = this.mBeanId;
            String str2 = BeanConstants.API_DO_PAY;
            if (i2 != 14 && i2 != 263 && (i2 != 13 || com.baidu.wallet.paysdk.a.b.a())) {
                str2 = (this.mBeanId == 5 && f.f62409a == 1) ? BeanConstants.API_CHECK_CARD_INFO : "";
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            arrayList.add(String.valueOf(this.mPayErrorCode));
            arrayList.add(str);
            StatisticManager.onEventWithValues("payAlertAction", arrayList);
            this.mBeanId = -1;
        }
    }

    public void doLivingPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void handleErrorContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) {
            if (i2 == 12) {
                this.f62989c = false;
                if (TextUtils.isEmpty(str)) {
                    if (com.baidu.wallet.paysdk.a.b.a()) {
                        str = getString(ResUtils.string(this, "ebpay_pay_fail"));
                    } else {
                        str = getString(ResUtils.string(this, "ebpay_sign_fail"));
                    }
                }
                PayResultContent payResultContent = new PayResultContent();
                payResultContent.mErrorMsg = str;
                if (i3 >= -1) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    CountDownTimer countDownTimer = this.f62990d;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        this.f62990d = null;
                    }
                    PayController.getInstance().payPaying(this, payResultContent, com.baidu.wallet.paysdk.a.b.a() ? 4 : 1);
                    return;
                }
                String str2 = "mTimeAmount=" + this.f62991e;
                if (this.f62991e == 0) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    PayController.getInstance().payPaying(this, payResultContent, com.baidu.wallet.paysdk.a.b.a() ? 4 : 1);
                    StatisticManager.onEventWithValue("queryPayResultFail", String.valueOf(i3));
                    return;
                }
                return;
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
            if (i2 == 13 || i2 == 263) {
                PayResponse payResponse = (PayResponse) obj;
                if (payResponse != null && payResponse.checkResponseValidity()) {
                    if (this.f62988b == null) {
                        this.f62988b = new PayQueryRequest();
                    }
                    PayQueryRequest payQueryRequest = this.f62988b;
                    payQueryRequest.mBankNo = payResponse.bank_no;
                    payQueryRequest.mOrderNo = payResponse.order_no;
                    if (com.baidu.wallet.paysdk.a.b.a()) {
                        if (com.baidu.wallet.paysdk.a.b.b()) {
                            a(0);
                            PayResultContent payResultContent = new PayResultContent();
                            payResultContent.title_url = payResponse.title_url;
                            payResultContent.paytype_info = payResponse.paytype_info;
                            payResultContent.cash_amount = "";
                            payResultContent.total_amount = "";
                            payResultContent.authorize_msg = "";
                            payResultContent.isPaySuccess = true;
                            payResultContent.paytype_desc = payResponse.sign_success_tips;
                            payResultContent.subtitle_msg = payResponse.update_mobile_desc;
                            PayController.getInstance().paySucess(this, payResultContent, 4);
                            return;
                        }
                        this.f62988b.mName = PayQueryRequest.EASYPAY_NAME;
                        PayDataCache.getInstance().setSignSuccessTips(payResponse.sign_success_tips);
                        PayDataCache.getInstance().setAccountBankCard(payResponse.account_bank_card);
                    } else if (i2 == 263) {
                        this.f62988b.mName = PayQueryRequest.CRDDITPAY_NAME;
                    } else {
                        this.f62988b.mName = PayQueryRequest.EASYPAY_NAME;
                    }
                    if (payResponse.toShowH5ResultPage()) {
                        PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(payResponse.redirect_sp_succpage_remain_time, payResponse.pay_result_url, payResponse.pay_result_params, payResponse.show_h5_result, CashierDeskPayResult.PayScenario.BankcardPay));
                    }
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f62988b.getRequestId(), this.f62988b);
                    queryPayResult();
                }
                stopCountDown();
            } else if (i2 == 12) {
                this.f62989c = false;
                QueryPayResponse queryPayResponse = (QueryPayResponse) obj;
                if (queryPayResponse != null && (str2 = queryPayResponse.trans_state) != null && "0".equals(str2)) {
                    String str3 = "######. query ok = " + System.currentTimeMillis();
                    PayResultContent payResultContent2 = new PayResultContent();
                    payResultContent2.subtitle_msg = queryPayResponse.display_msg;
                    payResultContent2.compliance = queryPayResponse.compliance;
                    payResultContent2.notify = queryPayResponse.notify;
                    payResultContent2.score_tip = queryPayResponse.score_tip;
                    payResultContent2.paytype_desc = queryPayResponse.paytype_desc;
                    payResultContent2.coupon_msg = queryPayResponse.coupon_msg;
                    payResultContent2.coupon_find_prompt = queryPayResponse.coupon_find_prompt;
                    payResultContent2.title_url = queryPayResponse.title_url;
                    payResultContent2.discount_info = queryPayResponse.discount_info;
                    QueryPayResponse.Business business = queryPayResponse.business;
                    if (business != null) {
                        String str4 = business.stream_recharge_msg;
                        if (str4 != null) {
                            payResultContent2.stream_recharge_msg = str4;
                        }
                        String str5 = queryPayResponse.business.expected_time;
                        if (str5 != null) {
                            payResultContent2.expected_time = str5;
                        }
                    }
                    payResultContent2.total_amount = queryPayResponse.total_amount;
                    payResultContent2.cash_amount = queryPayResponse.cash_amount;
                    payResultContent2.discount_amount = queryPayResponse.discount_amount;
                    payResultContent2.pay_detail_info = queryPayResponse.pay_detail_info;
                    payResultContent2.paytype_info = queryPayResponse.paytype_info;
                    AuthorizeInfo authorizeInfo = queryPayResponse.authorize_info;
                    payResultContent2.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
                    payResultContent2.trans_no = queryPayResponse.trans_no;
                    payResultContent2.feedback_info = queryPayResponse.feedback_info;
                    payResultContent2.cross_market = queryPayResponse.cross_market;
                    payResultContent2.order_prefix = queryPayResponse.order_prefix;
                    payResultContent2.discount_prefix = queryPayResponse.discount_prefix;
                    payResultContent2.redirect_sp_succpage_remain_time = queryPayResponse.redirect_sp_succpage_remain_time;
                    payResultContent2.fp_open_or_update_msg = queryPayResponse.fp_open_or_update_msg;
                    payResultContent2.payResultCashbackDetail = queryPayResponse.cashback_dialog_detail;
                    CountDownTimer countDownTimer = this.f62990d;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    StatHelper.cachePayAmount(Double.valueOf(queryPayResponse.cash_amount).doubleValue());
                    a(0);
                    if (com.baidu.wallet.paysdk.a.b.a() && !com.baidu.wallet.paysdk.a.b.b()) {
                        payResultContent2.paytype_desc = PayDataCache.getInstance().getSignSuccessTips();
                        PayDataCache.getInstance().setAccountBankCard(null);
                        PayDataCache.getInstance().setSignSuccessTips("");
                        PayController.getInstance().paySucess(this, payResultContent2, 4);
                    } else {
                        showPaySuccessPage(true, payResultContent2, 1);
                    }
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    return;
                }
                String str6 = "mTimeAmount====" + this.f62991e;
                if (this.f62991e == 0) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    StatisticManager.onEvent("queryPayResultFail");
                    showPaySuccessPage(false, new PayResultContent(), 1);
                }
            }
        }
    }

    public void hideFullScreenLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean isBindPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public boolean isSlidingEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        ErrorContentResponse errorContentResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            StatHelper.cacheCodeAndMsg(i3 + "", str);
            this.mDialogMsg = str;
            if (obj != null && (obj instanceof ErrorContentResponse)) {
                this.mErrorContent = (ErrorContentResponse) obj;
            }
            if (i3 == 15500) {
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeDismissDialog(this, 0);
                WalletGlobalUtils.safeShowDialog(this, 34, "");
            } else if (i3 == 80320 || i3 == 80321 || i3 == 80326 || i3 == 80327) {
                PayDataCache.getInstance().cleanDetainmentDesc();
                WalletGlobalUtils.safeDismissDialog(this, 0);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(this, 35, "");
            } else if (i3 == 51010 && (errorContentResponse = this.mErrorContent) != null && errorContentResponse.verify != null) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                if (TextUtils.isEmpty(this.mErrorContent.verify.type)) {
                    return;
                }
                a(this.mErrorContent.verify.type, i3, str);
                a(this.mErrorContent.verify);
            } else {
                ErrorContentResponse errorContentResponse2 = this.mErrorContent;
                if (errorContentResponse2 != null && (guidance = errorContentResponse2.guidance) != null && guidance.isGuidanceAvilable()) {
                    StatisticManager.onEvent("payTimeoutGuidanceState", String.valueOf(i3));
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    WalletGlobalUtils.safeDismissDialog(this, -1);
                    WalletGlobalUtils.safeDismissDialog(this, -2);
                    if (!com.baidu.wallet.paysdk.a.b.a() && i3 != 100015 && i3 != 16545) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_ENTER, null, i3 + "", str);
                    }
                    ErrorContentResponse errorContentResponse3 = this.mErrorContent;
                    this.f62992f = errorContentResponse3.living_param;
                    a(errorContentResponse3.guidance);
                    this.mGuidance = this.mErrorContent.guidance;
                    this.mPayErrorCode = i3;
                    this.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(this, 53, "");
                } else if (i2 == 13 && i3 == 5320 && this.mErrorContent != null) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    ErrorContentResponse.Verify verify = this.mErrorContent.verify;
                    if (verify != null) {
                        a(verify.getVerifyType(), i3, str);
                    }
                    ErrorContentResponse errorContentResponse4 = this.mErrorContent;
                    triggerSmsVerify(errorContentResponse4.verify, false, errorContentResponse4.hint_sms, 5320);
                    StatisticManager.onEvent("event_banks_need_to_verify_sms");
                    a();
                } else {
                    super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null && (serializable = bundle.getSerializable("mCardInfoUpdateContent")) != null && (serializable instanceof ErrorContentResponse)) {
                this.mErrorContent = (ErrorContentResponse) serializable;
            }
            setFlagPaySdk();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        ErrorContentResponse.Guidance guidance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 == 53 && (guidance = this.mGuidance) != null && guidance.isGuidanceAvilable()) {
                if (isBindPay()) {
                    ErrorContentResponse.Guidance guidance2 = this.mGuidance;
                    guidance2.operations = a(guidance2.operations);
                }
                if (this.mGuidance.operations.length > 2) {
                    return new PromptMultiBtnDialog(this);
                }
                return new PromptDialog(this);
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            CountDownTimer countDownTimer = this.f62990d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f62990d = null;
            }
            BeanManager.getInstance().removeAllBeans("PayBaseActivity");
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, event) == null) && event != null && "ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    public void onNegativeBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void onOtherPayTypeClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            WalletGlobalUtils.safeDismissDialog(this, i2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, dialog) == null) {
            if (i2 == 53) {
                ErrorContentResponse.Guidance guidance = this.mGuidance;
                if (guidance == null || !guidance.isGuidanceAvilable()) {
                    return;
                }
                a(dialog, this.mGuidance);
            } else if (i2 == 18) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setCanceledOnTouchOutside(false);
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                String detainmentDesc = PayDataCache.getInstance().getDetainmentDesc();
                if (TextUtils.isEmpty(detainmentDesc)) {
                    detainmentDesc = ResUtils.getString(this, "ebpay_confirm_abandon_pay");
                }
                promptDialog.setMessage(detainmentDesc);
                StatHelper.statServiceEvent("cancelDoPayAlert", null, detainmentDesc, PayDataCache.getInstance().getInsideTransOrder());
                promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_abandom_pay_comfirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63000a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63000a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (!PayDataCache.getInstance().isFromPreCashier()) {
                                StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                            }
                            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONFIRM_IN_QUIT_DIALOG);
                            WalletGlobalUtils.safeDismissDialog(this.f63000a, 18);
                            PayCallBackManager.callBackClientCancel(this.f63000a, "PayBaseActivity.onPrepareDialog().1");
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.string(this, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63003a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63003a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CANCEL_IN_QUIT_DIALOG);
                            WalletGlobalUtils.safeDismissDialog(this.f63003a, 18);
                        }
                    }
                });
            } else if (i2 == 34) {
                StatisticManager.onEvent("showCardOverDue");
                PayRequest payRequest2 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (payRequest2 != null && (bondCard = payRequest2.mBondCard) != null) {
                    bondCard.isCheckPass = true;
                }
                PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
                promptMultiBtnDialog.setMessage(this.mDialogMsg);
                promptMultiBtnDialog.setFirstBtn(ResUtils.string(this, "ebpay_wallet_continue_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63004a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63004a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayBaseActivity payBaseActivity = this.f63004a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                            StatisticManager.onEvent("continueFromCardOverdue");
                            WalletGlobalUtils.safeDismissDialog(this.f63004a, 34);
                            PayController payController = PayController.getInstance();
                            PayBaseActivity payBaseActivity2 = this.f63004a;
                            payController.updateCardInfoPay(payBaseActivity2, payBaseActivity2.mErrorContent);
                            this.f63004a.finishWithoutAnim();
                        }
                    }
                });
                promptMultiBtnDialog.setSecondBtn(ResUtils.string(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63005a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63005a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayBaseActivity payBaseActivity = this.f63005a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                            PayRequest payRequest3 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                            if (payRequest3 != null) {
                                payRequest3.clearMktSolution();
                            }
                            WalletGlobalUtils.safeDismissDialog(this.f63005a, 34);
                            PayController.getInstance().gotoPayTypePage(this.f63005a, false);
                            this.f63005a.finishWithoutAnim();
                        }
                    }
                });
                promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63006a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63006a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f63006a.addDoPayorCheckCardStatistics("取消");
                            this.f63006a.c(34);
                            PayBaseActivity payBaseActivity = this.f63006a;
                            if (payBaseActivity instanceof WalletSmsActivity) {
                                payBaseActivity.finishWithoutAnim();
                            }
                        }
                    }
                });
            } else if (i2 == 35) {
                StatisticManager.onEvent("showOrigPriceAlert");
                PromptMultiBtnDialog promptMultiBtnDialog2 = (PromptMultiBtnDialog) dialog;
                promptMultiBtnDialog2.setMessage(this.mDialogMsg);
                promptMultiBtnDialog2.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63007a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63007a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("origPriceFromAlert");
                            PayBaseActivity payBaseActivity = this.f63007a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                            WalletGlobalUtils.safeDismissDialog(this.f63007a, 35);
                            this.f63007a.handleErrorContent();
                        }
                    }
                });
                promptMultiBtnDialog2.setSecondBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63008a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63008a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayBaseActivity payBaseActivity = this.f63008a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                            WalletGlobalUtils.safeDismissDialog(this.f63008a, 35);
                            PayController.getInstance().gotoPayTypePage(this.f63008a, false);
                            this.f63008a.finishWithoutAnim();
                        }
                    }
                });
                promptMultiBtnDialog2.setThirdBtn("取消", new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63010a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63010a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f63010a.addDoPayorCheckCardStatistics("取消");
                            this.f63010a.c(35);
                        }
                    }
                });
            } else if (i2 == 54) {
                StatisticManager.onEvent("livingVerifyDialogShow");
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setMessage(ResUtils.getString(this.mAct, "wallet_base_finish_living_verify"));
                promptDialog2.setNegativeBtn(ResUtils.getString(this.mAct, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63009a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63009a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f63009a.mAct, 54);
                            this.f63009a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog2.setPositiveBtn(ResUtils.getString(this.mAct, "wallet_base_revalidation"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63011a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63011a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f63011a.mAct, 54);
                            StatisticManager.onEvent("livingVerifyDialogRetry");
                            this.f63011a.triggerLivingVerify();
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            if (this.f62993g) {
                this.f62993g = false;
                WalletGlobalUtils.safeShowDialog(this, 54, "");
            }
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
            EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            ErrorContentResponse errorContentResponse = this.mErrorContent;
            if (errorContentResponse != null) {
                bundle.putSerializable("mCardInfoUpdateContent", errorContentResponse);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void queryPayResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f62987a == null) {
                this.f62987a = (v) PayBeanFactory.getInstance().getBean((Context) this, 12, "PayBaseActivity");
            }
            this.f62989c = true;
            this.f62987a.setResponseCallback(this);
            this.f62987a.execBean();
            CountDownTimer countDownTimer = this.f62990d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f62990d = null;
            }
            long j2 = this.f62991e;
            if (j2 <= 0) {
                j2 = 20000;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, j2, 3000L) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f62997a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(j2, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(r13)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62997a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62997a.f62991e = 0L;
                        if (this.f62997a.f62989c) {
                            String str = "######. onFinish. query return = " + System.currentTimeMillis();
                            return;
                        }
                        this.f62997a.f62989c = true;
                        this.f62997a.f62987a.setResponseCallback(this.f62997a);
                        this.f62997a.f62987a.execBean();
                        String str2 = "######. onTick. query = " + System.currentTimeMillis();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j3) == null) {
                        this.f62997a.f62991e = j3;
                        if (this.f62997a.f62989c) {
                            String str = "######. onTick. query return = " + System.currentTimeMillis();
                            return;
                        }
                        String str2 = "######. onTick. query = " + System.currentTimeMillis() + " , remain millis = " + j3;
                        this.f62997a.f62989c = true;
                        this.f62997a.f62987a.setResponseCallback(this.f62997a);
                        this.f62997a.f62987a.execBean();
                    }
                }
            };
            this.f62990d = countDownTimer2;
            countDownTimer2.start();
        }
    }

    public abstract void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2);

    public void stopCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void triggerCardItemVerify(ErrorContentResponse.Verify verify) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, verify) == null) || verify == null || (strArr = verify.card_item_required) == null || strArr.length < 1) {
            return;
        }
        String str = strArr[0];
        Intent intent = new Intent();
        intent.setClass(this, CardInfoCheckActivity.class);
        if (ErrorContentResponse.Verify.VERIFY_CVV2.equals(str)) {
            intent.putExtra(CardInfoCheckActivity.CHECK_INFO_STATE, 3);
            startActivityWithoutAnim(intent);
            a();
        } else if (ErrorContentResponse.Verify.VERIFY_CETIFICATE_CODE.equals(str)) {
            intent.putExtra(CardInfoCheckActivity.CHECK_INFO_STATE, 1);
            startActivityWithoutAnim(intent);
            a();
        } else if ("card_no".equals(str)) {
            intent.putExtra(CardInfoCheckActivity.CHECK_INFO_STATE, 2);
            startActivityWithoutAnim(intent);
            a();
        }
    }

    public void triggerLivingVerify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            StatisticManager.onEvent("triggerLivingVerify");
            hideFullScreenLoading();
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (LocalRouter.getInstance(this).isProviderExisted("livenessidentifyauth") && this.f62992f != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(LightInvokerImpl.LIVENESS_SHOW_GUIDE_PAGE, "0");
                hashMap.put("method", "DXMPayLivenessMatch");
                hashMap.put("recogType", "authToken");
                hashMap.put("authToken", this.f62992f.usertoken);
                hashMap.put(LightInvokerImpl.SP_PARAMS, this.f62992f.sp_params);
                hashMap.put("userDisplayName", this.f62992f.user_display_name);
                LocalRouter.getInstance(this).route(this, new RouterRequest().provider("livenessidentifyauth").action("livenessidentifyauth").data(hashMap), new RouterCallback(this, payRequest) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayRequest f63001a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f63002b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, payRequest};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f63002b = this;
                        this.f63001a = payRequest;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap2) == null) {
                            if (hashMap2 != null) {
                                if (i2 == 0) {
                                    StatisticManager.onEvent("triggerLivingVerifySuccess");
                                } else {
                                    StatisticManager.onEvent("triggerLivingVerifyFailWithErrorCode");
                                    if (i2 == -203 || i2 == -202 || i2 == -201 || i2 == -402) {
                                        this.f63002b.f62993g = true;
                                        return;
                                    }
                                }
                                if (hashMap2.get("value") != null) {
                                    LivingVerifyResultModel a2 = this.f63002b.a(hashMap2.get("value").toString());
                                    PayRequest payRequest2 = this.f63001a;
                                    if (payRequest2 != null && a2 != null) {
                                        payRequest2.mLivingKey = a2.callback_key;
                                    }
                                }
                            } else {
                                StatisticManager.onEvent("triggerLivingVerifyFailWithErrorCode");
                            }
                            i2 = (i2 == -100 || i2 == 5) ? 10003 : 10003;
                            PayRequest payRequest3 = this.f63001a;
                            if (payRequest3 != null) {
                                payRequest3.mLivingResultCode = i2 + "";
                            }
                            this.f63002b.doLivingPay();
                        }
                    }
                });
                return;
            }
            StatisticManager.onEvent("triggerLivingVerifyFailWithErrorCode");
            if (payRequest != null) {
                payRequest.mLivingResultCode = LightappConstants.ERRCODE_INNER_ERROR;
            }
            doLivingPay();
        }
    }

    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{verify, Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) {
            StatHelper.statServiceEvent("triggleSmsPay");
            Intent intent = new Intent();
            intent.setClass(this, WalletSmsActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
            intent.putExtra(BeanConstants.KEY_SEND_SMS_AUTO, z);
            intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
            intent.putExtra(BeanConstants.KEY_SMS_HINT, str);
            intent.putExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, i2);
            startActivityWithoutAnim(intent);
        }
    }

    public void triggerSpeechVerify(ErrorContentResponse.Verify verify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, verify) == null) {
            StatisticManager.onEvent("triggerSpeechVerify");
            Intent intent = new Intent();
            intent.setClass(this, VoiceVerifyActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
            intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
            startActivityWithoutAnim(intent);
        }
    }

    private void c(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, this, dialog, guidance) == null) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setTitleText(guidance.prompt_head);
            promptDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
            if (TextUtils.equals(ErrorContentResponse.Operations.LIVING_AGAIN, guidance.operations[1].type)) {
                StatisticManager.onEvent("livingVerifyDialogShow");
            }
            promptDialog.setNegativeBtn(guidance.operations[0].getActionName(), this.f62994h);
            promptDialog.setPositiveBtn(guidance.operations[1].getActionName(), this.f62996j);
        }
    }

    private void d(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, this, dialog, guidance) == null) {
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setCanceledOnTouchOutside(false);
            promptMultiBtnDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
            promptMultiBtnDialog.setFirstBtn(guidance.operations[0].getActionName(), this.f62996j);
            promptMultiBtnDialog.setSecondBtn(guidance.operations[1].getActionName(), this.f62995i);
            promptMultiBtnDialog.setThirdBtn(guidance.operations[2].getActionName(), this.f62994h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        ErrorContentResponse.Guidance guidance;
        ErrorContentResponse.Operations[] operationsArr;
        ErrorContentResponse.Operations[] operationsArr2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65554, this, i2) == null) || (guidance = this.mGuidance) == null || (operationsArr = guidance.operations) == null) {
            return;
        }
        boolean z2 = true;
        if (operationsArr.length > 1) {
            int i3 = 0;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            while (true) {
                operationsArr2 = this.mGuidance.operations;
                if (i3 >= operationsArr2.length) {
                    break;
                }
                if (ErrorContentResponse.Operations.CASHDESK_CLOSE.equals(operationsArr2[i3].type)) {
                    z3 = true;
                } else if ("change_paytype".equals(this.mGuidance.operations[i3].type)) {
                    z5 = true;
                } else if (ErrorContentResponse.Operations.BIND_OTHER_CARDS.equals(this.mGuidance.operations[i3].type)) {
                    z4 = true;
                }
                i3++;
            }
            if (z3) {
                z = ErrorContentResponse.Operations.CASHDESK_CLOSE.equals(operationsArr2[i2].type);
            } else {
                if (z4 || z5) {
                    z = !ErrorContentResponse.Operations.HELP_CENTER.equals(this.mGuidance.operations[i2].type);
                }
                addDoPayorCheckCardStatistics(this.mGuidance.operations[i2].getActionName());
            }
            z2 = z;
            addDoPayorCheckCardStatistics(this.mGuidance.operations[i2].getActionName());
        }
        if (z2) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, 53);
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            StatHelper.cachePayType(i2);
            if (PayDataCache.getInstance().isFromPreCashier()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS);
                return;
            }
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, this, i2) == null) {
            WalletGlobalUtils.safeDismissDialog(this, i2);
            onNegativeBtnClick();
        }
    }

    private void a(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        ErrorContentResponse.Operations[] operationsArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, dialog, guidance) == null) || guidance == null || (operationsArr = guidance.operations) == null || operationsArr.length == 0) {
            return;
        }
        if (operationsArr.length == 1) {
            b(dialog, guidance);
        } else if (operationsArr.length == 2) {
            c(dialog, guidance);
        } else if (operationsArr.length >= 3) {
            d(dialog, guidance);
        }
    }

    private void b(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, dialog, guidance) == null) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setTitleText(guidance.prompt_head);
            promptDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
            promptDialog.hidePositiveButton();
            promptDialog.setNegativeBtn(guidance.operations[0].getActionName(), this.f62994h);
        }
    }

    private ErrorContentResponse.Operations[] a(ErrorContentResponse.Operations[] operationsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, operationsArr)) == null) {
            if (operationsArr == null || operationsArr.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, operationsArr);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals("change_paytype", ((ErrorContentResponse.Operations) it.next()).type)) {
                    it.remove();
                }
            }
            return (ErrorContentResponse.Operations[]) arrayList.toArray(new ErrorContentResponse.Operations[arrayList.size()]);
        }
        return (ErrorContentResponse.Operations[]) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if ((this instanceof PwdPayActivity) || (this instanceof WalletSmsActivity)) {
                finishWithoutAnim();
            }
        }
    }

    private void b(ErrorContentResponse.Verify verify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, verify) == null) {
            a(verify, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && (this instanceof PwdPayActivity)) {
            finishWithoutAnim();
        }
    }

    private void a(ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, guidance) == null) || guidance == null || guidance.operations == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ErrorContentResponse.Operations[] operationsArr = guidance.operations;
            if (i2 >= operationsArr.length) {
                return;
            }
            operationsArr[i2].registerActionHandler(ErrorContentResponse.Operations.SEND_SMS, new n(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f63015a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63015a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.n
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, ErrorContentResponse.Operations.SEND_SMS);
                        this.f63015a.a((ErrorContentResponse.Verify) null, true);
                        this.f63015a.a();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.LIVING_AGAIN, new n(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f63016a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63016a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.n
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, ErrorContentResponse.Operations.LIVING_AGAIN);
                        StatisticManager.onEvent("livingVerifyDialogRetry");
                        this.f63016a.triggerLivingVerify();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.BIND_OTHER_CARDS, new n(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f63017a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63017a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.n
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, ErrorContentResponse.Operations.BIND_OTHER_CARDS);
                        PayBaseActivity payBaseActivity = this.f63017a;
                        if (payBaseActivity instanceof BindCardImplActivity) {
                            ((BindCardImplActivity) payBaseActivity).handleBindOtherCard();
                        }
                    }
                }
            });
            guidance.operations[i2].registerActionHandler("change_paytype", new n(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f62998a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62998a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.n
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, "change_paytype");
                        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                        if (payRequest != null) {
                            payRequest.clearMktSolution();
                        }
                        PayController.getInstance().gotoPayTypePage(this.f62998a, false);
                        this.f62998a.b();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.RETRY_PAY, new n(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f62999a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62999a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.n
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, null, ErrorContentResponse.Operations.RETRY_PAY);
                        if (PayRequestCache.getInstance().isPaying()) {
                            BaiduPayDelegate.getInstance().reOrderPay(this.f62999a.getActivity());
                        }
                    }
                }
            });
            i2++;
        }
    }

    private void a(ErrorContentResponse.Verify verify) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, verify) == null) || verify == null) {
            return;
        }
        String verifyType = verify.getVerifyType();
        if ("1".equals(verifyType)) {
            b(verify);
            a();
        } else if ("2".equals(verifyType)) {
            triggerSpeechVerify(verify);
            a();
        } else if ("3".equals(verifyType)) {
            triggerCardItemVerify(verify);
        } else if ("4".equals(verifyType)) {
            this.f62992f = verify.living_param;
            triggerLivingVerify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LivingVerifyResultModel a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (LivingVerifyResultModel) JsonUtils.fromJson(str, LivingVerifyResultModel.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (LivingVerifyResultModel) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorContentResponse.Verify verify, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, this, verify, z) == null) {
            triggerSmsVerify(verify, z, null, Integer.MIN_VALUE);
        }
    }

    private void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, this, str, i2, str2) == null) {
            if (!com.baidu.wallet.paysdk.a.b.a()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_SMS_ENTER, null, i2 + "", str2, str);
            }
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_SMS_DURATION);
        }
    }
}
