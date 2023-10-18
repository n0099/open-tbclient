package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ir6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends gq6> T a(hq6 hq6Var, Class<T> type, i0 entity, zp6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, hq6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(hq6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            h0 f = hq6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(hq6 hq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hq6Var)) == null) {
            Intrinsics.checkNotNullParameter(hq6Var, "<this>");
            return d(hq6Var).a();
        }
        return invokeL.longValue;
    }

    public static final zr6 c(hq6 hq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hq6Var)) == null) {
            Intrinsics.checkNotNullParameter(hq6Var, "<this>");
            return hq6Var.j().d();
        }
        return (zr6) invokeL.objValue;
    }

    public static final cs6 d(hq6 hq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hq6Var)) == null) {
            Intrinsics.checkNotNullParameter(hq6Var, "<this>");
            return hq6Var.j().f();
        }
        return (cs6) invokeL.objValue;
    }

    public static final boolean e(hq6 hq6Var) {
        InterceptResult invokeL;
        fq6 fq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, hq6Var)) == null) {
            Intrinsics.checkNotNullParameter(hq6Var, "<this>");
            h0 f = hq6Var.f();
            if (f instanceof fq6) {
                fq6Var = (fq6) f;
            } else {
                fq6Var = null;
            }
            if (fq6Var != null) {
                return fq6Var.y();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
