package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class nj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends li6> T a(mi6 mi6Var, Class<T> type, v0 entity, ei6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, mi6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(mi6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            u0 f = mi6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(mi6 mi6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mi6Var)) == null) {
            Intrinsics.checkNotNullParameter(mi6Var, "<this>");
            return d(mi6Var).a();
        }
        return invokeL.longValue;
    }

    public static final ek6 c(mi6 mi6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mi6Var)) == null) {
            Intrinsics.checkNotNullParameter(mi6Var, "<this>");
            return mi6Var.i().d();
        }
        return (ek6) invokeL.objValue;
    }

    public static final hk6 d(mi6 mi6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mi6Var)) == null) {
            Intrinsics.checkNotNullParameter(mi6Var, "<this>");
            return mi6Var.i().f();
        }
        return (hk6) invokeL.objValue;
    }

    public static final boolean e(mi6 mi6Var) {
        InterceptResult invokeL;
        ki6 ki6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mi6Var)) == null) {
            Intrinsics.checkNotNullParameter(mi6Var, "<this>");
            u0 f = mi6Var.f();
            if (f instanceof ki6) {
                ki6Var = (ki6) f;
            } else {
                ki6Var = null;
            }
            if (ki6Var != null) {
                return ki6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
