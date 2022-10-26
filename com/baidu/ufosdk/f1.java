package com.baidu.ufosdk;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f1 extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final PorterDuffXfermode r;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public Paint b;
    public d c;
    public g d;
    public Bitmap e;
    public Bitmap f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public ViewTreeObserver.OnGlobalLayoutListener o;
    public ValueAnimator p;
    public Bitmap q;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f1 a;

        public a(f1 f1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f1Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f1 f1Var = this.a;
                boolean z = f1Var.n;
                f1Var.a();
                if (this.a.g || z) {
                    this.a.b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f1 a;

        public b(f1 f1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f1Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float max = Math.max(0.0f, Math.min(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                f1 f1Var = this.a;
                g gVar = f1Var.d;
                float f = 1.0f - max;
                f1Var.setMaskOffsetX((int) ((gVar.a * f) + (gVar.c * max)));
                f1 f1Var2 = this.a;
                g gVar2 = f1Var2.d;
                f1Var2.setMaskOffsetY((int) ((gVar2.b * f) + (gVar2.d * max)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1139024724, "Lcom/baidu/ufosdk/f1$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1139024724, "Lcom/baidu/ufosdk/f1$c;");
                    return;
                }
            }
            int[] iArr = new int[f.values().length];
            b = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.values().length];
            a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[2] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[3] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e a;
        public float b;
        public float c;
        public int d;
        public int e;
        public float f;
        public float g;
        public float h;
        public f i;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public int[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int ordinal = this.i.ordinal();
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        return new int[]{0, -16777216, -16777216, 0};
                    }
                    return new int[]{-16777216, 0, 0, -16777216};
                }
                return new int[]{-16777216, -16777216, 0};
            }
            return (int[]) invokeV.objValue;
        }

        public float[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.i.ordinal() != 1 ? new float[]{Math.max(((1.0f - this.f) - this.c) / 2.0f, 0.0f), Math.max((1.0f - this.f) / 2.0f, 0.0f), Math.min((this.f + 1.0f) / 2.0f, 1.0f), Math.min(((this.f + 1.0f) + this.c) / 2.0f, 1.0f)} : new float[]{0.0f, Math.min(this.f, 1.0f), Math.min(this.f + this.c, 1.0f)};
            }
            return (float[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public final class e {
        public static /* synthetic */ Interceptable $ic;
        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        public static final /* synthetic */ e[] e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1139024662, "Lcom/baidu/ufosdk/f1$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1139024662, "Lcom/baidu/ufosdk/f1$e;");
                    return;
                }
            }
            a = new e("CW_0", 0);
            b = new e("CW_90", 1);
            c = new e("CW_180", 2);
            e eVar = new e("CW_270", 3);
            d = eVar;
            e = new e[]{a, b, c, eVar};
        }

        public e(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static e valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (e) Enum.valueOf(e.class, str);
            }
            return (e) invokeL.objValue;
        }

        public static e[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (e[]) e.clone();
            }
            return (e[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final f a;
        public static final f b;
        public static final f c;
        public static final /* synthetic */ f[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1139024631, "Lcom/baidu/ufosdk/f1$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1139024631, "Lcom/baidu/ufosdk/f1$f;");
                    return;
                }
            }
            a = new f("LINEAR", 0);
            b = new f("RADIAL", 1);
            f fVar = new f("WHITE_LINEAR", 2);
            c = fVar;
            d = new f[]{a, b, fVar};
        }

        public f(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static f valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (f) Enum.valueOf(f.class, str);
            }
            return (f) invokeL.objValue;
        }

        public static f[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (f[]) d.clone();
            }
            return (f[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1174232459, "Lcom/baidu/ufosdk/f1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1174232459, "Lcom/baidu/ufosdk/f1;");
                return;
            }
        }
        r = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    private ViewTreeObserver.OnGlobalLayoutListener getLayoutListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return new a(this);
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            Bitmap bitmap = this.q;
            if (bitmap != null) {
                bitmap.recycle();
                this.q = null;
            }
            Bitmap bitmap2 = this.f;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f = null;
            }
            Bitmap bitmap3 = this.e;
            if (bitmap3 != null) {
                bitmap3.recycle();
                this.e = null;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.n) {
            Animator shimmerAnimation = getShimmerAnimation();
            shimmerAnimation.start();
            ((ValueAnimator) shimmerAnimation).setCurrentPlayTime(300L);
            this.n = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.end();
                this.p.removeAllUpdateListeners();
                this.p.cancel();
            }
            this.p = null;
            this.n = false;
        }
    }

    public e getAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c.a;
        }
        return (e) invokeV.objValue;
    }

    public float getBaseAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.getAlpha() / 255.0f;
        }
        return invokeV.floatValue;
    }

    public float getDropoff() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c.c;
        }
        return invokeV.floatValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int getFixedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c.e;
        }
        return invokeV.intValue;
    }

    public int getFixedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c.d;
        }
        return invokeV.intValue;
    }

    public float getIntensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c.f;
        }
        return invokeV.floatValue;
    }

    public f getMaskShape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c.i;
        }
        return (f) invokeV.objValue;
    }

    public float getRelativeHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c.h;
        }
        return invokeV.floatValue;
    }

    public float getRelativeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c.g;
        }
        return invokeV.floatValue;
    }

    public int getRepeatCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int getRepeatDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public float getTilt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c.b;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
            if (this.o == null) {
                this.o = getLayoutListener();
            }
            getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c();
            if (this.o != null) {
                getViewTreeObserver().removeGlobalOnLayoutListener(this.o);
                this.o = null;
            }
            super.onDetachedFromWindow();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f1(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        setWillNotDraw(false);
        this.c = new d(null);
        this.a = new Paint();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setFilterBitmap(true);
        this.b.setXfermode(r);
        e();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UFOShimmerFrameLayout, 0, 0);
            try {
                if (obtainStyledAttributes.hasValue(1)) {
                    setAutoStart(obtainStyledAttributes.getBoolean(1, false));
                }
                if (obtainStyledAttributes.hasValue(2)) {
                    setBaseAlpha(obtainStyledAttributes.getFloat(2, 0.0f));
                }
                if (obtainStyledAttributes.hasValue(4)) {
                    setDuration(obtainStyledAttributes.getInt(4, 0));
                }
                if (obtainStyledAttributes.hasValue(10)) {
                    setRepeatCount(obtainStyledAttributes.getInt(10, 0));
                }
                if (obtainStyledAttributes.hasValue(11)) {
                    setRepeatDelay(obtainStyledAttributes.getInt(11, 0));
                }
                if (obtainStyledAttributes.hasValue(12)) {
                    setRepeatMode(obtainStyledAttributes.getInt(12, 0));
                }
                if (obtainStyledAttributes.hasValue(0)) {
                    int i4 = obtainStyledAttributes.getInt(0, 0);
                    if (i4 != 90) {
                        if (i4 != 180) {
                            if (i4 != 270) {
                                this.c.a = e.a;
                            } else {
                                this.c.a = e.d;
                            }
                        } else {
                            this.c.a = e.c;
                        }
                    } else {
                        this.c.a = e.b;
                    }
                }
                if (obtainStyledAttributes.hasValue(13)) {
                    if (obtainStyledAttributes.getInt(13, 0) != 1) {
                        this.c.i = f.a;
                    } else {
                        this.c.i = f.b;
                    }
                }
                if (obtainStyledAttributes.hasValue(3)) {
                    this.c.c = obtainStyledAttributes.getFloat(3, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(6)) {
                    this.c.d = obtainStyledAttributes.getDimensionPixelSize(6, 0);
                }
                if (obtainStyledAttributes.hasValue(5)) {
                    this.c.e = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                }
                if (obtainStyledAttributes.hasValue(7)) {
                    this.c.f = obtainStyledAttributes.getFloat(7, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(9)) {
                    this.c.g = obtainStyledAttributes.getFloat(9, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(8)) {
                    this.c.h = obtainStyledAttributes.getFloat(8, 0.0f);
                }
                if (obtainStyledAttributes.hasValue(14)) {
                    this.c.b = obtainStyledAttributes.getFloat(14, 0.0f);
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private Bitmap getMaskBitmap() {
        InterceptResult invokeV;
        Bitmap createBitmap;
        Shader radialGradient;
        int sqrt;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            Bitmap bitmap = this.q;
            if (bitmap != null) {
                return bitmap;
            }
            d dVar = this.c;
            int width = getWidth();
            int i4 = dVar.d;
            if (i4 <= 0) {
                i4 = (int) (width * dVar.g);
            }
            d dVar2 = this.c;
            int height = getHeight();
            int i5 = dVar2.e;
            if (i5 <= 0) {
                i5 = (int) (height * dVar2.h);
            }
            try {
                createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                System.gc();
                createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            }
            this.q = createBitmap;
            Canvas canvas = new Canvas(this.q);
            if (this.c.i.ordinal() != 1) {
                int ordinal = this.c.a.ordinal();
                int i6 = 0;
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            i = i4;
                        } else {
                            i3 = i5;
                            i = 0;
                            i2 = 0;
                            radialGradient = new LinearGradient(i2, i3, i, i6, this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
                        }
                    } else {
                        i2 = i4;
                        i = 0;
                        i3 = 0;
                        radialGradient = new LinearGradient(i2, i3, i, i6, this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
                    }
                } else {
                    i6 = i5;
                    i = 0;
                }
                i3 = 0;
                i2 = 0;
                radialGradient = new LinearGradient(i2, i3, i, i6, this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
            } else {
                radialGradient = new RadialGradient(i4 / 2, i5 / 2, (float) (Math.max(i4, i5) / Math.sqrt(2.0d)), this.c.a(), this.c.b(), Shader.TileMode.REPEAT);
            }
            canvas.rotate(this.c.b, i4 / 2, i5 / 2);
            Paint paint = new Paint();
            paint.setShader(radialGradient);
            float f2 = -(((int) (Math.sqrt(2.0d) * Math.max(i4, i5))) / 2);
            canvas.drawRect(f2, f2, i4 + sqrt, i5 + sqrt, paint);
            return this.q;
        }
        return (Bitmap) invokeV.objValue;
    }

    private Animator getShimmerAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                return valueAnimator;
            }
            int width = getWidth();
            int height = getHeight();
            int i = c.b[this.c.i.ordinal()];
            int ordinal = this.c.a.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        this.d.a(-width, 0, width, 0);
                    } else {
                        this.d.a(0, height, 0, -height);
                    }
                } else {
                    this.d.a(width, 0, -width, 0);
                }
            } else {
                this.d.a(0, -height, 0, height);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (this.j / this.h) + 1.0f);
            this.p = ofFloat;
            ofFloat.setDuration(this.h + this.j);
            this.p.setRepeatCount(this.i);
            this.p.setRepeatMode(this.k);
            this.p.addUpdateListener(new b(this));
            return this.p;
        }
        return (Animator) invokeV.objValue;
    }

    public final Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int width = getWidth();
            int height = getHeight();
            try {
                try {
                    return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    StringBuilder sb = new StringBuilder("ShimmerFrameLayout failed to create working bitmap");
                    sb.append(" (width = ");
                    sb.append(width);
                    sb.append(", height = ");
                    sb.append(height);
                    sb.append(")\n\n");
                    for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    Log.d("ShimmerFrameLayout", sb.toString());
                    return null;
                }
            } catch (OutOfMemoryError unused2) {
                System.gc();
                return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetX(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65545, this, i) == null) && this.l != i) {
            this.l = i;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskOffsetY(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65546, this, i) == null) && this.m != i) {
            this.m = i;
            invalidate();
        }
    }

    public void setAngle(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, eVar) == null) {
            this.c.a = eVar;
            a();
        }
    }

    public void setAutoStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.g = z;
            a();
        }
    }

    public void setBaseAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.a.setAlpha((int) (Math.min(1.0f, Math.max(0.0f, f2)) * 255.0f));
            a();
        }
    }

    public void setDropoff(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            this.c.c = f2;
            a();
        }
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.h = i;
            a();
        }
    }

    public void setFixedHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.c.e = i;
            a();
        }
    }

    public void setFixedWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.c.d = i;
            a();
        }
    }

    public void setIntensity(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            this.c.f = f2;
            a();
        }
    }

    public void setMaskShape(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, fVar) == null) {
            this.c.i = fVar;
            a();
        }
    }

    public void setRelativeHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.c.h = i;
            a();
        }
    }

    public void setRelativeWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.c.g = i;
            a();
        }
    }

    public void setRepeatCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.i = i;
            a();
        }
    }

    public void setRepeatDelay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.j = i;
            a();
        }
    }

    public void setRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.k = i;
            a();
        }
    }

    public void setTilt(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048612, this, f2) == null) {
            this.c.b = f2;
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.n && getWidth() > 0 && getHeight() > 0) {
                if (this.f == null) {
                    this.f = d();
                }
                Bitmap bitmap = this.f;
                if (this.e == null) {
                    this.e = d();
                }
                Bitmap bitmap2 = this.e;
                if (bitmap != null && bitmap2 != null) {
                    Canvas canvas2 = new Canvas(bitmap);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    super.dispatchDraw(canvas2);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.a);
                    Canvas canvas3 = new Canvas(bitmap2);
                    Bitmap maskBitmap = getMaskBitmap();
                    if (maskBitmap != null) {
                        int i = this.l;
                        canvas3.clipRect(i, this.m, maskBitmap.getWidth() + i, this.m + maskBitmap.getHeight());
                        canvas3.drawColor(0, PorterDuff.Mode.CLEAR);
                        super.dispatchDraw(canvas3);
                        canvas3.drawBitmap(maskBitmap, this.l, this.m, this.b);
                    }
                    canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                    return;
                }
                return;
            }
            super.dispatchDraw(canvas);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setDuration(1200);
            setRepeatCount(-1);
            setRepeatDelay(0);
            setRepeatMode(1);
            d dVar = this.c;
            dVar.a = e.a;
            dVar.i = f.a;
            dVar.c = 0.5f;
            dVar.d = 0;
            dVar.e = 0;
            dVar.f = 0.0f;
            dVar.g = 1.0f;
            dVar.h = 1.0f;
            dVar.b = 340.0f;
            this.d = new g();
            setBaseAlpha(1.0f);
            a();
        }
    }
}
