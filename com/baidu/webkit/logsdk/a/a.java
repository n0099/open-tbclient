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
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    private static String n;
    private String a;
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
        if (TextUtils.isEmpty(this.a)) {
            this.a = bVar.e();
        }
        if (TextUtils.isEmpty(this.a)) {
            throw new RuntimeException("BdLogBase: get cuid null!");
        }
        return this.a;
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
            return "fail";
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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"));
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

    /* JADX WARN: Can't wrap try/catch for region: R(50:4|(1:6)(1:111)|7|(2:8|9)|(3:11|12|(1:14))|16|17|18|(1:20)|22|23|(1:25)|27|28|(1:30)|32|33|(1:35)|37|38|(1:40)|42|43|44|(1:46)|48|49|50|(1:52)|53|54|55|(1:57)|59|60|61|(1:63)|65|66|(1:68)|70|(1:72)(1:85)|73|(1:75)|76|(1:78)|79|(1:81)|82|83) */
    /* JADX WARN: Can't wrap try/catch for region: R(51:4|(1:6)(1:111)|7|8|9|(3:11|12|(1:14))|16|17|18|(1:20)|22|23|(1:25)|27|28|(1:30)|32|33|(1:35)|37|38|(1:40)|42|43|44|(1:46)|48|49|50|(1:52)|53|54|55|(1:57)|59|60|61|(1:63)|65|66|(1:68)|70|(1:72)(1:85)|73|(1:75)|76|(1:78)|79|(1:81)|82|83) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b6, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01b7, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01bc, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01bd, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c2, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c3, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01c8, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01c9, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ce, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01cf, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d4, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d5, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01da, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01db, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e0, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e1, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e6, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e7, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ec, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ed, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: Exception -> 0x01b6, TRY_LEAVE, TryCatch #8 {Exception -> 0x01b6, blocks: (B:15:0x0040, B:17:0x004a), top: B:105:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[Catch: Exception -> 0x01bc, TRY_LEAVE, TryCatch #4 {Exception -> 0x01bc, blocks: (B:18:0x0054, B:20:0x0065), top: B:97:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[Catch: Exception -> 0x01c2, TRY_LEAVE, TryCatch #10 {Exception -> 0x01c2, blocks: (B:21:0x006f, B:23:0x0080), top: B:109:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b A[Catch: Exception -> 0x01c8, TRY_LEAVE, TryCatch #6 {Exception -> 0x01c8, blocks: (B:24:0x008a, B:26:0x009b), top: B:101:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6 A[Catch: Exception -> 0x01ce, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ce, blocks: (B:27:0x00a5, B:29:0x00b6), top: B:91:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0 A[Catch: Exception -> 0x01d4, TRY_LEAVE, TryCatch #9 {Exception -> 0x01d4, blocks: (B:31:0x00c6, B:33:0x00d0), top: B:107:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106 A[Catch: Exception -> 0x01e0, TRY_LEAVE, TryCatch #0 {Exception -> 0x01e0, blocks: (B:39:0x0100, B:41:0x0106), top: B:89:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118 A[Catch: Exception -> 0x01e6, TRY_LEAVE, TryCatch #7 {Exception -> 0x01e6, blocks: (B:43:0x0112, B:45:0x0118), top: B:103:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0134 A[Catch: Exception -> 0x01ec, TRY_LEAVE, TryCatch #3 {Exception -> 0x01ec, blocks: (B:46:0x012a, B:48:0x0134), top: B:95:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, String str) {
        String str2;
        Exception e;
        String str3;
        String b;
        String str4;
        String packageName;
        String c;
        String encode;
        String encode2;
        String encode3;
        String encode4;
        if (TextUtils.isEmpty(str) || context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        com.baidu.webkit.logsdk.b c2 = b.a().c();
        try {
            str2 = a(context, c2);
        } catch (Exception e2) {
            str2 = "";
            e = e2;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                sb.append("ua=").append(str2);
            }
        } catch (Exception e3) {
            e = e3;
            com.baidu.webkit.logsdk.d.c.a(e);
            str3 = "";
            str3 = a(c2);
            if (!TextUtils.isEmpty(str3)) {
            }
            encode4 = URLEncoder.encode(c(c2), "UTF-8");
            if (!TextUtils.isEmpty(encode4)) {
            }
            encode3 = URLEncoder.encode(b(c2), "UTF-8");
            if (!TextUtils.isEmpty(encode3)) {
            }
            encode2 = URLEncoder.encode(a(), "UTF-8");
            if (!TextUtils.isEmpty(encode2)) {
            }
            encode = URLEncoder.encode(b(), "UTF-8");
            if (!TextUtils.isEmpty(encode)) {
            }
            sb.append("ctv=2");
            c = c();
            if (!TextUtils.isEmpty(c)) {
            }
            sb.append("&st=").append(f());
            b = b(context);
            if (!TextUtils.isEmpty(b)) {
            }
            if (!TextUtils.isEmpty(null)) {
            }
            if (!TextUtils.isEmpty(null)) {
            }
            packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!TextUtils.isEmpty(null)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            return sb.toString();
        }
        str3 = "";
        str3 = a(c2);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&cuid=").append(str3);
        }
        encode4 = URLEncoder.encode(c(c2), "UTF-8");
        if (!TextUtils.isEmpty(encode4)) {
            sb.append("&cfrom=").append(encode4);
        }
        encode3 = URLEncoder.encode(b(c2), "UTF-8");
        if (!TextUtils.isEmpty(encode3)) {
            sb.append("&from=").append(encode3);
        }
        encode2 = URLEncoder.encode(a(), "UTF-8");
        if (!TextUtils.isEmpty(encode2)) {
            sb.append("&crp=").append(encode2);
        }
        encode = URLEncoder.encode(b(), "UTF-8");
        if (!TextUtils.isEmpty(encode)) {
            sb.append("&it=").append(encode);
        }
        sb.append("ctv=2");
        c = c();
        if (!TextUtils.isEmpty(c)) {
            sb.append("&seid=").append(c);
        }
        sb.append("&st=").append(f());
        b = b(context);
        if (!TextUtils.isEmpty(b)) {
            sb.append("&nw=").append(b);
        }
        if (!TextUtils.isEmpty(null)) {
            sb.append("&uid=").append((String) null);
        }
        if (!TextUtils.isEmpty(null)) {
            sb.append("&city=").append(URLEncoder.encode(null, "UTF-8"));
        }
        packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            sb.append("&pkgname=").append(packageName);
        }
        str4 = TextUtils.isEmpty(str2) ? "" + j.c : "";
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
                if (str.equals(AdvanceSetting.NETWORK_TYPE)) {
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
        if ("full".equals(c.a)) {
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
                    String a = a(next, context, c2);
                    if (TextUtils.isEmpty(a)) {
                        int a2 = a(next, context);
                        if (a2 > 0) {
                            jSONObject.put(next, a2);
                        }
                    } else {
                        jSONObject.put(next, a);
                    }
                }
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
        return jSONObject.toString();
    }
}
