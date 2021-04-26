package com.baidu.wallet.core;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.domain.c;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes5.dex */
public final class DebugConfig {
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String F = "https://www.baifubao.com";
    public static final String PASS_COMPLETE_VERIFY = "pass_complete_verify";
    public static final String SERVER_COMPLETE_VERIFY = "http://wappass.baidu.com/v2/?bindingret";
    public static final String SERVICE = "service";
    public static final String VOICE_API_HOST_DFT = "https://wallet.baidu.com";
    public static final String VOICE_SERVICE_URL_DFT = "https://wallet.baidu.com";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24643a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f24644b = "wallet_config.properties";

    /* renamed from: c  reason: collision with root package name */
    public static final String f24645c = "wallet_https_host";

    /* renamed from: d  reason: collision with root package name */
    public static final String f24646d = "wallet_passport_host";

    /* renamed from: e  reason: collision with root package name */
    public static final String f24647e = "environment";

    /* renamed from: f  reason: collision with root package name */
    public static final String f24648f = "wallet_plugin_host";

    /* renamed from: g  reason: collision with root package name */
    public static final String f24649g = "wallet_nfc_host";

    /* renamed from: h  reason: collision with root package name */
    public static final String f24650h = "wallet_web_cache_host";

    /* renamed from: i  reason: collision with root package name */
    public static final String f24651i = "voiceprint_service";
    public static final String j = "voiceprint_host";
    public static final String k = "wallet_stat_host";
    public static final String l = "wallet_stat_strategy_host";
    public static final String m = "wallet_sensor_stat_host";
    public static final String n = "wallet_coupon_host";
    public static final String o = "wallet_comet_push_host";
    public static String p = "https://www.baifubao.com";
    public static String q = "http://www.baifubao.com";
    public static String r = "http://wappass.baidu.com/passport";
    public static String s = "https://chong.baidu.com";
    public static String t = "https://wallet.baidu.com";
    public static String u = "https://wallet.baidu.com";
    public static String v = "https://wallet.baidu.com";
    public static String w = "https://www.baifubao.com";
    public static String x = "https://www.baifubao.com";
    public static String y = "https://www.baifubao.com";
    public static String z = "https://datasink.dxmpay.com";
    public File D;
    public Properties E;
    public static String A = DomainConfig.getInstance().getCometHost();
    public static String LBS_HOST = DomainConfig.getInstance().getZhiFuHost();
    public static String B = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
    public static DebugConfig C = null;

    public DebugConfig(Context context) {
        this.D = null;
        if (context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            File externalFilesDir = context.getExternalFilesDir("");
            if (externalFilesDir != null && !externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            this.D = new File(externalFilesDir, f24644b);
        } else {
            this.D = new File(String.valueOf(Environment.getExternalStorageDirectory()), f24644b);
        }
        this.E = b();
    }

    private void a() {
        c.a().a(a("life_host"));
        c.a().d(a("app_host"));
        c.a().f(a(c.n));
        c.a().h(a(c.p));
        c.a().k(a("comet_host"));
        c.a().c(a(c.k));
        c.a().g(a(c.o));
        c.a().e(a("nfc_host"));
        c.a().b(a("my_host"));
        c.a().i(a(c.q));
        c.a().j(a(c.r));
        c.a().l(a("wallet_web_cache_host"));
        DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA);
        String a2 = a(k);
        w = a2;
        if (TextUtils.isEmpty(a2)) {
            w = "https://www.baifubao.com";
        }
        String a3 = a(l);
        x = a3;
        if (TextUtils.isEmpty(a3)) {
            x = "https://www.baifubao.com";
        }
        String a4 = a(m);
        z = a4;
        if (TextUtils.isEmpty(a4)) {
            z = "https://datasink.dxmpay.com";
        }
    }

    private Properties b() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(this.D);
                } catch (IOException unused) {
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            LogUtil.d("DebugConfig", "the wallet_config.properties is not exist!!");
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return properties;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        return properties;
    }

    public static synchronized DebugConfig getInstance(Context context) {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (C == null) {
                C = new DebugConfig(context);
            }
            debugConfig = C;
        }
        return debugConfig;
    }

    public void changeOnline() {
        f24643a = false;
        p = "https://www.baifubao.com";
        r = "https://wappass.baidu.com/passport/";
        s = "https://chong.baidu.com";
        LBS_HOST = DomainConfig.getInstance().getZhiFuHost();
        t = "https://wallet.baidu.com";
        DEFAULT_ENVIRONMENT = "ONLINE";
        A = DomainConfig.getInstance().getCometHost();
        u = "https://wallet.baidu.com";
        v = "https://wallet.baidu.com";
        w = "https://www.baifubao.com";
        x = "https://www.baifubao.com";
        y = "https://www.baifubao.com";
    }

    public void changeQA() {
        f24643a = true;
        DEFAULT_ENVIRONMENT = "QA";
        readConfigHost(true);
    }

    public String getCometPushHttps() {
        return A;
    }

    public String getCouponHost() {
        return t;
    }

    public String getEnvironment() {
        if (f24643a) {
            return a(f24647e);
        }
        return DEFAULT_ENVIRONMENT;
    }

    public String getFixedWalletHttpsHostForH5() {
        return "https://www.baifubao.com";
    }

    public String getProperty(String str, String str2) {
        if (!f24643a) {
            LogUtil.logd("没有打开DEBUG开关 返回默认值=" + str2);
            return str2;
        }
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            LogUtil.logd("配置文件没有配置 返回默认值=" + str2);
            return str2;
        }
        LogUtil.logd("返回配置文件的值 value=" + a2);
        return a2;
    }

    public String getSenorStatisticsHost() {
        return z;
    }

    public String getStatStrategyHost() {
        if (isOnline()) {
            return DomainConfig.getInstance().getLifeHost();
        }
        return x;
    }

    public String getStatisticsHost() {
        if (isOnline()) {
            return DomainConfig.getInstance().getAppHost();
        }
        return w;
    }

    public String getVoiceprintHost() {
        return v;
    }

    public String getVoiceprintServiceUrl() {
        return u;
    }

    public String getWalletHttpsHost() {
        return p;
    }

    public String getWalletNfcHost() {
        return s;
    }

    public String getWalletPassportHost() {
        return r;
    }

    public String getWalletPluginHost() {
        return B;
    }

    public String getWebCacheHost() {
        return y;
    }

    public boolean isOnline() {
        return "ONLINE".equals(getEnvironment());
    }

    public void readConfigHost(boolean z2) {
        f24643a = z2;
        if (z2) {
            a();
        } else {
            p = "https://www.baifubao.com";
            r = "https://wappass.baidu.com/passport/";
            B = "https://www.baifubao.com/wireless/0/config?cate[plugin]&_app=wallet";
            s = "https://chong.baidu.com";
            t = "https://wallet.baidu.com";
            A = DomainConfig.getInstance().getCometHost();
            u = "https://wallet.baidu.com";
            v = "https://wallet.baidu.com";
            w = "https://www.baifubao.com";
            x = "https://www.baifubao.com";
            y = "https://www.baifubao.com";
            z = "https://datasink.dxmpay.com";
        }
        RestDebugConfig.getInstance().setQAEnv(z2);
    }

    public void setCometPushHttps(String str) {
        A = str;
    }

    public void setWalletHttpsHost(String str) {
        p = str;
    }

    public static synchronized DebugConfig getInstance() {
        DebugConfig debugConfig;
        synchronized (DebugConfig.class) {
            if (C == null) {
                C = new DebugConfig(null);
            }
            debugConfig = C;
        }
        return debugConfig;
    }

    private String a(String str) {
        Properties b2 = b();
        this.E = b2;
        return b2.getProperty(str);
    }
}
