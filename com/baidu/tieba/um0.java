package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class um0 {
    public static /* synthetic */ Interceptable $ic;
    public static zm0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static xm0 a(zm0 zm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zm0Var)) == null) {
            if (zm0Var instanceof xm0) {
                return (xm0) zm0Var;
            }
            return null;
        }
        return (xm0) invokeL.objValue;
    }

    public static an0 b(zm0 zm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zm0Var)) == null) {
            if (zm0Var instanceof an0) {
                return (an0) zm0Var;
            }
            return null;
        }
        return (an0) invokeL.objValue;
    }

    public static void c(@NonNull zm0 zm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zm0Var) == null) {
            synchronized (zm0.class) {
                if (a != null) {
                    return;
                }
                a = zm0Var;
            }
        }
    }

    public static void f(ym0 ym0Var) {
        an0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ym0Var) == null) && (b = b(a)) != null) {
            b.b(ym0Var);
        }
    }

    public static void g(ym0 ym0Var) {
        an0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, ym0Var) == null) && (b = b(a)) != null) {
            b.d(ym0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            xm0 a2 = a(a);
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
            xm0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
