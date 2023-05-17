package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class up6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final zo6 a(c0 c0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, c0Var)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            return (zo6) c0Var.d(zo6.class);
        }
        return (zo6) invokeL.objValue;
    }

    public static final wo6 b(c0 c0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c0Var)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            return (wo6) c0Var.d(wo6.class);
        }
        return (wo6) invokeL.objValue;
    }

    public static final long c(c0 c0Var) {
        InterceptResult invokeL;
        ko6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c0Var)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            wo6 b = b(c0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final vo6 d(c0 c0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c0Var)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            return (vo6) c0Var.d(vo6.class);
        }
        return (vo6) invokeL.objValue;
    }

    public static final xo6 e(c0 c0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c0Var)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            return (xo6) c0Var.d(xo6.class);
        }
        return (xo6) invokeL.objValue;
    }

    public static final long f(c0 c0Var) {
        InterceptResult invokeL;
        ko6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, c0Var)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            wo6 b = b(c0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(c0 c0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, c0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            if (j - f(c0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(c0 c0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, c0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(c0Var, "<this>");
            if (j - f(c0Var) > c(c0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
