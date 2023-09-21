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
/* loaded from: classes8.dex */
public class t72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948134042, "Lcom/baidu/tieba/t72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948134042, "Lcom/baidu/tieba/t72;");
                return;
            }
        }
        boolean z = qr1.a;
    }

    @Nullable
    public static <C extends v62> C a(w62 w62Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, w62Var)) == null) {
            if (w62Var == null) {
                z72.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = w62Var.d();
            String str = w62Var.c;
            if (TextUtils.isEmpty(str)) {
                g82.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            w72 d2 = d(str);
            if (d2 == null) {
                g82.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = w62Var.b;
            if (TextUtils.isEmpty(str2)) {
                g82.o("Component-Finder", "find " + d + " with a empty componentId");
                List<v62> list = d2.a().c.get(w62Var.a);
                if (list == null) {
                    g82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    g82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    g82.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                g82.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends v62> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            w72 d = d(str);
            if (d == null) {
                g82.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                g82.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static w72 c(w62 w62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, w62Var)) == null) {
            if (w62Var == null) {
                z72.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(w62Var.c);
        }
        return (w72) invokeL.objValue;
    }

    @Nullable
    public static w72 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                g82.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            ox1 A = tw2.T().A(str);
            if (!(A instanceof mx1)) {
                return null;
            }
            return ((mx1) A).b0();
        }
        return (w72) invokeL.objValue;
    }
}
