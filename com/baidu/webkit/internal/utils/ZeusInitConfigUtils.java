package com.baidu.webkit.internal.utils;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.baidu.webkit.sdk.WebViewFactory;
@Keep
/* loaded from: classes5.dex */
public class ZeusInitConfigUtils {
    public static final String KEY_ENGINE_CLOUDSETTINGS_DATA = "engineCloudSettingsData";
    public static final String KEY_ENGINE_CLOUDSETTINGS_TIME = "engineCloudSettingsTime";
    public static final String NAME_CLOUDDATA = "zeus_init_config";
    public static final String PREF_KEY_NO_ZEUS_UNDER_5 = "no_zeus_under_5";
    public static final String PREF_KEY_SDK_VERSION = "sdk_version";
    public static SharedPreferences mSharePrefs;

    public static String get(String str, String str2) {
        return getPrefs().getString(str, str2);
    }

    public static boolean get(String str, boolean z) {
        return getPrefs().getBoolean(str, z);
    }

    public static SharedPreferences getPrefs() {
        synchronized (ZeusInitConfigUtils.class) {
            if (mSharePrefs == null) {
                mSharePrefs = WebViewFactory.getContext().getSharedPreferences(NAME_CLOUDDATA, 0);
            }
        }
        return mSharePrefs;
    }

    public static void set(String str, String str2) {
        SharedPreferences.Editor edit = getPrefs().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void set(String str, boolean z) {
        SharedPreferences.Editor edit = getPrefs().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
