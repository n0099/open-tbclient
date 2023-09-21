package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class nb7 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Class> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947996774, "Lcom/baidu/tieba/nb7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947996774, "Lcom/baidu/tieba/nb7;");
                return;
            }
        }
        HashMap<String, Class> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("text_with_bg", sb7.class);
        a.put("common_text", pb7.class);
        a.put("emoji", qb7.class);
        a.put("tie_plus", tb7.class);
        a.put("common_icon", ob7.class);
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
