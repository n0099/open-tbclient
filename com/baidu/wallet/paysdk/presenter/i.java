package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.r;
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
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class i extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f62494a;

    /* renamed from: c  reason: collision with root package name */
    public r f62495c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PayBaseBeanActivity payBaseBeanActivity) {
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
        this.f62494a = null;
    }

    private void f() {
        Pair<Integer, Object> checkSecurityEvn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && (checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn()) != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.f62494a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f62494a.mSecurityParams = Base64.encodeBytes(str.getBytes());
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    PayController.getInstance().gotoPwdPay(this.f62506b);
                    return;
                } else if (this.f62494a.isWithHoldingValidity()) {
                    PayController.getInstance().gotoWithholdPay(this.f62506b);
                    return;
                } else {
                    StatHelper.statServiceEvent("enterOrderConfirmActivity");
                    PayController payController = PayController.getInstance();
                    PayBaseBeanActivity payBaseBeanActivity = this.f62506b;
                    payController.gotoOrderConfirm(payBaseBeanActivity, payBaseBeanActivity.getIntent());
                    return;
                }
            }
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            if (PayDataCache.getInstance().hasBondCards()) {
                StatHelper.statServiceEvent(StatServiceEvent.ENTER_SELECT_CARD_ACTIVITY);
                PayController payController2 = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity2 = this.f62506b;
                payController2.selectCompletCards(payBaseBeanActivity2, payBaseBeanActivity2.getIntent());
                return;
            }
            PayController payController3 = PayController.getInstance();
            PayBaseBeanActivity payBaseBeanActivity3 = this.f62506b;
            payController3.bindCardPay(payBaseBeanActivity3, payBaseBeanActivity3.getIntent(), true);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            PwdRequest pwdRequest = new PwdRequest();
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            if (PayDataCache.getInstance().hasBondCards()) {
                Intent intent = new Intent(this.f62506b, AuthorizeSignActivity.class);
                if (com.baidu.wallet.paysdk.a.b.b()) {
                    intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
                } else if (com.baidu.wallet.paysdk.a.b.c()) {
                    intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 1);
                }
                this.f62506b.startActivity(intent);
                this.f62506b.finishWithoutAnim();
                return;
            }
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
            BaiduPay.getInstance().bindCardAuth(this.f62506b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            PayRequest payRequest = this.f62494a;
            String str = payRequest != null ? payRequest.mParams : "";
            String str2 = "doRePayOrder->orderinfo:" + str;
            PayRequest payRequest2 = this.f62494a;
            String payFrom = payRequest2 != null ? payRequest2.getPayFrom() : "";
            PayCallBack payBack = BaiduPay.getInstance().getPayBack();
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", payFrom);
            BaiduPay.getInstance().doPay(this.f62506b.getActivity(), str, payBack, hashMap);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            f();
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            this.f62494a = payRequest;
            if (payRequest != null && payRequest.checkRequestValidity()) {
                if (this.f62495c == null) {
                    PayBeanFactory payBeanFactory = PayBeanFactory.getInstance();
                    PayBaseBeanActivity payBaseBeanActivity = this.f62506b;
                    this.f62495c = (r) payBeanFactory.getBean((Context) payBaseBeanActivity, 1, "PayWelcomePresenter" + toString());
                }
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventStart("remoteCreateOrder");
                } else {
                    StatisticManager.onEventStart("createOrder");
                }
                this.f62495c.setResponseCallback(this);
                this.f62495c.execBean();
            } else if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEvent("remotePreCreateOrderPayReqInvalid");
                PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.loadData().1 remotePay");
            } else {
                PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.loadData().1");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BeanManager beanManager = BeanManager.getInstance();
            beanManager.removeAllBeans("PayWelcomePresenter" + toString());
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.callBackCancel().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            if (bundle == null) {
                this.f62494a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            } else {
                Serializable serializable = bundle.getSerializable("mPayRequest");
                if (serializable != null && (serializable instanceof PayRequest)) {
                    this.f62494a = (PayRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayResponse");
                if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                    PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
                }
            }
            if (this.f62494a != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f62494a.getRequestId(), this.f62494a);
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.initSaveInstanceData().1");
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, directPayContentResponse) == null) {
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && ((directPayPay.easypay != null || directPayPay.balance != null) && directPayContentResponse.user != null)) {
                h();
                return;
            }
            StatisticManager.onEvent("remoteOrderInfoInvalid");
            PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.confirmRemotePayOrderInfo().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a() {
        PayBaseBeanActivity payBaseBeanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (payBaseBeanActivity = this.f62506b) == null) {
            return;
        }
        payBaseBeanActivity.setFlagPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Object obj, String str) {
        UserData.Misc misc;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
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
                if (this.f62494a == null) {
                    PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.handleResponse().2");
                    return;
                }
                UserData.SP sp = directPayContentResponse.sp;
                if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
                    this.f62494a.mGoodName = directPayContentResponse.sp.goods_name;
                }
                directPayContentResponse.storeResponse(this.f62506b);
                PayRequest payRequest = this.f62494a;
                if (payRequest != null && (misc = directPayContentResponse.misc) != null) {
                    payRequest.title_url = misc.title_url;
                    ArrayList<String> a2 = a(directPayContentResponse);
                    if (!TextUtils.isEmpty(a2.get(0)) && !TextUtils.isEmpty(a2.get(1))) {
                        if (PayDataCache.getInstance().isRemotePay()) {
                            StatisticManager.onEventEndWithValues("remoteCreateOrder", 0, a2);
                        } else {
                            StatisticManager.onEventEndWithValues("createOrder", 0, a2);
                        }
                    }
                }
                PayData.DirectPayPay directPayPay2 = directPayContentResponse.pay;
                if (directPayPay2 != null) {
                    this.f62494a.setCalcPayment(directPayPay2.composite);
                    this.f62494a.setRandomDiscount(directPayContentResponse.pay.random_discount);
                }
                if (directPayContentResponse.isWithHoldingValidity()) {
                    this.f62494a.withholding = directPayContentResponse.authorize_common_cashdesk;
                }
                if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f62494a.mPayFrom)) {
                    StatHelper.cachePayType(0);
                    StatHelper.cachePayWay(4);
                    a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
                    BindFastRequest bindFastRequest = new BindFastRequest();
                    bindFastRequest.mBindFrom = 1;
                    PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                    this.f62506b.startActivity(new Intent(this.f62506b, BindCardImplActivity.class));
                    this.f62506b.finishWithoutAnim();
                    return;
                } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f62494a.mPayFrom)) {
                    this.f62494a.initPayStrategy(this.f62506b);
                    StatHelper.cachePayType(0);
                    StatHelper.cachePayWay(3);
                    a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
                    Authorize authorize = directPayContentResponse.authorize;
                    if (authorize != null) {
                        this.f62494a.title_url = authorize.title_url;
                    }
                    i();
                    return;
                } else {
                    this.f62494a.initPayStrategy(this.f62506b);
                    if ("balance".equals(PayDataCache.getInstance().getDefaultPayType())) {
                        StatHelper.cachePayType(1);
                    } else {
                        StatHelper.cachePayType(0);
                    }
                    if (this.f62494a.getPayWay() == 2) {
                        StatHelper.cachePayWay(1);
                    } else {
                        StatHelper.cachePayWay(0);
                    }
                    a(directPayContentResponse.hasPwd(), directPayContentResponse.hasBindCards());
                    if (PayDataCache.getInstance().isRemotePay()) {
                        b(directPayContentResponse);
                    } else {
                        h();
                    }
                    this.f62506b.finishWithoutAnim();
                    return;
                }
            }
            PayCallBackManager.callBackClientCancel(this.f62506b, "PayWelcomePresenter.handleResponse().1");
        }
    }

    private void a(boolean z, boolean z2) {
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f62494a == null) {
            return;
        }
        StatHelper.cacheHasPwd(z);
        StatHelper.cacheHasBankCard(z2);
        String str = "0";
        String str2 = "-1";
        if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f62494a.mPayFrom)) {
            if (this.f62494a.getDefaultBankCardIdx() != null) {
                str2 = this.f62494a.getDefaultBankCardIdx().card_type + "";
                str = this.f62494a.getDefaultBankCardIdx().bank_code;
            } else {
                str = "-1";
            }
            if (com.baidu.wallet.paysdk.a.b.c()) {
                StatHelper.cacheSignPay("1");
            } else {
                StatHelper.cacheSignPay("2");
            }
        } else {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (this.f62494a.getPayPrice() != null && this.f62494a.getPayPrice().payType == PayRequest.PayPrice.PayType.BANKCARD && (bondCard = this.f62494a.mBondCard) != null) {
                    str = bondCard.bank_code;
                    str2 = this.f62494a.mBondCard.card_type + "";
                } else if (this.f62494a.getPayPrice() != null && this.f62494a.getPayPrice().payType == PayRequest.PayPrice.PayType.BALANCE) {
                    str2 = "0";
                }
            }
            str = "-1";
        }
        StatHelper.cacheBankCode(str);
        StatHelper.cacheCardType(str2);
        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_ORDER);
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i3 == 65340) {
                StatisticManager.onEventEnd("createOrder", i3);
                if (this.f62506b != null) {
                    StatisticManager.onEventWithValue(PayStatServiceEvent.PASS_NOT_MATCH_DIALOG, StatHelper.getOrderNo());
                    WalletGlobalUtils.safeShowDialog(this.f62506b, 55, str);
                    return;
                }
                return;
            }
            PayRequest payRequest = this.f62494a;
            if (payRequest != null && !BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEventEndWithValues("remoteCreateOrder", i3, a((DirectPayContentResponse) null));
                } else {
                    StatisticManager.onEventEndWithValues("createOrder", i3, a((DirectPayContentResponse) null));
                }
            }
            super.a(i2, i3, str);
        }
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        InterceptResult invokeL;
        UserData.Misc misc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, directPayContentResponse)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.f62494a;
            String str = "\"\"";
            String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? "\"\"" : this.f62494a.mSpNO;
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
            DirectPayErrorContent directPayErrorContent = (obj == null || !(obj instanceof DirectPayErrorContent)) ? null : (DirectPayErrorContent) obj;
            if (i3 == 65015 && directPayErrorContent != null && !TextUtils.isEmpty(directPayErrorContent.order_url)) {
                StatisticManager.onEventWithValue(PayStatServiceEvent.JUMP_WAPCASHIER, StatHelper.getOrderNo());
                BaiduPay.getInstance().jumpWapCashier(this.f62506b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
            } else if ((i3 == 5170 || i3 == 5177) && directPayErrorContent != null) {
                if (TextUtils.isEmpty(directPayErrorContent.auth_url_sdk)) {
                    e();
                    return;
                }
                BaiduPayDelegate.getInstance().doPayRNAuth(this.f62506b, directPayErrorContent.auth_url_sdk, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.presenter.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f62496a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62496a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            if (i4 == 0) {
                                this.f62496a.j();
                            } else {
                                this.f62496a.e();
                            }
                        }
                    }
                });
                this.f62506b.finishWithoutAnim();
            } else {
                super.a(i2, i3, str, obj);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i2, dialog) == null) && i2 == 55) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideTitle();
            promptDialog.setMessage(WalletGlobalUtils.showStr);
            promptDialog.setPositiveBtn(ResUtils.string(this.f62506b, "wallet_base_to_rnauth_for_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ i f62497a;

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
                    this.f62497a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StatisticManager.onEventWithValue("nameNotMatchToConfirm", StatHelper.getOrderNo());
                        HashMap hashMap = new HashMap();
                        hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1171");
                        BaiduPayDelegate.getInstance().doRNAuth(this.f62497a.f62506b, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.presenter.i.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f62498a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62498a = this;
                            }

                            @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                            public void onRNAuthResult(int i3, String str) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, str) == null) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(StatHelper.getOrderNo());
                                    arrayList.add("" + i3);
                                    StatisticManager.onEventWithValues(PayStatServiceEvent.PASS_NOT_MATCH_RESULT, arrayList);
                                    if (i3 == 0) {
                                        this.f62498a.f62497a.j();
                                    } else {
                                        this.f62498a.f62497a.e();
                                    }
                                }
                            }
                        });
                        WalletGlobalUtils.safeDismissDialog(this.f62497a.f62506b, 55);
                        this.f62497a.f62506b.finish();
                    }
                }
            });
            promptDialog.setNegativeBtn(ResUtils.string(this.f62506b, "wallet_base_quit_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.i.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ i f62499a;

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
                    this.f62499a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        StatisticManager.onEventWithValue("nameNotMatchToCancel", StatHelper.getOrderNo());
                        this.f62499a.e();
                        WalletGlobalUtils.safeDismissDialog(this.f62499a.f62506b, 55);
                        this.f62499a.f62506b.finish();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, precashierCreateOrderResponse) == null) {
            if (precashierCreateOrderResponse != null) {
                if (TextUtils.equals(precashierCreateOrderResponse.ret, "0")) {
                    StatisticManager.onEventStart("createOrder");
                    a(-1, precashierCreateOrderResponse.content, (String) null);
                    return;
                } else if (Integer.parseInt(precashierCreateOrderResponse.ret) != 5173 && Integer.parseInt(precashierCreateOrderResponse.ret) != 5172 && (Integer.parseInt(precashierCreateOrderResponse.ret) != 5171 || TextUtils.isEmpty(precashierCreateOrderResponse.msg))) {
                    if (TextUtils.equals(precashierCreateOrderResponse.ret, String.valueOf(65340))) {
                        StatisticManager.onEventEnd("preCreateOrderFromTransfer", Integer.valueOf(precashierCreateOrderResponse.ret).intValue());
                        PayBaseBeanActivity payBaseBeanActivity = this.f62506b;
                        if (payBaseBeanActivity != null) {
                            WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 55, precashierCreateOrderResponse.msg);
                            return;
                        }
                        return;
                    }
                    DirectPayErrorContent directPayErrorContent = precashierCreateOrderResponse.errContent;
                    if (directPayErrorContent != null) {
                        try {
                            if (Integer.parseInt(precashierCreateOrderResponse.ret) == 65015 && !TextUtils.isEmpty(directPayErrorContent.order_url)) {
                                BaiduPay.getInstance().jumpWapCashier(this.f62506b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
                                return;
                            } else if (Integer.parseInt(precashierCreateOrderResponse.ret) == 5170 || Integer.parseInt(precashierCreateOrderResponse.ret) == 5177) {
                                if (TextUtils.isEmpty(directPayErrorContent.auth_url_sdk)) {
                                    e();
                                    return;
                                }
                                this.f62506b.finishWithoutAnim();
                                BaiduPayDelegate.getInstance().doPayRNAuth(this.f62506b, directPayErrorContent.auth_url_sdk, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.presenter.i.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ i f62500a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f62500a = this;
                                    }

                                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                                    public void onRNAuthResult(int i2, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                                            if (i2 == 0) {
                                                this.f62500a.j();
                                            } else {
                                                this.f62500a.e();
                                            }
                                        }
                                    }
                                });
                                return;
                            } else {
                                return;
                            }
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
                } else {
                    PayBaseBeanActivity payBaseBeanActivity2 = this.f62506b;
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
}
