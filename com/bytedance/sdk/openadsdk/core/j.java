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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.List;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f66476a;

    /* renamed from: b  reason: collision with root package name */
    public static String f66477b;

    /* renamed from: c  reason: collision with root package name */
    public static String f66478c;

    /* renamed from: d  reason: collision with root package name */
    public static String f66479d;

    /* renamed from: e  reason: collision with root package name */
    public static String f66480e;

    /* renamed from: f  reason: collision with root package name */
    public static String f66481f;

    /* renamed from: g  reason: collision with root package name */
    public static String f66482g;

    /* renamed from: h  reason: collision with root package name */
    public static String f66483h;

    /* renamed from: i  reason: collision with root package name */
    public static String f66484i;

    /* renamed from: j  reason: collision with root package name */
    public static String f66485j;
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
            f66482g = a2;
            if (TextUtils.isEmpty(a2)) {
                StringBuilder sb = new StringBuilder();
                try {
                    if (com.bytedance.sdk.openadsdk.q.l.e()) {
                        str = "MIUI-";
                    } else if (com.bytedance.sdk.openadsdk.q.l.b()) {
                        str = "FLYME-";
                    } else {
                        String n = com.bytedance.sdk.openadsdk.q.l.n();
                        if (com.bytedance.sdk.openadsdk.q.l.a(n)) {
                            sb.append("EMUI-");
                        }
                        if (!TextUtils.isEmpty(n)) {
                            sb.append(n);
                            str = "-";
                        }
                        sb.append(Build.VERSION.INCREMENTAL);
                        String sb2 = sb.toString();
                        f66482g = sb2;
                        h.a("sdk_local_rom", sb2);
                    }
                    sb.append(str);
                    sb.append(Build.VERSION.INCREMENTAL);
                    String sb22 = sb.toString();
                    f66482g = sb22;
                    h.a("sdk_local_rom", sb22);
                } catch (Exception unused) {
                }
            }
            return f66482g;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f66476a) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            try {
                if (TextUtils.isEmpty(f66476a) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    String b2 = c.a(k(context)).b("did", (String) null);
                    f66476a = b2;
                    com.bytedance.sdk.openadsdk.o.a.a(3, b2);
                }
            } catch (Exception unused) {
            }
            return f66476a;
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
            String str = "02:00:00:00:00:00";
            if (wifiManager == null) {
                return "02:00:00:00:00:00";
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
            if (!TextUtils.isEmpty(str) && !str.equals(f66476a)) {
                c.a(context).a("did", str);
                f66476a = str;
                com.bytedance.sdk.openadsdk.o.a.a(3, str);
            }
            if (TextUtils.isEmpty(f66476a)) {
                return;
            }
            s.a().a(f66476a);
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (f66483h == null && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f66483h;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (TextUtils.isEmpty(f66477b) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f66477b;
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 != null && !f2.isCanUsePhoneState()) {
                com.bytedance.sdk.openadsdk.o.a.a(6, f2.getDevImei());
                return f2.getDevImei();
            }
            if (TextUtils.isEmpty(f66478c) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f66478c;
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (TextUtils.isEmpty(f66484i) && !k) {
                synchronized (j.class) {
                    if (!k) {
                        l(context);
                    }
                }
            }
            return f66484i;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            TTCustomController f2 = h.d().f();
            if (f2 == null || f2.isCanUsePhoneState()) {
                if (TextUtils.isEmpty(f66481f) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f66481f;
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
                if (TextUtils.isEmpty(f66479d) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f66479d;
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
                if (TextUtils.isEmpty(f66480e) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f66480e;
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
                if (TextUtils.isEmpty(f66485j) && !k) {
                    synchronized (j.class) {
                        if (!k) {
                            l(context);
                        }
                    }
                }
                return f66485j;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void j(Context context) {
        Context k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, context) == null) && TextUtils.isEmpty(f66478c) && (k2 = k(context)) != null) {
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
                        f66479d = connectionInfo.getSSID();
                    }
                    f66480e = a(wifiManager);
                } catch (Throwable unused2) {
                }
            }
            f66485j = Build.VERSION.SDK_INT >= 28 ? Build.getSerial() : Build.SERIAL;
        } catch (Exception unused3) {
        }
        f66477b = a(k2, true);
        String b2 = c.a(k2).b("did", (String) null);
        f66476a = b2;
        com.bytedance.sdk.openadsdk.o.a.a(3, b2);
        f66482g = a();
        f66483h = String.valueOf(Build.TIME);
        f66484i = c.a(k2).b("uuid", (String) null);
        k = true;
    }

    @SuppressLint({"HardwareIds"})
    public static void m(Context context) {
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            com.bytedance.sdk.openadsdk.o.a.a(6, "");
            TTCustomController f2 = h.d().f();
            if ((f2 == null || f2.isCanUsePhoneState()) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                String deviceId = telephonyManager.getDeviceId();
                f66478c = deviceId;
                com.bytedance.sdk.openadsdk.o.a.a(6, deviceId);
                f66481f = telephonyManager.getSubscriberId();
            }
        }
    }
}
