package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.datamodel.O2OPayResultItemInfo;
import com.baidu.wallet.paysdk.datamodel.O2OScancodeSendSMSRsp;
import com.baidu.wallet.paysdk.datamodel.O2OTransInfo;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.baidu.wallet.paysdk.datamodel.ScanCodeLimitPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.util.StatHelper;
/* loaded from: classes5.dex */
public class b implements ISmsController {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f25423a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f25424b;

    /* renamed from: c  reason: collision with root package name */
    public SmsVerifyHandler f25425c;

    /* renamed from: d  reason: collision with root package name */
    public O2OTransInfo f25426d;

    /* renamed from: e  reason: collision with root package name */
    public PayQueryRequest f25427e;

    private void a(ScanCodeLimitPayResponse scanCodeLimitPayResponse) {
        if (scanCodeLimitPayResponse == null || this.f25426d == null) {
            return;
        }
        PayRequest payRequest = new PayRequest();
        payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
        payRequest.mGoodName = this.f25426d.goods_name;
        PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
        PayResultContent payResultContent = new PayResultContent();
        payResultContent.notify = scanCodeLimitPayResponse.notify;
        payResultContent.score_tip = scanCodeLimitPayResponse.score_tip;
        payResultContent.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
        O2OPayResultItemInfo o2OPayResultItemInfo = scanCodeLimitPayResponse.pay_result;
        if (o2OPayResultItemInfo != null) {
            payResultContent.coupon_msg = o2OPayResultItemInfo.coupon_msg;
            payResultContent.coupon_find_prompt = o2OPayResultItemInfo.coupon_find_prompt;
            String str = o2OPayResultItemInfo.cash_amount;
            payResultContent.cash_amount = str;
            payResultContent.total_amount = o2OPayResultItemInfo.total_amount;
            payResultContent.discount_amount = o2OPayResultItemInfo.discount_amount;
            payResultContent.pay_detail_info = o2OPayResultItemInfo.pay_detail_info;
            payResultContent.paytype_info = o2OPayResultItemInfo.paytype_info;
            payResultContent.discount_prefix = o2OPayResultItemInfo.discount_prefix;
            payResultContent.order_prefix = o2OPayResultItemInfo.order_prefix;
            StatHelper.cachePayAmount(Double.valueOf(str).doubleValue());
        }
        PayController.getInstance().paySucess(this.f25423a, payResultContent, 1);
        this.f25423a.finishWithoutAnim();
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
        BeanManager.getInstance().removeAllBeans(ISmsController.BEAN_TAG);
        this.f25423a = null;
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
        bundle.putSerializable(ScanCodeConstant.ORDER_INFO_KEY, this.f25426d);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        if (i2 == 595) {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f25423a.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler = this.f25425c;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i3, str);
            }
            return true;
        }
        if (i2 == 594) {
            WalletGlobalUtils.safeDismissDialog(this.f25423a, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25423a.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == 15414 || i3 == 15432 || i3 == 69563) {
                GlobalUtils.toast(this.f25423a, str);
                return true;
            } else if (i3 == 100018) {
                GlobalUtils.toast(this.f25423a, str);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this.f25423a, 0);
        if (i2 == 595) {
            if (obj instanceof O2OScancodeSendSMSRsp) {
                O2OScancodeSendSMSRsp o2OScancodeSendSMSRsp = (O2OScancodeSendSMSRsp) obj;
                SmsUpdateUiInterface smsUpdateUiInterface = this.f25424b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(o2OScancodeSendSMSRsp.sms_length, o2OScancodeSendSMSRsp.sms_type);
                }
            }
            SmsVerifyHandler smsVerifyHandler = this.f25425c;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
            }
            return true;
        } else if (i2 != 594 || !(obj instanceof ScanCodeLimitPayResponse)) {
            if (i2 == 12) {
                PayRequest payRequest = new PayRequest();
                payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                payRequest.mGoodName = this.f25426d.goods_name;
                PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
            }
            return false;
        } else {
            ScanCodeLimitPayResponse scanCodeLimitPayResponse = (ScanCodeLimitPayResponse) obj;
            if (scanCodeLimitPayResponse.checkResponseValidity()) {
                O2OTransInfo o2OTransInfo = this.f25426d;
                o2OTransInfo.notify = scanCodeLimitPayResponse.notify;
                o2OTransInfo.score_tip = scanCodeLimitPayResponse.score_tip;
                if ("2".equalsIgnoreCase(scanCodeLimitPayResponse.pay_type)) {
                    if (this.f25427e == null) {
                        this.f25427e = new PayQueryRequest();
                    }
                    PayQueryRequest payQueryRequest = this.f25427e;
                    payQueryRequest.mBankNo = scanCodeLimitPayResponse.bank_no;
                    payQueryRequest.mOrderNo = scanCodeLimitPayResponse.bank_send_trans_no;
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f25427e.getRequestId(), this.f25427e);
                    this.f25423a.queryPayResult();
                } else {
                    this.f25426d.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                    a(scanCodeLimitPayResponse);
                }
            }
            return true;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f25423a, "ebpay_pay_next");
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25424b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", string, this.f25426d.mobile, true);
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
        if (bundle == null) {
            this.f25426d = (O2OTransInfo) this.f25423a.getIntent().getSerializableExtra(ScanCodeConstant.ORDER_INFO_KEY);
            return true;
        }
        this.f25426d = (O2OTransInfo) bundle.getSerializable(ScanCodeConstant.ORDER_INFO_KEY);
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        WalletGlobalUtils.safeShowDialog(this.f25423a, 0, "");
        BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this.f25423a, PayBeanFactory.BEAN_ID_SCANCODE_PAY, ISmsController.BEAN_TAG);
        if (bean != null) {
            O2OTransInfo o2OTransInfo = this.f25426d;
            bean.setBeanParams(o2OTransInfo.sp_no, o2OTransInfo.order_no, o2OTransInfo.pay_code, str);
            bean.setResponseCallback((WalletSmsActivity) this.f25423a);
            bean.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        WalletGlobalUtils.safeShowDialog(this.f25423a, 0, "");
        BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this.f25423a, PayBeanFactory.BEAN_ID_SCANCODE_SEND_SMS_TO_PAY, ISmsController.BEAN_TAG);
        if (bean != null) {
            O2OTransInfo o2OTransInfo = this.f25426d;
            bean.setBeanParams(o2OTransInfo.sp_no, o2OTransInfo.order_no, o2OTransInfo.pay_code, o2OTransInfo.mobile);
            bean.setResponseCallback((WalletSmsActivity) this.f25423a);
            bean.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25423a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25424b = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f25425c = smsVerifyHandler;
    }
}
