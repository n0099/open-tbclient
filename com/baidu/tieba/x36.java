package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class x36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final c36 a(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (c36) o0Var.d(c36.class);
        }
        return (c36) invokeL.objValue;
    }

    public static final z26 b(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (z26) o0Var.d(z26.class);
        }
        return (z26) invokeL.objValue;
    }

    public static final long c(o0 o0Var) {
        InterceptResult invokeL;
        n26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            z26 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final y26 d(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (y26) o0Var.d(y26.class);
        }
        return (y26) invokeL.objValue;
    }

    public static final a36 e(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (a36) o0Var.d(a36.class);
        }
        return (a36) invokeL.objValue;
    }

    public static final long f(o0 o0Var) {
        InterceptResult invokeL;
        n26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            z26 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(o0 o0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, o0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return j - f(o0Var) < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(o0 o0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, o0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return j - f(o0Var) > c(o0Var);
        }
        return invokeLJ.booleanValue;
    }
}
