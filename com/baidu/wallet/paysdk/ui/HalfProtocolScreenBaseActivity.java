package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
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
import com.baidu.wallet.paysdk.ui.widget.HalfScreenContainerLayout;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.SDKBaseActivity;
/* loaded from: classes10.dex */
public abstract class HalfProtocolScreenBaseActivity extends PayBaseActivity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f61085a;
    public transient /* synthetic */ FieldHolder $fh;
    public View mActionBar;
    public ViewGroup mContentView;
    public HalfScreenContainerLayout mHalfScreenContainer;
    public ViewGroup mHalfScreenPageView;
    public ImageView mLeftImg;
    public TextView mRightTxt;
    public View mRootView;
    public TextView mTitle;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1303323070, "Lcom/baidu/wallet/paysdk/ui/HalfProtocolScreenBaseActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1303323070, "Lcom/baidu/wallet/paysdk/ui/HalfProtocolScreenBaseActivity;");
        }
    }

    public HalfProtocolScreenBaseActivity() {
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

    private void a() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || f61085a <= 1 || BaseActivity.mActivityStack.size() - 2 < 0 || !(BaseActivity.mActivityStack.get(size) instanceof HalfProtocolScreenBaseActivity)) {
            return;
        }
        findViewById(ResUtils.id(getActivity(), "ebpay_top_half")).setVisibility(4);
    }

    private void b() {
        int drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (f61085a > 1) {
                drawable = ResUtils.drawable(this, "wallet_base_new_halfscreen_actionbar_back");
                this.mLeftImg.setContentDescription("返回");
            } else {
                drawable = ResUtils.drawable(this, "wallet_base_new_bind_card_halfscreen_actionbar_close");
                this.mLeftImg.setContentDescription("关闭");
            }
            this.mLeftImg.setImageResource(drawable);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            this.mHalfScreenContainer.startAnimation(translateAnimation);
        }
    }

    public static void resetInstanceCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            f61085a = 0;
        }
    }

    public abstract void addContentView();

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            int i2 = f61085a;
            if (i2 > 0) {
                f61085a = i2 - 1;
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public void finishWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finishWithoutAnim();
            int i2 = f61085a;
            if (i2 > 0) {
                f61085a = i2 - 1;
            }
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            f61085a++;
            setFlagPaySdk();
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_half_protocol_scrren_activity"));
            this.mHalfScreenPageView = (ViewGroup) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_page"));
            this.mRootView = findViewById(ResUtils.id(getActivity(), "root_view"));
            this.mHalfScreenContainer = (HalfScreenContainerLayout) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_container"));
            a();
            this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
            this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
            this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
            this.mRightTxt = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
            b();
            addContentView();
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            if (isFinishing() || (i2 = f61085a) <= 0) {
                return;
            }
            f61085a = i2 - 1;
        }
    }

    public void setPageTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mRootView.setVisibility(z ? 4 : 0);
        }
    }
}
