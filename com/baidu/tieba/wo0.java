package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class wo0 {
    public static /* synthetic */ Interceptable $ic;
    public static bp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static zo0 a(bp0 bp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bp0Var)) == null) {
            if (bp0Var instanceof zo0) {
                return (zo0) bp0Var;
            }
            return null;
        }
        return (zo0) invokeL.objValue;
    }

    public static cp0 b(bp0 bp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bp0Var)) == null) {
            if (bp0Var instanceof cp0) {
                return (cp0) bp0Var;
            }
            return null;
        }
        return (cp0) invokeL.objValue;
    }

    public static void c(@NonNull bp0 bp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bp0Var) == null) {
            synchronized (bp0.class) {
                if (a != null) {
                    return;
                }
                a = bp0Var;
            }
        }
    }

    public static void f(ap0 ap0Var) {
        cp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ap0Var) == null) && (b = b(a)) != null) {
            b.b(ap0Var);
        }
    }

    public static void g(ap0 ap0Var) {
        cp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, ap0Var) == null) && (b = b(a)) != null) {
            b.d(ap0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            zo0 a2 = a(a);
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
            zo0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
