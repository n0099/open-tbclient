package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class y86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends w76> T a(x76 x76Var, Class<T> type, p0 entity, p76 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, x76Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(x76Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = x76Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(x76 x76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x76Var)) == null) {
            Intrinsics.checkNotNullParameter(x76Var, "<this>");
            return d(x76Var).a();
        }
        return invokeL.longValue;
    }

    public static final p96 c(x76 x76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x76Var)) == null) {
            Intrinsics.checkNotNullParameter(x76Var, "<this>");
            return x76Var.i().d();
        }
        return (p96) invokeL.objValue;
    }

    public static final s96 d(x76 x76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x76Var)) == null) {
            Intrinsics.checkNotNullParameter(x76Var, "<this>");
            return x76Var.i().f();
        }
        return (s96) invokeL.objValue;
    }

    public static final boolean e(x76 x76Var) {
        InterceptResult invokeL;
        v76 v76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x76Var)) == null) {
            Intrinsics.checkNotNullParameter(x76Var, "<this>");
            o0 f = x76Var.f();
            if (f instanceof v76) {
                v76Var = (v76) f;
            } else {
                v76Var = null;
            }
            if (v76Var == null) {
                return true;
            }
            return v76Var.x();
        }
        return invokeL.booleanValue;
    }
}
