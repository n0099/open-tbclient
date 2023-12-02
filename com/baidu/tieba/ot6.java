package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ot6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ts6 a(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ts6) y0Var.d(ts6.class);
        }
        return (ts6) invokeL.objValue;
    }

    public static final qs6 b(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (qs6) y0Var.d(qs6.class);
        }
        return (qs6) invokeL.objValue;
    }

    public static final long c(y0 y0Var) {
        InterceptResult invokeL;
        es6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            qs6 b = b(y0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final ps6 d(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ps6) y0Var.d(ps6.class);
        }
        return (ps6) invokeL.objValue;
    }

    public static final rs6 e(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (rs6) y0Var.d(rs6.class);
        }
        return (rs6) invokeL.objValue;
    }

    public static final long f(y0 y0Var) {
        InterceptResult invokeL;
        es6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            qs6 b = b(y0Var);
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
