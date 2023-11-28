package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends hs6> T a(is6 is6Var, Class<T> type, y0 entity, as6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, is6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(is6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x0 f = is6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(is6 is6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, is6Var)) == null) {
            Intrinsics.checkNotNullParameter(is6Var, "<this>");
            return d(is6Var).a();
        }
        return invokeL.longValue;
    }

    public static final au6 c(is6 is6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, is6Var)) == null) {
            Intrinsics.checkNotNullParameter(is6Var, "<this>");
            return is6Var.j().d();
        }
        return (au6) invokeL.objValue;
    }

    public static final du6 d(is6 is6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, is6Var)) == null) {
            Intrinsics.checkNotNullParameter(is6Var, "<this>");
            return is6Var.j().f();
        }
        return (du6) invokeL.objValue;
    }

    public static final boolean e(is6 is6Var) {
        InterceptResult invokeL;
        gs6 gs6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, is6Var)) == null) {
            Intrinsics.checkNotNullParameter(is6Var, "<this>");
            x0 f = is6Var.f();
            if (f instanceof gs6) {
                gs6Var = (gs6) f;
            } else {
                gs6Var = null;
            }
            if (gs6Var != null) {
                return gs6Var.y();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
