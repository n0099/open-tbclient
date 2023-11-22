package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class oz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public View b;
    public TBLottieAnimationView c;
    public TextView d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948049691, "Lcom/baidu/tieba/oz9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948049691, "Lcom/baidu/tieba/oz9;");
        }
    }

    public oz9(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = activity;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.c;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_full_screen_refresh);
            }
            TextView textView = this.d;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0108);
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.c;
            if (tBLottieAnimationView != null && tBLottieAnimationView.isAnimating()) {
                tBLottieAnimationView.cancelAnimation();
            }
            View view2 = this.b;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            DefaultLog.getInstance().i("PbFragmentLoadingManager", "隐藏最上层loading");
        }
    }

    public final void c(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.c;
            if (tBLottieAnimationView != null) {
                Intrinsics.checkNotNull(tBLottieAnimationView);
                if (tBLottieAnimationView.isAnimating()) {
                    return;
                }
            }
            if (view2 != null) {
                this.b = view2;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                TBLottieAnimationView tBLottieAnimationView2 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09287f);
                this.c = tBLottieAnimationView2;
                if (tBLottieAnimationView2 != null) {
                    SkinManager.setLottieAnimation(tBLottieAnimationView2, R.raw.lottie_full_screen_refresh);
                    TBLottieAnimationView tBLottieAnimationView3 = this.c;
                    if (tBLottieAnimationView3 != null) {
                        tBLottieAnimationView3.setRepeatCount(-1);
                    }
                    TBLottieAnimationView tBLottieAnimationView4 = this.c;
                    if (tBLottieAnimationView4 != null) {
                        tBLottieAnimationView4.setSpeed(1.2f);
                    }
                    TBLottieAnimationView tBLottieAnimationView5 = this.c;
                    if (tBLottieAnimationView5 != null) {
                        tBLottieAnimationView5.playAnimation();
                    }
                }
                this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092880);
            }
            DefaultLog.getInstance().i("PbFragmentLoadingManager", "显示最上层loading");
        }
    }
}
