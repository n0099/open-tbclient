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
/* loaded from: classes5.dex */
public class s02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948097524, "Lcom/baidu/tieba/s02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948097524, "Lcom/baidu/tieba/s02;");
                return;
            }
        }
        boolean z = pk1.a;
    }

    @Nullable
    public static <C extends uz1> C a(vz1 vz1Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vz1Var)) == null) {
            if (vz1Var == null) {
                y02.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = vz1Var.d();
            String str = vz1Var.c;
            if (TextUtils.isEmpty(str)) {
                f12.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            v02 d2 = d(str);
            if (d2 == null) {
                f12.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = vz1Var.b;
            if (TextUtils.isEmpty(str2)) {
                f12.o("Component-Finder", "find " + d + " with a empty componentId");
                List<uz1> list = d2.a().c.get(vz1Var.a);
                if (list == null) {
                    f12.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    f12.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    f12.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                f12.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends uz1> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            v02 d = d(str);
            if (d == null) {
                f12.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                f12.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static v02 c(vz1 vz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vz1Var)) == null) {
            if (vz1Var == null) {
                y02.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(vz1Var.c);
        }
        return (v02) invokeL.objValue;
    }

    @Nullable
    public static v02 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                f12.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            nq1 A = sp2.U().A(str);
            if (!(A instanceof lq1)) {
                return null;
            }
            return ((lq1) A).c0();
        }
        return (v02) invokeL.objValue;
    }
}
