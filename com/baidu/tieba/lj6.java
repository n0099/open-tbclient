package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class lj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ji6> T a(ki6 ki6Var, Class<T> type, y entity, ci6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ki6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(ki6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x f = ki6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(ki6 ki6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ki6Var)) == null) {
            Intrinsics.checkNotNullParameter(ki6Var, "<this>");
            return d(ki6Var).a();
        }
        return invokeL.longValue;
    }

    public static final ck6 c(ki6 ki6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ki6Var)) == null) {
            Intrinsics.checkNotNullParameter(ki6Var, "<this>");
            return ki6Var.i().d();
        }
        return (ck6) invokeL.objValue;
    }

    public static final fk6 d(ki6 ki6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ki6Var)) == null) {
            Intrinsics.checkNotNullParameter(ki6Var, "<this>");
            return ki6Var.i().f();
        }
        return (fk6) invokeL.objValue;
    }

    public static final boolean e(ki6 ki6Var) {
        InterceptResult invokeL;
        ii6 ii6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ki6Var)) == null) {
            Intrinsics.checkNotNullParameter(ki6Var, "<this>");
            x f = ki6Var.f();
            if (f instanceof ii6) {
                ii6Var = (ii6) f;
            } else {
                ii6Var = null;
            }
            if (ii6Var != null) {
                return ii6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
