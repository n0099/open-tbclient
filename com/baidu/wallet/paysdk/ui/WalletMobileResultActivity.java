package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ResultPageStateListener;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.u;
import com.baidu.wallet.paysdk.datamodel.WalletChargeResultBannerResponse;
/* loaded from: classes5.dex */
public class WalletMobileResultActivity extends PayBaseBeanActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26755a = WalletMobileResultActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static ResultPageStateListener f26756b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26757c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26758d;

    /* renamed from: e  reason: collision with root package name */
    public Button f26759e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26760f;

    /* renamed from: g  reason: collision with root package name */
    public NetImageView f26761g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f26762h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f26763i;
    public boolean j;
    public String k;
    public boolean l;
    public WalletChargeResultBannerResponse m;
    public BdActionBar n;

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.f26762h = bundle.getCharSequence("business_result_text");
            this.f26763i = bundle.getCharSequence("business_result_desc");
            this.k = bundle.getString("business_result_order");
            this.j = bundle.getBoolean("business_result_ischarge", false);
            this.l = bundle.getBoolean("business_result_paying", false);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.f26762h = intent.getCharSequenceExtra("business_result_text");
                this.f26763i = intent.getCharSequenceExtra("business_result_desc");
                this.k = intent.getStringExtra("business_result_order");
                this.j = intent.getBooleanExtra("business_result_ischarge", false);
                this.l = intent.getBooleanExtra("business_result_paying", false);
            }
        }
        if (TextUtils.isEmpty(this.f26762h)) {
            this.f26762h = ResUtils.getString(getActivity(), this.l ? "wallet_phone_charge_result_paying" : "wallet_phone_charge_result_desc");
        }
        if (TextUtils.isEmpty(this.f26763i)) {
            if (this.j) {
                this.f26763i = ResUtils.getString(getActivity(), "wallet_phone_charge_payresult_paydesc");
            } else {
                this.f26763i = ResUtils.getString(getActivity(), "wallet_phone_traffic_payresult_paydesc");
            }
        }
    }

    public static void gotoBusniessResultPage(Context context, boolean z, String str, CharSequence charSequence, boolean z2, ResultPageStateListener resultPageStateListener) {
        f26756b = resultPageStateListener;
        Intent intent = new Intent(context, WalletMobileResultActivity.class);
        intent.putExtra("business_result_order", str);
        intent.putExtra("business_result_ischarge", z);
        intent.putExtra("business_result_desc", charSequence);
        intent.putExtra("business_result_paying", z2);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
        } else if (context instanceof BaseActivity) {
            ((BaseActivity) context).startActivityWithoutAnim(intent);
        } else {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
        }
    }

    public static void setBusnessResultListener(ResultPageStateListener resultPageStateListener) {
        f26756b = resultPageStateListener;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 528 && (obj instanceof WalletChargeResultBannerResponse)) {
            WalletChargeResultBannerResponse walletChargeResultBannerResponse = (WalletChargeResultBannerResponse) obj;
            this.m = walletChargeResultBannerResponse;
            WalletChargeResultBannerResponse.AdBanner adBanner = walletChargeResultBannerResponse.banner;
            if (adBanner != null && !TextUtils.isEmpty(adBanner.imgUrl)) {
                this.f26761g.setVisibility(0);
                this.f26761g.setImageUrl(this.m.banner.imgUrl);
                return;
            }
            this.f26761g.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WalletChargeResultBannerResponse.AdBanner adBanner;
        if (view == this.f26759e) {
            ResultPageStateListener resultPageStateListener = f26756b;
            if (resultPageStateListener != null) {
                resultPageStateListener.onConfirm();
            }
            finish();
        }
        if (view == this.f26761g) {
            if (this.j) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_MOBILE_RESULT_BANNER_CLICK, "0");
            } else {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.EVENT_MOBILE_RECHAREGE_QUERY_CLICK, "1");
            }
            WalletChargeResultBannerResponse walletChargeResultBannerResponse = this.m;
            if (walletChargeResultBannerResponse == null || (adBanner = walletChargeResultBannerResponse.banner) == null || TextUtils.isEmpty(adBanner.linkUrl)) {
                return;
            }
            BaiduWalletDelegate.getInstance().openH5Module(getActivity(), this.m.banner.linkUrl, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_base_fp_result_layout"));
        a(bundle);
        initActionBar("wallet_phone_charge_result_title");
        BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        this.n = bdActionBar;
        bdActionBar.hideLeftZone();
        this.f26757c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_text"));
        this.f26758d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_desc"));
        Button button = (Button) findViewById(ResUtils.id(getActivity(), "wallet_business_result_confirm"));
        this.f26759e = button;
        button.setOnClickListener(this);
        this.f26760f = (ImageView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_image"));
        NetImageView netImageView = (NetImageView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_ad_banner"));
        this.f26761g = netImageView;
        netImageView.setOnClickListener(this);
        this.f26757c.setText(this.f26762h);
        this.f26758d.setText(this.f26763i);
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(f26755a);
        f26756b = null;
        super.onDestroy();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putCharSequence("business_result_text", this.f26762h);
        bundle.putCharSequence("business_result_desc", this.f26763i);
        bundle.putString("business_result_order", this.k);
        bundle.putBoolean("business_result_ischarge", this.j);
        bundle.putBoolean("business_result_paying", this.l);
        super.onSaveInstanceState(bundle);
    }

    private void a() {
        u uVar = (u) PayBeanFactory.getInstance().getBean((Context) getActivity(), 528, f26755a);
        uVar.a(this.j);
        uVar.a(this.k);
        uVar.setResponseCallback(this);
        uVar.execBean();
    }
}
