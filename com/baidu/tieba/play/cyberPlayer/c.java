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
    private static TurbonetContext mEA;
    private static OkHttpClient mEz;
    private static long mEB = 0;
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
        if (mEz == null) {
            mEz = build();
        }
        return mEz;
    }

    private static OkHttpClient build() {
        mEA = dCh();
        OkHttp3Interceptor okHttp3Interceptor = new OkHttp3Interceptor(mEA);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(15000L, TimeUnit.MILLISECONDS).addInterceptor(okHttp3Interceptor);
        return builder.build();
    }

    private static TurbonetContext dCh() {
        TurbonetContext turbonetContext = new TurbonetContext(TbadkCoreApplication.getInst().getContext(), "tieba", TbadkCoreApplication.getInst().getCuid(), dCi());
        mEA = turbonetContext;
        return turbonetContext;
    }

    private static TurbonetConfig dCi() {
        TurbonetConfig turbonetConfig = new TurbonetConfig();
        turbonetConfig.setRequestTimeout(15);
        turbonetConfig.Ag(true);
        turbonetConfig.Aj(true);
        turbonetConfig.Ai(true);
        turbonetConfig.WY("http://tb-video.bdstatic.com|2");
        turbonetConfig.Ah(true);
        turbonetConfig.e("bdns", "bce_http_dns_account_id", "119799");
        turbonetConfig.e("bdns", "bce_http_dns_secret", "87JNTZjGacgUzuMBYvid");
        turbonetConfig.e("bdbus", "min_trigger_interval", 180);
        turbonetConfig.e("bdns", "dual_stack_bdns_cache_policy", 0);
        File file = new File(getCachePath(), "turbonetcache");
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                file.mkdirs();
            }
        } else {
            file.mkdirs();
        }
        turbonetConfig.WX(file.getAbsolutePath());
        turbonetConfig.B(3, 10485760L);
        turbonetConfig.e(TbConfig.TMP_LOG_DIR_NAME, "lite_log_in_response_header", true);
        turbonetConfig.e("app", "app_package_name", "com.baidu.tieba");
        turbonetConfig.e("nq", "network_quality_enabled", true);
        turbonetConfig.e("nq", "watch_all", true);
        turbonetConfig.e("nq", "rejudge_interval_sec", 10);
        turbonetConfig.e("nq", "weak_window_sec", 30);
        turbonetConfig.e("nq", "weak_min_cnt", 10);
        turbonetConfig.e("nq", "probe_enabled", false);
        turbonetConfig.e("nq", "weak_policy_tcp_retrans_enable", true);
        turbonetConfig.e("nq", "weak_policy_tcp_retrans_percentage", 30);
        turbonetConfig.e("nq", "weak_policy_tcp_recv_len_enable", false);
        turbonetConfig.e("nq", "weak_policy_http_ttfb_enable", true);
        turbonetConfig.e("nq", "weak_policy_http_ttfb_threshold_ms", 800);
        turbonetConfig.e("nq", "weak_policy_http_ttfb_percentage", 30);
        turbonetConfig.e("nq", "weak_policy_tcp_rtt_enable", true);
        turbonetConfig.e("nq", "weak_policy_tcp_rtt_threshold_ms", 500);
        turbonetConfig.e("nq", "weak_policy_tcp_rtt_percentage", 30);
        turbonetConfig.e("misc", "preconnect_for_alter_quic", true);
        return turbonetConfig;
    }

    public static long dCj() {
        if (mEA != null && mEB == 0) {
            mEB = mEA.eig();
        }
        return mEB;
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
