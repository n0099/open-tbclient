package com.baidu.tieba;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.angcyo.tablayout.DslTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public class o0 extends j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;

    public o0() {
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
        this.s = r0.i() * 2;
        this.t = r0.i() * 2;
        this.y = 2;
    }

    public final int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public final int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.v;
        }
        return invokeV.intValue;
    }

    public final int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public final DslTabLayout T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getCallback() instanceof DslTabLayout) {
                Drawable.Callback callback = getCallback();
                if (callback != null) {
                    return (DslTabLayout) callback;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout");
            }
            return null;
        }
        return (DslTabLayout) invokeV.objValue;
    }

    public boolean U(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            DslTabLayout T2 = T();
            if (T2 != null && T2.k() && T2.l() && i == i2 - 1) {
                if ((this.y & 1) == 0) {
                    return false;
                }
                return true;
            } else if (i != i2 - 1 || (this.y & 4) == 0) {
                return false;
            } else {
                return true;
            }
        }
        return invokeII.booleanValue;
    }

    public boolean V(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            DslTabLayout T2 = T();
            if (T2 != null && T2.k() && T2.l()) {
                if (i == 0) {
                    if ((this.y & 4) == 0) {
                        return false;
                    }
                    return true;
                } else if ((this.y & 2) == 0) {
                    return false;
                } else {
                    return true;
                }
            } else if (i == 0) {
                if ((this.y & 1) == 0) {
                    return false;
                }
                return true;
            } else if ((this.y & 2) == 0) {
                return false;
            } else {
                return true;
            }
        }
        return invokeII.booleanValue;
    }

    @Override // com.baidu.tieba.j0, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
            Drawable z = z();
            if (z != null) {
                z.setBounds(getBounds());
                z.draw(canvas);
            }
        }
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.k(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ee7.DslTabLayout);
            this.s = obtainStyledAttributes.getDimensionPixelOffset(48, this.s);
            this.t = obtainStyledAttributes.getDimensionPixelOffset(38, this.t);
            this.u = obtainStyledAttributes.getDimensionPixelOffset(40, this.u);
            this.v = obtainStyledAttributes.getDimensionPixelOffset(41, this.v);
            this.w = obtainStyledAttributes.getDimensionPixelOffset(42, this.w);
            this.x = obtainStyledAttributes.getDimensionPixelOffset(39, this.x);
            if (obtainStyledAttributes.hasValue(45)) {
                H(obtainStyledAttributes.getColor(45, w()));
            } else if (obtainStyledAttributes.hasValue(32)) {
                H(obtainStyledAttributes.getColor(32, w()));
            } else {
                H(obtainStyledAttributes.getColor(36, w()));
            }
            I(obtainStyledAttributes.getColor(46, x()));
            J(obtainStyledAttributes.getDimensionPixelOffset(47, 0));
            q(obtainStyledAttributes.getDimensionPixelOffset(43, r0.i() * 2));
            L(obtainStyledAttributes.getDrawable(37));
            this.y = obtainStyledAttributes.getInt(44, this.y);
            obtainStyledAttributes.recycle();
            if (z() == null) {
                M();
            }
        }
    }
}
