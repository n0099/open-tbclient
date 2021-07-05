package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f26133a;

    /* renamed from: c  reason: collision with root package name */
    public PayRequest f26134c;

    /* renamed from: d  reason: collision with root package name */
    public v f26135d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payBaseBeanActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((PayBaseBeanActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26134c = null;
    }

    private void h() {
        Pair<Integer, Object> checkSecurityEvn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn()) != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.f26134c == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f26134c.mSecurityParams = Base64.encodeBytes(str.getBytes());
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            if (l()) {
                BankSignFactory bankSignFactory = BankSignFactory.getInstance();
                PayBaseBeanActivity payBaseBeanActivity = this.f26138b;
                com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) bankSignFactory.getBean((Context) payBaseBeanActivity, 768, "PrecashierWelcomePresenter" + toString());
                bVar.a(PayDataCache.getInstance().getSelectedCardNo());
                bVar.setResponseCallback(this);
                bVar.execBean();
                return;
            }
            f();
            this.f26138b.finishWithoutAnim();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            PwdRequest pwdRequest = new PwdRequest();
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            if (PayDataCache.getInstance().hasBondCards()) {
                Intent intent = new Intent(this.f26138b, AuthorizeSignActivity.class);
                if (com.baidu.wallet.paysdk.a.b.b()) {
                    intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
                } else if (com.baidu.wallet.paysdk.a.b.c()) {
                    intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 1);
                }
                this.f26138b.startActivity(intent);
                this.f26138b.finishWithoutAnim();
                return;
            }
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            BaiduPay.getInstance().bindCardAuth(this.f26138b, true);
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            PayRequest payRequest = this.f26134c;
            String str = payRequest != null ? payRequest.mParams : "";
            LogUtil.d("present", "doRePayOrder->orderinfo:" + str);
            PayRequest payRequest2 = this.f26134c;
            String payFrom = payRequest2 != null ? payRequest2.getPayFrom() : "";
            PayCallBack payBack = BaiduPay.getInstance().getPayBack();
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", payFrom);
            BaiduPay.getInstance().doPay(this.f26138b.getActivity(), str, payBack, hashMap);
        }
    }

    private boolean l() {
        InterceptResult invokeV;
        CardData.BondCard selectedCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            PayRequest payRequest = this.f26134c;
            return (payRequest == null || (selectedCard = payRequest.getSelectedCard()) == null || 1 != selectedCard.is_sign_jump_bank) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, precashierCreateOrderResponse) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            if (bundle == null) {
                this.f26134c = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            } else {
                Serializable serializable = bundle.getSerializable("mPayRequest");
                if (serializable != null && (serializable instanceof PayRequest)) {
                    this.f26134c = (PayRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayResponse");
                if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                    PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
                }
            }
            if (this.f26134c != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26134c.getRequestId(), this.f26134c);
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f26138b, "PrecashierWelcomePresenter.initSaveInstanceData().1");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            this.f26134c = payRequest;
            if (payRequest != null && payRequest.checkRequestValidity()) {
                if (this.f26135d == null) {
                    PayBeanFactory payBeanFactory = PayBeanFactory.getInstance();
                    PayBaseBeanActivity payBaseBeanActivity = this.f26138b;
                    this.f26135d = (v) payBeanFactory.getBean((Context) payBaseBeanActivity, 1, "PrecashierWelcomePresenter" + toString());
                }
                PayRequest payRequest2 = this.f26134c;
                if (payRequest2 != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest2.getPayFrom())) {
                    PayStatisticsUtil.onEventStart(StatServiceEvent.ACTIVE_BIND);
                } else {
                    StatisticManager.onEventStart(StatServiceEvent.CREATE_PRE_ORDER);
                }
                this.f26135d.a(this.f26133a);
                this.f26135d.setResponseCallback(this);
                this.f26135d.execBean();
                return;
            }
            PayCallBackManager.callBackClientCancel(this.f26138b, "PrecashierWelcomePresenter.loadData().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BeanManager beanManager = BeanManager.getInstance();
            beanManager.removeAllBeans("PrecashierWelcomePresenter" + toString());
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PayCallBackManager.callBackClientCancel(this.f26138b, "PrecashierWelcomePresenter.callBackCancle().1");
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    PayController.getInstance().gotoPwdPay(this.f26138b);
                } else if (this.f26134c.isWithHoldingValidity()) {
                    PayController.getInstance().gotoWithholdPay(this.f26138b);
                } else {
                    PayController payController = PayController.getInstance();
                    PayBaseBeanActivity payBaseBeanActivity = this.f26138b;
                    payController.gotoOrderConfirm(payBaseBeanActivity, payBaseBeanActivity.getIntent());
                }
            } else if (PayDataCache.getInstance().hasBondCards()) {
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                PayController payController2 = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity2 = this.f26138b;
                payController2.selectCompletCards(payBaseBeanActivity2, payBaseBeanActivity2.getIntent());
            } else {
                PayController payController3 = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity3 = this.f26138b;
                payController3.bindCardPay(payBaseBeanActivity3, payBaseBeanActivity3.getIntent(), true);
            }
        }
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, directPayContentResponse) == null) {
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && directPayPay.easypay != null && directPayContentResponse.user != null) {
                i();
            } else {
                PayCallBackManager.callBackClientCancel(this.f26138b, "PrecashierWelcomePresenter.confirmRemotePayOrderInfo().1");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a() {
        PayBaseBeanActivity payBaseBeanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (payBaseBeanActivity = this.f26138b) == null) {
            return;
        }
        payBaseBeanActivity.setFlagPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Object obj, String str) {
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
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
                    a2.a(this.f26138b);
                } else {
                    f();
                }
                this.f26138b.finishWithoutAnim();
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
                if (this.f26134c == null) {
                    PayCallBackManager.callBackClientCancel(this.f26138b, "PrecashierWelcomePresenter.handleResponse().2");
                    return;
                }
                UserData.SP sp = directPayContentResponse.sp;
                if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
                    this.f26134c.mGoodName = directPayContentResponse.sp.goods_name;
                }
                directPayContentResponse.storeResponse(this.f26138b);
                StatHelper.cacheHasPwd(directPayContentResponse.hasPwd());
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getHasPwd());
                HashMap hashMap = new HashMap();
                hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.PERCASHIER_PAY_ORDER, collectData, hashMap);
                StatHelper.cachePayType("balance".equals(PayDataCache.getInstance().getDefaultPayType()) ? 1 : 0);
                PayRequest payRequest = this.f26134c;
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
                    this.f26134c.setCalcPayment(directPayPay2.composite);
                    this.f26134c.setRandomDiscount(directPayContentResponse.pay.random_discount);
                }
                if (directPayContentResponse.isWithHoldingValidity()) {
                    this.f26134c.withholding = directPayContentResponse.authorize_common_cashdesk;
                }
                if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f26134c.mPayFrom)) {
                    BindFastRequest bindFastRequest = new BindFastRequest();
                    bindFastRequest.mBindFrom = 1;
                    PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                    this.f26138b.startActivity(new Intent(this.f26138b, BindCardImplActivity.class));
                    this.f26138b.finishWithoutAnim();
                    return;
                } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f26134c.mPayFrom)) {
                    this.f26134c.initPayStrategy(this.f26138b);
                    j();
                    return;
                } else {
                    this.f26134c.initPayStrategy(this.f26138b);
                    if (PayDataCache.getInstance().isRemotePay()) {
                        b(directPayContentResponse);
                        this.f26138b.finishWithoutAnim();
                        return;
                    }
                    i();
                    return;
                }
            }
            PayCallBackManager.callBackClientCancel(this.f26138b, "PrecashierWelcomePresenter.handleResponse().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            StatisticManager.onEventEnd(StatServiceEvent.CREATE_PRE_ORDER, i3);
            StatisticManager.onEventWithValue(StatServiceEvent.CREATE_PRE_ORDER_FAIL, String.valueOf(i3), str);
            if (i3 == 5173 || i3 == 5172 || (i3 == 5171 && !TextUtils.isEmpty(str))) {
                PayBaseBeanActivity payBaseBeanActivity = this.f26138b;
                if (payBaseBeanActivity != null) {
                    WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 3, str);
                }
            } else if (i2 == 768) {
                f();
            } else {
                k();
            }
        }
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        InterceptResult invokeL;
        UserData.Misc misc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, directPayContentResponse)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.f26134c;
            String str = "\"\"";
            String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? "\"\"" : this.f26134c.mSpNO;
            if (directPayContentResponse != null && (misc = directPayContentResponse.misc) != null) {
                str = misc.getInsideTransOrder();
            }
            arrayList.add(str2);
            arrayList.add(str);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            StatisticManager.onEventEnd(StatServiceEvent.CREATE_PRE_ORDER, i3);
            StatisticManager.onEventWithValue(StatServiceEvent.CREATE_PRE_ORDER_FAIL, String.valueOf(i3), str);
            k();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i2, dialog) == null) && i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideNegativeButton();
            promptDialog.setMessage(WalletGlobalUtils.showStr);
            promptDialog.setPositiveBtn(ResUtils.getString(this.f26138b, "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ j f26136a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26136a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.DismissLoadingDialog();
                        this.f26136a.f26138b.finish();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f26133a = str;
        }
    }
}
