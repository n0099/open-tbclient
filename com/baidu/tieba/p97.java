package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class p97 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, ma7> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016955, "Lcom/baidu/tieba/p97;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016955, "Lcom/baidu/tieba/p97;");
                return;
            }
        }
        HashMap<String, ma7> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("browse_location", new us6());
        a.put("ala_live_attention", new ts6());
        a.put("feed", new ws6());
        a.put("recommend_banner", new xs6());
        a.put("fake_wall", new vs6());
        a.put("sideway", new ys6());
    }

    public static HashMap<String, ma7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
