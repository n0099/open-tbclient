package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class z36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e36 a(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (e36) o0Var.d(e36.class);
        }
        return (e36) invokeL.objValue;
    }

    public static final b36 b(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (b36) o0Var.d(b36.class);
        }
        return (b36) invokeL.objValue;
    }

    public static final long c(o0 o0Var) {
        InterceptResult invokeL;
        p26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            b36 b = b(o0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final a36 d(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (a36) o0Var.d(a36.class);
        }
        return (a36) invokeL.objValue;
    }

    public static final c36 e(o0 o0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            return (c36) o0Var.d(c36.class);
        }
        return (c36) invokeL.objValue;
    }

    public static final long f(o0 o0Var) {
        InterceptResult invokeL;
        p26 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, o0Var)) == null) {
            Intrinsics.checkNotNullParameter(o0Var, "<this>");
            b36 b = b(o0Var);
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
