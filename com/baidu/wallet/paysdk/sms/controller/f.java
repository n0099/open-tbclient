package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ag;
import com.baidu.wallet.paysdk.beans.ah;
import com.baidu.wallet.paysdk.beans.s;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.datamodel.VerifyByBankResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public CardData.BondCard f25461a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f25462b;

    /* renamed from: c  reason: collision with root package name */
    public PayBaseActivity f25463c;

    /* renamed from: d  reason: collision with root package name */
    public SmsUpdateUiInterface f25464d;

    /* renamed from: e  reason: collision with root package name */
    public ErrorContentResponse f25465e;

    /* renamed from: f  reason: collision with root package name */
    public String f25466f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f25467g;

    /* renamed from: h  reason: collision with root package name */
    public PwdRequest f25468h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.h f25469i;
    public y j;
    public boolean k = false;
    public String l = "";
    public ah m;
    public boolean n;

    private void c() {
        ag agVar = (ag) PayBeanFactory.getInstance().getBean((Context) this.f25463c, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
        agVar.setResponseCallback(this.f25463c);
        agVar.execBean();
    }

    private void d() {
        if (this.f25469i == null) {
            this.f25469i = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) this.f25463c, 5, ISmsController.BEAN_TAG);
        }
        PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
        if (PayRequestCache.getInstance().isBondPay()) {
            this.f25469i.a();
        }
        this.f25469i.a(PayRequestCache.getBindRequest(this.f25463c.getActivity()));
        this.f25469i.setResponseCallback(this.f25463c);
        this.f25469i.execBean();
    }

    private void e() {
        com.baidu.wallet.paysdk.beans.j jVar = (com.baidu.wallet.paysdk.beans.j) PayBeanFactory.getInstance().getBean((Context) this.f25463c, PayBeanFactory.BEAN_ID_CREDIT_PAY, ISmsController.BEAN_TAG);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CREDIT_PAY);
        jVar.setResponseCallback(this.f25463c);
        jVar.execBean();
    }

    private void f() {
        com.baidu.wallet.paysdk.beans.a aVar = (com.baidu.wallet.paysdk.beans.a) PayBeanFactory.getInstance().getBean((Context) this.f25463c, 14, ISmsController.BEAN_TAG);
        aVar.setResponseCallback(this.f25463c);
        aVar.execBean();
    }

    private void g() {
        PayStatisticsUtil.onEvent(this.n ? StatServiceEvent.EVENT_CONFIRM_PAY_FROM_SMS_VERIFY : StatServiceEvent.EVENT_CONFIRM_PAY_BY_SMS);
        StatisticManager.onEventStart(StatServiceEvent.TIME_PAY);
        if (this.j == null) {
            this.j = (y) PayBeanFactory.getInstance().getBean((Context) this.f25463c, 13, ISmsController.BEAN_TAG);
        }
        this.j.setResponseCallback(this.f25463c);
        if (PayRequestCache.getInstance().isBondPay()) {
            this.j.a(true);
        }
        this.j.b(this.f25463c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
        this.j.execBean();
    }

    private String h() {
        CardData.BondCard bondCard;
        if (TextUtils.isEmpty(this.f25466f)) {
            if (PayRequestCache.getInstance().isBondPay() && (bondCard = this.f25461a) != null) {
                return bondCard.mobile;
            }
            return ((BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name())).getSendSmsphone();
        }
        return SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.f25466f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        PayRequest payRequest = this.f25462b;
        if (payRequest != null) {
            if (payRequest.mMktSolution != null) {
                return String.format(ResUtils.getString(this.f25463c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25462b.mMktSolution.easypay_amount));
            }
            return String.format(ResUtils.getString(this.f25463c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25462b.getFinalPayAmount()));
        }
        return "";
    }

    private void j() {
        if (5320 != this.f25463c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) || this.f25464d == null) {
            return;
        }
        ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.f25463c.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
        this.f25464d.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        if (i3 != 80320 && i3 != 80321 && i3 != 80326 && i3 != 80327) {
            if (i3 == 15500 && obj != null && (obj instanceof ErrorContentResponse)) {
                this.l = str;
                PayBaseActivity payBaseActivity = this.f25463c;
                payBaseActivity.mPayErrorCode = i3;
                payBaseActivity.mBeanId = i2;
                this.f25465e = (ErrorContentResponse) obj;
                WalletGlobalUtils.safeDismissDialog(payBaseActivity, 0);
                WalletGlobalUtils.safeShowDialog(this.f25463c, 65316, "");
                return true;
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
        PayDataCache.getInstance().cleanDetainmentDesc();
        if (obj instanceof ErrorContentResponse) {
            this.f25465e = (ErrorContentResponse) obj;
            if (!TextUtils.isEmpty(str)) {
                this.l = str;
                PayBaseActivity payBaseActivity2 = this.f25463c;
                payBaseActivity2.mPayErrorCode = i3;
                payBaseActivity2.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(payBaseActivity2, ISmsController.DIALOG_CANNOT_DISCOUNT, "");
            }
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        if (i2 == 65315) {
            return new PromptMultiBtnDialog(this.f25463c.getActivity());
        }
        if (i2 == 65316) {
            return new PromptMultiBtnDialog(this.f25463c.getActivity());
        }
        return null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        this.f25463c = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        switch (i2) {
            case ISmsController.DIALOG_CANNOT_DISCOUNT /* 65315 */:
                return b((PromptMultiBtnDialog) dialog);
            case 65316:
                return a((PromptMultiBtnDialog) dialog);
            case ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH /* 65317 */:
                return a((PromptDialog) dialog);
            default:
                return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("mPwdRequest", this.f25468h);
        bundle.putSerializable("mPayRequest", this.f25462b);
        bundle.putBoolean("mPayBySmsCode", this.n);
        bundle.putSerializable("mCardInfoUpdateContent", this.f25465e);
        bundle.putString("phone_no", this.f25466f);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        PayBaseActivity payBaseActivity;
        if (i2 == 5) {
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, i3);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25463c.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            a(i3, str);
            return true;
        } else if (i2 != 13 && i2 != 14 && i2 != 263) {
            if (i2 == 9 || i2 == 264) {
                a(i3, str);
                return true;
            }
            return false;
        } else {
            WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25463c.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == 60500) {
                this.l = str;
                PayBaseActivity payBaseActivity2 = this.f25463c;
                payBaseActivity2.mPayErrorCode = i3;
                payBaseActivity2.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(payBaseActivity2, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH, "");
            } else if (65312 == i3) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_65312_ON_FP_SMSACT);
                if (this.f25462b != null && (payBaseActivity = this.f25463c) != null) {
                    GlobalUtils.toast(payBaseActivity, ResUtils.getString(payBaseActivity, "bd_wallet_fingerprint_auth_failed"));
                }
                PayBaseActivity payBaseActivity3 = this.f25463c;
                if (payBaseActivity3 != null) {
                    payBaseActivity3.finish();
                }
            } else {
                SmsVerifyHandler smsVerifyHandler = this.f25467g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifyFailure(i3, str);
                }
            }
            StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, i3);
            StatisticManager.onEventWithValue(StatServiceEvent.ONE_KEY_PAY_ACCEPT_FAIL, String.valueOf(i3));
            return true;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        if (i2 == 5) {
            WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
            return e(obj);
        } else if (i2 == 13) {
            StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, 0);
            SmsVerifyHandler smsVerifyHandler = this.f25467g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifySuccess();
            }
            return false;
        } else if (i2 == 9) {
            WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
            return d(obj);
        } else if (i2 == 14) {
            WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
            return c(obj);
        } else if (i2 == 263) {
            SmsVerifyHandler smsVerifyHandler2 = this.f25467g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifySuccess();
            }
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CREDIT_PAY, 0);
            return false;
        } else if (i2 == 264) {
            WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
            return b(obj);
        } else if (i2 == 15) {
            return a(obj);
        } else {
            return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f25463c, "ebpay_submit_pay");
        PayRequest payRequest = this.f25462b;
        if (payRequest != null) {
            if (payRequest.mMktSolution != null) {
                string = String.format(ResUtils.getString(this.f25463c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25462b.mMktSolution.easypay_amount));
            } else {
                string = String.format(ResUtils.getString(this.f25463c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25462b.getFinalPayAmount()));
            }
        }
        String str = string;
        PayRequest payRequest2 = this.f25462b;
        if (payRequest2 != null) {
            this.f25461a = payRequest2.mBondCard;
            if (this.f25464d != null) {
                this.f25464d.initSMSActivityView("ebpay_sms_title_tip_security_check", this.n ? ResUtils.getString(this.f25463c, "ebpay_sms_pwd_error_tip") : "", str, h(), true);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        j();
        return 5320 != this.f25463c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("mPwdRequest");
            if (serializable != null && (serializable instanceof PwdRequest)) {
                this.f25468h = (PwdRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.f25462b = (PayRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("payBySmsCode");
            if (serializable3 != null && (serializable3 instanceof Boolean)) {
                this.n = ((Boolean) serializable3).booleanValue();
            }
            Serializable serializable4 = bundle.getSerializable("mCardInfoUpdateContent");
            if (serializable4 != null && (serializable4 instanceof ErrorContentResponse)) {
                this.f25465e = (ErrorContentResponse) serializable4;
            }
            this.f25466f = bundle.getString("phone_no");
        } else {
            this.f25468h = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            this.f25462b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            this.n = this.f25463c.getIntent().getBooleanExtra("pay_by_smscode", false);
            Serializable serializableExtra = this.f25463c.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            if (serializableExtra != null) {
                this.f25466f = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
            }
        }
        if (this.f25462b != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f25462b.getRequestId(), this.f25462b);
            if (this.f25468h != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f25468h.getRequestId(), this.f25468h);
            }
            this.k = isSendSmsOnCreate();
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.f25463c, "SmsControllerForPaySMS.onCreateCheckInvalide().1");
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        if (bindFastRequest != null) {
            bindFastRequest.mSmsVCode = str;
        }
        PayRequest payRequest = this.f25462b;
        if (payRequest != null) {
            payRequest.mSmsCode = str;
        }
        WalletGlobalUtils.safeShowDialog(this.f25463c, 0, "");
        PayRequest.PayPrice.PayType b2 = b();
        if (b2 == PayRequest.PayPrice.PayType.BANKCARD) {
            g();
        } else if (b2 == PayRequest.PayPrice.PayType.BALANCE) {
            f();
        } else if (b2 == PayRequest.PayPrice.PayType.CREIDT) {
            e();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity = this.f25463c;
        if (payBaseActivity == null) {
            return;
        }
        if (this.k) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f25463c.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
            c();
            return;
        }
        PayRequest.PayPrice.PayType b2 = b();
        if (b2 == PayRequest.PayPrice.PayType.BANKCARD) {
            d();
        } else if (b2 == PayRequest.PayPrice.PayType.BALANCE || b2 == PayRequest.PayPrice.PayType.CREIDT) {
            a(b2);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25463c = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25464d = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f25467g = smsVerifyHandler;
    }

    private String b(PayRequest.PayPrice.PayType payType) {
        ArrayList arrayList = new ArrayList();
        if (payType == PayRequest.PayPrice.PayType.BALANCE) {
            arrayList.addAll(PayDataCache.getInstance().getBalancePayPostInfo());
        } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
            arrayList.addAll(PayDataCache.getInstance().getCreditPayPostInfo());
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if ("pay_type".equals(((RestNameValuePair) arrayList.get(i2)).getName())) {
                return ((RestNameValuePair) arrayList.get(i2)).getValue();
            }
        }
        return "";
    }

    private void a(PayRequest.PayPrice.PayType payType) {
        String str = this.f25466f;
        PayRequest payRequest = this.f25462b;
        com.baidu.wallet.paysdk.datamodel.d dVar = new com.baidu.wallet.paysdk.datamodel.d(str, payRequest.mSpNO, payRequest.mOrderNo, b(payType));
        PayRequestCache.getInstance().addBeanRequestToCache(dVar.getRequestId(), dVar);
        if (this.m == null) {
            this.m = (ah) PayBeanFactory.getInstance().getBean((Context) this.f25463c, 9, ISmsController.BEAN_TAG);
        }
        this.m.setResponseCallback(this.f25463c);
        this.m.execBean();
    }

    private boolean c(Object obj) {
        SmsVerifyHandler smsVerifyHandler = this.f25467g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsVerifySuccess();
        }
        if (obj != null && (obj instanceof BalancePayResponse)) {
            BalancePayResponse balancePayResponse = (BalancePayResponse) obj;
            PayStatisticsUtil.onEvent("paySuccess");
            PayResultContent payResultContent = new PayResultContent();
            payResultContent.notify = balancePayResponse.notify;
            payResultContent.paytype_desc = balancePayResponse.paytype_desc;
            payResultContent.coupon_msg = balancePayResponse.coupon_msg;
            BalancePayResponse.Business business = balancePayResponse.business;
            if (business != null) {
                String str = business.stream_recharge_msg;
                if (str != null) {
                    payResultContent.stream_recharge_msg = str;
                }
                String str2 = balancePayResponse.business.expected_time;
                if (str2 != null) {
                    payResultContent.expected_time = str2;
                }
            }
            payResultContent.coupon_find_prompt = balancePayResponse.coupon_find_prompt;
            payResultContent.total_amount = balancePayResponse.total_amount;
            payResultContent.cash_amount = balancePayResponse.cash_amount;
            payResultContent.discount_amount = balancePayResponse.discount_amount;
            payResultContent.pay_detail_info = balancePayResponse.pay_detail_info;
            payResultContent.paytype_info = balancePayResponse.paytype_info;
            payResultContent.order_no = balancePayResponse.order_no;
            AuthorizeInfo authorizeInfo = balancePayResponse.authorize_info;
            payResultContent.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
            payResultContent.order_prefix = balancePayResponse.order_prefix;
            payResultContent.discount_prefix = balancePayResponse.discount_prefix;
            payResultContent.payResultCashbackDetail = balancePayResponse.cashback_dialog_detail;
            payResultContent.feedback_info = balancePayResponse.feedback_info;
            payResultContent.trans_no = balancePayResponse.trans_no;
            payResultContent.redirect_sp_succpage_remain_time = balancePayResponse.redirect_sp_succpage_remain_time;
            payResultContent.fp_open_or_update_msg = balancePayResponse.fp_open_or_update_msg;
            payResultContent.compliance = balancePayResponse.compliance;
            StatHelper.cachePayAmount(Double.valueOf(balancePayResponse.cash_amount).doubleValue());
            a("1");
            if (balancePayResponse.toShowH5ResultPage()) {
                PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(balancePayResponse.redirect_sp_succpage_remain_time, balancePayResponse.pay_result_url, balancePayResponse.pay_result_params, balancePayResponse.show_h5_result, CashierDeskPayResult.PayScenario.BalancedPay));
            }
            PayController.getInstance().paySucess(this.f25463c, payResultContent, 1);
        }
        return true;
    }

    private boolean e(Object obj) {
        CheckCardInfoResponse checkCardInfoResponse;
        PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, 0);
        if (obj == null || !(obj instanceof CheckCardInfoResponse)) {
            checkCardInfoResponse = null;
        } else {
            checkCardInfoResponse = (CheckCardInfoResponse) obj;
            PayRequest payRequest = this.f25462b;
            if (payRequest != null) {
                payRequest.mChannelNo = checkCardInfoResponse.channel_no;
            }
        }
        this.k = false;
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25464d;
        if (smsUpdateUiInterface != null && checkCardInfoResponse != null) {
            smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
            this.f25464d.updateModifyPhoneUI(!TextUtils.isEmpty(checkCardInfoResponse.update_mobile_desc), checkCardInfoResponse.update_mobile_desc);
        }
        SmsVerifyHandler smsVerifyHandler = this.f25467g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendSuccess();
        }
        return true;
    }

    private boolean d(Object obj) {
        VerifyCodeResponse verifyCodeResponse = obj instanceof VerifyCodeResponse ? (VerifyCodeResponse) obj : null;
        if (this.k) {
            this.k = false;
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25464d;
        if (smsUpdateUiInterface != null && verifyCodeResponse != null) {
            smsUpdateUiInterface.upDateSafeKeyBoradView(verifyCodeResponse.sms_length, verifyCodeResponse.sms_type);
        }
        SmsVerifyHandler smsVerifyHandler = this.f25467g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendSuccess();
            return true;
        }
        return true;
    }

    private boolean b(Object obj) {
        VerifyByBankResponse verifyByBankResponse = obj instanceof VerifyByBankResponse ? (VerifyByBankResponse) obj : null;
        if (this.k) {
            this.k = false;
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25464d;
        if (smsUpdateUiInterface != null && verifyByBankResponse != null) {
            smsUpdateUiInterface.upDateSafeKeyBoradView(verifyByBankResponse.sms_length, verifyByBankResponse.sms_type);
        }
        SmsVerifyHandler smsVerifyHandler = this.f25467g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendSuccess();
            return true;
        }
        return true;
    }

    private boolean a(Object obj) {
        if (obj instanceof GetCardInfoResponse) {
            this.f25463c.finishWithoutAnim();
            PayController.getInstance().completeCardPay(this.f25463c, this.f25462b.mBondCard, (GetCardInfoResponse) obj);
            return true;
        }
        return false;
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

    private boolean b(PromptMultiBtnDialog promptMultiBtnDialog) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
        promptMultiBtnDialog.setMessage(this.l);
        promptMultiBtnDialog.setFirstBtn(ResUtils.getString(this.f25463c, "bd_wallet_pay_by_order_price"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = f.this.f25463c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                f fVar = f.this;
                ErrorContentResponse errorContentResponse = fVar.f25465e;
                if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                    return;
                }
                if (fVar.f25469i == null) {
                    f.this.f25469i = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) f.this.f25463c, 5, ISmsController.BEAN_TAG);
                }
                ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(f.this.f25465e.mkt_solution);
                PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
                if (PayRequestCache.getInstance().isBondPay()) {
                    f.this.f25469i.a();
                }
                f.this.f25469i.setResponseCallback(f.this.f25463c);
                f.this.f25469i.execBean();
                WalletGlobalUtils.safeShowDialog(f.this.f25463c, 0, "");
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                f fVar2 = f.this;
                if (fVar2.f25464d != null) {
                    String i2 = fVar2.i();
                    if (!TextUtils.isEmpty(i2)) {
                        f.this.f25464d.updateButtonTip(i2);
                    }
                }
                SmsUpdateUiInterface smsUpdateUiInterface = f.this.f25464d;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.clearSmsEditText();
                    f.this.f25464d.doStartCountDown();
                }
            }
        });
        promptMultiBtnDialog.setSecondBtn(ResUtils.getString(this.f25463c, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = f.this.f25463c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, ISmsController.DIALOG_CANNOT_DISCOUNT);
                PayController.getInstance().gotoPayTypePage(f.this.f25463c, false);
                f.this.f25463c.finish();
            }
        });
        promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.f25463c.addDoPayorCheckCardStatistics("取消");
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, ISmsController.DIALOG_CANNOT_DISCOUNT);
            }
        });
        return true;
    }

    public PayRequest.PayPrice.PayType b() {
        return this.f25462b.getPayPrice().payType;
    }

    private void a(int i2, String str) {
        WalletGlobalUtils.safeDismissDialog(this.f25463c, 0);
        if (this.k) {
            this.k = false;
        }
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.f25463c.getActivity(), "ebpay_send_fail");
        }
        SmsVerifyHandler smsVerifyHandler = this.f25467g;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendFailure(i2, str);
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25464d;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.clearSmsEditText();
            this.f25464d.doStopCountDown();
        }
    }

    private boolean a(PromptMultiBtnDialog promptMultiBtnDialog) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_CARD_UPDATE);
        promptMultiBtnDialog.setMessage(this.l);
        promptMultiBtnDialog.setFirstBtn(ResUtils.string(this.f25463c, "ebpay_wallet_continue_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = f.this.f25463c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                BindFastRequest bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 2;
                PayRequest payRequest = f.this.f25462b;
                if (payRequest != null) {
                    bindFastRequest.mBondCard = payRequest.mBondCard;
                }
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, 65316);
                PayController payController = PayController.getInstance();
                f fVar = f.this;
                payController.updateCardInfoPay(fVar.f25463c, fVar.f25465e);
                f.this.f25463c.finishWithoutAnim();
            }
        });
        promptMultiBtnDialog.setSecondBtn(ResUtils.string(this.f25463c, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (payRequest != null) {
                    payRequest.clearMktSolution();
                }
                PayBaseActivity payBaseActivity = f.this.f25463c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, 65316);
                PayController.getInstance().gotoPayTypePage(f.this.f25463c, false);
                f.this.f25463c.finishWithoutAnim();
            }
        });
        promptMultiBtnDialog.setThirdBtn("取消", new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.f25463c.addDoPayorCheckCardStatistics("取消");
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, 65316);
            }
        });
        return true;
    }

    private boolean a(PromptDialog promptDialog) {
        promptDialog.setMessage(this.l);
        promptDialog.setNegativeBtn(ResUtils.getString(this.f25463c, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = f.this.f25463c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_know"));
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH);
            }
        });
        promptDialog.setPositiveBtn(ResUtils.getString(this.f25463c, "ebpay_use_other_paytype"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.f.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayBaseActivity payBaseActivity = f.this.f25463c;
                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_use_other_paytype"));
                WalletGlobalUtils.safeDismissDialog(f.this.f25463c, ISmsController.DIALOG_CARDBALANCE_NOT_ENOUGH);
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (payRequest != null) {
                    payRequest.clearMktSolution();
                }
                PayController.getInstance().gotoPayTypePage(f.this.f25463c, false);
                f.this.f25463c.finish();
            }
        });
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.a
    public void a() {
        s sVar = (s) PayBeanFactory.getInstance().getBean((Context) this.f25463c, 15, ISmsController.BEAN_TAG);
        sVar.setResponseCallback(this.f25463c);
        WalletGlobalUtils.safeShowDialog(this.f25463c, 0, "");
        sVar.execBean();
    }
}
