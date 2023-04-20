package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class pm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends nl6> T a(ol6 ol6Var, Class<T> type, y entity, gl6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ol6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(ol6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x f = ol6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(ol6 ol6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ol6Var)) == null) {
            Intrinsics.checkNotNullParameter(ol6Var, "<this>");
            return d(ol6Var).a();
        }
        return invokeL.longValue;
    }

    public static final gn6 c(ol6 ol6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ol6Var)) == null) {
            Intrinsics.checkNotNullParameter(ol6Var, "<this>");
            return ol6Var.i().d();
        }
        return (gn6) invokeL.objValue;
    }

    public static final jn6 d(ol6 ol6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ol6Var)) == null) {
            Intrinsics.checkNotNullParameter(ol6Var, "<this>");
            return ol6Var.i().f();
        }
        return (jn6) invokeL.objValue;
    }

    public static final boolean e(ol6 ol6Var) {
        InterceptResult invokeL;
        ml6 ml6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ol6Var)) == null) {
            Intrinsics.checkNotNullParameter(ol6Var, "<this>");
            x f = ol6Var.f();
            if (f instanceof ml6) {
                ml6Var = (ml6) f;
            } else {
                ml6Var = null;
            }
            if (ml6Var != null) {
                return ml6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
