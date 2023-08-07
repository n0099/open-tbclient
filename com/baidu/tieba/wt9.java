package com.baidu.tieba;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
/* loaded from: classes8.dex */
public class wt9 {
    public static /* synthetic */ Interceptable $ic;
    public static OkHttpClient a;
    public static y0b b;
    public static long c;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948282253, "Lcom/baidu/tieba/wt9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948282253, "Lcom/baidu/tieba/wt9;");
        }
    }

    public static OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b = g();
            d1b d1bVar = new d1b(b);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(15000L, TimeUnit.MILLISECONDS).addInterceptor(d1bVar);
            return builder.build();
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public static y0b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            y0b y0bVar = new y0b(TbadkCoreApplication.getInst().getContext(), "tieba", TbadkCoreApplication.getInst().getCuid(), d());
            b = y0bVar;
            return y0bVar;
        }
        return (y0b) invokeV.objValue;
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
            y0b y0bVar = b;
            if (y0bVar != null && c == 0) {
                c = y0bVar.c();
            }
            return c;
        }
        return invokeV.longValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65542, null) != null) || d) {
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

    public static x0b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            x0b x0bVar = new x0b();
            x0bVar.j(15);
            x0bVar.c(true);
            x0bVar.b(true);
            x0bVar.e(true);
            x0bVar.a("http://tb-video.bdstatic.com|2");
            x0bVar.f(true);
            x0bVar.i("bdns", "bce_http_dns_account_id", "119799");
            x0bVar.i("bdns", "bce_http_dns_secret", "87JNTZjGacgUzuMBYvid");
            x0bVar.i("bdns", "bce_http_dns_tag", "tieba");
            x0bVar.i("bdbus", "min_trigger_interval", 180);
            x0bVar.i("bdns", "dual_stack_bdns_cache_policy", 1);
            File file = new File(b(), "turbonetcache");
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    file.mkdirs();
                }
            } else {
                file.mkdirs();
            }
            x0bVar.k(file.getAbsolutePath());
            x0bVar.d(3, Config.FULL_TRACE_LOG_LIMIT);
            x0bVar.i(LocalFilesFilterKt.FILTER_NAME_LOG, "lite_log_in_response_header", Boolean.TRUE);
            x0bVar.i("app", "app_package_name", "com.baidu.tieba");
            x0bVar.i("nq", "network_quality_enabled", Boolean.TRUE);
            x0bVar.i("nq", "watch_all", Boolean.TRUE);
            x0bVar.i("nq", "rejudge_interval_sec", 10);
            x0bVar.i("nq", "weak_window_sec", 30);
            x0bVar.i("nq", "weak_min_cnt", 10);
            x0bVar.i("nq", "probe_enabled", Boolean.FALSE);
            x0bVar.i("nq", "weak_policy_tcp_retrans_enable", Boolean.TRUE);
            x0bVar.i("nq", "weak_policy_tcp_retrans_percentage", 30);
            x0bVar.i("nq", "weak_policy_tcp_recv_len_enable", Boolean.FALSE);
            x0bVar.i("nq", "weak_policy_http_ttfb_enable", Boolean.TRUE);
            x0bVar.i("nq", "weak_policy_http_ttfb_threshold_ms", 800);
            x0bVar.i("nq", "weak_policy_http_ttfb_percentage", 30);
            x0bVar.i("nq", "weak_policy_tcp_rtt_enable", Boolean.TRUE);
            x0bVar.i("nq", "weak_policy_tcp_rtt_threshold_ms", 500);
            x0bVar.i("nq", "weak_policy_tcp_rtt_percentage", 30);
            x0bVar.i("misc", "preconnect_for_alter_quic", Boolean.TRUE);
            return x0bVar;
        }
        return (x0b) invokeV.objValue;
    }
}
