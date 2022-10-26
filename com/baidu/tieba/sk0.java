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
public class sk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sk0() {
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

    public final JSONObject a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", aj0.a().u());
            map.put("uid", aj0.a().r());
            map.put("cuid", aj0.a().g());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", aj0.e());
            }
            String e = qj0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            String h = qj0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put("_os_version", h);
            }
            map.put("nt", String.valueOf(new iq0().c()));
            String b = qj0.c().b(false);
            if (!TextUtils.isEmpty(b)) {
                map.put("imei", b);
            }
            String a = qj0.c().a(false);
            if (!TextUtils.isEmpty(a)) {
                map.put(HttpRequest.ANDROID_ID, a);
            }
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                yz0.f(jSONObject, (String) entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map map, lq0 lq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, lq0Var) == null) {
            sq0 f = sq0.f(p31.a(a(map).toString().getBytes()));
            tq0 tq0Var = new tq0();
            tq0Var.a("Content-Encoding", "gzip");
            tq0Var.a("Content-Type", "application/json");
            tq0Var.k("https://afdconf.baidu.com/afd/download");
            tq0Var.g(3000);
            tq0Var.i(3000);
            tq0Var.j(3000);
            tq0Var.f(f);
            aq0.b().a().a(tq0Var, lq0Var);
        }
    }
}
