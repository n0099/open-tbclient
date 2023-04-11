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
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.webkit.logsdk.d.c;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static String n;
    public String a;
    public int b;
    public int c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
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
        if (TextUtils.isEmpty(this.g)) {
            int e = e(context);
            int f = f(context);
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                str = "NULL";
            }
            String str2 = Build.MODEL;
            String str3 = TextUtils.isEmpty(str2) ? "NULL" : str2;
            String str4 = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str4)) {
                str4 = "0.0";
            }
            String h = h(context);
            String str5 = TextUtils.isEmpty(null) ? "j2" : null;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("bd_");
            stringBuffer.append(e);
            stringBuffer.append("_");
            stringBuffer.append(f);
            stringBuffer.append("_");
            stringBuffer.append(str.replace("_", "-") + "*@*" + str3.replace("_", "-") + "*@*" + str4.replace("_", "-"));
            stringBuffer.append("_");
            stringBuffer.append(h);
            stringBuffer.append("_");
            stringBuffer.append(str5);
            this.g = bVar.a(stringBuffer.toString().replace(".", "-"));
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
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return com.baidu.pass.biometrics.face.liveness.b.a.g0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 20) {
                    switch (subtype) {
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
                return "5g";
            }
            return "unknown";
        } catch (Exception e) {
            c.a(e);
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
        return b.equals("2g") || b.equals("3g") || b.equals("4g") || b.equals("5g");
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
            this.b = displayMetrics.widthPixels;
            this.c = displayMetrics.heightPixels;
            this.d = displayMetrics.densityDpi;
        } catch (Exception e) {
            c.a(e);
        }
    }

    private int e(Context context) {
        if (this.b == 0) {
            d(context);
        }
        return this.b;
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
        if (this.c == 0) {
            d(context);
        }
        return this.c;
    }

    public static String f() {
        return "0010000" + TransactionIdCreater.FILL_BYTE;
    }

    private int g(Context context) {
        if (this.d == 0) {
            d(context);
        }
        return this.d;
    }

    private String h(Context context) {
        try {
            if (TextUtils.isEmpty(this.e)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.e = packageInfo.versionName;
                this.e = this.e.substring(0, this.e.length() - 1) + "1";
                this.f = packageInfo.versionCode;
                c.e("BdLogSDK", "mVersionName = " + this.e);
            }
            return this.e;
        } catch (Exception e) {
            c.a(e);
            return "1.0.0.0";
        }
    }

    private int i(Context context) {
        try {
            if (this.f <= 0) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.e = packageInfo.versionName;
                this.e = this.e.substring(0, this.e.length() - 1) + "1";
                this.f = packageInfo.versionCode;
                c.e("BdLogSDK", "mVersionName = " + this.e);
            }
        } catch (Exception e) {
            c.a(e);
        }
        return this.f;
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
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1643810197) {
            if (str.equals("display_density")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != -102985484) {
            if (hashCode == -19457365 && str.equals("network_type")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("version_code")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
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
            jSONObject.put("package", context.getPackageName());
            jSONObject.put("version_code", i(context));
            jSONObject.put("display_density", g(context));
            jSONObject.put("network_type", ((TelephonyManager) context.getSystemService("phone")).getNetworkType());
            jSONObject.put("operator", j(context));
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
            c.a(e2);
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
        String b;
        String packageName;
        String c;
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
        com.baidu.webkit.logsdk.b c2 = b.a().c();
        try {
            str2 = a(context, c2);
            try {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append("ua=");
                    sb.append(str2);
                }
            } catch (Exception e) {
                e = e;
                c.a(e);
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
                String f = f();
                sb.append("&st=");
                sb.append(f);
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
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        try {
            str3 = a(c2);
        } catch (Exception e3) {
            e = e3;
            str3 = "";
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                sb.append("&cuid=");
                sb.append(str3);
            }
        } catch (Exception e4) {
            e = e4;
            c.a(e);
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
            String f2 = f();
            sb.append("&st=");
            sb.append(f2);
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
        encode4 = URLEncoder.encode(c(c2), "UTF-8");
        if (!TextUtils.isEmpty(encode4)) {
            sb.append("&cfrom=");
            sb.append(encode4);
        }
        encode3 = URLEncoder.encode(b(c2), "UTF-8");
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
        } catch (Exception e5) {
            c.a(e5);
        }
        sb.append("ctv=2");
        try {
            c = c();
            if (!TextUtils.isEmpty(c)) {
                sb.append("&seid=");
                sb.append(c);
            }
        } catch (Exception e6) {
            c.a(e6);
        }
        String f22 = f();
        sb.append("&st=");
        sb.append(f22);
        b = b(context);
        if (!TextUtils.isEmpty(b)) {
            sb.append("&nw=");
            sb.append(b);
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
        char c;
        switch (str.hashCode()) {
            case -1643810197:
                if (str.equals("display_density")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -837666831:
                if (str.equals("build_display")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -807062458:
                if (str.equals("package")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -516987305:
                if (str.equals("pkgname")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -500553564:
                if (str.equals("operator")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -102985484:
                if (str.equals("version_code")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -19457365:
                if (str.equals("network_type")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 3371:
                if (str.equals(AdvanceSetting.NETWORK_TYPE)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3529:
                if (str.equals("nw")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3724:
                if (str.equals("ua")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 98785:
                if (str.equals("crp")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 98853:
                if (str.equals(BaiduIdentityManager.PARAM_CTV)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 115792:
                if (str.equals("uid")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3053931:
                if (str.equals("city")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3065101:
                if (str.equals("cuid")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3151786:
                if (str.equals("from")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3236474:
                if (str.equals(BaseStatisContent.IMSI)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 3526381:
                if (str.equals("seid")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 94580365:
                if (str.equals("cfrom")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 607796817:
                if (str.equals("sessionId")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 999451023:
                if (str.equals("zeusVersion")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1291458716:
                if (str.equals("net_type")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1683336973:
                if (str.equals("framework_sid")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 2015527638:
                if (str.equals("kernel_version")) {
                    c = 17;
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
        com.baidu.webkit.logsdk.b.c d = b.a().e().d(str);
        if ("full".equals(d.a)) {
            return a(context);
        }
        HashSet<String> hashSet = d.c;
        JSONObject jSONObject = new JSONObject();
        if (hashSet != null) {
            try {
                com.baidu.webkit.logsdk.b c = b.a().c();
                Iterator<String> it = hashSet.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String a = a(next, context, c);
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
                c.a(e);
            }
        }
        return jSONObject.toString();
    }
}
