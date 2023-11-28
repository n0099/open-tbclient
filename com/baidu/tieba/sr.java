package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class sr {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, rr> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317230, "Lcom/baidu/tieba/sr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317230, "Lcom/baidu/tieba/sr;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized rr a(String str) {
        InterceptResult invokeL;
        rr b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (sr.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (rr) invokeL.objValue;
    }

    public static synchronized void c(rr rrVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rrVar) == null) {
            synchronized (sr.class) {
                if (rrVar != null) {
                    rrVar.a();
                    a.values().remove(rrVar);
                }
            }
        }
    }

    public static synchronized rr b(String str, int i) {
        InterceptResult invokeLI;
        rr rrVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (sr.class) {
                if (a.containsKey(str) && (rrVar = a.get(str)) != null) {
                    return rrVar;
                }
                rr rrVar2 = new rr(str, i);
                try {
                    rrVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, rrVar2);
                return rrVar2;
            }
        }
        return (rr) invokeLI.objValue;
    }
}
