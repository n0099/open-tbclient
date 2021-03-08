package com.baidu.webkit.logsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class a {
    private static String n;

    /* renamed from: a  reason: collision with root package name */
    private String f3844a;
    private int b;
    private int c;
    private int d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    public a(Context context) {
        d(context);
        d();
    }

    private String a() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = null;
        }
        return this.j;
    }

    private String a(Context context, com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.g)) {
            if (this.b == 0) {
                d(context);
            }
            int i = this.b;
            if (this.c == 0) {
                d(context);
            }
            int i2 = this.c;
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                str = "NULL";
            }
            String str2 = Build.MODEL;
            if (TextUtils.isEmpty(str2)) {
                str2 = "NULL";
            }
            String str3 = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str3)) {
                str3 = "0.0";
            }
            String f = f(context);
            String str4 = TextUtils.isEmpty(null) ? "j2" : null;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("bd_");
            stringBuffer.append(i);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(i2);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER) + "*@*" + str2.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER) + "*@*" + str3.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(f);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(str4);
            this.g = bVar.a(stringBuffer.toString().replace(".", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        }
        if (TextUtils.isEmpty(this.g)) {
            throw new RuntimeException("BdLogBase: get ua null!");
        }
        return this.g;
    }

    private String a(com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.f3844a)) {
            this.f3844a = bVar.e();
        }
        if (TextUtils.isEmpty(this.f3844a)) {
            throw new RuntimeException("BdLogBase: get cuid null!");
        }
        return this.f3844a;
    }

    private String b() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = null;
        }
        return this.k;
    }

    public static String b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2g";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3g";
                        case 13:
                            return "4g";
                        default:
                            return "unknown";
                    }
                }
                return "unknown";
            }
            return com.baidu.pass.biometrics.face.liveness.c.a.p;
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
            return "exception";
        }
    }

    private String b(com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.h)) {
            this.h = bVar.c();
        }
        if (TextUtils.isEmpty(this.h)) {
            throw new RuntimeException("BdLogBase: get from null!");
        }
        return this.h;
    }

    private String c() {
        if (TextUtils.isEmpty(this.l)) {
            this.l = null;
        }
        return this.l;
    }

    private String c(com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.i)) {
            this.i = bVar.d();
        }
        if (TextUtils.isEmpty(this.i)) {
            throw new RuntimeException("BdLogBase: get Cfrom null!");
        }
        return this.i;
    }

    public static boolean c(Context context) {
        b.a().g();
        String b = b(context);
        return b.equals("2g") || b.equals("3g") || b.equals("4g");
    }

    @SuppressLint({"HardwareIds"})
    private static synchronized String d() {
        String str;
        synchronized (a.class) {
            if (n == null) {
                n = "";
                b.a().c();
            }
            str = n;
        }
        return str;
    }

    private void d(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.b = displayMetrics.widthPixels;
            this.c = displayMetrics.heightPixels;
            this.d = displayMetrics.densityDpi;
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
    }

    private int e(Context context) {
        if (this.d == 0) {
            d(context);
        }
        return this.d;
    }

    private static String e() {
        if (Build.VERSION.SDK_INT >= 26) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return readLine;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String f() {
        return "00100000";
    }

    private String f(Context context) {
        try {
            if (TextUtils.isEmpty(this.e)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.e = packageInfo.versionName;
                this.e = this.e.substring(0, this.e.length() - 1) + "1";
                this.f = packageInfo.versionCode;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mVersionName = " + this.e);
            }
            return this.e;
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
            return "1.0.0.0";
        }
    }

    private int g(Context context) {
        try {
            if (this.f <= 0) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.e = packageInfo.versionName;
                this.e = this.e.substring(0, this.e.length() - 1) + "1";
                this.f = packageInfo.versionCode;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mVersionName = " + this.e);
            }
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        return this.f;
    }

    private String h(Context context) {
        if (TextUtils.isEmpty(this.m)) {
            this.m = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        }
        return this.m;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int a(String str, Context context) {
        char c;
        switch (str.hashCode()) {
            case -1643810197:
                if (str.equals("display_density")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -102985484:
                if (str.equals("version_code")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -19457365:
                if (str.equals(HttpConstants.NETWORK_TYPE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return g(context);
            case 1:
                return e(context);
            case 2:
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            default:
                return -1;
        }
    }

    public final String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imsi", d());
            jSONObject.put("package", context.getPackageName());
            jSONObject.put("version_code", g(context));
            jSONObject.put("display_density", e(context));
            jSONObject.put(HttpConstants.NETWORK_TYPE, ((TelephonyManager) context.getSystemService("phone")).getNetworkType());
            jSONObject.put("operator", h(context));
            jSONObject.put("build_display", Build.DISPLAY);
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("kernel_version", e);
            }
            if (b.a().c() != null) {
                jSONObject.put("net_type", (Object) null);
                jSONObject.put("sessionId", (Object) null);
                jSONObject.put("zeusVersion", (Object) null);
            }
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
        return jSONObject.toString();
    }

    public final String a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        com.baidu.webkit.logsdk.b c = b.a().c();
        String str2 = "";
        try {
            str2 = a(context, c);
            if (!TextUtils.isEmpty(str2)) {
                sb.append("ua=").append(str2);
            }
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        String str3 = "";
        try {
            str3 = a(c);
            if (!TextUtils.isEmpty(str3)) {
                sb.append("&cuid=").append(str3);
            }
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
        try {
            String encode = URLEncoder.encode(c(c), "UTF-8");
            if (!TextUtils.isEmpty(encode)) {
                sb.append("&cfrom=").append(encode);
            }
        } catch (Exception e3) {
            com.baidu.webkit.logsdk.d.c.a(e3);
        }
        try {
            String encode2 = URLEncoder.encode(b(c), "UTF-8");
            if (!TextUtils.isEmpty(encode2)) {
                sb.append("&from=").append(encode2);
            }
        } catch (Exception e4) {
            com.baidu.webkit.logsdk.d.c.a(e4);
        }
        try {
            String encode3 = URLEncoder.encode(a(), "UTF-8");
            if (!TextUtils.isEmpty(encode3)) {
                sb.append("&crp=").append(encode3);
            }
        } catch (Exception e5) {
            com.baidu.webkit.logsdk.d.c.a(e5);
        }
        try {
            String encode4 = URLEncoder.encode(b(), "UTF-8");
            if (!TextUtils.isEmpty(encode4)) {
                sb.append("&it=").append(encode4);
            }
        } catch (Exception e6) {
            com.baidu.webkit.logsdk.d.c.a(e6);
        }
        sb.append("ctv=2");
        try {
            String c2 = c();
            if (!TextUtils.isEmpty(c2)) {
                sb.append("&seid=").append(c2);
            }
        } catch (Exception e7) {
            com.baidu.webkit.logsdk.d.c.a(e7);
        }
        try {
            sb.append("&st=").append(f());
        } catch (Exception e8) {
            com.baidu.webkit.logsdk.d.c.a(e8);
        }
        String b = b(context);
        if (!TextUtils.isEmpty(b)) {
            sb.append("&nw=").append(b);
        }
        try {
            if (!TextUtils.isEmpty(null)) {
                sb.append("&uid=").append((String) null);
            }
        } catch (Exception e9) {
            com.baidu.webkit.logsdk.d.c.a(e9);
        }
        try {
            if (!TextUtils.isEmpty(null)) {
                sb.append("&city=").append(URLEncoder.encode(null, "UTF-8"));
            }
        } catch (Exception e10) {
            com.baidu.webkit.logsdk.d.c.a(e10);
        }
        try {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                sb.append("&pkgname=").append(packageName);
            }
        } catch (Exception e11) {
            com.baidu.webkit.logsdk.d.c.a(e11);
        }
        String str4 = !TextUtils.isEmpty(str2) ? "" + j.c : "";
        if (!TextUtils.isEmpty(str3)) {
            str4 = str4 + "_cuid";
        }
        if (!TextUtils.isEmpty(null)) {
            str4 = str4 + "_uid";
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&cen=").append(str4);
        }
        return sb.toString();
    }

    public final String a(String str, Context context, com.baidu.webkit.logsdk.b bVar) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1643810197:
                if (str.equals("display_density")) {
                    c = 23;
                    break;
                }
                break;
            case -837666831:
                if (str.equals("build_display")) {
                    c = 16;
                    break;
                }
                break;
            case -807062458:
                if (str.equals("package")) {
                    c = '\r';
                    break;
                }
                break;
            case -516987305:
                if (str.equals("pkgname")) {
                    c = '\f';
                    break;
                }
                break;
            case -500553564:
                if (str.equals("operator")) {
                    c = 15;
                    break;
                }
                break;
            case -102985484:
                if (str.equals("version_code")) {
                    c = 24;
                    break;
                }
                break;
            case -19457365:
                if (str.equals(HttpConstants.NETWORK_TYPE)) {
                    c = 22;
                    break;
                }
                break;
            case 3371:
                if (str.equals("it")) {
                    c = 5;
                    break;
                }
                break;
            case 3529:
                if (str.equals("nw")) {
                    c = '\t';
                    break;
                }
                break;
            case 3681:
                if (str.equals("st")) {
                    c = '\b';
                    break;
                }
                break;
            case 3724:
                if (str.equals(j.c)) {
                    c = 1;
                    break;
                }
                break;
            case 98785:
                if (str.equals("crp")) {
                    c = 4;
                    break;
                }
                break;
            case 98853:
                if (str.equals("ctv")) {
                    c = 6;
                    break;
                }
                break;
            case 115792:
                if (str.equals("uid")) {
                    c = '\n';
                    break;
                }
                break;
            case 3053931:
                if (str.equals("city")) {
                    c = 11;
                    break;
                }
                break;
            case 3065101:
                if (str.equals("cuid")) {
                    c = 0;
                    break;
                }
                break;
            case 3151786:
                if (str.equals("from")) {
                    c = 3;
                    break;
                }
                break;
            case 3236474:
                if (str.equals("imsi")) {
                    c = 14;
                    break;
                }
                break;
            case 3526381:
                if (str.equals("seid")) {
                    c = 7;
                    break;
                }
                break;
            case 94580365:
                if (str.equals(BdStatsConstant.StatsKey.CURRENT_CHANNEL)) {
                    c = 2;
                    break;
                }
                break;
            case 607796817:
                if (str.equals("sessionId")) {
                    c = 19;
                    break;
                }
                break;
            case 999451023:
                if (str.equals("zeusVersion")) {
                    c = 21;
                    break;
                }
                break;
            case 1291458716:
                if (str.equals("net_type")) {
                    c = 18;
                    break;
                }
                break;
            case 1683336973:
                if (str.equals("framework_sid")) {
                    c = 20;
                    break;
                }
                break;
            case 2015527638:
                if (str.equals("kernel_version")) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a(bVar);
            case 1:
                return a(context, bVar);
            case 2:
                return c(bVar);
            case 3:
                return b(bVar);
            case 4:
                return a();
            case 5:
                return b();
            case 6:
                return "2";
            case 7:
                return c();
            case '\b':
                return f();
            case '\t':
                return b(context);
            case '\n':
            case 11:
            case 19:
            case 20:
            case 21:
                return null;
            case '\f':
            case '\r':
                return context.getPackageName();
            case 14:
                return d();
            case 15:
                return h(context);
            case 16:
                return Build.DISPLAY;
            case 17:
                return e();
            case 18:
                if (TextUtils.isEmpty(null)) {
                    return b(context);
                }
                return null;
            default:
                return "";
        }
    }

    public final String b(Context context, String str) {
        com.baidu.webkit.logsdk.b.c c = b.a().e().c(str);
        if ("full".equals(c.f3852a)) {
            return a(context);
        }
        HashSet<String> hashSet = c.c;
        JSONObject jSONObject = new JSONObject();
        if (hashSet != null) {
            try {
                com.baidu.webkit.logsdk.b c2 = b.a().c();
                Iterator<String> it = hashSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String a2 = a(next, context, c2);
                    if (TextUtils.isEmpty(a2)) {
                        int a3 = a(next, context);
                        if (a3 > 0) {
                            jSONObject.put(next, a3);
                        }
                    } else {
                        jSONObject.put(next, a2);
                    }
                }
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
        return jSONObject.toString();
    }
}
