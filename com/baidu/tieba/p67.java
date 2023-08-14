package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class p67 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, l77> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948014072, "Lcom/baidu/tieba/p67;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948014072, "Lcom/baidu/tieba/p67;");
                return;
            }
        }
        HashMap<String, l77> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("recommend_banner", new eq6());
        a.put("browse_location", new bq6());
        a.put("fake_wall", new cq6());
        a.put("feed", new dq6());
        a.put("ala_live_attention", new aq6());
        a.put("sideway", new fq6());
    }

    public static HashMap<String, l77> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
