package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class rk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rk0() {
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
            map.put("_client_version", zi0.a().v());
            map.put("uid", zi0.a().s());
            map.put("cuid", zi0.a().g());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", zi0.e());
            }
            String e = pj0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            String h = pj0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put("_os_version", h);
            }
            map.put("nt", String.valueOf(new zq0().c()));
            String b = pj0.c().b(false);
            if (!TextUtils.isEmpty(b)) {
                map.put("imei", b);
            }
            String a = pj0.c().a(false);
            if (!TextUtils.isEmpty(a)) {
                map.put(HttpRequest.ANDROID_ID, a);
            }
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                p01.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, cr0<sk0> cr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, cr0Var) == null) {
            jr0 f = jr0.f(h41.a(a(map).toString().getBytes()));
            kr0 kr0Var = new kr0();
            kr0Var.a("Content-Encoding", "gzip");
            kr0Var.a("Content-Type", "application/json");
            kr0Var.l("https://afdconf.baidu.com/afd/download");
            kr0Var.g(3000);
            kr0Var.j(3000);
            kr0Var.k(3000);
            kr0Var.f(f);
            rq0.b().a().a(kr0Var, cr0Var);
        }
    }
}
