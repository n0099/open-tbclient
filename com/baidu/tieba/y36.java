package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class y36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends w26> T a(x26 x26Var, Class<T> type, o0 entity, p26 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, x26Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(x26Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            n0 f = x26Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(x26 x26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x26Var)) == null) {
            Intrinsics.checkNotNullParameter(x26Var, "<this>");
            return d(x26Var).a();
        }
        return invokeL.longValue;
    }

    public static final p46 c(x26 x26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x26Var)) == null) {
            Intrinsics.checkNotNullParameter(x26Var, "<this>");
            return x26Var.i().d();
        }
        return (p46) invokeL.objValue;
    }

    public static final s46 d(x26 x26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x26Var)) == null) {
            Intrinsics.checkNotNullParameter(x26Var, "<this>");
            return x26Var.i().f();
        }
        return (s46) invokeL.objValue;
    }

    public static final boolean e(x26 x26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x26Var)) == null) {
            Intrinsics.checkNotNullParameter(x26Var, "<this>");
            n0 f = x26Var.f();
            v26 v26Var = f instanceof v26 ? (v26) f : null;
            if (v26Var == null) {
                return true;
            }
            return v26Var.x();
        }
        return invokeL.booleanValue;
    }
}
