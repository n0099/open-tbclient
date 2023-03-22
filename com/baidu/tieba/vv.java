package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class vv {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, uv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320237, "Lcom/baidu/tieba/vv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320237, "Lcom/baidu/tieba/vv;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized uv a(String str) {
        InterceptResult invokeL;
        uv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (vv.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (uv) invokeL.objValue;
    }

    public static synchronized void c(uv uvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, uvVar) == null) {
            synchronized (vv.class) {
                if (uvVar != null) {
                    uvVar.a();
                    a.values().remove(uvVar);
                }
            }
        }
    }

    public static synchronized uv b(String str, int i) {
        InterceptResult invokeLI;
        uv uvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (vv.class) {
                if (a.containsKey(str) && (uvVar = a.get(str)) != null) {
                    return uvVar;
                }
                uv uvVar2 = new uv(str, i);
                try {
                    uvVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, uvVar2);
                return uvVar2;
            }
        }
        return (uv) invokeLI.objValue;
    }
}
