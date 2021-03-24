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
import com.bytedance.sdk.openadsdk.utils.ae;
import java.util.List;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static String f28450a;

    /* renamed from: b  reason: collision with root package name */
    public static String f28451b;

    /* renamed from: c  reason: collision with root package name */
    public static String f28452c;

    /* renamed from: d  reason: collision with root package name */
    public static String f28453d;

    /* renamed from: e  reason: collision with root package name */
    public static String f28454e;

    /* renamed from: f  reason: collision with root package name */
    public static String f28455f;

    /* renamed from: g  reason: collision with root package name */
    public static String f28456g;

    /* renamed from: h  reason: collision with root package name */
    public static String f28457h;
    public static String i;
    public static String j;
    public static boolean k;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f28450a) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(f28450a) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
                f28450a = d.a(k(context)).b("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return f28450a;
    }

    public static String b(Context context) {
        if (f28457h == null && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return f28457h;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f28451b) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return f28451b;
    }

    public static String d(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 != null && !e2.isCanUsePhoneState()) {
            return e2.getDevImei();
        }
        if (TextUtils.isEmpty(f28452c) && !k) {
            synchronized (k.class) {
                if (!k) {
                    l(context);
                }
            }
        }
        return f28452c;
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
        TTCustomController e2 = i.d().e();
        if (e2 == null || e2.isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f28455f) && !k) {
                synchronized (k.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f28455f;
        }
        return null;
    }

    public static String g(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 == null || e2.isCanUseWifiState()) {
            if (TextUtils.isEmpty(f28453d) && !k) {
                synchronized (k.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f28453d;
        }
        return null;
    }

    public static String h(Context context) {
        TTCustomController e2 = i.d().e();
        if (e2 == null || e2.isCanUseWifiState()) {
            if (TextUtils.isEmpty(f28454e) && !k) {
                synchronized (k.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f28454e;
        }
        return null;
    }

    public static String i(Context context) {
        TTCustomController e2;
        if (Build.VERSION.SDK_INT < 28 || (e2 = i.d().e()) == null || e2.isCanUsePhoneState()) {
            if (TextUtils.isEmpty(j) && !k) {
                synchronized (k.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return j;
        }
        return null;
    }

    public static void j(Context context) {
        Context k2;
        if (TextUtils.isEmpty(f28452c) && (k2 = k(context)) != null) {
            try {
                m(k2);
            } catch (Exception unused) {
            }
        }
    }

    public static Context k(Context context) {
        return context == null ? p.a() : context;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    @SuppressLint({"HardwareIds"})
    public static void l(Context context) {
        Context k2;
        if (k || (k2 = k(context)) == null) {
            return;
        }
        try {
            m(k2);
        } catch (Exception unused) {
        }
        try {
            TTCustomController e2 = i.d().e();
            if (e2 != null && e2.isCanUseWifiState() && e2.isCanUseLocation()) {
                try {
                    WifiManager wifiManager = (WifiManager) k2.getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                    if (connectionInfo != null) {
                        f28453d = connectionInfo.getSSID();
                    }
                    f28454e = a(wifiManager);
                } catch (Throwable unused2) {
                }
            }
            if (Build.VERSION.SDK_INT >= 28) {
                j = Build.getSerial();
            } else {
                j = Build.SERIAL;
            }
        } catch (Exception unused3) {
        }
        f28451b = a(k2, true);
        f28450a = d.a(k2).b("did", (String) null);
        f28456g = a();
        f28457h = String.valueOf(Build.TIME);
        i = d.a(k2).b("uuid", (String) null);
        k = true;
    }

    @SuppressLint({"HardwareIds"})
    public static void m(Context context) {
        TelephonyManager telephonyManager;
        TTCustomController e2 = i.d().e();
        if ((e2 == null || e2.isCanUsePhoneState()) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            f28452c = telephonyManager.getDeviceId();
            f28455f = telephonyManager.getSubscriberId();
        }
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f28450a)) {
            d.a(context).a("did", str);
            f28450a = str;
        }
        if (TextUtils.isEmpty(f28450a)) {
            return;
        }
        s.a().a(f28450a);
    }

    public static String a(WifiManager wifiManager) {
        String str = Config.DEF_MAC_ID;
        if (wifiManager == null) {
            return Config.DEF_MAC_ID;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (scanResults != null && connectionInfo != null && connectionInfo.getBSSID() != null) {
                for (int i2 = 0; i2 < scanResults.size(); i2++) {
                    ScanResult scanResult = scanResults.get(i2);
                    if (connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                        str = scanResult.BSSID;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r0.length() < 13) goto L19;
     */
    @SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context, boolean z) {
        synchronized (k.class) {
            Context k2 = k(context);
            String str = null;
            if (k2 == null) {
                return null;
            }
            try {
                str = Settings.Secure.getString(k2.getContentResolver(), "android_id");
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
            str = "";
            return str;
        }
    }

    public static String a() {
        String a2 = i.a("sdk_local_rom", 604800000L);
        f28456g = a2;
        if (TextUtils.isEmpty(a2)) {
            StringBuilder sb = new StringBuilder();
            try {
                if (ae.e()) {
                    sb.append("MIUI-");
                } else if (ae.b()) {
                    sb.append("FLYME-");
                } else {
                    String n = ae.n();
                    if (ae.a(n)) {
                        sb.append("EMUI-");
                    }
                    if (!TextUtils.isEmpty(n)) {
                        sb.append(n);
                        sb.append("-");
                    }
                }
                sb.append(Build.VERSION.INCREMENTAL);
                String sb2 = sb.toString();
                f28456g = sb2;
                i.a("sdk_local_rom", sb2);
            } catch (Exception unused) {
            }
        }
        return f28456g;
    }
}
