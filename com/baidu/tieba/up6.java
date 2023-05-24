package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class up6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends so6> T a(to6 to6Var, Class<T> type, c0 entity, lo6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, to6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(to6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            b0 f = to6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(to6 to6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, to6Var)) == null) {
            Intrinsics.checkNotNullParameter(to6Var, "<this>");
            return d(to6Var).a();
        }
        return invokeL.longValue;
    }

    public static final lq6 c(to6 to6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, to6Var)) == null) {
            Intrinsics.checkNotNullParameter(to6Var, "<this>");
            return to6Var.i().d();
        }
        return (lq6) invokeL.objValue;
    }

    public static final oq6 d(to6 to6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, to6Var)) == null) {
            Intrinsics.checkNotNullParameter(to6Var, "<this>");
            return to6Var.i().f();
        }
        return (oq6) invokeL.objValue;
    }

    public static final boolean e(to6 to6Var) {
        InterceptResult invokeL;
        ro6 ro6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, to6Var)) == null) {
            Intrinsics.checkNotNullParameter(to6Var, "<this>");
            b0 f = to6Var.f();
            if (f instanceof ro6) {
                ro6Var = (ro6) f;
            } else {
                ro6Var = null;
            }
            if (ro6Var != null) {
                return ro6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
