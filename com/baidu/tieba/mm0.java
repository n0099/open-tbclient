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
/* loaded from: classes7.dex */
public class mm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mm0() {
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
            map.put("_client_version", rk0.a().w());
            map.put("uid", rk0.a().t());
            map.put("cuid", rk0.a().g());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", rk0.e());
            }
            String e = jl0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            String h = jl0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put(HttpRequest.OS_VERSION, h);
            }
            map.put("nt", String.valueOf(new zt0().c()));
            String b = jl0.c().b(false);
            if (!TextUtils.isEmpty(b)) {
                map.put("imei", b);
            }
            String a = jl0.c().a(false);
            if (!TextUtils.isEmpty(a)) {
                map.put(HttpRequest.ANDROID_ID, a);
            }
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                y31.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, cu0<nm0> cu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, cu0Var) == null) {
            ju0 f = ju0.f(d81.a(a(map).toString().getBytes()));
            ku0 ku0Var = new ku0();
            ku0Var.a("Content-Encoding", "gzip");
            ku0Var.a("Content-Type", "application/json");
            ku0Var.l("https://afdconf.baidu.com/afd/download");
            ku0Var.g(3000);
            ku0Var.j(3000);
            ku0Var.k(3000);
            ku0Var.f(f);
            rt0.b().a().a(ku0Var, cu0Var);
        }
    }
}
