package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class xv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, wv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448322159, "Lcom/baidu/tieba/xv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448322159, "Lcom/baidu/tieba/xv;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized wv a(String str) {
        InterceptResult invokeL;
        wv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (xv.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (wv) invokeL.objValue;
    }

    public static synchronized void c(wv wvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, wvVar) == null) {
            synchronized (xv.class) {
                if (wvVar != null) {
                    wvVar.a();
                    a.values().remove(wvVar);
                }
            }
        }
    }

    public static synchronized wv b(String str, int i) {
        InterceptResult invokeLI;
        wv wvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (xv.class) {
                if (a.containsKey(str) && (wvVar = a.get(str)) != null) {
                    return wvVar;
                }
                wv wvVar2 = new wv(str, i);
                try {
                    wvVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, wvVar2);
                return wvVar2;
            }
        }
        return (wv) invokeLI.objValue;
    }
}
