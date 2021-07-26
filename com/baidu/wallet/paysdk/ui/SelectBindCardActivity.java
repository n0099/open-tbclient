package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.m;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.FindPwdCardCheckResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class SelectBindCardActivity extends PayBaseBeanActivity implements SelectBindCardLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f26886a;

    /* renamed from: b  reason: collision with root package name */
    public SelectBindCardLayout f26887b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26888c;

    /* renamed from: d  reason: collision with root package name */
    public OrderConfirmation f26889d;

    /* renamed from: e  reason: collision with root package name */
    public CardData.BondCard[] f26890e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26891f;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f26892g;

    /* renamed from: h  reason: collision with root package name */
    public PayRequest f26893h;

    /* renamed from: i  reason: collision with root package name */
    public int f26894i;
    public SelectBindCardLayout.BindCardItemView j;
    public Boolean k;
    public View l;

    public SelectBindCardActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26886a = "SelectBindCardActivity" + hashCode();
        this.f26891f = false;
        this.k = Boolean.FALSE;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
        }
    }

    private void b() {
        PayRequest payRequest;
        String displayName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (payRequest = this.f26893h) == null) {
            return;
        }
        String needToPayAmount = payRequest.getNeedToPayAmount();
        String orderPrice = this.f26893h.getOrderPrice();
        String discountAmount = this.f26893h.getDiscountAmount();
        boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
        SpannableString spannableString = new SpannableString(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
        if (z) {
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        }
        String str = "-" + ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
        if (this.f26893h.showCouponListEntry()) {
            this.f26889d.setDiscountInfoVisiable(true);
            this.f26889d.setCouponInfo(this.f26893h.getDiscountMsg(), str, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SelectBindCardActivity f26896a;

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
                    this.f26896a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayController.getInstance().gotoDiscountPage(this.f26896a);
                    }
                }
            });
        } else if (!TextUtils.isEmpty(this.f26893h.getRandomDiscountMsg())) {
            this.f26889d.setDiscountInfoVisiable(true);
            this.f26889d.setCouponInfo(this.f26893h.getRandomDiscountMsg(), "", null);
        } else {
            this.f26889d.setDiscountInfoVisiable(false);
        }
        this.f26889d.setOrderPrice(StringUtils.fen2Yuan(needToPayAmount), spannableString);
        this.f26889d.setOrderInfo(this.f26893h.getGoodsName());
        this.f26889d.setTitle(this.f26893h.title_url);
        this.f26889d.setSpNameValue(PayDataCache.getInstance().getSpName());
        if (PayDataCache.getInstance().isRemotePay()) {
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                displayName = WalletLoginHelper.getInstance().getPassUserName();
            } else {
                displayName = PayDataCache.getInstance().getPayResponse().getDisplayName();
            }
            this.f26889d.setAccountInfo(displayName, null);
        }
    }

    private void c() {
        boolean enableAddBondCards;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (d()) {
                this.f26890e = new CardData.BondCard[0];
                WalletGlobalUtils.safeShowDialog(this, -1, "");
                e();
                enableAddBondCards = true;
            } else {
                this.f26890e = PayDataCache.getInstance().getBondCards();
                enableAddBondCards = PayDataCache.getInstance().enableAddBondCards();
            }
            this.f26887b.setAdaptetr(this.f26890e, enableAddBondCards);
            this.f26887b.setBindCardItemClickListener(this);
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = this.f26892g.mBindFrom;
            return i2 == 4 || i2 == 5;
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            m mVar = (m) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, this.f26886a);
            mVar.setResponseCallback(this);
            mVar.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            BindFastRequest bindFastRequest = this.f26892g;
            if (bindFastRequest == null || bindFastRequest.mBondCard == null) {
                return;
            }
            this.j.setProgressBarVisible(false);
            CardData.BondCard bondCard = this.f26892g.mBondCard;
            if (bondCard != null) {
                extras.putSerializable(BindFastRequest.HAS_BINDED_CARD, bondCard);
                extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                int a2 = i.a().a(this.mAct, bondCard, false);
                if (a2 > 0 && 2 >= a2) {
                    extras.putInt("halfScreen", a2);
                }
                extras.putInt("reasonForChangeCardItem", 1);
                startActivityWithExtras(extras, BindCardImplActivity.class);
            }
        }
    }

    private void g() {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Bundle extras = getIntent().getExtras();
            if (this.f26893h != null && !d()) {
                this.f26893h.mBondCard = null;
            }
            BindFastRequest bindFastRequest2 = this.f26892g;
            int i2 = bindFastRequest2.mBindFrom;
            if (i2 == 2) {
                bindFastRequest2.mBindFrom = 0;
            } else if (i2 == 5) {
                bindFastRequest2.mBindFrom = 3;
            } else if (i2 == 4) {
                bindFastRequest2.mBindFrom = 3;
            }
            int i3 = this.f26892g.mBindFrom;
            if ((i3 == 3 || i3 == 4) && (bindFastRequest = this.f26892g) != null) {
                bindFastRequest.mUseNewCardFindPwd = true;
            }
            PayRequestCache.BindCategory h2 = h();
            if (PayRequestCache.BindCategory.Other == h2) {
                StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                getBindCardFlagDelegate().a(this.f26892g);
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26892g.getRequestId(), this.f26892g);
                this.f26892g.mBondCard = null;
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                startActivityWithExtras(extras, BindCardImplActivity.class);
                return;
            }
            BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn(this, extras) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Bundle f26900a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SelectBindCardActivity f26901b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, extras};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26901b = this;
                    this.f26900a = extras;
                }

                @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                public void onFailed(int i4, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    }
                }

                @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                public void onResponse(CardAddResponse cardAddResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardAddResponse) == null) {
                        this.f26901b.getBindCardFlagDelegate().a(this.f26901b.f26892g);
                        PayRequestCache.getInstance().addBeanRequestToCache(this.f26901b.f26892g.getRequestId(), this.f26901b.f26892g);
                        this.f26901b.f26892g.mBondCard = null;
                        Bundle bundle = this.f26900a;
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                        Intent intent = this.f26901b.getIntent();
                        if (intent != null && intent.hasExtra(com.baidu.wallet.api.Constants.BDL_KEY_FROM)) {
                            bundle.putString(com.baidu.wallet.api.Constants.BDL_KEY_FROM, intent.getStringExtra(com.baidu.wallet.api.Constants.BDL_KEY_FROM));
                        }
                        Activity loadingUi = BindCardEntry.getLoadingUi();
                        if (loadingUi instanceof BaseActivity) {
                            ((BaseActivity) loadingUi).startActivityWithExtras(bundle, BindCardImplActivity.class);
                        } else {
                            this.f26901b.startActivityWithExtras(bundle, BindCardImplActivity.class);
                        }
                    }
                }
            }, h2, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.f26894i, null, null);
        }
    }

    private PayRequestCache.BindCategory h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (PayRequestCache.getInstance().isPaying()) {
                return PayRequestCache.BindCategory.Other;
            }
            if (this.k.booleanValue()) {
                return PayRequestCache.BindCategory.Pwd;
            }
            int i2 = this.f26894i;
            if (1 == i2) {
                return PayRequestCache.BindCategory.Initiative;
            }
            if (4 == i2) {
                return PayRequestCache.BindCategory.Pwd;
            }
            if (5 == i2 && !PayRequestCache.getInstance().isPaying()) {
                return PayRequestCache.BindCategory.Initiative;
            }
            return PayRequestCache.BindCategory.Other;
        }
        return (PayRequestCache.BindCategory) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.b
    public void addNewCardClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.b
    public void enableCardClick(SelectBindCardLayout.BindCardItemView bindCardItemView, CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bindCardItemView, bondCard) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        this.j = bindCardItemView;
        a(bondCard);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            if (i2 == 526) {
                WalletGlobalUtils.safeDismissDialog(this, -1);
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
                finish();
                return;
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            if (i2 != 526) {
                if (i2 == 16) {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.CALCU_COUPON, 0);
                    CalcPaymentResponse calcPaymentResponse = obj instanceof CalcPaymentResponse ? (CalcPaymentResponse) obj : null;
                    this.f26893h.setCalcPayment(calcPaymentResponse);
                    if (calcPaymentResponse != null) {
                        this.f26893h.calcPayPriceByRemote(calcPaymentResponse);
                    }
                    f();
                    return;
                }
                return;
            }
            WalletGlobalUtils.safeDismissDialog(this, -1);
            FindPwdCardCheckResponse findPwdCardCheckResponse = (FindPwdCardCheckResponse) obj;
            if (findPwdCardCheckResponse != null) {
                this.f26890e = findPwdCardCheckResponse.getBondCards();
            }
            CardData.BondCard[] bondCardArr = this.f26890e;
            if (bondCardArr != null && bondCardArr.length != 0) {
                this.f26887b.setAdaptetr(bondCardArr, PayDataCache.getInstance().enableAddBondCards());
                this.f26887b.setBindCardItemClickListener(this);
                return;
            }
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
            finish();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PasswordController.getPassWordInstance().setPassByUserFail("");
            PasswordController.getPassWordInstance().forgetPasswdFailed();
            if (this.f26891f) {
                WalletGlobalUtils.safeShowDialog(this, 4, "");
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagPaySdk();
            if (bundle == null) {
                this.f26891f = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
                this.f26892g = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent()));
                this.k = Boolean.valueOf(PayRequestCache.BindCategory.Pwd.name().equals(getIntent().getStringExtra(com.baidu.wallet.api.Constants.BDL_KEY_FROM)));
                BeanRequestBase beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (beanRequestFromCache != null && (beanRequestFromCache instanceof PayRequest)) {
                    this.f26893h = (PayRequest) beanRequestFromCache;
                }
                if (PayDataCache.getInstance().getPayResponse() != null && PayDataCache.getInstance().getPayResponse().checkResponseValidity()) {
                    PayDataCache.getInstance().getPayResponse().storeResponse(this);
                } else {
                    finish();
                    return;
                }
            } else {
                this.f26891f = bundle.getBoolean("isFrist", false);
                this.k = Boolean.valueOf(bundle.getBoolean("isForPwd", false));
                Serializable serializable = bundle.getSerializable("mBindRequest");
                if (serializable != null && (serializable instanceof BindFastRequest)) {
                    this.f26892g = (BindFastRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f26893h = (PayRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("DirectPayContentResponse");
                if (serializable3 != null && (serializable3 instanceof DirectPayContentResponse)) {
                    ((DirectPayContentResponse) serializable3).storeResponse(getActivity());
                }
            }
            BindFastRequest bindFastRequest = this.f26892g;
            if (bindFastRequest != null && (!bindFastRequest.isRealPay() || this.f26893h != null)) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26892g.getRequestId(), this.f26892g);
                if (this.f26893h != null) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f26893h.getRequestId(), this.f26893h);
                }
                LogUtil.d("bindFrom=" + this.f26892g.mBindFrom + "#");
                this.f26894i = this.f26892g.mBindFrom;
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    a();
                }
                setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_bond_card_activity"));
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                this.f26888c = (TextView) findViewById(ResUtils.id(getActivity(), "select_pay_card"));
                this.f26889d = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "pay_layout"));
                this.l = findViewById(ResUtils.id(getActivity(), "statusbar_top"));
                this.f26889d.getBackButton().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SelectBindCardActivity f26895a;

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
                        this.f26895a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26895a.onBackPressed();
                        }
                    }
                });
                int i2 = this.f26892g.mBindFrom;
                if (i2 == 4) {
                    String string2 = ResUtils.getString(getActivity(), "ebpay_complete_tip1");
                    initActionBar("ebpay_title_find_pwd");
                    this.f26888c.setVisibility(0);
                    this.f26889d.setVisibility(8);
                    if (!TextUtils.isEmpty(string2)) {
                        this.f26888c.setText(string2);
                    }
                } else if (i2 == 5) {
                    if (PayDataCache.getInstance().hasEnableCardsForFindPWD()) {
                        string = ResUtils.getString(getActivity(), "ebpay_complete_tip4");
                    } else if (!PayDataCache.getInstance().enableAddBondCards()) {
                        string = ResUtils.getString(getActivity(), "ebpay_complete_tip5");
                    } else {
                        string = ResUtils.getString(getActivity(), "ebpay_complete_tip6");
                    }
                    initActionBar("ebpay_title_complete_info");
                    this.f26888c.setVisibility(0);
                    this.f26889d.setVisibility(8);
                    if (!TextUtils.isEmpty(string)) {
                        this.f26888c.setText(string);
                    }
                } else if (i2 == 2) {
                    initActionBar("ebpay_title_complete_info");
                    this.f26888c.setVisibility(8);
                    if (PayDataCache.getInstance().hasCanAmount()) {
                        this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip7");
                        if (bundle == null) {
                            WalletGlobalUtils.safeShowDialog(this, 3, "");
                        }
                    }
                    this.f26889d.setVisibility(0);
                    if (payResponse != null) {
                        b();
                        findViewById(ResUtils.id(getActivity(), "bdactionbar")).setVisibility(8);
                        setTop();
                    }
                }
                SelectBindCardLayout selectBindCardLayout = (SelectBindCardLayout) findViewById(ResUtils.id(this, "lv_bond_card_list"));
                this.f26887b = selectBindCardLayout;
                selectBindCardLayout.setBindFrom(this.f26894i);
                c();
                EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
                EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 3) {
                if (i2 != 4) {
                    return super.onCreateDialog(i2);
                }
                return new PromptDialog(getActivity());
            }
            return new PromptDialog(getActivity());
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BeanManager.getInstance().removeAllBeans(this.f26886a);
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
            EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
            super.onDestroy();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) && event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            b();
            BindFastRequest bindFastRequest = this.f26892g;
            if (bindFastRequest == null || bindFastRequest.mBindFrom != 2) {
                return;
            }
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, dialog) == null) {
            if (i2 != 3) {
                super.onPrepareDialog(i2, dialog);
                return;
            }
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setMessage(this.mDialogMsg);
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SelectBindCardActivity f26897a;

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
                    this.f26897a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f26897a, 3);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
            setFlagPaySdk();
            BindFastRequest bindFastRequest = this.f26892g;
            int i2 = this.f26894i;
            bindFastRequest.mBindFrom = i2;
            bindFastRequest.setBindFromOrigin(i2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, this.f26891f);
            bundle.putBoolean("isForPwd", this.k.booleanValue());
            bundle.putSerializable("mBindRequest", this.f26892g);
            PayRequest payRequest = this.f26893h;
            if (payRequest != null) {
                bundle.putSerializable("mPayRequest", payRequest);
            }
            bundle.putSerializable("DirectPayContentResponse", PayDataCache.getInstance().getPayResponse());
            super.onSaveInstanceState(bundle);
        }
    }

    public void setTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(this.mAct) + 10));
        ImmersiveStatusBarManager.setTopBar(this.mAct.getActivity(), this.l, isStatusbarTextColorBlack());
    }

    private void a(CardData.BondCard bondCard) {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bondCard) == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (bondCard == null) {
                return;
            }
            BindFastRequest bindFastRequest2 = this.f26892g;
            bindFastRequest2.mBondCard = bondCard;
            bindFastRequest2.setmBankInfo(null);
            int i2 = this.f26892g.mBindFrom;
            if (i2 == 2) {
                b(bondCard);
            } else if (i2 == 4 || i2 == 5) {
                this.f26892g.setmBankCard(bondCard.account_no);
                this.f26892g.setSubBankCode(bondCard.account_bank_code);
                this.f26892g.mBindFrom = 3;
                extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                if (PayRequestCache.getInstance().isPaying()) {
                    BaiduPay.getInstance().launchBindCardActivity(this, null, extras);
                } else {
                    BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn(this, extras) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Bundle f26898a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ SelectBindCardActivity f26899b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, extras};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f26899b = this;
                            this.f26898a = extras;
                        }

                        @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                        public void onFailed(int i3, String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                            }
                        }

                        @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                        public void onResponse(CardAddResponse cardAddResponse) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardAddResponse) == null) {
                                this.f26899b.getBindCardFlagDelegate().a(this.f26899b.f26892g);
                                PayRequestCache.getInstance().addBeanRequestToCache(this.f26899b.f26892g.getRequestId(), this.f26899b.f26892g);
                                Activity loadingUi = BindCardEntry.getLoadingUi();
                                if (loadingUi instanceof BaseActivity) {
                                    ((BaseActivity) loadingUi).startActivityWithExtras(this.f26898a, BindCardImplActivity.class);
                                } else {
                                    this.f26899b.startActivityWithExtras(this.f26898a, BindCardImplActivity.class);
                                }
                            }
                        }
                    }, PayRequestCache.BindCategory.Pwd, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.f26894i, null, null);
                }
            }
            int i3 = this.f26892g.mBindFrom;
            if ((i3 == 3 || i3 == 4) && (bindFastRequest = this.f26892g) != null) {
                bindFastRequest.mUseNewCardFindPwd = false;
            }
            getBindCardFlagDelegate().a(this.f26892g);
            PayRequestCache.getInstance().addBeanRequestToCache(this.f26892g.getRequestId(), this.f26892g);
        }
    }

    private void b(CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bondCard) == null) {
            PayRequest payRequest = this.f26893h;
            if (payRequest != null) {
                payRequest.mBondCard = bondCard;
            }
            if (!PayDataCache.getInstance().needCalcPayment()) {
                f();
                return;
            }
            SelectBindCardLayout.BindCardItemView bindCardItemView = this.j;
            if (bindCardItemView != null) {
                bindCardItemView.setProgressBarVisible(true);
            }
            com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) getActivity(), 16, this.f26886a);
            PayStatisticsUtil.onEventStart(StatServiceEvent.CALCU_COUPON);
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
            payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
            payTypeItemViewData.card = bondCard;
            cVar.a(payTypeItemViewData);
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }
}
