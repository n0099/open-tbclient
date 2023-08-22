package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final vu6 a(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (vu6) h0Var.d(vu6.class);
        }
        return (vu6) invokeL.objValue;
    }

    public static final su6 b(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (su6) h0Var.d(su6.class);
        }
        return (su6) invokeL.objValue;
    }

    public static final long c(h0 h0Var) {
        InterceptResult invokeL;
        gu6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            su6 b = b(h0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final ru6 d(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (ru6) h0Var.d(ru6.class);
        }
        return (ru6) invokeL.objValue;
    }

    public static final tu6 e(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (tu6) h0Var.d(tu6.class);
        }
        return (tu6) invokeL.objValue;
    }

    public static final long f(h0 h0Var) {
        InterceptResult invokeL;
        gu6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            su6 b = b(h0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(h0 h0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, h0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            if (j - f(h0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(h0 h0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, h0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            if (j - f(h0Var) > c(h0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
