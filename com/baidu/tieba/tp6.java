package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class tp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ro6> T a(so6 so6Var, Class<T> type, c0 entity, ko6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, so6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(so6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            b0 f = so6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(so6 so6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, so6Var)) == null) {
            Intrinsics.checkNotNullParameter(so6Var, "<this>");
            return d(so6Var).a();
        }
        return invokeL.longValue;
    }

    public static final kq6 c(so6 so6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, so6Var)) == null) {
            Intrinsics.checkNotNullParameter(so6Var, "<this>");
            return so6Var.i().d();
        }
        return (kq6) invokeL.objValue;
    }

    public static final nq6 d(so6 so6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, so6Var)) == null) {
            Intrinsics.checkNotNullParameter(so6Var, "<this>");
            return so6Var.i().f();
        }
        return (nq6) invokeL.objValue;
    }

    public static final boolean e(so6 so6Var) {
        InterceptResult invokeL;
        qo6 qo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, so6Var)) == null) {
            Intrinsics.checkNotNullParameter(so6Var, "<this>");
            b0 f = so6Var.f();
            if (f instanceof qo6) {
                qo6Var = (qo6) f;
            } else {
                qo6Var = null;
            }
            if (qo6Var != null) {
                return qo6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
