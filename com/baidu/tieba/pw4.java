package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes5.dex */
public class pw4 extends Drawable implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnLayoutChangeListener A;
    public int B;
    public int a;
    public View b;
    public Paint c;
    public Paint d;
    public Paint e;
    public float f;
    public int g;
    public float h;
    public float i;
    public int j;
    public int k;
    public int l;
    public float[] m;
    public float[] n;
    public int o;
    public int p;
    public int[] q;
    public LinearGradient r;
    public float[] s;
    public float[] t;
    public Direction u;
    public RectF v;
    public RectF w;
    public Path x;
    public Path y;
    public Path z;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pw4 a;

        /* renamed from: com.baidu.tieba.pw4$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0406a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ ViewGroup.MarginLayoutParams b;
            public final /* synthetic */ a c;

            public RunnableC0406a(a aVar, View view2, ViewGroup.MarginLayoutParams marginLayoutParams) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view2, marginLayoutParams};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = view2;
                this.b = marginLayoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.setLayoutParams(this.b);
                }
            }
        }

        public a(pw4 pw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pw4Var;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            float f;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                if (view2.getBackground() instanceof pw4) {
                    pw4 pw4Var = (pw4) view2.getBackground();
                    this.a.j = pw4Var.j;
                    this.a.o = pw4Var.o;
                    this.a.p = pw4Var.p;
                    this.a.n = pw4Var.n;
                }
                float[] u = this.a.u();
                if (this.a.l == 1) {
                    float f4 = 0.0f;
                    if ((this.a.B & 1) == 1) {
                        f = u[0];
                    } else {
                        f = 0.0f;
                    }
                    u[0] = f;
                    if ((this.a.B & 16) == 16) {
                        f2 = u[1];
                    } else {
                        f2 = 0.0f;
                    }
                    u[1] = f2;
                    if ((this.a.B & 256) == 256) {
                        f3 = u[2];
                    } else {
                        f3 = 0.0f;
                    }
                    u[2] = f3;
                    if ((this.a.B & 4096) == 4096) {
                        f4 = u[3];
                    }
                    u[3] = f4;
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin -= (int) u[0];
                    marginLayoutParams.topMargin -= (int) u[1];
                    marginLayoutParams.rightMargin -= (int) u[2];
                    marginLayoutParams.bottomMargin -= (int) u[3];
                    marginLayoutParams.width = (i3 - i) + ((int) u[0]) + ((int) u[2]);
                    marginLayoutParams.height = (i4 - i2) + ((int) u[1]) + ((int) u[3]);
                    view2.post(new RunnableC0406a(this, view2, marginLayoutParams));
                }
                view2.removeOnLayoutChangeListener(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-504297378, "Lcom/baidu/tieba/pw4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-504297378, "Lcom/baidu/tieba/pw4$b;");
                    return;
                }
            }
            int[] iArr = new int[Direction.values().length];
            a = iArr;
            try {
                iArr[Direction.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Direction.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Direction.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public pw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f = 1.0f;
        this.g = 0;
        this.h = 1.0f;
        this.i = 0.0f;
        this.l = 1;
        this.m = new float[8];
        this.n = new float[8];
        this.q = new int[]{0};
        this.s = new float[]{0.0f, 1.0f};
        this.t = new float[]{0.0f, 1.0f};
        this.u = Direction.BOTTOM;
        this.v = new RectF();
        this.w = new RectF();
        this.x = new Path();
        this.y = new Path();
        this.z = new Path();
        this.A = new a(this);
        this.B = ShadowDrawable.ALL;
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(0);
        this.d.setAntiAlias(true);
        this.d.setShadowLayer(this.j, this.o, this.p, this.k);
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.c = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.e = paint3;
        paint3.setColor(this.g);
        this.e.setAlpha((int) (this.h * 255.0f));
        this.e.setStrokeWidth(this.i);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
    }

    public pw4 A(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            if (this.f != f) {
                this.f = f;
            }
            return this;
        }
        return (pw4) invokeF.objValue;
    }

    public pw4 B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int[] iArr = this.q;
            if (iArr.length == 1 && iArr[0] == i) {
                return this;
            }
            this.q = r0;
            int[] iArr2 = {i};
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 C(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
            if (Arrays.equals(this.q, iArr)) {
                return this;
            }
            this.q = iArr;
            return this;
        }
        return (pw4) invokeL.objValue;
    }

    public pw4 D(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
            if (this.h == f) {
                return this;
            }
            this.h = f;
            return this;
        }
        return (pw4) invokeF.objValue;
    }

    public pw4 E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.g == i) {
                return this;
            }
            this.g = i;
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 F(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            if (this.i == f) {
                return this;
            }
            this.i = f;
            return this;
        }
        return (pw4) invokeF.objValue;
    }

    public pw4 G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a == i) {
                return this;
            }
            this.a = i;
            Q();
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 H(Direction direction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, direction)) == null) {
            if (this.u.equals(direction)) {
                return this;
            }
            this.u = direction;
            return this;
        }
        return (pw4) invokeL.objValue;
    }

    public pw4 I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.o == i) {
                return this;
            }
            this.o = i;
            this.d.setShadowLayer(this.j, i, this.p, this.k);
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int i2 = this.o;
            if (i2 == i) {
                return this;
            }
            this.p = i;
            this.d.setShadowLayer(this.j, i2, i, this.k);
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 K(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fArr)) == null) {
            if (Arrays.equals(this.s, fArr)) {
                return this;
            }
            this.s = fArr;
            return this;
        }
        return (pw4) invokeL.objValue;
    }

    public pw4 L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.k == i) {
                return this;
            }
            this.k = i;
            this.d.setShadowLayer(this.j, this.o, this.p, i);
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.j == i) {
                return this;
            }
            this.j = i;
            this.d.setShadowLayer(i, this.o, this.p, this.k);
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.B == i) {
                return this;
            }
            this.B = i;
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (this.l == i) {
                return this;
            }
            this.l = i;
            return this;
        }
        return (pw4) invokeI.objValue;
    }

    public pw4 P(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fArr)) == null) {
            if (Arrays.equals(this.m, fArr)) {
                return this;
            }
            System.arraycopy(fArr, 0, this.m, 0, Math.min(fArr.length, 8));
            Q();
            return this;
        }
        return (pw4) invokeL.objValue;
    }

    public void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) && this.i != 0.0f && this.h != 0.0f && this.g != 0) {
            canvas.drawPath(this.z, this.e);
        }
    }

    public void p(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, canvas) == null) {
            if (this.j == 0 && this.o == 0 && this.p == 0) {
                return;
            }
            canvas.drawPath(this.x, this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.d.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, colorFilter) == null) {
            this.d.setColorFilter(colorFilter);
        }
    }

    public static pw4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return new pw4();
        }
        return (pw4) invokeV.objValue;
    }

    public final int[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int[] iArr = this.q;
            if (iArr == null) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length];
            for (int i = 0; i < length; i++) {
                iArr2[i] = rn8.a(this.q[i], this.f);
            }
            return iArr2;
        }
        return (int[]) invokeV.objValue;
    }

    public float r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.h;
        }
        return invokeV.floatValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public float t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.i;
        }
        return invokeV.floatValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            float[] fArr = this.s;
            if (fArr == null || fArr.length < 1 || fArr[fArr.length - 1] >= 1.0f) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || (view2 = this.b) == null) {
            return;
        }
        view2.removeOnLayoutChangeListener(this.A);
        this.b.setLayerType(0, null);
        this.b = null;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            float[] fArr = this.m;
            float[] fArr2 = this.n;
            System.arraycopy(fArr, 0, fArr2, 0, Math.min(fArr2.length, 8));
            int i = this.a;
            if (i != 1) {
                if (i == 2) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        this.n[i2] = 0.0f;
                    }
                    return;
                }
                return;
            }
            for (int i3 = 4; i3 < 8; i3++) {
                this.n[i3] = 0.0f;
            }
        }
    }

    public Object clone() {
        pw4 pw4Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                pw4Var = (pw4) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                pw4Var = null;
            }
            if (pw4Var == null) {
                return this;
            }
            pw4Var.O(this.l);
            pw4Var.N(this.B);
            pw4Var.G(this.a);
            pw4Var.P((float[]) this.m.clone());
            pw4Var.L(this.k);
            pw4Var.M(this.j);
            pw4Var.I(this.o);
            pw4Var.J(this.p);
            pw4Var.C((int[]) this.q.clone());
            pw4Var.K((float[]) this.s.clone());
            pw4Var.H(this.u);
            pw4Var.E(this.g);
            pw4Var.D(this.h);
            pw4Var.F(this.i);
            pw4Var.A(this.f);
            return pw4Var;
        }
        return invokeV.objValue;
    }

    public final float[] u() {
        InterceptResult invokeV;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            float[] fArr = new float[4];
            int i = this.l;
            if (i == 1) {
                if ((this.B & 1) == 1) {
                    f = this.j - this.o;
                } else {
                    f = -this.n[0];
                }
                fArr[0] = f;
                if ((this.B & 16) == 16) {
                    f2 = this.j - this.p;
                } else {
                    f2 = -this.n[2];
                }
                fArr[1] = f2;
                if ((this.B & 256) == 256) {
                    f3 = this.j + this.o;
                } else {
                    f3 = -this.n[4];
                }
                fArr[2] = f3;
                if ((this.B & 4096) == 4096) {
                    f4 = this.j + this.p;
                } else {
                    f4 = -this.n[6];
                }
                fArr[3] = f4;
            } else if (i == 2) {
                Arrays.fill(fArr, this.j);
            }
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, canvas) == null) {
            int[] q = q();
            if (q != null) {
                if (q.length == 1) {
                    this.c.setColor(q[0]);
                } else {
                    PointF w = w(this.v, this.u);
                    PointF v = v(this.v, this.u);
                    LinearGradient linearGradient = new LinearGradient(w.x, w.y, v.x, v.y, q, this.t, Shader.TileMode.CLAMP);
                    this.r = linearGradient;
                    this.c.setShader(linearGradient);
                }
            }
            this.e.setColor(this.g);
            this.e.setAlpha((int) ((this.g >>> 24) * this.h));
            this.e.setStrokeWidth(this.i);
            int i = this.l;
            if (i == 1) {
                p(canvas);
                canvas.drawPath(this.y, this.c);
                o(canvas);
            } else if (i == 2) {
                canvas.drawCircle(this.v.centerX(), this.v.centerY(), Math.min(this.v.width(), this.v.height()) / 2.0f, this.d);
                canvas.drawCircle(this.v.centerX(), this.v.centerY(), Math.min(this.v.width(), this.v.height()) / 2.0f, this.c);
                canvas.drawCircle(this.v.centerX(), this.v.centerY(), (Math.min(this.v.width(), this.v.height()) / 2.0f) - (this.i * 0.5f), this.e);
            } else {
                canvas.drawRect(this.v, this.c);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, rect) == null) {
            super.onBoundsChange(rect);
            int length = this.n.length;
            for (int i = 0; i < length; i++) {
                float[] fArr = this.n;
                if (fArr[i] > 0.0f && fArr[i] < 1.0f) {
                    fArr[i] = fArr[i] * rect.height();
                }
            }
            float[] u = u();
            this.v = new RectF(rect.left + u[0], rect.top + u[1], rect.right - u[2], rect.bottom - u[3]);
            this.x.reset();
            this.x.addRoundRect(this.v, this.n, Path.Direction.CW);
            this.t = (float[]) this.s.clone();
            float[] fArr2 = (float[]) this.n.clone();
            int[] iArr = this.q;
            if (iArr != null && iArr.length > 1 && x()) {
                m(fArr2, this.t);
            }
            this.y.reset();
            this.y.addRoundRect(this.v, fArr2, Path.Direction.CW);
            float f = this.i * 0.5f;
            float[] fArr3 = (float[]) this.n.clone();
            for (int i2 = 0; i2 < fArr3.length; i2++) {
                fArr3[i2] = fArr3[i2] - this.i;
                if (fArr3[i2] < 0.0f) {
                    fArr3[i2] = 0.0f;
                }
            }
            RectF rectF = this.v;
            this.w = new RectF(rectF.left + f, rectF.top + f, rectF.right - f, rectF.bottom - f);
            this.z.reset();
            this.z.addRoundRect(this.w, fArr3, Path.Direction.CW);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || pw4.class != obj.getClass()) {
                return false;
            }
            pw4 pw4Var = (pw4) obj;
            if (hashCode() == pw4Var.hashCode() && this.a == pw4Var.a && this.j == pw4Var.j && this.k == pw4Var.k && this.l == pw4Var.l && this.o == pw4Var.o && this.p == pw4Var.p && this.B == pw4Var.B && Arrays.equals(this.m, pw4Var.m) && Arrays.equals(this.n, pw4Var.n) && Arrays.equals(this.q, pw4Var.q) && Arrays.equals(this.s, pw4Var.s) && this.u.equals(pw4Var.u) && this.g == pw4Var.g && this.h == pw4Var.h && this.i == pw4Var.i && this.f == pw4Var.f) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return (((((((Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.o), Integer.valueOf(this.p), this.u, Integer.valueOf(this.B), Integer.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(this.i), Float.valueOf(this.f)) * 31) + Arrays.hashCode(this.m)) * 31) + Arrays.hashCode(this.n)) * 31) + Arrays.hashCode(this.q)) * 31) + Arrays.hashCode(this.s);
        }
        return invokeV.intValue;
    }

    public GradientDrawable l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            int length = this.n.length;
            for (int i2 = 0; i2 < length; i2++) {
                float[] fArr = this.n;
                if (fArr[i2] > 0.0f && fArr[i2] < 1.0f) {
                    fArr[i2] = fArr[i2] * i;
                }
            }
            gradientDrawable.setCornerRadii(this.n);
            gradientDrawable.setAlpha((int) (this.f * 255.0f));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeI.objValue;
    }

    public final void m(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, fArr, fArr2) == null) {
            int i = b.a[this.u.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            RectF rectF = this.v;
                            float f = rectF.left;
                            float width = rectF.width();
                            float[] fArr3 = this.s;
                            rectF.right = f + (width * fArr3[fArr3.length - 1]);
                            fArr[2] = 0.0f;
                            fArr[3] = 0.0f;
                            fArr[4] = 0.0f;
                            fArr[5] = 0.0f;
                        }
                    } else {
                        RectF rectF2 = this.v;
                        float f2 = rectF2.right;
                        float width2 = rectF2.width();
                        float[] fArr4 = this.s;
                        rectF2.left = f2 - (width2 * fArr4[fArr4.length - 1]);
                        fArr[0] = 0.0f;
                        fArr[1] = 0.0f;
                        fArr[6] = 0.0f;
                        fArr[7] = 0.0f;
                    }
                } else {
                    RectF rectF3 = this.v;
                    float f3 = rectF3.bottom;
                    float height = rectF3.height();
                    float[] fArr5 = this.s;
                    rectF3.top = f3 - (height * fArr5[fArr5.length - 1]);
                    fArr[0] = 0.0f;
                    fArr[1] = 0.0f;
                    fArr[2] = 0.0f;
                    fArr[3] = 0.0f;
                }
            } else {
                RectF rectF4 = this.v;
                float f4 = rectF4.top;
                float height2 = rectF4.height();
                float[] fArr6 = this.s;
                rectF4.bottom = f4 + (height2 * fArr6[fArr6.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
            }
            fArr2[fArr2.length - 1] = 1.0f;
        }
    }

    public pw4 n(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            this.b = view2;
            if (equals(view2.getBackground())) {
                return null;
            }
            this.b.removeOnLayoutChangeListener(this.A);
            this.b.addOnLayoutChangeListener(this.A);
            return this;
        }
        return (pw4) invokeL.objValue;
    }

    public final PointF v(RectF rectF, Direction direction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, rectF, direction)) == null) {
            int i = b.a[direction.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new PointF();
                        }
                        return new PointF(rectF.right, rectF.height() / 2.0f);
                    }
                    return new PointF(rectF.left, rectF.height() / 2.0f);
                }
                return new PointF(rectF.width() / 2.0f, rectF.top);
            }
            return new PointF(rectF.width() / 2.0f, rectF.bottom);
        }
        return (PointF) invokeLL.objValue;
    }

    public final PointF w(RectF rectF, Direction direction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, rectF, direction)) == null) {
            int i = b.a[direction.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new PointF();
                        }
                        return new PointF(rectF.left, rectF.height() / 2.0f);
                    }
                    return new PointF(rectF.right, rectF.height() / 2.0f);
                }
                return new PointF(rectF.width() / 2.0f, rectF.bottom);
            }
            return new PointF(rectF.width() / 2.0f, rectF.top);
        }
        return (PointF) invokeLL.objValue;
    }
}
