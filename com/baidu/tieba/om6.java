package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class om6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ml6> T a(nl6 nl6Var, Class<T> type, y entity, fl6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, nl6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(nl6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x f = nl6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(nl6 nl6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nl6Var)) == null) {
            Intrinsics.checkNotNullParameter(nl6Var, "<this>");
            return d(nl6Var).a();
        }
        return invokeL.longValue;
    }

    public static final fn6 c(nl6 nl6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nl6Var)) == null) {
            Intrinsics.checkNotNullParameter(nl6Var, "<this>");
            return nl6Var.i().d();
        }
        return (fn6) invokeL.objValue;
    }

    public static final in6 d(nl6 nl6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, nl6Var)) == null) {
            Intrinsics.checkNotNullParameter(nl6Var, "<this>");
            return nl6Var.i().f();
        }
        return (in6) invokeL.objValue;
    }

    public static final boolean e(nl6 nl6Var) {
        InterceptResult invokeL;
        ll6 ll6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, nl6Var)) == null) {
            Intrinsics.checkNotNullParameter(nl6Var, "<this>");
            x f = nl6Var.f();
            if (f instanceof ll6) {
                ll6Var = (ll6) f;
            } else {
                ll6Var = null;
            }
            if (ll6Var != null) {
                return ll6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
