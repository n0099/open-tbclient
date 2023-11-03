package com.baidu.tieba;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.angcyo.tablayout.AbsDslDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public class j0 extends AbsDslDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float[] h;
    public int[] i;
    public float[] j;
    public float k;
    public float l;
    public float m;
    public GradientDrawable.Orientation n;
    public int o;
    public Drawable p;
    public int q;
    public int r;

    public j0() {
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
        this.h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.k = 0.5f;
        this.l = 0.5f;
        this.m = 0.5f;
        this.n = GradientDrawable.Orientation.LEFT_RIGHT;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.c == 0 && this.d == 0 && this.i == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        InterceptResult invokeV;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Drawable drawable = this.p;
            if (drawable != null) {
                iArr = drawable.getState();
            } else {
                iArr = null;
            }
            if (iArr == null) {
                int[] state = super.getState();
                Intrinsics.checkNotNullExpressionValue(state, "super.getState()");
                return state;
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public final int[] r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.i;
        }
        return (int[]) invokeV.objValue;
    }

    public final float s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.g;
        }
        return invokeV.floatValue;
    }

    public final float t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f;
        }
        return invokeV.floatValue;
    }

    public final float[] u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.h;
        }
        return (float[]) invokeV.objValue;
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final Drawable z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.p;
        }
        return (Drawable) invokeV.objValue;
    }

    public final void B(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr) == null) {
            this.i = iArr;
        }
    }

    public final void C(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.g = f;
        }
    }

    public final void D(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.f = f;
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.r = i;
        }
    }

    public final void F(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fArr) == null) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.h = fArr;
        }
    }

    public final void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b = i;
        }
    }

    public final void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c = i;
        }
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
        }
    }

    public final void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.e = i;
        }
    }

    public final void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.q = i;
        }
    }

    public final void L(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.p = drawable;
        }
    }

    public j0 p(Function1<? super j0, Unit> config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, config)) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            config.invoke(this);
            M();
            return this;
        }
        return (j0) invokeL.objValue;
    }

    public final void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            Arrays.fill(this.h, f);
        }
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, colorFilter) == null) {
            super.setColorFilter(colorFilter);
            Drawable drawable = this.p;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, stateSet)) == null) {
            Intrinsics.checkNotNullParameter(stateSet, "stateSet");
            Drawable drawable = this.p;
            if (drawable != null) {
                return drawable.setState(stateSet);
            }
            return super.setState(stateSet);
        }
        return invokeL.booleanValue;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, colorStateList) == null) {
            super.setTintList(colorStateList);
            if (Build.VERSION.SDK_INT >= 21 && (drawable = this.p) != null) {
                drawable.setTintList(colorStateList);
            }
        }
    }

    public GradientDrawable M() {
        InterceptResult invokeV;
        GradientDrawable gradientDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Drawable drawable = this.p;
            if (drawable == null) {
                gradientDrawable = new GradientDrawable();
            } else if (drawable instanceof GradientDrawable) {
                if (drawable != null) {
                    gradientDrawable = (GradientDrawable) drawable;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            } else {
                gradientDrawable = null;
            }
            if (gradientDrawable != null) {
                gradientDrawable.setBounds(getBounds());
                gradientDrawable.setShape(this.b);
                gradientDrawable.setStroke(this.e, this.d, this.f, this.g);
                gradientDrawable.setColor(this.c);
                gradientDrawable.setCornerRadii(this.h);
                if (this.i != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        gradientDrawable.setGradientCenter(this.k, this.l);
                    }
                    gradientDrawable.setGradientRadius(this.m);
                    gradientDrawable.setGradientType(this.o);
                    if (Build.VERSION.SDK_INT >= 21) {
                        gradientDrawable.setOrientation(this.n);
                    }
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 29) {
                        gradientDrawable.setColors(this.i, this.j);
                    } else if (i >= 16) {
                        gradientDrawable.setColors(this.i);
                    }
                }
                this.p = gradientDrawable;
                gradientDrawable.invalidateSelf();
            }
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
            Drawable drawable = this.p;
            if (drawable != null) {
                drawable.setBounds(getBounds().left - (this.q / 2), getBounds().top - (this.r / 2), getBounds().right + (this.q / 2), getBounds().bottom + (this.r / 2));
                drawable.draw(canvas);
            }
        }
    }

    public final int[] n(String str) {
        InterceptResult invokeL;
        boolean z;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            int size = split$default.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                String str2 = (String) split$default.get(i);
                if (StringsKt__StringsJVMKt.startsWith$default(str2, "#", false, 2, null)) {
                    parseInt = Color.parseColor(str2);
                } else {
                    parseInt = Integer.parseInt(str2);
                }
                iArr[i] = parseInt;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public final void o(float[] array, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, array, str) == null) {
            Intrinsics.checkNotNullParameter(array, "array");
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            if (split$default.size() == 8) {
                float f = Resources.getSystem().getDisplayMetrics().density;
                int size = split$default.size();
                for (int i = 0; i < size; i++) {
                    array[i] = Float.parseFloat((String) split$default.get(i)) * f;
                }
                return;
            }
            throw new IllegalArgumentException("radii 需要8个值.");
        }
    }
}
