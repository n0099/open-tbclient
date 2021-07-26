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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f26394a;

    /* renamed from: c  reason: collision with root package name */
    public v f26395c;

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
        this.f26394a = null;
    }

    private void f() {
        Pair<Integer, Object> checkSecurityEvn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && (checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn()) != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.f26394a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f26394a.mSecurityParams = Base64.encodeBytes(str.getBytes());
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    PayController.getInstance().gotoPwdPay(this.f26406b);
                } else if (this.f26394a.isWithHoldingValidity()) {
                    PayController.getInstance().gotoWithholdPay(this.f26406b);
                } else {
                    if (PayDataCache.getInstance().isRemotePay()) {
                        StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_ORDER_CONFIRM_ACTIVITY);
                    } else {
                        StatisticManager.onEvent(StatServiceEvent.ENTER_ORDER_CONFIRM_ACTIVITY);
                    }
                    PayController payController = PayController.getInstance();
                    PayBaseBeanActivity payBaseBeanActivity = this.f26406b;
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
                PayBaseBeanActivity payBaseBeanActivity2 = this.f26406b;
                payController2.selectCompletCards(payBaseBeanActivity2, payBaseBeanActivity2.getIntent());
            } else {
                if (PayDataCache.getInstance().isRemotePay()) {
                    StatisticManager.onEvent(StatServiceEvent.REMOTE_ENTER_BIND_CARD_ACTIVITY);
                } else {
                    StatisticManager.onEvent(StatServiceEvent.ENTER_BIND_CARD_ACTIVITY);
                }
                PayController payController3 = PayController.getInstance();
                PayBaseBeanActivity payBaseBeanActivity3 = this.f26406b;
                payController3.bindCardPay(payBaseBeanActivity3, payBaseBeanActivity3.getIntent(), true);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            PwdRequest pwdRequest = new PwdRequest();
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            if (PayDataCache.getInstance().hasBondCards()) {
                Intent intent = new Intent(this.f26406b, AuthorizeSignActivity.class);
                if (com.baidu.wallet.paysdk.a.b.b()) {
                    intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 2);
                } else if (com.baidu.wallet.paysdk.a.b.c()) {
                    intent.putExtra(AuthorizeSignActivity.AUTH_SIGN_TYPE, 1);
                }
                this.f26406b.startActivity(intent);
                this.f26406b.finishWithoutAnim();
                return;
            }
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            BaiduPay.getInstance().bindCardAuth(this.f26406b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            PayRequest payRequest = this.f26394a;
            String str = payRequest != null ? payRequest.mParams : "";
            LogUtil.d("present", "doRePayOrder->orderinfo:" + str);
            PayRequest payRequest2 = this.f26394a;
            String payFrom = payRequest2 != null ? payRequest2.getPayFrom() : "";
            PayCallBack payBack = BaiduPay.getInstance().getPayBack();
            PayRequestCache.getInstance().clearPaySdkRequestCache();
            PayBaseBeanActivity.exitEbpay();
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", payFrom);
            BaiduPay.getInstance().doPay(this.f26406b.getActivity(), str, payBack, hashMap);
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
            this.f26394a = payRequest;
            if (payRequest != null && payRequest.checkRequestValidity()) {
                if (this.f26395c == null) {
                    PayBeanFactory payBeanFactory = PayBeanFactory.getInstance();
                    PayBaseBeanActivity payBaseBeanActivity = this.f26406b;
                    this.f26395c = (v) payBeanFactory.getBean((Context) payBaseBeanActivity, 1, "PayWelcomePresenter" + toString());
                }
                PayRequest payRequest2 = this.f26394a;
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
                this.f26395c.setResponseCallback(this);
                this.f26395c.execBean();
            } else if (PayDataCache.getInstance().isRemotePay()) {
                StatisticManager.onEvent(StatServiceEvent.REMOTE_PRE_CREATE_ORDER_PAY_REQ_INVALID);
                PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.loadData().1 remotePay");
            } else {
                PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.loadData().1");
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
            PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.callBackCancle().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            if (bundle == null) {
                this.f26394a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            } else {
                Serializable serializable = bundle.getSerializable("mPayRequest");
                if (serializable != null && (serializable instanceof PayRequest)) {
                    this.f26394a = (PayRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayResponse");
                if (serializable2 != null && (serializable2 instanceof DirectPayContentResponse)) {
                    PayDataCache.getInstance().setPayResponse((DirectPayContentResponse) serializable2);
                }
            }
            if (this.f26394a != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26394a.getRequestId(), this.f26394a);
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.initSaveInstanceData().1");
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b(DirectPayContentResponse directPayContentResponse) {
        PayData.DirectPayPay directPayPay;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, directPayContentResponse) == null) {
            if (directPayContentResponse != null && (directPayPay = directPayContentResponse.pay) != null && ((directPayPay.easypay != null || directPayPay.balance != null) && directPayContentResponse.user != null)) {
                h();
                return;
            }
            StatisticManager.onEvent(StatServiceEvent.REMOTE_ORDER_INFO_INVALID);
            PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.confirmRemotePayOrderInfo().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a() {
        PayBaseBeanActivity payBaseBeanActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (payBaseBeanActivity = this.f26406b) == null) {
            return;
        }
        payBaseBeanActivity.setFlagPaySdk();
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, Object obj, String str) {
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
                if (this.f26394a == null) {
                    PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.handleResponse().2");
                    return;
                }
                UserData.SP sp = directPayContentResponse.sp;
                if (sp != null && !TextUtils.isEmpty(sp.goods_name)) {
                    this.f26394a.mGoodName = directPayContentResponse.sp.goods_name;
                }
                directPayContentResponse.storeResponse(this.f26406b);
                PayRequest payRequest = this.f26394a;
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    if (PayDataCache.getInstance().isRemotePay()) {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.REMOTE_ACTIVE_BIND, 0);
                    } else {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.ACTIVE_BIND, 0);
                    }
                } else {
                    UserData.Misc misc = directPayContentResponse.misc;
                    if (misc != null) {
                        this.f26394a.title_url = misc.title_url;
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
                    this.f26394a.setCalcPayment(directPayPay2.composite);
                    this.f26394a.setRandomDiscount(directPayContentResponse.pay.random_discount);
                }
                if (directPayContentResponse.isWithHoldingValidity()) {
                    this.f26394a.withholding = directPayContentResponse.authorize_common_cashdesk;
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
                if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f26394a.mPayFrom)) {
                    BindFastRequest bindFastRequest = new BindFastRequest();
                    bindFastRequest.mBindFrom = 1;
                    PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
                    this.f26406b.startActivity(new Intent(this.f26406b, BindCardImplActivity.class));
                    this.f26406b.finishWithoutAnim();
                    return;
                } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f26394a.mPayFrom)) {
                    this.f26394a.initPayStrategy(this.f26406b);
                    Authorize authorize = directPayContentResponse.authorize;
                    if (authorize != null) {
                        this.f26394a.title_url = authorize.title_url;
                    }
                    i();
                    return;
                } else {
                    this.f26394a.initPayStrategy(this.f26406b);
                    if (PayDataCache.getInstance().isRemotePay()) {
                        b(directPayContentResponse);
                    } else {
                        h();
                    }
                    this.f26406b.finishWithoutAnim();
                    return;
                }
            }
            PayCallBackManager.callBackClientCancel(this.f26406b, "PayWelcomePresenter.handleResponse().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.k
    public void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (5170 == i3) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1150");
                StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RNAUTH_ENTER, StatHelper.getOrderNo());
                BaiduPayDelegate.getInstance().doPayRNAuth(this.f26406b, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.presenter.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ i f26396a;

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
                        this.f26396a = this;
                    }

                    @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                    public void onRNAuthResult(int i4, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                            String orderNo = StatHelper.getOrderNo();
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RNAUTH_RESULT, StatHelper.collectData(orderNo, i4 + "", str2));
                            if (i4 == 0) {
                                this.f26396a.j();
                            } else {
                                this.f26396a.e();
                            }
                        }
                    }
                });
            } else if (i3 == 65340) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.CREATE_ORDER, i3);
                PayBaseBeanActivity payBaseBeanActivity = this.f26406b;
                if (payBaseBeanActivity != null) {
                    WalletGlobalUtils.safeShowDialog(payBaseBeanActivity, 55, str);
                }
            } else {
                PayRequest payRequest = this.f26394a;
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    if (PayDataCache.getInstance().isRemotePay()) {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.REMOTE_ACTIVE_BIND, i3);
                    } else {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.ACTIVE_BIND, i3);
                    }
                } else if (PayDataCache.getInstance().isRemotePay()) {
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.REMOTE_CREATE_ORDER, i3, a((DirectPayContentResponse) null));
                } else {
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.CREATE_ORDER, i3, a((DirectPayContentResponse) null));
                }
                super.a(i2, i3, str);
            }
        }
    }

    private ArrayList<String> a(DirectPayContentResponse directPayContentResponse) {
        InterceptResult invokeL;
        UserData.Misc misc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, directPayContentResponse)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.f26394a;
            String str = "\"\"";
            String str2 = (payRequest == null || TextUtils.isEmpty(payRequest.mSpNO)) ? "\"\"" : this.f26394a.mSpNO;
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
                BaiduPay.getInstance().jumpWapCashier(this.f26406b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
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
            promptDialog.setPositiveBtn(ResUtils.string(this.f26406b, "wallet_base_to_rnauth_for_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ i f26397a;

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
                    this.f26397a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.NAME_NOT_MATCH_TO_CONFIRM);
                        HashMap hashMap = new HashMap();
                        hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1171");
                        BaiduPayDelegate.getInstance().doRNAuth(this.f26397a.f26406b, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.presenter.i.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f26398a;

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
                                this.f26398a = this;
                            }

                            @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                            public void onRNAuthResult(int i3, String str) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i3, str) == null) {
                                    if (i3 == 0) {
                                        this.f26398a.f26397a.j();
                                    } else {
                                        this.f26398a.f26397a.e();
                                    }
                                }
                            }
                        });
                        WalletGlobalUtils.safeDismissDialog(this.f26397a.f26406b, 55);
                        this.f26397a.f26406b.finish();
                    }
                }
            });
            promptDialog.setNegativeBtn(ResUtils.string(this.f26406b, "wallet_base_quit_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.i.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ i f26399a;

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
                    this.f26399a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayStatisticsUtil.onEvent(StatServiceEvent.NAME_NOT_MATCH_TO_CANCEL);
                        this.f26399a.e();
                        WalletGlobalUtils.safeDismissDialog(this.f26399a.f26406b, 55);
                        this.f26399a.f26406b.finish();
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
                    PayStatisticsUtil.onEventStart(StatServiceEvent.CREATE_ORDER);
                    a(-1, precashierCreateOrderResponse.content, (String) null);
                    return;
                } else if (Integer.parseInt(precashierCreateOrderResponse.ret) != 5173 && Integer.parseInt(precashierCreateOrderResponse.ret) != 5172 && (Integer.parseInt(precashierCreateOrderResponse.ret) != 5171 || TextUtils.isEmpty(precashierCreateOrderResponse.msg))) {
                    if (TextUtils.equals(precashierCreateOrderResponse.ret, "5170")) {
                        String str = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).mParams;
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, "1150");
                        StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_RNAUTH_ENTER, StatHelper.getOrderNo());
                        BaiduPayDelegate.getInstance().doPayRNAuth(this.f26406b, hashMap, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.presenter.i.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ i f26400a;

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
                                this.f26400a = this;
                            }

                            @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                            public void onRNAuthResult(int i2, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                    String orderNo = StatHelper.getOrderNo();
                                    StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_RNAUTH_RESULT, StatHelper.collectData(orderNo, i2 + "", str2));
                                    this.f26400a.e();
                                }
                            }
                        });
                        return;
                    } else if (TextUtils.equals(precashierCreateOrderResponse.ret, String.valueOf((int) StatusCode.ERROR_AUTH_INFO_NOT_MATCH))) {
                        PayStatisticsUtil.onEventEnd(StatServiceEvent.PRE_CREATE_ORDER_FROM_TRANSFER, Integer.valueOf(precashierCreateOrderResponse.ret).intValue());
                        PayBaseBeanActivity payBaseBeanActivity = this.f26406b;
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
                                BaiduPay.getInstance().jumpWapCashier(this.f26406b, directPayErrorContent.order_url, H5PayWebViewActivity.class.getName());
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
                    PayBaseBeanActivity payBaseBeanActivity2 = this.f26406b;
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
