package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.h;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes13.dex */
public class PayTypeActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_CODE_FOR_BALANCE_LIMIT_LIGHT_APP = 1;
    public static final String TAG = "PayTypeActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public PayRequest a;

    /* renamed from: b  reason: collision with root package name */
    public String f54359b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54360c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54361d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54362e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54363f;
    public PayTypeItemView mClickedItemView;
    public ViewGroup mPayTypeContainerView;
    public PayTypeContract.Presenter mPresenter;

    public PayTypeActivity() {
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
        this.f54359b = "";
        this.f54360c = false;
        this.f54361d = false;
        this.f54363f = false;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_pay_way_list"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    public void dismissLoading(int i2) {
        PayTypeItemView payTypeItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (payTypeItemView = this.mClickedItemView) == null) {
            return;
        }
        payTypeItemView.setItemState(false);
    }

    public void gotoOrderConfim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EventBus eventBus = EventBus.getInstance();
            EventBus eventBus2 = EventBus.getInstance();
            eventBus.getClass();
            PayTypeContract.Presenter presenter = this.mPresenter;
            eventBus2.postStickyEvent(new EventBus.Event(eventBus, "order_confirm_event_bus_key", presenter != null ? presenter.getPayRequest() : null));
            finishWithoutAnim();
        }
    }

    public void gotoPwdPay(boolean z) {
        PayTypeItemView payTypeItemView;
        PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f54362e = z;
            if (PayDataCache.getInstance().isFromPreCashier() && (payTypeItemView = this.mClickedItemView) != null && (payTypeItemViewData = payTypeItemView.mData) != null && (bondCard = payTypeItemViewData.card) != null && !TextUtils.isEmpty(bondCard.account_no)) {
                if (this.f54360c) {
                    String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(this.mClickedItemView.mData.card.account_no);
                    if (!TextUtils.isEmpty(g2)) {
                        PayDataCache.getInstance().setOrderExtraInfo(g2);
                    }
                    BaiduPayDelegate.getInstance().reOrderPay(this.mAct);
                    return;
                } else if (this.mClickedItemView.mData.card.is_sign_jump_bank == 1) {
                    PayData.DirectPayPay directPayPay = PayDataCache.getInstance().getPayResponse().pay;
                    String str = this.mClickedItemView.mData.card.account_no;
                    directPayPay.selected_card_no = str;
                    a(str);
                    return;
                } else {
                    jumpPwdPayActivity();
                    return;
                }
            }
            jumpPwdPayActivity();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, str) == null) {
            if (i2 == 768) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
                GlobalUtils.toast(this.mAct, str);
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) {
            if (i2 == 768) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
                GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
                if (getJumpUrlResponse.agreement_trans_id != null) {
                    com.baidu.wallet.paysdk.banksign.a.a.a().f(getJumpUrlResponse.agreement_trans_id);
                }
                if (getJumpUrlResponse.is_signed == 0) {
                    String str2 = getJumpUrlResponse.form_data;
                    com.baidu.wallet.paysdk.banksign.a.a.a().a(str2 == null ? null : str2.getBytes());
                    if (!this.f54361d) {
                        com.baidu.wallet.paysdk.banksign.a.a.a().a(this);
                    } else {
                        com.baidu.wallet.paysdk.banksign.a.a.a().a((PayTypeActivity) null);
                    }
                    com.baidu.wallet.paysdk.banksign.a.a.a().a(this.f54361d);
                    com.baidu.wallet.paysdk.banksign.a.a.a().d(getJumpUrlResponse.form_url);
                    com.baidu.wallet.paysdk.banksign.a.a.a().e(getJumpUrlResponse.webview_title);
                    BankSignPayFlow a = BankSignPayFlow.a();
                    a.a(BankSignPayFlow.Action.ShowGuide);
                    a.a(this.mAct);
                } else if (PayDataCache.getInstance().isFromPreCashier() && !this.f54361d) {
                    jumpPwdPayActivity();
                } else if (this.f54361d && !TextUtils.isEmpty(getJumpUrlResponse.signed_msg)) {
                    GlobalUtils.toast(this.mAct, getJumpUrlResponse.signed_msg);
                }
            }
            super.handleResponse(i2, obj, str);
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mActionBar.setVisibility(0);
            this.mLeftImg.setOnClickListener(this);
            PayRequest payRequest = this.a;
            if (payRequest != null && payRequest.isWithHoldingValidity()) {
                this.mRightTxt.setVisibility(8);
            } else if (com.baidu.wallet.paysdk.a.b.a()) {
                this.mRightTxt.setVisibility(8);
            } else {
                this.mRightTxt.setVisibility(0);
                this.mRightTxt.setText(ResUtils.getString(this, "ebpay_settings"));
                this.mRightTxt.setOnClickListener(this);
            }
            this.mTitle.setVisibility(4);
            TextView textView = (TextView) findViewById(ResUtils.id(this, "bd_wallet_payway_title"));
            this.mTitle = textView;
            textView.setText(ResUtils.getString(this, "ebpay_pwdpay_payment_select"));
            this.mPayTypeContainerView = (ViewGroup) findViewById(ResUtils.id(this, "bd_wallet_payway_container"));
        }
    }

    public void jumpPwdPayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Intent intent = new Intent(this, PwdPayActivity.class);
            intent.putExtra("IS_FOR_BIND_CARD_PAY", this.f54362e);
            startActivity(intent);
        }
    }

    public void jumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a(str, false, 1);
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.mHalfScreenContainer.isClickable()) {
            if (PayRequestCache.getInstance().isPaying() && PayDataCache.getInstance().isFromPreCashier()) {
                PayCallBackManager.callBackClientCancel(this, "PayTypeActivity.onBackPressed().1");
            }
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onBackPressed();
            }
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view == this.mRightTxt) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CASHDESK_SETTINGS);
                if (PayRequestCache.getInstance().isPaying()) {
                    EventBus.getInstance().register(this, BeanConstants.EVENT_PAY_SORT_SETTING, 0, EventBus.ThreadMode.MainThread);
                }
                BaiduPayServiceController.getInstance().gotoPaySetActivity(this);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            this.f54360c = getIntent().getBooleanExtra("isGatewaySignPay", false);
            initView();
            if (PayDataCache.getInstance().isFromPreCashier()) {
                this.f54359b = "FORM_PRECASHIER";
            } else if (com.baidu.wallet.paysdk.a.b.a()) {
                this.f54359b = "FROM_AUTHORIZE";
            } else {
                this.f54359b = "";
            }
            PayTypeContract.Presenter a = h.a(this.f54359b, this);
            this.mPresenter = a;
            if (a == null) {
                finish();
            } else {
                a.onCreate(bundle);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(TAG);
            EventBus.getInstance().unregister(this, BeanConstants.EVENT_PAY_SORT_SETTING);
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onDestroy();
                this.mPresenter = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, event) == null) || event == null || !BeanConstants.EVENT_PAY_SORT_SETTING.equals(event.mEventKey) || event.mEventObj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) event.mEventObj);
            if (jSONObject.has("pay_sort_change") && 1 == jSONObject.getInt("pay_sort_change")) {
                this.f54363f = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            if (this.f54363f) {
                this.f54363f = false;
                BaiduPayDelegate.getInstance().reOrderPay(this);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onSaveInstanceState(bundle);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void setPageClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mHalfScreenContainer.setClickable(z);
        }
    }

    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mClickedItemView.setItemState(true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList) {
        PayTypeItemView generateItemView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) {
            this.mClickedItemView = null;
            if (arrayList != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<PayTypeItemView.PayTypeItemViewData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PayTypeItemView.PayTypeItemViewData next = it.next();
                    boolean z = next.isChecked;
                    BeanActivity beanActivity = this.mAct;
                    if (beanActivity != null && (generateItemView = PayTypeItemView.generateItemView(beanActivity, next, new View.OnClickListener(this, next) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PayTypeItemView.PayTypeItemViewData a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ PayTypeActivity f54364b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, next};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f54364b = this;
                            this.a = next;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f54364b.jumpUrl(this.a.jump_url);
                                StatisticManager.onEventWithValue("payMethodBalanceQuota", this.a.tips);
                            }
                        }
                    }, new View.OnClickListener(this, next) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PayTypeItemView.PayTypeItemViewData a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ PayTypeActivity f54365b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, next};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f54365b = this;
                            this.a = next;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            CardData.BondCard bondCard;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                boolean z2 = true;
                                this.f54365b.f54361d = true;
                                PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.a;
                                boolean z3 = false;
                                if (payTypeItemViewData != null && (bondCard = payTypeItemViewData.card) != null) {
                                    z2 = (bondCard.is_sign_jump_bank != 1 || TextUtils.isEmpty(bondCard.account_no)) ? false : false;
                                    StatHelper.cacheBankCode(this.a.card.bank_code);
                                    StatHelper.cacheCardType(this.a.card.card_type + "");
                                    z3 = z2;
                                }
                                if (z3) {
                                    this.f54365b.a(this.a.card.account_no);
                                    return;
                                }
                                if (!TextUtils.isEmpty(this.a.hintUrl)) {
                                    BaiduWalletDelegate.getInstance().openH5Module(this.f54365b.getActivity(), this.a.hintUrl);
                                }
                                StatisticManager.onEventWithValue("payMethodBankHint", this.a.hintMsg);
                            }
                        }
                    })) != null) {
                        generateItemView.setOnClickListener(new View.OnClickListener(this, next, generateItemView) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ PayTypeItemView.PayTypeItemViewData a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ PayTypeItemView f54366b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ PayTypeActivity f54367c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, next, generateItemView};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f54367c = this;
                                this.a = next;
                                this.f54366b = generateItemView;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                CardData.BondCard bondCard;
                                CardData.BondCard bondCard2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.a;
                                    if (!payTypeItemViewData.isAvaible) {
                                        if (payTypeItemViewData.isNeedToColored()) {
                                            return;
                                        }
                                        PayTypeActivity payTypeActivity = this.f54367c;
                                        PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = this.a;
                                        GlobalUtils.toast(payTypeActivity, payTypeItemViewData2.removeSeparator(payTypeItemViewData2.tips));
                                        return;
                                    }
                                    String str = "";
                                    if (payTypeItemViewData != null && (bondCard2 = payTypeItemViewData.card) != null) {
                                        StatHelper.cacheBankCode(bondCard2.bank_code);
                                        StatHelper.cacheCardType(this.a.card.card_type + "");
                                    }
                                    if (this.f54367c.f54360c && PayDataCache.getInstance().isFromPreCashier()) {
                                        PayTypeItemView.PayTypeItemViewData payTypeItemViewData3 = this.a;
                                        if (payTypeItemViewData3 != null && (bondCard = payTypeItemViewData3.card) != null && bondCard.account_no != null) {
                                            str = com.baidu.wallet.paysdk.banksign.a.a.a().g(this.a.card.account_no);
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            PayDataCache.getInstance().setOrderExtraInfo(str);
                                        }
                                        BaiduPayDelegate.getInstance().reOrderPay(this.f54367c.mAct);
                                        return;
                                    }
                                    PayTypeActivity payTypeActivity2 = this.f54367c;
                                    payTypeActivity2.mClickedItemView = this.f54366b;
                                    payTypeActivity2.f54361d = false;
                                    PayTypeItemView.ItemViewType itemViewType = this.a.type;
                                    if (itemViewType == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                                        StatHelper.cachePayWay(4);
                                        StatHelper.statServiceEvent("onekeyClickNewcard");
                                    } else if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                                        StatHelper.statServiceEvent(StatServiceEvent.EVENT_SWITCH_BANKCARD);
                                    }
                                    PayTypeContract.Presenter presenter = this.f54367c.mPresenter;
                                    if (presenter != null) {
                                        presenter.modifyPayType(this.a);
                                    }
                                }
                            }
                        });
                        arrayList2.add(generateItemView);
                    }
                }
                this.mPayTypeContainerView.removeAllViews();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    this.mPayTypeContainerView.addView((PayTypeItemView) it2.next());
                    View view = new View(getActivity());
                    view.setBackgroundColor(ResUtils.getColor(getActivity(), "wallet_base_separator_color"));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 1);
                    int dimension = (int) ResUtils.getDimension(this.mAct, "dxm_wallet_base_margin");
                    layoutParams.setMargins(dimension, 0, dimension, 0);
                    view.setLayoutParams(layoutParams);
                    this.mPayTypeContainerView.addView(view);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(PayTypeContract.Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, presenter) == null) {
            this.mPresenter = presenter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            if (this.f54361d) {
                StatisticManager.onEvent("clickBankSign");
            }
            com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) BankSignFactory.getInstance().getBean((Context) this.mAct, 768, TAG);
            com.baidu.wallet.paysdk.banksign.a.a.a().a(str);
            bVar.a(str);
            bVar.setResponseCallback(this.mAct);
            bVar.execBean();
        }
    }

    private void a(String str, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            LocalRouter.getInstance(this).route(this, new RouterRequest().provider("langbrige").action("langbrige_getStartIntent").data("url", str).data("withAnim", Boolean.valueOf(z)).data("showShare", Boolean.TRUE), new RouterCallback(this, i2) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayTypeActivity f54368b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54368b = this;
                    this.a = i2;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i3, HashMap hashMap) {
                    Intent intent;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) && i3 == 0 && hashMap != null && (hashMap.get("result") instanceof Intent) && (intent = (Intent) hashMap.get("result")) != null) {
                        this.f54368b.startActivityForResult(intent, this.a);
                    }
                }
            });
        }
    }
}
