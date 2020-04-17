package com.baidu.tieba.play.cyberPlayer;

import android.content.Context;
import android.os.Environment;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.turbonet.net.OkHttp3Interceptor;
import com.baidu.turbonet.net.TurbonetConfig;
import com.baidu.turbonet.net.TurbonetContext;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class c {
    private static OkHttpClient kiV;
    private static TurbonetContext kiW;
    private static long kiX = 0;
    private static boolean sInited = false;

    public static void init() {
        if (!sInited) {
            sInited = true;
            try {
                getOkHttpClient();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static OkHttpClient getOkHttpClient() {
        if (kiV == null) {
            kiV = build();
        }
        return kiV;
    }

    private static OkHttpClient build() {
        kiW = cKz();
        OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor(kiW);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(15000L, TimeUnit.MILLISECONDS).addInterceptor(okHttp3Interceptor);
        return builder.build();
    }

    private static TurbonetContext cKz() {
        TurbonetContext turbonetContext = new TurbonetContext(TbadkCoreApplication.getInst().getContext(), "tieba", TbadkCoreApplication.getInst().getCuid(), cKA());
        kiW = turbonetContext;
        return turbonetContext;
    }

    private static TurbonetConfig cKA() {
        TurbonetConfig turbonetConfig = new TurbonetConfig();
        turbonetConfig.setRequestTimeout(15);
        turbonetConfig.vk(true);
        turbonetConfig.vn(true);
        turbonetConfig.vm(true);
        turbonetConfig.MY("http://tb-video.bdstatic.com|2");
        turbonetConfig.vl(true);
        turbonetConfig.d("bdns", "bce_http_dns_account_id", "119799");
        turbonetConfig.d("bdns", "bce_http_dns_secret", "87JNTZjGacgUzuMBYvid");
        turbonetConfig.d("bdbus", "min_trigger_interval", 180);
        turbonetConfig.d("bdns", "dual_stack_bdns_cache_policy", 0);
        File file = new File(getCachePath(), "turbonetcache");
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                file.mkdirs();
            }
        } else {
            file.mkdirs();
        }
        turbonetConfig.MX(file.getAbsolutePath());
        turbonetConfig.z(3, 10485760L);
        turbonetConfig.d(TbConfig.TMP_LOG_DIR_NAME, "lite_log_in_response_header", true);
        turbonetConfig.d("app", "app_package_name", "com.baidu.tieba");
        turbonetConfig.d("nq", "network_quality_enabled", true);
        turbonetConfig.d("nq", "watch_all", true);
        turbonetConfig.d("nq", "rejudge_interval_sec", 10);
        turbonetConfig.d("nq", "weak_window_sec", 30);
        turbonetConfig.d("nq", "weak_min_cnt", 10);
        turbonetConfig.d("nq", "probe_enabled", false);
        turbonetConfig.d("nq", "weak_policy_tcp_retrans_enable", true);
        turbonetConfig.d("nq", "weak_policy_tcp_retrans_percentage", 30);
        turbonetConfig.d("nq", "weak_policy_tcp_recv_len_enable", false);
        turbonetConfig.d("nq", "weak_policy_http_ttfb_enable", true);
        turbonetConfig.d("nq", "weak_policy_http_ttfb_threshold_ms", 800);
        turbonetConfig.d("nq", "weak_policy_http_ttfb_percentage", 30);
        turbonetConfig.d("nq", "weak_policy_tcp_rtt_enable", true);
        turbonetConfig.d("nq", "weak_policy_tcp_rtt_threshold_ms", 500);
        turbonetConfig.d("nq", "weak_policy_tcp_rtt_percentage", 30);
        turbonetConfig.d("misc", "preconnect_for_alter_quic", true);
        return turbonetConfig;
    }

    public static long cKB() {
        if (kiW != null && kiX == 0) {
            kiX = kiW.djH();
        }
        return kiX;
    }

    public static String getCachePath() {
        String path;
        Context context = TbadkCoreApplication.getInst().getContext();
        try {
            String externalStorageState = Environment.getExternalStorageState();
            boolean equalsIgnoreCase = externalStorageState.equalsIgnoreCase("mounted");
            boolean z = (equalsIgnoreCase || Environment.isExternalStorageRemovable() || externalStorageState.equalsIgnoreCase("shared")) ? false : true;
            if (equalsIgnoreCase || z) {
                path = context.getExternalCacheDir().getPath();
            } else {
                path = context.getCacheDir().getPath();
            }
        } catch (Exception e) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            path = cacheDir.getPath();
        }
        if (path.endsWith(File.separator)) {
            return path.substring(0, path.length() - 1);
        }
        return path;
    }
}
