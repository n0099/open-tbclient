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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.j;
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
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class SelectBindCardActivity extends PayBaseBeanActivity implements SelectBindCardLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f62925a;

    /* renamed from: b  reason: collision with root package name */
    public SelectBindCardLayout f62926b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62927c;

    /* renamed from: d  reason: collision with root package name */
    public OrderConfirmation f62928d;

    /* renamed from: e  reason: collision with root package name */
    public CardData.BondCard[] f62929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62930f;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f62931g;

    /* renamed from: h  reason: collision with root package name */
    public PayRequest f62932h;

    /* renamed from: i  reason: collision with root package name */
    public int f62933i;

    /* renamed from: j  reason: collision with root package name */
    public SelectBindCardLayout.BindCardItemView f62934j;
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
        this.f62925a = "SelectBindCardActivity" + hashCode();
        this.f62930f = false;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (payRequest = this.f62932h) == null) {
            return;
        }
        String needToPayAmount = payRequest.getNeedToPayAmount();
        String orderPrice = this.f62932h.getOrderPrice();
        String discountAmount = this.f62932h.getDiscountAmount();
        boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
        SpannableString spannableString = new SpannableString(ResUtils.getString(getActivity(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
        if (z) {
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        }
        String str = "-" + ResUtils.getString(getActivity(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
        if (this.f62932h.showCouponListEntry()) {
            this.f62928d.setDiscountInfoVisiable(true);
            this.f62928d.setCouponInfo(this.f62932h.getDiscountMsg(), str, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SelectBindCardActivity f62936a;

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
                    this.f62936a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        PayController.getInstance().gotoDiscountPage(this.f62936a);
                    }
                }
            });
        } else if (!TextUtils.isEmpty(this.f62932h.getRandomDiscountMsg())) {
            this.f62928d.setDiscountInfoVisiable(true);
            this.f62928d.setCouponInfo(this.f62932h.getRandomDiscountMsg(), "", null);
        } else {
            this.f62928d.setDiscountInfoVisiable(false);
        }
        this.f62928d.setOrderPrice(StringUtils.fen2Yuan(needToPayAmount), spannableString);
        this.f62928d.setOrderInfo(this.f62932h.getGoodsName());
        this.f62928d.setTitle(this.f62932h.title_url);
        this.f62928d.setSpNameValue(PayDataCache.getInstance().getSpName());
        if (PayDataCache.getInstance().isRemotePay()) {
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                displayName = WalletLoginHelper.getInstance().getPassUserName();
            } else {
                displayName = PayDataCache.getInstance().getPayResponse().getDisplayName();
            }
            this.f62928d.setAccountInfo(displayName, null);
        }
    }

    private void c() {
        boolean enableAddBondCards;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (d()) {
                this.f62929e = new CardData.BondCard[0];
                WalletGlobalUtils.safeShowDialog(this, -1, "");
                e();
                enableAddBondCards = true;
            } else {
                this.f62929e = PayDataCache.getInstance().getBondCards();
                enableAddBondCards = PayDataCache.getInstance().enableAddBondCards();
            }
            this.f62926b.setAdaptetr(this.f62929e, enableAddBondCards);
            this.f62926b.setBindCardItemClickListener(this);
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = this.f62931g.mBindFrom;
            return i2 == 4 || i2 == 5;
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            j jVar = (j) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, this.f62925a);
            jVar.setResponseCallback(this);
            jVar.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            BindFastRequest bindFastRequest = this.f62931g;
            if (bindFastRequest == null || bindFastRequest.mBondCard == null) {
                return;
            }
            this.f62934j.setProgressBarVisible(false);
            CardData.BondCard bondCard = this.f62931g.mBondCard;
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
            if (this.f62932h != null && !d()) {
                this.f62932h.mBondCard = null;
            }
            BindFastRequest bindFastRequest2 = this.f62931g;
            int i2 = bindFastRequest2.mBindFrom;
            if (i2 == 2) {
                bindFastRequest2.mBindFrom = 0;
            } else if (i2 == 5) {
                bindFastRequest2.mBindFrom = 3;
            } else if (i2 == 4) {
                bindFastRequest2.mBindFrom = 3;
            }
            int i3 = this.f62931g.mBindFrom;
            if ((i3 == 3 || i3 == 4) && (bindFastRequest = this.f62931g) != null) {
                bindFastRequest.mUseNewCardFindPwd = true;
            }
            PayRequestCache.BindCategory h2 = h();
            if (PayRequestCache.BindCategory.Other == h2) {
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER);
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
                getBindCardFlagDelegate().a(this.f62931g);
                PayRequestCache.getInstance().addBeanRequestToCache(this.f62931g.getRequestId(), this.f62931g);
                this.f62931g.mBondCard = null;
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
                public final /* synthetic */ Bundle f62940a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SelectBindCardActivity f62941b;

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
                    this.f62941b = this;
                    this.f62940a = extras;
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
                        this.f62941b.getBindCardFlagDelegate().a(this.f62941b.f62931g);
                        PayRequestCache.getInstance().addBeanRequestToCache(this.f62941b.f62931g.getRequestId(), this.f62941b.f62931g);
                        this.f62941b.f62931g.mBondCard = null;
                        Bundle bundle = this.f62940a;
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                        Intent intent = this.f62941b.getIntent();
                        if (intent != null && intent.hasExtra("baidu.wallet.from")) {
                            bundle.putString("baidu.wallet.from", intent.getStringExtra("baidu.wallet.from"));
                        }
                        Activity loadingUi = BindCardEntry.getLoadingUi();
                        if (loadingUi instanceof BaseActivity) {
                            ((BaseActivity) loadingUi).startActivityWithExtras(bundle, BindCardImplActivity.class);
                        } else {
                            this.f62941b.startActivityWithExtras(bundle, BindCardImplActivity.class);
                        }
                    }
                }
            }, h2, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.f62933i, null, null);
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
            int i2 = this.f62933i;
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
        this.f62934j = bindCardItemView;
        a(bondCard);
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
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

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            if (i2 != 526) {
                if (i2 == 16) {
                    CalcPaymentResponse calcPaymentResponse = obj instanceof CalcPaymentResponse ? (CalcPaymentResponse) obj : null;
                    this.f62932h.setCalcPayment(calcPaymentResponse);
                    if (calcPaymentResponse != null) {
                        this.f62932h.calcPayPriceByRemote(calcPaymentResponse);
                    }
                    f();
                    return;
                }
                return;
            }
            WalletGlobalUtils.safeDismissDialog(this, -1);
            FindPwdCardCheckResponse findPwdCardCheckResponse = (FindPwdCardCheckResponse) obj;
            if (findPwdCardCheckResponse != null) {
                this.f62929e = findPwdCardCheckResponse.getBondCards();
            }
            CardData.BondCard[] bondCardArr = this.f62929e;
            if (bondCardArr != null && bondCardArr.length != 0) {
                this.f62926b.setAdaptetr(bondCardArr, PayDataCache.getInstance().enableAddBondCards());
                this.f62926b.setBindCardItemClickListener(this);
                return;
            }
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
            finish();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PasswordController.getPassWordInstance().setPassByUserFail("");
            PasswordController.getPassWordInstance().forgetPasswdFailed();
            if (this.f62930f) {
                WalletGlobalUtils.safeShowDialog(this, 4, "");
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagPaySdk();
            if (bundle == null) {
                this.f62930f = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
                this.f62931g = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent()));
                this.k = Boolean.valueOf(PayRequestCache.BindCategory.Pwd.name().equals(getIntent().getStringExtra("baidu.wallet.from")));
                BeanRequestBase beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (beanRequestFromCache != null && (beanRequestFromCache instanceof PayRequest)) {
                    this.f62932h = (PayRequest) beanRequestFromCache;
                }
                if (PayDataCache.getInstance().getPayResponse() != null && PayDataCache.getInstance().getPayResponse().checkResponseValidity()) {
                    PayDataCache.getInstance().getPayResponse().storeResponse(this);
                } else {
                    finish();
                    return;
                }
            } else {
                this.f62930f = bundle.getBoolean("isFrist", false);
                this.k = Boolean.valueOf(bundle.getBoolean("isForPwd", false));
                Serializable serializable = bundle.getSerializable("mBindRequest");
                if (serializable != null && (serializable instanceof BindFastRequest)) {
                    this.f62931g = (BindFastRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f62932h = (PayRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("DirectPayContentResponse");
                if (serializable3 != null && (serializable3 instanceof DirectPayContentResponse)) {
                    ((DirectPayContentResponse) serializable3).storeResponse(getActivity());
                }
            }
            BindFastRequest bindFastRequest = this.f62931g;
            if (bindFastRequest != null && (!bindFastRequest.isRealPay() || this.f62932h != null)) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f62931g.getRequestId(), this.f62931g);
                if (this.f62932h != null) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f62932h.getRequestId(), this.f62932h);
                }
                String str = "bindFrom=" + this.f62931g.mBindFrom + "#";
                this.f62933i = this.f62931g.mBindFrom;
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    a();
                }
                setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_bond_card_activity"));
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                this.f62927c = (TextView) findViewById(ResUtils.id(getActivity(), "select_pay_card"));
                this.f62928d = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "pay_layout"));
                this.l = findViewById(ResUtils.id(getActivity(), "statusbar_top"));
                this.f62928d.getBackButton().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SelectBindCardActivity f62935a;

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
                        this.f62935a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f62935a.onBackPressed();
                        }
                    }
                });
                int i2 = this.f62931g.mBindFrom;
                if (i2 == 4) {
                    String string2 = ResUtils.getString(getActivity(), "ebpay_complete_tip1");
                    initActionBar("ebpay_title_find_pwd");
                    this.f62927c.setVisibility(0);
                    this.f62928d.setVisibility(8);
                    if (!TextUtils.isEmpty(string2)) {
                        this.f62927c.setText(string2);
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
                    this.f62927c.setVisibility(0);
                    this.f62928d.setVisibility(8);
                    if (!TextUtils.isEmpty(string)) {
                        this.f62927c.setText(string);
                    }
                } else if (i2 == 2) {
                    initActionBar("ebpay_title_complete_info");
                    this.f62927c.setVisibility(8);
                    if (PayDataCache.getInstance().hasCanAmount()) {
                        this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip7");
                        if (bundle == null) {
                            WalletGlobalUtils.safeShowDialog(this, 3, "");
                        }
                    }
                    this.f62928d.setVisibility(0);
                    if (payResponse != null) {
                        b();
                        findViewById(ResUtils.id(getActivity(), "bdactionbar")).setVisibility(8);
                        setTop();
                    }
                }
                SelectBindCardLayout selectBindCardLayout = (SelectBindCardLayout) findViewById(ResUtils.id(this, "lv_bond_card_list"));
                this.f62926b = selectBindCardLayout;
                selectBindCardLayout.setBindFrom(this.f62933i);
                c();
                EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
                EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BeanManager.getInstance().removeAllBeans(this.f62925a);
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
            EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
            super.onDestroy();
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) && event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            b();
            BindFastRequest bindFastRequest = this.f62931g;
            if (bindFastRequest == null || bindFastRequest.mBindFrom != 2) {
                return;
            }
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
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
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SelectBindCardActivity f62937a;

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
                    this.f62937a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f62937a, 3);
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
            setFlagPaySdk();
            BindFastRequest bindFastRequest = this.f62931g;
            int i2 = this.f62933i;
            bindFastRequest.mBindFrom = i2;
            bindFastRequest.setBindFromOrigin(i2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, this.f62930f);
            bundle.putBoolean("isForPwd", this.k.booleanValue());
            bundle.putSerializable("mBindRequest", this.f62931g);
            PayRequest payRequest = this.f62932h;
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
            BindFastRequest bindFastRequest2 = this.f62931g;
            bindFastRequest2.mBondCard = bondCard;
            bindFastRequest2.setmBankInfo(null);
            int i2 = this.f62931g.mBindFrom;
            if (i2 == 2) {
                b(bondCard);
            } else if (i2 == 4 || i2 == 5) {
                this.f62931g.setmBankCard(bondCard.account_no);
                this.f62931g.setSubBankCode(bondCard.account_bank_code);
                this.f62931g.mBindFrom = 3;
                extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                if (PayRequestCache.getInstance().isPaying()) {
                    BaiduPay.getInstance().launchBindCardActivity(this, null, extras);
                } else {
                    BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn(this, extras) { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Bundle f62938a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ SelectBindCardActivity f62939b;

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
                            this.f62939b = this;
                            this.f62938a = extras;
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
                                this.f62939b.getBindCardFlagDelegate().a(this.f62939b.f62931g);
                                PayRequestCache.getInstance().addBeanRequestToCache(this.f62939b.f62931g.getRequestId(), this.f62939b.f62931g);
                                Activity loadingUi = BindCardEntry.getLoadingUi();
                                if (loadingUi instanceof BaseActivity) {
                                    ((BaseActivity) loadingUi).startActivityWithExtras(this.f62938a, BindCardImplActivity.class);
                                } else {
                                    this.f62939b.startActivityWithExtras(this.f62938a, BindCardImplActivity.class);
                                }
                            }
                        }
                    }, PayRequestCache.BindCategory.Pwd, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.f62933i, null, null);
                }
            }
            int i3 = this.f62931g.mBindFrom;
            if ((i3 == 3 || i3 == 4) && (bindFastRequest = this.f62931g) != null) {
                bindFastRequest.mUseNewCardFindPwd = false;
            }
            getBindCardFlagDelegate().a(this.f62931g);
            PayRequestCache.getInstance().addBeanRequestToCache(this.f62931g.getRequestId(), this.f62931g);
        }
    }

    private void b(CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bondCard) == null) {
            PayRequest payRequest = this.f62932h;
            if (payRequest != null) {
                payRequest.mBondCard = bondCard;
            }
            if (!PayDataCache.getInstance().needCalcPayment()) {
                f();
                return;
            }
            SelectBindCardLayout.BindCardItemView bindCardItemView = this.f62934j;
            if (bindCardItemView != null) {
                bindCardItemView.setProgressBarVisible(true);
            }
            com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) getActivity(), 16, this.f62925a);
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
            payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
            payTypeItemViewData.card = bondCard;
            cVar.a(payTypeItemViewData);
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }
}
