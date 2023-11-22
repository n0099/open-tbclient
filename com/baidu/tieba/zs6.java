package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends xr6> T a(yr6 yr6Var, Class<T> type, y0 entity, qr6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, yr6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(yr6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x0 f = yr6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(yr6 yr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yr6Var)) == null) {
            Intrinsics.checkNotNullParameter(yr6Var, "<this>");
            return d(yr6Var).a();
        }
        return invokeL.longValue;
    }

    public static final qt6 c(yr6 yr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yr6Var)) == null) {
            Intrinsics.checkNotNullParameter(yr6Var, "<this>");
            return yr6Var.j().d();
        }
        return (qt6) invokeL.objValue;
    }

    public static final tt6 d(yr6 yr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yr6Var)) == null) {
            Intrinsics.checkNotNullParameter(yr6Var, "<this>");
            return yr6Var.j().f();
        }
        return (tt6) invokeL.objValue;
    }

    public static final boolean e(yr6 yr6Var) {
        InterceptResult invokeL;
        wr6 wr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yr6Var)) == null) {
            Intrinsics.checkNotNullParameter(yr6Var, "<this>");
            x0 f = yr6Var.f();
            if (f instanceof wr6) {
                wr6Var = (wr6) f;
            } else {
                wr6Var = null;
            }
            if (wr6Var != null) {
                return wr6Var.y();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
