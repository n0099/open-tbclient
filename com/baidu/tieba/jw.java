package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class jw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, iw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448308736, "Lcom/baidu/tieba/jw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448308736, "Lcom/baidu/tieba/jw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized iw a(String str) {
        InterceptResult invokeL;
        iw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (jw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (iw) invokeL.objValue;
    }

    public static synchronized void c(iw iwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iwVar) == null) {
            synchronized (jw.class) {
                if (iwVar != null) {
                    iwVar.a();
                    a.values().remove(iwVar);
                }
            }
        }
    }

    public static synchronized iw b(String str, int i) {
        InterceptResult invokeLI;
        iw iwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (jw.class) {
                if (a.containsKey(str) && (iwVar = a.get(str)) != null) {
                    return iwVar;
                }
                iw iwVar2 = new iw(str, i);
                try {
                    iwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, iwVar2);
                return iwVar2;
            }
        }
        return (iw) invokeLI.objValue;
    }
}
