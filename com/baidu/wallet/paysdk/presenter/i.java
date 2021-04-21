package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.StatusCode;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayErrorContent;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.H5PayWebViewActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends k {

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f25450a;

    /* renamed from: c  reason: collision with root package name */
    public v f25451c;

    public i(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
        this.f25450a = null;
    }

    private void f() {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn == null || ((Integer) checkSecurityEvn.first).intValue() != 0) {
            return;
        }
        Object obj = checkSecurityEvn.second;
        String str = null;
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        }
        if (this.f25450a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25450a.mSecurityParams = Base64.encodeBytes(str.getBytes());
    }

    private void h() {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                PayController.getInstance().gotoPwdPay(this.f25462b);
            } else if (this.f25450a.isWithHoldingValidity()) {
                PayController.getInstance().gotoWithholdPay(this.f25462b);
            } else {
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_ORDER_CONFIRM_ACTIVITY);
                } else {
                    StatisticManager.onEvent(StatServiceEvent.ENTER_ORDER_CONFIRM_ACTIVITY);
                }
                PayController payController = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.f25462b;
                payController.gotoOrderConfirm(payBaseBeanActivity, payBaseBeanActivity.getIntent());
            }
        } else if (PayDataCache.getInstance().hasBondCards()) {
            if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_SELECT_CARD_ACTIVITY);
            } else {
                StatisticManager.onEvent(StatServiceEvent.ENTER_SELECT_CARD_ACTIVITY);
            }
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            PayController payController2 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity2 = this.f25462b;
            payController2.selectCompletCards(payBaseBeanActivity2, payBaseBeanActivity2.getIntent());
        } else {
            if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_BIND_CARD_ACTIVITY);
            } else {
                StatisticManager.onEvent(StatServiceEvent.ENTER_BIND_CARD_ACTIVITY);
            }
            PayController payController3 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity3 = this.f25462b;
            payController3.bindCardPay(payBaseBeanActivity3, payBaseBeanActivity3.getIntent(), true);
        }
    }

    private void i() {
        PwdRequest pwdRequest = new PwdRequest();
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        if (PayDataCache.getInstance().hasBondCards()) {
            Intent intent = new Intent(this.f25462b, AuthorizeSignActivity.class);
            if (com.baidu.wallet.paysdk.a.b.b()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
            } else if (com.baidu.wallet.paysdk.a.b.c()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 1);
            }
            this.f25462b.startActivity(intent);
            this.f25462b.finishWithoutAnim();
            return;
        }
        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        BaiduPay.getInstance().bindCardAuth(this.f25462b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        PayRequest payRequest = this.f25450a;
        String str = payRequest != null ? payRequest.mParams : "";
        LogUtil.d("present", "doRePayOrder->orderinfo:" + str);
        PayRequest payRequest2 = this.f25450a;
        String payFrom = payRequest2 != null ? payRequest2.getPayFrom() : "";
        PayCallBack payBack = BaiduPay.getInstance().getPayBack();
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        PayBaseBeanActivity.exitEbpay();
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.PAY_FROM, payFrom);
        BaiduPay.getInstance().doPay(this.f25462b.getActivity(), str, payBack, hashMap);
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(String str) {
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void b() {
        f();
        c();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void c() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        this.f25450a = payRequest;
        if (payRequest != null && payRequest.checkRequestValidity()) {
            if (this.f25451c == null) {
                PayBeanFactory payBeanFactory = PayBeanFactory.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.f25462b;
                this.f25451c = (v) payBeanFactory.getBean((Context) payBaseBeanActivity, 1, "PayWelcomePresenter" + toString());
            }
            PayRequest payRequest2 = this.f25450a;
            if (payRequest2 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    PayStatisticsUtil.onEventStart(StatServiceEvent.REMOTE_ACTIVE_BIND);
                } else {
                    PayStatisticsUtil.onEventStart(StatServiceEvent.ACTIVE_BIND);
                }
            } else if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEventStart(StatServiceEvent.REMOTE_CREATE_ORDER);
            } else {
                StatisticManager.onEventStart(StatServiceEvent.CREATE_ORDER);
            }
            this.f25451c.setResponseCallback(this);
            this.f25451c.execBean();
        } else if (PayDataCache.getInstance().isRemotePay()) {
            StatisticManager.onEvent(StatServiceEvent.REMOTE_PRE_CREATE_ORDER_PAY_REQ_INVALID);
            PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.loadData().1 remotePay");
        } else {
            PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.loadData().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void d() {
        BeanManager beanManager = BeanManager.getInstance();
        beanManager.removeAllBeans("PayWelcomePresenter" + toString());
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void e() {
        PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.callBackCancle().1");
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public boolean a(Bundle bundle) {
        if (bundle == null) {
            this.f25450a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        } else {
            Serializable serializable = bundle.getSerializable("mPayRequest");
            if (serializable != null && (serializable instanceof PayRequest)) {
                this.f25450a = (PayRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayResponse");
            if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
            }
        }
        if (this.f25450a != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f25450a.getRequestId(), this.f25450a);
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.initSaveInstanceData().1");
        return false;
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && ((directPayPay.easypay != null || directPayPay.balance != null) && directPayContentResponse.user != null)) {
            h();
            return;
        }
        StatisticManager.onEvent(StatServiceEvent.REMOTE_ORDER_INFO_INVALID);
        PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.confirmRemotePayOrderInfo().1");
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a() {
        PayBaseBeanActivity payBaseBeanActivity = this.f25462b;
        if (payBaseBeanActivity != null) {
            payBaseBeanActivity.setFlagPaySdk();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i, Object obj, String str) {
        PayData.EasyPay easyPay;
        DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
        if (directPayContentResponse != null && directPayContentResponse.checkResponseValidity()) {
            UserData.UserModel userModel = directPayContentResponse.user;
            if (userModel != null) {
                userModel.decrypt();
            }
            PayData.DirectPayPay directPayPay = directPayContentResponse.pay;
            if (directPayPay != null && (easyPay = directPayPay.easypay) != null) {
                easyPay.decrypt();
            }
            if (this.f25450a == null) {
                PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.handleResponse().2");
                return;
            }
            UserData.SP sp = directPayContentResponse.sp;
            if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
                this.f25450a.mGoodName = directPayContentResponse.sp.goods_name;
            }
            directPayContentResponse.storeResponse(this.f25462b);
            PayRequest payRequest = this.f25450a;
            if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.REMOTE_ACTIVE_BIND, 0);
                } else {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.ACTIVE_BIND, 0);
                }
            } else {
                UserData.Misc misc = directPayContentResponse.misc;
                if (misc != null) {
                    this.f25450a.title_url = misc.title_url;
                    ArrayList<String> a2 = a(directPayContentResponse);
                    if (!TextUtils.isEmpty(a2.get(0)) && !TextUtils.isEmpty(a2.get(1))) {
                        if (PayDataCache.getInstance().isRemotePay()) {
                            StatisticManager.onEventEndWithValues(StatServiceEvent.REMOTE_CREATE_ORDER, 0, a2);
                        } else {
                            StatisticManager.onEventEndWithValues(StatServiceEvent.CREATE_ORDER, 0, a2);
                        }
                    }
                }
            }
            PayData.DirectPayPay directPayPay2 = directPayContentResponse.pay;
            if (directPayPay2 != null) {
                this.f25450a.setCalcPayment(directPayPay2.composite);
                this.f25450a.setRandomDiscount(directPayContentResponse.pay.random_discount);
            }
            if (directPayContentResponse.isWithHoldingValidity()) {
                this.f25450a.withholding = directPayContentResponse.authorize_common_cashdesk;
            }
            StatHelper.cacheHasPwd(directPayContentResponse.hasPwd());
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getHasPwd());
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
            if (StatHelper.isPrecashierPay(StatHelper.getOrderNo())) {
                hashMap.put("pay_category", "1");
            }
            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_ORDER, collectData, hashMap);
            if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f25450a.mPayFrom)) {
                BindFastRequest bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 1;
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                this.f25462b.startActivity(new Intent(this.f25462b, BindCardImplActivity.class));
                this.f25462b.finishWithoutAnim();
                return;
            } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f25450a.mPayFrom)) {
                this.f25450a.initPayStrategy(this.f25462b);
                Authorize authorize = directPayContentResponse.authorize;
                if (authorize != null) {
                    this.f25450a.title_url = authorize.title_url;
                }
                i();
                return;
            } else {
                this.f25450a.initPayStrategy(this.f25462b);
                if (PayDataCache.getInstance().isRemotePay()) {
                    b(directPayContentResponse);
                } else {
                    h();
                }
                this.f25462b.finishWithoutAnim();
                return;
            }
        }
        PayCallBackManager.callBackClientCancel(this.f25462b, "PayWelcomePresenter.handleResponse().1");
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i, int i2, String str) {
        if (5170 == i2) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1150");
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RNAUTH_ENTER, StatHelper.getOrderNo());
            BaiduPayDelegate.getInstance().doPayRNAuth(this.f25462b, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.presenter.i.1
                @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                public void onRNAuthResult(int i3, String str2) {
                    String orderNo = StatHelper.getOrderNo();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RNAUTH_RESULT, StatHelper.collectData(orderNo, i3 + "", str2));
                    if (i3 == 0) {
                        i.this.j();
                    } else {
                        i.this.e();
                    }
                }
            });
        } else if (i2 == 65340) {
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CREATE_ORDER, i2);
            PayBaseBeanActivity payBaseBeanActivity = this.f25462b;
            if (payBaseBeanActivity != null) {
                WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 55, str);
            }
        } else {
            PayRequest payRequest = this.f25450a;
            if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.REMOTE_ACTIVE_BIND, i2);
                } else {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.ACTIVE_BIND, i2);
                }
            } else if (PayDataCache.getInstance().isRemotePay()) {
                PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.REMOTE_CREATE_ORDER, i2, a((DirectPayContentResponse) null));
            } else {
                PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.CREATE_ORDER, i2, a((DirectPayContentResponse) null));
            }
            super.a(i, i2, str);
        }
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        UserData.Misc misc;
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.f25450a;
        String str = "\"\"";
        String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? "\"\"" : this.f25450a.mSpNO;
        if (directPayContentResponse != null && (misc = directPayContentResponse.misc) != null) {
            str = misc.getInsideTransOrder();
        }
        arrayList.add(str2);
        arrayList.add(str);
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i, int i2, String str, Object obj) {
        DirectPayErrorContent directPayErrorContent = (obj == null || !(obj instanceof DirectPayErrorContent)) ? null : (DirectPayErrorContent) obj;
        if (i2 == 65015 && directPayErrorContent != null && !TextUtils.isEmpty(directPayErrorContent.order_url)) {
            BaiduPay.getInstance().jumpWapCashier(this.f25462b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
        } else {
            super.a(i, i2, str, obj);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i, Dialog dialog) {
        if (i == 55) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideTitle();
            promptDialog.setMessage(WalletGlobalUtils.showStr);
            promptDialog.setPositiveBtn(ResUtils.string(this.f25462b, "wallet_base_to_rnauth_for_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.presenter.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.NAME_NOT_MATCH_TO_CONFIRM);
                    HashMap hashMap = new HashMap();
                    hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1171");
                    BaiduPayDelegate.getInstance().doRNAuth(i.this.f25462b, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.presenter.i.2.1
                        @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                        public void onRNAuthResult(int i2, String str) {
                            if (i2 == 0) {
                                i.this.j();
                            } else {
                                i.this.e();
                            }
                        }
                    });
                    WalletGlobalUtils.safeDismissDialog(i.this.f25462b, 55);
                    i.this.f25462b.finish();
                }
            });
            promptDialog.setNegativeBtn(ResUtils.string(this.f25462b, "wallet_base_quit_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.presenter.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.NAME_NOT_MATCH_TO_CANCEL);
                    i.this.e();
                    WalletGlobalUtils.safeDismissDialog(i.this.f25462b, 55);
                    i.this.f25462b.finish();
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        if (precashierCreateOrderResponse != null) {
            if (TextUtils.equals(precashierCreateOrderResponse.ret, "0")) {
                PayStatisticsUtil.onEventStart(StatServiceEvent.CREATE_ORDER);
                a(-1, precashierCreateOrderResponse.content, (String) null);
                return;
            } else if (Integer.parseInt(precashierCreateOrderResponse.ret) != 5173 && Integer.parseInt(precashierCreateOrderResponse.ret) != 5172 && (Integer.parseInt(precashierCreateOrderResponse.ret) != 5171 || TextUtils.isEmpty(precashierCreateOrderResponse.msg))) {
                if (TextUtils.equals(precashierCreateOrderResponse.ret, "5170")) {
                    String str = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).mParams;
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1150");
                    StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RNAUTH_ENTER, StatHelper.getOrderNo());
                    BaiduPayDelegate.getInstance().doPayRNAuth(this.f25462b, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.presenter.i.4
                        @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                        public void onRNAuthResult(int i, String str2) {
                            String orderNo = StatHelper.getOrderNo();
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RNAUTH_RESULT, StatHelper.collectData(orderNo, i + "", str2));
                            i.this.e();
                        }
                    });
                    return;
                } else if (TextUtils.equals(precashierCreateOrderResponse.ret, String.valueOf((int) StatusCode.ERROR_AUTH_INFO_NOT_MATCH))) {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.PRE_CREATE_ORDER_FROM_TRANSFER, Integer.valueOf(precashierCreateOrderResponse.ret).intValue());
                    PayBaseBeanActivity payBaseBeanActivity = this.f25462b;
                    if (payBaseBeanActivity != null) {
                        WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 55, precashierCreateOrderResponse.msg);
                        return;
                    }
                    return;
                } else {
                    DirectPayErrorContent directPayErrorContent = precashierCreateOrderResponse.errContent;
                    if (directPayErrorContent != null) {
                        try {
                            if (Integer.parseInt(precashierCreateOrderResponse.ret) != 65015 || TextUtils.isEmpty(directPayErrorContent.order_url)) {
                                return;
                            }
                            BaiduPay.getInstance().jumpWapCashier(this.f25462b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
                            return;
                        } catch (Exception unused) {
                            c();
                            return;
                        }
                    }
                    try {
                        a(-1, Integer.parseInt(precashierCreateOrderResponse.ret), precashierCreateOrderResponse.msg);
                        return;
                    } catch (Exception unused2) {
                        c();
                        return;
                    }
                }
            } else {
                PayBaseBeanActivity payBaseBeanActivity2 = this.f25462b;
                if (payBaseBeanActivity2 != null) {
                    WalletGlobalUtils.safeShowDialog(payBaseBeanActivity2, 3, precashierCreateOrderResponse.msg);
                    return;
                }
                return;
            }
        }
        c();
    }
}
