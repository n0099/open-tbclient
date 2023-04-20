package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class vm0 {
    public static /* synthetic */ Interceptable $ic;
    public static an0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ym0 a(an0 an0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, an0Var)) == null) {
            if (an0Var instanceof ym0) {
                return (ym0) an0Var;
            }
            return null;
        }
        return (ym0) invokeL.objValue;
    }

    public static bn0 b(an0 an0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, an0Var)) == null) {
            if (an0Var instanceof bn0) {
                return (bn0) an0Var;
            }
            return null;
        }
        return (bn0) invokeL.objValue;
    }

    public static void c(@NonNull an0 an0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, an0Var) == null) {
            synchronized (an0.class) {
                if (a != null) {
                    return;
                }
                a = an0Var;
            }
        }
    }

    public static void f(zm0 zm0Var) {
        bn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, zm0Var) == null) && (b = b(a)) != null) {
            b.b(zm0Var);
        }
    }

    public static void g(zm0 zm0Var) {
        bn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, zm0Var) == null) && (b = b(a)) != null) {
            b.d(zm0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ym0 a2 = a(a);
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
            ym0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
