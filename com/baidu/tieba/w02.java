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
public class w02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216688, "Lcom/baidu/tieba/w02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216688, "Lcom/baidu/tieba/w02;");
                return;
            }
        }
        boolean z = tk1.a;
    }

    @Nullable
    public static <C extends yz1> C a(zz1 zz1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zz1Var)) == null) {
            if (zz1Var == null) {
                c12.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = zz1Var.d();
            String str = zz1Var.c;
            if (TextUtils.isEmpty(str)) {
                j12.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            z02 d2 = d(str);
            if (d2 == null) {
                j12.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = zz1Var.b;
            if (TextUtils.isEmpty(str2)) {
                j12.o("Component-Finder", "find " + d + " with a empty componentId");
                List<yz1> list = d2.a().c.get(zz1Var.a);
                if (list == null) {
                    j12.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    j12.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    j12.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                j12.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends yz1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            z02 d = d(str);
            if (d == null) {
                j12.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                j12.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static z02 c(zz1 zz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zz1Var)) == null) {
            if (zz1Var == null) {
                c12.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(zz1Var.c);
        }
        return (z02) invokeL.objValue;
    }

    @Nullable
    public static z02 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                j12.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            rq1 A = wp2.U().A(str);
            if (!(A instanceof pq1)) {
                return null;
            }
            return ((pq1) A).c0();
        }
        return (z02) invokeL.objValue;
    }
}
