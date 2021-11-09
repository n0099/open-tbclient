package com.baidu.wallet.paysdk.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
public abstract class HalfScreenBaseActivity extends PayBaseActivity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f60164a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AnimationDrawable f60165b;

    /* renamed from: c  reason: collision with root package name */
    public View f60166c;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1291938186, "Lcom/baidu/wallet/paysdk/ui/HalfScreenBaseActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1291938186, "Lcom/baidu/wallet/paysdk/ui/HalfScreenBaseActivity;");
        }
    }

    public HalfScreenBaseActivity() {
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
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || f60164a <= 1 || BaseActivity.mActivityStack.size() - 2 < 0 || !(BaseActivity.mActivityStack.get(size) instanceof HalfScreenBaseActivity)) {
            return;
        }
        findViewById(ResUtils.id(getActivity(), "ebpay_top_half")).setVisibility(4);
    }

    private void b() {
        int drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (f60164a > 1) {
                drawable = ResUtils.drawable(this, "wallet_base_new_halfscreen_actionbar_back");
                this.mLeftImg.setContentDescription("返回");
            } else {
                drawable = ResUtils.drawable(this, "wallet_base_halfscreen_actionbar_close");
                this.mLeftImg.setContentDescription("关闭");
            }
            this.mLeftImg.setImageResource(drawable);
        }
    }

    public static void resetInstanceCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f60164a = 0;
        }
    }

    public abstract void addContentView();

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            int i2 = f60164a;
            if (i2 > 0) {
                f60164a = i2 - 1;
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public void finishWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finishWithoutAnim();
            int i2 = f60164a;
            if (i2 > 0) {
                f60164a = i2 - 1;
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            f60164a++;
            setFlagPaySdk();
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_half_scrren_activity"));
            this.mHalfScreenPageView = (ViewGroup) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_page"));
            View findViewById = findViewById(ResUtils.id(getActivity(), "welcome_page"));
            this.f60166c = findViewById;
            findViewById.setVisibility(8);
            this.mRootView = findViewById(ResUtils.id(getActivity(), "root_view"));
            this.mHalfScreenContainer = (HalfScreenContainerLayout) findViewById(ResUtils.id(getActivity(), "ebpay_half_screen_container"));
            a();
            this.mActionBar = findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar"));
            this.mLeftImg = (ImageView) findViewById(ResUtils.id(getActivity(), "action_bar_left_img"));
            this.mTitle = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_title"));
            this.mRightTxt = (TextView) findViewById(ResUtils.id(getActivity(), "action_bar_left_txt"));
            b();
            this.f60165b = (AnimationDrawable) ((ImageView) findViewById(ResUtils.id(getActivity(), "img_anim"))).getDrawable();
            addContentView();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            if (isFinishing() || (i2 = f60164a) <= 0) {
                return;
            }
            f60164a = i2 - 1;
        }
    }

    public void setPageTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mRootView.setVisibility(z ? 4 : 0);
        }
    }

    public void showLikeDismissLadingPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f60166c.setVisibility(8);
            this.f60165b.stop();
        }
    }

    public void showLikeLoadingPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            setPageTransparent(false);
            if (z) {
                this.mHalfScreenPageView.setVisibility(8);
                this.f60166c.setVisibility(0);
                this.f60165b.start();
                return;
            }
            this.mHalfScreenPageView.setVisibility(0);
            this.f60166c.setVisibility(8);
            this.f60165b.stop();
        }
    }
}
