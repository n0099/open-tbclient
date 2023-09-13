package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends rv6> T a(sv6 sv6Var, Class<T> type, i0 entity, kv6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, sv6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(sv6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            h0 f = sv6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(sv6 sv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sv6Var)) == null) {
            Intrinsics.checkNotNullParameter(sv6Var, "<this>");
            return d(sv6Var).a();
        }
        return invokeL.longValue;
    }

    public static final kx6 c(sv6 sv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sv6Var)) == null) {
            Intrinsics.checkNotNullParameter(sv6Var, "<this>");
            return sv6Var.i().d();
        }
        return (kx6) invokeL.objValue;
    }

    public static final nx6 d(sv6 sv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sv6Var)) == null) {
            Intrinsics.checkNotNullParameter(sv6Var, "<this>");
            return sv6Var.i().f();
        }
        return (nx6) invokeL.objValue;
    }

    public static final boolean e(sv6 sv6Var) {
        InterceptResult invokeL;
        qv6 qv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sv6Var)) == null) {
            Intrinsics.checkNotNullParameter(sv6Var, "<this>");
            h0 f = sv6Var.f();
            if (f instanceof qv6) {
                qv6Var = (qv6) f;
            } else {
                qv6Var = null;
            }
            if (qv6Var != null) {
                return qv6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
