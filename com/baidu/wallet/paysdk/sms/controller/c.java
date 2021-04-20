package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ac;
import com.baidu.wallet.paysdk.beans.ai;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponseForNoPwd;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
/* loaded from: classes5.dex */
public class c implements ISmsController {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f25472a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25473b = false;

    /* renamed from: c  reason: collision with root package name */
    public ai f25474c;

    /* renamed from: d  reason: collision with root package name */
    public SmsVerifyHandler f25475d;

    /* renamed from: e  reason: collision with root package name */
    public SmsUpdateUiInterface f25476e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25477f;

    /* renamed from: g  reason: collision with root package name */
    public String f25478g;

    /* renamed from: h  reason: collision with root package name */
    public String f25479h;

    private void a(boolean z, String str, String str2, String str3) {
        ac acVar = (ac) PayBeanFactory.getInstance().getBean((Context) this.f25472a, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE, ISmsController.BEAN_TAG);
        String seed = PasswordController.getSeed();
        acVar.a(PasswordController.handlePwd(str, seed), SafePay.getInstance().encryptProxy(seed), z ? "1" : "2", "20000");
        acVar.setResponseCallback((WalletSmsActivity) this.f25472a);
        acVar.a(str2, str3);
        acVar.execBean();
        WalletGlobalUtils.safeShowDialog(this.f25472a, 0, "");
    }

    private boolean a(int i) {
        return i == 68000 || i == 38510 || i == 38601;
    }

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
        this.f25472a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i, Dialog dialog) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i, int i2, String str) {
        if (i != 10) {
            if (i == 576) {
                WalletGlobalUtils.safeDismissDialog(this.f25472a, 0);
                if (a(i2)) {
                    GlobalUtils.toast(this.f25472a, str);
                    return true;
                }
                Intent intent = new Intent();
                intent.putExtra(PaySettingActivity.APPLY_SUCCESS, false);
                this.f25472a.setResult(-1, intent);
                this.f25472a.finish();
                return true;
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f25472a, 0);
        if (i2 == 5003) {
            AccountManager.getInstance(this.f25472a.getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        }
        if (this.f25473b) {
            this.f25473b = false;
        }
        if (TextUtils.isEmpty(str)) {
            PayBaseActivity payBaseActivity = this.f25472a;
            str = payBaseActivity.getString(ResUtils.string(payBaseActivity, "ebpay_send_fail"));
        }
        SmsVerifyHandler smsVerifyHandler = this.f25475d;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendFailure(i2, str);
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25476e;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.clearSmsEditText();
            this.f25476e.doStopCountDown();
            return true;
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i, Object obj, String str) {
        if (i != 10) {
            if (i == 576) {
                WalletGlobalUtils.safeDismissDialog(this.f25472a, 0);
                Intent intent = new Intent();
                intent.putExtra(PaySettingActivity.APPLY_SUCCESS, true);
                this.f25472a.setResult(-1, intent);
                this.f25472a.finish();
                return true;
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f25472a, 0);
        if (obj instanceof VerifyCodeResponseForNoPwd) {
            VerifyCodeResponseForNoPwd verifyCodeResponseForNoPwd = (VerifyCodeResponseForNoPwd) obj;
            SmsUpdateUiInterface smsUpdateUiInterface = this.f25476e;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(verifyCodeResponseForNoPwd.sms_length, verifyCodeResponseForNoPwd.sms_type);
            }
        }
        if (this.f25473b) {
            this.f25473b = false;
        }
        SmsVerifyHandler smsVerifyHandler = this.f25475d;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsVerifySuccess();
            return true;
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        PayBaseActivity payBaseActivity = this.f25472a;
        if (payBaseActivity == null) {
            return;
        }
        this.f25476e.initSMSActivityView("wallet_base_verify_phone_no", "", payBaseActivity.getString(ResUtils.string(payBaseActivity, "wallet_base_next_step")), this.f25479h, false);
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
        this.f25473b = isSendSmsOnCreate();
        com.baidu.wallet.paysdk.datamodel.e eVar = new com.baidu.wallet.paysdk.datamodel.e();
        if (eVar.checkRequestValidity()) {
            PayRequestCache.getInstance().addBeanRequestToCache(eVar.getRequestId(), eVar);
        }
        return eVar.checkRequestValidity();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        a(this.f25477f, this.f25478g, this.f25479h, str);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        if (this.f25473b && (payBaseActivity = this.f25472a) != null) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f25474c == null) {
            this.f25474c = (ai) PayBeanFactory.getInstance().getBean((Context) this.f25472a, 10, ISmsController.BEAN_TAG);
        }
        this.f25474c.setResponseCallback(this.f25472a);
        this.f25474c.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25472a = payBaseActivity;
        this.f25477f = payBaseActivity.getIntent().getBooleanExtra(PaySettingActivity.OPENED, true);
        this.f25478g = this.f25472a.getIntent().getStringExtra(PaySettingActivity.PWD);
        this.f25479h = this.f25472a.getIntent().getStringExtra("phone");
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25476e = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f25475d = smsVerifyHandler;
    }
}
