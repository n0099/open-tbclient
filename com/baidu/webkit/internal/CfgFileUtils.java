package com.baidu.webkit.internal;

import android.content.SharedPreferences;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes2.dex */
public class CfgFileUtils implements INoProGuard {
    public static final String KEY_CRONET_AB_STAT = "croent_ab_stat";
    public static final String KEY_ENGINE_BROWSING_COUNT = "engineBrowsingCount";
    public static final String KEY_ENGINE_CLOUDSETTINGS_DATA = "engineCloudSettingsData";
    public static final String KEY_ENGINE_CLOUDSETTINGS_TIME = "engineCloudSettingsTime";
    public static final String KEY_ENGINE_STAT_DATA = "engineStatData";
    public static final String KEY_ENGINE_STAT_TIME = "engineStatTime";
    public static final String KEY_ENGINE_VERSION = "engineVersion";
    public static final String KEY_FAKE_BAIDU_MODEL = "fakeBaiduModel";
    public static final String KEY_FAKE_BAIDU_MODEL_TIME = "fakeBaiduModelTime";
    public static final String KEY_FAKE_BAIDU_WHITE_LIST = "fakeBaiduWhiteList";
    public static final String KEY_FAKE_BAIDU_WHITE_LIST_TIME = "fakeBaiduWhiteListTime";
    public static final String KEY_HTTP_DNS_CACHE = "httpdnscache";
    public static final String KEY_HTTP_WORMHOLE_IPLIST = "wormholeIpList";
    public static final String KEY_ML_MODEL = "MLModel";
    public static final String KEY_ML_MODEL_TIME = "MLModelTime";
    public static final String KEY_URL_CHECK = "urlCheck";

    private static SharedPreferences gerPrefs() {
        return WebViewFactory.getContext().getSharedPreferences(GlobalConstants.SDK_CFG_RELATIVE_PATH, 0);
    }

    public static synchronized String get(String str, String str2) {
        String string;
        synchronized (CfgFileUtils.class) {
            string = gerPrefs().getString(str, str2);
        }
        return string;
    }

    public static synchronized boolean get(String str, boolean z) {
        boolean z2;
        synchronized (CfgFileUtils.class) {
            z2 = gerPrefs().getBoolean(str, z);
        }
        return z2;
    }

    public static synchronized void set(String str, String str2) {
        synchronized (CfgFileUtils.class) {
            SharedPreferences.Editor edit = gerPrefs().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static synchronized void set(String str, boolean z) {
        synchronized (CfgFileUtils.class) {
            SharedPreferences.Editor edit = gerPrefs().edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }
}
