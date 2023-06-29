package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class m77 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Class> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925660, "Lcom/baidu/tieba/m77;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925660, "Lcom/baidu/tieba/m77;");
                return;
            }
        }
        HashMap<String, Class> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("common_text", o77.class);
        a.put("text_with_bg", r77.class);
        a.put("common_icon", n77.class);
        a.put("emoji", p77.class);
        a.put("tie_plus", s77.class);
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
