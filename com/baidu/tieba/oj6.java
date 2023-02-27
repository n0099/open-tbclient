package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class oj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ti6 a(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (ti6) v0Var.d(ti6.class);
        }
        return (ti6) invokeL.objValue;
    }

    public static final qi6 b(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (qi6) v0Var.d(qi6.class);
        }
        return (qi6) invokeL.objValue;
    }

    public static final long c(v0 v0Var) {
        InterceptResult invokeL;
        ei6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            qi6 b = b(v0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final pi6 d(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (pi6) v0Var.d(pi6.class);
        }
        return (pi6) invokeL.objValue;
    }

    public static final ri6 e(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (ri6) v0Var.d(ri6.class);
        }
        return (ri6) invokeL.objValue;
    }

    public static final long f(v0 v0Var) {
        InterceptResult invokeL;
        ei6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            qi6 b = b(v0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(v0 v0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, v0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            if (j - f(v0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(v0 v0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, v0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            if (j - f(v0Var) > c(v0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
