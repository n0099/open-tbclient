package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class uo extends Drawable implements Animatable {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator l;
    public static final Interpolator m;
    public static final int[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Animation> a;
    public final d b;
    public float c;
    public Resources d;
    public View e;
    public Animation f;
    public float g;
    public double h;
    public double i;
    public boolean j;
    public final Drawable.Callback k;

    /* loaded from: classes6.dex */
    public class a extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ uo b;

        public a(uo uoVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uoVar;
            this.a = dVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                uo uoVar = this.b;
                if (uoVar.j) {
                    uoVar.a(f, this.a);
                    return;
                }
                float c = uoVar.c(this.a);
                float j = this.a.j();
                float l = this.a.l();
                float k = this.a.k();
                this.b.m(f, this.a);
                if (f <= 0.5f) {
                    this.a.D(l + ((0.8f - c) * uo.m.getInterpolation(f / 0.5f)));
                }
                if (f > 0.5f) {
                    this.a.z(j + ((0.8f - c) * uo.m.getInterpolation((f - 0.5f) / 0.5f)));
                }
                this.a.B(k + (0.25f * f));
                uo uoVar2 = this.b;
                uoVar2.h((f * 216.0f) + ((uoVar2.g / 5.0f) * 1080.0f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ uo b;

        public b(uo uoVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uoVar;
            this.a = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                this.a.F();
                this.a.n();
                d dVar = this.a;
                dVar.D(dVar.e());
                uo uoVar = this.b;
                if (uoVar.j) {
                    uoVar.j = false;
                    animation.setDuration(1332L);
                    this.a.C(false);
                    return;
                }
                uoVar.g = (uoVar.g + 1.0f) % 5.0f;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                this.b.g = 0.0f;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Drawable.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo a;

        public c(uo uoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uoVar;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.a.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{drawable, runnable, Long.valueOf(j)}) == null) {
                this.a.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, drawable, runnable) == null) {
                this.a.unscheduleSelf(runnable);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RectF a;
        public final Paint b;
        public final Paint c;
        public final Drawable.Callback d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public int[] j;
        public int k;
        public float l;
        public float m;
        public float n;
        public boolean o;
        public Path p;
        public float q;
        public double r;
        public int s;
        public int t;
        public int u;
        public final Paint v;
        public int w;
        public int x;

        public d(Drawable.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new RectF();
            this.b = new Paint();
            this.c = new Paint();
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 5.0f;
            this.i = 2.5f;
            this.v = new Paint(1);
            this.d = callback;
            this.b.setStrokeCap(Paint.Cap.SQUARE);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.STROKE);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setAntiAlias(true);
        }

        public void A(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                float min = Math.min(i, i2);
                double d = this.r;
                this.i = (float) ((d <= 0.0d || min < 0.0f) ? Math.ceil(this.h / 2.0f) : (min / 2.0f) - d);
            }
        }

        public void B(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                this.g = f;
                o();
            }
        }

        public void C(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.o == z) {
                return;
            }
            this.o = z;
            o();
        }

        public void D(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.e = f;
                o();
            }
        }

        public void E(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
                this.h = f;
                this.b.setStrokeWidth(f);
                o();
            }
        }

        public void F() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.l = this.e;
                this.m = this.f;
                this.n = this.g;
            }
        }

        public void a(Canvas canvas, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, canvas, rect) == null) {
                RectF rectF = this.a;
                rectF.set(rect);
                float f = this.i;
                rectF.inset(f, f);
                float f2 = this.e;
                float f3 = this.g;
                float f4 = (f2 + f3) * 360.0f;
                float f5 = ((this.f + f3) * 360.0f) - f4;
                this.b.setColor(this.x);
                canvas.drawArc(rectF, f4, f5, false, this.b);
                b(canvas, f4, f5, rect);
                if (this.u < 255) {
                    this.v.setColor(this.w);
                    this.v.setAlpha(255 - this.u);
                    canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.v);
                }
            }
        }

        public final void b(Canvas canvas, float f, float f2, Rect rect) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), rect}) == null) && this.o) {
                Path path = this.p;
                if (path == null) {
                    Path path2 = new Path();
                    this.p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.i) / 2) * this.q;
                float sin = (float) ((this.r * Math.sin(0.0d)) + rect.exactCenterY());
                this.p.moveTo(0.0f, 0.0f);
                this.p.lineTo(this.s * this.q, 0.0f);
                Path path3 = this.p;
                float f4 = this.q;
                path3.lineTo((this.s * f4) / 2.0f, this.t * f4);
                this.p.offset(((float) ((this.r * Math.cos(0.0d)) + rect.exactCenterX())) - f3, sin);
                this.p.close();
                this.c.setColor(this.x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.p, this.c);
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.u : invokeV.intValue;
        }

        public double d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.doubleValue;
        }

        public float e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : invokeV.floatValue;
        }

        public int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j[g()] : invokeV.intValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (this.k + 1) % this.j.length : invokeV.intValue;
        }

        public float h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.e : invokeV.floatValue;
        }

        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j[this.k] : invokeV.intValue;
        }

        public float j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : invokeV.floatValue;
        }

        public float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : invokeV.floatValue;
        }

        public float l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.floatValue;
        }

        public float m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h : invokeV.floatValue;
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                x(g());
            }
        }

        public final void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                this.d.invalidateDrawable(null);
            }
        }

        public void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                this.l = 0.0f;
                this.m = 0.0f;
                this.n = 0.0f;
                D(0.0f);
                z(0.0f);
                B(0.0f);
            }
        }

        public void q(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
                this.u = i;
            }
        }

        public void r(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.s = (int) f;
                this.t = (int) f2;
            }
        }

        public void s(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048600, this, f) == null) || f == this.q) {
                return;
            }
            this.q = f;
            o();
        }

        public void t(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
                this.w = i;
            }
        }

        public void u(double d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Double.valueOf(d)}) == null) {
                this.r = d;
            }
        }

        public void v(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
                this.x = i;
            }
        }

        public void w(ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, colorFilter) == null) {
                this.b.setColorFilter(colorFilter);
                o();
            }
        }

        public void x(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
                this.k = i;
                this.x = this.j[i];
            }
        }

        public void y(@NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, iArr) == null) {
                this.j = iArr;
                x(0);
            }
        }

        public void z(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048607, this, f) == null) {
                this.f = f;
                o();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319059, "Lcom/baidu/tieba/uo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319059, "Lcom/baidu/tieba/uo;");
                return;
            }
        }
        l = new LinearInterpolator();
        m = new FastOutSlowInInterpolator();
        n = new int[]{-16777216};
    }

    public uo(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.k = new c(this);
        this.e = view2;
        this.d = context.getResources();
        d dVar = new d(this.k);
        this.b = dVar;
        dVar.y(n);
        n(1);
        k();
    }

    public void a(float f, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), dVar}) == null) {
            m(f, dVar);
            dVar.D(dVar.l() + (((dVar.j() - c(dVar)) - dVar.l()) * f));
            dVar.z(dVar.j());
            dVar.B(dVar.k() + ((((float) (Math.floor(dVar.k() / 0.8f) + 1.0d)) - dVar.k()) * f));
        }
    }

    public final int b(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int intValue = Integer.valueOf(i).intValue();
            int i3 = (intValue >> 24) & 255;
            int i4 = (intValue >> 16) & 255;
            int i5 = (intValue >> 8) & 255;
            int i6 = intValue & 255;
            int intValue2 = Integer.valueOf(i2).intValue();
            return ((i3 + ((int) ((((intValue2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((intValue2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((intValue2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((intValue2 & 255) - i6))));
        }
        return invokeCommon.intValue;
    }

    public float c(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? (float) Math.toRadians(dVar.m() / (dVar.d() * 6.283185307179586d)) : invokeL.floatValue;
    }

    public void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.b.s(f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            Rect bounds = getBounds();
            int save = canvas.save();
            canvas.rotate(this.c, bounds.exactCenterX(), bounds.exactCenterY());
            this.b.a(canvas, bounds);
            if (save < 1 || save > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b.t(i);
        }
    }

    public void f(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iArr) == null) {
            this.b.y(iArr);
            this.b.x(0);
        }
    }

    public void g(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.b.B(f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b.c() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) this.i : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (int) this.h : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public void h(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            this.c = f;
            invalidateSelf();
        }
    }

    public final void i(double d2, double d3, double d4, double d5, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            d dVar = this.b;
            float f3 = this.d.getDisplayMetrics().density;
            double d6 = f3;
            this.h = d2 * d6;
            this.i = d3 * d6;
            dVar.E(((float) d5) * f3);
            dVar.u(d4 * d6);
            dVar.x(0);
            dVar.r(f * f3, f2 * f3);
            dVar.A((int) this.h, (int) this.i);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList<Animation> arrayList = this.a;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Animation animation = arrayList.get(i);
                if (animation.hasStarted() && !animation.hasEnded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.b.D(f);
            this.b.z(f2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            d dVar = this.b;
            a aVar = new a(this, dVar);
            aVar.setRepeatCount(-1);
            aVar.setRepeatMode(1);
            aVar.setInterpolator(l);
            aVar.setAnimationListener(new b(this, dVar));
            this.f = aVar;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.b.C(z);
        }
    }

    public void m(float f, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), dVar}) == null) || f <= 0.75f) {
            return;
        }
        dVar.v(b((f - 0.75f) / 0.25f, dVar.i(), dVar.f()));
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            if (i == 0) {
                i(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
            } else {
                i(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.b.q(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, colorFilter) == null) {
            this.b.w(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f.reset();
            this.b.F();
            if (this.b.e() != this.b.h()) {
                this.j = true;
                this.f.setDuration(666L);
                this.e.startAnimation(this.f);
                return;
            }
            this.b.x(0);
            this.b.p();
            this.f.setDuration(1332L);
            this.e.startAnimation(this.f);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.e.clearAnimation();
            h(0.0f);
            this.b.C(false);
            this.b.x(0);
            this.b.p();
        }
    }
}
