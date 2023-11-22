package com.baidu.tieba;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.SoChecker;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
/* loaded from: classes7.dex */
public class k9a {
    public static /* synthetic */ Interceptable $ic;
    public static OkHttpClient a;
    public static njb b;
    public static long c;
    public static volatile boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947869302, "Lcom/baidu/tieba/k9a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947869302, "Lcom/baidu/tieba/k9a;");
        }
    }

    public static OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b = h();
            sjb sjbVar = new sjb(b);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(15000L, TimeUnit.MILLISECONDS).addInterceptor(sjbVar);
            return builder.build();
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public static njb h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            njb njbVar = new njb(TbadkCoreApplication.getInst().getContext(), "tieba", TbadkCoreApplication.getInst().getCuid(), d());
            b = njbVar;
            return njbVar;
        }
        return (njb) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        InterceptResult invokeV;
        String path;
        boolean equalsIgnoreCase;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            try {
                String externalStorageState = Environment.getExternalStorageState();
                equalsIgnoreCase = externalStorageState.equalsIgnoreCase("mounted");
                if (!equalsIgnoreCase && !Environment.isExternalStorageRemovable() && !externalStorageState.equalsIgnoreCase(SwanKV.FLAVOR_SHARED)) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception unused) {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                path = cacheDir.getPath();
            }
            if (!equalsIgnoreCase && !z) {
                path = context.getCacheDir().getPath();
                if (!path.endsWith(File.separator)) {
                    return path.substring(0, path.length() - 1);
                }
                return path;
            }
            path = context.getExternalCacheDir().getPath();
            if (!path.endsWith(File.separator)) {
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public static OkHttpClient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                a = a();
            }
            return a;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            njb njbVar = b;
            if (njbVar != null && c == 0) {
                c = njbVar.c();
            }
            return c;
        }
        return invokeV.longValue;
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (k9a.class) {
                if (d) {
                    return;
                }
                if (SoChecker.d("libturbonet.so")) {
                    g();
                }
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, null) != null) || d) {
            return;
        }
        d = true;
        try {
            c();
        } catch (Throwable th) {
            d = false;
            th.printStackTrace();
        }
    }

    public static mjb d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            mjb mjbVar = new mjb();
            mjbVar.j(15);
            mjbVar.c(true);
            mjbVar.b(true);
            mjbVar.e(true);
            mjbVar.a("http://tb-video.bdstatic.com|2");
            mjbVar.f(true);
            mjbVar.i("bdns", "bce_http_dns_account_id", hb.a);
            mjbVar.i("bdns", "bce_http_dns_secret", hb.b);
            mjbVar.i("bdns", "bce_http_dns_tag", "tieba");
            mjbVar.i("bdbus", "min_trigger_interval", 180);
            mjbVar.i("bdns", "dual_stack_bdns_cache_policy", 1);
            File file = new File(b(), "turbonetcache");
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    file.mkdirs();
                }
            } else {
                file.mkdirs();
            }
            mjbVar.k(file.getAbsolutePath());
            mjbVar.d(3, Config.FULL_TRACE_LOG_LIMIT);
            mjbVar.i(LocalFilesFilterKt.FILTER_NAME_LOG, "lite_log_in_response_header", Boolean.TRUE);
            mjbVar.i("app", "app_package_name", "com.baidu.tieba");
            mjbVar.i("nq", "network_quality_enabled", Boolean.TRUE);
            mjbVar.i("nq", "watch_all", Boolean.TRUE);
            mjbVar.i("nq", "rejudge_interval_sec", 10);
            mjbVar.i("nq", "weak_window_sec", 30);
            mjbVar.i("nq", "weak_min_cnt", 10);
            mjbVar.i("nq", "probe_enabled", Boolean.FALSE);
            mjbVar.i("nq", "weak_policy_tcp_retrans_enable", Boolean.TRUE);
            mjbVar.i("nq", "weak_policy_tcp_retrans_percentage", 30);
            mjbVar.i("nq", "weak_policy_tcp_recv_len_enable", Boolean.FALSE);
            mjbVar.i("nq", "weak_policy_http_ttfb_enable", Boolean.TRUE);
            mjbVar.i("nq", "weak_policy_http_ttfb_threshold_ms", 800);
            mjbVar.i("nq", "weak_policy_http_ttfb_percentage", 30);
            mjbVar.i("nq", "weak_policy_tcp_rtt_enable", Boolean.TRUE);
            mjbVar.i("nq", "weak_policy_tcp_rtt_threshold_ms", 500);
            mjbVar.i("nq", "weak_policy_tcp_rtt_percentage", 30);
            mjbVar.i("misc", "preconnect_for_alter_quic", Boolean.TRUE);
            return mjbVar;
        }
        return (mjb) invokeV.objValue;
    }
}
