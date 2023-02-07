package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class zn0 {
    public static /* synthetic */ Interceptable $ic;
    public static eo0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static co0 a(eo0 eo0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eo0Var)) == null) {
            if (eo0Var instanceof co0) {
                return (co0) eo0Var;
            }
            return null;
        }
        return (co0) invokeL.objValue;
    }

    public static fo0 b(eo0 eo0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eo0Var)) == null) {
            if (eo0Var instanceof fo0) {
                return (fo0) eo0Var;
            }
            return null;
        }
        return (fo0) invokeL.objValue;
    }

    public static void c(@NonNull eo0 eo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eo0Var) == null) {
            synchronized (eo0.class) {
                if (a != null) {
                    return;
                }
                a = eo0Var;
            }
        }
    }

    public static void f(do0 do0Var) {
        fo0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, do0Var) == null) && (b = b(a)) != null) {
            b.b(do0Var);
        }
    }

    public static void g(do0 do0Var) {
        fo0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, do0Var) == null) && (b = b(a)) != null) {
            b.d(do0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            co0 a2 = a(a);
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
            co0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
