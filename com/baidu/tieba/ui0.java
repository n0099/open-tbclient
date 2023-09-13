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
/* loaded from: classes8.dex */
public class ui0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public Map<String, String> b;
    public Map<String, String> c;

    public ui0() {
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

    public static ui0 a(@NonNull HashMap<String, ?> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hashMap)) == null) {
            ui0 ui0Var = new ui0();
            if (hashMap.get("cmd_map") instanceof String) {
                JSONObject c = i31.c((String) hashMap.get("cmd_map"));
                ui0Var.a = c;
                ui0Var.b = i31.b(c);
            }
            if (hashMap.get("area_cmd") instanceof String) {
                ui0Var.c = i31.b(i31.c((String) hashMap.get("area_cmd")));
            }
            if (hashMap.get("charge_map") instanceof String) {
                i31.b(i31.c((String) hashMap.get("charge_map")));
            }
            if (hashMap.get("parallel_charge_urls") instanceof JSONObject) {
                i31.b((JSONObject) hashMap.get("parallel_charge_urls"));
            }
            if (hashMap.get("defer_charge_urls") instanceof JSONObject) {
                i31.b((JSONObject) hashMap.get("defer_charge_urls"));
            }
            return ui0Var;
        }
        return (ui0) invokeL.objValue;
    }
}
