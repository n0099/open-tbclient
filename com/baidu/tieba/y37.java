package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class y37 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, v47> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948279308, "Lcom/baidu/tieba/y37;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948279308, "Lcom/baidu/tieba/y37;");
                return;
            }
        }
        HashMap<String, v47> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("fake_wall", new en6());
        a.put("recommend_banner", new gn6());
        a.put("feed", new fn6());
        a.put("browse_location", new dn6());
        a.put("ala_live_attention", new cn6());
        a.put("sideway", new hn6());
    }

    public static HashMap<String, v47> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
