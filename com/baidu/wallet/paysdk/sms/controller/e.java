package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.l;
import com.baidu.wallet.paysdk.beans.o;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardCheckSmsResponse;
import com.baidu.wallet.paysdk.datamodel.FindPWDFromOldCardSendSmsResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class e implements ISmsController {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f25495a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f25496b;

    /* renamed from: c  reason: collision with root package name */
    public BindFastRequest f25497c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25498d;

    /* renamed from: e  reason: collision with root package name */
    public o f25499e;

    /* renamed from: f  reason: collision with root package name */
    public l f25500f;

    /* renamed from: g  reason: collision with root package name */
    public SmsVerifyHandler f25501g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25502h = false;

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i) {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        if (this.f25502h) {
            PasswordController.getPassWordInstance().clearSetPwdListener();
        }
        this.f25495a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i, Dialog dialog) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("mBindRequest", this.f25497c);
        bundle.putSerializable("mPayRequest", this.f25498d);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i, int i2, String str) {
        if (i != 522) {
            if (i == 523) {
                WalletGlobalUtils.safeDismissDialog(this.f25495a, 0);
                if (i2 == 5003) {
                    AccountManager.getInstance(this.f25495a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                SmsVerifyHandler smsVerifyHandler = this.f25501g;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifyFailure(i2, str);
                }
                PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_CHECKSMS, i2);
                return true;
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f25495a, 0);
        if (i2 == 5003) {
            AccountManager.getInstance(this.f25495a).logout();
            WalletLoginHelper.getInstance().logout(false);
        }
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.f25495a.getActivity(), "ebpay_send_fail");
        }
        SmsVerifyHandler smsVerifyHandler2 = this.f25501g;
        if (smsVerifyHandler2 != null) {
            smsVerifyHandler2.onSmsSendFailure(i2, str);
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25496b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.doStopCountDown();
        }
        PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_SENDASMS, i2);
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i, Object obj, String str) {
        BindFastRequest bindFastRequest;
        if (i == 522 && (obj instanceof FindPWDFromOldCardSendSmsResponse)) {
            WalletGlobalUtils.safeDismissDialog(this.f25495a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_SENDASMS, 0);
            FindPWDFromOldCardSendSmsResponse findPWDFromOldCardSendSmsResponse = (FindPWDFromOldCardSendSmsResponse) obj;
            if (findPWDFromOldCardSendSmsResponse.checkResponseValidity()) {
                findPWDFromOldCardSendSmsResponse.decrypt();
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f25496b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(findPWDFromOldCardSendSmsResponse.sms_length, findPWDFromOldCardSendSmsResponse.sms_type);
            }
            SmsVerifyHandler smsVerifyHandler = this.f25501g;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
            }
            return true;
        } else if (i == 523 && (obj instanceof FindPWDFromOldCardCheckSmsResponse)) {
            WalletGlobalUtils.safeDismissDialog(this.f25495a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_CHECKSMS, 0);
            FindPWDFromOldCardCheckSmsResponse findPWDFromOldCardCheckSmsResponse = (FindPWDFromOldCardCheckSmsResponse) obj;
            if (findPWDFromOldCardCheckSmsResponse.checkResponseValidity() && (bindFastRequest = this.f25497c) != null) {
                bindFastRequest.setSmsToken(findPWDFromOldCardCheckSmsResponse.sms_token);
                a();
            }
            SmsVerifyHandler smsVerifyHandler2 = this.f25501g;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifySuccess();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f25495a, "ebpay_pay_next");
        String sendSmsphone = !TextUtils.isEmpty(this.f25497c.getSendSmsphone()) ? this.f25497c.getSendSmsphone() : "";
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25496b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", string, sendSmsphone, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        PayRequest payRequest;
        if (bundle == null) {
            this.f25497c = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Pwd.name());
            this.f25498d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        } else {
            Serializable serializable = bundle.getSerializable("mBindRequest");
            if (serializable != null && (serializable instanceof BindFastRequest)) {
                this.f25497c = (BindFastRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.f25498d = (PayRequest) serializable2;
            }
        }
        if (this.f25497c != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f25497c.getRequestId(), this.f25497c);
            if (this.f25497c.isRealPay() && (payRequest = this.f25498d) != null && payRequest.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f25498d.getRequestId(), this.f25498d);
                return true;
            }
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.f25495a, "SmsControllerForFindPWD.onCreateCheckInvalide().1");
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        PayStatisticsUtil.onEvent(StatServiceEvent.NEXT_THIRD);
        this.f25497c.mSmsVCode = str;
        a(str);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        WalletGlobalUtils.safeShowDialog(this.f25495a, 0, "");
        if (this.f25499e == null) {
            this.f25499e = (o) PayBeanFactory.getInstance().getBean((Context) this.f25495a, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS, ISmsController.BEAN_TAG);
        }
        this.f25499e.a((BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.BindCategory.Pwd));
        PayStatisticsUtil.onEventStart(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_SENDASMS);
        this.f25499e.setResponseCallback(this.f25495a);
        this.f25499e.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25495a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25496b = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f25501g = smsVerifyHandler;
    }

    private void a(String str) {
        WalletGlobalUtils.safeShowDialog(this.f25495a, 0, "");
        PayStatisticsUtil.onEventStart(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD_CHECKSMS);
        l lVar = (l) PayBeanFactory.getInstance().getBean((Context) this.f25495a, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_CHECKSMS, ISmsController.BEAN_TAG);
        this.f25500f = lVar;
        lVar.setResponseCallback(this.f25495a);
        this.f25500f.execBean();
    }

    private void a() {
        PasswordController.getPassWordInstance().setPwd(this.f25495a, false, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.sms.controller.e.1
            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i, String str) {
                if (e.this.f25496b != null) {
                    e.this.f25496b.clearSmsEditText();
                    e.this.f25496b.doStopCountDown();
                }
                if (e.this.f25497c == null || e.this.f25497c.mBindFrom != 5) {
                    return;
                }
                PasswordController.getPassWordInstance().setPassByUserFail(str);
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                if (e.this.f25497c == null || e.this.f25497c.mBindFrom != 5) {
                    if (e.this.f25497c == null || e.this.f25497c.mBindFrom != 4) {
                        return;
                    }
                    PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                    return;
                }
                PasswordController.getPassWordInstance().setPassByUserSucceed(str);
            }
        }, PayRequestCache.BindCategory.Pwd);
        this.f25502h = true;
    }
}
