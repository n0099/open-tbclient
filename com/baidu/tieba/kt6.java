package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ps6 a(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ps6) y0Var.d(ps6.class);
        }
        return (ps6) invokeL.objValue;
    }

    public static final ms6 b(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ms6) y0Var.d(ms6.class);
        }
        return (ms6) invokeL.objValue;
    }

    public static final long c(y0 y0Var) {
        InterceptResult invokeL;
        as6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            ms6 b = b(y0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final ls6 d(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ls6) y0Var.d(ls6.class);
        }
        return (ls6) invokeL.objValue;
    }

    public static final ns6 e(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ns6) y0Var.d(ns6.class);
        }
        return (ns6) invokeL.objValue;
    }

    public static final long f(y0 y0Var) {
        InterceptResult invokeL;
        as6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            ms6 b = b(y0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(y0 y0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, y0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            if (j - f(y0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(y0 y0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, y0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            if (j - f(y0Var) > c(y0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
