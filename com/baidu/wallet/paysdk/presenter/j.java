package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.v;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class j extends k {

    /* renamed from: a  reason: collision with root package name */
    public String f25405a;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f25406c;

    /* renamed from: d  reason: collision with root package name */
    public v f25407d;

    public j(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
        this.f25406c = null;
    }

    private void h() {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn == null || ((Integer) checkSecurityEvn.first).intValue() != 0) {
            return;
        }
        Object obj = checkSecurityEvn.second;
        String str = null;
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        }
        if (this.f25406c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25406c.mSecurityParams = Base64.encodeBytes(str.getBytes());
    }

    private void i() {
        if (l()) {
            BankSignFactory bankSignFactory = BankSignFactory.getInstance();
            PayBaseBeanActivity payBaseBeanActivity = this.f25410b;
            com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) bankSignFactory.getBean((Context) payBaseBeanActivity, 768, "PrecashierWelcomePresenter" + toString());
            bVar.a(PayDataCache.getInstance().getSelectedCardNo());
            bVar.setResponseCallback(this);
            bVar.execBean();
            return;
        }
        f();
        this.f25410b.finishWithoutAnim();
    }

    private void j() {
        PwdRequest pwdRequest = new PwdRequest();
        PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
        if (PayDataCache.getInstance().hasBondCards()) {
            Intent intent = new Intent(this.f25410b, AuthorizeSignActivity.class);
            if (com.baidu.wallet.paysdk.a.b.b()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
            } else if (com.baidu.wallet.paysdk.a.b.c()) {
                intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 1);
            }
            this.f25410b.startActivity(intent);
            this.f25410b.finishWithoutAnim();
            return;
        }
        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
        StatHelper.cachePayType(0);
        StatHelper.cachePayWay(4);
        BaiduPay.getInstance().bindCardAuth(this.f25410b, true);
    }

    private void k() {
        PayRequest payRequest = this.f25406c;
        String str = payRequest != null ? payRequest.mParams : "";
        LogUtil.d("present", "doRePayOrder->orderinfo:" + str);
        PayRequest payRequest2 = this.f25406c;
        String payFrom = payRequest2 != null ? payRequest2.getPayFrom() : "";
        PayCallBack payBack = BaiduPay.getInstance().getPayBack();
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        PayBaseBeanActivity.exitEbpay();
        HashMap hashMap = new HashMap();
        hashMap.put(BaiduPay.PAY_FROM, payFrom);
        BaiduPay.getInstance().doPay(this.f25410b.getActivity(), str, payBack, hashMap);
    }

    private boolean l() {
        CardData.BondCard selectedCard;
        PayRequest payRequest = this.f25406c;
        return (payRequest == null || (selectedCard = payRequest.getSelectedCard()) == null || 1 != selectedCard.is_sign_jump_bank) ? false : true;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public boolean a(Bundle bundle) {
        if (bundle == null) {
            this.f25406c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        } else {
            Serializable serializable = bundle.getSerializable("mPayRequest");
            if (serializable != null && (serializable instanceof PayRequest)) {
                this.f25406c = (PayRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayResponse");
            if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
            }
        }
        if (this.f25406c != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f25406c.getRequestId(), this.f25406c);
            return true;
        }
        PayCallBackManager.callBackClientCancel(this.f25410b, "PrecashierWelcomePresenter.initSaveInstanceData().1");
        return false;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void b() {
        h();
        c();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void c() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        this.f25406c = payRequest;
        if (payRequest != null && payRequest.checkRequestValidity()) {
            if (this.f25407d == null) {
                PayBeanFactory payBeanFactory = PayBeanFactory.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.f25410b;
                this.f25407d = (v) payBeanFactory.getBean((Context) payBaseBeanActivity, 1, "PrecashierWelcomePresenter" + toString());
            }
            PayRequest payRequest2 = this.f25406c;
            if (payRequest2 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
                PayStatisticsUtil.onEventStart(StatServiceEvent.ACTIVE_BIND);
            } else {
                StatisticManager.onEventStart(StatServiceEvent.CREATE_PRE_ORDER);
            }
            this.f25407d.a(this.f25405a);
            this.f25407d.setResponseCallback(this);
            this.f25407d.execBean();
            return;
        }
        PayCallBackManager.callBackClientCancel(this.f25410b, "PrecashierWelcomePresenter.loadData().1");
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void d() {
        BeanManager beanManager = BeanManager.getInstance();
        beanManager.removeAllBeans("PrecashierWelcomePresenter" + toString());
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void e() {
        PayCallBackManager.callBackClientCancel(this.f25410b, "PrecashierWelcomePresenter.callBackCancle().1");
    }

    public void f() {
        if (PayDataCache.getInstance().hasMobilePwd()) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                PayController.getInstance().gotoPwdPay(this.f25410b);
            } else if (this.f25406c.isWithHoldingValidity()) {
                PayController.getInstance().gotoWithholdPay(this.f25410b);
            } else {
                PayController payController = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.f25410b;
                payController.gotoOrderConfirm(payBaseBeanActivity, payBaseBeanActivity.getIntent());
            }
        } else if (PayDataCache.getInstance().hasBondCards()) {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            PayController payController2 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity2 = this.f25410b;
            payController2.selectCompletCards(payBaseBeanActivity2, payBaseBeanActivity2.getIntent());
        } else {
            PayController payController3 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity3 = this.f25410b;
            payController3.bindCardPay(payBaseBeanActivity3, payBaseBeanActivity3.getIntent(), true);
        }
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && directPayPay.easypay != null && directPayContentResponse.user != null) {
            i();
        } else {
            PayCallBackManager.callBackClientCancel(this.f25410b, "PrecashierWelcomePresenter.confirmRemotePayOrderInfo().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a() {
        PayBaseBeanActivity payBaseBeanActivity = this.f25410b;
        if (payBaseBeanActivity != null) {
            payBaseBeanActivity.setFlagPaySdk();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Object obj, String str) {
        PayData.EasyPay easyPay;
        if (i2 == 768) {
            GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
            if (getJumpUrlResponse.agreement_trans_id != null) {
                com.baidu.wallet.paysdk.banksign.a.a.a().f(getJumpUrlResponse.agreement_trans_id);
            }
            if (getJumpUrlResponse.is_signed == 0) {
                com.baidu.wallet.paysdk.banksign.a.a.a().a(this);
                String str2 = getJumpUrlResponse.form_data;
                com.baidu.wallet.paysdk.banksign.a.a.a().a(str2 == null ? null : str2.getBytes());
                com.baidu.wallet.paysdk.banksign.a.a.a().a(false);
                com.baidu.wallet.paysdk.banksign.a.a.a().d(getJumpUrlResponse.form_url);
                com.baidu.wallet.paysdk.banksign.a.a.a().e(getJumpUrlResponse.webview_title);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a(this.f25410b);
            } else {
                f();
            }
            this.f25410b.finishWithoutAnim();
            return;
        }
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
            if (this.f25406c == null) {
                PayCallBackManager.callBackClientCancel(this.f25410b, "PrecashierWelcomePresenter.handleResponse().2");
                return;
            }
            UserData.SP sp = directPayContentResponse.sp;
            if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
                this.f25406c.mGoodName = directPayContentResponse.sp.goods_name;
            }
            directPayContentResponse.storeResponse(this.f25410b);
            StatHelper.cacheHasPwd(directPayContentResponse.hasPwd());
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getHasPwd());
            HashMap hashMap = new HashMap();
            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
            StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_ORDER, collectData, hashMap);
            StatHelper.cachePayType("balance".equals(PayDataCache.getInstance().getDefaultPayType()) ? 1 : 0);
            PayRequest payRequest = this.f25406c;
            if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.ACTIVE_BIND, 0);
            } else if (directPayContentResponse.misc != null) {
                ArrayList<String> a3 = a(directPayContentResponse);
                if (!TextUtils.isEmpty(a3.get(0)) && !TextUtils.isEmpty(a3.get(1))) {
                    StatisticManager.onEventEndWithValues(StatServiceEvent.CREATE_PRE_ORDER, 0, a3);
                }
            }
            PayData.DirectPayPay directPayPay2 = directPayContentResponse.pay;
            if (directPayPay2 != null) {
                this.f25406c.setCalcPayment(directPayPay2.composite);
                this.f25406c.setRandomDiscount(directPayContentResponse.pay.random_discount);
            }
            if (directPayContentResponse.isWithHoldingValidity()) {
                this.f25406c.withholding = directPayContentResponse.authorize_common_cashdesk;
            }
            if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f25406c.mPayFrom)) {
                BindFastRequest bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 1;
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                this.f25410b.startActivity(new Intent(this.f25410b, BindCardImplActivity.class));
                this.f25410b.finishWithoutAnim();
                return;
            } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f25406c.mPayFrom)) {
                this.f25406c.initPayStrategy(this.f25410b);
                j();
                return;
            } else {
                this.f25406c.initPayStrategy(this.f25410b);
                if (PayDataCache.getInstance().isRemotePay()) {
                    b(directPayContentResponse);
                    this.f25410b.finishWithoutAnim();
                    return;
                }
                i();
                return;
            }
        }
        PayCallBackManager.callBackClientCancel(this.f25410b, "PrecashierWelcomePresenter.handleResponse().1");
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str) {
        StatisticManager.onEventEnd(StatServiceEvent.CREATE_PRE_ORDER, i3);
        StatisticManager.onEventWithValue(StatServiceEvent.CREATE_PRE_ORDER_FAIL, String.valueOf(i3), str);
        if (i3 == 5173 || i3 == 5172 || (i3 == 5171 && !TextUtils.isEmpty(str))) {
            PayBaseBeanActivity payBaseBeanActivity = this.f25410b;
            if (payBaseBeanActivity != null) {
                WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 3, str);
            }
        } else if (i2 == 768) {
            f();
        } else {
            k();
        }
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        UserData.Misc misc;
        ArrayList<String> arrayList = new ArrayList<>();
        PayRequest payRequest = this.f25406c;
        String str = "\"\"";
        String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? "\"\"" : this.f25406c.mSpNO;
        if (directPayContentResponse != null && (misc = directPayContentResponse.misc) != null) {
            str = misc.getInsideTransOrder();
        }
        arrayList.add(str2);
        arrayList.add(str);
        return arrayList;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str, Object obj) {
        StatisticManager.onEventEnd(StatServiceEvent.CREATE_PRE_ORDER, i3);
        StatisticManager.onEventWithValue(StatServiceEvent.CREATE_PRE_ORDER_FAIL, String.valueOf(i3), str);
        k();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Dialog dialog) {
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideNegativeButton();
            promptDialog.setMessage(WalletGlobalUtils.showStr);
            promptDialog.setPositiveBtn(ResUtils.getString(this.f25410b, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.presenter.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.DismissLoadingDialog();
                    j.this.f25410b.finish();
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(String str) {
        this.f25405a = str;
    }
}
