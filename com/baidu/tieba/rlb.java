package com.baidu.tieba;

import android.animation.ValueAnimator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.InstallActivity;
/* loaded from: classes7.dex */
public final class rlb implements ValueAnimator.AnimatorUpdateListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ InstallActivity d;

    public rlb(InstallActivity installActivity, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {installActivity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = installActivity;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
            float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
            float animatedFraction2 = valueAnimator.getAnimatedFraction();
            int i = this.b;
            this.d.getWindow().setLayout((int) ((this.a * animatedFraction) + (i * animatedFraction2)), (int) ((this.c * animatedFraction) + (i * animatedFraction2)));
            this.d.getWindow().getDecorView().refreshDrawableState();
        }
    }
}
