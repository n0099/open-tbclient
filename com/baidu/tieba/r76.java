package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class r76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final w66 a(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (w66) p0Var.d(w66.class);
        }
        return (w66) invokeL.objValue;
    }

    public static final t66 b(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (t66) p0Var.d(t66.class);
        }
        return (t66) invokeL.objValue;
    }

    public static final long c(p0 p0Var) {
        InterceptResult invokeL;
        h66 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            t66 b = b(p0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final s66 d(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (s66) p0Var.d(s66.class);
        }
        return (s66) invokeL.objValue;
    }

    public static final u66 e(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (u66) p0Var.d(u66.class);
        }
        return (u66) invokeL.objValue;
    }

    public static final long f(p0 p0Var) {
        InterceptResult invokeL;
        h66 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            t66 b = b(p0Var);
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
