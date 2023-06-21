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
public class m82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926466, "Lcom/baidu/tieba/m82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926466, "Lcom/baidu/tieba/m82;");
                return;
            }
        }
        boolean z = js1.a;
    }

    @Nullable
    public static <C extends o72> C a(p72 p72Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p72Var)) == null) {
            if (p72Var == null) {
                s82.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = p72Var.d();
            String str = p72Var.c;
            if (TextUtils.isEmpty(str)) {
                z82.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            p82 d2 = d(str);
            if (d2 == null) {
                z82.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = p72Var.b;
            if (TextUtils.isEmpty(str2)) {
                z82.o("Component-Finder", "find " + d + " with a empty componentId");
                List<o72> list = d2.a().c.get(p72Var.a);
                if (list == null) {
                    z82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    z82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    z82.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                z82.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends o72> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            p82 d = d(str);
            if (d == null) {
                z82.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                z82.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static p82 c(p72 p72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p72Var)) == null) {
            if (p72Var == null) {
                s82.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(p72Var.c);
        }
        return (p82) invokeL.objValue;
    }

    @Nullable
    public static p82 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                z82.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            hy1 A = mx2.T().A(str);
            if (!(A instanceof fy1)) {
                return null;
            }
            return ((fy1) A).a0();
        }
        return (p82) invokeL.objValue;
    }
}
