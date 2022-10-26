package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class p86 {
    public static /* synthetic */ Interceptable $ic;
    public static Map a;
    public static Map b;
    public static Map c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015963, "Lcom/baidu/tieba/p86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015963, "Lcom/baidu/tieba/p86;");
                return;
            }
        }
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        a.put("CAM_X0906", "CAM_X0906");
        b.put("CAM_X0906", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        c.put("CAM_X0906", "testMethod");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (b.containsKey(str)) {
                try {
                    Method declaredMethod = Class.forName((String) b.get(str)).getDeclaredMethod((String) c.get(str), new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    if (invoke instanceof Boolean) {
                        if (((Boolean) invoke).booleanValue()) {
                            return (String) a.get(str);
                        }
                        return str;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
