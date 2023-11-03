package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class rr {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, qr> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448316269, "Lcom/baidu/tieba/rr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448316269, "Lcom/baidu/tieba/rr;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized qr a(String str) {
        InterceptResult invokeL;
        qr b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (rr.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (qr) invokeL.objValue;
    }

    public static synchronized void c(qr qrVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qrVar) == null) {
            synchronized (rr.class) {
                if (qrVar != null) {
                    qrVar.a();
                    a.values().remove(qrVar);
                }
            }
        }
    }

    public static synchronized qr b(String str, int i) {
        InterceptResult invokeLI;
        qr qrVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (rr.class) {
                if (a.containsKey(str) && (qrVar = a.get(str)) != null) {
                    return qrVar;
                }
                qr qrVar2 = new qr(str, i);
                try {
                    qrVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, qrVar2);
                return qrVar2;
            }
        }
        return (qr) invokeLI.objValue;
    }
}
