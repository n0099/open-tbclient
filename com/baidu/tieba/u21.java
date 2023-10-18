package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c11;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u21 extends t21 {
    public static /* synthetic */ Interceptable $ic;
    public static final s21 u;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint h;
    public final RectF i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;

    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u21 a;

        public a(u21 u21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u21Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationRepeat(animator);
                this.a.y();
                u21 u21Var = this.a;
                u21Var.o = u21Var.n;
                u21 u21Var2 = this.a;
                u21Var2.l = (u21Var2.l + 1.0f) % 5.0f;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.l = 0.0f;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948158997, "Lcom/baidu/tieba/u21;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948158997, "Lcom/baidu/tieba/u21;");
                return;
            }
        }
        u = new s21();
    }

    @Override // com.baidu.tieba.t21
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = 0.0f;
            this.r = 0.0f;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h.setAntiAlias(true);
            this.h.setStrokeWidth(this.s);
            this.h.setStyle(Paint.Style.STROKE);
            this.h.setStrokeCap(Paint.Cap.SQUARE);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            float f = this.n;
            this.q = f;
            this.r = f;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u21(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = new Paint();
        this.i = new RectF();
        u(context);
        x();
        b(new a(this));
    }

    @Override // com.baidu.tieba.t21
    public void c(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            if (f <= 0.5f) {
                this.o = this.r + (u.a(f / 0.5f) * 288.0f);
            }
            if (f > 0.5f) {
                this.n = this.q + (u.a((f - 0.5f) / 0.5f) * 288.0f);
            }
            if (Math.abs(this.n - this.o) > 0.0f) {
                this.p = this.n - this.o;
            }
            this.m = (f * 216.0f) + ((this.l / 5.0f) * 1080.0f);
        }
    }

    @Override // com.baidu.tieba.t21
    public void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            int save = canvas.save();
            this.i.set(this.b);
            RectF rectF = this.i;
            float f = this.k;
            rectF.inset(f, f);
            canvas.rotate(this.m, this.i.centerX(), this.i.centerY());
            if (this.p != 0.0f) {
                this.h.setColor(this.j);
                canvas.drawArc(this.i, this.o, this.p, false, this.h);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // com.baidu.tieba.t21
    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.h.setAlpha(i);
        }
    }

    @Override // com.baidu.tieba.t21
    public void l(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, colorFilter) == null) {
            this.h.setColorFilter(colorFilter);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.s = c11.c.a(context, 2.0f);
            this.t = c11.c.a(context, 11.5f);
            this.j = -1;
            v(this.f, this.g);
        }
    }

    public final void v(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.k = Math.max((Math.min(f, f2) / 2.0f) - this.t, (float) Math.ceil(this.s / 2.0f));
        }
    }
}
