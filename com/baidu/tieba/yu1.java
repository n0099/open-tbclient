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
/* loaded from: classes9.dex */
public class yu1 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948342548, "Lcom/baidu/tieba/yu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948342548, "Lcom/baidu/tieba/yu1;");
                return;
            }
        }
        boolean z = am1.a;
        f = String.format("%s/ma/call", j22.b());
        g = ww2.a;
    }

    public final void b() {
        p53 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (c0 = p53.c0()) == null) {
            return;
        }
        int k = c0.k();
        String i = ue3.i(cr2.V().getCoreVersion(), k);
        if (k == 0) {
            this.c.put("swan_ver", i);
        } else if (k == 1) {
            this.c.put("game_ver", i);
        }
    }

    public yu1() {
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
        p53 c0;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c0 = p53.c0()) == null || (g0 = c0.X().g0()) == null) {
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
            this.b.put("Referer", wi3.b());
        }
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, responseCallback) == null) {
            if (!this.d) {
                responseCallback.onFail(new InvalidParameterException("no service has been set"));
                return;
            }
            String b = hj3.b(this.a, this.c);
            this.a = b;
            this.a = l22.b(b);
            sc4 sc4Var = new sc4(this.a, RequestBody.create(g, this.e), responseCallback);
            sc4Var.c = this.b;
            sc4Var.g = true;
            p22.i("CallServiceRequest", "Start request cloud ability: " + this.c.get("service"));
            tc4.g().e(sc4Var);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (kp3.a() == null) {
                p22.c("CallServiceRequest", Log.getStackTraceString(new AssertionError("Assertion failed: SwanConfigRuntime.getContext() == null")));
                return;
            }
            this.c.put("host_os", pl4.f());
            this.c.put("host_os_ver", pl4.g());
            this.c.put("host_app", kp3.a().c());
            this.c.put("host_app_ver", kp3.a().h());
            this.c.put("sdk_ver", kp3.a().b());
            this.c.put("ua", xl4.b(kp3.a().h()));
            this.c.put("ut", l22.f());
            this.c.put("network", pl4.e());
            this.c.put("bundle_Id", o53.K().getAppId());
            this.c.put("cuid", kp3.a().g());
            this.c.put("uuid", kp3.a().e());
            Map<String, String> map = this.c;
            map.put("sid", wo2.g0().k() + "");
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
