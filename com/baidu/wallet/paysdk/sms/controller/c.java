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
    public PayBaseActivity f26254a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26255b = false;

    /* renamed from: c  reason: collision with root package name */
    public ai f26256c;

    /* renamed from: d  reason: collision with root package name */
    public SmsVerifyHandler f26257d;

    /* renamed from: e  reason: collision with root package name */
    public SmsUpdateUiInterface f26258e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26259f;

    /* renamed from: g  reason: collision with root package name */
    public String f26260g;

    /* renamed from: h  reason: collision with root package name */
    public String f26261h;

    private void a(boolean z, String str, String str2, String str3) {
        ac acVar = (ac) PayBeanFactory.getInstance().getBean((Context) this.f26254a, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE, ISmsController.BEAN_TAG);
        String seed = PasswordController.getSeed();
        acVar.a(PasswordController.handlePwd(str, seed), SafePay.getInstance().encryptProxy(seed), z ? "1" : "2", "20000");
        acVar.setResponseCallback((WalletSmsActivity) this.f26254a);
        acVar.a(str2, str3);
        acVar.execBean();
        WalletGlobalUtils.safeShowDialog(this.f26254a, 0, "");
    }

    private boolean a(int i2) {
        return i2 == 68000 || i2 == 38510 || i2 == 38601;
    }

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
        this.f26254a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        if (i2 != 10) {
            if (i2 == 576) {
                WalletGlobalUtils.safeDismissDialog(this.f26254a, 0);
                if (a(i3)) {
                    GlobalUtils.toast(this.f26254a, str);
                    return true;
                }
                Intent intent = new Intent();
                intent.putExtra(PaySettingActivity.APPLY_SUCCESS, false);
                this.f26254a.setResult(-1, intent);
                this.f26254a.finish();
                return true;
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f26254a, 0);
        if (i3 == 5003) {
            AccountManager.getInstance(this.f26254a.getActivity()).logout();
            WalletLoginHelper.getInstance().logout(false);
        }
        if (this.f26255b) {
            this.f26255b = false;
        }
        if (TextUtils.isEmpty(str)) {
            PayBaseActivity payBaseActivity = this.f26254a;
            str = payBaseActivity.getString(ResUtils.string(payBaseActivity, "ebpay_send_fail"));
        }
        SmsVerifyHandler smsVerifyHandler = this.f26257d;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendFailure(i3, str);
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f26258e;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.clearSmsEditText();
            this.f26258e.doStopCountDown();
            return true;
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        if (i2 != 10) {
            if (i2 == 576) {
                WalletGlobalUtils.safeDismissDialog(this.f26254a, 0);
                Intent intent = new Intent();
                intent.putExtra(PaySettingActivity.APPLY_SUCCESS, true);
                this.f26254a.setResult(-1, intent);
                this.f26254a.finish();
                return true;
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f26254a, 0);
        if (obj instanceof VerifyCodeResponseForNoPwd) {
            VerifyCodeResponseForNoPwd verifyCodeResponseForNoPwd = (VerifyCodeResponseForNoPwd) obj;
            SmsUpdateUiInterface smsUpdateUiInterface = this.f26258e;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(verifyCodeResponseForNoPwd.sms_length, verifyCodeResponseForNoPwd.sms_type);
            }
        }
        if (this.f26255b) {
            this.f26255b = false;
        }
        SmsVerifyHandler smsVerifyHandler = this.f26257d;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsVerifySuccess();
            return true;
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        PayBaseActivity payBaseActivity = this.f26254a;
        if (payBaseActivity == null) {
            return;
        }
        this.f26258e.initSMSActivityView("wallet_base_verify_phone_no", "", payBaseActivity.getString(ResUtils.string(payBaseActivity, "wallet_base_next_step")), this.f26261h, false);
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
        this.f26255b = isSendSmsOnCreate();
        com.baidu.wallet.paysdk.datamodel.e eVar = new com.baidu.wallet.paysdk.datamodel.e();
        if (eVar.checkRequestValidity()) {
            PayRequestCache.getInstance().addBeanRequestToCache(eVar.getRequestId(), eVar);
        }
        return eVar.checkRequestValidity();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        a(this.f26259f, this.f26260g, this.f26261h, str);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        if (this.f26255b && (payBaseActivity = this.f26254a) != null) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f26256c == null) {
            this.f26256c = (ai) PayBeanFactory.getInstance().getBean((Context) this.f26254a, 10, ISmsController.BEAN_TAG);
        }
        this.f26256c.setResponseCallback(this.f26254a);
        this.f26256c.execBean();
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f26254a = payBaseActivity;
        this.f26259f = payBaseActivity.getIntent().getBooleanExtra(PaySettingActivity.OPENED, true);
        this.f26260g = this.f26254a.getIntent().getStringExtra(PaySettingActivity.PWD);
        this.f26261h = this.f26254a.getIntent().getStringExtra("phone");
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f26258e = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f26257d = smsVerifyHandler;
    }
}
