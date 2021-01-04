package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.baidu.mobstat.Config;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static String f6904a;

    /* renamed from: b  reason: collision with root package name */
    private static String f6905b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static boolean k;

    private static Context k(Context context) {
        return context == null ? p.a() : context;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f6904a) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(f6904a) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
                f6904a = d.a(k(context)).b("did", (String) null);
            }
        } catch (Exception e2) {
        }
        return f6904a;
    }

    public static String b(Context context) {
        if (h == null && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return h;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f6905b) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return f6905b;
    }

    public static String d(Context context) {
        TTCustomController d2 = i.c().d();
        if (d2 != null && !d2.isCanUsePhoneState()) {
            return d2.getDevImei();
        }
        if (TextUtils.isEmpty(c) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return c;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(i) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return i;
    }

    public static String f(Context context) {
        TTCustomController d2 = i.c().d();
        if (d2 != null && !d2.isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(f) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return f;
    }

    public static String g(Context context) {
        TTCustomController d2 = i.c().d();
        if (d2 != null && !d2.isCanUseWifiState()) {
            return null;
        }
        if (TextUtils.isEmpty(d) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return d;
    }

    public static String h(Context context) {
        TTCustomController d2 = i.c().d();
        if (d2 != null && !d2.isCanUseWifiState()) {
            return null;
        }
        if (TextUtils.isEmpty(e) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return e;
    }

    public static String i(Context context) {
        TTCustomController d2;
        if (Build.VERSION.SDK_INT >= 28 && (d2 = i.c().d()) != null && !d2.isCanUsePhoneState()) {
            return null;
        }
        if (TextUtils.isEmpty(j) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return j;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f6904a)) {
            d.a(context).a("did", str);
            f6904a = str;
        }
        if (!TextUtils.isEmpty(f6904a)) {
            s.b(f6904a).a(f6904a);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    @SuppressLint({"HardwareIds"})
    private static void l(Context context) {
        Context k2;
        if (!k && (k2 = k(context)) != null) {
            try {
                m(k2);
            } catch (Exception e2) {
            }
            try {
                TTCustomController d2 = i.c().d();
                if (d2 != null && d2.isCanUseWifiState() && d2.isCanUseLocation()) {
                    try {
                        WifiManager wifiManager = (WifiManager) k2.getSystemService("wifi");
                        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                        if (connectionInfo != null) {
                            d = connectionInfo.getSSID();
                        }
                        e = a(wifiManager);
                    } catch (Throwable th) {
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    j = Build.getSerial();
                } else {
                    j = Build.SERIAL;
                }
            } catch (Exception e3) {
            }
            f6905b = a(k2, true);
            f6904a = d.a(k2).b("did", (String) null);
            g = a();
            h = String.valueOf(Build.TIME);
            i = d.a(k2).b("uuid", (String) null);
            k = true;
        }
    }

    public static String a(WifiManager wifiManager) {
        String str = Config.DEF_MAC_ID;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (scanResults != null && connectionInfo != null && connectionInfo.getBSSID() != null) {
                    int i2 = 0;
                    while (i2 < scanResults.size()) {
                        ScanResult scanResult = scanResults.get(i2);
                        i2++;
                        str = connectionInfo.getBSSID().equals(scanResult.BSSID) ? scanResult.BSSID : str;
                    }
                }
            } catch (Exception e2) {
            }
        }
        return str;
    }

    public static void j(Context context) {
        Context k2;
        if (TextUtils.isEmpty(c) && (k2 = k(context)) != null) {
            try {
                m(k2);
            } catch (Exception e2) {
            }
        }
    }

    @SuppressLint({"HardwareIds"})
    private static void m(Context context) {
        TelephonyManager telephonyManager;
        TTCustomController d2 = i.c().d();
        if ((d2 == null || d2.isCanUsePhoneState()) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            c = telephonyManager.getDeviceId();
            f = telephonyManager.getSubscriberId();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r0.length() < 13) goto L16;
     */
    @SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized String a(Context context, boolean z) {
        String str = null;
        synchronized (k.class) {
            Context k2 = k(context);
            if (k2 != null) {
                try {
                    str = Settings.Secure.getString(k2.getContentResolver(), "android_id");
                } catch (Exception e2) {
                }
                if (!TextUtils.isEmpty(str)) {
                }
                str = "";
            }
        }
        return str;
    }

    private static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ad.e()) {
                sb.append("MIUI-");
            } else if (ad.b()) {
                sb.append("FLYME-");
            } else {
                String n = ad.n();
                if (ad.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception e2) {
        }
        return sb.toString();
    }
}
