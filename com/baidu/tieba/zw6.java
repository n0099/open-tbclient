package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends xv6> T a(yv6 yv6Var, Class<T> type, i0 entity, qv6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, yv6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(yv6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            h0 f = yv6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(yv6 yv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yv6Var)) == null) {
            Intrinsics.checkNotNullParameter(yv6Var, "<this>");
            return d(yv6Var).a();
        }
        return invokeL.longValue;
    }

    public static final qx6 c(yv6 yv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yv6Var)) == null) {
            Intrinsics.checkNotNullParameter(yv6Var, "<this>");
            return yv6Var.i().d();
        }
        return (qx6) invokeL.objValue;
    }

    public static final tx6 d(yv6 yv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yv6Var)) == null) {
            Intrinsics.checkNotNullParameter(yv6Var, "<this>");
            return yv6Var.i().f();
        }
        return (tx6) invokeL.objValue;
    }

    public static final boolean e(yv6 yv6Var) {
        InterceptResult invokeL;
        wv6 wv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yv6Var)) == null) {
            Intrinsics.checkNotNullParameter(yv6Var, "<this>");
            h0 f = yv6Var.f();
            if (f instanceof wv6) {
                wv6Var = (wv6) f;
            } else {
                wv6Var = null;
            }
            if (wv6Var != null) {
                return wv6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
