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
public class z52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310866, "Lcom/baidu/tieba/z52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310866, "Lcom/baidu/tieba/z52;");
                return;
            }
        }
        boolean z = wp1.a;
    }

    @Nullable
    public static <C extends b52> C a(c52 c52Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c52Var)) == null) {
            if (c52Var == null) {
                f62.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = c52Var.d();
            String str = c52Var.c;
            if (TextUtils.isEmpty(str)) {
                m62.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            c62 d2 = d(str);
            if (d2 == null) {
                m62.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = c52Var.b;
            if (TextUtils.isEmpty(str2)) {
                m62.o("Component-Finder", "find " + d + " with a empty componentId");
                List<b52> list = d2.a().c.get(c52Var.a);
                if (list == null) {
                    m62.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    m62.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    m62.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                m62.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends b52> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c62 d = d(str);
            if (d == null) {
                m62.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                m62.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static c62 c(c52 c52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c52Var)) == null) {
            if (c52Var == null) {
                f62.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(c52Var.c);
        }
        return (c62) invokeL.objValue;
    }

    @Nullable
    public static c62 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                m62.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            uv1 A = zu2.U().A(str);
            if (!(A instanceof sv1)) {
                return null;
            }
            return ((sv1) A).c0();
        }
        return (c62) invokeL.objValue;
    }
}
