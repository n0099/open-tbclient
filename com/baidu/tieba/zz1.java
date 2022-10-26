package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class zz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948377144, "Lcom/baidu/tieba/zz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948377144, "Lcom/baidu/tieba/zz1;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public static bz1 a(cz1 cz1Var) {
        InterceptResult invokeL;
        bz1 bz1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cz1Var)) == null) {
            if (cz1Var == null) {
                f02.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = cz1Var.d();
            String str = cz1Var.c;
            if (TextUtils.isEmpty(str)) {
                m02.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            c02 d2 = d(str);
            if (d2 == null) {
                m02.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = cz1Var.b;
            if (TextUtils.isEmpty(str2)) {
                m02.o("Component-Finder", "find " + d + " with a empty componentId");
                List list = (List) d2.a().c.get(cz1Var.a);
                if (list == null) {
                    m02.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    m02.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    m02.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    bz1Var = (bz1) list.get(0);
                }
            } else {
                bz1Var = (bz1) d2.a().b.get(str2);
            }
            if (bz1Var == null) {
                m02.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return bz1Var;
        }
        return (bz1) invokeL.objValue;
    }

    public static bz1 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c02 d = d(str);
            if (d == null) {
                m02.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            bz1 bz1Var = (bz1) d.a().b.get(str2);
            if (bz1Var == null) {
                m02.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return bz1Var;
        }
        return (bz1) invokeLL.objValue;
    }

    public static c02 c(cz1 cz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cz1Var)) == null) {
            if (cz1Var == null) {
                f02.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(cz1Var.c);
        }
        return (c02) invokeL.objValue;
    }

    public static c02 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                m02.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            up1 A = zo2.U().A(str);
            if (!(A instanceof sp1)) {
                return null;
            }
            return ((sp1) A).c0();
        }
        return (c02) invokeL.objValue;
    }
}
