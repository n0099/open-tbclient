package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends nu6> T a(ou6 ou6Var, Class<T> type, h0 entity, gu6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ou6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(ou6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            g0 f = ou6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(ou6 ou6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ou6Var)) == null) {
            Intrinsics.checkNotNullParameter(ou6Var, "<this>");
            return d(ou6Var).a();
        }
        return invokeL.longValue;
    }

    public static final gw6 c(ou6 ou6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ou6Var)) == null) {
            Intrinsics.checkNotNullParameter(ou6Var, "<this>");
            return ou6Var.i().d();
        }
        return (gw6) invokeL.objValue;
    }

    public static final jw6 d(ou6 ou6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ou6Var)) == null) {
            Intrinsics.checkNotNullParameter(ou6Var, "<this>");
            return ou6Var.i().f();
        }
        return (jw6) invokeL.objValue;
    }

    public static final boolean e(ou6 ou6Var) {
        InterceptResult invokeL;
        mu6 mu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ou6Var)) == null) {
            Intrinsics.checkNotNullParameter(ou6Var, "<this>");
            g0 f = ou6Var.f();
            if (f instanceof mu6) {
                mu6Var = (mu6) f;
            } else {
                mu6Var = null;
            }
            if (mu6Var != null) {
                return mu6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
