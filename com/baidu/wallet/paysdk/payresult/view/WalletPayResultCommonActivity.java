package com.baidu.wallet.paysdk.payresult.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.Compliance;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.presenter.a;
import com.baidu.wallet.paysdk.payresult.presenter.b;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import com.baidu.wallet.paysdk.ui.widget.ImageViewDialog;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.ImmersiveStatusBarManager;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class WalletPayResultCommonActivity extends PayBaseBeanActivity implements View.OnClickListener, b.InterfaceC1855b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_FEEDBACK = 74081;

    /* renamed from: b  reason: collision with root package name */
    public static final String f62899b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a f62900a;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f62901c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62902d;

    /* renamed from: e  reason: collision with root package name */
    public View f62903e;

    /* renamed from: f  reason: collision with root package name */
    public View f62904f;

    /* renamed from: g  reason: collision with root package name */
    public View f62905g;

    /* renamed from: h  reason: collision with root package name */
    public int f62906h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62907i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f62908j;
    public TextView mMainTip;
    public View mPayResultOrderAmountLayout;
    public TextView mPayResultOrderAmountText;
    public TextView mPayResultOrderPrefix;
    public TextView mPayResultPayType;
    public View mPayResultPayTypeGroup;
    public TextView mPayResultPayTypePrefix;
    public View mPayResultRealMoneyLayout;
    public TextView mPayResultRealMoneyText;
    public TextView mPayResultTotalDiscount;
    public View mPayResultTotalDiscountGroup;
    public TextView mPayResultTotalDiscountTip;
    public Button mPaySuccess;
    public ImageView mResultImg;
    public TextView mSubtitleView;
    public LinearLayout mpayResultDiscountType;
    public View mpayResultDiscountTypeGroup;
    public TextView mpayResultDiscountTypeTip;
    public String strRmbUnit;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(99393312, "Lcom/baidu/wallet/paysdk/payresult/view/WalletPayResultCommonActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(99393312, "Lcom/baidu/wallet/paysdk/payresult/view/WalletPayResultCommonActivity;");
                return;
            }
        }
        f62899b = WalletPayResultCommonActivity.class.getSimpleName();
    }

    public WalletPayResultCommonActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.strRmbUnit = "";
        this.f62906h = 0;
        this.f62907i = true;
        this.f62908j = true;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            a(findViewById(ResUtils.id(this, "root_layout")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || isFinishing()) {
            return;
        }
        this.f62900a.h();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62905g.getLayoutParams();
            if (this.f62907i) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mResultImg.getLayoutParams();
                layoutParams2.setMargins(0, DisplayUtils.dip2px(this, 100.0f), 0, 0);
                this.mResultImg.setLayoutParams(layoutParams2);
                findViewById(ResUtils.id(this, "pay_result_content_info_head_graw")).setVisibility(8);
                findViewById(ResUtils.id(this, "pay_result_content_info_foot_wave")).setVisibility(8);
                findViewById(ResUtils.id(this, "pay_result_content_info_white")).setBackgroundColor(ResUtils.getColor(this, "ebpay_f7f8fa"));
                layoutParams.height = DisplayUtils.dip2px(this, 230.0f);
                this.f62905g.setLayoutParams(layoutParams);
                return;
            }
            if (this.f62908j) {
                this.f62904f.setVisibility(8);
                this.f62906h++;
            }
            int i2 = this.f62902d.getVisibility() == 0 ? 16 : 0;
            int dip2px = DisplayUtils.dip2px(this, 320 - (this.f62906h * 35));
            int displayHeight = (DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(this, 258.0f)) - i2;
            if (dip2px <= displayHeight) {
                dip2px = displayHeight;
            }
            layoutParams.height = dip2px;
            this.f62905g.setLayoutParams(layoutParams);
        }
    }

    public boolean changePayResultMainInfo(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void finishPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            finish();
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void initActionBar(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(this, "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(ResUtils.string(this, str));
        bdActionBar.hideLeftZone();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void initViewElements() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mResultImg = (ImageView) findViewById(ResUtils.id(this, "payresult_maininfo_icon"));
            this.mMainTip = (TextView) findViewById(ResUtils.id(this, "payresult_maininfo_main_tip"));
            Button button = (Button) findViewById(ResUtils.id(this, "pay_success_bt"));
            this.mPaySuccess = button;
            button.setOnClickListener(this);
            this.mPaySuccess.setVisibility(0);
            this.f62905g = findViewById(ResUtils.id(this, "pay_result_content_info"));
            this.mPayResultPayTypeGroup = findViewById(ResUtils.id(this, "payresult_pay_type_group"));
            this.mPayResultPayType = (TextView) findViewById(ResUtils.id(this, "payresult_pay_type_info"));
            this.mPayResultPayTypePrefix = (TextView) findViewById(ResUtils.id(this, "payresult_pay_type_pfefix"));
            this.mPayResultOrderAmountLayout = findViewById(ResUtils.id(this, "payresult_order_amount_group"));
            this.mPayResultOrderPrefix = (TextView) findViewById(ResUtils.id(this, "payresult_order_amount_prefix"));
            this.mPayResultOrderAmountText = (TextView) findViewById(ResUtils.id(this, "payresult_order_amount"));
            this.mPayResultTotalDiscountGroup = findViewById(ResUtils.id(this, "payresult_discount_amount_group"));
            this.mPayResultTotalDiscount = (TextView) findViewById(ResUtils.id(this, "payresult_discount_amount"));
            this.mPayResultTotalDiscountTip = (TextView) findViewById(ResUtils.id(this, "payresult_discount_amount_tip"));
            this.mpayResultDiscountTypeGroup = findViewById(ResUtils.id(this, "payresult_discount_info_group"));
            this.mpayResultDiscountType = (LinearLayout) findViewById(ResUtils.id(this, "payresult_discount_info"));
            this.mpayResultDiscountTypeTip = (TextView) findViewById(ResUtils.id(this, "payresult_discount_info_tip"));
            this.mPayResultRealMoneyLayout = findViewById(ResUtils.id(this, "payresult_pay_info_group"));
            this.mPayResultRealMoneyText = (TextView) findViewById(ResUtils.id(this, "payresult_pay_info"));
            this.f62901c = (NetImageView) findViewById(ResUtils.id(this, "payresult_title"));
            this.f62901c.setImageResource(ResUtils.drawable(getApplicationContext(), "wallet_cashdesk_logo"));
            this.mSubtitleView = (TextView) findViewById(ResUtils.id(this, "payresult_maininfo_sub_tip"));
            this.f62902d = (TextView) findViewById(ResUtils.id(this, "authorize_text"));
            this.f62903e = findViewById(ResUtils.id(this, "statusbar_top"));
            this.f62904f = findViewById(ResUtils.id(this, "divider_line"));
            setTop();
        }
    }

    public boolean isPayResultMoneyLayoutVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isPayResultRealMoneyTextVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPayResultRealMoneyLayout.getVisibility() == 0 : invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.mPaySuccess) {
            StatisticManager.onEventWithValues("resultClickBtn", this.f62900a.f());
            if (this.f62900a.j()) {
                FeedbackDialog feedbackDialog = new FeedbackDialog(getActivity());
                feedbackDialog.initDialog(this.f62900a.k());
                feedbackDialog.show();
                return;
            }
            finishWithoutAnim();
            this.f62900a.g();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(this, "wallet_cashdesk_pay_result_common_activity"));
            this.strRmbUnit = ResUtils.getString(this, "dxm_wallet_base_unit");
            a aVar = new a(this, this, bundle);
            this.f62900a = aVar;
            if (!aVar.a()) {
                PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.onCreate().1");
                finish();
                return;
            }
            if (this.f62900a.b()) {
                setFlagPaySdk();
            }
            if (!this.f62900a.a(bundle)) {
                PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.onCreate().2");
                finish();
            } else if (this.f62900a.c(bundle)) {
                d();
                b();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            b.a aVar = this.f62900a;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, event) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.f62900a.b(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void setOKBtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mPaySuccess.setText(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void setTitleLogo(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f62901c.setImageUrl(str);
    }

    public void setTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        this.f62903e.setLayoutParams(new LinearLayout.LayoutParams(-1, StatusBarUtils.getStatusBarHeight(getActivity())));
        ImmersiveStatusBarManager.setTopBar(getActivity(), this.f62903e, isStatusbarTextColorBlack());
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public boolean showAuthDialog(Compliance compliance) {
        InterceptResult invokeL;
        Compliance.AntiMoneyLaundering antiMoneyLaundering;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, compliance)) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null && TextUtils.equals(payRequest.getPayFrom(), BaiduPay.PAY_FROM_AUTHORIZE)) {
                LogUtil.e(WalletPayResultCommonActivity.class.getSimpleName(), payRequest.getPayFrom(), null);
                return false;
            } else if (compliance == null || (antiMoneyLaundering = compliance.anti_money_laundering) == null || antiMoneyLaundering.after_pay_identity != 1 || TextUtils.isEmpty(antiMoneyLaundering.auth_msg) || TextUtils.isEmpty(compliance.anti_money_laundering.sdk_auth_url)) {
                return false;
            } else {
                Compliance.AntiMoneyLaundering antiMoneyLaundering2 = compliance.anti_money_laundering;
                a(antiMoneyLaundering2.auth_msg, antiMoneyLaundering2.sdk_auth_url);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showAuthorizeMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(this.mSubtitleView.getText())) {
                    this.mSubtitleView.setVisibility(8);
                }
                this.f62902d.setVisibility(0);
                this.f62902d.setText(str);
                return;
            }
            this.f62902d.setVisibility(8);
        }
    }

    public void showDiscountAmountInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, str, str2, str3) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showDiscountTypeInfo(String[][] strArr, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, strArr, str, str2) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 5;
            layoutParams.gravity = 5;
            layoutParams.setMargins(0, DisplayUtils.dip2px(this, 15.0f), 0, 0);
            if (strArr != null) {
                this.f62907i = false;
                this.f62908j = false;
                this.mpayResultDiscountTypeGroup.setVisibility(0);
                int i2 = 0;
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    if (strArr[i3].length > 1) {
                        if (TextUtils.equals(strArr[i3][0], "msg")) {
                            this.mpayResultDiscountTypeTip.setText(strArr[i3][1]);
                        } else {
                            i2++;
                            if (i3 == 0) {
                                a(strArr[i3][0], strArr[i3][1], layoutParams2);
                            } else {
                                this.f62906h--;
                                a(strArr[i3][0], strArr[i3][1], layoutParams);
                            }
                        }
                    }
                }
                if (i2 >= 2) {
                    this.mPayResultTotalDiscountGroup.setVisibility(0);
                    this.mPayResultTotalDiscountTip.setText(str2);
                    this.mPayResultTotalDiscount.setText(new SpannableString("-" + this.strRmbUnit + str));
                    return;
                }
                this.f62906h++;
                this.mPayResultTotalDiscountGroup.setVisibility(8);
                return;
            }
            this.mPayResultTotalDiscountGroup.setVisibility(8);
            this.mpayResultDiscountTypeGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showExpectedTime(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mSubtitleView.setText(str);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showMarketDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) {
            ImageViewDialog imageViewDialog = new ImageViewDialog(getActivity());
            imageViewDialog.initDialog(str, new ImageViewDialog.a(this, str2, (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY), imageViewDialog) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62913a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayRequest f62914b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ImageViewDialog f62915c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ WalletPayResultCommonActivity f62916d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, r8, imageViewDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62916d = this;
                    this.f62913a = str2;
                    this.f62914b = r8;
                    this.f62915c = imageViewDialog;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (CheckUtils.isFastDoubleClick()) {
                            String unused = WalletPayResultCommonActivity.f62899b;
                            return;
                        }
                        BaiduWalletDelegate.getInstance().openH5Module(this.f62916d.getActivity(), this.f62913a);
                        PayRequest payRequest = this.f62914b;
                        if (payRequest != null) {
                            StatisticManager.onEventWithValues("payResultCrossMarketImageClick", Arrays.asList(payRequest.mSpNO, this.f62913a));
                        }
                        this.f62915c.dismiss();
                    }
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.a
                public void b() {
                    PayRequest payRequest;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (payRequest = this.f62914b) == null) {
                        return;
                    }
                    StatisticManager.onEventWithValues("payResultCrossMarketCloseClick", Arrays.asList(payRequest.mSpNO, this.f62913a));
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.ImageViewDialog.a
                public void c() {
                    PayRequest payRequest;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (payRequest = this.f62914b) == null) {
                        return;
                    }
                    StatisticManager.onEventWithValues("payResultCrossMarketBackClick", Arrays.asList(payRequest.mSpNO, this.f62913a));
                }
            });
            imageViewDialog.show();
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showPayResultMoneyLayoutVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showPayResultRealMoneyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f62904f.setVisibility(0);
                this.mPayResultRealMoneyLayout.setVisibility(0);
                RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.75f);
                SpannableString spannableString = new SpannableString(this.strRmbUnit + str);
                spannableString.setSpan(relativeSizeSpan, 0, 1, 33);
                this.mPayResultRealMoneyText.setText(spannableString);
                this.f62907i = false;
                return;
            }
            this.f62904f.setVisibility(8);
            this.mPayResultRealMoneyLayout.setVisibility(8);
            this.f62906h += 2;
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showPaySuccess(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, hashMap) == null) {
            if (hashMap != null && hashMap.size() > 0) {
                this.mMainTip.setText(ResUtils.getString(this, hashMap.get("mainTip")));
                this.mResultImg.setImageDrawable(ResUtils.getDrawable(this, hashMap.get("statusDrawableName")));
                this.mPaySuccess.setText(ResUtils.getString(this, hashMap.get("okBtnText")));
                if (TextUtils.isEmpty(hashMap.get("update_phone_desc"))) {
                    return;
                }
                this.mSubtitleView.setText(hashMap.get("update_phone_desc"));
                return;
            }
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.showPaySuccess().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showPayTypeInfo(String[][] strArr, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, strArr, str, str2, str3) == null) {
            if (strArr != null && strArr.length > 0) {
                this.f62907i = false;
                this.f62908j = false;
                this.mPayResultPayTypeGroup.setVisibility(0);
                if (strArr[0].length > 1) {
                    this.mPayResultPayTypePrefix.setText(strArr[0][0]);
                    this.mPayResultPayType.setText(strArr[0][1]);
                    return;
                }
                return;
            }
            this.f62906h++;
            this.mPayResultPayTypeGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showPaying(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, hashMap) == null) {
            if (hashMap != null && hashMap.size() > 0) {
                this.mResultImg.setImageDrawable(ResUtils.getDrawable(this, hashMap.get("statusDrawableName")));
                this.mMainTip.setText(ResUtils.getString(this, hashMap.get("mainTip")));
                if (TextUtils.isEmpty(hashMap.get("update_phone_desc"))) {
                    return;
                }
                this.mSubtitleView.setText(hashMap.get("update_phone_desc"));
                return;
            }
            PayCallBackManager.callBackClientCancel(this, "WalletPayResultCommonActivity.showPaying().1");
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.InterfaceC1855b
    public void showTotalAmountInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, str, str2, str3) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f62907i = false;
                this.f62908j = false;
                this.mPayResultOrderAmountLayout.setVisibility(0);
                this.mPayResultOrderAmountText.setText(this.strRmbUnit + str);
                if (!TextUtils.isEmpty(str2)) {
                    this.mPayResultOrderPrefix.setText(str2);
                }
                if (Float.valueOf(str3).floatValue() < Float.valueOf(str).floatValue()) {
                    this.mPayResultOrderAmountText.getPaint().setFlags(16);
                    return;
                } else {
                    this.mPayResultOrderAmountText.getPaint().setFlags(1);
                    return;
                }
            }
            this.mPayResultOrderAmountLayout.setVisibility(8);
            this.f62906h++;
        }
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, view) == null) {
            view.post(new Runnable(this, view) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f62909a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ WalletPayResultCommonActivity f62910b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62910b = this;
                    this.f62909a = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int bottom = this.f62909a.getBottom();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                        ofFloat.setDuration(500L);
                        ofFloat.setInterpolator(new DecelerateInterpolator());
                        ofFloat.start();
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, bottom) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f62911a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f62912b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(bottom)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62912b = this;
                                this.f62911a = bottom;
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    ViewHelper.setTranslationY(this.f62912b.f62909a, (-this.f62911a) * floatValue);
                                    if (floatValue <= 0.0f) {
                                        this.f62912b.f62910b.c();
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void a(String str, String str2, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2, layoutParams) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        View inflate = getLayoutInflater().inflate(ResUtils.layout(this, "wallet_cashdesk_discount_info_group"), (ViewGroup) null);
        ((TextView) inflate.findViewById(ResUtils.id(this, "payresult_discount_type"))).setText(str);
        ((TextView) inflate.findViewById(ResUtils.id(this, "payresult_discount_type_amount"))).setText("-" + this.strRmbUnit + str2);
        this.mpayResultDiscountType.addView(inflate, layoutParams);
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2) == null) {
            new Handler().post(new Runnable(this, str, str2) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62917a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f62918b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WalletPayResultCommonActivity f62919c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62919c = this;
                    this.f62917a = str;
                    this.f62918b = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        PromptDialog promptDialog = new PromptDialog(this.f62919c.getActivity());
                        promptDialog.setMessage(this.f62917a);
                        promptDialog.setCanceledOnTouchOutside(false);
                        promptDialog.setCancelable(true);
                        promptDialog.setPositiveBtn(ResUtils.string(this.f62919c.getApplicationContext(), "wallet_hce_do_auth"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ PromptDialog f62920a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f62921b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, promptDialog};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62921b = this;
                                this.f62920a = promptDialog;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                    PromptDialog promptDialog2 = this.f62920a;
                                    if (promptDialog2 != null && promptDialog2.isShowing()) {
                                        this.f62920a.dismiss();
                                    }
                                    BaiduPayDelegate.getInstance().doPayRNAuth(this.f62921b.f62919c.getActivity(), this.f62921b.f62918b, new RNAuthCallBack(this) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass1 f62922a;

                                        {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable4.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable4.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f62922a = this;
                                        }

                                        @Override // com.baidu.wallet.rnauth.RNAuthCallBack
                                        public void onRNAuthResult(int i2, String str3) {
                                            Interceptable interceptable4 = $ic;
                                            if (interceptable4 == null || interceptable4.invokeIL(1048576, this, i2, str3) == null) {
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        promptDialog.setNegativeBtn(ResUtils.string(this.f62919c.getApplicationContext(), "dxm_ebpay_cancel"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ PromptDialog f62923a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f62924b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, promptDialog};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62924b = this;
                                this.f62923a = promptDialog;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PromptDialog promptDialog2;
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) && (promptDialog2 = this.f62923a) != null && promptDialog2.isShowing()) {
                                    this.f62923a.dismiss();
                                }
                            }
                        });
                        promptDialog.show();
                    }
                }
            });
        }
    }
}
