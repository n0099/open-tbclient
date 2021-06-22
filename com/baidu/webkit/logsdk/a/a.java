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
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.webkit.logsdk.d.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static String n;

    /* renamed from: a  reason: collision with root package name */
    public String f26818a;

    /* renamed from: b  reason: collision with root package name */
    public int f26819b;

    /* renamed from: c  reason: collision with root package name */
    public int f26820c;

    /* renamed from: d  reason: collision with root package name */
    public int f26821d;

    /* renamed from: e  reason: collision with root package name */
    public String f26822e;

    /* renamed from: f  reason: collision with root package name */
    public int f26823f;

    /* renamed from: g  reason: collision with root package name */
    public String f26824g;

    /* renamed from: h  reason: collision with root package name */
    public String f26825h;

    /* renamed from: i  reason: collision with root package name */
    public String f26826i;
    public String j;
    public String k;
    public String l;
    public String m;

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
        if (TextUtils.isEmpty(this.f26824g)) {
            int e2 = e(context);
            int f2 = f(context);
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                str = "NULL";
            }
            String str2 = Build.MODEL;
            String str3 = TextUtils.isEmpty(str2) ? "NULL" : str2;
            String str4 = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str4)) {
                str4 = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
            }
            String h2 = h(context);
            String str5 = TextUtils.isEmpty(null) ? "j2" : null;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("bd_");
            stringBuffer.append(e2);
            stringBuffer.append("_");
            stringBuffer.append(f2);
            stringBuffer.append("_");
            stringBuffer.append(str.replace("_", "-") + "*@*" + str3.replace("_", "-") + "*@*" + str4.replace("_", "-"));
            stringBuffer.append("_");
            stringBuffer.append(h2);
            stringBuffer.append("_");
            stringBuffer.append(str5);
            this.f26824g = bVar.a(stringBuffer.toString().replace(".", "-"));
        }
        if (TextUtils.isEmpty(this.f26824g)) {
            throw new RuntimeException("BdLogBase: get ua null!");
        }
        return this.f26824g;
    }

    private String a(com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.f26818a)) {
            this.f26818a = bVar.e();
        }
        if (TextUtils.isEmpty(this.f26818a)) {
            throw new RuntimeException("BdLogBase: get cuid null!");
        }
        return this.f26818a;
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
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return com.baidu.pass.biometrics.face.liveness.b.a.g0;
            }
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
        } catch (Exception e2) {
            c.a(e2);
            return "exception";
        }
    }

    private String b(com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.f26825h)) {
            this.f26825h = bVar.c();
        }
        if (TextUtils.isEmpty(this.f26825h)) {
            throw new RuntimeException("BdLogBase: get from null!");
        }
        return this.f26825h;
    }

    private String c() {
        if (TextUtils.isEmpty(this.l)) {
            this.l = null;
        }
        return this.l;
    }

    private String c(com.baidu.webkit.logsdk.b bVar) {
        if (TextUtils.isEmpty(this.f26826i)) {
            this.f26826i = bVar.d();
        }
        if (TextUtils.isEmpty(this.f26826i)) {
            throw new RuntimeException("BdLogBase: get Cfrom null!");
        }
        return this.f26826i;
    }

    public static boolean c(Context context) {
        b.a().g();
        String b2 = b(context);
        return b2.equals("2g") || b2.equals("3g") || b2.equals("4g");
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String d() {
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
            this.f26819b = displayMetrics.widthPixels;
            this.f26820c = displayMetrics.heightPixels;
            this.f26821d = displayMetrics.densityDpi;
        } catch (Exception e2) {
            c.a(e2);
        }
    }

    private int e(Context context) {
        if (this.f26819b == 0) {
            d(context);
        }
        return this.f26819b;
    }

    public static String e() {
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

    private int f(Context context) {
        if (this.f26820c == 0) {
            d(context);
        }
        return this.f26820c;
    }

    public static String f() {
        return "00100000";
    }

    private int g(Context context) {
        if (this.f26821d == 0) {
            d(context);
        }
        return this.f26821d;
    }

    private String h(Context context) {
        try {
            if (TextUtils.isEmpty(this.f26822e)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.f26822e = packageInfo.versionName;
                this.f26822e = this.f26822e.substring(0, this.f26822e.length() - 1) + "1";
                this.f26823f = packageInfo.versionCode;
                c.e("BdLogSDK", "mVersionName = " + this.f26822e);
            }
            return this.f26822e;
        } catch (Exception e2) {
            c.a(e2);
            return "1.0.0.0";
        }
    }

    private int i(Context context) {
        try {
            if (this.f26823f <= 0) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.f26822e = packageInfo.versionName;
                this.f26822e = this.f26822e.substring(0, this.f26822e.length() - 1) + "1";
                this.f26823f = packageInfo.versionCode;
                c.e("BdLogSDK", "mVersionName = " + this.f26822e);
            }
        } catch (Exception e2) {
            c.a(e2);
        }
        return this.f26823f;
    }

    private String j(Context context) {
        if (TextUtils.isEmpty(this.m)) {
            this.m = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        }
        return this.m;
    }

    public static String k(Context context) {
        if (TextUtils.isEmpty(null)) {
            return b(context);
        }
        return null;
    }

    public final int a(String str, Context context) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == -1643810197) {
            if (str.equals("display_density")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != -102985484) {
            if (hashCode == -19457365 && str.equals(PmsConstant.Statistic.STATISTIC_NETWORK)) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (str.equals("version_code")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return -1;
                }
                return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            }
            return g(context);
        }
        return i(context);
    }

    public final String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseStatisContent.IMSI, d());
            jSONObject.put(AsInstallService.SCHEME_PACKAGE_ADDED, context.getPackageName());
            jSONObject.put("version_code", i(context));
            jSONObject.put("display_density", g(context));
            jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, ((TelephonyManager) context.getSystemService("phone")).getNetworkType());
            jSONObject.put("operator", j(context));
            jSONObject.put("build_display", Build.DISPLAY);
            String e2 = e();
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put("kernel_version", e2);
            }
            if (b.a().c() != null) {
                jSONObject.put("net_type", (Object) null);
                jSONObject.put("sessionId", (Object) null);
                jSONObject.put("zeusVersion", (Object) null);
            }
        } catch (Exception e3) {
            c.a(e3);
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(42:4|(1:6)(1:113)|7|(5:8|9|10|11|(1:13))|(2:15|16)|(3:18|19|(1:21))|23|24|(1:26)|28|29|(1:31)|33|34|(1:36)|(3:38|39|(1:41))|43|(3:44|45|(1:47))|49|50|51|(1:53)|54|55|56|(1:58)|60|61|(1:63)|65|66|(1:68)|70|(1:72)|73|(1:75)|76|(1:78)|79|(1:81)|82|83) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        com.baidu.webkit.logsdk.d.c.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ad, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ae, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f5, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f6, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x011b, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x011c, code lost:
        com.baidu.webkit.logsdk.d.c.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0132, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0133, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0149, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x014a, code lost:
        com.baidu.webkit.logsdk.d.c.a(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: Exception -> 0x0059, TRY_LEAVE, TryCatch #9 {Exception -> 0x0059, blocks: (B:22:0x004a, B:24:0x0050), top: B:121:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[Catch: Exception -> 0x0077, TRY_LEAVE, TryCatch #2 {Exception -> 0x0077, blocks: (B:31:0x0060, B:33:0x006e), top: B:107:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089 A[Catch: Exception -> 0x0092, TRY_LEAVE, TryCatch #5 {Exception -> 0x0092, blocks: (B:37:0x007b, B:39:0x0089), top: B:113:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4 A[Catch: Exception -> 0x00ad, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ad, blocks: (B:43:0x0096, B:45:0x00a4), top: B:103:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf A[Catch: Exception -> 0x00c8, TRY_LEAVE, TryCatch #10 {Exception -> 0x00c8, blocks: (B:49:0x00b1, B:51:0x00bf), top: B:123:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00db A[Catch: Exception -> 0x00e4, TRY_LEAVE, TryCatch #11 {Exception -> 0x00e4, blocks: (B:56:0x00d1, B:58:0x00db), top: B:125:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0112 A[Catch: Exception -> 0x011b, TRY_LEAVE, TryCatch #7 {Exception -> 0x011b, blocks: (B:70:0x010c, B:72:0x0112), top: B:117:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0125 A[Catch: Exception -> 0x0132, TRY_LEAVE, TryCatch #4 {Exception -> 0x0132, blocks: (B:76:0x011f, B:78:0x0125), top: B:111:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0140 A[Catch: Exception -> 0x0149, TRY_LEAVE, TryCatch #1 {Exception -> 0x0149, blocks: (B:82:0x0136, B:84:0x0140), top: B:105:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, String str) {
        String str2;
        String str3;
        String b2;
        String packageName;
        String c2;
        String encode;
        String encode2;
        String encode3;
        String encode4;
        String str4 = "";
        if (TextUtils.isEmpty(str) || context == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        com.baidu.webkit.logsdk.b c3 = b.a().c();
        try {
            str2 = a(context, c3);
            try {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append("ua=");
                    sb.append(str2);
                }
            } catch (Exception e2) {
                e = e2;
                c.a(e);
                str3 = a(c3);
                if (!TextUtils.isEmpty(str3)) {
                }
                encode4 = URLEncoder.encode(c(c3), "UTF-8");
                if (!TextUtils.isEmpty(encode4)) {
                }
                encode3 = URLEncoder.encode(b(c3), "UTF-8");
                if (!TextUtils.isEmpty(encode3)) {
                }
                encode2 = URLEncoder.encode(a(), "UTF-8");
                if (!TextUtils.isEmpty(encode2)) {
                }
                encode = URLEncoder.encode(b(), "UTF-8");
                if (!TextUtils.isEmpty(encode)) {
                }
                sb.append("ctv=2");
                c2 = c();
                if (!TextUtils.isEmpty(c2)) {
                }
                String f2 = f();
                sb.append("&st=");
                sb.append(f2);
                b2 = b(context);
                if (!TextUtils.isEmpty(b2)) {
                }
                if (!TextUtils.isEmpty(null)) {
                }
                if (!TextUtils.isEmpty(null)) {
                }
                packageName = context.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                }
                if (!TextUtils.isEmpty(str2)) {
                }
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!TextUtils.isEmpty(null)) {
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                return sb.toString();
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
        }
        try {
            str3 = a(c3);
        } catch (Exception e4) {
            e = e4;
            str3 = "";
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                sb.append("&cuid=");
                sb.append(str3);
            }
        } catch (Exception e5) {
            e = e5;
            c.a(e);
            encode4 = URLEncoder.encode(c(c3), "UTF-8");
            if (!TextUtils.isEmpty(encode4)) {
            }
            encode3 = URLEncoder.encode(b(c3), "UTF-8");
            if (!TextUtils.isEmpty(encode3)) {
            }
            encode2 = URLEncoder.encode(a(), "UTF-8");
            if (!TextUtils.isEmpty(encode2)) {
            }
            encode = URLEncoder.encode(b(), "UTF-8");
            if (!TextUtils.isEmpty(encode)) {
            }
            sb.append("ctv=2");
            c2 = c();
            if (!TextUtils.isEmpty(c2)) {
            }
            String f22 = f();
            sb.append("&st=");
            sb.append(f22);
            b2 = b(context);
            if (!TextUtils.isEmpty(b2)) {
            }
            if (!TextUtils.isEmpty(null)) {
            }
            if (!TextUtils.isEmpty(null)) {
            }
            packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!TextUtils.isEmpty(null)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            return sb.toString();
        }
        encode4 = URLEncoder.encode(c(c3), "UTF-8");
        if (!TextUtils.isEmpty(encode4)) {
            sb.append("&cfrom=");
            sb.append(encode4);
        }
        encode3 = URLEncoder.encode(b(c3), "UTF-8");
        if (!TextUtils.isEmpty(encode3)) {
            sb.append("&from=");
            sb.append(encode3);
        }
        encode2 = URLEncoder.encode(a(), "UTF-8");
        if (!TextUtils.isEmpty(encode2)) {
            sb.append("&crp=");
            sb.append(encode2);
        }
        try {
            encode = URLEncoder.encode(b(), "UTF-8");
            if (!TextUtils.isEmpty(encode)) {
                sb.append("&it=");
                sb.append(encode);
            }
        } catch (Exception e6) {
            c.a(e6);
        }
        sb.append("ctv=2");
        try {
            c2 = c();
            if (!TextUtils.isEmpty(c2)) {
                sb.append("&seid=");
                sb.append(c2);
            }
        } catch (Exception e7) {
            c.a(e7);
        }
        String f222 = f();
        sb.append("&st=");
        sb.append(f222);
        b2 = b(context);
        if (!TextUtils.isEmpty(b2)) {
            sb.append("&nw=");
            sb.append(b2);
        }
        if (!TextUtils.isEmpty(null)) {
            sb.append("&uid=");
            sb.append((String) null);
        }
        if (!TextUtils.isEmpty(null)) {
            String encode5 = URLEncoder.encode(null, "UTF-8");
            sb.append("&city=");
            sb.append(encode5);
        }
        packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            sb.append("&pkgname=");
            sb.append(packageName);
        }
        if (!TextUtils.isEmpty(str2)) {
            str4 = "ua";
        }
        if (!TextUtils.isEmpty(str3)) {
            str4 = str4 + "_cuid";
        }
        if (!TextUtils.isEmpty(null)) {
            str4 = str4 + "_uid";
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&cen=");
            sb.append(str4);
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String a(String str, Context context, com.baidu.webkit.logsdk.b bVar) {
        char c2;
        switch (str.hashCode()) {
            case -1643810197:
                if (str.equals("display_density")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case -837666831:
                if (str.equals("build_display")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -807062458:
                if (str.equals(AsInstallService.SCHEME_PACKAGE_ADDED)) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -516987305:
                if (str.equals("pkgname")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -500553564:
                if (str.equals("operator")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case -102985484:
                if (str.equals("version_code")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case -19457365:
                if (str.equals(PmsConstant.Statistic.STATISTIC_NETWORK)) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case 3371:
                if (str.equals(AdvanceSetting.NETWORK_TYPE)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3529:
                if (str.equals("nw")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 3724:
                if (str.equals("ua")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 98785:
                if (str.equals("crp")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 98853:
                if (str.equals("ctv")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 115792:
                if (str.equals("uid")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 3053931:
                if (str.equals("city")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 3065101:
                if (str.equals("cuid")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3151786:
                if (str.equals("from")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3236474:
                if (str.equals(BaseStatisContent.IMSI)) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 3526381:
                if (str.equals("seid")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 94580365:
                if (str.equals("cfrom")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 607796817:
                if (str.equals("sessionId")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 999451023:
                if (str.equals("zeusVersion")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 1291458716:
                if (str.equals("net_type")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 1683336973:
                if (str.equals("framework_sid")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 2015527638:
                if (str.equals("kernel_version")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
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
                return null;
            case '\f':
            case '\r':
                return context.getPackageName();
            case 14:
                return d();
            case 15:
                return j(context);
            case 16:
                return Build.DISPLAY;
            case 17:
                return e();
            case 18:
                return k(context);
            case 19:
            case 20:
            case 21:
                return null;
            default:
                return "";
        }
    }

    public final String b(Context context, String str) {
        com.baidu.webkit.logsdk.b.c d2 = b.a().e().d(str);
        if ("full".equals(d2.f26859a)) {
            return a(context);
        }
        HashSet<String> hashSet = d2.f26861c;
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
            } catch (Exception e2) {
                c.a(e2);
            }
        }
        return jSONObject.toString();
    }
}
