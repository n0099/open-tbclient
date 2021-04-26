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
    public PayBaseActivity f26249a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f26250b;

    /* renamed from: c  reason: collision with root package name */
    public SmsVerifyHandler f26251c;

    /* renamed from: d  reason: collision with root package name */
    public O2OTransInfo f26252d;

    /* renamed from: e  reason: collision with root package name */
    public PayQueryRequest f26253e;

    private void a(ScanCodeLimitPayResponse scanCodeLimitPayResponse) {
        if (scanCodeLimitPayResponse == null || this.f26252d == null) {
            return;
        }
        PayRequest payRequest = new PayRequest();
        payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
        payRequest.mGoodName = this.f26252d.goods_name;
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
        PayController.getInstance().paySucess(this.f26249a, payResultContent, 1);
        this.f26249a.finishWithoutAnim();
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
        this.f26249a = null;
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
        bundle.putSerializable(ScanCodeConstant.ORDER_INFO_KEY, this.f26252d);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        if (i2 == 595) {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f26249a.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler = this.f26251c;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i3, str);
            }
            return true;
        }
        if (i2 == 594) {
            WalletGlobalUtils.safeDismissDialog(this.f26249a, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f26249a.getActivity()).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == 15414 || i3 == 15432 || i3 == 69563) {
                GlobalUtils.toast(this.f26249a, str);
                return true;
            } else if (i3 == 100018) {
                GlobalUtils.toast(this.f26249a, str);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this.f26249a, 0);
        if (i2 == 595) {
            if (obj instanceof O2OScancodeSendSMSRsp) {
                O2OScancodeSendSMSRsp o2OScancodeSendSMSRsp = (O2OScancodeSendSMSRsp) obj;
                SmsUpdateUiInterface smsUpdateUiInterface = this.f26250b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(o2OScancodeSendSMSRsp.sms_length, o2OScancodeSendSMSRsp.sms_type);
                }
            }
            SmsVerifyHandler smsVerifyHandler = this.f26251c;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
            }
            return true;
        } else if (i2 != 594 || !(obj instanceof ScanCodeLimitPayResponse)) {
            if (i2 == 12) {
                PayRequest payRequest = new PayRequest();
                payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                payRequest.mGoodName = this.f26252d.goods_name;
                PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
            }
            return false;
        } else {
            ScanCodeLimitPayResponse scanCodeLimitPayResponse = (ScanCodeLimitPayResponse) obj;
            if (scanCodeLimitPayResponse.checkResponseValidity()) {
                O2OTransInfo o2OTransInfo = this.f26252d;
                o2OTransInfo.notify = scanCodeLimitPayResponse.notify;
                o2OTransInfo.score_tip = scanCodeLimitPayResponse.score_tip;
                if ("2".equalsIgnoreCase(scanCodeLimitPayResponse.pay_type)) {
                    if (this.f26253e == null) {
                        this.f26253e = new PayQueryRequest();
                    }
                    PayQueryRequest payQueryRequest = this.f26253e;
                    payQueryRequest.mBankNo = scanCodeLimitPayResponse.bank_no;
                    payQueryRequest.mOrderNo = scanCodeLimitPayResponse.bank_send_trans_no;
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f26253e.getRequestId(), this.f26253e);
                    this.f26249a.queryPayResult();
                } else {
                    this.f26252d.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                    a(scanCodeLimitPayResponse);
                }
            }
            return true;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f26249a, "ebpay_pay_next");
        SmsUpdateUiInterface smsUpdateUiInterface = this.f26250b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", string, this.f26252d.mobile, true);
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
            this.f26252d = (O2OTransInfo) this.f26249a.getIntent().getSerializableExtra(ScanCodeConstant.ORDER_INFO_KEY);
            return true;
        }
        this.f26252d = (O2OTransInfo) bundle.getSerializable(ScanCodeConstant.ORDER_INFO_KEY);
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        WalletGlobalUtils.safeShowDialog(this.f26249a, 0, "");
        BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this.f26249a, PayBeanFactory.BEAN_ID_SCANCODE_PAY, ISmsController.BEAN_TAG);
        if (bean != null) {
            O2OTransInfo o2OTransInfo = this.f26252d;
            bean.setBeanParams(o2OTransInfo.sp_no, o2OTransInfo.order_no, o2OTransInfo.pay_code, str);
            bean.setResponseCallback((WalletSmsActivity) this.f26249a);
            bean.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        WalletGlobalUtils.safeShowDialog(this.f26249a, 0, "");
        BaseBean<?> bean = PayBeanFactory.getInstance().getBean((Context) this.f26249a, PayBeanFactory.BEAN_ID_SCANCODE_SEND_SMS_TO_PAY, ISmsController.BEAN_TAG);
        if (bean != null) {
            O2OTransInfo o2OTransInfo = this.f26252d;
            bean.setBeanParams(o2OTransInfo.sp_no, o2OTransInfo.order_no, o2OTransInfo.pay_code, o2OTransInfo.mobile);
            bean.setResponseCallback((WalletSmsActivity) this.f26249a);
            bean.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f26249a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f26250b = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.f26251c = smsVerifyHandler;
    }
}
