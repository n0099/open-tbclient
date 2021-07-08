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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.beans.q;
import com.baidu.wallet.paysdk.beans.z;
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
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import com.baidu.wallet.utils.StringUtil;
import com.baidu.walletfacesdk.LightInvokerImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class PayBaseActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QUERY_DELTA_FOR_EASY = 3000;
    public static final int QUERY_TIME_FOR_EASY = 20000;
    public static final int REQUEST_CODE = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public z f26543a;

    /* renamed from: b  reason: collision with root package name */
    public PayQueryRequest f26544b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26545c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.wallet.paysdk.b f26546d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownTimer f26547e;

    /* renamed from: f  reason: collision with root package name */
    public long f26548f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f26549g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f26550h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f26551i;
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
        this.f26545c = false;
        this.f26548f = 0L;
        this.f26549g = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayBaseActivity f26566a;

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
                this.f26566a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ErrorContentResponse.Operations[] operationsArr = this.f26566a.mGuidance.operations;
                    if (operationsArr.length < 1) {
                        return;
                    }
                    int i4 = operationsArr.length >= 3 ? 2 : 0;
                    this.f26566a.a(i4);
                    this.f26566a.onNegativeBtnClick();
                    if (this.f26566a.mGuidance.operations[i4].getAction() != null) {
                        q action = this.f26566a.mGuidance.operations[i4].getAction();
                        PayBaseActivity payBaseActivity = this.f26566a;
                        action.a(payBaseActivity.mGuidance.operations[i4], payBaseActivity.mAct);
                    }
                }
            }
        };
        this.f26550h = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayBaseActivity f26567a;

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
                this.f26567a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    PayBaseActivity payBaseActivity = this.f26567a;
                    if (payBaseActivity.mGuidance.operations.length < 2) {
                        return;
                    }
                    payBaseActivity.a(1);
                    if (this.f26567a.mGuidance.operations[1].getAction() != null) {
                        q action = this.f26567a.mGuidance.operations[1].getAction();
                        PayBaseActivity payBaseActivity2 = this.f26567a;
                        action.a(payBaseActivity2.mGuidance.operations[1], payBaseActivity2.mAct);
                    }
                }
            }
        };
        this.f26551i = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayBaseActivity f26568a;

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
                this.f26568a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    ErrorContentResponse.Operations[] operationsArr = this.f26568a.mGuidance.operations;
                    if (operationsArr.length < 2) {
                        return;
                    }
                    int i4 = operationsArr.length >= 3 ? 0 : 1;
                    this.f26568a.a(i4);
                    if (this.f26568a.mGuidance.operations[i4].getAction() != null) {
                        q action = this.f26568a.mGuidance.operations[i4].getAction();
                        PayBaseActivity payBaseActivity = this.f26568a;
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
                str2 = (this.mBeanId == 5 && h.f25987a == 1) ? BeanConstants.API_CHECK_CARD_INFO : "";
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            arrayList.add(String.valueOf(this.mPayErrorCode));
            arrayList.add(str);
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_ALERT_ACTION, arrayList);
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

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) {
            if (i2 == 12) {
                this.f26545c = false;
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
                    CountDownTimer countDownTimer = this.f26547e;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        this.f26547e = null;
                    }
                    PayController.getInstance().payPaying(this, payResultContent, com.baidu.wallet.paysdk.a.b.a() ? 4 : 1);
                    return;
                }
                LogUtil.logd("mTimeAmount=" + this.f26548f);
                if (this.f26548f == 0) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    PayController.getInstance().payPaying(this, payResultContent, com.baidu.wallet.paysdk.a.b.a() ? 4 : 1);
                    StatisticManager.onEventWithValue(StatServiceEvent.QUERY_PAY_RESULT_FAIL, String.valueOf(i3));
                    return;
                }
                return;
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
            if (i2 == 13 || i2 == 263) {
                PayResponse payResponse = (PayResponse) obj;
                if (payResponse != null && payResponse.checkResponseValidity()) {
                    if (i2 != 13) {
                        StatisticManager.onEventEnd(StatServiceEvent.CREDIT_PAY, 0);
                    }
                    if (this.f26544b == null) {
                        this.f26544b = new PayQueryRequest();
                    }
                    PayQueryRequest payQueryRequest = this.f26544b;
                    payQueryRequest.mBankNo = payResponse.bank_no;
                    payQueryRequest.mOrderNo = payResponse.order_no;
                    if (com.baidu.wallet.paysdk.a.b.a()) {
                        if (com.baidu.wallet.paysdk.a.b.b()) {
                            a("0");
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
                        this.f26544b.mName = PayQueryRequest.EASYPAY_NAME;
                        PayDataCache.getInstance().setSignSuccessTips(payResponse.sign_success_tips);
                        PayDataCache.getInstance().setAccountBankCard(payResponse.account_bank_card);
                    } else if (i2 == 263) {
                        this.f26544b.mName = PayQueryRequest.CRDDITPAY_NAME;
                    } else {
                        this.f26544b.mName = PayQueryRequest.EASYPAY_NAME;
                    }
                    if (payResponse.toShowH5ResultPage()) {
                        PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(payResponse.redirect_sp_succpage_remain_time, payResponse.pay_result_url, payResponse.pay_result_params, payResponse.show_h5_result, CashierDeskPayResult.PayScenario.BankcardPay));
                    }
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f26544b.getRequestId(), this.f26544b);
                    queryPayResult();
                }
                stopCountDown();
            } else if (i2 == 12) {
                this.f26545c = false;
                QueryPayResponse queryPayResponse = (QueryPayResponse) obj;
                if (queryPayResponse != null && (str2 = queryPayResponse.trans_state) != null && "0".equals(str2)) {
                    LogUtil.logd("######. query ok = " + System.currentTimeMillis());
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
                        String str3 = business.stream_recharge_msg;
                        if (str3 != null) {
                            payResultContent2.stream_recharge_msg = str3;
                        }
                        String str4 = queryPayResponse.business.expected_time;
                        if (str4 != null) {
                            payResultContent2.expected_time = str4;
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
                    CountDownTimer countDownTimer = this.f26547e;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    StatHelper.cachePayAmount(Double.valueOf(queryPayResponse.cash_amount).doubleValue());
                    a("0");
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
                LogUtil.logd("mTimeAmount====" + this.f26548f);
                if (this.f26548f == 0) {
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    StatisticManager.onEvent(StatServiceEvent.QUERY_PAY_RESULT_FAIL);
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        ErrorContentResponse errorContentResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
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
                    StatisticManager.onEvent(StatServiceEvent.EVENT_PAY_TIMEOUT_GUIDANCE_STATE, String.valueOf(i3));
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    WalletGlobalUtils.safeDismissDialog(this, -1);
                    WalletGlobalUtils.safeDismissDialog(this, -2);
                    if (!com.baidu.wallet.paysdk.a.b.a() && i3 != 100015 && i3 != 16545) {
                        String orderNo = StatHelper.getOrderNo();
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_GUIDANCE_ENTER, StatHelper.collectData(orderNo, i3 + "", str));
                    }
                    a(this.mErrorContent.guidance);
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
                    ErrorContentResponse errorContentResponse3 = this.mErrorContent;
                    triggerSmsVerify(errorContentResponse3.verify, false, errorContentResponse3.hint_sms, StatusCode.ERROR_BANKS_NEED_TO_VERIFY_SMS);
                    StatisticManager.onEvent(StatServiceEvent.EVENT_BANKS_NEED_TO_VERIFY_SMS);
                    a();
                } else {
                    super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null && (serializable = bundle.getSerializable("mCardInfoUpdateContent")) != null && (serializable instanceof ErrorContentResponse)) {
                this.mErrorContent = (ErrorContentResponse) serializable;
            }
            setFlagPaySdk();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        ErrorContentResponse.Guidance guidance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            CountDownTimer countDownTimer = this.f26547e;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f26547e = null;
            }
            BeanManager.getInstance().removeAllBeans("PayBaseActivity");
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, event) == null) && event != null && "ev_bean_execut_err_content".equals(event.mEventKey)) {
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void onOtherPayTypeClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            WalletGlobalUtils.safeDismissDialog(this, i2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, dialog) == null) {
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
                StatisticManager.onEventWithValues(StatServiceEvent.CANCEL_DOPAY_ALERT, getCancelPayEventValue(detainmentDesc));
                promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_abandom_pay_comfirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26555a;

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
                        this.f26555a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (!PayDataCache.getInstance().isFromPreCashier()) {
                                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                                HashMap hashMap = new HashMap();
                                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                                StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_CANCEL, collectData, hashMap);
                            }
                            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONFIRM_IN_QUIT_DIALOG);
                            WalletGlobalUtils.safeDismissDialog(this.f26555a, 18);
                            PayCallBackManager.callBackClientCancel(this.f26555a, "PayBaseActivity.onPrepareDialog().1");
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.string(this, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26557a;

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
                        this.f26557a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CANCEL_IN_QUIT_DIALOG);
                            WalletGlobalUtils.safeDismissDialog(this.f26557a, 18);
                        }
                    }
                });
            } else if (i2 == 34) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_CARD_UPDATE);
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
                    public final /* synthetic */ PayBaseActivity f26558a;

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
                        this.f26558a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayBaseActivity payBaseActivity = this.f26558a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                            WalletGlobalUtils.safeDismissDialog(this.f26558a, 34);
                            PayController payController = PayController.getInstance();
                            PayBaseActivity payBaseActivity2 = this.f26558a;
                            payController.updateCardInfoPay(payBaseActivity2, payBaseActivity2.mErrorContent);
                            this.f26558a.finishWithoutAnim();
                        }
                    }
                });
                promptMultiBtnDialog.setSecondBtn(ResUtils.string(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26559a;

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
                        this.f26559a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayBaseActivity payBaseActivity = this.f26559a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                            PayRequest payRequest3 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                            if (payRequest3 != null) {
                                payRequest3.clearMktSolution();
                            }
                            WalletGlobalUtils.safeDismissDialog(this.f26559a, 34);
                            PayController.getInstance().gotoPayTypePage(this.f26559a, false);
                            this.f26559a.finishWithoutAnim();
                        }
                    }
                });
                promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26560a;

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
                        this.f26560a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26560a.addDoPayorCheckCardStatistics("取消");
                            this.f26560a.b(34);
                            PayBaseActivity payBaseActivity = this.f26560a;
                            if (payBaseActivity instanceof WalletSmsActivity) {
                                payBaseActivity.finishWithoutAnim();
                            }
                        }
                    }
                });
            } else if (i2 == 35) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
                PromptMultiBtnDialog promptMultiBtnDialog2 = (PromptMultiBtnDialog) dialog;
                promptMultiBtnDialog2.setMessage(this.mDialogMsg);
                promptMultiBtnDialog2.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26561a;

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
                        this.f26561a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                            PayBaseActivity payBaseActivity = this.f26561a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                            WalletGlobalUtils.safeDismissDialog(this.f26561a, 35);
                            this.f26561a.handleErrorContent();
                        }
                    }
                });
                promptMultiBtnDialog2.setSecondBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26562a;

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
                        this.f26562a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayBaseActivity payBaseActivity = this.f26562a;
                            payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                            WalletGlobalUtils.safeDismissDialog(this.f26562a, 35);
                            PayController.getInstance().gotoPayTypePage(this.f26562a, false);
                            this.f26562a.finishWithoutAnim();
                        }
                    }
                });
                promptMultiBtnDialog2.setThirdBtn("取消", new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26564a;

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
                        this.f26564a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26564a.addDoPayorCheckCardStatistics("取消");
                            this.f26564a.b(35);
                        }
                    }
                });
            } else if (i2 == 54) {
                StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_SHOW);
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setMessage(ResUtils.getString(this.mAct, "wallet_base_finish_living_verify"));
                promptDialog2.setNegativeBtn(ResUtils.getString(this.mAct, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26563a;

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
                        this.f26563a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26563a.mAct, 54);
                            this.f26563a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog2.setPositiveBtn(ResUtils.getString(this.mAct, "wallet_base_revalidation"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayBaseActivity f26565a;

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
                        this.f26565a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26565a.mAct, 54);
                            StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_RETRY);
                            this.f26565a.triggerLivingVerify();
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
            EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            ErrorContentResponse errorContentResponse = this.mErrorContent;
            if (errorContentResponse != null) {
                bundle.putSerializable("mCardInfoUpdateContent", errorContentResponse);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void queryPayResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                StatisticManager.onEventWithValue("paySuccess", payRequest != null ? payRequest.mSpNO : "");
            }
            if (this.f26543a == null) {
                this.f26543a = (z) PayBeanFactory.getInstance().getBean((Context) this, 12, "PayBaseActivity");
            }
            this.f26545c = true;
            this.f26543a.setResponseCallback(this);
            this.f26543a.execBean();
            CountDownTimer countDownTimer = this.f26547e;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f26547e = null;
            }
            long j = this.f26548f;
            if (j <= 0) {
                j = 20000;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, j, 3000L) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26552a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(j, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(r13)};
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
                    this.f26552a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26552a.f26548f = 0L;
                        if (this.f26552a.f26545c) {
                            LogUtil.logd("######. onFinish. query return = " + System.currentTimeMillis());
                            return;
                        }
                        this.f26552a.f26545c = true;
                        this.f26552a.f26543a.setResponseCallback(this.f26552a);
                        this.f26552a.f26543a.execBean();
                        LogUtil.logd("######. onTick. query = " + System.currentTimeMillis());
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f26552a.f26548f = j2;
                        if (this.f26552a.f26545c) {
                            LogUtil.logd("######. onTick. query return = " + System.currentTimeMillis());
                            return;
                        }
                        LogUtil.logd("######. onTick. query = " + System.currentTimeMillis() + " , remain millis = " + j2);
                        this.f26552a.f26545c = true;
                        this.f26552a.f26543a.setResponseCallback(this.f26552a);
                        this.f26552a.f26543a.execBean();
                    }
                }
            };
            this.f26547e = countDownTimer2;
            countDownTimer2.start();
        }
    }

    public abstract void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2);

    public void stopCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void triggerCardItemVerify(ErrorContentResponse.Verify verify) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, verify) == null) || verify == null || (strArr = verify.card_item_required) == null || strArr.length < 1) {
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            StatisticManager.onEvent(StatServiceEvent.TRIGGERLIVINGVERIFY);
            hideFullScreenLoading();
            if (this.f26546d == null) {
                this.f26546d = new com.baidu.wallet.paysdk.b(StatServiceEvent.CALL_NATIVE_VOICE_FAIL_BY_CASHDESK);
            }
            this.f26546d.a(this.mAct, c(), new ILightappInvokerCallback(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26556a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26556a = this;
                }

                @Override // com.baidu.wallet.api.ILightappInvokerCallback
                public void onResult(int i2, String str) {
                    LivingVerifyResultModel.Cnt cnt;
                    int i3;
                    LivingVerifyResultModel.Result result;
                    LivingVerifyResultModel.Cnt cnt2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        LivingVerifyResultModel b2 = this.f26556a.b(str);
                        if (i2 == 0) {
                            StatisticManager.onEvent(StatServiceEvent.TRIGGER_LIVING_VERIFY_SUCCESS);
                            if (b2 == null || (cnt2 = b2.cnt) == null || cnt2.data == null) {
                                return;
                            }
                            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                            if (payRequest != null) {
                                LivingVerifyResultModel.Result result2 = b2.cnt.data.result;
                                if (result2 != null) {
                                    if (!TextUtils.isEmpty(result2.credentialKey)) {
                                        payRequest.mLivingKey = b2.cnt.data.result.credentialKey;
                                    }
                                    if (!TextUtils.isEmpty(b2.cnt.data.result.callbackkey)) {
                                        payRequest.mLivingKey = b2.cnt.data.result.callbackkey;
                                    }
                                }
                                int i4 = b2.cnt.data.retCode;
                                if (i4 != Integer.MIN_VALUE) {
                                    payRequest.mLivingResultCode = String.valueOf(i4);
                                }
                            }
                            this.f26556a.doLivingPay();
                        } else if (b2 == null || (cnt = b2.cnt) == null || (i3 = cnt.errCode) == Integer.MIN_VALUE) {
                        } else {
                            StatisticManager.onEventWithValue(StatServiceEvent.TRIGGER_LIVING_VERIFY_FAIL, String.valueOf(i3));
                            if (b2.cnt.errCode == LivingVerifyResultModel.ERRORCODECANCEL) {
                                WalletGlobalUtils.safeShowDialog(this.f26556a.mAct, 54, "");
                                return;
                            }
                            PayRequest payRequest2 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                            if (payRequest2 != null) {
                                payRequest2.mLivingResultCode = String.valueOf(b2.cnt.errCode);
                                LivingVerifyResultModel.Data data = b2.cnt.data;
                                if (data != null && (result = data.result) != null) {
                                    if (!TextUtils.isEmpty(result.credentialKey)) {
                                        payRequest2.mLivingKey = b2.cnt.data.result.credentialKey;
                                    }
                                    if (!TextUtils.isEmpty(b2.cnt.data.result.callbackkey)) {
                                        payRequest2.mLivingKey = b2.cnt.data.result.callbackkey;
                                    }
                                }
                            }
                            this.f26556a.doLivingPay();
                        }
                    }
                }
            });
        }
    }

    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{verify, Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) {
            StatisticManager.onEvent(StatServiceEvent.TRIGGLESMSPAY);
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
        if (interceptable == null || interceptable.invokeL(1048600, this, verify) == null) {
            StatisticManager.onEvent(StatServiceEvent.TRIGGER_SPEECH_VERIFY);
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
                StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_SHOW);
            }
            promptDialog.setNegativeBtn(guidance.operations[0].getActionName(), this.f26549g);
            promptDialog.setPositiveBtn(guidance.operations[1].getActionName(), this.f26551i);
        }
    }

    private void d(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, this, dialog, guidance) == null) {
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setCanceledOnTouchOutside(false);
            promptMultiBtnDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
            promptMultiBtnDialog.setFirstBtn(guidance.operations[0].getActionName(), this.f26551i);
            promptMultiBtnDialog.setSecondBtn(guidance.operations[1].getActionName(), this.f26550h);
            promptMultiBtnDialog.setThirdBtn(guidance.operations[2].getActionName(), this.f26549g);
        }
    }

    private void b(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, dialog, guidance) == null) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setTitleText(guidance.prompt_head);
            promptDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
            promptDialog.hidePositiveButton();
            promptDialog.setNegativeBtn(guidance.operations[0].getActionName(), this.f26549g);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getHasPwd(), str, StatHelper.getPayWay());
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
            if (PayDataCache.getInstance().isFromPreCashier()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY, collectData, hashMap);
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, collectData, hashMap);
                return;
            }
            if (StatHelper.isPrecashierPay(StatHelper.getOrderNo())) {
                hashMap.put("pay_category", "1");
            }
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY, collectData, hashMap);
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_SUCCESS, collectData, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            WalletGlobalUtils.safeDismissDialog(this, i2);
            onNegativeBtnClick();
        }
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method_name", "callNativeVoice");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("productId", "1200000005").put(LightInvokerImpl.LIVENESS_SERVIVETYPE, "1008").put(LightInvokerImpl.VOICE_ACTIONTYPE, "2").put(LightInvokerImpl.VOICE_BARSTYLE, "0");
                jSONObject.put(LightInvokerImpl.START_IDENTIFY, jSONObject2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if ((this instanceof PwdPayActivity) || (this instanceof WalletSmsActivity)) {
                finishWithoutAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LivingVerifyResultModel b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
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

    private void b(ErrorContentResponse.Verify verify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, verify) == null) {
            a(verify, false);
        }
    }

    private void a(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        ErrorContentResponse.Operations[] operationsArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, dialog, guidance) == null) || guidance == null || (operationsArr = guidance.operations) == null || operationsArr.length == 0) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        ErrorContentResponse.Guidance guidance;
        ErrorContentResponse.Operations[] operationsArr;
        ErrorContentResponse.Operations[] operationsArr2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || (guidance = this.mGuidance) == null || (operationsArr = guidance.operations) == null) {
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
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (this instanceof PwdPayActivity)) {
            finishWithoutAnim();
        }
    }

    private void a(ErrorContentResponse.Guidance guidance) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, guidance) == null) || guidance == null || guidance.operations == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ErrorContentResponse.Operations[] operationsArr = guidance.operations;
            if (i2 >= operationsArr.length) {
                return;
            }
            operationsArr[i2].registerActionHandler(ErrorContentResponse.Operations.SEND_SMS, new q(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26569a;

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
                    this.f26569a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        this.f26569a.a((ErrorContentResponse.Verify) null, true);
                        this.f26569a.a();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.LIVING_AGAIN, new q(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26570a;

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
                    this.f26570a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_RETRY);
                        this.f26570a.triggerLivingVerify();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.BIND_OTHER_CARDS, new q(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26571a;

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
                    this.f26571a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        PayBaseActivity payBaseActivity = this.f26571a;
                        if (payBaseActivity instanceof BindCardImplActivity) {
                            ((BindCardImplActivity) payBaseActivity).handleBindOtherCard();
                        }
                    }
                }
            });
            guidance.operations[i2].registerActionHandler("change_paytype", new q(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26553a;

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
                    this.f26553a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) {
                        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                        if (payRequest != null) {
                            payRequest.clearMktSolution();
                        }
                        PayController.getInstance().gotoPayTypePage(this.f26553a, false);
                        this.f26553a.b();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.RETRY_PAY, new q(this) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayBaseActivity f26554a;

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
                    this.f26554a = this;
                }

                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, obj, obj2) == null) && PayRequestCache.getInstance().isPaying()) {
                        BaiduPayDelegate.getInstance().reOrderPay(this.f26554a.getActivity());
                    }
                }
            });
            i2++;
        }
    }

    private void a(ErrorContentResponse.Verify verify) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, verify) == null) || verify == null) {
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
            triggerLivingVerify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorContentResponse.Verify verify, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, this, verify, z) == null) {
            triggerSmsVerify(verify, z, null, Integer.MIN_VALUE);
        }
    }

    private void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, this, str, i2, str2) == null) || com.baidu.wallet.paysdk.a.b.a()) {
            return;
        }
        String orderNo = StatHelper.getOrderNo();
        StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_SMS_ENTER, StatHelper.collectData(orderNo, i2 + "", str2, str));
    }
}
