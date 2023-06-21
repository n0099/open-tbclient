package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final st6 a(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (st6) g0Var.d(st6.class);
        }
        return (st6) invokeL.objValue;
    }

    public static final pt6 b(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (pt6) g0Var.d(pt6.class);
        }
        return (pt6) invokeL.objValue;
    }

    public static final long c(g0 g0Var) {
        InterceptResult invokeL;
        dt6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            pt6 b = b(g0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final ot6 d(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (ot6) g0Var.d(ot6.class);
        }
        return (ot6) invokeL.objValue;
    }

    public static final qt6 e(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (qt6) g0Var.d(qt6.class);
        }
        return (qt6) invokeL.objValue;
    }

    public static final long f(g0 g0Var) {
        InterceptResult invokeL;
        dt6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            pt6 b = b(g0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(g0 g0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, g0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            if (j - f(g0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(g0 g0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, g0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            if (j - f(g0Var) > c(g0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
