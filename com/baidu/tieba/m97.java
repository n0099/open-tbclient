package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class m97 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Class> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947927582, "Lcom/baidu/tieba/m97;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947927582, "Lcom/baidu/tieba/m97;");
                return;
            }
        }
        HashMap<String, Class> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("common_icon", n97.class);
        a.put("emoji", p97.class);
        a.put("tie_plus", t97.class);
        a.put("text_with_hollow_bg", s97.class);
        a.put("text_with_bg", r97.class);
        a.put("common_text", o97.class);
    }

    public static HashMap<String, Class> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
