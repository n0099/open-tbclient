package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class ow {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448313541, "Lcom/baidu/tieba/ow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448313541, "Lcom/baidu/tieba/ow;");
                return;
            }
        }
        a = new HashMap();
    }

    public static synchronized nw a(String str) {
        InterceptResult invokeL;
        nw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (ow.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (nw) invokeL.objValue;
    }

    public static synchronized void c(nw nwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nwVar) == null) {
            synchronized (ow.class) {
                if (nwVar != null) {
                    nwVar.a();
                    a.values().remove(nwVar);
                }
            }
        }
    }

    public static synchronized nw b(String str, int i) {
        InterceptResult invokeLI;
        nw nwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (ow.class) {
                if (a.containsKey(str) && (nwVar = (nw) a.get(str)) != null) {
                    return nwVar;
                }
                nw nwVar2 = new nw(str, i);
                try {
                    nwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, nwVar2);
                return nwVar2;
            }
        }
        return (nw) invokeLI.objValue;
    }
}
