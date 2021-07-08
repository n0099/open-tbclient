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
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.List;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f30262a;

    /* renamed from: b  reason: collision with root package name */
    public static String f30263b;

    /* renamed from: c  reason: collision with root package name */
    public static String f30264c;

    /* renamed from: d  reason: collision with root package name */
    public static String f30265d;

    /* renamed from: e  reason: collision with root package name */
    public static String f30266e;

    /* renamed from: f  reason: collision with root package name */
    public static String f30267f;

    /* renamed from: g  reason: collision with root package name */
    public static String f30268g;

    /* renamed from: h  reason: collision with root package name */
    public static String f30269h;

    /* renamed from: i  reason: collision with root package name */
    public static String f30270i;
    public static String j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String a2 = h.a("sdk_local_rom", 604800000L);
            f30268g = a2;
            if (TextUtils.isEmpty(a2)) {
                StringBuilder sb = new StringBuilder();
                try {
                    if (com.bytedance.sdk.openadsdk.r.j.e()) {
                        str = "MIUI-";
                    } else if (com.bytedance.sdk.openadsdk.r.j.b()) {
                        str = "FLYME-";
                    } else {
                        String n = com.bytedance.sdk.openadsdk.r.j.n();
                        if (com.bytedance.sdk.openadsdk.r.j.a(n)) {
                            sb.append("EMUI-");
                        }
                        if (!TextUtils.isEmpty(n)) {
                            sb.append(n);
                            str = "-";
                        }
                        sb.append(Build.VERSION.INCREMENTAL);
                        String sb2 = sb.toString();
                        f30268g = sb2;
                        h.a("sdk_local_rom", sb2);
                    }
                    sb.append(str);
                    sb.append(Build.VERSION.INCREMENTAL);
                    String sb22 = sb.toString();
                    f30268g = sb22;
                    h.a("sdk_local_rom", sb22);
                } catch (Exception unused) {
                }
            }
            return f30268g;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f30262a) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            try {
                if (TextUtils.isEmpty(f30262a) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    String b2 = c.a(k(context)).b("did", (String) null);
                    f30262a = b2;
                    com.bytedance.sdk.openadsdk.p.a.a(3, b2);
                }
            } catch (Exception unused) {
            }
            return f30262a;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r0.length() < 13) goto L21;
     */
    @SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            synchronized (j.class) {
                Context k2 = k(context);
                String str = null;
                if (k2 == null) {
                    return null;
                }
                try {
                    str = Settings.Secure.getString(k2.getContentResolver(), IAdRequestParam.ANDROID_ID);
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(str)) {
                }
                str = "";
                return str;
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static String a(WifiManager wifiManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, wifiManager)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) {
            if (!TextUtils.isEmpty(str) && !str.equals(f30262a)) {
                c.a(context).a("did", str);
                f30262a = str;
                com.bytedance.sdk.openadsdk.p.a.a(3, str);
            }
            if (TextUtils.isEmpty(f30262a)) {
                return;
            }
            s.a().a(f30262a);
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f30269h == null && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f30269h;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (TextUtils.isEmpty(f30263b) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f30263b;
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 == null || f2.isCanUsePhoneState()) {
                if (TextUtils.isEmpty(f30264c) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f30264c;
            }
            return f2.getDevImei();
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (TextUtils.isEmpty(f30270i) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f30270i;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 == null || f2.isCanUsePhoneState()) {
                if (TextUtils.isEmpty(f30267f) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f30267f;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 == null || f2.isCanUseWifiState()) {
                if (TextUtils.isEmpty(f30265d) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f30265d;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 == null || f2.isCanUseWifiState()) {
                if (TextUtils.isEmpty(f30266e) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f30266e;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        TTCustomController f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (Build.VERSION.SDK_INT < 28 || (f2 = h.d().f()) == null || f2.isCanUsePhoneState()) {
                if (TextUtils.isEmpty(j) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return j;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void j(Context context) {
        Context k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, context) == null) && TextUtils.isEmpty(f30264c) && (k2 = k(context)) != null) {
            try {
                m(k2);
            } catch (Exception unused) {
            }
        }
    }

    public static Context k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? context == null ? o.a() : context : (Context) invokeL.objValue;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    @SuppressLint({"HardwareIds"})
    public static void l(Context context) {
        Context k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, context) == null) || k || (k2 = k(context)) == null) {
            return;
        }
        try {
            m(k2);
        } catch (Exception unused) {
        }
        try {
            TTCustomController f2 = h.d().f();
            if (f2 != null && f2.isCanUseWifiState() && f2.isCanUseLocation()) {
                try {
                    WifiManager wifiManager = (WifiManager) k2.getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                    if (connectionInfo != null) {
                        f30265d = connectionInfo.getSSID();
                    }
                    f30266e = a(wifiManager);
                } catch (Throwable unused2) {
                }
            }
            j = Build.VERSION.SDK_INT >= 28 ? Build.getSerial() : Build.SERIAL;
        } catch (Exception unused3) {
        }
        f30263b = a(k2, true);
        String b2 = c.a(k2).b("did", (String) null);
        f30262a = b2;
        com.bytedance.sdk.openadsdk.p.a.a(3, b2);
        f30268g = a();
        f30269h = String.valueOf(Build.TIME);
        f30270i = c.a(k2).b("uuid", (String) null);
        k = true;
    }

    @SuppressLint({"HardwareIds"})
    public static void m(Context context) {
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            com.bytedance.sdk.openadsdk.p.a.a(6, "");
            TTCustomController f2 = h.d().f();
            if ((f2 == null || f2.isCanUsePhoneState()) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                f30264c = telephonyManager.getDeviceId();
                String subscriberId = telephonyManager.getSubscriberId();
                f30267f = subscriberId;
                com.bytedance.sdk.openadsdk.p.a.a(6, subscriberId);
            }
        }
    }
}
