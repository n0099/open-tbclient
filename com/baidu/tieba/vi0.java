package com.baidu.tieba;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vi0() {
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

    public final JSONObject a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", eh0.a().t());
            map.put("uid", eh0.a().p());
            map.put("cuid", eh0.a().b());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", eh0.e());
            }
            map.put("model", Build.MODEL);
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("_os_version", Build.VERSION.RELEASE);
            map.put("nt", String.valueOf(new io0().c()));
            map.put("imei", eh0.a().s());
            map.put(HttpRequest.ANDROID_ID, eh0.a().a());
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                yx0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, lo0<wi0> lo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, lo0Var) == null) {
            so0 f = so0.f(j11.a(a(map).toString().getBytes()));
            to0 to0Var = new to0();
            to0Var.a("Content-Encoding", "gzip");
            to0Var.a("Content-Type", "application/json");
            to0Var.k("https://afdconf.baidu.com/afd/download");
            to0Var.g(3000);
            to0Var.i(3000);
            to0Var.j(3000);
            to0Var.f(f);
            ao0.b().a().a(to0Var, lo0Var);
        }
    }
}
