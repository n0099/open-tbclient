package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j95 extends d95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContinuousAnimationView a;
    public String[] b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public int f;
    public final int g;
    public int h;
    public Runnable i;
    public boolean j;
    public ValueAnimator.AnimatorUpdateListener k;
    public final Animator.AnimatorListener l;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j95 a;

        public a(j95 j95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j95Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(this.a.i);
                    return;
                }
                this.a.c.setText(this.a.b[this.a.l()]);
                TbadkCoreApplication.getInst().handler.postDelayed(this.a.i, 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j95 a;

        public b(j95 j95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j95Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedFraction > 0.0f) {
                    this.a.e.setVisibility(8);
                }
                if (!this.a.j) {
                    this.a.a.setAlpha(Math.min(1.0f, (animatedFraction * 24.0f) / 6.0f));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j95 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        public c(j95 j95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j95Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) != null) {
                return;
            }
            this.a.j = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, animator) != null) {
                return;
            }
            this.a.j = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j95(Context context) {
        this(context, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j95(Context context, int i) {
        super(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0565, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.h = -1;
        this.i = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0906a5);
        this.a = continuousAnimationView;
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.a.setLayoutParams(marginLayoutParams);
            }
        }
        SkinManager.setLottieAnimation(this.a, R.raw.lottie_full_screen_refresh);
        this.a.setMinAndMaxProgress(0.0f, 1.0f);
        this.a.setRepeatMode(1);
        this.a.addAnimatorUpdateListener(this.k);
        this.a.addAnimatorListener(this.l);
        this.a.setSpeed(1.2f);
        this.c = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091406);
        this.d = (TextView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f091412);
        ImageView imageView = (ImageView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f09140b);
        this.e = imageView;
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f0807c8);
        String[] stringArray = context.getResources().getStringArray(R.array.obfuscated_res_0x7f030011);
        this.b = stringArray;
        this.g = stringArray.length;
    }

    @Override // com.baidu.tieba.d95
    public void dettachView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            ContinuousAnimationView continuousAnimationView = this.a;
            if (continuousAnimationView != null) {
                continuousAnimationView.cancelAnimation();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.i);
            super.dettachView(view2);
        }
    }

    public void o(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (view2 = this.attachedView) != null) {
            view2.setBackgroundColor(i);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.d.setText(i);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = i;
        }
    }

    public void s(int i) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048590, this, i) != null) || (continuousAnimationView = this.a) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = continuousAnimationView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.a.setLayoutParams(marginLayoutParams);
        }
    }

    public void i() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (continuousAnimationView = this.a) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) continuousAnimationView.getLayoutParams()).addRule(15, 0);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.attachedView;
        }
        return (View) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.f + 1;
            this.f = i;
            if (i >= this.g) {
                this.f = 0;
            }
            return this.f;
        }
        return invokeV.intValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            u();
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.i);
        }
    }

    @Override // com.baidu.tieba.d95
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            n();
        }
    }

    public final void t() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (continuousAnimationView = this.a) != null) {
            continuousAnimationView.playAnimation();
        }
    }

    public final void u() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (continuousAnimationView = this.a) != null) {
            continuousAnimationView.pauseAnimation();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0108, 1, i);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1, i);
            SkinManager.setLottieAnimation(this.a, R.raw.lottie_full_screen_refresh);
            if (isViewAttached()) {
                t();
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.i);
            TbadkCoreApplication.getInst().handler.postDelayed(this.i, 200L);
            this.h = i;
        }
    }

    public void p(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && this.a != null && (textView = this.d) != null) {
            if (textView.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.bottomMargin = i;
                    this.a.setLayoutParams(marginLayoutParams);
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.bottomMargin = i;
                this.d.setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.h == -1) {
                this.h = TbadkCoreApplication.getInst().getSkinType();
            }
            if (isViewAttached()) {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0108, 1, this.h);
                SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1, this.h);
                t();
            }
        }
    }

    @Override // com.baidu.tieba.d95
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.h == -1) {
                this.h = TbadkCoreApplication.getInst().getSkinType();
            }
            SkinManager.setLottieAnimation(this.a, R.raw.lottie_full_screen_refresh);
            t();
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0108, 1, this.h);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1, this.h);
            this.c.setText(this.b[0]);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.i);
            TbadkCoreApplication.getInst().handler.postDelayed(this.i, 200L);
            this.attachedView.setClickable(true);
        }
    }
}
