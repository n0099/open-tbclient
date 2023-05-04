package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class xm0 {
    public static /* synthetic */ Interceptable $ic;
    public static cn0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static an0 a(cn0 cn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cn0Var)) == null) {
            if (cn0Var instanceof an0) {
                return (an0) cn0Var;
            }
            return null;
        }
        return (an0) invokeL.objValue;
    }

    public static dn0 b(cn0 cn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cn0Var)) == null) {
            if (cn0Var instanceof dn0) {
                return (dn0) cn0Var;
            }
            return null;
        }
        return (dn0) invokeL.objValue;
    }

    public static void c(@NonNull cn0 cn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cn0Var) == null) {
            synchronized (cn0.class) {
                if (a != null) {
                    return;
                }
                a = cn0Var;
            }
        }
    }

    public static void f(bn0 bn0Var) {
        dn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, bn0Var) == null) && (b = b(a)) != null) {
            b.b(bn0Var);
        }
    }

    public static void g(bn0 bn0Var) {
        dn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, bn0Var) == null) && (b = b(a)) != null) {
            b.d(bn0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            an0 a2 = a(a);
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
            an0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
