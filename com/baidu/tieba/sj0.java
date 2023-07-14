package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public Map<String, String> b;
    public Map<String, String> c;

    public sj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static sj0 a(@NonNull HashMap<String, ?> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            sj0 sj0Var = new sj0();
            if (hashMap.get("cmd_map") instanceof String) {
                JSONObject c = y31.c((String) hashMap.get("cmd_map"));
                sj0Var.a = c;
                sj0Var.b = y31.b(c);
            }
            if (hashMap.get("area_cmd") instanceof String) {
                sj0Var.c = y31.b(y31.c((String) hashMap.get("area_cmd")));
            }
            if (hashMap.get("charge_map") instanceof String) {
                y31.b(y31.c((String) hashMap.get("charge_map")));
            }
            if (hashMap.get("parallel_charge_urls") instanceof JSONObject) {
                y31.b((JSONObject) hashMap.get("parallel_charge_urls"));
            }
            if (hashMap.get("defer_charge_urls") instanceof JSONObject) {
                y31.b((JSONObject) hashMap.get("defer_charge_urls"));
            }
            return sj0Var;
        }
        return (sj0) invokeL.objValue;
    }
}
