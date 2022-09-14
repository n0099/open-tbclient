package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class n56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final s46 a(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (s46) p0Var.d(s46.class);
        }
        return (s46) invokeL.objValue;
    }

    public static final p46 b(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (p46) p0Var.d(p46.class);
        }
        return (p46) invokeL.objValue;
    }

    public static final long c(p0 p0Var) {
        InterceptResult invokeL;
        d46 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            p46 b = b(p0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final o46 d(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (o46) p0Var.d(o46.class);
        }
        return (o46) invokeL.objValue;
    }

    public static final q46 e(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (q46) p0Var.d(q46.class);
        }
        return (q46) invokeL.objValue;
    }

    public static final long f(p0 p0Var) {
        InterceptResult invokeL;
        d46 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            p46 b = b(p0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(p0 p0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, p0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return j - f(p0Var) < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(p0 p0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, p0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return j - f(p0Var) > c(p0Var);
        }
        return invokeLJ.booleanValue;
    }
}
