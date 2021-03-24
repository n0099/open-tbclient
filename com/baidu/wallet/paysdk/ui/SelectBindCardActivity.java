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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.Constants;
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

    /* renamed from: b  reason: collision with root package name */
    public SelectBindCardLayout f26235b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26236c;

    /* renamed from: d  reason: collision with root package name */
    public OrderConfirmation f26237d;

    /* renamed from: e  reason: collision with root package name */
    public CardData.BondCard[] f26238e;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f26240g;

    /* renamed from: h  reason: collision with root package name */
    public PayRequest f26241h;
    public int i;
    public SelectBindCardLayout.BindCardItemView j;
    public View l;

    /* renamed from: a  reason: collision with root package name */
    public final String f26234a = "SelectBindCardActivity" + hashCode();

    /* renamed from: f  reason: collision with root package name */
    public boolean f26239f = false;
    public Boolean k = Boolean.FALSE;

    private void a() {
    }

    private void b() {
        String displayName;
        PayRequest payRequest = this.f26241h;
        if (payRequest == null) {
            return;
        }
        String needToPayAmount = payRequest.getNeedToPayAmount();
        String orderPrice = this.f26241h.getOrderPrice();
        String discountAmount = this.f26241h.getDiscountAmount();
        boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
        SpannableString spannableString = new SpannableString(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
        if (z) {
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        }
        String str = "-" + ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
        if (this.f26241h.showCouponListEntry()) {
            this.f26237d.setDiscountInfoVisiable(true);
            this.f26237d.setCouponInfo(this.f26241h.getDiscountMsg(), str, new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayController.getInstance().gotoDiscountPage(SelectBindCardActivity.this);
                }
            });
        } else if (!TextUtils.isEmpty(this.f26241h.getRandomDiscountMsg())) {
            this.f26237d.setDiscountInfoVisiable(true);
            this.f26237d.setCouponInfo(this.f26241h.getRandomDiscountMsg(), "", null);
        } else {
            this.f26237d.setDiscountInfoVisiable(false);
        }
        this.f26237d.setOrderPrice(StringUtils.fen2Yuan(needToPayAmount), spannableString);
        this.f26237d.setOrderInfo(this.f26241h.getGoodsName());
        this.f26237d.setTitle(this.f26241h.title_url);
        this.f26237d.setSpNameValue(PayDataCache.getInstance().getSpName());
        if (PayDataCache.getInstance().isRemotePay()) {
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                displayName = WalletLoginHelper.getInstance().getPassUserName();
            } else {
                displayName = PayDataCache.getInstance().getPayResponse().getDisplayName();
            }
            this.f26237d.setAccountInfo(displayName, null);
        }
    }

    private void c() {
        boolean enableAddBondCards;
        if (d()) {
            this.f26238e = new CardData.BondCard[0];
            WalletGlobalUtils.safeShowDialog(this, -1, "");
            e();
            enableAddBondCards = true;
        } else {
            this.f26238e = PayDataCache.getInstance().getBondCards();
            enableAddBondCards = PayDataCache.getInstance().enableAddBondCards();
        }
        this.f26235b.setAdaptetr(this.f26238e, enableAddBondCards);
        this.f26235b.setBindCardItemClickListener(this);
    }

    private boolean d() {
        int i = this.f26240g.mBindFrom;
        return i == 4 || i == 5;
    }

    private void e() {
        m mVar = (m) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, this.f26234a);
        mVar.setResponseCallback(this);
        mVar.execBean();
    }

    private void f() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        BindFastRequest bindFastRequest = this.f26240g;
        if (bindFastRequest == null || bindFastRequest.mBondCard == null) {
            return;
        }
        this.j.setProgressBarVisible(false);
        CardData.BondCard bondCard = this.f26240g.mBondCard;
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

    private void g() {
        BindFastRequest bindFastRequest;
        final Bundle extras = getIntent().getExtras();
        if (this.f26241h != null && !d()) {
            this.f26241h.mBondCard = null;
        }
        BindFastRequest bindFastRequest2 = this.f26240g;
        int i = bindFastRequest2.mBindFrom;
        if (i == 2) {
            bindFastRequest2.mBindFrom = 0;
        } else if (i == 5) {
            bindFastRequest2.mBindFrom = 3;
        } else if (i == 4) {
            bindFastRequest2.mBindFrom = 3;
        }
        int i2 = this.f26240g.mBindFrom;
        if ((i2 == 3 || i2 == 4) && (bindFastRequest = this.f26240g) != null) {
            bindFastRequest.mUseNewCardFindPwd = true;
        }
        PayRequestCache.BindCategory h2 = h();
        if (PayRequestCache.BindCategory.Other == h2) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            getBindCardFlagDelegate().a(this.f26240g);
            PayRequestCache.getInstance().addBeanRequestToCache(this.f26240g.getRequestId(), this.f26240g);
            this.f26240g.mBondCard = null;
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
            startActivityWithExtras(extras, BindCardImplActivity.class);
            return;
        }
        BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn() { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.5
            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
            public void onFailed(int i3, String str) {
            }

            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
            public void onResponse(CardAddResponse cardAddResponse) {
                SelectBindCardActivity.this.getBindCardFlagDelegate().a(SelectBindCardActivity.this.f26240g);
                PayRequestCache.getInstance().addBeanRequestToCache(SelectBindCardActivity.this.f26240g.getRequestId(), SelectBindCardActivity.this.f26240g);
                SelectBindCardActivity.this.f26240g.mBondCard = null;
                Bundle bundle = extras;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
                Intent intent = SelectBindCardActivity.this.getIntent();
                if (intent != null && intent.hasExtra(Constants.BDL_KEY_FROM)) {
                    bundle.putString(Constants.BDL_KEY_FROM, intent.getStringExtra(Constants.BDL_KEY_FROM));
                }
                Activity loadingUi = BindCardEntry.getLoadingUi();
                if (loadingUi instanceof BaseActivity) {
                    ((BaseActivity) loadingUi).startActivityWithExtras(bundle, BindCardImplActivity.class);
                } else {
                    SelectBindCardActivity.this.startActivityWithExtras(bundle, BindCardImplActivity.class);
                }
            }
        }, h2, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.i, null, null);
    }

    private PayRequestCache.BindCategory h() {
        if (PayRequestCache.getInstance().isPaying()) {
            return PayRequestCache.BindCategory.Other;
        }
        if (this.k.booleanValue()) {
            return PayRequestCache.BindCategory.Pwd;
        }
        int i = this.i;
        if (1 == i) {
            return PayRequestCache.BindCategory.Initiative;
        }
        if (4 == i) {
            return PayRequestCache.BindCategory.Pwd;
        }
        if (5 == i && !PayRequestCache.getInstance().isPaying()) {
            return PayRequestCache.BindCategory.Initiative;
        }
        return PayRequestCache.BindCategory.Other;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.b
    public void addNewCardClick() {
        g();
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.SelectBindCardLayout.b
    public void enableCardClick(SelectBindCardLayout.BindCardItemView bindCardItemView, CardData.BondCard bondCard) {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        this.j = bindCardItemView;
        a(bondCard);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        if (i == 526) {
            WalletGlobalUtils.safeDismissDialog(this, -1);
            GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
            finish();
            return;
        }
        super.handleFailure(i, i2, str);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        if (i != 526) {
            if (i == 16) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.CALCU_COUPON, 0);
                CalcPaymentResponse calcPaymentResponse = obj instanceof CalcPaymentResponse ? (CalcPaymentResponse) obj : null;
                this.f26241h.setCalcPayment(calcPaymentResponse);
                if (calcPaymentResponse != null) {
                    this.f26241h.calcPayPriceByRemote(calcPaymentResponse);
                }
                f();
                return;
            }
            return;
        }
        WalletGlobalUtils.safeDismissDialog(this, -1);
        FindPwdCardCheckResponse findPwdCardCheckResponse = (FindPwdCardCheckResponse) obj;
        if (findPwdCardCheckResponse != null) {
            this.f26238e = findPwdCardCheckResponse.getBondCards();
        }
        CardData.BondCard[] bondCardArr = this.f26238e;
        if (bondCardArr != null && bondCardArr.length != 0) {
            this.f26235b.setAdaptetr(bondCardArr, PayDataCache.getInstance().enableAddBondCards());
            this.f26235b.setBindCardItemClickListener(this);
            return;
        }
        GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_find_pwd_get_cardlist_failed"));
        finish();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        PasswordController.getPassWordInstance().setPassByUserFail("");
        PasswordController.getPassWordInstance().forgetPasswdFailed();
        if (this.f26239f) {
            WalletGlobalUtils.safeShowDialog(this, 4, "");
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setFlagPaySdk();
        if (bundle == null) {
            this.f26239f = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
            this.f26240g = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent()));
            this.k = Boolean.valueOf(PayRequestCache.BindCategory.Pwd.name().equals(getIntent().getStringExtra(Constants.BDL_KEY_FROM)));
            BeanRequestBase beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (beanRequestFromCache != null && (beanRequestFromCache instanceof PayRequest)) {
                this.f26241h = (PayRequest) beanRequestFromCache;
            }
            if (PayDataCache.getInstance().getPayResponse() != null && PayDataCache.getInstance().getPayResponse().checkResponseValidity()) {
                PayDataCache.getInstance().getPayResponse().storeResponse(this);
            } else {
                finish();
                return;
            }
        } else {
            this.f26239f = bundle.getBoolean("isFrist", false);
            this.k = Boolean.valueOf(bundle.getBoolean("isForPwd", false));
            Serializable serializable = bundle.getSerializable("mBindRequest");
            if (serializable != null && (serializable instanceof BindFastRequest)) {
                this.f26240g = (BindFastRequest) serializable;
            }
            Serializable serializable2 = bundle.getSerializable("mPayRequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                this.f26241h = (PayRequest) serializable2;
            }
            Serializable serializable3 = bundle.getSerializable("DirectPayContentResponse");
            if (serializable3 != null && (serializable3 instanceof DirectPayContentResponse)) {
                ((DirectPayContentResponse) serializable3).storeResponse(getActivity());
            }
        }
        BindFastRequest bindFastRequest = this.f26240g;
        if (bindFastRequest != null && (!bindFastRequest.isRealPay() || this.f26241h != null)) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.f26240g.getRequestId(), this.f26240g);
            if (this.f26241h != null) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26241h.getRequestId(), this.f26241h);
            }
            LogUtil.d("bindFrom=" + this.f26240g.mBindFrom + "#");
            this.i = this.f26240g.mBindFrom;
            if (PayDataCache.getInstance().hasMobilePwd()) {
                a();
            }
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_bond_card_activity"));
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            this.f26236c = (TextView) findViewById(ResUtils.id(getActivity(), "select_pay_card"));
            this.f26237d = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "pay_layout"));
            this.l = findViewById(ResUtils.id(getActivity(), "statusbar_top"));
            this.f26237d.getBackButton().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SelectBindCardActivity.this.onBackPressed();
                }
            });
            int i = this.f26240g.mBindFrom;
            if (i == 4) {
                String string2 = ResUtils.getString(getActivity(), "ebpay_complete_tip1");
                initActionBar("ebpay_title_find_pwd");
                this.f26236c.setVisibility(0);
                this.f26237d.setVisibility(8);
                if (!TextUtils.isEmpty(string2)) {
                    this.f26236c.setText(string2);
                }
            } else if (i == 5) {
                if (PayDataCache.getInstance().hasEnableCardsForFindPWD()) {
                    string = ResUtils.getString(getActivity(), "ebpay_complete_tip4");
                } else if (!PayDataCache.getInstance().enableAddBondCards()) {
                    string = ResUtils.getString(getActivity(), "ebpay_complete_tip5");
                } else {
                    string = ResUtils.getString(getActivity(), "ebpay_complete_tip6");
                }
                initActionBar("ebpay_title_complete_info");
                this.f26236c.setVisibility(0);
                this.f26237d.setVisibility(8);
                if (!TextUtils.isEmpty(string)) {
                    this.f26236c.setText(string);
                }
            } else if (i == 2) {
                initActionBar("ebpay_title_complete_info");
                this.f26236c.setVisibility(8);
                if (PayDataCache.getInstance().hasCanAmount()) {
                    this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip7");
                    if (bundle == null) {
                        WalletGlobalUtils.safeShowDialog(this, 3, "");
                    }
                }
                this.f26237d.setVisibility(0);
                if (payResponse != null) {
                    b();
                    findViewById(ResUtils.id(getActivity(), "bdactionbar")).setVisibility(8);
                    setTop();
                }
            }
            SelectBindCardLayout selectBindCardLayout = (SelectBindCardLayout) findViewById(ResUtils.id(this, "lv_bond_card_list"));
            this.f26235b = selectBindCardLayout;
            selectBindCardLayout.setBindFrom(this.i);
            c();
            EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
            EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
            return;
        }
        finish();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 3) {
            if (i != 4) {
                return super.onCreateDialog(i);
            }
            return new PromptDialog(getActivity());
        }
        return new PromptDialog(getActivity());
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(this.f26234a);
        EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"order_confirm_event_bus_key".equals(event.mEventKey)) {
            return;
        }
        b();
        BindFastRequest bindFastRequest = this.f26240g;
        if (bindFastRequest == null || bindFastRequest.mBindFrom != 2) {
            return;
        }
        c();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (i != 3) {
            super.onPrepareDialog(i, dialog);
            return;
        }
        PromptDialog promptDialog = (PromptDialog) dialog;
        promptDialog.setCanceledOnTouchOutside(false);
        promptDialog.setMessage(this.mDialogMsg);
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WalletGlobalUtils.safeDismissDialog(SelectBindCardActivity.this, 3);
            }
        });
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
        setFlagPaySdk();
        BindFastRequest bindFastRequest = this.f26240g;
        int i = this.i;
        bindFastRequest.mBindFrom = i;
        bindFastRequest.setBindFromOrigin(i);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(BindFastRequest.BIND_IS_FIRST, this.f26239f);
        bundle.putBoolean("isForPwd", this.k.booleanValue());
        bundle.putSerializable("mBindRequest", this.f26240g);
        PayRequest payRequest = this.f26241h;
        if (payRequest != null) {
            bundle.putSerializable("mPayRequest", payRequest);
        }
        bundle.putSerializable("DirectPayContentResponse", PayDataCache.getInstance().getPayResponse());
        super.onSaveInstanceState(bundle);
    }

    public void setTop() {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(this.mAct) + 10));
        ImmersiveStatusBarManager.setTopBar(this.mAct.getActivity(), this.l, isStatusbarTextColorBlack());
    }

    private void a(CardData.BondCard bondCard) {
        BindFastRequest bindFastRequest;
        final Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        if (bondCard == null) {
            return;
        }
        BindFastRequest bindFastRequest2 = this.f26240g;
        bindFastRequest2.mBondCard = bondCard;
        bindFastRequest2.setmBankInfo(null);
        int i = this.f26240g.mBindFrom;
        if (i == 2) {
            b(bondCard);
        } else if (i == 4 || i == 5) {
            this.f26240g.setmBankCard(bondCard.account_no);
            this.f26240g.setSubBankCode(bondCard.account_bank_code);
            this.f26240g.mBindFrom = 3;
            extras.putBoolean(BindFastRequest.BIND_IS_FIRST, false);
            if (PayRequestCache.getInstance().isPaying()) {
                BaiduPay.getInstance().launchBindCardActivity(this, null, extras);
            } else {
                BaiduPay.getInstance().bindCardOnCardaddReturn(this, new BindCardEntry.OnReturn() { // from class: com.baidu.wallet.paysdk.ui.SelectBindCardActivity.4
                    @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                    public void onFailed(int i2, String str) {
                    }

                    @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
                    public void onResponse(CardAddResponse cardAddResponse) {
                        SelectBindCardActivity.this.getBindCardFlagDelegate().a(SelectBindCardActivity.this.f26240g);
                        PayRequestCache.getInstance().addBeanRequestToCache(SelectBindCardActivity.this.f26240g.getRequestId(), SelectBindCardActivity.this.f26240g);
                        Activity loadingUi = BindCardEntry.getLoadingUi();
                        if (loadingUi instanceof BaseActivity) {
                            ((BaseActivity) loadingUi).startActivityWithExtras(extras, BindCardImplActivity.class);
                        } else {
                            SelectBindCardActivity.this.startActivityWithExtras(extras, BindCardImplActivity.class);
                        }
                    }
                }, PayRequestCache.BindCategory.Pwd, this.k.booleanValue() ? PayRequestCache.BindCategory.Pwd.getScenario() : this.i, null, null);
            }
        }
        int i2 = this.f26240g.mBindFrom;
        if ((i2 == 3 || i2 == 4) && (bindFastRequest = this.f26240g) != null) {
            bindFastRequest.mUseNewCardFindPwd = false;
        }
        getBindCardFlagDelegate().a(this.f26240g);
        PayRequestCache.getInstance().addBeanRequestToCache(this.f26240g.getRequestId(), this.f26240g);
    }

    private void b(CardData.BondCard bondCard) {
        PayRequest payRequest = this.f26241h;
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
        com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) getActivity(), 16, this.f26234a);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CALCU_COUPON);
        PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
        payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
        payTypeItemViewData.card = bondCard;
        cVar.a(payTypeItemViewData);
        cVar.setResponseCallback(this);
        cVar.execBean();
    }
}
