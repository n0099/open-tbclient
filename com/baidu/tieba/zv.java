package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class zv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, yv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448324081, "Lcom/baidu/tieba/zv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448324081, "Lcom/baidu/tieba/zv;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized yv a(String str) {
        InterceptResult invokeL;
        yv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (zv.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (yv) invokeL.objValue;
    }

    public static synchronized yv b(String str, int i) {
        InterceptResult invokeLI;
        yv yvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (zv.class) {
                if (!a.containsKey(str) || (yvVar = a.get(str)) == null) {
                    yv yvVar2 = new yv(str, i);
                    try {
                        yvVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, yvVar2);
                    return yvVar2;
                }
                return yvVar;
            }
        }
        return (yv) invokeLI.objValue;
    }

    public static synchronized void c(yv yvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, yvVar) == null) {
            synchronized (zv.class) {
                if (yvVar != null) {
                    yvVar.a();
                    a.values().remove(yvVar);
                }
            }
        }
    }
}
