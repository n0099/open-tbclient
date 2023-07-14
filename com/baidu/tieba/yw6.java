package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class yw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final dw6 a(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (dw6) h0Var.d(dw6.class);
        }
        return (dw6) invokeL.objValue;
    }

    public static final aw6 b(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (aw6) h0Var.d(aw6.class);
        }
        return (aw6) invokeL.objValue;
    }

    public static final long c(h0 h0Var) {
        InterceptResult invokeL;
        ov6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            aw6 b = b(h0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final zv6 d(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (zv6) h0Var.d(zv6.class);
        }
        return (zv6) invokeL.objValue;
    }

    public static final bw6 e(h0 h0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            return (bw6) h0Var.d(bw6.class);
        }
        return (bw6) invokeL.objValue;
    }

    public static final long f(h0 h0Var) {
        InterceptResult invokeL;
        ov6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, h0Var)) == null) {
            Intrinsics.checkNotNullParameter(h0Var, "<this>");
            aw6 b = b(h0Var);
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
