package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class wxb {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, a> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        String a(uxb uxbVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948287368, "Lcom/baidu/tieba/wxb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948287368, "Lcom/baidu/tieba/wxb;");
                return;
            }
        }
        a = new HashMap();
    }

    public static Map<String, a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : (Map) invokeV.objValue;
    }

    public static void b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, aVar) == null) {
            a.put(str, aVar);
        }
    }
}
