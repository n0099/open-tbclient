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
/* loaded from: classes5.dex */
public class py3 {
    public static /* synthetic */ Interceptable $ic;
    public static py3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948078335, "Lcom/baidu/tieba/py3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948078335, "Lcom/baidu/tieba/py3;");
                return;
            }
        }
        a = new py3();
    }

    public py3() {
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

    public static py3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (py3) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            j62.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ve3 ve3Var = new ve3();
            ve3Var.b = "beforeConfigRequest";
            ve3Var.e = str;
            me3.g(ve3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.b = str;
            ve3Var.g = "gbview";
            ve3Var.e = str2;
            ve3Var.a("gameAppkey", str3);
            ve3Var.a("gamePosition", str4);
            ve3Var.a("configName", str5);
            ve3Var.a("targetPackageName", str6);
            ve3Var.a("targetDownloadUrl", str7);
            me3.g(ve3Var);
        }
    }

    public void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.b = str;
            ve3Var.g = "gbview";
            ve3Var.a("configName", str2);
            ve3Var.a("targetPackageName", str3);
            ve3Var.a("targetDownloadUrl", str4);
            if (str3.equals(xx3.a)) {
                if (nl3.F(ar2.c(), str3)) {
                    ve3Var.a("isGamenowInstalled", "1");
                } else {
                    ve3Var.a("isGamenowInstalled", "2");
                }
            }
            me3.g(ve3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            ve3 ve3Var = new ve3();
            ve3Var.b = "request";
            ve3Var.g = "wdview";
            ve3Var.a("requestStatus", str);
            if (z) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            ve3Var.a("isFromNet", str3);
            ve3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            me3.g(ve3Var);
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
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.b = "wdDialogClick";
            ve3Var.g = "wdview";
            ve3Var.e = str;
            ve3Var.a("coinsThisTime", String.valueOf(i));
            ve3Var.a("coinsTotal", String.valueOf(i2));
            ve3Var.a("configName", str2);
            ve3Var.a("targetPackageName", str3);
            ve3Var.a("targetDownloadUrl", str4);
            me3.g(ve3Var);
        }
    }

    public void m(String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.g = str;
            ve3Var.e = str2;
            ve3Var.a("configName", str3);
            ve3Var.a("targetPackageName", str4);
            ve3Var.a("targetDownloadUrl", str5);
            ve3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            me3.g(ve3Var);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            if (!TextUtils.equals(str8, xx3.a)) {
                str6 = str9;
            }
            ve3 ve3Var = new ve3();
            ve3Var.b = str;
            ve3Var.g = str2;
            ve3Var.e = str3;
            ve3Var.a("gameAppkey", str4);
            ve3Var.a("gamePosition", str5);
            ve3Var.a("configName", str7);
            ve3Var.a("targetPackageName", str8);
            ve3Var.a("targetDownloadUrl", str6);
            me3.g(ve3Var);
        }
    }

    public void f(String str, oy3 oy3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, oy3Var, str2, str3, str4) == null) {
            JSONObject d = tk3.d(str3);
            qy3 qy3Var = new qy3();
            qy3Var.g(oy3Var);
            qy3Var.b = str;
            qy3Var.g = d.optString("from_view");
            qy3Var.e = d.optString("from_value");
            qy3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            qy3Var.a("targetPackageName", str2);
            qy3Var.a("targetDownloadUrl", str4);
            me3.g(qy3Var);
        }
    }

    public void g(String str, oy3 oy3Var, String str2, String str3, int i, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, oy3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = tk3.d(str3);
            long optLong = d.optLong("download_finish_time");
            if (optLong != 0) {
                j = SystemClock.elapsedRealtime() - optLong;
            } else {
                j = 0;
            }
            qy3 qy3Var = new qy3();
            qy3Var.g(oy3Var);
            qy3Var.e = d.optString("from_value");
            qy3Var.b = str;
            qy3Var.g = d.optString("from_view");
            qy3Var.a("error_code", Integer.valueOf(i));
            qy3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (j != 0) {
                qy3Var.a("timeAfterDownload", Long.valueOf(j));
            }
            qy3Var.a("targetPackageName", str2);
            qy3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                qy3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                qy3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                qy3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            me3.x("936", qy3Var);
        }
    }

    public void h(String str, oy3 oy3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, oy3Var, str2, str3, str4) == null) {
            g(str, oy3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.b = "guideClick";
            ve3Var.g = "wdview";
            ve3Var.a("guideViewNum", String.valueOf(i));
            ve3Var.a("configName", str);
            ve3Var.a("targetPackageName", str2);
            ve3Var.a("targetDownloadUrl", str3);
            me3.g(ve3Var);
        }
    }

    public void k(int i, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.b = "wdDialogShow";
            ve3Var.g = "wdview";
            ve3Var.a("coinsThisTime", String.valueOf(i));
            ve3Var.a("coinsTotal", String.valueOf(i2));
            ve3Var.a("configName", str);
            ve3Var.a("targetPackageName", str2);
            ve3Var.a("targetDownloadUrl", str3);
            if (str2.equals(xx3.a)) {
                if (nl3.F(ar2.c(), str2)) {
                    ve3Var.a("isGamenowInstalled", "1");
                } else {
                    ve3Var.a("isGamenowInstalled", "2");
                }
            }
            me3.g(ve3Var);
        }
    }

    public void l() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = sx3.o.z();
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
            ve3 ve3Var = new ve3();
            ve3Var.b = "guideShow";
            ve3Var.g = "wdview";
            ve3Var.a("configName", str);
            ve3Var.a("targetPackageName", str2);
            ve3Var.a("targetDownloadUrl", str3);
            me3.g(ve3Var);
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = k44.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", ar2.h0().i(ar2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", ar2.n().a());
                jSONObject.put("version", nl3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) xe4.h(ar2.c()).postRequest().cookieManager(ar2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = k44.b().d();
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(str, xx3.a)) {
                str4 = "2101000000";
            } else {
                str4 = "";
            }
            sx3 sx3Var = sx3.o;
            if (sx3Var != null && sx3Var.z() != null && !TextUtils.isEmpty(sx3.o.z().gamenowChannel)) {
                str4 = sx3.o.z().gamenowChannel;
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
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) xe4.h(ar2.c()).postRequest().cookieManager(ar2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
