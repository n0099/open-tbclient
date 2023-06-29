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
public class p82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015839, "Lcom/baidu/tieba/p82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015839, "Lcom/baidu/tieba/p82;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    @Nullable
    public static <C extends r72> C a(s72 s72Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, s72Var)) == null) {
            if (s72Var == null) {
                v82.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = s72Var.d();
            String str = s72Var.c;
            if (TextUtils.isEmpty(str)) {
                c92.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            s82 d2 = d(str);
            if (d2 == null) {
                c92.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = s72Var.b;
            if (TextUtils.isEmpty(str2)) {
                c92.o("Component-Finder", "find " + d + " with a empty componentId");
                List<r72> list = d2.a().c.get(s72Var.a);
                if (list == null) {
                    c92.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    c92.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    c92.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                c92.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends r72> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            s82 d = d(str);
            if (d == null) {
                c92.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                c92.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static s82 c(s72 s72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, s72Var)) == null) {
            if (s72Var == null) {
                v82.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(s72Var.c);
        }
        return (s82) invokeL.objValue;
    }

    @Nullable
    public static s82 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                c92.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            ky1 A = px2.T().A(str);
            if (!(A instanceof iy1)) {
                return null;
            }
            return ((iy1) A).a0();
        }
        return (s82) invokeL.objValue;
    }
}
