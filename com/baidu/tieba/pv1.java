package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String f;
    public static final MediaType g;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Map<String, String> b;
    public Map<String, String> c;
    public boolean d;
    public String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075390, "Lcom/baidu/tieba/pv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075390, "Lcom/baidu/tieba/pv1;");
                return;
            }
        }
        boolean z = rm1.a;
        f = String.format("%s/ma/call", a32.b());
        g = nx2.a;
    }

    public final void b() {
        g63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (c0 = g63.c0()) == null) {
            return;
        }
        int k = c0.k();
        String i = lf3.i(tr2.V().getCoreVersion(), k);
        if (k == 0) {
            this.c.put("swan_ver", i);
        } else if (k == 1) {
            this.c.put("game_ver", i);
        }
    }

    public pv1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f + "?";
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = false;
        this.e = "";
        d();
        e();
    }

    public final void a() {
        g63 c0;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c0 = g63.c0()) == null || (g0 = c0.X().g0()) == null) {
            return;
        }
        this.c.put("app_ver", String.valueOf(g0.versionCode));
    }

    public final void e() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Map<String, String> map = this.b;
            if (SwanAppAllianceLoginHelper.d.f()) {
                i = 2;
            } else {
                i = 0;
            }
            map.put("mnpunion", String.valueOf(i));
            this.b.put("Referer", nj3.b());
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b = yj3.b(this.a, this.c);
            this.a = b;
            this.a = c32.b(b);
            jd4 jd4Var = new jd4(this.a, RequestBody.create(g, this.e), responseCallback);
            jd4Var.c = this.b;
            jd4Var.g = true;
            g32.i("CallServiceRequest", "Start request cloud ability: " + this.c.get("service"));
            kd4.g().e(jd4Var);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (bq3.a() == null) {
                g32.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.c.put("host_os", gm4.f());
            this.c.put("host_os_ver", gm4.g());
            this.c.put("host_app", bq3.a().c());
            this.c.put("host_app_ver", bq3.a().h());
            this.c.put("sdk_ver", bq3.a().b());
            this.c.put("ua", om4.b(bq3.a().h()));
            this.c.put("ut", c32.f());
            this.c.put("network", gm4.e());
            this.c.put("bundle_Id", f63.K().getAppId());
            this.c.put("cuid", bq3.a().g());
            this.c.put("uuid", bq3.a().e());
            Map<String, String> map = this.c;
            map.put("sid", np2.g0().k() + "");
            this.c.put("source", "swan_sdk");
            this.c.put("timestamp", String.valueOf(System.currentTimeMillis()));
            b();
            a();
        }
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            if (jSONObject == null) {
                this.e = "";
            } else {
                this.e = jSONObject.toString();
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.c.put("service", str);
            this.d = true;
        }
    }
}
