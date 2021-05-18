package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ag;
import com.baidu.wallet.paysdk.beans.aj;
import com.baidu.wallet.paysdk.beans.s;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f25507a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f25508b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorContentResponse f25509c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25510d;

    /* renamed from: e  reason: collision with root package name */
    public String f25511e;

    /* renamed from: f  reason: collision with root package name */
    public PayRequestCache.BindCategory f25512f;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f25513g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.b f25514h;

    /* renamed from: i  reason: collision with root package name */
    public aj f25515i;
    public com.baidu.wallet.paysdk.beans.h j;
    public String k;
    public y n;
    public SmsVerifyHandler o;
    public String q;
    public boolean l = true;
    public boolean m = false;
    public boolean p = false;

    private void e() {
        PayStatisticsUtil.onEvent(StatServiceEvent.BIND_CLICK_PAY);
        StatisticManager.onEventStart(StatServiceEvent.TIME_PAY);
        WalletGlobalUtils.safeShowDialog(this.f25507a, 0, "");
        if (this.n == null) {
            this.n = (y) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 13, ISmsController.BEAN_TAG);
        }
        this.n.setResponseCallback((WalletSmsActivity) this.f25507a);
        this.n.b(this.f25507a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
        this.n.execBean();
    }

    private void f() {
        WalletGlobalUtils.safeShowDialog(this.f25507a, 0, "");
        if (this.f25514h == null) {
            this.f25514h = (com.baidu.wallet.paysdk.beans.b) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 513, ISmsController.BEAN_TAG);
        }
        PayStatisticsUtil.onEventStart(StatServiceEvent.BIND_CARD);
        this.f25514h.a(this.f25513g);
        this.f25514h.setResponseCallback((WalletSmsActivity) this.f25507a);
        this.f25514h.execBean();
    }

    private void g() {
        BindFastRequest bindFastRequest = this.f25513g;
        if (bindFastRequest != null && bindFastRequest.isNeedCheckSms()) {
            WalletGlobalUtils.safeShowDialog(this.f25507a, 0, "");
            if (this.f25515i == null) {
                this.f25515i = (aj) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 11, ISmsController.BEAN_TAG);
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.VERIFY_SMS);
            int i2 = this.f25513g.getmBindFrom();
            if (i2 != 6 && i2 != 7 && i2 != 8) {
                this.f25515i.a(false);
            } else {
                this.f25515i.a(true);
            }
            this.f25515i.a(this.f25513g);
            this.f25515i.setResponseCallback((WalletSmsActivity) this.f25507a);
            this.f25515i.execBean();
            return;
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        WalletGlobalUtils.safeShowDialog(this.f25507a, 0, "");
        if (this.n == null) {
            this.n = (y) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 13, ISmsController.BEAN_TAG);
        }
        this.n.setResponseCallback((WalletSmsActivity) this.f25507a);
        this.n.b(this.f25507a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
        this.n.execBean();
    }

    private void i() {
        if (this.f25513g == null) {
            return;
        }
        PasswordController.getPassWordInstance().setPwd(this.f25507a, false, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.1
            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i2, String str) {
                SmsUpdateUiInterface smsUpdateUiInterface = d.this.f25508b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.clearSmsEditText();
                    d.this.f25508b.doStopCountDown();
                }
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                int i2 = d.this.f25513g.getmBindFrom();
                if (i2 == 1) {
                    PayController.getInstance().bindSuccess(null);
                } else if (i2 == 3) {
                    PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                } else if (i2 == 4) {
                    PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                } else if (i2 == 6 || i2 == 7 || i2 == 8) {
                    d.this.h();
                }
            }
        }, this.f25512f);
        this.p = true;
    }

    private boolean j() {
        BindFastRequest bindFastRequest = this.f25513g;
        return (bindFastRequest == null || bindFastRequest.mBondCard == null || bindFastRequest.getmBindFrom() != 2 || this.f25513g.mBondCard.isNeedSendSms()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        String string = ResUtils.getString(this.f25507a, "ebpay_confirm");
        BindFastRequest bindFastRequest = this.f25513g;
        if (bindFastRequest == null) {
            return string;
        }
        int i2 = bindFastRequest.mBindFrom;
        if (i2 == 0) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                PayRequest payRequest = this.f25510d;
                if (payRequest != null && payRequest.mMktSolution != null) {
                    return String.format(ResUtils.getString(this.f25507a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25510d.mMktSolution.easypay_amount));
                }
                if (this.f25513g != null) {
                    return String.format(ResUtils.getString(this.f25507a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25513g.getFinalPayAmount()));
                }
                return ResUtils.getString(this.f25507a, "ebpay_submit_pay");
            }
            return ResUtils.getString(this.f25507a, "wallet_base_next_step");
        } else if (i2 == 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                return ResUtils.getString(this.f25507a, "ebpay_pwd_done");
            }
            return ResUtils.getString(this.f25507a, "wallet_base_next_step");
        } else if (i2 == 2) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                PayRequest payRequest2 = this.f25510d;
                if (payRequest2 != null) {
                    if (payRequest2.mMktSolution != null) {
                        return String.format(ResUtils.getString(this.f25507a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25510d.mMktSolution.easypay_amount));
                    }
                    return String.format(ResUtils.getString(this.f25507a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25510d.getFinalPayAmount()));
                }
                return ResUtils.getString(this.f25507a, "ebpay_submit_pay");
            }
            return ResUtils.getString(this.f25507a, "wallet_base_next_step");
        } else if (i2 != 3) {
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    if (com.baidu.wallet.paysdk.a.b.c()) {
                        PayRequest payRequest3 = this.f25510d;
                        if (payRequest3 != null && payRequest3.mMktSolution != null) {
                            return String.format(ResUtils.getString(this.f25507a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25510d.mMktSolution.easypay_amount));
                        }
                        if (this.f25513g != null) {
                            return String.format(ResUtils.getString(this.f25507a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25513g.getFinalPayAmount()));
                        }
                        return ResUtils.getString(this.f25507a, "ebpay_submit_pay");
                    }
                    return ResUtils.getString(this.f25507a, "bd_wallet_auth_submit_sign");
                }
                return ResUtils.getString(this.f25507a, "wallet_base_next_step");
            }
            return string;
        } else {
            return ResUtils.getString(this.f25507a, "wallet_base_next_step");
        }
    }

    private ArrayList<String> l() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.f25510d;
        arrayList.add(payRequest != null ? payRequest.mSpNO : "");
        PayRequest payRequest2 = this.f25510d;
        arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        if (i3 != 80320 && i3 != 80321 && i3 != 80326 && i3 != 80327) {
            if (obj instanceof ErrorContentResponse) {
                ErrorContentResponse errorContentResponse = (ErrorContentResponse) obj;
                if (errorContentResponse.card_item_required != null && this.f25513g.getmBindFrom() == 2) {
                    this.k = str;
                    this.f25509c = errorContentResponse;
                    WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
                    WalletGlobalUtils.safeShowDialog(this.f25507a, 40, "");
                    return true;
                } else if (i3 == 15500) {
                    this.k = str;
                    PayBaseActivity payBaseActivity = this.f25507a;
                    payBaseActivity.mPayErrorCode = i3;
                    payBaseActivity.mBeanId = i2;
                    this.f25509c = errorContentResponse;
                    WalletGlobalUtils.safeDismissDialog(payBaseActivity, 0);
                    WalletGlobalUtils.safeShowDialog(this.f25507a, 65316, "");
                    return true;
                }
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
        PayDataCache.getInstance().cleanDetainmentDesc();
        if (obj instanceof ErrorContentResponse) {
            this.f25509c = (ErrorContentResponse) obj;
            if (!TextUtils.isEmpty(str)) {
                this.k = str;
                PayBaseActivity payBaseActivity2 = this.f25507a;
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
            return new PromptDialog(this.f25507a.getActivity());
        }
        if (i2 == 65316) {
            return new PromptDialog(this.f25507a.getActivity());
        }
        if (i2 == 65283) {
            return new PromptDialog(this.f25507a.getActivity());
        }
        if (i2 == 40) {
            return new PromptDialog(this.f25507a.getActivity());
        }
        return null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        if (this.p) {
            PasswordController.getPassWordInstance().clearSetPwdListener();
        }
        this.f25507a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        switch (i2) {
            case 40:
                final PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.k);
                promptDialog.hideNegativeButton();
                promptDialog.setPositiveBtn(ResUtils.string(this.f25507a, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayController payController = PayController.getInstance();
                        d dVar = d.this;
                        payController.updateCardInfoPay(dVar.f25507a, dVar.f25509c);
                        promptDialog.dismiss();
                        d.this.f25507a.finishWithoutAnim();
                    }
                });
                return true;
            case ISmsController.DIALOG_PROMPT /* 65283 */:
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.k);
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.hideNegativeButton();
                return true;
            case ISmsController.DIALOG_CANNOT_DISCOUNT /* 65315 */:
                StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.k);
                promptDialog3.showCloseBtn(false);
                promptDialog3.setNegativeBtn(ResUtils.getString(this.f25507a, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25507a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_cancel"));
                        WalletGlobalUtils.safeDismissDialog(d.this.f25507a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                    }
                });
                promptDialog3.setPositiveBtn(ResUtils.getString(this.f25507a, "bd_wallet_pay_by_order_price"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25507a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                        d dVar = d.this;
                        ErrorContentResponse errorContentResponse = dVar.f25509c;
                        if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                            return;
                        }
                        if (dVar.j == null) {
                            d.this.j = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) d.this.f25507a, 5, ISmsController.BEAN_TAG);
                        }
                        ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(d.this.f25509c.mkt_solution);
                        PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
                        d.this.j.a(d.this.f25513g);
                        d.this.j.setResponseCallback((WalletSmsActivity) d.this.f25507a);
                        d.this.j.execBean();
                        WalletGlobalUtils.safeShowDialog(d.this.f25507a, 0, "");
                        WalletGlobalUtils.safeDismissDialog(d.this.f25507a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                        d dVar2 = d.this;
                        if (dVar2.f25508b != null) {
                            String k = dVar2.k();
                            if (!TextUtils.isEmpty(k)) {
                                d.this.f25508b.updateButtonTip(k);
                            }
                        }
                        SmsUpdateUiInterface smsUpdateUiInterface = d.this.f25508b;
                        if (smsUpdateUiInterface != null) {
                            smsUpdateUiInterface.clearSmsEditText();
                            d.this.f25508b.doStartCountDown();
                        }
                    }
                });
                return true;
            case 65316:
                StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_CARD_UPDATE);
                PayRequest payRequest = this.f25510d;
                if (payRequest != null && payRequest.mBondCard != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
                    this.f25510d.mBondCard.hideSMSDialog = true;
                }
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(this.k);
                promptDialog4.showCloseBtn(false);
                promptDialog4.setCanceledOnTouchOutside(false);
                if (j()) {
                    promptDialog4.hideNegativeButton();
                }
                promptDialog4.setNegativeBtn(ResUtils.getString(this.f25507a, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25507a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_cancel"));
                        WalletGlobalUtils.safeDismissDialog(d.this.f25507a, 65316);
                        PayBaseActivity payBaseActivity2 = d.this.f25507a;
                        if (payBaseActivity2 instanceof WalletSmsActivity) {
                            payBaseActivity2.finishWithoutAnim();
                        }
                    }
                });
                promptDialog4.setPositiveBtn(ResUtils.string(this.f25507a, "ebpay_wallet_continue_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25507a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                        WalletGlobalUtils.safeDismissDialog(d.this.f25507a, 65316);
                        PayController payController = PayController.getInstance();
                        d dVar = d.this;
                        payController.updateCardInfoPay(dVar.f25507a, dVar.f25509c);
                        d.this.f25507a.finishWithoutAnim();
                    }
                });
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("mBindRequest", this.f25513g);
        bundle.putSerializable("mPayRequest", this.f25510d);
        bundle.putSerializable("mCardInfoUpdateContent", this.f25509c);
        bundle.putBoolean("isSendSMSForCompletionPay", this.m);
        bundle.putString("mDialogMsg", this.k);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        if (i3 == 65025) {
            GlobalUtils.toast(this.f25507a, str);
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            return true;
        } else if (i2 == 5 || i2 == 17) {
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25507a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            a(i3, str);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, i3);
            return true;
        } else if (i2 == 11) {
            WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25507a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            SmsVerifyHandler smsVerifyHandler = this.o;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifyFailure(i3, str);
            }
            PayStatisticsUtil.onEvent(StatServiceEvent.VERFY_SMS_FAIL);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.VERIFY_SMS, i3);
            return true;
        } else if (i2 != 13 && i2 != 513) {
            if (i2 == 264) {
                a(i3, str);
                return true;
            }
            return false;
        } else {
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25507a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
            if (i3 == 60500) {
                this.k = str;
                WalletGlobalUtils.safeShowDialog(this.f25507a, ISmsController.DIALOG_PROMPT, "");
            } else {
                SmsVerifyHandler smsVerifyHandler2 = this.o;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifyFailure(i3, str);
                }
            }
            if (i2 == 13) {
                BindFastRequest bindFastRequest = this.f25513g;
                if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f25513g.getmBindFrom() == 6)) {
                    String orderNo = StatHelper.getOrderNo();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(orderNo, i3 + "", str));
                }
                StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, i3);
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.BIND_PAY_ACCEPT_FAIL, String.valueOf(i3));
            } else {
                String sessionId = StatHelper.getSessionId();
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(sessionId, i3 + "", str));
                PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, i3);
            }
            return true;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        if (i2 == 5 || i2 == 17) {
            WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
            CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            if (checkCardInfoResponse != null && checkCardInfoResponse.checkResponseValidity()) {
                if (this.f25513g != null) {
                    this.f25513g.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
                    if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                        this.f25513g.setChannelNo(checkCardInfoResponse.channel_no);
                    }
                }
                if (this.l) {
                    this.l = false;
                    SmsUpdateUiInterface smsUpdateUiInterface = this.f25508b;
                    if (smsUpdateUiInterface != null) {
                        smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
                    }
                }
                SmsUpdateUiInterface smsUpdateUiInterface2 = this.f25508b;
                if (smsUpdateUiInterface2 != null) {
                    smsUpdateUiInterface2.updateModifyPhoneUI(!TextUtils.isEmpty(checkCardInfoResponse.update_mobile_desc), checkCardInfoResponse.update_mobile_desc);
                }
            }
            SmsVerifyHandler smsVerifyHandler = this.o;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendSuccess();
            }
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, 0);
            return true;
        } else if (i2 == 11) {
            WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
            PayStatisticsUtil.onEvent(StatServiceEvent.VERIFY_SMS_SUCCESS);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.VERIFY_SMS, 0);
            i();
            SmsVerifyHandler smsVerifyHandler2 = this.o;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifySuccess();
            }
            return true;
        } else if (i2 == 513) {
            WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, 0);
            PayRequest payRequest = this.f25510d;
            if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                PayController.getInstance().bindExtSuccess(this.f25507a, obj);
            } else {
                PayController.getInstance().bindSuccess(obj);
            }
            SmsVerifyHandler smsVerifyHandler3 = this.o;
            if (smsVerifyHandler3 != null) {
                smsVerifyHandler3.onSmsVerifySuccess();
            }
            return true;
        } else if (i2 != 13) {
            if (i2 != 264) {
                if (i2 == 15) {
                    return a(obj);
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
            SmsVerifyHandler smsVerifyHandler4 = this.o;
            if (smsVerifyHandler4 != null) {
                smsVerifyHandler4.onSmsSendSuccess();
            }
            return true;
        } else {
            BindFastRequest bindFastRequest = this.f25513g;
            if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f25513g.getmBindFrom() == 6)) {
                StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_SUCCESS, StatHelper.getOrderNo());
            }
            StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, 0);
            PayStatisticsUtil.onEvent("paySuccess");
            SmsVerifyHandler smsVerifyHandler5 = this.o;
            if (smsVerifyHandler5 != null) {
                smsVerifyHandler5.onSmsVerifySuccess();
            }
            return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String unicodeDecode;
        if (this.f25513g == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f25511e)) {
            unicodeDecode = !TextUtils.isEmpty(this.f25513g.getSendSmsphone()) ? this.f25513g.getSendSmsphone() : "";
        } else {
            unicodeDecode = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.f25511e));
        }
        String str = unicodeDecode;
        String k = k();
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25508b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", k, str, true);
            this.f25508b.updateModifyPhoneUI(!TextUtils.isEmpty(this.q), this.q);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        BindFastRequest bindFastRequest = this.f25513g;
        if (bindFastRequest != null) {
            if (bindFastRequest.mBindFrom == 2 && this.m) {
                c();
                return 5320 != this.f25507a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
            }
            BindFastRequest bindFastRequest2 = this.f25513g;
            if (bindFastRequest2.mBindFrom == 8) {
                c();
                return 5320 != this.f25507a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f25508b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(bindFastRequest2.getSmsLength(), this.f25513g.getSmsType());
            }
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        PayRequest payRequest;
        this.q = this.f25507a.getIntent().getStringExtra(BeanConstants.UPDATE_MOBILE_DESC);
        if (bundle == null) {
            this.m = this.f25507a.getIntent().getBooleanExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
            if (this.f25513g == null) {
                this.f25513g = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            }
            if (this.f25512f == null) {
                this.f25512f = PayRequestCache.BindCategory.Other;
            }
            this.f25510d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            Serializable serializableExtra = this.f25507a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            if (serializableExtra != null) {
                this.f25511e = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
            }
        } else {
            this.m = bundle.getBoolean("isSendSMSForCompletionPay");
            this.k = bundle.getString("mDialogMsg");
            Serializable serializable = bundle.getSerializable("mBindRequest");
            if (serializable != null && (serializable instanceof BindFastRequest)) {
                this.f25513g = (BindFastRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.f25510d = (PayRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("mCardInfoUpdateContent");
            if (serializable3 != null && (serializable3 instanceof ErrorContentResponse)) {
                this.f25509c = (ErrorContentResponse) serializable3;
            }
            this.f25511e = bundle.getString("phone_no");
        }
        BindFastRequest bindFastRequest = this.f25513g;
        if (bindFastRequest != null && bindFastRequest.checkRequestValidity()) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f25513g.getRequestId(), this.f25513g);
            if (this.f25513g.isRealPay() && (payRequest = this.f25510d) != null && payRequest.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f25510d.getRequestId(), this.f25510d);
            } else if (this.f25513g.isRealPay()) {
                PayCallBackManager.callBackClientCancel(this.f25507a, "SmsControllerForBindSMS.onCreateCheckInvalide().1");
                return false;
            }
            this.l = true;
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.f25507a, "SmsControllerForBindSMS.onCreateCheckInvalide().2");
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.NEXT_THIRD, l());
        BindFastRequest bindFastRequest = this.f25513g;
        if (bindFastRequest == null) {
            return;
        }
        bindFastRequest.mSmsVCode = str;
        int i2 = bindFastRequest.getmBindFrom();
        if (i2 == 0) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                e();
            } else {
                g();
            }
        } else if (i2 == 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                f();
            } else {
                g();
            }
        } else if (i2 == 2) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                e();
            } else {
                g();
            }
        } else if (i2 == 3) {
            g();
        } else if (i2 == 6 || i2 == 7 || i2 == 8) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                h();
            } else {
                g();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity = this.f25507a;
        if (payBaseActivity == null) {
            return;
        }
        if (this.l) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f25507a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
            d();
        } else if (TextUtils.isEmpty(this.q)) {
            if (this.j == null) {
                this.j = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 5, ISmsController.BEAN_TAG);
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
            this.j.a(this.f25513g);
            this.j.setResponseCallback((WalletSmsActivity) this.f25507a);
            this.j.execBean();
        } else {
            com.baidu.wallet.paysdk.beans.g gVar = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 17, ISmsController.BEAN_TAG);
            gVar.setResponseCallback(this.f25507a);
            PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
            gVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25507a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25508b = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.o = smsVerifyHandler;
    }

    private void c() {
        if (5320 != this.f25507a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) || this.f25508b == null) {
            return;
        }
        ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.f25507a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
        this.f25508b.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
    }

    private void d() {
        ag agVar = (ag) PayBeanFactory.getInstance().getBean((Context) this.f25507a, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
        agVar.setResponseCallback(this.f25507a);
        agVar.execBean();
    }

    public boolean b() {
        BindFastRequest bindFastRequest = this.f25513g;
        if (bindFastRequest == null) {
            return false;
        }
        int i2 = bindFastRequest.getmBindFrom();
        return i2 == 0 || i2 == 2;
    }

    private boolean a(Object obj) {
        if (obj instanceof GetCardInfoResponse) {
            this.f25507a.finishWithoutAnim();
            PayController.getInstance().completeCardPay(this.f25507a, this.f25510d.mBondCard, (GetCardInfoResponse) obj);
            return true;
        }
        return false;
    }

    private void a(int i2, String str) {
        WalletGlobalUtils.safeDismissDialog(this.f25507a, 0);
        if (this.l) {
            this.l = false;
        }
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.f25507a.getActivity(), "ebpay_send_fail");
        }
        SmsVerifyHandler smsVerifyHandler = this.o;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendFailure(i2, str);
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25508b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.doStopCountDown();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.a
    public void a() {
        s sVar = (s) PayBeanFactory.getInstance().getBean((Context) this.f25507a, 15, ISmsController.BEAN_TAG);
        sVar.setResponseCallback(this.f25507a);
        WalletGlobalUtils.safeShowDialog(this.f25507a, 0, "");
        sVar.execBean();
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25513g = bindFastRequest;
    }

    public void a(PayRequestCache.BindCategory bindCategory) {
        if (bindCategory == null) {
            bindCategory = PayRequestCache.BindCategory.Other;
        }
        this.f25512f = bindCategory;
    }
}
