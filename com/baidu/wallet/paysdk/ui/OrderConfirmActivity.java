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
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.ResUtils;
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
    public TextView A;
    public ImageView B;
    public String C;
    public String D;
    public RelativeSizeSpan E;
    public View F;
    public String H;
    public String I;

    /* renamed from: b  reason: collision with root package name */
    public OrderConfirmContract.Presenter f25736b;

    /* renamed from: c  reason: collision with root package name */
    public View f25737c;

    /* renamed from: e  reason: collision with root package name */
    public View f25738e;

    /* renamed from: f  reason: collision with root package name */
    public NetImageView f25739f;

    /* renamed from: g  reason: collision with root package name */
    public View f25740g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25741h;
    public TextView i;
    public ImageView j;
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

    /* renamed from: a  reason: collision with root package name */
    public final String f25735a = OrderConfirmActivity.class.getSimpleName();
    public boolean k = false;
    public boolean G = false;

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_order_confirm_layout"), null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void dismissLoading(int i) {
    }

    public void gotoCoupon() {
        startActivity(new Intent(getActivity(), CouponListActivity.class));
    }

    public void gotoNext(String str, String str2) {
        if (c()) {
            this.H = str;
            this.I = str2;
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            BankSignFactory bankSignFactory = BankSignFactory.getInstance();
            BeanActivity beanActivity = this.mAct;
            com.baidu.wallet.paysdk.banksign.beans.b bVar = (com.baidu.wallet.paysdk.banksign.beans.b) bankSignFactory.getBean((Context) beanActivity, 768, this.f25735a + toString());
            CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
            bVar.a(selectCard != null ? selectCard.account_no : "");
            bVar.setResponseCallback(this);
            bVar.execBean();
            return;
        }
        pay(str, str2, false);
    }

    public void gotoPayType() {
        startActivity(new Intent(getActivity(), PayTypeActivity.class));
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        if (i == 768) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            pay(this.H, this.I, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        if (i == 768) {
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

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        this.f25736b.closeOrderComfirmPage();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f25740g) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_PAY_TYPE_ITEM);
            ImageView imageView = this.j;
            if (imageView != null && imageView.getVisibility() == 0) {
                this.k = true;
            }
            this.f25736b.clickPayway();
        } else if (view == this.q) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_COUPON_ITEM);
            this.f25736b.clickCoupon();
        } else if (view == this.F) {
            this.f25736b.closeOrderComfirmPage();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        OrderConfirmPresenter orderConfirmPresenter = new OrderConfirmPresenter(this);
        this.f25736b = orderConfirmPresenter;
        orderConfirmPresenter.onCreate(bundle);
        LogUtil.d(this.f25735a, "OrderConfirmActivity.onCreate");
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OrderConfirmContract.Presenter presenter = this.f25736b;
        if (presenter != null) {
            presenter.onDestroy();
            this.f25736b = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LogUtil.d(this.f25735a, "OrderConfirmActivity.onPause");
        if (Build.VERSION.SDK_INT >= 23) {
            WalletFingerprint.getInstance(this).cancleListening();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        OrderConfirmContract.Presenter presenter = this.f25736b;
        if (presenter != null) {
            presenter.startFingerprintListening();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f25736b.onSaveInstanceState(bundle);
    }

    public void pay(String str, String str2, boolean z) {
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

    public void showFpCheckError() {
        this.A.setText(ResUtils.getString(getActivity(), "wallet_cashdesk_onceagain"));
        this.A.setTextColor(ResUtils.getColor(this.mAct, "wallet_fp_record_tip_color_error"));
        this.B.setImageDrawable(ResUtils.getDrawable(this, "wallet_fingerprint_little_icon_red"));
        AnimUtils.startSharkAnim(this.z);
    }

    public void showFpCheckSuccess(final String str) {
        this.A.setText("指纹验证成功");
        this.A.setTextColor(ResUtils.getColor(this.mAct, "wallet_fp_record_tip_coloe_397BE6"));
        this.B.setImageDrawable(ResUtils.getDrawable(this, "wallet_cashdesk_fp_succ"));
        this.A.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.3
            @Override // java.lang.Runnable
            public void run() {
                OrderConfirmActivity.this.gotoNext(str, null);
                OrderConfirmActivity.this.A.postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OrderConfirmActivity.this.A.setText(ResUtils.getString(OrderConfirmActivity.this, "wallet_fp_pay_tips"));
                        OrderConfirmActivity.this.B.setImageDrawable(ResUtils.getDrawable(OrderConfirmActivity.this, "wallet_cashdesk_fp_logo"));
                    }
                }, 300L);
            }
        }, 300L);
    }

    public void showLoading(int i) {
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i) {
    }

    private void a() {
        this.f25736b.getViewData();
    }

    private void b() {
        this.mActionBar.setVisibility(8);
        this.f25739f = (NetImageView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_logo"));
        this.f25739f.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
        TextView textView = (TextView) this.mContentView.findViewById(ResUtils.id(getActivity(), "cashdesk_paymethod_entry"));
        this.x = textView;
        textView.setVisibility(8);
        this.f25737c = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_account_layout"));
        this.f25738e = this.mContentView.findViewById(ResUtils.id(getActivity(), "bd_wallet_account_arrow_icon"));
        this.w = (TextView) findViewById(ResUtils.id(this, "ebpay_account"));
        this.f25740g = this.mContentView.findViewById(ResUtils.id(getActivity(), "ebpay_payway_layout"));
        this.f25741h = (TextView) findViewById(ResUtils.id(this, "paytype_desc"));
        this.i = (TextView) findViewById(ResUtils.id(this, "payway_discount"));
        this.l = (TextView) findViewById(ResUtils.id(this, "payway_txt_for_complete_bankcard"));
        this.j = (ImageView) findViewById(ResUtils.id(this, "wallet_base_red_dot"));
        this.f25740g.setOnClickListener(this);
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

    private boolean c() {
        CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
        return selectCard != null && 1 == selectCard.is_sign_jump_bank;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(final OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData) {
        if (orderConfirmViewData == null) {
            return;
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.currentAccount)) {
            this.f25737c.setVisibility(0);
            this.w.setText(orderConfirmViewData.currentAccount);
            this.f25738e.setVisibility(4);
        } else {
            this.f25737c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(orderConfirmViewData.title_url)) {
            this.f25739f.setVisibility(0);
            this.f25739f.setImageUrl(orderConfirmViewData.title_url);
        }
        this.f25741h.setTextColor(ResUtils.getColor(this, orderConfirmViewData.hasAvailablePayType ? "ebpay_text_868e9e" : "wallet_base_textcolor_e85352"));
        this.f25741h.setText(!TextUtils.isEmpty(orderConfirmViewData.payTyeDesc) ? orderConfirmViewData.payTyeDesc : "");
        if (!TextUtils.isEmpty(orderConfirmViewData.channelDiscountDesc)) {
            this.i.setVisibility(0);
            this.i.setText(orderConfirmViewData.channelDiscountDesc);
        } else {
            this.i.setVisibility(8);
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
                this.x.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OrderConfirmActivity.this.f25736b.gotoPayUsePwd(false, null);
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
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.OrderConfirmActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                OrderConfirmContract.Presenter.OrderConfirmViewData orderConfirmViewData2 = orderConfirmViewData;
                if (!orderConfirmViewData2.isFingerprintPay) {
                    if (orderConfirmViewData2.hasAvailablePayType) {
                        StatisticManager.onEvent(StatServiceEvent.ONE_KEY_CLICK_PAY);
                    } else {
                        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_NEWCARD_TO_PAY);
                    }
                }
                StatisticManager.onEventWithValue(StatServiceEvent.PAY_VER_TYPE, orderConfirmViewData.confirmBtnMsg);
                OrderConfirmActivity.this.gotoNext(null, null);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(OrderConfirmContract.Presenter presenter) {
        this.f25736b = presenter;
    }
}
