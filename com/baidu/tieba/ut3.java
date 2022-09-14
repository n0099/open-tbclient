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
/* loaded from: classes6.dex */
public class ut3 {
    public static /* synthetic */ Interceptable $ic;
    public static ut3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222485, "Lcom/baidu/tieba/ut3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222485, "Lcom/baidu/tieba/ut3;");
                return;
            }
        }
        a = new ut3();
    }

    public ut3() {
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

    public static ut3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (ut3) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            aa3 aa3Var = new aa3();
            aa3Var.b = "beforeConfigRequest";
            aa3Var.e = str;
            r93.g(aa3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str5 = z != null ? z.configName : "";
            String str6 = z != null ? z.targetAppPackageId : "";
            String str7 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.b = str;
            aa3Var.g = "gbview";
            aa3Var.e = str2;
            aa3Var.a("gameAppkey", str3);
            aa3Var.a("gamePosition", str4);
            aa3Var.a("configName", str5);
            aa3Var.a("targetPackageName", str6);
            aa3Var.a("targetDownloadUrl", str7);
            r93.g(aa3Var);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.b = str;
            aa3Var.g = "gbview";
            aa3Var.a("configName", str2);
            aa3Var.a("targetPackageName", str3);
            aa3Var.a("targetDownloadUrl", str4);
            if (str3.equals(ct3.a)) {
                if (sg3.F(fm2.c(), str3)) {
                    aa3Var.a("isGamenowInstalled", "1");
                } else {
                    aa3Var.a("isGamenowInstalled", "2");
                }
            }
            r93.g(aa3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            aa3 aa3Var = new aa3();
            aa3Var.b = "request";
            aa3Var.g = "wdview";
            aa3Var.a("requestStatus", str);
            aa3Var.a("isFromNet", z ? "0" : "1");
            aa3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            r93.g(aa3Var);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str7 = z != null ? z.configName : "";
            String str8 = z != null ? z.targetAppPackageId : "";
            String str9 = z != null ? z.targetAppDownloadUrl : "";
            if (!TextUtils.equals(str8, ct3.a)) {
                str6 = str9;
            }
            aa3 aa3Var = new aa3();
            aa3Var.b = str;
            aa3Var.g = str2;
            aa3Var.e = str3;
            aa3Var.a("gameAppkey", str4);
            aa3Var.a("gamePosition", str5);
            aa3Var.a("configName", str7);
            aa3Var.a("targetPackageName", str8);
            aa3Var.a("targetDownloadUrl", str6);
            r93.g(aa3Var);
        }
    }

    public void f(String str, tt3 tt3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, tt3Var, str2, str3, str4) == null) {
            JSONObject d = yf3.d(str3);
            vt3 vt3Var = new vt3();
            vt3Var.g(tt3Var);
            vt3Var.b = str;
            vt3Var.g = d.optString("from_view");
            vt3Var.e = d.optString("from_value");
            vt3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            vt3Var.a("targetPackageName", str2);
            vt3Var.a("targetDownloadUrl", str4);
            r93.g(vt3Var);
        }
    }

    public void g(String str, tt3 tt3Var, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, tt3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = yf3.d(str3);
            long optLong = d.optLong("download_finish_time");
            long elapsedRealtime = optLong != 0 ? SystemClock.elapsedRealtime() - optLong : 0L;
            vt3 vt3Var = new vt3();
            vt3Var.g(tt3Var);
            vt3Var.e = d.optString("from_value");
            vt3Var.b = str;
            vt3Var.g = d.optString("from_view");
            vt3Var.a("error_code", Integer.valueOf(i));
            vt3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (elapsedRealtime != 0) {
                vt3Var.a("timeAfterDownload", Long.valueOf(elapsedRealtime));
            }
            vt3Var.a("targetPackageName", str2);
            vt3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                vt3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                vt3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                vt3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            r93.x("936", vt3Var);
        }
    }

    public void h(String str, tt3 tt3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, tt3Var, str2, str3, str4) == null) {
            g(str, tt3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.b = "guideClick";
            aa3Var.g = "wdview";
            aa3Var.a("guideViewNum", String.valueOf(i));
            aa3Var.a("configName", str);
            aa3Var.a("targetPackageName", str2);
            aa3Var.a("targetDownloadUrl", str3);
            r93.g(aa3Var);
        }
    }

    public void j(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.b = "wdDialogClick";
            aa3Var.g = "wdview";
            aa3Var.e = str;
            aa3Var.a("coinsThisTime", String.valueOf(i));
            aa3Var.a("coinsTotal", String.valueOf(i2));
            aa3Var.a("configName", str2);
            aa3Var.a("targetPackageName", str3);
            aa3Var.a("targetDownloadUrl", str4);
            r93.g(aa3Var);
        }
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.b = "wdDialogShow";
            aa3Var.g = "wdview";
            aa3Var.a("coinsThisTime", String.valueOf(i));
            aa3Var.a("coinsTotal", String.valueOf(i2));
            aa3Var.a("configName", str);
            aa3Var.a("targetPackageName", str2);
            aa3Var.a("targetDownloadUrl", str3);
            if (str2.equals(ct3.a)) {
                if (sg3.F(fm2.c(), str2)) {
                    aa3Var.a("isGamenowInstalled", "1");
                } else {
                    aa3Var.a("isGamenowInstalled", "2");
                }
            }
            r93.g(aa3Var);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.b = "guideShow";
            aa3Var.g = "wdview";
            aa3Var.a("configName", str);
            aa3Var.a("targetPackageName", str2);
            aa3Var.a("targetDownloadUrl", str3);
            r93.g(aa3Var);
        }
    }

    public void m(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = xs3.o.z();
            String str3 = z != null ? z.configName : "";
            String str4 = z != null ? z.targetAppPackageId : "";
            String str5 = z != null ? z.targetAppDownloadUrl : "";
            aa3 aa3Var = new aa3();
            aa3Var.g = str;
            aa3Var.e = str2;
            aa3Var.a("configName", str3);
            aa3Var.a("targetPackageName", str4);
            aa3Var.a("targetDownloadUrl", str5);
            aa3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            r93.g(aa3Var);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            o12.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = pz3.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", fm2.h0().i(fm2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", fm2.n().a());
                jSONObject.put("version", sg3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ca4.h(fm2.c()).postRequest().cookieManager(fm2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = pz3.b().d();
            JSONObject jSONObject = new JSONObject();
            String str4 = TextUtils.equals(str, ct3.a) ? "2101000000" : "";
            xs3 xs3Var = xs3.o;
            if (xs3Var != null && xs3Var.z() != null && !TextUtils.isEmpty(xs3.o.z().gamenowChannel)) {
                str4 = xs3.o.z().gamenowChannel;
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
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ca4.h(fm2.c()).postRequest().cookieManager(fm2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
