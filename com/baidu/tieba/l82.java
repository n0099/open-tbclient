package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class l82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896675, "Lcom/baidu/tieba/l82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896675, "Lcom/baidu/tieba/l82;");
                return;
            }
        }
        boolean z = is1.a;
    }

    @Nullable
    public static <C extends n72> C a(o72 o72Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o72Var)) == null) {
            if (o72Var == null) {
                r82.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = o72Var.d();
            String str = o72Var.c;
            if (TextUtils.isEmpty(str)) {
                y82.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            o82 d2 = d(str);
            if (d2 == null) {
                y82.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = o72Var.b;
            if (TextUtils.isEmpty(str2)) {
                y82.o("Component-Finder", "find " + d + " with a empty componentId");
                List<n72> list = d2.a().c.get(o72Var.a);
                if (list == null) {
                    y82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    y82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    y82.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                y82.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends n72> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            o82 d = d(str);
            if (d == null) {
                y82.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                y82.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static o82 c(o72 o72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, o72Var)) == null) {
            if (o72Var == null) {
                r82.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(o72Var.c);
        }
        return (o82) invokeL.objValue;
    }

    @Nullable
    public static o82 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                y82.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            gy1 A = lx2.T().A(str);
            if (!(A instanceof ey1)) {
                return null;
            }
            return ((ey1) A).a0();
        }
        return (o82) invokeL.objValue;
    }
}
