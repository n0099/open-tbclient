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
/* loaded from: classes6.dex */
public class kg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kg0() {
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
            map.put("_client_version", pe0.a().x());
            map.put("uid", pe0.a().u());
            map.put("cuid", pe0.a().g());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", pe0.e());
            }
            String e = hf0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            String h = hf0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put(HttpRequest.OS_VERSION, h);
            }
            map.put("nt", String.valueOf(new fo0().c()));
            String b = hf0.c().b(false);
            if (!TextUtils.isEmpty(b)) {
                map.put("imei", b);
            }
            String a = hf0.c().a(false);
            if (!TextUtils.isEmpty(a)) {
                map.put(HttpRequest.ANDROID_ID, a);
            }
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ux0.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, io0<lg0> io0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, io0Var) == null) {
            po0 f = po0.f(c21.a(a(map).toString().getBytes()));
            qo0 qo0Var = new qo0();
            qo0Var.a("Content-Encoding", "gzip");
            qo0Var.a("Content-Type", "application/json");
            qo0Var.l("https://afdconf.baidu.com/afd/download");
            qo0Var.g(3000);
            qo0Var.j(3000);
            qo0Var.k(3000);
            qo0Var.f(f);
            xn0.b().a().a(qo0Var, io0Var);
        }
    }
}
