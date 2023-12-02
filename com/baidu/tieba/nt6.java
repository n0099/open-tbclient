package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class nt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ls6> T a(ms6 ms6Var, Class<T> type, y0 entity, es6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ms6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(ms6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x0 f = ms6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(ms6 ms6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ms6Var)) == null) {
            Intrinsics.checkNotNullParameter(ms6Var, "<this>");
            return d(ms6Var).a();
        }
        return invokeL.longValue;
    }

    public static final eu6 c(ms6 ms6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ms6Var)) == null) {
            Intrinsics.checkNotNullParameter(ms6Var, "<this>");
            return ms6Var.j().d();
        }
        return (eu6) invokeL.objValue;
    }

    public static final hu6 d(ms6 ms6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ms6Var)) == null) {
            Intrinsics.checkNotNullParameter(ms6Var, "<this>");
            return ms6Var.j().f();
        }
        return (hu6) invokeL.objValue;
    }

    public static final boolean e(ms6 ms6Var) {
        InterceptResult invokeL;
        ks6 ks6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ms6Var)) == null) {
            Intrinsics.checkNotNullParameter(ms6Var, "<this>");
            x0 f = ms6Var.f();
            if (f instanceof ks6) {
                ks6Var = (ks6) f;
            } else {
                ks6Var = null;
            }
            if (ks6Var != null) {
                return ks6Var.y();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
