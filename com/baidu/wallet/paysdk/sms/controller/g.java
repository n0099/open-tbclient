package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UnbindCardBean;
import com.baidu.wallet.paysdk.beans.r;
import com.baidu.wallet.paysdk.datamodel.UnBindSmSResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
/* loaded from: classes5.dex */
public class g implements ISmsController {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f25663a;

    /* renamed from: b  reason: collision with root package name */
    public String f25664b;

    /* renamed from: c  reason: collision with root package name */
    public String f25665c;

    /* renamed from: d  reason: collision with root package name */
    public SmsUpdateUiInterface f25666d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25667e = false;

    /* renamed from: f  reason: collision with root package name */
    public SmsVerifyHandler f25668f;

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        return null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        this.f25663a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putString("card_no", this.f25664b);
        bundle.putString("phone_no", this.f25665c);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        if (i2 == 514) {
            WalletGlobalUtils.safeDismissDialog(this.f25663a, 0);
            this.f25667e = false;
            if (!TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this.f25663a, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f25666d;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.clearSmsEditText();
                this.f25666d.doStopCountDown();
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f25663a, "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler = this.f25668f;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i3, str);
            }
        } else if (i2 != 516) {
            return false;
        } else {
            WalletGlobalUtils.safeDismissDialog(this.f25663a, 0);
            SmsVerifyHandler smsVerifyHandler2 = this.f25668f;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifyFailure(i3, str);
            }
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        SmsUpdateUiInterface smsUpdateUiInterface;
        if (i2 == 514) {
            this.f25667e = false;
            WalletGlobalUtils.safeDismissDialog(this.f25663a, 0);
            PayBaseActivity payBaseActivity = this.f25663a;
            GlobalUtils.toast(payBaseActivity, ResUtils.getString(payBaseActivity, "ebpay_sms_sent"));
            if (obj != null && (obj instanceof UnBindSmSResponse) && (smsUpdateUiInterface = this.f25666d) != null) {
                UnBindSmSResponse unBindSmSResponse = (UnBindSmSResponse) obj;
                smsUpdateUiInterface.upDateSafeKeyBoradView(unBindSmSResponse.sms_length, unBindSmSResponse.sms_type);
            }
            SmsVerifyHandler smsVerifyHandler = this.f25668f;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
            }
        } else if (i2 != 516) {
            return false;
        } else {
            WalletGlobalUtils.safeDismissDialog(this.f25663a, 0);
            SmsVerifyHandler smsVerifyHandler2 = this.f25668f;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifySuccess();
            }
            this.f25663a.finish();
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        PayBaseActivity payBaseActivity = this.f25663a;
        if (payBaseActivity == null) {
            return;
        }
        this.f25666d.initSMSActivityView("wallet_base_verify_phone_no", "", ResUtils.getString(payBaseActivity, "wallet_base_unbind_tip"), this.f25665c, false);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        this.f25667e = true;
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        if (bundle == null) {
            PayBaseActivity payBaseActivity = this.f25663a;
            if (payBaseActivity == null) {
                return false;
            }
            this.f25664b = payBaseActivity.getIntent().getStringExtra(BeanConstants.EXTRA_CARD_NO);
            this.f25665c = this.f25663a.getIntent().getStringExtra(BeanConstants.EXTRA_PHONE_NO);
        } else {
            this.f25664b = bundle.getString("card_no");
            this.f25665c = bundle.getString("phone_no");
        }
        com.baidu.wallet.paysdk.datamodel.b bVar = new com.baidu.wallet.paysdk.datamodel.b();
        bVar.f25404b = this.f25664b;
        bVar.f25403a = this.f25665c;
        if (bVar.checkRequestValidity()) {
            PayRequestCache.getInstance().addBeanRequestToCache(bVar.getRequestId(), bVar);
        }
        return bVar.checkRequestValidity();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        UnbindCardBean unbindCardBean = (UnbindCardBean) PayBeanFactory.getInstance().getBean((Context) this.f25663a, 516, ISmsController.BEAN_TAG);
        unbindCardBean.setCardNo(this.f25664b);
        unbindCardBean.setPhoneNo(this.f25665c);
        unbindCardBean.setUsePass(false);
        unbindCardBean.setValue(str);
        unbindCardBean.setResponseCallback(this.f25663a);
        unbindCardBean.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        if (this.f25667e && (payBaseActivity = this.f25663a) != null) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        r rVar = (r) PayBeanFactory.getInstance().getBean((Context) this.f25663a, 514, ISmsController.BEAN_TAG);
        rVar.setResponseCallback(this.f25663a);
        rVar.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25663a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25666d = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f25668f = smsVerifyHandler;
    }
}
