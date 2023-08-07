package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o67 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, k77> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947984281, "Lcom/baidu/tieba/o67;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947984281, "Lcom/baidu/tieba/o67;");
                return;
            }
        }
        HashMap<String, k77> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("feed", new cq6());
        a.put("recommend_banner", new dq6());
        a.put("fake_wall", new bq6());
        a.put("ala_live_attention", new zp6());
        a.put("browse_location", new aq6());
        a.put("sideway", new eq6());
    }

    public static HashMap<String, k77> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
