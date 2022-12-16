package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class z86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e86 a(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (e86) p0Var.d(e86.class);
        }
        return (e86) invokeL.objValue;
    }

    public static final b86 b(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (b86) p0Var.d(b86.class);
        }
        return (b86) invokeL.objValue;
    }

    public static final long c(p0 p0Var) {
        InterceptResult invokeL;
        p76 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            b86 b = b(p0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final a86 d(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (a86) p0Var.d(a86.class);
        }
        return (a86) invokeL.objValue;
    }

    public static final c86 e(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (c86) p0Var.d(c86.class);
        }
        return (c86) invokeL.objValue;
    }

    public static final long f(p0 p0Var) {
        InterceptResult invokeL;
        p76 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            b86 b = b(p0Var);
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
            if (j - f(p0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(p0 p0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, p0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            if (j - f(p0Var) > c(p0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
