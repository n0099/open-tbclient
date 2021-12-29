package com.baidu.wallet.fastpay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ResultPageStateListener;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.fastpay.beans.FastPayBeanFactory;
import com.baidu.wallet.fastpay.beans.b;
import com.baidu.wallet.fastpay.datamodel.WalletChargeResultBannerResponse;
/* loaded from: classes13.dex */
public class WalletMobileResultActivity extends BeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static ResultPageStateListener f53099b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f53100c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53101d;

    /* renamed from: e  reason: collision with root package name */
    public Button f53102e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f53103f;

    /* renamed from: g  reason: collision with root package name */
    public NetImageView f53104g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f53105h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f53106i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f53107j;

    /* renamed from: k  reason: collision with root package name */
    public String f53108k;
    public boolean l;
    public WalletChargeResultBannerResponse m;
    public BdActionBar n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(33704196, "Lcom/baidu/wallet/fastpay/ui/WalletMobileResultActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(33704196, "Lcom/baidu/wallet/fastpay/ui/WalletMobileResultActivity;");
                return;
            }
        }
        a = WalletMobileResultActivity.class.getSimpleName();
    }

    public WalletMobileResultActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
            if (bundle != null) {
                this.f53105h = bundle.getCharSequence("business_result_text");
                this.f53106i = bundle.getCharSequence("business_result_desc");
                this.f53108k = bundle.getString("business_result_order");
                this.f53107j = bundle.getBoolean("business_result_ischarge", false);
                this.l = bundle.getBoolean("business_result_paying", false);
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    this.f53105h = intent.getCharSequenceExtra("business_result_text");
                    this.f53106i = intent.getCharSequenceExtra("business_result_desc");
                    this.f53108k = intent.getStringExtra("business_result_order");
                    this.f53107j = intent.getBooleanExtra("business_result_ischarge", false);
                    this.l = intent.getBooleanExtra("business_result_paying", false);
                }
            }
            if (TextUtils.isEmpty(this.f53105h)) {
                this.f53105h = ResUtils.getString(getActivity(), this.l ? "wallet_phone_charge_result_paying" : "wallet_phone_charge_result_desc");
            }
            if (TextUtils.isEmpty(this.f53106i)) {
                if (this.f53107j) {
                    this.f53106i = ResUtils.getString(getActivity(), "wallet_phone_charge_payresult_paydesc");
                } else {
                    this.f53106i = ResUtils.getString(getActivity(), "wallet_phone_traffic_payresult_paydesc");
                }
            }
        }
    }

    public static void gotoBusniessResultPage(Context context, boolean z, String str, CharSequence charSequence, boolean z2, ResultPageStateListener resultPageStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Boolean.valueOf(z), str, charSequence, Boolean.valueOf(z2), resultPageStateListener}) == null) {
            f53099b = resultPageStateListener;
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
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    public static void setBusnessResultListener(ResultPageStateListener resultPageStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, resultPageStateListener) == null) {
            f53099b = resultPageStateListener;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) && i2 == 45317 && (obj instanceof WalletChargeResultBannerResponse)) {
            WalletChargeResultBannerResponse walletChargeResultBannerResponse = (WalletChargeResultBannerResponse) obj;
            this.m = walletChargeResultBannerResponse;
            WalletChargeResultBannerResponse.AdBanner adBanner = walletChargeResultBannerResponse.banner;
            if (adBanner != null && !TextUtils.isEmpty(adBanner.imgUrl)) {
                this.f53104g.setVisibility(0);
                this.f53104g.setImageUrl(this.m.banner.imgUrl);
                return;
            }
            this.f53104g.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WalletChargeResultBannerResponse walletChargeResultBannerResponse;
        WalletChargeResultBannerResponse.AdBanner adBanner;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.f53102e) {
                ResultPageStateListener resultPageStateListener = f53099b;
                if (resultPageStateListener != null) {
                    resultPageStateListener.onConfirm();
                }
                finish();
            }
            if (view != this.f53104g || (walletChargeResultBannerResponse = this.m) == null || (adBanner = walletChargeResultBannerResponse.banner) == null || TextUtils.isEmpty(adBanner.linkUrl)) {
                return;
            }
            BaiduWalletDelegate.getInstance().openH5Module(getActivity(), this.m.banner.linkUrl, true);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "wallet_base_fp_result_layout"));
            a(bundle);
            initActionBar("wallet_phone_charge_result_title");
            BdActionBar bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
            this.n = bdActionBar;
            bdActionBar.hideLeftZone();
            this.f53100c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_text"));
            this.f53101d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_desc"));
            Button button = (Button) findViewById(ResUtils.id(getActivity(), "wallet_business_result_confirm"));
            this.f53102e = button;
            button.setOnClickListener(this);
            this.f53103f = (ImageView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_image"));
            NetImageView netImageView = (NetImageView) findViewById(ResUtils.id(getActivity(), "wallet_business_result_ad_banner"));
            this.f53104g = netImageView;
            netImageView.setOnClickListener(this);
            this.f53100c.setText(this.f53105h);
            this.f53101d.setText(this.f53106i);
            a();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BeanManager.getInstance().removeAllBeans(a);
            f53099b = null;
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            bundle.putCharSequence("business_result_text", this.f53105h);
            bundle.putCharSequence("business_result_desc", this.f53106i);
            bundle.putString("business_result_order", this.f53108k);
            bundle.putBoolean("business_result_ischarge", this.f53107j);
            bundle.putBoolean("business_result_paying", this.l);
            super.onSaveInstanceState(bundle);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            b bVar = (b) FastPayBeanFactory.getInstance().getBean((Context) getActivity(), FastPayBeanFactory.BEAN_ID_CHARGE_RESULT_BANNER, a);
            bVar.a(this.f53107j);
            bVar.a(this.f53108k);
            bVar.setResponseCallback(this);
            bVar.execBean();
        }
    }
}
