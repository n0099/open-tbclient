package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class zw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, yw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448324112, "Lcom/baidu/tieba/zw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448324112, "Lcom/baidu/tieba/zw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized yw a(String str) {
        InterceptResult invokeL;
        yw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (zw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (yw) invokeL.objValue;
    }

    public static synchronized void c(yw ywVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ywVar) == null) {
            synchronized (zw.class) {
                if (ywVar != null) {
                    ywVar.a();
                    a.values().remove(ywVar);
                }
            }
        }
    }

    public static synchronized yw b(String str, int i) {
        InterceptResult invokeLI;
        yw ywVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (zw.class) {
                if (a.containsKey(str) && (ywVar = a.get(str)) != null) {
                    return ywVar;
                }
                yw ywVar2 = new yw(str, i);
                try {
                    ywVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, ywVar2);
                return ywVar2;
            }
        }
        return (yw) invokeLI.objValue;
    }
}
