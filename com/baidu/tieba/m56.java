package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class m56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends k46> T a(l46 l46Var, Class<T> type, p0 entity, d46 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, l46Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(l46Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = l46Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(l46 l46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l46Var)) == null) {
            Intrinsics.checkNotNullParameter(l46Var, "<this>");
            return d(l46Var).a();
        }
        return invokeL.longValue;
    }

    public static final d66 c(l46 l46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, l46Var)) == null) {
            Intrinsics.checkNotNullParameter(l46Var, "<this>");
            return l46Var.i().d();
        }
        return (d66) invokeL.objValue;
    }

    public static final g66 d(l46 l46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l46Var)) == null) {
            Intrinsics.checkNotNullParameter(l46Var, "<this>");
            return l46Var.i().f();
        }
        return (g66) invokeL.objValue;
    }

    public static final boolean e(l46 l46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, l46Var)) == null) {
            Intrinsics.checkNotNullParameter(l46Var, "<this>");
            o0 f = l46Var.f();
            j46 j46Var = f instanceof j46 ? (j46) f : null;
            if (j46Var == null) {
                return true;
            }
            return j46Var.x();
        }
        return invokeL.booleanValue;
    }
}
