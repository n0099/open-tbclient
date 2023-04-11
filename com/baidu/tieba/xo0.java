package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a41;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class xo0 {
    public static /* synthetic */ Interceptable $ic;
    public static final xo0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948306960, "Lcom/baidu/tieba/xo0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948306960, "Lcom/baidu/tieba/xo0;");
                return;
            }
        }
        a = new xo0();
    }

    public xo0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void a(@NonNull FrameLayout.LayoutParams layoutParams, int i, int i2, double d, double d2, boolean z, double d3) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{layoutParams, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Double.valueOf(d3)}) == null) {
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            if (d2 > 0 && i > 0 && i2 > 0) {
                layoutParams.width = c(i, i2, d, d2, z);
                layoutParams.height = b(i, i2, d, d2, z);
                int g = g(d2, i2, d3);
                if (g >= 0) {
                    layoutParams.topMargin = g;
                }
                if (g < 0 && !z) {
                    i3 = 17;
                } else {
                    i3 = 48;
                }
                layoutParams.gravity = i3;
            }
        }
    }

    public final int b(int i, int i2, double d, double d2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z)})) == null) {
            int max = Math.max(i2 - f(d, z), 0);
            if (d2 >= 1.77d && z) {
                if (d <= 2.0d && d >= 1.3d && d2 > d) {
                    return d(i, i2, d2);
                }
                return max;
            }
            return d(i, i2, d2);
        }
        return invokeCommon.intValue;
    }

    public final int c(int i, int i2, double d, double d2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z)})) == null) {
            if (d2 >= 1.77d && z) {
                if (d > 2.0d) {
                    return e(i, i2, d2);
                }
                if (d < 1.3d) {
                    return e(i, i2, d2);
                }
                if (d2 <= d) {
                    return e(i, i2, d2);
                }
                return i;
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public final int d(int i, int i2, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d)})) == null) {
            if (i > 0 && i2 > 0 && d > 0) {
                return Math.min((int) (i * d), i2);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final int e(int i, int i2, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d)})) == null) {
            if (i > 0 && i2 > 0 && d > 0) {
                return Math.min((int) (i2 / d), i);
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public final int f(double d, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d), Boolean.valueOf(z)})) == null) {
            if (z && d > 2.0d) {
                return a41.c.a(ii0.b(), 52.0f);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public final int g(double d, int i, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d2)})) == null) {
            if (i > 0 && d2 >= 0 && d2 <= 1) {
                return Math.min((int) (i * d2), Math.max((int) ((i - a41.c.a(ii0.b(), 200)) - (a41.c.e(ii0.b()) * d)), 0));
            }
            return -1;
        }
        return invokeCommon.intValue;
    }
}
