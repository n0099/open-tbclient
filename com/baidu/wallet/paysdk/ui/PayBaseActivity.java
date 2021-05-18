package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
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
    public static final int QUERY_DELTA_FOR_EASY = 3000;
    public static final int QUERY_TIME_FOR_EASY = 20000;
    public static final int REQUEST_CODE = 1000;

    /* renamed from: a  reason: collision with root package name */
    public z f25776a;

    /* renamed from: b  reason: collision with root package name */
    public PayQueryRequest f25777b;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.wallet.paysdk.b f25779d;

    /* renamed from: e  reason: collision with root package name */
    public CountDownTimer f25780e;
    public ErrorContentResponse mErrorContent;
    public ErrorContentResponse.Guidance mGuidance;
    public int mPayErrorCode;
    public int mBeanId = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25778c = false;

    /* renamed from: f  reason: collision with root package name */
    public long f25781f = 0;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f25782g = new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorContentResponse.Operations[] operationsArr = PayBaseActivity.this.mGuidance.operations;
            if (operationsArr.length < 1) {
                return;
            }
            int i2 = operationsArr.length >= 3 ? 2 : 0;
            PayBaseActivity.this.a(i2);
            PayBaseActivity.this.onNegativeBtnClick();
            if (PayBaseActivity.this.mGuidance.operations[i2].getAction() != null) {
                q action = PayBaseActivity.this.mGuidance.operations[i2].getAction();
                PayBaseActivity payBaseActivity = PayBaseActivity.this;
                action.a(payBaseActivity.mGuidance.operations[i2], payBaseActivity.mAct);
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f25783h = new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayBaseActivity payBaseActivity = PayBaseActivity.this;
            if (payBaseActivity.mGuidance.operations.length < 2) {
                return;
            }
            payBaseActivity.a(1);
            if (PayBaseActivity.this.mGuidance.operations[1].getAction() != null) {
                q action = PayBaseActivity.this.mGuidance.operations[1].getAction();
                PayBaseActivity payBaseActivity2 = PayBaseActivity.this;
                action.a(payBaseActivity2.mGuidance.operations[1], payBaseActivity2.mAct);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f25784i = new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorContentResponse.Operations[] operationsArr = PayBaseActivity.this.mGuidance.operations;
            if (operationsArr.length < 2) {
                return;
            }
            int i2 = operationsArr.length >= 3 ? 0 : 1;
            PayBaseActivity.this.a(i2);
            if (PayBaseActivity.this.mGuidance.operations[i2].getAction() != null) {
                q action = PayBaseActivity.this.mGuidance.operations[i2].getAction();
                PayBaseActivity payBaseActivity = PayBaseActivity.this;
                action.a(payBaseActivity.mGuidance.operations[i2], payBaseActivity.mAct);
            }
        }
    };

    public void addDoPayorCheckCardStatistics(String str) {
        int i2 = this.mBeanId;
        String str2 = BeanConstants.API_DO_PAY;
        if (i2 != 14 && i2 != 263 && (i2 != 13 || com.baidu.wallet.paysdk.a.b.a())) {
            str2 = (this.mBeanId == 5 && h.f25220a == 1) ? BeanConstants.API_CHECK_CARD_INFO : "";
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

    public void doLivingPay() {
    }

    public void handleErrorContent() {
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        if (i2 == 12) {
            this.f25778c = false;
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
                CountDownTimer countDownTimer = this.f25780e;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    this.f25780e = null;
                }
                PayController.getInstance().payPaying(this, payResultContent, com.baidu.wallet.paysdk.a.b.a() ? 4 : 1);
                return;
            }
            LogUtil.logd("mTimeAmount=" + this.f25781f);
            if (this.f25781f == 0) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PayController.getInstance().payPaying(this, payResultContent, com.baidu.wallet.paysdk.a.b.a() ? 4 : 1);
                StatisticManager.onEventWithValue(StatServiceEvent.QUERY_PAY_RESULT_FAIL, String.valueOf(i3));
                return;
            }
            return;
        }
        super.handleFailure(i2, i3, str);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        String str2;
        if (i2 == 13 || i2 == 263) {
            PayResponse payResponse = (PayResponse) obj;
            if (payResponse != null && payResponse.checkResponseValidity()) {
                if (i2 != 13) {
                    StatisticManager.onEventEnd(StatServiceEvent.CREDIT_PAY, 0);
                }
                if (this.f25777b == null) {
                    this.f25777b = new PayQueryRequest();
                }
                PayQueryRequest payQueryRequest = this.f25777b;
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
                    this.f25777b.mName = PayQueryRequest.EASYPAY_NAME;
                    PayDataCache.getInstance().setSignSuccessTips(payResponse.sign_success_tips);
                    PayDataCache.getInstance().setAccountBankCard(payResponse.account_bank_card);
                } else if (i2 == 263) {
                    this.f25777b.mName = PayQueryRequest.CRDDITPAY_NAME;
                } else {
                    this.f25777b.mName = PayQueryRequest.EASYPAY_NAME;
                }
                if (payResponse.toShowH5ResultPage()) {
                    PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(payResponse.redirect_sp_succpage_remain_time, payResponse.pay_result_url, payResponse.pay_result_params, payResponse.show_h5_result, CashierDeskPayResult.PayScenario.BankcardPay));
                }
                PayRequestCache.getInstance().addBeanRequestToCache(this.f25777b.getRequestId(), this.f25777b);
                queryPayResult();
            }
            stopCountDown();
        } else if (i2 == 12) {
            this.f25778c = false;
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
                CountDownTimer countDownTimer = this.f25780e;
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
            LogUtil.logd("mTimeAmount====" + this.f25781f);
            if (this.f25781f == 0) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                StatisticManager.onEvent(StatServiceEvent.QUERY_PAY_RESULT_FAIL);
                showPaySuccessPage(false, new PayResultContent(), 1);
            }
        }
    }

    public void hideFullScreenLoading() {
    }

    public boolean isBindPay() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        ErrorContentResponse errorContentResponse;
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        if (bundle != null && (serializable = bundle.getSerializable("mCardInfoUpdateContent")) != null && (serializable instanceof ErrorContentResponse)) {
            this.mErrorContent = (ErrorContentResponse) serializable;
        }
        setFlagPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        ErrorContentResponse.Guidance guidance;
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.f25780e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f25780e = null;
        }
        BeanManager.getInstance().removeAllBeans("PayBaseActivity");
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"ev_bean_execut_err_content".equals(event.mEventKey)) {
            return;
        }
        Object obj = event.mEventObj;
        if (obj instanceof BeanErrorContent) {
            BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
            onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
            EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
        }
    }

    public void onNegativeBtnClick() {
    }

    public void onOtherPayTypeClick(int i2) {
        WalletGlobalUtils.safeDismissDialog(this, i2);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
        EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        CardData.BondCard bondCard;
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
            promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_abandom_pay_comfirm"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!PayDataCache.getInstance().isFromPreCashier()) {
                        List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                        HashMap hashMap = new HashMap();
                        hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                        hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                        StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_CANCEL, collectData, hashMap);
                    }
                    StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONFIRM_IN_QUIT_DIALOG);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 18);
                    PayCallBackManager.callBackClientCancel(PayBaseActivity.this, "PayBaseActivity.onPrepareDialog().1");
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CANCEL_IN_QUIT_DIALOG);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 18);
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
            promptMultiBtnDialog.setFirstBtn(ResUtils.string(this, "ebpay_wallet_continue_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                    StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 34);
                    PayController payController = PayController.getInstance();
                    PayBaseActivity payBaseActivity2 = PayBaseActivity.this;
                    payController.updateCardInfoPay(payBaseActivity2, payBaseActivity2.mErrorContent);
                    PayBaseActivity.this.finishWithoutAnim();
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.string(this, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                    PayRequest payRequest3 = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                    if (payRequest3 != null) {
                        payRequest3.clearMktSolution();
                    }
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 34);
                    PayController.getInstance().gotoPayTypePage(PayBaseActivity.this, false);
                    PayBaseActivity.this.finishWithoutAnim();
                }
            });
            promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayBaseActivity.this.addDoPayorCheckCardStatistics("取消");
                    PayBaseActivity.this.b(34);
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    if (payBaseActivity instanceof WalletSmsActivity) {
                        payBaseActivity.finishWithoutAnim();
                    }
                }
            });
        } else if (i2 == 35) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
            PromptMultiBtnDialog promptMultiBtnDialog2 = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog2.setMessage(this.mDialogMsg);
            promptMultiBtnDialog2.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 35);
                    PayBaseActivity.this.handleErrorContent();
                }
            });
            promptMultiBtnDialog2.setSecondBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity.getActivity(), "ebpay_use_other_paytype"));
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this, 35);
                    PayController.getInstance().gotoPayTypePage(PayBaseActivity.this, false);
                    PayBaseActivity.this.finishWithoutAnim();
                }
            });
            promptMultiBtnDialog2.setThirdBtn("取消", new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayBaseActivity.this.addDoPayorCheckCardStatistics("取消");
                    PayBaseActivity.this.b(35);
                }
            });
        } else if (i2 == 54) {
            StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_SHOW);
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setMessage(ResUtils.getString(this.mAct, "wallet_base_finish_living_verify"));
            promptDialog2.setNegativeBtn(ResUtils.getString(this.mAct, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 54);
                    PayBaseActivity.this.onNegativeBtnClick();
                }
            });
            promptDialog2.setPositiveBtn(ResUtils.getString(this.mAct, "wallet_base_revalidation"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseActivity.this.mAct, 54);
                    StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_RETRY);
                    PayBaseActivity.this.triggerLivingVerify();
                }
            });
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
        EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        ErrorContentResponse errorContentResponse = this.mErrorContent;
        if (errorContentResponse != null) {
            bundle.putSerializable("mCardInfoUpdateContent", errorContentResponse);
        }
        super.onSaveInstanceState(bundle);
    }

    public void queryPayResult() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            StatisticManager.onEventWithValue("paySuccess", payRequest != null ? payRequest.mSpNO : "");
        }
        if (this.f25776a == null) {
            this.f25776a = (z) PayBeanFactory.getInstance().getBean((Context) this, 12, "PayBaseActivity");
        }
        this.f25778c = true;
        this.f25776a.setResponseCallback(this);
        this.f25776a.execBean();
        CountDownTimer countDownTimer = this.f25780e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f25780e = null;
        }
        long j = this.f25781f;
        if (j <= 0) {
            j = 20000;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(j, 3000L) { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                PayBaseActivity.this.f25781f = 0L;
                if (PayBaseActivity.this.f25778c) {
                    LogUtil.logd("######. onFinish. query return = " + System.currentTimeMillis());
                    return;
                }
                PayBaseActivity.this.f25778c = true;
                PayBaseActivity.this.f25776a.setResponseCallback(PayBaseActivity.this);
                PayBaseActivity.this.f25776a.execBean();
                LogUtil.logd("######. onTick. query = " + System.currentTimeMillis());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                PayBaseActivity.this.f25781f = j2;
                if (PayBaseActivity.this.f25778c) {
                    LogUtil.logd("######. onTick. query return = " + System.currentTimeMillis());
                    return;
                }
                LogUtil.logd("######. onTick. query = " + System.currentTimeMillis() + " , remain millis = " + j2);
                PayBaseActivity.this.f25778c = true;
                PayBaseActivity.this.f25776a.setResponseCallback(PayBaseActivity.this);
                PayBaseActivity.this.f25776a.execBean();
            }
        };
        this.f25780e = countDownTimer2;
        countDownTimer2.start();
    }

    public abstract void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2);

    public void stopCountDown() {
    }

    public void triggerCardItemVerify(ErrorContentResponse.Verify verify) {
        String[] strArr;
        if (verify == null || (strArr = verify.card_item_required) == null || strArr.length < 1) {
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
        StatisticManager.onEvent(StatServiceEvent.TRIGGERLIVINGVERIFY);
        hideFullScreenLoading();
        if (this.f25779d == null) {
            this.f25779d = new com.baidu.wallet.paysdk.b(StatServiceEvent.CALL_NATIVE_VOICE_FAIL_BY_CASHDESK);
        }
        this.f25779d.a(this.mAct, c(), new ILightappInvokerCallback() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.13
            @Override // com.baidu.wallet.api.ILightappInvokerCallback
            public void onResult(int i2, String str) {
                LivingVerifyResultModel.Cnt cnt;
                int i3;
                LivingVerifyResultModel.Result result;
                LivingVerifyResultModel.Cnt cnt2;
                LivingVerifyResultModel b2 = PayBaseActivity.this.b(str);
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
                    PayBaseActivity.this.doLivingPay();
                } else if (b2 == null || (cnt = b2.cnt) == null || (i3 = cnt.errCode) == Integer.MIN_VALUE) {
                } else {
                    StatisticManager.onEventWithValue(StatServiceEvent.TRIGGER_LIVING_VERIFY_FAIL, String.valueOf(i3));
                    if (b2.cnt.errCode == LivingVerifyResultModel.ERRORCODECANCEL) {
                        WalletGlobalUtils.safeShowDialog(PayBaseActivity.this.mAct, 54, "");
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
                    PayBaseActivity.this.doLivingPay();
                }
            }
        });
    }

    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z, String str, int i2) {
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

    public void triggerSpeechVerify(ErrorContentResponse.Verify verify) {
        StatisticManager.onEvent(StatServiceEvent.TRIGGER_SPEECH_VERIFY);
        Intent intent = new Intent();
        intent.setClass(this, VoiceVerifyActivity.class);
        intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
        intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
        startActivityWithoutAnim(intent);
    }

    private void c(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        PromptDialog promptDialog = (PromptDialog) dialog;
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setTitleText(guidance.prompt_head);
        promptDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
        if (TextUtils.equals(ErrorContentResponse.Operations.LIVING_AGAIN, guidance.operations[1].type)) {
            StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_SHOW);
        }
        promptDialog.setNegativeBtn(guidance.operations[0].getActionName(), this.f25782g);
        promptDialog.setPositiveBtn(guidance.operations[1].getActionName(), this.f25784i);
    }

    private void d(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
        promptMultiBtnDialog.setCanceledOnTouchOutside(false);
        promptMultiBtnDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
        promptMultiBtnDialog.setFirstBtn(guidance.operations[0].getActionName(), this.f25784i);
        promptMultiBtnDialog.setSecondBtn(guidance.operations[1].getActionName(), this.f25783h);
        promptMultiBtnDialog.setThirdBtn(guidance.operations[2].getActionName(), this.f25782g);
    }

    private void b(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        PromptDialog promptDialog = (PromptDialog) dialog;
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setTitleText(guidance.prompt_head);
        promptDialog.setMessage(StringUtil.parseColorString(guidance.prompt_body));
        promptDialog.hidePositiveButton();
        promptDialog.setNegativeBtn(guidance.operations[0].getActionName(), this.f25782g);
    }

    private void a(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        WalletGlobalUtils.safeDismissDialog(this, i2);
        onNegativeBtnClick();
    }

    private String c() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if ((this instanceof PwdPayActivity) || (this instanceof WalletSmsActivity)) {
            finishWithoutAnim();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LivingVerifyResultModel b(String str) {
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

    private void b(ErrorContentResponse.Verify verify) {
        a(verify, false);
    }

    private void a(Dialog dialog, ErrorContentResponse.Guidance guidance) {
        ErrorContentResponse.Operations[] operationsArr;
        if (guidance == null || (operationsArr = guidance.operations) == null || operationsArr.length == 0) {
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
        ErrorContentResponse.Operations[] operationsArr;
        ErrorContentResponse.Operations[] operationsArr2;
        boolean z;
        ErrorContentResponse.Guidance guidance = this.mGuidance;
        if (guidance == null || (operationsArr = guidance.operations) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this instanceof PwdPayActivity) {
            finishWithoutAnim();
        }
    }

    private void a(ErrorContentResponse.Guidance guidance) {
        if (guidance == null || guidance.operations == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            ErrorContentResponse.Operations[] operationsArr = guidance.operations;
            if (i2 >= operationsArr.length) {
                return;
            }
            operationsArr[i2].registerActionHandler(ErrorContentResponse.Operations.SEND_SMS, new q() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.7
                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    PayBaseActivity.this.a((ErrorContentResponse.Verify) null, true);
                    PayBaseActivity.this.a();
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.LIVING_AGAIN, new q() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.8
                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    StatisticManager.onEvent(StatServiceEvent.LIVING_VERIFY_DIALOG_RETRY);
                    PayBaseActivity.this.triggerLivingVerify();
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.BIND_OTHER_CARDS, new q() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.9
                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    PayBaseActivity payBaseActivity = PayBaseActivity.this;
                    if (payBaseActivity instanceof BindCardImplActivity) {
                        ((BindCardImplActivity) payBaseActivity).handleBindOtherCard();
                    }
                }
            });
            guidance.operations[i2].registerActionHandler("change_paytype", new q() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.10
                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                    if (payRequest != null) {
                        payRequest.clearMktSolution();
                    }
                    PayController.getInstance().gotoPayTypePage(PayBaseActivity.this, false);
                    PayBaseActivity.this.b();
                }
            });
            guidance.operations[i2].registerActionHandler(ErrorContentResponse.Operations.RETRY_PAY, new q() { // from class: com.baidu.wallet.paysdk.ui.PayBaseActivity.11
                @Override // com.baidu.wallet.paysdk.beans.q
                public void a(Object obj, Object obj2) {
                    if (PayRequestCache.getInstance().isPaying()) {
                        BaiduPayDelegate.getInstance().reOrderPay(PayBaseActivity.this.getActivity());
                    }
                }
            });
            i2++;
        }
    }

    private void a(ErrorContentResponse.Verify verify) {
        if (verify == null) {
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
        triggerSmsVerify(verify, z, null, Integer.MIN_VALUE);
    }

    private void a(String str, int i2, String str2) {
        if (com.baidu.wallet.paysdk.a.b.a()) {
            return;
        }
        String orderNo = StatHelper.getOrderNo();
        StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_SMS_ENTER, StatHelper.collectData(orderNo, i2 + "", str2, str));
    }
}
