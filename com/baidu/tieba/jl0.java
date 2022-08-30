package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class jl0 {
    public static /* synthetic */ Interceptable $ic;
    public static ol0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static ml0 a(ol0 ol0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ol0Var)) == null) {
            if (ol0Var instanceof ml0) {
                return (ml0) ol0Var;
            }
            return null;
        }
        return (ml0) invokeL.objValue;
    }

    public static pl0 b(ol0 ol0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ol0Var)) == null) {
            if (ol0Var instanceof pl0) {
                return (pl0) ol0Var;
            }
            return null;
        }
        return (pl0) invokeL.objValue;
    }

    public static void c(@NonNull ol0 ol0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ol0Var) == null) {
            synchronized (ol0.class) {
                if (a != null) {
                    return;
                }
                a = ol0Var;
            }
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ml0 a2 = a(a);
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
            ml0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }

    public static void f(nl0 nl0Var) {
        pl0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, nl0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.b(nl0Var);
    }

    public static void g(nl0 nl0Var) {
        pl0 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, nl0Var) == null) || (b = b(a)) == null) {
            return;
        }
        b.d(nl0Var);
    }
}
