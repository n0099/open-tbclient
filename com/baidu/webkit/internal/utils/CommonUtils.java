package com.baidu.webkit.internal.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.WebKitFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class CommonUtils implements INoProGuard {
    private static final boolean DEBUG = false;
    private static final String TAG = "CommonUtils";
    protected static final String URL_KEY_APP_VERSION = "appversion";
    protected static final String URL_KEY_BLINK_VER = "zeus_ver";
    protected static final String URL_KEY_SDK_APP = "app";
    protected static final String URL_KEY_ZEUS_SDK = "sdk";
    private static String[] sFiledsSysMemInfo = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};

    private static void appendUrlParam(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append(ETAG.EQUAL);
        sb.append(str2);
        sb.append(ETAG.ITEM_SEPARATOR);
    }

    public static boolean checkPermissionGranted(Context context, String str) {
        return str != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static boolean checkPhonePermission(Context context) {
        if (context == null) {
            return false;
        }
        try {
            boolean z = checkPermissionGranted(context, "android.permission.CALL_PHONE") || checkPermissionGranted(context, "android.permission.MODIFY_PHONE_STATE") || checkPermissionGranted(context, "android.permission.READ_PHONE_STATE") || checkPermissionGranted(context, "android.permission.PROCESS_OUTGOING_CALLS");
            if (Build.VERSION.SDK_INT >= 16) {
                if (!z) {
                    if (!checkPermissionGranted(context, "android.permission.READ_CALL_LOG")) {
                        return false;
                    }
                }
                return true;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String getCookieValue(String str, String str2) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager == null) {
            return null;
        }
        String cookie = cookieManager.getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return null;
        }
        String[] split = cookie.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        int length = split.length;
        for (int i = 0; i != length; i++) {
            String[] split2 = split[i].trim().split(ETAG.EQUAL);
            if (split2.length == 2 && TextUtils.equals(str2, split2[0])) {
                return split2[1];
            }
        }
        return null;
    }

    public static String getQueryParameter(String str, String str2) {
        int length = str.length();
        int indexOf = str.indexOf("?") + 1;
        while (true) {
            int indexOf2 = str.indexOf(38, indexOf);
            int i = indexOf2 != -1 ? indexOf2 : length;
            int indexOf3 = str.indexOf(61, indexOf);
            if (indexOf3 > i || indexOf3 == -1) {
                indexOf3 = i;
            }
            if (indexOf3 - indexOf == str2.length() && str.regionMatches(indexOf, str2, 0, str2.length())) {
                return indexOf3 == i ? "" : str.substring(indexOf3 + 1, i);
            } else if (indexOf2 == -1) {
                return null;
            } else {
                indexOf = indexOf2 + 1;
            }
        }
    }

    public static Map<String, Long> getSysMemoryInfo() {
        HashMap hashMap = new HashMap();
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            if (method != null) {
                long[] jArr = new long[sFiledsSysMemInfo.length];
                jArr[0] = 30;
                jArr[1] = -30;
                method.invoke(null, "/proc/meminfo", sFiledsSysMemInfo, jArr);
                for (int i = 0; i < jArr.length; i++) {
                    hashMap.put(sFiledsSysMemInfo[i], Long.valueOf(jArr[i]));
                }
                return hashMap;
            }
            return hashMap;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        } catch (NoSuchMethodException e4) {
            return null;
        } catch (SecurityException e5) {
            return null;
        } catch (InvocationTargetException e6) {
            return null;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            com.a.a.a.a.a.a.a.a(e);
            return "0.8";
        }
    }

    public static String processUrl(String str, Context context) {
        if (context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        String versionName = WebKitVersionBlink.getVersionName();
        String sdkVersionName = WebKitFactory.getSdkVersionName();
        appendUrlParam(sb, "zeus_ver", versionName);
        appendUrlParam(sb, "sdk", sdkVersionName);
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            appendUrlParam(sb, "app", packageName);
        }
        String versionName2 = getVersionName(context);
        if (!TextUtils.isEmpty(versionName2)) {
            appendUrlParam(sb, "appversion", versionName2);
        }
        return sb.toString();
    }
}
