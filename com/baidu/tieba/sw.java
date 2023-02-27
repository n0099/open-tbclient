package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class sw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, rw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317385, "Lcom/baidu/tieba/sw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317385, "Lcom/baidu/tieba/sw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized rw a(String str) {
        InterceptResult invokeL;
        rw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (sw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (rw) invokeL.objValue;
    }

    public static synchronized void c(rw rwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rwVar) == null) {
            synchronized (sw.class) {
                if (rwVar != null) {
                    rwVar.a();
                    a.values().remove(rwVar);
                }
            }
        }
    }

    public static synchronized rw b(String str, int i) {
        InterceptResult invokeLI;
        rw rwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (sw.class) {
                if (a.containsKey(str) && (rwVar = a.get(str)) != null) {
                    return rwVar;
                }
                rw rwVar2 = new rw(str, i);
                try {
                    rwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, rwVar2);
                return rwVar2;
            }
        }
        return (rw) invokeLI.objValue;
    }
}
