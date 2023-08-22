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
/* loaded from: classes7.dex */
public class q72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948044669, "Lcom/baidu/tieba/q72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948044669, "Lcom/baidu/tieba/q72;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    @Nullable
    public static <C extends s62> C a(t62 t62Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t62Var)) == null) {
            if (t62Var == null) {
                w72.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = t62Var.d();
            String str = t62Var.c;
            if (TextUtils.isEmpty(str)) {
                d82.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            t72 d2 = d(str);
            if (d2 == null) {
                d82.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = t62Var.b;
            if (TextUtils.isEmpty(str2)) {
                d82.o("Component-Finder", "find " + d + " with a empty componentId");
                List<s62> list = d2.a().c.get(t62Var.a);
                if (list == null) {
                    d82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    d82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    d82.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                d82.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends s62> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            t72 d = d(str);
            if (d == null) {
                d82.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                d82.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static t72 c(t62 t62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t62Var)) == null) {
            if (t62Var == null) {
                w72.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(t62Var.c);
        }
        return (t72) invokeL.objValue;
    }

    @Nullable
    public static t72 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                d82.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            lx1 A = qw2.T().A(str);
            if (!(A instanceof jx1)) {
                return null;
            }
            return ((jx1) A).a0();
        }
        return (t72) invokeL.objValue;
    }
}
