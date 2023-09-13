package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ni3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji3 a;

        public a(ji3 ji3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948003377, "Lcom/baidu/tieba/ni3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948003377, "Lcom/baidu/tieba/ni3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static String a(Response response) {
        InterceptResult invokeL;
        ResponseBody body;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, response)) == null) {
            if (response == null || (body = response.body()) == null) {
                return "";
            }
            JSONObject jSONObject = null;
            try {
                str = body.string();
            } catch (IOException e) {
                if (a) {
                    e.printStackTrace();
                }
                str = null;
            }
            if (str == null) {
                return "";
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            if (jSONObject == null) {
                return "";
            }
            return jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) != null) || TextUtils.equals(str, GameAssistConstKt.METHOD_GET_LOCATION)) {
            return;
        }
        c(str, i, str2, i2, str3, null);
    }

    public static void c(String str, int i, String str2, int i2, String str3, Response response) {
        pa2 H;
        nx1 q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            ji3 ji3Var = new ji3();
            hb3 b0 = hb3.b0();
            if (b0 == null || (H = uw2.T().H()) == null || (q3 = H.q3()) == null) {
                return;
            }
            String l = q3.l();
            ew2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            String W2 = W.W();
            String v1 = W.v1();
            String i3 = mk3.i(uw2.T().getCoreVersion(), W.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            ji3Var.a = ai3.n(W.G());
            ji3Var.c = b0.W().T();
            ji3Var.d = b0.W().V();
            ji3Var.f = appId;
            ji3Var.a("name", Z);
            ji3Var.a("apiName", str);
            ji3Var.a(CloudStabilityUBCUtils.KEY_ERROR_CODE, String.valueOf(i));
            ji3Var.a("errorMsg", str2);
            ji3Var.a("pagePath", l);
            if (i2 != -1) {
                ji3Var.a("oldErrorCode", String.valueOf(i2));
            }
            ji3Var.a("oldErrorMsg", str3);
            ji3Var.a("scheme", W2);
            ji3Var.a("appVersion", v1);
            ji3Var.a("swan", i3);
            ji3Var.a("requestid", a2);
            ji3Var.a("net", d);
            if (si4.b() != null) {
                ji3Var.a("SDKVersion", si4.b().b());
                ji3Var.a("hostName", si4.b().c());
            }
            bo3.j(new a(ji3Var), "monitor");
        }
    }
}
