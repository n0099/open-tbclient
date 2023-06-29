package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ru6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends pt6> T a(qt6 qt6Var, Class<T> type, h0 entity, it6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, qt6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(qt6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            g0 f = qt6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(qt6 qt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qt6Var)) == null) {
            Intrinsics.checkNotNullParameter(qt6Var, "<this>");
            return d(qt6Var).a();
        }
        return invokeL.longValue;
    }

    public static final iv6 c(qt6 qt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qt6Var)) == null) {
            Intrinsics.checkNotNullParameter(qt6Var, "<this>");
            return qt6Var.i().d();
        }
        return (iv6) invokeL.objValue;
    }

    public static final lv6 d(qt6 qt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qt6Var)) == null) {
            Intrinsics.checkNotNullParameter(qt6Var, "<this>");
            return qt6Var.i().f();
        }
        return (lv6) invokeL.objValue;
    }

    public static final boolean e(qt6 qt6Var) {
        InterceptResult invokeL;
        ot6 ot6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qt6Var)) == null) {
            Intrinsics.checkNotNullParameter(qt6Var, "<this>");
            g0 f = qt6Var.f();
            if (f instanceof ot6) {
                ot6Var = (ot6) f;
            } else {
                ot6Var = null;
            }
            if (ot6Var != null) {
                return ot6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
