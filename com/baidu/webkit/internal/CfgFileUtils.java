package com.baidu.webkit.internal;

import android.content.SharedPreferences;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes12.dex */
public class CfgFileUtils implements INoProGuard {
    public static final String KEY_ALT_SERVICE = "alt_service";
    public static final String KEY_BACK_DNS_TIME = "back_dns_time";
    public static final String KEY_CLOUDSETTINGS_LASTMODIFY = "cloudsettings_lastmodify";
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
    public static final String KEY_HTTPDNS_AB_STAT = "httpdns_ab_stat";
    public static final String KEY_HTTP_DNS_CACHE = "httpdnscache_v2";
    public static final String KEY_HTTP_DNS_IPV6_ENV = "http_dns_ipv6_env";
    public static final String KEY_HTTP_DNS_NATIVE_CACHE = "http_dns_native_cache";
    public static final String KEY_HTTP_DNS_PERSISTENCE_CACHE = "http_dns_persistence_cache";
    public static final String KEY_HTTP_WORMHOLE_IPLIST = "wormholeIpList";
    public static final String KEY_KEEP_ALIVE_TIME = "keep_alive_time";
    public static final String KEY_ML_MODEL = "MLModel";
    public static final String KEY_ML_MODEL_TIME = "MLModelTime";
    public static final String KEY_NATIVE_HTTPDNS_ENABLED = "native_httpdns_enabled";
    public static final String KEY_PAC_DATA = "pac_data";
    public static final String KEY_PAC_FREE_FLOW_DATA = "pac_free_flow_data";
    public static final String KEY_PAC_FREE_FLOW_LASTMODIFY = "pac_free_flow_lastmodify";
    public static final String KEY_PAC_LASTMODIFY = "pac_lastmodify";
    public static final String KEY_SOCKET_GROUP_NUMBER = "socket_group_number";
    public static final String KEY_URL_CHECK = "urlCheck";
    public static final String KEY_VIDEO_PROXY_DATA = "videoproxy_data";
    public static final String KEY_VIDEO_PROXY_LASTMODIFY = "videoproxy_lastmodify";
    public static final String TAG = "CfgFileUtils";
    public static SharedPreferences mPref;

    private static SharedPreferences gerPrefs() {
        synchronized (CfgFileUtils.class) {
            if (mPref == null) {
                com.baidu.webkit.internal.utils.b.b();
                mPref = WebViewFactory.getContext().getSharedPreferences(GlobalConstants.SDK_CFG_RELATIVE_PATH_V2, 0);
            }
        }
        return mPref;
    }

    public static String get(String str, String str2) {
        return gerPrefs().getString(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String get(String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        if (!z) {
            return get(str, str2);
        }
        com.baidu.webkit.internal.utils.b.b();
        try {
            fileInputStream = new FileInputStream(getFilePath(str));
            try {
                try {
                    byte[] bArr = new byte[10240];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            byteArrayOutputStream.flush();
                            String str3 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                            try {
                                fileInputStream.close();
                                return str3;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return str3;
                            }
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            return null;
        }
    }

    public static boolean get(String str, boolean z) {
        return gerPrefs().getBoolean(str, z);
    }

    public static String getFilePath(String str) {
        return WebViewFactory.getContext().getFilesDir().getAbsolutePath() + File.separator + str + ".cfg";
    }

    public static boolean isExist(String str) {
        com.baidu.webkit.internal.utils.b.b();
        File file = new File(getFilePath(str));
        if (file.isFile() && file.exists()) {
            Log.d(TAG, getFilePath(str) + " is Exist");
            return true;
        }
        Log.d(TAG, getFilePath(str) + " is not Exist");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void save(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(getFilePath(str), false);
                try {
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static void set(String str, String str2) {
        SharedPreferences.Editor edit = gerPrefs().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void set(String str, boolean z) {
        SharedPreferences.Editor edit = gerPrefs().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
