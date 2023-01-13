package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class qc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ob6> T a(pb6 pb6Var, Class<T> type, q0 entity, hb6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, pb6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(pb6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            p0 f = pb6Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(pb6 pb6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pb6Var)) == null) {
            Intrinsics.checkNotNullParameter(pb6Var, "<this>");
            return d(pb6Var).a();
        }
        return invokeL.longValue;
    }

    public static final hd6 c(pb6 pb6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pb6Var)) == null) {
            Intrinsics.checkNotNullParameter(pb6Var, "<this>");
            return pb6Var.i().d();
        }
        return (hd6) invokeL.objValue;
    }

    public static final kd6 d(pb6 pb6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, pb6Var)) == null) {
            Intrinsics.checkNotNullParameter(pb6Var, "<this>");
            return pb6Var.i().f();
        }
        return (kd6) invokeL.objValue;
    }

    public static final boolean e(pb6 pb6Var) {
        InterceptResult invokeL;
        nb6 nb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pb6Var)) == null) {
            Intrinsics.checkNotNullParameter(pb6Var, "<this>");
            p0 f = pb6Var.f();
            if (f instanceof nb6) {
                nb6Var = (nb6) f;
            } else {
                nb6Var = null;
            }
            if (nb6Var == null) {
                return true;
            }
            return nb6Var.x();
        }
        return invokeL.booleanValue;
    }
}
