package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class yw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, xw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448323151, "Lcom/baidu/tieba/yw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448323151, "Lcom/baidu/tieba/yw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized xw a(String str) {
        InterceptResult invokeL;
        xw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (yw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (xw) invokeL.objValue;
    }

    public static synchronized void c(xw xwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xwVar) == null) {
            synchronized (yw.class) {
                if (xwVar != null) {
                    xwVar.a();
                    a.values().remove(xwVar);
                }
            }
        }
    }

    public static synchronized xw b(String str, int i) {
        InterceptResult invokeLI;
        xw xwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (yw.class) {
                if (a.containsKey(str) && (xwVar = a.get(str)) != null) {
                    return xwVar;
                }
                xw xwVar2 = new xw(str, i);
                try {
                    xwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, xwVar2);
                return xwVar2;
            }
        }
        return (xw) invokeLI.objValue;
    }
}
