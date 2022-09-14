package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class nw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, mw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448312580, "Lcom/baidu/tieba/nw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448312580, "Lcom/baidu/tieba/nw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized mw a(String str) {
        InterceptResult invokeL;
        mw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (nw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (mw) invokeL.objValue;
    }

    public static synchronized mw b(String str, int i) {
        InterceptResult invokeLI;
        mw mwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (nw.class) {
                if (!a.containsKey(str) || (mwVar = a.get(str)) == null) {
                    mw mwVar2 = new mw(str, i);
                    try {
                        mwVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, mwVar2);
                    return mwVar2;
                }
                return mwVar;
            }
        }
        return (mw) invokeLI.objValue;
    }

    public static synchronized void c(mw mwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mwVar) == null) {
            synchronized (nw.class) {
                if (mwVar != null) {
                    mwVar.a();
                    a.values().remove(mwVar);
                }
            }
        }
    }
}
