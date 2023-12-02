package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.hr2;
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
public final class qd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md3 a;

        public a(md3 md3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948087945, "Lcom/baidu/tieba/qd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948087945, "Lcom/baidu/tieba/qd3;");
                return;
            }
        }
        a = vm1.a;
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
        s52 J;
        rs1 v3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            md3 md3Var = new md3();
            k63 c0 = k63.c0();
            if (c0 == null || (J = xr2.V().J()) == null || (v3 = J.v3()) == null) {
                return;
            }
            String l = v3.l();
            hr2.a X = c0.X();
            String a0 = c0.a0();
            String appId = c0.getAppId();
            String X2 = X.X();
            String x1 = X.x1();
            String i3 = pf3.i(xr2.V().getCoreVersion(), X.H());
            String a2 = a(response);
            String d = NetworkUtils.d();
            md3Var.a = dd3.n(X.H());
            md3Var.c = c0.X().U();
            md3Var.d = c0.X().W();
            md3Var.f = appId;
            md3Var.a("name", a0);
            md3Var.a("apiName", str);
            md3Var.a(CloudStabilityUBCUtils.KEY_ERROR_CODE, String.valueOf(i));
            md3Var.a("errorMsg", str2);
            md3Var.a("pagePath", l);
            if (i2 != -1) {
                md3Var.a("oldErrorCode", String.valueOf(i2));
            }
            md3Var.a("oldErrorMsg", str3);
            md3Var.a("scheme", X2);
            md3Var.a("appVersion", x1);
            md3Var.a("swan", i3);
            md3Var.a("requestid", a2);
            md3Var.a("net", d);
            if (vd4.b() != null) {
                md3Var.a("SDKVersion", vd4.b().b());
                md3Var.a("hostName", vd4.b().c());
            }
            ej3.j(new a(md3Var), "monitor");
        }
    }
}
