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
    public PayBaseActivity f25794a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f25795b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorContentResponse f25796c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f25797d;

    /* renamed from: e  reason: collision with root package name */
    public String f25798e;

    /* renamed from: f  reason: collision with root package name */
    public PayRequestCache.BindCategory f25799f;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f25800g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.b f25801h;
    public aj i;
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
        WalletGlobalUtils.safeShowDialog(this.f25794a, 0, "");
        if (this.n == null) {
            this.n = (y) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 13, ISmsController.BEAN_TAG);
        }
        this.n.setResponseCallback((WalletSmsActivity) this.f25794a);
        this.n.b(this.f25794a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
        this.n.execBean();
    }

    private void f() {
        WalletGlobalUtils.safeShowDialog(this.f25794a, 0, "");
        if (this.f25801h == null) {
            this.f25801h = (com.baidu.wallet.paysdk.beans.b) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 513, ISmsController.BEAN_TAG);
        }
        PayStatisticsUtil.onEventStart(StatServiceEvent.BIND_CARD);
        this.f25801h.a(this.f25800g);
        this.f25801h.setResponseCallback((WalletSmsActivity) this.f25794a);
        this.f25801h.execBean();
    }

    private void g() {
        BindFastRequest bindFastRequest = this.f25800g;
        if (bindFastRequest != null && bindFastRequest.isNeedCheckSms()) {
            WalletGlobalUtils.safeShowDialog(this.f25794a, 0, "");
            if (this.i == null) {
                this.i = (aj) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 11, ISmsController.BEAN_TAG);
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.VERIFY_SMS);
            int i = this.f25800g.getmBindFrom();
            if (i != 6 && i != 7 && i != 8) {
                this.i.a(false);
            } else {
                this.i.a(true);
            }
            this.i.a(this.f25800g);
            this.i.setResponseCallback((WalletSmsActivity) this.f25794a);
            this.i.execBean();
            return;
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        WalletGlobalUtils.safeShowDialog(this.f25794a, 0, "");
        if (this.n == null) {
            this.n = (y) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 13, ISmsController.BEAN_TAG);
        }
        this.n.setResponseCallback((WalletSmsActivity) this.f25794a);
        this.n.b(this.f25794a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
        this.n.execBean();
    }

    private void i() {
        if (this.f25800g == null) {
            return;
        }
        PasswordController.getPassWordInstance().setPwd(this.f25794a, false, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.1
            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i, String str) {
                SmsUpdateUiInterface smsUpdateUiInterface = d.this.f25795b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.clearSmsEditText();
                    d.this.f25795b.doStopCountDown();
                }
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                int i = d.this.f25800g.getmBindFrom();
                if (i == 1) {
                    PayController.getInstance().bindSuccess(null);
                } else if (i == 3) {
                    PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                } else if (i == 4) {
                    PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                } else if (i == 6 || i == 7 || i == 8) {
                    d.this.h();
                }
            }
        }, this.f25799f);
        this.p = true;
    }

    private boolean j() {
        BindFastRequest bindFastRequest = this.f25800g;
        return (bindFastRequest == null || bindFastRequest.mBondCard == null || bindFastRequest.getmBindFrom() != 2 || this.f25800g.mBondCard.isNeedSendSms()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        String string = ResUtils.getString(this.f25794a, "ebpay_confirm");
        BindFastRequest bindFastRequest = this.f25800g;
        if (bindFastRequest == null) {
            return string;
        }
        int i = bindFastRequest.mBindFrom;
        if (i == 0) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                PayRequest payRequest = this.f25797d;
                if (payRequest != null && payRequest.mMktSolution != null) {
                    return String.format(ResUtils.getString(this.f25794a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25797d.mMktSolution.easypay_amount));
                }
                if (this.f25800g != null) {
                    return String.format(ResUtils.getString(this.f25794a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25800g.getFinalPayAmount()));
                }
                return ResUtils.getString(this.f25794a, "ebpay_submit_pay");
            }
            return ResUtils.getString(this.f25794a, "wallet_base_next_step");
        } else if (i == 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                return ResUtils.getString(this.f25794a, "ebpay_pwd_done");
            }
            return ResUtils.getString(this.f25794a, "wallet_base_next_step");
        } else if (i == 2) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                PayRequest payRequest2 = this.f25797d;
                if (payRequest2 != null) {
                    if (payRequest2.mMktSolution != null) {
                        return String.format(ResUtils.getString(this.f25794a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25797d.mMktSolution.easypay_amount));
                    }
                    return String.format(ResUtils.getString(this.f25794a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25797d.getFinalPayAmount()));
                }
                return ResUtils.getString(this.f25794a, "ebpay_submit_pay");
            }
            return ResUtils.getString(this.f25794a, "wallet_base_next_step");
        } else if (i != 3) {
            if (i == 6 || i == 7 || i == 8) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    if (com.baidu.wallet.paysdk.a.b.c()) {
                        PayRequest payRequest3 = this.f25797d;
                        if (payRequest3 != null && payRequest3.mMktSolution != null) {
                            return String.format(ResUtils.getString(this.f25794a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25797d.mMktSolution.easypay_amount));
                        }
                        if (this.f25800g != null) {
                            return String.format(ResUtils.getString(this.f25794a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25800g.getFinalPayAmount()));
                        }
                        return ResUtils.getString(this.f25794a, "ebpay_submit_pay");
                    }
                    return ResUtils.getString(this.f25794a, "bd_wallet_auth_submit_sign");
                }
                return ResUtils.getString(this.f25794a, "wallet_base_next_step");
            }
            return string;
        } else {
            return ResUtils.getString(this.f25794a, "wallet_base_next_step");
        }
    }

    private ArrayList<String> l() {
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.f25797d;
        arrayList.add(payRequest != null ? payRequest.mSpNO : "");
        PayRequest payRequest2 = this.f25797d;
        arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        if (i2 != 80320 && i2 != 80321 && i2 != 80326 && i2 != 80327) {
            if (obj instanceof ErrorContentResponse) {
                ErrorContentResponse errorContentResponse = (ErrorContentResponse) obj;
                if (errorContentResponse.card_item_required != null && this.f25800g.getmBindFrom() == 2) {
                    this.k = str;
                    this.f25796c = errorContentResponse;
                    WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
                    WalletGlobalUtils.safeShowDialog(this.f25794a, 40, "");
                    return true;
                } else if (i2 == 15500) {
                    this.k = str;
                    PayBaseActivity payBaseActivity = this.f25794a;
                    payBaseActivity.mPayErrorCode = i2;
                    payBaseActivity.mBeanId = i;
                    this.f25796c = errorContentResponse;
                    WalletGlobalUtils.safeDismissDialog(payBaseActivity, 0);
                    WalletGlobalUtils.safeShowDialog(this.f25794a, 65316, "");
                    return true;
                }
            }
            return false;
        }
        WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
        PayDataCache.getInstance().cleanDetainmentDesc();
        if (obj instanceof ErrorContentResponse) {
            this.f25796c = (ErrorContentResponse) obj;
            if (!TextUtils.isEmpty(str)) {
                this.k = str;
                PayBaseActivity payBaseActivity2 = this.f25794a;
                payBaseActivity2.mPayErrorCode = i2;
                payBaseActivity2.mBeanId = i;
                WalletGlobalUtils.safeShowDialog(payBaseActivity2, ISmsController.DIALOG_CANNOT_DISCOUNT, "");
            }
        }
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i) {
        if (i == 65315) {
            return new PromptDialog(this.f25794a.getActivity());
        }
        if (i == 65316) {
            return new PromptDialog(this.f25794a.getActivity());
        }
        if (i == 65283) {
            return new PromptDialog(this.f25794a.getActivity());
        }
        if (i == 40) {
            return new PromptDialog(this.f25794a.getActivity());
        }
        return null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        if (this.p) {
            PasswordController.getPassWordInstance().clearSetPwdListener();
        }
        this.f25794a = null;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 40:
                final PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.k);
                promptDialog.hideNegativeButton();
                promptDialog.setPositiveBtn(ResUtils.string(this.f25794a, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayController payController = PayController.getInstance();
                        d dVar = d.this;
                        payController.updateCardInfoPay(dVar.f25794a, dVar.f25796c);
                        promptDialog.dismiss();
                        d.this.f25794a.finishWithoutAnim();
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
                promptDialog3.setNegativeBtn(ResUtils.getString(this.f25794a, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25794a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_cancel"));
                        WalletGlobalUtils.safeDismissDialog(d.this.f25794a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                    }
                });
                promptDialog3.setPositiveBtn(ResUtils.getString(this.f25794a, "bd_wallet_pay_by_order_price"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25794a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                        d dVar = d.this;
                        ErrorContentResponse errorContentResponse = dVar.f25796c;
                        if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                            return;
                        }
                        if (dVar.j == null) {
                            d.this.j = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) d.this.f25794a, 5, ISmsController.BEAN_TAG);
                        }
                        ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(d.this.f25796c.mkt_solution);
                        PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
                        d.this.j.a(d.this.f25800g);
                        d.this.j.setResponseCallback((WalletSmsActivity) d.this.f25794a);
                        d.this.j.execBean();
                        WalletGlobalUtils.safeShowDialog(d.this.f25794a, 0, "");
                        WalletGlobalUtils.safeDismissDialog(d.this.f25794a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                        d dVar2 = d.this;
                        if (dVar2.f25795b != null) {
                            String k = dVar2.k();
                            if (!TextUtils.isEmpty(k)) {
                                d.this.f25795b.updateButtonTip(k);
                            }
                        }
                        SmsUpdateUiInterface smsUpdateUiInterface = d.this.f25795b;
                        if (smsUpdateUiInterface != null) {
                            smsUpdateUiInterface.clearSmsEditText();
                            d.this.f25795b.doStartCountDown();
                        }
                    }
                });
                return true;
            case 65316:
                StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_CARD_UPDATE);
                PayRequest payRequest = this.f25797d;
                if (payRequest != null && payRequest.mBondCard != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
                    this.f25797d.mBondCard.hideSMSDialog = true;
                }
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(this.k);
                promptDialog4.showCloseBtn(false);
                promptDialog4.setCanceledOnTouchOutside(false);
                if (j()) {
                    promptDialog4.hideNegativeButton();
                }
                promptDialog4.setNegativeBtn(ResUtils.getString(this.f25794a, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25794a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_cancel"));
                        WalletGlobalUtils.safeDismissDialog(d.this.f25794a, 65316);
                        PayBaseActivity payBaseActivity2 = d.this.f25794a;
                        if (payBaseActivity2 instanceof WalletSmsActivity) {
                            payBaseActivity2.finishWithoutAnim();
                        }
                    }
                });
                promptDialog4.setPositiveBtn(ResUtils.string(this.f25794a, "ebpay_wallet_continue_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.sms.controller.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PayBaseActivity payBaseActivity = d.this.f25794a;
                        payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                        WalletGlobalUtils.safeDismissDialog(d.this.f25794a, 65316);
                        PayController payController = PayController.getInstance();
                        d dVar = d.this;
                        payController.updateCardInfoPay(dVar.f25794a, dVar.f25796c);
                        d.this.f25794a.finishWithoutAnim();
                    }
                });
                return true;
            default:
                return false;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("mBindRequest", this.f25800g);
        bundle.putSerializable("mPayRequest", this.f25797d);
        bundle.putSerializable("mCardInfoUpdateContent", this.f25796c);
        bundle.putBoolean("isSendSMSForCompletionPay", this.m);
        bundle.putString("mDialogMsg", this.k);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i, int i2, String str) {
        if (i2 == 65025) {
            GlobalUtils.toast(this.f25794a, str);
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            return true;
        } else if (i == 5 || i == 17) {
            if (i2 == 5003) {
                AccountManager.getInstance(this.f25794a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            a(i2, str);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, i2);
            return true;
        } else if (i == 11) {
            WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
            if (i2 == 5003) {
                AccountManager.getInstance(this.f25794a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            SmsVerifyHandler smsVerifyHandler = this.o;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsVerifyFailure(i2, str);
            }
            PayStatisticsUtil.onEvent(StatServiceEvent.VERFY_SMS_FAIL);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.VERIFY_SMS, i2);
            return true;
        } else if (i != 13 && i != 513) {
            if (i == 264) {
                a(i2, str);
                return true;
            }
            return false;
        } else {
            if (i2 == 5003) {
                AccountManager.getInstance(this.f25794a).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
            if (i2 == 60500) {
                this.k = str;
                WalletGlobalUtils.safeShowDialog(this.f25794a, ISmsController.DIALOG_PROMPT, "");
            } else {
                SmsVerifyHandler smsVerifyHandler2 = this.o;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifyFailure(i2, str);
                }
            }
            if (i == 13) {
                BindFastRequest bindFastRequest = this.f25800g;
                if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f25800g.getmBindFrom() == 6)) {
                    String orderNo = StatHelper.getOrderNo();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(orderNo, i2 + "", str));
                }
                StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, i2);
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.BIND_PAY_ACCEPT_FAIL, String.valueOf(i2));
            } else {
                String sessionId = StatHelper.getSessionId();
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(sessionId, i2 + "", str));
                PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, i2);
            }
            return true;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i, Object obj, String str) {
        if (i == 5 || i == 17) {
            WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
            CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            if (checkCardInfoResponse != null && checkCardInfoResponse.checkResponseValidity()) {
                if (this.f25800g != null) {
                    this.f25800g.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
                    if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                        this.f25800g.setChannelNo(checkCardInfoResponse.channel_no);
                    }
                }
                if (this.l) {
                    this.l = false;
                    SmsUpdateUiInterface smsUpdateUiInterface = this.f25795b;
                    if (smsUpdateUiInterface != null) {
                        smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
                    }
                }
                SmsUpdateUiInterface smsUpdateUiInterface2 = this.f25795b;
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
        } else if (i == 11) {
            WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
            PayStatisticsUtil.onEvent(StatServiceEvent.VERIFY_SMS_SUCCESS);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.VERIFY_SMS, 0);
            i();
            SmsVerifyHandler smsVerifyHandler2 = this.o;
            if (smsVerifyHandler2 != null) {
                smsVerifyHandler2.onSmsVerifySuccess();
            }
            return true;
        } else if (i == 513) {
            WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
            PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, 0);
            PayRequest payRequest = this.f25797d;
            if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                PayController.getInstance().bindExtSuccess(this.f25794a, obj);
            } else {
                PayController.getInstance().bindSuccess(obj);
            }
            SmsVerifyHandler smsVerifyHandler3 = this.o;
            if (smsVerifyHandler3 != null) {
                smsVerifyHandler3.onSmsVerifySuccess();
            }
            return true;
        } else if (i != 13) {
            if (i != 264) {
                if (i == 15) {
                    return a(obj);
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
            SmsVerifyHandler smsVerifyHandler4 = this.o;
            if (smsVerifyHandler4 != null) {
                smsVerifyHandler4.onSmsSendSuccess();
            }
            return true;
        } else {
            BindFastRequest bindFastRequest = this.f25800g;
            if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f25800g.getmBindFrom() == 6)) {
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
        if (this.f25800g == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f25798e)) {
            unicodeDecode = !TextUtils.isEmpty(this.f25800g.getSendSmsphone()) ? this.f25800g.getSendSmsphone() : "";
        } else {
            unicodeDecode = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.f25798e));
        }
        String str = unicodeDecode;
        String k = k();
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25795b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", k, str, true);
            this.f25795b.updateModifyPhoneUI(!TextUtils.isEmpty(this.q), this.q);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        return true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        BindFastRequest bindFastRequest = this.f25800g;
        if (bindFastRequest != null) {
            if (bindFastRequest.mBindFrom == 2 && this.m) {
                c();
                return 5320 != this.f25794a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
            }
            BindFastRequest bindFastRequest2 = this.f25800g;
            if (bindFastRequest2.mBindFrom == 8) {
                c();
                return 5320 != this.f25794a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f25795b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.upDateSafeKeyBoradView(bindFastRequest2.getSmsLength(), this.f25800g.getSmsType());
            }
        }
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        PayRequest payRequest;
        this.q = this.f25794a.getIntent().getStringExtra(BeanConstants.UPDATE_MOBILE_DESC);
        if (bundle == null) {
            this.m = this.f25794a.getIntent().getBooleanExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
            if (this.f25800g == null) {
                this.f25800g = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            }
            if (this.f25799f == null) {
                this.f25799f = PayRequestCache.BindCategory.Other;
            }
            this.f25797d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            Serializable serializableExtra = this.f25794a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            if (serializableExtra != null) {
                this.f25798e = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
            }
        } else {
            this.m = bundle.getBoolean("isSendSMSForCompletionPay");
            this.k = bundle.getString("mDialogMsg");
            Serializable serializable = bundle.getSerializable("mBindRequest");
            if (serializable != null && (serializable instanceof BindFastRequest)) {
                this.f25800g = (BindFastRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.f25797d = (PayRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("mCardInfoUpdateContent");
            if (serializable3 != null && (serializable3 instanceof ErrorContentResponse)) {
                this.f25796c = (ErrorContentResponse) serializable3;
            }
            this.f25798e = bundle.getString("phone_no");
        }
        BindFastRequest bindFastRequest = this.f25800g;
        if (bindFastRequest != null && bindFastRequest.checkRequestValidity()) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f25800g.getRequestId(), this.f25800g);
            if (this.f25800g.isRealPay() && (payRequest = this.f25797d) != null && payRequest.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f25797d.getRequestId(), this.f25797d);
            } else if (this.f25800g.isRealPay()) {
                PayCallBackManager.callBackClientCancel(this.f25794a, "SmsControllerForBindSMS.onCreateCheckInvalide().1");
                return false;
            }
            this.l = true;
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.f25794a, "SmsControllerForBindSMS.onCreateCheckInvalide().2");
        return false;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        PayStatisticsUtil.onEventWithValues(StatServiceEvent.NEXT_THIRD, l());
        BindFastRequest bindFastRequest = this.f25800g;
        if (bindFastRequest == null) {
            return;
        }
        bindFastRequest.mSmsVCode = str;
        int i = bindFastRequest.getmBindFrom();
        if (i == 0) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                e();
            } else {
                g();
            }
        } else if (i == 1) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                f();
            } else {
                g();
            }
        } else if (i == 2) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                e();
            } else {
                g();
            }
        } else if (i == 3) {
            g();
        } else if (i == 6 || i == 7 || i == 8) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                h();
            } else {
                g();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity = this.f25794a;
        if (payBaseActivity == null) {
            return;
        }
        if (this.l) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f25794a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
            d();
        } else if (TextUtils.isEmpty(this.q)) {
            if (this.j == null) {
                this.j = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 5, ISmsController.BEAN_TAG);
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
            this.j.a(this.f25800g);
            this.j.setResponseCallback((WalletSmsActivity) this.f25794a);
            this.j.execBean();
        } else {
            com.baidu.wallet.paysdk.beans.g gVar = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 17, ISmsController.BEAN_TAG);
            gVar.setResponseCallback(this.f25794a);
            PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
            gVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        this.f25794a = payBaseActivity;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        this.f25795b = smsUpdateUiInterface;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        this.o = smsVerifyHandler;
    }

    private void c() {
        if (5320 != this.f25794a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) || this.f25795b == null) {
            return;
        }
        ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.f25794a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
        this.f25795b.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
    }

    private void d() {
        ag agVar = (ag) PayBeanFactory.getInstance().getBean((Context) this.f25794a, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
        agVar.setResponseCallback(this.f25794a);
        agVar.execBean();
    }

    public boolean b() {
        BindFastRequest bindFastRequest = this.f25800g;
        if (bindFastRequest == null) {
            return false;
        }
        int i = bindFastRequest.getmBindFrom();
        return i == 0 || i == 2;
    }

    private boolean a(Object obj) {
        if (obj instanceof GetCardInfoResponse) {
            this.f25794a.finishWithoutAnim();
            PayController.getInstance().completeCardPay(this.f25794a, this.f25797d.mBondCard, (GetCardInfoResponse) obj);
            return true;
        }
        return false;
    }

    private void a(int i, String str) {
        WalletGlobalUtils.safeDismissDialog(this.f25794a, 0);
        if (this.l) {
            this.l = false;
        }
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(this.f25794a.getActivity(), "ebpay_send_fail");
        }
        SmsVerifyHandler smsVerifyHandler = this.o;
        if (smsVerifyHandler != null) {
            smsVerifyHandler.onSmsSendFailure(i, str);
        }
        SmsUpdateUiInterface smsUpdateUiInterface = this.f25795b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.doStopCountDown();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.a
    public void a() {
        s sVar = (s) PayBeanFactory.getInstance().getBean((Context) this.f25794a, 15, ISmsController.BEAN_TAG);
        sVar.setResponseCallback(this.f25794a);
        WalletGlobalUtils.safeShowDialog(this.f25794a, 0, "");
        sVar.execBean();
    }

    public void a(BindFastRequest bindFastRequest) {
        this.f25800g = bindFastRequest;
    }

    public void a(PayRequestCache.BindCategory bindCategory) {
        if (bindCategory == null) {
            bindCategory = PayRequestCache.BindCategory.Other;
        }
        this.f25799f = bindCategory;
    }
}
