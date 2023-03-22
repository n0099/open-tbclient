package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class tm0 {
    public static /* synthetic */ Interceptable $ic;
    public static ym0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static wm0 a(ym0 ym0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ym0Var)) == null) {
            if (ym0Var instanceof wm0) {
                return (wm0) ym0Var;
            }
            return null;
        }
        return (wm0) invokeL.objValue;
    }

    public static zm0 b(ym0 ym0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ym0Var)) == null) {
            if (ym0Var instanceof zm0) {
                return (zm0) ym0Var;
            }
            return null;
        }
        return (zm0) invokeL.objValue;
    }

    public static void c(@NonNull ym0 ym0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ym0Var) == null) {
            synchronized (ym0.class) {
                if (a != null) {
                    return;
                }
                a = ym0Var;
            }
        }
    }

    public static void f(xm0 xm0Var) {
        zm0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, xm0Var) == null) && (b = b(a)) != null) {
            b.b(xm0Var);
        }
    }

    public static void g(xm0 xm0Var) {
        zm0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, xm0Var) == null) && (b = b(a)) != null) {
            b.d(xm0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            wm0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            wm0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
