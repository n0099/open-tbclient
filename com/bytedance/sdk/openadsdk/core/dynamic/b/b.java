package com.bytedance.sdk.openadsdk.core.dynamic.b;

import androidx.annotation.Keep;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? Arrays.asList(DI.APP_INFO_NAME, "adInfo", "getTemplateInfo") : (List) invokeV.objValue;
    }

    @Keep
    @JProtect
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return (JSONObject) invokeV.objValue;
        }
        char c2 = 'I';
        while (true) {
            switch (c2) {
                case 'H':
                case 'J':
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (String str : b()) {
                        jSONArray.put(str);
                    }
                    try {
                        jSONObject.put("appName", com.bytedance.sdk.openadsdk.c.a.a());
                        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.c.a.e());
                        jSONObject.put("aid", com.bytedance.sdk.openadsdk.c.a.b());
                        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.c.a.c());
                        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.c.a.d());
                        jSONObject.put("netType", com.bytedance.sdk.openadsdk.c.a.f());
                        jSONObject.put("supportList", jSONArray);
                        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.c.a.a(o.a()));
                    } catch (Exception unused) {
                    }
                    return jSONObject;
                case 'I':
                default:
                    c2 = 'H';
            }
        }
    }
}
