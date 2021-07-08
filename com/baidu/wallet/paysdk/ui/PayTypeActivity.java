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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
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
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class PayTypeActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_CODE_FOR_BALANCE_LIMIT_LIGHT_APP = 1;
    public static final String TAG = "PayTypeActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f26616a;

    /* renamed from: b  reason: collision with root package name */
    public String f26617b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26618c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26619e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26620f;
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
        this.f26617b = "";
        this.f26618c = false;
        this.f26619e = false;
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
            this.f26620f = z;
            if (PayDataCache.getInstance().isFromPreCashier() && (payTypeItemView = this.mClickedItemView) != null && (payTypeItemViewData = payTypeItemView.mData) != null && (bondCard = payTypeItemViewData.card) != null && !TextUtils.isEmpty(bondCard.account_no)) {
                if (this.f26618c) {
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
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
                    if (!this.f26619e) {
                        com.baidu.wallet.paysdk.banksign.a.a.a().a(this);
                    } else {
                        com.baidu.wallet.paysdk.banksign.a.a.a().a((PayTypeActivity) null);
                    }
                    com.baidu.wallet.paysdk.banksign.a.a.a().a(this.f26619e);
                    com.baidu.wallet.paysdk.banksign.a.a.a().d(getJumpUrlResponse.form_url);
                    com.baidu.wallet.paysdk.banksign.a.a.a().e(getJumpUrlResponse.webview_title);
                    BankSignPayFlow a2 = BankSignPayFlow.a();
                    a2.a(BankSignPayFlow.Action.ShowGuide);
                    a2.a(this.mAct);
                } else if (PayDataCache.getInstance().isFromPreCashier() && !this.f26619e) {
                    jumpPwdPayActivity();
                } else if (this.f26619e && !TextUtils.isEmpty(getJumpUrlResponse.signed_msg)) {
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
            PayRequest payRequest = this.f26616a;
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
            intent.putExtra("IS_FOR_BIND_CARD_PAY", this.f26620f);
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
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
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CASHDESK_SETTINGS);
                PayController.getInstance().startPaySettingActivity(this, new PaySettingActivity.a(this) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PayTypeActivity f26628a;

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
                        this.f26628a = this;
                    }

                    @Override // com.baidu.wallet.paysdk.ui.PaySettingActivity.a
                    public void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            LogUtil.d(PayTypeActivity.TAG, "是否更换了支付方式：" + z);
                            if (z) {
                                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CASHDESK_SETTED_METHOD);
                                PayTypeContract.Presenter presenter = this.f26628a.mPresenter;
                                if (presenter != null) {
                                    presenter.reOrderPay();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.f26616a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            this.f26618c = getIntent().getBooleanExtra("isGatewaySignPay", false);
            initView();
            if (PayDataCache.getInstance().isFromPreCashier()) {
                this.f26617b = "FORM_PRECASHIER";
            } else if (com.baidu.wallet.paysdk.a.b.a()) {
                this.f26617b = "FROM_AUTHORIZE";
            } else {
                this.f26617b = "";
            }
            PayTypeContract.Presenter a2 = h.a(this.f26617b, this);
            this.mPresenter = a2;
            if (a2 == null) {
                finish();
            } else {
                a2.onCreate(bundle);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(TAG);
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onDestroy();
                this.mPresenter = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            PayTypeContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onSaveInstanceState(bundle);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void setPageClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mHalfScreenContainer.setClickable(z);
        }
    }

    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mClickedItemView.setItemState(true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList) {
        PayTypeItemView generateItemView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
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

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PayTypeItemView.PayTypeItemViewData f26621a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ PayTypeActivity f26622b;

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
                            this.f26622b = this;
                            this.f26621a = next;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.f26622b.jumpUrl(this.f26621a.jump_url);
                                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_PAY_METHOD_BALANCE_QUOTA, this.f26621a.tips);
                            }
                        }
                    }, new View.OnClickListener(this, next) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PayTypeItemView.PayTypeItemViewData f26623a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ PayTypeActivity f26624b;

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
                            this.f26624b = this;
                            this.f26623a = next;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            CardData.BondCard bondCard;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                boolean z2 = true;
                                this.f26624b.f26619e = true;
                                PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f26623a;
                                if ((payTypeItemViewData == null || (bondCard = payTypeItemViewData.card) == null || bondCard.is_sign_jump_bank != 1 || TextUtils.isEmpty(bondCard.account_no)) ? false : false) {
                                    this.f26624b.a(this.f26623a.card.account_no);
                                    return;
                                }
                                if (!TextUtils.isEmpty(this.f26623a.hintUrl)) {
                                    BaiduWalletDelegate.getInstance().openH5Module(this.f26624b.getActivity(), this.f26623a.hintUrl);
                                }
                                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_PAY_METHOD_BANK_HINT, this.f26623a.hintMsg);
                            }
                        }
                    })) != null) {
                        generateItemView.setOnClickListener(new View.OnClickListener(this, next, generateItemView) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ PayTypeItemView.PayTypeItemViewData f26625a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ PayTypeItemView f26626b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ PayTypeActivity f26627c;

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
                                this.f26627c = this;
                                this.f26625a = next;
                                this.f26626b = generateItemView;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData = this.f26625a;
                                    if (!payTypeItemViewData.isAvaible) {
                                        if (payTypeItemViewData.isNeedToColored()) {
                                            return;
                                        }
                                        PayTypeActivity payTypeActivity = this.f26627c;
                                        PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = this.f26625a;
                                        GlobalUtils.toast(payTypeActivity, payTypeItemViewData2.removeSeparator(payTypeItemViewData2.tips));
                                    } else if (this.f26627c.f26618c && PayDataCache.getInstance().isFromPreCashier()) {
                                        String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(this.f26625a.card.account_no);
                                        if (!TextUtils.isEmpty(g2)) {
                                            PayDataCache.getInstance().setOrderExtraInfo(g2);
                                        }
                                        BaiduPayDelegate.getInstance().reOrderPay(this.f26627c.mAct);
                                    } else {
                                        PayTypeActivity payTypeActivity2 = this.f26627c;
                                        payTypeActivity2.mClickedItemView = this.f26626b;
                                        payTypeActivity2.f26619e = false;
                                        PayTypeItemView.ItemViewType itemViewType = this.f26625a.type;
                                        if (itemViewType == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_NEWCARD_PAY);
                                        } else if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_SWITCH_BANKCARD);
                                        }
                                        PayTypeContract.Presenter presenter = this.f26627c.mPresenter;
                                        if (presenter != null) {
                                            presenter.modifyPayType(this.f26625a);
                                        }
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
                    int dimension = (int) ResUtils.getDimension(this.mAct, "wallet_base_margin");
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
        if (interceptable == null || interceptable.invokeL(1048594, this, presenter) == null) {
            this.mPresenter = presenter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            if (this.f26619e) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_BANK_SIGN);
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
            LocalRouter.getInstance(this).route(this, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getStartIntent").data("url", str).data("withAnim", Boolean.valueOf(z)).data("showShare", Boolean.TRUE), new RouterCallback(this, i2) { // from class: com.baidu.wallet.paysdk.ui.PayTypeActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f26629a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayTypeActivity f26630b;

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
                    this.f26630b = this;
                    this.f26629a = i2;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i3, HashMap hashMap) {
                    Intent intent;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) && i3 == 0 && hashMap != null && (hashMap.get("result") instanceof Intent) && (intent = (Intent) hashMap.get("result")) != null) {
                        this.f26630b.startActivityForResult(intent, this.f26629a);
                    }
                }
            });
        }
    }
}
