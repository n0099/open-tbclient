package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mv3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986079, "Lcom/baidu/tieba/mv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986079, "Lcom/baidu/tieba/mv3;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(String str, String str2, String str3, String str4, kv3 kv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, kv3Var) == null) {
            String l = lv3.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (a) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            lv3 lv3Var = new lv3();
            lv3Var.m(kv3Var);
            lv3Var.b = l;
            lv3Var.e = str3;
            lv3Var.v = str;
            lv3Var.l = fh3.D();
            if (l33.b0() != null) {
                io2.a W = l33.b0().W();
                lv3Var.a = ea3.n(W.G());
                lv3Var.f = W.H();
                lv3Var.c = W.T();
            }
            lv3Var.t = str4;
            ea3.x("1245", lv3Var);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            c(str, str2, "");
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            String l = lv3.l(str);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            lv3 lv3Var = new lv3();
            lv3Var.b = l;
            lv3Var.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            lv3Var.a("packageName", str3);
            ea3.x("1245", lv3Var);
        }
    }

    public static void d(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = c04.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", sm2.h0().i(sm2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", sm2.n().a());
                jSONObject.put("version", fh3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) pa4.h(sm2.c()).postRequest().cookieManager(sm2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
