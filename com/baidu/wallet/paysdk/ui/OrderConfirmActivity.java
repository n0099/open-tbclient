package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.AnimUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.contract.OrderConfirmContract;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.OrderConfirmPresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public class OrderConfirmActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public String C;
    public String D;
    public RelativeSizeSpan E;
    public View F;
    public boolean G;
    public String H;
    public String I;

    /* renamed from: a  reason: collision with root package name */
    public final String f26686a;

    /* renamed from: b  reason: collision with root package name */
    public OrderConfirmContract.Presenter f26687b;

    /* renamed from: c  reason: collision with root package name */
    public View f26688c;

    /* renamed from: e  reason: collision with root package name */
    public View f26689e;

    /* renamed from: f  reason: collision with root package name */
    public NetImageView f26690f;

    /* renamed from: g  reason: collision with root package name */
    public View f26691g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26692h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26693i;
    public ImageView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public View o;
    public TextView p;
    public View q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public WalletBaseButtonWithImage y;
    public View z;

    public OrderConfirmActivity() {
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
        this.f26686a = OrderConfirmActivity.class.getSimpleName();
        this.k = false;
        this.G = false;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_order_confirm_layout"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    public void dismissLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public void gotoCoupon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            startActivity(new Intent(getActivity(), CouponListActivity.class));
        }
    }

    public void gotoNext(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (c()) {
                this.H = str;
                this.I = str2;
                WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
                BankSignFactory bankSignFactory = BankSignFactory.getInstance();
                BeanActivity beanActivity = this.mAct;
                com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) bankSignFactory.getBean((Context) beanActivity, 768, this.f26686a + toString());
                CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
                bVar.a(selectCard != null ? selectCard.account_no : "");
                bVar.setResponseCallback(this);
                bVar.execBean();
                return;
            }
            pay(str, str2, false);
        }
    }

    public void gotoPayType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            startActivity(new Intent(getActivity(), PayTypeActivity.class));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) && i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            pay(this.H, this.I, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048582, this, i2, obj, str) == null) && i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GetJumpUrlResponse getJumpUrlResponse = (GetJumpUrlResponse) obj;
            if (getJumpUrlResponse.agreement_trans_id != null) {
                com.baidu.wallet.paysdk.banksign.a.a.a().f(getJumpUrlResponse.agreement_trans_id);
            }
            if (getJumpUrlResponse.is_signed == 0) {
                String str2 = getJumpUrlResponse.form_data;
                com.baidu.wallet.paysdk.banksign.a.a.a().a(str2 == null ? null : str2.getBytes());
                com.baidu.wallet.paysdk.banksign.a.a.a().a(false);
                com.baidu.wallet.paysdk.banksign.a.a.a().d(getJumpUrlResponse.form_url);
                com.baidu.wallet.paysdk.banksign.a.a.a().e(getJumpUrlResponse.webview_title);
                com.baidu.wallet.paysdk.banksign.a.a.a().c(this.H);
                com.baidu.wallet.paysdk.banksign.a.a.a().b(this.I);
                com.baidu.wallet.paysdk.banksign.a.a.a().a(this);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a(this.mAct);
                return;
            }
            pay(this.H, this.I, true);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26687b.closeOrderComfirmPage();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view == this.f26691g) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_PAY_TYPE_ITEM);
                ImageView imageView = this.j;
                if (imageView != null && imageView.getVisibility() == 0) {
                    this.k = true;
                }
                this.f26687b.clickPayway();
            } else if (view == this.q) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_COUPON_ITEM);
                this.f26687b.clickCoupon();
            } else if (view == this.F) {
                this.f26687b.closeOrderComfirmPage();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            b();
            OrderConfirmPresenter orderConfirmPresenter = new OrderConfirmPresenter(this);
            this.f26687b = orderConfirmPresenter;
            orderConfirmPresenter.onCreate(bundle);
            LogUtil.d(this.f26686a, "OrderConfirmActivity.onCreate");
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            OrderConfirmContract.Presenter presenter = this.f26687b;
            if (presenter != null) {
                presenter.onDestroy();
                this.f26687b = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            LogUtil.d(this.f26686a, "OrderConfirmActivity.onPause");
            if (Build.VERSION.SDK_INT >= 23) {
                WalletFingerprint.getInstance(this).cancleListening();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            OrderConfirmContract.Presenter presenter = this.f26687b;
            if (presenter != null) {
                presenter.startFingerprintListening();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.f26687b.onSaveInstanceState(bundle);
        }
    }

    public void pay(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, str, str2, z) == null) {
            Intent intent = new Intent(this, PwdPayActivity.class);
            intent.putExtra("otpToken", str);
            intent.putExtra("warningTips", str2);
            intent.putExtra("gatewaySign", z);
            if (this.G) {
                intent.putExtra("IS_FOR_BIND_CARD_PAY", true);
                StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
            }
            startActivity(intent);
        }
    }

    public void showFpCheckError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.A.setText(ResUtils.getString(getActivity(), "wallet_cashdesk_onceagain"));
            this.A.setTextColor(ResUtils.getColor(this.mAct, "wallet_fp_record_tip_color_error"));
            this.B.setImageDrawable(ResUtils.getDrawable(this, "wallet_fingerprint_little_icon_red"));
            AnimUtils.startSharkAnim(this.z);
        }
    }

    public void showFpCheckSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.A.setText("指纹验证成功");
            this.A.setTextColor(ResUtils.getColor(this.mAct, "wallet_fp_record_tip_coloe_397BE6"));
            this.B.setImageDrawable(ResUtils.getDrawable(this, "wallet_cashdesk_fp_succ"));
            this.A.postDelayed(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f26697a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ OrderConfirmActivity f26698b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26698b = this;
                    this.f26697a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26698b.gotoNext(this.f26697a, null);
                        this.f26698b.A.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f26699a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f26699a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f26699a.f26698b.A.setText(ResUtils.getString(this.f26699a.f26698b, "wallet_fp_pay_tips"));
                                    this.f26699a.f26698b.B.setImageDrawable(ResUtils.getDrawable(this.f26699a.f26698b, "wallet_cashdesk_fp_logo"));
                                }
                            }
                        }, 300L);
                    }
                }
            }, 300L);
        }
    }

    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f26687b.getViewData();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mActionBar.setVisibility(8);
            this.f26690f = (NetImageView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_logo"));
            this.f26690f.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
            TextView textView = (TextView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_paymethod_entry"));
            this.x = textView;
            textView.setVisibility(8);
            this.f26688c = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_account_layout"));
            this.f26689e = this.mContentView.findViewById(ResUtils.id(getActivity(), "bd_wallet_account_arrow_icon"));
            this.w = (TextView) findViewById(ResUtils.id(this, "ebpay_account"));
            this.f26691g = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_payway_layout"));
            this.f26692h = (TextView) findViewById(ResUtils.id(this, "paytype_desc"));
            this.f26693i = (TextView) findViewById(ResUtils.id(this, "payway_discount"));
            this.l = (TextView) findViewById(ResUtils.id(this, "payway_txt_for_complete_bankcard"));
            this.j = (ImageView) findViewById(ResUtils.id(this, "wallet_base_red_dot"));
            this.f26691g.setOnClickListener(this);
            this.m = findViewById(ResUtils.id(this, "ebpay_goods_layout"));
            this.n = (TextView) findViewById(ResUtils.id(this, "ebpay_order_info"));
            this.o = findViewById(ResUtils.id(this, "ebpay_sp_layout"));
            this.p = (TextView) findViewById(ResUtils.id(this, "ebpay_sp_info"));
            this.q = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_discount_layout"));
            this.r = (TextView) findViewById(ResUtils.id(this, "ebpay_discount_desc_type"));
            this.s = (TextView) findViewById(ResUtils.id(this, "ebpay_discount_amount"));
            this.t = (ImageView) findViewById(ResUtils.id(this, "discount_arrow"));
            this.q.setOnClickListener(this);
            this.u = (TextView) findViewById(ResUtils.id(this, "bd_wallet_pay_amount"));
            this.v = (TextView) findViewById(ResUtils.id(this, "ebpay_orderprice"));
            WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_pay_btn"));
            this.y = walletBaseButtonWithImage;
            walletBaseButtonWithImage.setOnClickListener(this);
            this.z = findViewById(ResUtils.id(getActivity(), "pwd_fp_layout"));
            this.A = (TextView) findViewById(ResUtils.id(getActivity(), "fp_layout_tips"));
            this.B = (ImageView) findViewById(ResUtils.id(getActivity(), "fp_logo"));
            this.C = ResUtils.getString(this, "price_format");
            this.D = ResUtils.getString(this, "save_format");
            this.E = new RelativeSizeSpan(0.5f);
            View findViewById = findViewById(ResUtils.id(this, "ic_close"));
            this.F = findViewById;
            findViewById.setOnClickListener(this);
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
            return selectCard != null && 1 == selectCard.is_sign_jump_bank;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, orderConfirmViewData) == null) || orderConfirmViewData == null) {
            return;
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.currentAccount)) {
            this.f26688c.setVisibility(0);
            this.w.setText(orderConfirmViewData.currentAccount);
            this.f26689e.setVisibility(4);
        } else {
            this.f26688c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.title_url)) {
            this.f26690f.setVisibility(0);
            this.f26690f.setImageUrl(orderConfirmViewData.title_url);
        }
        this.f26692h.setTextColor(ResUtils.getColor(this, orderConfirmViewData.hasAvailablePayType ? "ebpay_text_868e9e" : "wallet_base_textcolor_e85352"));
        this.f26692h.setText(!TextUtils.isEmpty(orderConfirmViewData.payTyeDesc) ? orderConfirmViewData.payTyeDesc : "");
        if (!TextUtils.isEmpty(orderConfirmViewData.channelDiscountDesc)) {
            this.f26693i.setVisibility(0);
            this.f26693i.setText(orderConfirmViewData.channelDiscountDesc);
        } else {
            this.f26693i.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.cardTip)) {
            this.l.setVisibility(0);
            this.l.setText(orderConfirmViewData.cardTip);
        } else {
            this.l.setVisibility(8);
        }
        if (!this.k && orderConfirmViewData.isShowRedDot) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.goodsName)) {
            this.n.setText(orderConfirmViewData.goodsName);
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.spName)) {
            this.p.setText(orderConfirmViewData.spName);
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        if (orderConfirmViewData.showDiscount) {
            this.q.setVisibility(0);
            this.q.setClickable(true);
            this.r.setText(orderConfirmViewData.discountDesc);
            this.s.setText(String.format(this.D, StringUtils.fen2Yuan(orderConfirmViewData.discountAmount)));
            this.t.setVisibility(0);
            this.s.setVisibility(0);
        } else if (!TextUtils.isEmpty(orderConfirmViewData.randomDiscountMsg)) {
            this.q.setVisibility(0);
            this.q.setClickable(false);
            this.r.setText(orderConfirmViewData.randomDiscountMsg);
            this.s.setVisibility(8);
            this.t.setVisibility(4);
        } else {
            this.q.setVisibility(8);
        }
        this.v.setText(!TextUtils.isEmpty(orderConfirmViewData.orderPrice) ? String.format(this.C, StringUtils.fen2Yuan(orderConfirmViewData.orderPrice)) : "");
        if (new BigDecimal(orderConfirmViewData.orderPrice).compareTo(new BigDecimal(orderConfirmViewData.needPayAmount)) > 0) {
            this.v.setVisibility(0);
            this.v.getPaint().setFlags(16);
        } else {
            this.v.setVisibility(4);
        }
        String format = TextUtils.isEmpty(orderConfirmViewData.needPayAmount) ? "" : String.format(this.C, StringUtils.fen2Yuan(orderConfirmViewData.needPayAmount));
        if (format.length() > 0) {
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.E, 0, 1, 33);
            this.u.setText(spannableString);
        } else {
            this.u.setText(format);
        }
        this.y.setText(orderConfirmViewData.confirmBtnMsg);
        if (orderConfirmViewData.hasAvailablePayType) {
            this.G = false;
            if (orderConfirmViewData.isFingerprintPay) {
                if (orderConfirmViewData.isOTP) {
                    this.y.setVisibility(8);
                    if (this.z.getVisibility() == 8) {
                        this.z.setVisibility(0);
                        this.A.setText(ResUtils.getString(this, "wallet_fp_pay_tips"));
                        this.B.setImageDrawable(ResUtils.getDrawable(this, "wallet_cashdesk_fp_logo"));
                    }
                }
                StatHelper.cachePayWay(1);
                this.x.setVisibility(0);
                this.x.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ OrderConfirmActivity f26694a;

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
                        this.f26694a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26694a.f26687b.gotoPayUsePwd(false, null);
                        }
                    }
                });
            } else {
                if (PayDataCache.getInstance().isPassFree()) {
                    StatHelper.cachePayWay(2);
                } else {
                    StatHelper.cachePayWay(0);
                }
                this.y.setVisibility(0);
                this.z.setVisibility(8);
                this.x.setVisibility(8);
            }
        } else {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_USE_NEWCARD_TO_PAY);
            this.y.setVisibility(0);
            this.x.setVisibility(8);
            this.G = true;
        }
        this.y.setOnClickListener(new View.OnClickListener(this, orderConfirmViewData) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OrderConfirmContract.Presenter.OrderConfirmViewData f26695a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OrderConfirmActivity f26696b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, orderConfirmViewData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26696b = this;
                this.f26695a = orderConfirmViewData;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                    return;
                }
                OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData2 = this.f26695a;
                if (!orderConfirmViewData2.isFingerprintPay) {
                    if (orderConfirmViewData2.hasAvailablePayType) {
                        StatisticManager.onEvent(StatServiceEvent.ONE_KEY_CLICK_PAY);
                    } else {
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_NEWCARD_TO_PAY);
                    }
                }
                StatisticManager.onEventWithValue(StatServiceEvent.PAY_VER_TYPE, this.f26695a.confirmBtnMsg);
                this.f26696b.gotoNext(null, null);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(OrderConfirmContract.Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, presenter) == null) {
            this.f26687b = presenter;
        }
    }
}
