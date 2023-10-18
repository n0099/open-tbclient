package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final oq6 a(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (oq6) i0Var.d(oq6.class);
        }
        return (oq6) invokeL.objValue;
    }

    public static final lq6 b(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (lq6) i0Var.d(lq6.class);
        }
        return (lq6) invokeL.objValue;
    }

    public static final long c(i0 i0Var) {
        InterceptResult invokeL;
        zp6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            lq6 b = b(i0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final kq6 d(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (kq6) i0Var.d(kq6.class);
        }
        return (kq6) invokeL.objValue;
    }

    public static final mq6 e(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (mq6) i0Var.d(mq6.class);
        }
        return (mq6) invokeL.objValue;
    }

    public static final long f(i0 i0Var) {
        InterceptResult invokeL;
        zp6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            lq6 b = b(i0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(i0 i0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, i0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            if (j - f(i0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(i0 i0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, i0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            if (j - f(i0Var) > c(i0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
