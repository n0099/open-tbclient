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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.logsdk.d.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static String n;
    public transient /* synthetic */ FieldHolder $fh;
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d(context);
        d();
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (TextUtils.isEmpty(this.j)) {
                this.j = null;
            }
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    private String a(Context context, com.baidu.webkit.logsdk.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, bVar)) == null) {
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
        return (String) invokeLL.objValue;
    }

    private String a(com.baidu.webkit.logsdk.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bVar)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                this.a = bVar.e();
            }
            if (TextUtils.isEmpty(this.a)) {
                throw new RuntimeException("BdLogBase: get cuid null!");
            }
            return this.a;
        }
        return (String) invokeL.objValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (TextUtils.isEmpty(this.k)) {
                this.k = null;
            }
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        NetworkInfo activeNetworkInfo;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    private String b(com.baidu.webkit.logsdk.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, bVar)) == null) {
            if (TextUtils.isEmpty(this.h)) {
                this.h = bVar.c();
            }
            if (TextUtils.isEmpty(this.h)) {
                throw new RuntimeException("BdLogBase: get from null!");
            }
            return this.h;
        }
        return (String) invokeL.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (TextUtils.isEmpty(this.l)) {
                this.l = null;
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    private String c(com.baidu.webkit.logsdk.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, bVar)) == null) {
            if (TextUtils.isEmpty(this.i)) {
                this.i = bVar.d();
            }
            if (TextUtils.isEmpty(this.i)) {
                throw new RuntimeException("BdLogBase: get Cfrom null!");
            }
            return this.i;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            b.a().g();
            String b = b(context);
            return b.equals("2g") || b.equals("3g") || b.equals("4g") || b.equals("5g");
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (a.class) {
                if (n == null) {
                    n = "";
                    b.a().c();
                }
                str = n;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.b = displayMetrics.widthPixels;
                this.c = displayMetrics.heightPixels;
                this.d = displayMetrics.densityDpi;
            } catch (Exception e) {
                c.a(e);
            }
        }
    }

    private int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, context)) == null) {
            if (this.b == 0) {
                d(context);
            }
            return this.b;
        }
        return invokeL.intValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    private int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, context)) == null) {
            if (this.c == 0) {
                d(context);
            }
            return this.c;
        }
        return invokeL.intValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return "00100000";
        }
        return (String) invokeV.objValue;
    }

    private int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) {
            if (this.d == 0) {
                d(context);
            }
            return this.d;
        }
        return invokeL.intValue;
    }

    private String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    private int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, context)) == null) {
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
        return invokeL.intValue;
    }

    private String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, context)) == null) {
            if (TextUtils.isEmpty(this.m)) {
                this.m = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            }
            return this.m;
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            if (TextUtils.isEmpty(null)) {
                return b(context);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final int a(String str, Context context) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, context)) == null) {
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
        return invokeLL.intValue;
    }

    public final String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(50:6|(1:8)(1:115)|9|(2:10|11)|(3:13|14|(1:16))|18|19|21|22|(1:24)|26|27|(1:29)|31|32|(1:34)|36|37|(1:39)|41|42|(1:44)|46|47|48|(1:50)|52|53|54|(1:56)|57|58|59|(1:61)|63|64|(1:66)|68|69|(1:71)|73|(1:75)|76|(1:78)|79|(1:81)|82|(1:84)|85|86) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
        r5 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        r5 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
        com.baidu.webkit.logsdk.d.c.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007c, code lost:
        com.baidu.webkit.logsdk.d.c.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b1, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b2, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cc, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00cd, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e8, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e9, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f9, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fa, code lost:
        com.baidu.webkit.logsdk.d.c.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x011f, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0120, code lost:
        com.baidu.webkit.logsdk.d.c.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0136, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0137, code lost:
        com.baidu.webkit.logsdk.d.c.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x014d, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014e, code lost:
        com.baidu.webkit.logsdk.d.c.a(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #7 {Exception -> 0x005d, blocks: (B:24:0x004e, B:26:0x0054), top: B:123:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072 A[Catch: Exception -> 0x007b, TRY_LEAVE, TryCatch #8 {Exception -> 0x007b, blocks: (B:33:0x0064, B:35:0x0072), top: B:125:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #3 {Exception -> 0x0096, blocks: (B:39:0x007f, B:41:0x008d), top: B:115:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8 A[Catch: Exception -> 0x00b1, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b1, blocks: (B:45:0x009a, B:47:0x00a8), top: B:117:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3 A[Catch: Exception -> 0x00cc, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cc, blocks: (B:51:0x00b5, B:53:0x00c3), top: B:111:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00df A[Catch: Exception -> 0x00e8, TRY_LEAVE, TryCatch #10 {Exception -> 0x00e8, blocks: (B:58:0x00d5, B:60:0x00df), top: B:129:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0116 A[Catch: Exception -> 0x011f, TRY_LEAVE, TryCatch #5 {Exception -> 0x011f, blocks: (B:72:0x0110, B:74:0x0116), top: B:119:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0129 A[Catch: Exception -> 0x0136, TRY_LEAVE, TryCatch #2 {Exception -> 0x0136, blocks: (B:78:0x0123, B:80:0x0129), top: B:113:0x0123 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0144 A[Catch: Exception -> 0x014d, TRY_LEAVE, TryCatch #0 {Exception -> 0x014d, blocks: (B:84:0x013a, B:86:0x0144), top: B:109:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        String b;
        String packageName;
        String c;
        String encode;
        String encode2;
        String encode3;
        String encode4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
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
            } catch (Exception e) {
                e = e;
                str2 = "";
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append("ua=");
                    sb.append(str2);
                }
            } catch (Exception e2) {
                e = e2;
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
            str3 = a(c2);
            if (!TextUtils.isEmpty(str3)) {
                sb.append("&cuid=");
                sb.append(str3);
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
            encode = URLEncoder.encode(b(), "UTF-8");
            if (!TextUtils.isEmpty(encode)) {
                sb.append("&it=");
                sb.append(encode);
            }
            sb.append("ctv=2");
            c = c();
            if (!TextUtils.isEmpty(c)) {
                sb.append("&seid=");
                sb.append(c);
            }
            String f2 = f();
            sb.append("&st=");
            sb.append(f2);
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
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String a(String str, Context context, com.baidu.webkit.logsdk.b bVar) {
        InterceptResult invokeLLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, context, bVar)) == null) {
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
                    if (str.equals("ctv")) {
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
        return (String) invokeLLL.objValue;
    }

    public final String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
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
        return (String) invokeLL.objValue;
    }
}
