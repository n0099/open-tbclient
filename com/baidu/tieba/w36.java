package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class w36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends u26> T a(v26 v26Var, Class<T> type, o0 entity, n26 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, v26Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(v26Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            n0 f = v26Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(v26 v26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v26Var)) == null) {
            Intrinsics.checkNotNullParameter(v26Var, "<this>");
            return d(v26Var).a();
        }
        return invokeL.longValue;
    }

    public static final n46 c(v26 v26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v26Var)) == null) {
            Intrinsics.checkNotNullParameter(v26Var, "<this>");
            return v26Var.i().d();
        }
        return (n46) invokeL.objValue;
    }

    public static final q46 d(v26 v26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, v26Var)) == null) {
            Intrinsics.checkNotNullParameter(v26Var, "<this>");
            return v26Var.i().f();
        }
        return (q46) invokeL.objValue;
    }

    public static final boolean e(v26 v26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v26Var)) == null) {
            Intrinsics.checkNotNullParameter(v26Var, "<this>");
            n0 f = v26Var.f();
            t26 t26Var = f instanceof t26 ? (t26) f : null;
            if (t26Var == null) {
                return true;
            }
            return t26Var.x();
        }
        return invokeL.booleanValue;
    }
}
