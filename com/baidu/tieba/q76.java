package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class q76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends o66> T a(p66 p66Var, Class<T> type, p0 entity, h66 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, p66Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(p66Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = p66Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(p66 p66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p66Var)) == null) {
            Intrinsics.checkNotNullParameter(p66Var, "<this>");
            return d(p66Var).a();
        }
        return invokeL.longValue;
    }

    public static final h86 c(p66 p66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p66Var)) == null) {
            Intrinsics.checkNotNullParameter(p66Var, "<this>");
            return p66Var.i().d();
        }
        return (h86) invokeL.objValue;
    }

    public static final k86 d(p66 p66Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p66Var)) == null) {
            Intrinsics.checkNotNullParameter(p66Var, "<this>");
            return p66Var.i().f();
        }
        return (k86) invokeL.objValue;
    }

    public static final boolean e(p66 p66Var) {
        InterceptResult invokeL;
        n66 n66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p66Var)) == null) {
            Intrinsics.checkNotNullParameter(p66Var, "<this>");
            o0 f = p66Var.f();
            if (f instanceof n66) {
                n66Var = (n66) f;
            } else {
                n66Var = null;
            }
            if (n66Var == null) {
                return true;
            }
            return n66Var.x();
        }
        return invokeL.booleanValue;
    }
}
