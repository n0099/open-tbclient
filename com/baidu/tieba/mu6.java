package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class mu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends kt6> T a(lt6 lt6Var, Class<T> type, g0 entity, dt6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, lt6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(lt6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            f0 f = lt6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(lt6 lt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lt6Var)) == null) {
            Intrinsics.checkNotNullParameter(lt6Var, "<this>");
            return d(lt6Var).a();
        }
        return invokeL.longValue;
    }

    public static final dv6 c(lt6 lt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lt6Var)) == null) {
            Intrinsics.checkNotNullParameter(lt6Var, "<this>");
            return lt6Var.i().d();
        }
        return (dv6) invokeL.objValue;
    }

    public static final gv6 d(lt6 lt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lt6Var)) == null) {
            Intrinsics.checkNotNullParameter(lt6Var, "<this>");
            return lt6Var.i().f();
        }
        return (gv6) invokeL.objValue;
    }

    public static final boolean e(lt6 lt6Var) {
        InterceptResult invokeL;
        jt6 jt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lt6Var)) == null) {
            Intrinsics.checkNotNullParameter(lt6Var, "<this>");
            f0 f = lt6Var.f();
            if (f instanceof jt6) {
                jt6Var = (jt6) f;
            } else {
                jt6Var = null;
            }
            if (jt6Var != null) {
                return jt6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
