package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class wv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, vv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448321198, "Lcom/baidu/tieba/wv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448321198, "Lcom/baidu/tieba/wv;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized vv a(String str) {
        InterceptResult invokeL;
        vv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (wv.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (vv) invokeL.objValue;
    }

    public static synchronized void c(vv vvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, vvVar) == null) {
            synchronized (wv.class) {
                if (vvVar != null) {
                    vvVar.a();
                    a.values().remove(vvVar);
                }
            }
        }
    }

    public static synchronized vv b(String str, int i) {
        InterceptResult invokeLI;
        vv vvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (wv.class) {
                if (a.containsKey(str) && (vvVar = a.get(str)) != null) {
                    return vvVar;
                }
                vv vvVar2 = new vv(str, i);
                try {
                    vvVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, vvVar2);
                return vvVar2;
            }
        }
        return (vv) invokeLI.objValue;
    }
}
