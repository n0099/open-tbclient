package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class rc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final wb6 a(q0 q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, q0Var)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            return (wb6) q0Var.d(wb6.class);
        }
        return (wb6) invokeL.objValue;
    }

    public static final tb6 b(q0 q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, q0Var)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            return (tb6) q0Var.d(tb6.class);
        }
        return (tb6) invokeL.objValue;
    }

    public static final long c(q0 q0Var) {
        InterceptResult invokeL;
        hb6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, q0Var)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            tb6 b = b(q0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final sb6 d(q0 q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, q0Var)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            return (sb6) q0Var.d(sb6.class);
        }
        return (sb6) invokeL.objValue;
    }

    public static final ub6 e(q0 q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, q0Var)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            return (ub6) q0Var.d(ub6.class);
        }
        return (ub6) invokeL.objValue;
    }

    public static final long f(q0 q0Var) {
        InterceptResult invokeL;
        hb6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, q0Var)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            tb6 b = b(q0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(q0 q0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, q0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            if (j - f(q0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(q0 q0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, q0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(q0Var, "<this>");
            if (j - f(q0Var) > c(q0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
