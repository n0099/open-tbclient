package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class mj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ri6 a(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yVar)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            return (ri6) yVar.d(ri6.class);
        }
        return (ri6) invokeL.objValue;
    }

    public static final oi6 b(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yVar)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            return (oi6) yVar.d(oi6.class);
        }
        return (oi6) invokeL.objValue;
    }

    public static final long c(y yVar) {
        InterceptResult invokeL;
        ci6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yVar)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            oi6 b = b(yVar);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final ni6 d(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yVar)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            return (ni6) yVar.d(ni6.class);
        }
        return (ni6) invokeL.objValue;
    }

    public static final pi6 e(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yVar)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            return (pi6) yVar.d(pi6.class);
        }
        return (pi6) invokeL.objValue;
    }

    public static final long f(y yVar) {
        InterceptResult invokeL;
        ci6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, yVar)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            oi6 b = b(yVar);
            if (b != null && (a = b.a()) != null) {
                return a.k();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(y yVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, yVar, j)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            if (j - f(yVar) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(y yVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, yVar, j)) == null) {
            Intrinsics.checkNotNullParameter(yVar, "<this>");
            if (j - f(yVar) > c(yVar)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
