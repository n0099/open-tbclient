package com.baidu.tieba;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v24 {
    public static /* synthetic */ Interceptable $ic;
    public static v24 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188881, "Lcom/baidu/tieba/v24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188881, "Lcom/baidu/tieba/v24;");
                return;
            }
        }
        a = new v24();
    }

    public v24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static v24 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (v24) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            pa2.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            bj3 bj3Var = new bj3();
            bj3Var.b = "beforeConfigRequest";
            bj3Var.e = str;
            si3.g(bj3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str7 = "";
            if (z == null) {
                str5 = "";
            } else {
                str5 = z.configName;
            }
            if (z == null) {
                str6 = "";
            } else {
                str6 = z.targetAppPackageId;
            }
            if (z != null) {
                str7 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = str;
            bj3Var.g = "gbview";
            bj3Var.e = str2;
            bj3Var.a("gameAppkey", str3);
            bj3Var.a("gamePosition", str4);
            bj3Var.a("configName", str5);
            bj3Var.a("targetPackageName", str6);
            bj3Var.a("targetDownloadUrl", str7);
            si3.g(bj3Var);
        }
    }

    public void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str4 = "";
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.configName;
            }
            if (z == null) {
                str3 = "";
            } else {
                str3 = z.targetAppPackageId;
            }
            if (z != null) {
                str4 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = str;
            bj3Var.g = "gbview";
            bj3Var.a("configName", str2);
            bj3Var.a("targetPackageName", str3);
            bj3Var.a("targetDownloadUrl", str4);
            if (str3.equals(d24.a)) {
                if (tp3.F(gv2.c(), str3)) {
                    bj3Var.a("isGamenowInstalled", "1");
                } else {
                    bj3Var.a("isGamenowInstalled", "2");
                }
            }
            si3.g(bj3Var);
        }
    }

    public void i(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str3 = "";
            if (z == null) {
                str = "";
            } else {
                str = z.configName;
            }
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.targetAppPackageId;
            }
            if (z != null) {
                str3 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = "guideClick";
            bj3Var.g = "wdview";
            bj3Var.a("guideViewNum", String.valueOf(i));
            bj3Var.a("configName", str);
            bj3Var.a("targetPackageName", str2);
            bj3Var.a("targetDownloadUrl", str3);
            si3.g(bj3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            bj3 bj3Var = new bj3();
            bj3Var.b = "request";
            bj3Var.g = "wdview";
            bj3Var.a("requestStatus", str);
            if (z) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            bj3Var.a("isFromNet", str3);
            bj3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            si3.g(bj3Var);
            if (TextUtils.equals(str, "fail") || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void j(String str, int i, int i2) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str4 = "";
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.configName;
            }
            if (z == null) {
                str3 = "";
            } else {
                str3 = z.targetAppPackageId;
            }
            if (z != null) {
                str4 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = "wdDialogClick";
            bj3Var.g = "wdview";
            bj3Var.e = str;
            bj3Var.a("coinsThisTime", String.valueOf(i));
            bj3Var.a("coinsTotal", String.valueOf(i2));
            bj3Var.a("configName", str2);
            bj3Var.a("targetPackageName", str3);
            bj3Var.a("targetDownloadUrl", str4);
            si3.g(bj3Var);
        }
    }

    public void m(String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str5 = "";
            if (z == null) {
                str3 = "";
            } else {
                str3 = z.configName;
            }
            if (z == null) {
                str4 = "";
            } else {
                str4 = z.targetAppPackageId;
            }
            if (z != null) {
                str5 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.g = str;
            bj3Var.e = str2;
            bj3Var.a("configName", str3);
            bj3Var.a("targetPackageName", str4);
            bj3Var.a("targetDownloadUrl", str5);
            bj3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            si3.g(bj3Var);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str9 = "";
            if (z == null) {
                str7 = "";
            } else {
                str7 = z.configName;
            }
            if (z == null) {
                str8 = "";
            } else {
                str8 = z.targetAppPackageId;
            }
            if (z != null) {
                str9 = z.targetAppDownloadUrl;
            }
            if (!TextUtils.equals(str8, d24.a)) {
                str6 = str9;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = str;
            bj3Var.g = str2;
            bj3Var.e = str3;
            bj3Var.a("gameAppkey", str4);
            bj3Var.a("gamePosition", str5);
            bj3Var.a("configName", str7);
            bj3Var.a("targetPackageName", str8);
            bj3Var.a("targetDownloadUrl", str6);
            si3.g(bj3Var);
        }
    }

    public void f(String str, u24 u24Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, u24Var, str2, str3, str4) == null) {
            JSONObject d = zo3.d(str3);
            w24 w24Var = new w24();
            w24Var.g(u24Var);
            w24Var.b = str;
            w24Var.g = d.optString("from_view");
            w24Var.e = d.optString("from_value");
            w24Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            w24Var.a("targetPackageName", str2);
            w24Var.a("targetDownloadUrl", str4);
            si3.g(w24Var);
        }
    }

    public void g(String str, u24 u24Var, String str2, String str3, int i, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, u24Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = zo3.d(str3);
            long optLong = d.optLong("download_finish_time");
            if (optLong != 0) {
                j = SystemClock.elapsedRealtime() - optLong;
            } else {
                j = 0;
            }
            w24 w24Var = new w24();
            w24Var.g(u24Var);
            w24Var.e = d.optString("from_value");
            w24Var.b = str;
            w24Var.g = d.optString("from_view");
            w24Var.a("error_code", Integer.valueOf(i));
            w24Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (j != 0) {
                w24Var.a("timeAfterDownload", Long.valueOf(j));
            }
            w24Var.a("targetPackageName", str2);
            w24Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                w24Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                w24Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                w24Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            si3.x("936", w24Var);
        }
    }

    public void h(String str, u24 u24Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, u24Var, str2, str3, str4) == null) {
            g(str, u24Var, str2, str3, 0, str4);
        }
    }

    public void k(int i, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str3 = "";
            if (z == null) {
                str = "";
            } else {
                str = z.configName;
            }
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.targetAppPackageId;
            }
            if (z != null) {
                str3 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = "wdDialogShow";
            bj3Var.g = "wdview";
            bj3Var.a("coinsThisTime", String.valueOf(i));
            bj3Var.a("coinsTotal", String.valueOf(i2));
            bj3Var.a("configName", str);
            bj3Var.a("targetPackageName", str2);
            bj3Var.a("targetDownloadUrl", str3);
            if (str2.equals(d24.a)) {
                if (tp3.F(gv2.c(), str2)) {
                    bj3Var.a("isGamenowInstalled", "1");
                } else {
                    bj3Var.a("isGamenowInstalled", "2");
                }
            }
            si3.g(bj3Var);
        }
    }

    public void l() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = y14.o.z();
            String str3 = "";
            if (z == null) {
                str = "";
            } else {
                str = z.configName;
            }
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.targetAppPackageId;
            }
            if (z != null) {
                str3 = z.targetAppDownloadUrl;
            }
            bj3 bj3Var = new bj3();
            bj3Var.b = "guideShow";
            bj3Var.g = "wdview";
            bj3Var.a("configName", str);
            bj3Var.a("targetPackageName", str2);
            bj3Var.a("targetDownloadUrl", str3);
            si3.g(bj3Var);
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = q84.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", gv2.h0().i(gv2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", gv2.n().a());
                jSONObject.put("version", tp3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) dj4.h(gv2.c()).postRequest().cookieManager(gv2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = q84.b().d();
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(str, d24.a)) {
                str4 = "2101000000";
            } else {
                str4 = "";
            }
            y14 y14Var = y14.o;
            if (y14Var != null && y14Var.z() != null && !TextUtils.isEmpty(y14.o.z().gamenowChannel)) {
                str4 = y14.o.z().gamenowChannel;
            }
            try {
                jSONObject.put("error_code", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("packagename", str);
                jSONObject.put("downloadurl", str2);
                jSONObject.put("channel", str4);
                jSONObject.put("currentBytes", j);
                jSONObject.put("totalBytes", j2);
                jSONObject.put("errorReason", i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("fileMd5", str3);
                }
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) dj4.h(gv2.c()).postRequest().cookieManager(gv2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
