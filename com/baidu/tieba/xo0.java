package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class xo0 {
    public static /* synthetic */ Interceptable $ic;
    public static cp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ap0 a(cp0 cp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cp0Var)) == null) {
            if (cp0Var instanceof ap0) {
                return (ap0) cp0Var;
            }
            return null;
        }
        return (ap0) invokeL.objValue;
    }

    public static dp0 b(cp0 cp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cp0Var)) == null) {
            if (cp0Var instanceof dp0) {
                return (dp0) cp0Var;
            }
            return null;
        }
        return (dp0) invokeL.objValue;
    }

    public static void c(@NonNull cp0 cp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cp0Var) == null) {
            synchronized (cp0.class) {
                if (a != null) {
                    return;
                }
                a = cp0Var;
            }
        }
    }

    public static void f(bp0 bp0Var) {
        dp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, bp0Var) == null) && (b = b(a)) != null) {
            b.b(bp0Var);
        }
    }

    public static void g(bp0 bp0Var) {
        dp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, bp0Var) == null) && (b = b(a)) != null) {
            b.d(bp0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ap0 a2 = a(a);
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
            ap0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
