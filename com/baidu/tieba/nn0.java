package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class nn0 {
    public static /* synthetic */ Interceptable $ic;
    public static sn0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static qn0 a(sn0 sn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sn0Var)) == null) {
            if (sn0Var instanceof qn0) {
                return (qn0) sn0Var;
            }
            return null;
        }
        return (qn0) invokeL.objValue;
    }

    public static tn0 b(sn0 sn0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sn0Var)) == null) {
            if (sn0Var instanceof tn0) {
                return (tn0) sn0Var;
            }
            return null;
        }
        return (tn0) invokeL.objValue;
    }

    public static void c(@NonNull sn0 sn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, sn0Var) == null) {
            synchronized (sn0.class) {
                if (a != null) {
                    return;
                }
                a = sn0Var;
            }
        }
    }

    public static void f(rn0 rn0Var) {
        tn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, rn0Var) == null) && (b = b(a)) != null) {
            b.b(rn0Var);
        }
    }

    public static void g(rn0 rn0Var) {
        tn0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, rn0Var) == null) && (b = b(a)) != null) {
            b.d(rn0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            qn0 a2 = a(a);
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
            qn0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
