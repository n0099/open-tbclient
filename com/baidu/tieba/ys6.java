package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class ys6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends wr6> T a(xr6 xr6Var, Class<T> type, y0 entity, pr6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, xr6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(xr6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x0 f = xr6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(xr6 xr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xr6Var)) == null) {
            Intrinsics.checkNotNullParameter(xr6Var, "<this>");
            return d(xr6Var).a();
        }
        return invokeL.longValue;
    }

    public static final pt6 c(xr6 xr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xr6Var)) == null) {
            Intrinsics.checkNotNullParameter(xr6Var, "<this>");
            return xr6Var.j().d();
        }
        return (pt6) invokeL.objValue;
    }

    public static final st6 d(xr6 xr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xr6Var)) == null) {
            Intrinsics.checkNotNullParameter(xr6Var, "<this>");
            return xr6Var.j().f();
        }
        return (st6) invokeL.objValue;
    }

    public static final boolean e(xr6 xr6Var) {
        InterceptResult invokeL;
        vr6 vr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xr6Var)) == null) {
            Intrinsics.checkNotNullParameter(xr6Var, "<this>");
            x0 f = xr6Var.f();
            if (f instanceof vr6) {
                vr6Var = (vr6) f;
            } else {
                vr6Var = null;
            }
            if (vr6Var != null) {
                return vr6Var.y();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
