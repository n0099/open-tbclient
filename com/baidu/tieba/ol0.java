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
public class ol0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ol0() {
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
            map.put("_client_version", tj0.a().w());
            map.put("uid", tj0.a().t());
            map.put("cuid", tj0.a().g());
            if (Build.VERSION.SDK_INT >= 17) {
                map.put("ua", tj0.e());
            }
            String e = lk0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            String h = lk0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put(HttpRequest.OS_VERSION, h);
            }
            map.put("nt", String.valueOf(new jt0().c()));
            String b = lk0.c().b(false);
            if (!TextUtils.isEmpty(b)) {
                map.put("imei", b);
            }
            String a = lk0.c().a(false);
            if (!TextUtils.isEmpty(a)) {
                map.put(HttpRequest.ANDROID_ID, a);
            }
            map.put("ssl", "1");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                i31.f(jSONObject, entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void b(Map<String, String> map, mt0<pl0> mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, mt0Var) == null) {
            tt0 f = tt0.f(q71.a(a(map).toString().getBytes()));
            ut0 ut0Var = new ut0();
            ut0Var.a("Content-Encoding", "gzip");
            ut0Var.a("Content-Type", "application/json");
            ut0Var.l("https://afdconf.baidu.com/afd/download");
            ut0Var.g(3000);
            ut0Var.j(3000);
            ut0Var.k(3000);
            ut0Var.f(f);
            bt0.b().a().a(ut0Var, mt0Var);
        }
    }
}
