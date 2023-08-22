package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.aw2;
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
/* loaded from: classes6.dex */
public final class ji3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;

        public a(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kh3.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947884213, "Lcom/baidu/tieba/ji3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947884213, "Lcom/baidu/tieba/ji3;");
                return;
            }
        }
        a = nr1.a;
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
        la2 H;
        jx1 q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            fi3 fi3Var = new fi3();
            db3 b0 = db3.b0();
            if (b0 == null || (H = qw2.T().H()) == null || (q3 = H.q3()) == null) {
                return;
            }
            String l = q3.l();
            aw2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            String W2 = W.W();
            String v1 = W.v1();
            String i3 = ik3.i(qw2.T().getCoreVersion(), W.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            fi3Var.a = wh3.n(W.G());
            fi3Var.c = b0.W().T();
            fi3Var.d = b0.W().V();
            fi3Var.f = appId;
            fi3Var.a("name", Z);
            fi3Var.a("apiName", str);
            fi3Var.a("errorCode", String.valueOf(i));
            fi3Var.a("errorMsg", str2);
            fi3Var.a("pagePath", l);
            if (i2 != -1) {
                fi3Var.a("oldErrorCode", String.valueOf(i2));
            }
            fi3Var.a("oldErrorMsg", str3);
            fi3Var.a("scheme", W2);
            fi3Var.a("appVersion", v1);
            fi3Var.a("swan", i3);
            fi3Var.a("requestid", a2);
            fi3Var.a("net", d);
            if (oi4.b() != null) {
                fi3Var.a("SDKVersion", oi4.b().b());
                fi3Var.a("hostName", oi4.b().c());
            }
            xn3.j(new a(fi3Var), "monitor");
        }
    }
}
