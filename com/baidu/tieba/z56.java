package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class z56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends x46> T a(y46 y46Var, Class<T> type, p0 entity, q46 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, y46Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(y46Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = y46Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(y46 y46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y46Var)) == null) {
            Intrinsics.checkNotNullParameter(y46Var, "<this>");
            return d(y46Var).a();
        }
        return invokeL.longValue;
    }

    public static final q66 c(y46 y46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y46Var)) == null) {
            Intrinsics.checkNotNullParameter(y46Var, "<this>");
            return y46Var.i().d();
        }
        return (q66) invokeL.objValue;
    }

    public static final t66 d(y46 y46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y46Var)) == null) {
            Intrinsics.checkNotNullParameter(y46Var, "<this>");
            return y46Var.i().f();
        }
        return (t66) invokeL.objValue;
    }

    public static final boolean e(y46 y46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, y46Var)) == null) {
            Intrinsics.checkNotNullParameter(y46Var, "<this>");
            o0 f = y46Var.f();
            w46 w46Var = f instanceof w46 ? (w46) f : null;
            if (w46Var == null) {
                return true;
            }
            return w46Var.x();
        }
        return invokeL.booleanValue;
    }
}
