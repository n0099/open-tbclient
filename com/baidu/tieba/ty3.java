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
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ty3 {
    public static /* synthetic */ Interceptable $ic;
    public static ty3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948197499, "Lcom/baidu/tieba/ty3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948197499, "Lcom/baidu/tieba/ty3;");
                return;
            }
        }
        a = new ty3();
    }

    public ty3() {
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

    public static ty3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (ty3) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n62.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ze3 ze3Var = new ze3();
            ze3Var.b = "beforeConfigRequest";
            ze3Var.e = str;
            qe3.g(ze3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.b = str;
            ze3Var.g = "gbview";
            ze3Var.e = str2;
            ze3Var.a("gameAppkey", str3);
            ze3Var.a("gamePosition", str4);
            ze3Var.a("configName", str5);
            ze3Var.a("targetPackageName", str6);
            ze3Var.a("targetDownloadUrl", str7);
            qe3.g(ze3Var);
        }
    }

    public void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.b = str;
            ze3Var.g = "gbview";
            ze3Var.a("configName", str2);
            ze3Var.a("targetPackageName", str3);
            ze3Var.a("targetDownloadUrl", str4);
            if (str3.equals(by3.a)) {
                if (rl3.F(er2.c(), str3)) {
                    ze3Var.a("isGamenowInstalled", "1");
                } else {
                    ze3Var.a("isGamenowInstalled", "2");
                }
            }
            qe3.g(ze3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            ze3 ze3Var = new ze3();
            ze3Var.b = "request";
            ze3Var.g = "wdview";
            ze3Var.a("requestStatus", str);
            if (z) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            ze3Var.a("isFromNet", str3);
            ze3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            qe3.g(ze3Var);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void j(String str, int i, int i2) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.b = "wdDialogClick";
            ze3Var.g = "wdview";
            ze3Var.e = str;
            ze3Var.a("coinsThisTime", String.valueOf(i));
            ze3Var.a("coinsTotal", String.valueOf(i2));
            ze3Var.a("configName", str2);
            ze3Var.a("targetPackageName", str3);
            ze3Var.a("targetDownloadUrl", str4);
            qe3.g(ze3Var);
        }
    }

    public void m(String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.g = str;
            ze3Var.e = str2;
            ze3Var.a("configName", str3);
            ze3Var.a("targetPackageName", str4);
            ze3Var.a("targetDownloadUrl", str5);
            ze3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            qe3.g(ze3Var);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            if (!TextUtils.equals(str8, by3.a)) {
                str6 = str9;
            }
            ze3 ze3Var = new ze3();
            ze3Var.b = str;
            ze3Var.g = str2;
            ze3Var.e = str3;
            ze3Var.a("gameAppkey", str4);
            ze3Var.a("gamePosition", str5);
            ze3Var.a("configName", str7);
            ze3Var.a("targetPackageName", str8);
            ze3Var.a("targetDownloadUrl", str6);
            qe3.g(ze3Var);
        }
    }

    public void f(String str, sy3 sy3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, sy3Var, str2, str3, str4) == null) {
            JSONObject d = xk3.d(str3);
            uy3 uy3Var = new uy3();
            uy3Var.g(sy3Var);
            uy3Var.b = str;
            uy3Var.g = d.optString("from_view");
            uy3Var.e = d.optString("from_value");
            uy3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            uy3Var.a("targetPackageName", str2);
            uy3Var.a("targetDownloadUrl", str4);
            qe3.g(uy3Var);
        }
    }

    public void g(String str, sy3 sy3Var, String str2, String str3, int i, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, sy3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = xk3.d(str3);
            long optLong = d.optLong("download_finish_time");
            if (optLong != 0) {
                j = SystemClock.elapsedRealtime() - optLong;
            } else {
                j = 0;
            }
            uy3 uy3Var = new uy3();
            uy3Var.g(sy3Var);
            uy3Var.e = d.optString("from_value");
            uy3Var.b = str;
            uy3Var.g = d.optString("from_view");
            uy3Var.a("error_code", Integer.valueOf(i));
            uy3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (j != 0) {
                uy3Var.a("timeAfterDownload", Long.valueOf(j));
            }
            uy3Var.a("targetPackageName", str2);
            uy3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                uy3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                uy3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                uy3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            qe3.x("936", uy3Var);
        }
    }

    public void h(String str, sy3 sy3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, sy3Var, str2, str3, str4) == null) {
            g(str, sy3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.b = "guideClick";
            ze3Var.g = "wdview";
            ze3Var.a("guideViewNum", String.valueOf(i));
            ze3Var.a("configName", str);
            ze3Var.a("targetPackageName", str2);
            ze3Var.a("targetDownloadUrl", str3);
            qe3.g(ze3Var);
        }
    }

    public void k(int i, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.b = "wdDialogShow";
            ze3Var.g = "wdview";
            ze3Var.a("coinsThisTime", String.valueOf(i));
            ze3Var.a("coinsTotal", String.valueOf(i2));
            ze3Var.a("configName", str);
            ze3Var.a("targetPackageName", str2);
            ze3Var.a("targetDownloadUrl", str3);
            if (str2.equals(by3.a)) {
                if (rl3.F(er2.c(), str2)) {
                    ze3Var.a("isGamenowInstalled", "1");
                } else {
                    ze3Var.a("isGamenowInstalled", "2");
                }
            }
            qe3.g(ze3Var);
        }
    }

    public void l() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = wx3.o.z();
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
            ze3 ze3Var = new ze3();
            ze3Var.b = "guideShow";
            ze3Var.g = "wdview";
            ze3Var.a("configName", str);
            ze3Var.a("targetPackageName", str2);
            ze3Var.a("targetDownloadUrl", str3);
            qe3.g(ze3Var);
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = o44.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", er2.h0().i(er2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", er2.n().a());
                jSONObject.put("version", rl3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) bf4.h(er2.c()).postRequest().cookieManager(er2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = o44.b().d();
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(str, by3.a)) {
                str4 = "2101000000";
            } else {
                str4 = "";
            }
            wx3 wx3Var = wx3.o;
            if (wx3Var != null && wx3Var.z() != null && !TextUtils.isEmpty(wx3.o.z().gamenowChannel)) {
                str4 = wx3.o.z().gamenowChannel;
            }
            try {
                jSONObject.put("error_code", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("packagename", str);
                jSONObject.put("downloadurl", str2);
                jSONObject.put("channel", str4);
                jSONObject.put("currentBytes", j);
                jSONObject.put("totalBytes", j2);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("fileMd5", str3);
                }
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) bf4.h(er2.c()).postRequest().cookieManager(er2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
