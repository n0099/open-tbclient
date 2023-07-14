package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends vv6> T a(wv6 wv6Var, Class<T> type, h0 entity, ov6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, wv6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(wv6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            g0 f = wv6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(wv6 wv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wv6Var)) == null) {
            Intrinsics.checkNotNullParameter(wv6Var, "<this>");
            return d(wv6Var).a();
        }
        return invokeL.longValue;
    }

    public static final ox6 c(wv6 wv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, wv6Var)) == null) {
            Intrinsics.checkNotNullParameter(wv6Var, "<this>");
            return wv6Var.i().d();
        }
        return (ox6) invokeL.objValue;
    }

    public static final rx6 d(wv6 wv6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, wv6Var)) == null) {
            Intrinsics.checkNotNullParameter(wv6Var, "<this>");
            return wv6Var.i().f();
        }
        return (rx6) invokeL.objValue;
    }

    public static final boolean e(wv6 wv6Var) {
        InterceptResult invokeL;
        uv6 uv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, wv6Var)) == null) {
            Intrinsics.checkNotNullParameter(wv6Var, "<this>");
            g0 f = wv6Var.f();
            if (f instanceof uv6) {
                uv6Var = (uv6) f;
            } else {
                uv6Var = null;
            }
            if (uv6Var != null) {
                return uv6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
