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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.datamodel.GetJumpUrlResponse;
import com.baidu.wallet.paysdk.contract.OrderConfirmContract;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.OrderConfirmPresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.utils.AnimUtils;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.math.BigDecimal;
/* loaded from: classes8.dex */
public class OrderConfirmActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public String B;
    public String C;
    public RelativeSizeSpan D;
    public View E;
    public boolean F;
    public String G;
    public String H;

    /* renamed from: a  reason: collision with root package name */
    public final String f62970a;

    /* renamed from: b  reason: collision with root package name */
    public OrderConfirmContract.Presenter f62971b;

    /* renamed from: c  reason: collision with root package name */
    public View f62972c;

    /* renamed from: d  reason: collision with root package name */
    public View f62973d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f62974e;

    /* renamed from: f  reason: collision with root package name */
    public View f62975f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62976g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62977h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f62978i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f62979j;
    public TextView k;
    public View l;
    public TextView m;
    public View n;
    public TextView o;
    public View p;
    public TextView q;
    public TextView r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public WalletBaseButtonWithImage x;
    public View y;
    public TextView z;

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
        this.f62970a = OrderConfirmActivity.class.getSimpleName();
        this.f62979j = false;
        this.F = false;
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
                this.G = str;
                this.H = str2;
                WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
                BankSignFactory bankSignFactory = BankSignFactory.getInstance();
                BeanActivity beanActivity = this.mAct;
                com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) bankSignFactory.getBean((Context) beanActivity, 768, this.f62970a + toString());
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) && i2 == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            pay(this.G, this.H, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
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
                com.baidu.wallet.paysdk.banksign.a.a.a().c(this.G);
                com.baidu.wallet.paysdk.banksign.a.a.a().b(this.H);
                com.baidu.wallet.paysdk.banksign.a.a.a().a(this);
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.ShowGuide);
                a2.a(this.mAct);
                return;
            }
            pay(this.G, this.H, true);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62971b.closeOrderComfirmPage();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view == this.f62975f) {
                StatHelper.statServiceEvent(StatServiceEvent.EVENT_CLICK_PAY_TYPE_ITEM);
                ImageView imageView = this.f62978i;
                if (imageView != null && imageView.getVisibility() == 0) {
                    this.f62979j = true;
                }
                this.f62971b.clickPayway();
            } else if (view == this.p) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_COUPON_ITEM);
                this.f62971b.clickCoupon();
            } else if (view == this.E) {
                this.f62971b.closeOrderComfirmPage();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            b();
            OrderConfirmPresenter orderConfirmPresenter = new OrderConfirmPresenter(this);
            this.f62971b = orderConfirmPresenter;
            orderConfirmPresenter.onCreate(bundle);
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            OrderConfirmContract.Presenter presenter = this.f62971b;
            if (presenter != null) {
                presenter.onDestroy();
                this.f62971b = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 23) {
                WalletFingerprint.getInstance(this).cancleListening();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            OrderConfirmContract.Presenter presenter = this.f62971b;
            if (presenter != null) {
                presenter.startFingerprintListening();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.f62971b.onSaveInstanceState(bundle);
        }
    }

    public void pay(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, str, str2, z) == null) {
            Intent intent = new Intent(this, PwdPayActivity.class);
            intent.putExtra("otpToken", str);
            intent.putExtra("warningTips", str2);
            intent.putExtra("gatewaySign", z);
            if (this.F) {
                intent.putExtra("IS_FOR_BIND_CARD_PAY", true);
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER);
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
            }
            startActivity(intent);
        }
    }

    public void showFpCheckError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.z.setText(ResUtils.getString(getActivity(), "wallet_cashdesk_onceagain"));
            this.z.setTextColor(ResUtils.getColor(this.mAct, "dxm_wallet_fp_record_tip_color_error"));
            this.A.setImageDrawable(ResUtils.getDrawable(this, "wallet_fingerprint_little_icon_red"));
            AnimUtils.startSharkAnim(this.y);
        }
    }

    public void showFpCheckSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.z.setText("指纹验证成功");
            this.z.setTextColor(ResUtils.getColor(this.mAct, "wallet_fp_record_tip_coloe_397BE6"));
            this.A.setImageDrawable(ResUtils.getDrawable(this, "dxm_wallet_cashdesk_fp_succ"));
            this.z.postDelayed(new Runnable(this, str) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62983a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ OrderConfirmActivity f62984b;

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
                    this.f62984b = this;
                    this.f62983a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62984b.gotoNext(this.f62983a, null);
                        this.f62984b.z.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f62985a;

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
                                this.f62985a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f62985a.f62984b.z.setText(ResUtils.getString(this.f62985a.f62984b, "wallet_fp_pay_tips"));
                                    this.f62985a.f62984b.A.setImageDrawable(ResUtils.getDrawable(this.f62985a.f62984b, "wallet_cashdesk_fp_logo"));
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
            this.f62971b.getViewData();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mActionBar.setVisibility(8);
            this.f62974e = (NetImageView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_logo"));
            this.f62974e.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
            TextView textView = (TextView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_paymethod_entry"));
            this.w = textView;
            textView.setVisibility(8);
            this.f62972c = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_account_layout"));
            this.f62973d = this.mContentView.findViewById(ResUtils.id(getActivity(), "bd_wallet_account_arrow_icon"));
            this.v = (TextView) findViewById(ResUtils.id(this, "ebpay_account"));
            this.f62975f = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_payway_layout"));
            this.f62976g = (TextView) findViewById(ResUtils.id(this, "paytype_desc"));
            this.f62977h = (TextView) findViewById(ResUtils.id(this, "payway_discount"));
            this.k = (TextView) findViewById(ResUtils.id(this, "payway_txt_for_complete_bankcard"));
            this.f62978i = (ImageView) findViewById(ResUtils.id(this, "wallet_base_red_dot"));
            this.f62975f.setOnClickListener(this);
            this.l = findViewById(ResUtils.id(this, "ebpay_goods_layout"));
            this.m = (TextView) findViewById(ResUtils.id(this, "ebpay_order_info"));
            this.n = findViewById(ResUtils.id(this, "ebpay_sp_layout"));
            this.o = (TextView) findViewById(ResUtils.id(this, "ebpay_sp_info"));
            this.p = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_discount_layout"));
            this.q = (TextView) findViewById(ResUtils.id(this, "ebpay_discount_desc_type"));
            this.r = (TextView) findViewById(ResUtils.id(this, "ebpay_discount_amount"));
            this.s = (ImageView) findViewById(ResUtils.id(this, "discount_arrow"));
            this.p.setOnClickListener(this);
            this.t = (TextView) findViewById(ResUtils.id(this, "bd_wallet_pay_amount"));
            this.u = (TextView) findViewById(ResUtils.id(this, "ebpay_orderprice"));
            WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_pay_btn"));
            this.x = walletBaseButtonWithImage;
            walletBaseButtonWithImage.setOnClickListener(this);
            this.y = findViewById(ResUtils.id(getActivity(), "pwd_fp_layout"));
            this.z = (TextView) findViewById(ResUtils.id(getActivity(), "fp_layout_tips"));
            this.A = (ImageView) findViewById(ResUtils.id(getActivity(), "fp_logo"));
            this.B = ResUtils.getString(this, "dxm_price_format");
            this.C = ResUtils.getString(this, "dxm_save_format");
            this.D = new RelativeSizeSpan(0.5f);
            View findViewById = findViewById(ResUtils.id(this, "ic_close"));
            this.E = findViewById;
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
            this.f62972c.setVisibility(0);
            this.v.setText(orderConfirmViewData.currentAccount);
            this.f62973d.setVisibility(4);
        } else {
            this.f62972c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.title_url)) {
            this.f62974e.setVisibility(0);
            this.f62974e.setImageUrl(orderConfirmViewData.title_url);
        }
        this.f62976g.setTextColor(ResUtils.getColor(this, orderConfirmViewData.hasAvailablePayType ? "ebpay_text_868e9e" : "dxm_wallet_base_textcolor_e85352"));
        this.f62976g.setText(!TextUtils.isEmpty(orderConfirmViewData.payTyeDesc) ? orderConfirmViewData.payTyeDesc : "");
        if (!TextUtils.isEmpty(orderConfirmViewData.channelDiscountDesc)) {
            this.f62977h.setVisibility(0);
            this.f62977h.setText(orderConfirmViewData.channelDiscountDesc);
        } else {
            this.f62977h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.cardTip)) {
            this.k.setVisibility(0);
            this.k.setText(orderConfirmViewData.cardTip);
        } else {
            this.k.setVisibility(8);
        }
        if (!this.f62979j && orderConfirmViewData.isShowRedDot) {
            this.f62978i.setVisibility(0);
        } else {
            this.f62978i.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.goodsName)) {
            this.m.setText(orderConfirmViewData.goodsName);
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.spName)) {
            this.o.setText(orderConfirmViewData.spName);
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        if (orderConfirmViewData.showDiscount) {
            this.p.setVisibility(0);
            this.p.setClickable(true);
            this.q.setText(orderConfirmViewData.discountDesc);
            this.r.setText(String.format(this.C, StringUtils.fen2Yuan(orderConfirmViewData.discountAmount)));
            this.s.setVisibility(0);
            this.r.setVisibility(0);
        } else if (!TextUtils.isEmpty(orderConfirmViewData.randomDiscountMsg)) {
            this.p.setVisibility(0);
            this.p.setClickable(false);
            this.q.setText(orderConfirmViewData.randomDiscountMsg);
            this.r.setVisibility(8);
            this.s.setVisibility(4);
        } else {
            this.p.setVisibility(8);
        }
        this.u.setText(!TextUtils.isEmpty(orderConfirmViewData.orderPrice) ? String.format(this.B, StringUtils.fen2Yuan(orderConfirmViewData.orderPrice)) : "");
        if (new BigDecimal(orderConfirmViewData.orderPrice).compareTo(new BigDecimal(orderConfirmViewData.needPayAmount)) > 0) {
            this.u.setVisibility(0);
            this.u.getPaint().setFlags(16);
        } else {
            this.u.setVisibility(4);
        }
        String format = TextUtils.isEmpty(orderConfirmViewData.needPayAmount) ? "" : String.format(this.B, StringUtils.fen2Yuan(orderConfirmViewData.needPayAmount));
        if (format.length() > 0) {
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(this.D, 0, 1, 33);
            this.t.setText(spannableString);
        } else {
            this.t.setText(format);
        }
        this.x.setText(orderConfirmViewData.confirmBtnMsg);
        if (orderConfirmViewData.hasAvailablePayType) {
            this.F = false;
            if (orderConfirmViewData.isFingerprintPay) {
                if (orderConfirmViewData.isOTP) {
                    this.x.setVisibility(8);
                    if (this.y.getVisibility() == 8) {
                        this.y.setVisibility(0);
                        this.z.setText(ResUtils.getString(this, "wallet_fp_pay_tips"));
                        this.A.setImageDrawable(ResUtils.getDrawable(this, "wallet_cashdesk_fp_logo"));
                    }
                }
                StatHelper.cachePayWay(1);
                this.w.setVisibility(0);
                this.w.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ OrderConfirmActivity f62980a;

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
                        this.f62980a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f62980a.f62971b.gotoPayUsePwd(false, null);
                        }
                    }
                });
            } else {
                if (PayDataCache.getInstance().isPassFree()) {
                    StatHelper.cachePayWay(2);
                } else {
                    StatHelper.cachePayWay(0);
                }
                this.x.setVisibility(0);
                this.y.setVisibility(8);
                this.w.setVisibility(8);
            }
        } else {
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_USE_NEWCARD_TO_PAY);
            this.x.setVisibility(0);
            this.w.setVisibility(8);
            this.F = true;
        }
        this.x.setOnClickListener(new View.OnClickListener(this, orderConfirmViewData) { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OrderConfirmContract.Presenter.OrderConfirmViewData f62981a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OrderConfirmActivity f62982b;

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
                this.f62982b = this;
                this.f62981a = orderConfirmViewData;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                    return;
                }
                OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData2 = this.f62981a;
                if (!orderConfirmViewData2.isFingerprintPay) {
                    if (orderConfirmViewData2.hasAvailablePayType) {
                        StatisticManager.onEvent("onekeyClickpay");
                    } else {
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_NEWCARD_TO_PAY);
                    }
                }
                StatHelper.statServiceEvent("payVerType", null, this.f62981a.confirmBtnMsg);
                this.f62982b.gotoNext(null, null);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(OrderConfirmContract.Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, presenter) == null) {
            this.f62971b = presenter;
        }
    }
}
