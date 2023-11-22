package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q3b implements View.OnClickListener, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public final TBLottieAnimationView a;
    public final VerticalViewPager b;
    public boolean c;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, animator) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948042313, "Lcom/baidu/tieba/q3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948042313, "Lcom/baidu/tieba/q3b;");
                return;
            }
        }
        d = SharedPrefHelper.getInstance().getBoolean("key_video_guide_up_slide_animated", false);
        e = SharedPrefHelper.getInstance().getBoolean("key_video_guide_left_slide_animated", false);
    }

    public void c() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tBLottieAnimationView = this.a) != null && this.b != null && !this.c && d && !e && !tBLottieAnimationView.isAnimating()) {
            this.a.setImageAssetsFolder("lottie_video_guide_left");
            l(R.raw.lottie_video_guide_left);
            e = true;
            this.c = true;
            SharedPrefHelper.getInstance().putBoolean("key_video_guide_left_slide_animated", true);
        }
    }

    public void d() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tBLottieAnimationView = this.a) != null && this.b != null && !this.c && !d && !tBLottieAnimationView.isAnimating()) {
            this.a.setImageAssetsFolder("lottie_video_guide_up");
            l(R.raw.lottie_video_guide_up);
            d = true;
            this.c = true;
            SharedPrefHelper.getInstance().putBoolean("key_video_guide_up_slide_animated", true);
        }
    }

    public q3b(TBLottieAnimationView tBLottieAnimationView, VerticalViewPager verticalViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tBLottieAnimationView, verticalViewPager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
        this.a = tBLottieAnimationView;
        this.b = verticalViewPager;
        f();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            e = true;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.a.isAnimating()) {
                this.a.pauseAnimation();
            }
            this.a.setVisibility(8);
        }
    }

    public final void f() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tBLottieAnimationView = this.a) != null && this.b != null) {
            tBLottieAnimationView.setOnClickListener(this);
            this.a.addAnimatorUpdateListener(this);
            this.a.addAnimatorListener(this);
            this.a.setRepeatCount(2);
            this.a.setRepeatMode(1);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = false;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null && this.b != null) {
            e();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.setVisibility(0);
            this.a.playAnimation();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b(this.b);
        }
    }

    public final void b(VerticalViewPager verticalViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, verticalViewPager) == null) {
            verticalViewPager.setCurrentItem(verticalViewPager.getCurrentItem() + 1, true);
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a.setAnimation(i);
            i();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, animator) == null) && this.a != null && this.b != null) {
            e();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, valueAnimator) == null) && (tBLottieAnimationView = this.a) != null && this.b != null && tBLottieAnimationView.isAnimating() && !e && d) {
            valueAnimator.getAnimatedFraction();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            e();
        }
    }
}
