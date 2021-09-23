package com.bytedance.sdk.openadsdk.core.k;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.pass.face.platform.utils.DeviceUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.f;
import com.bytedance.sdk.openadsdk.q.l;
import com.bytedance.sdk.openadsdk.q.m;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Locale;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f67045a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f67046b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f67047c = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final IntentFilter f67048a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(135774394, "Lcom/bytedance/sdk/openadsdk/core/k/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(135774394, "Lcom/bytedance/sdk/openadsdk/core/k/c$a;");
                    return;
                }
            }
            f67048a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        }

        public static int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                try {
                    Intent registerReceiver = context.registerReceiver(null, f67048a);
                    if (registerReceiver != null) {
                        int intExtra = registerReceiver.getIntExtra("status", -1);
                        return intExtra == -1 ? intExtra : intExtra == 2 ? 1 : 0;
                    }
                } catch (Throwable unused) {
                }
                return -1;
            }
            return invokeL.intValue;
        }

        public static float b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                try {
                    Intent registerReceiver = context.registerReceiver(null, f67048a);
                    if (registerReceiver != null) {
                        return (registerReceiver.getIntExtra("level", -1) * 100) / registerReceiver.getIntExtra("scale", -1);
                    }
                    return 0.0f;
                } catch (Throwable unused) {
                    return 0.0f;
                }
            }
            return invokeL.floatValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                    boolean unused = c.f67047c = true;
                    k.c(DeviceUtils.TAG, "screen_on");
                } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    boolean unused2 = c.f67047c = false;
                    k.c(DeviceUtils.TAG, "screen_off");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(268297431, "Lcom/bytedance/sdk/openadsdk/core/k/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(268297431, "Lcom/bytedance/sdk/openadsdk/core/k/c;");
        }
    }

    @Keep
    @SuppressLint({"NewApi"})
    @JProtect
    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            } catch (Throwable unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Keep
    @JProtect
    public static String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress()) {
                            boolean z2 = inetAddress instanceof Inet4Address;
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (z) {
                                if (z2) {
                                    return upperCase;
                                }
                            } else if (!z2) {
                                int indexOf = upperCase.indexOf(37);
                                return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                            }
                        }
                    }
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeZ.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || f67046b) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                f67047c = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(bVar, intentFilter);
        f67046b = true;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Build.VERSION.SDK_INT == 29 && l.r()) {
                try {
                    PowerManager powerManager = (PowerManager) o.a().getSystemService("power");
                    if (powerManager != null) {
                        f67047c = powerManager.isScreenOn();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return f67047c;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    @Keep
    @JProtect
    public static String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (TextUtils.isEmpty(f67045a)) {
                String a2 = h.a("sdk_local_mac_address", 172800000L);
                f67045a = a2;
                if (TextUtils.isEmpty(a2)) {
                    TTCustomController f2 = h.d().f();
                    if (f2 != null && f2.isCanUseWifiState() && f2.isCanUseLocation()) {
                        str = a(NetworkInfoUtils.NETWORK_NAME);
                        if (TextUtils.isEmpty(str)) {
                            str = a("eth0");
                        }
                    } else {
                        str = "DU:MM:YA:DD:RE:SS";
                    }
                    String str2 = TextUtils.isEmpty(str) ? "DU:MM:YA:DD:RE:SS" : str;
                    f67045a = str2;
                    h.a("sdk_local_mac_address", str2);
                }
                return f67045a;
            }
            return f67045a;
        }
        return (String) invokeV.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            try {
                return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                String languageTag = Locale.getDefault().toLanguageTag();
                return !TextUtils.isEmpty(languageTag) ? languageTag : "";
            }
            return Locale.getDefault().getLanguage();
        }
        return (String) invokeV.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return (context.getResources().getConfiguration().uiMode & 15) == 4;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int i2 = -1;
            try {
                Context a2 = o.a();
                if (a2 != null) {
                    i2 = Settings.System.getInt(a2.getContentResolver(), "screen_brightness", -1);
                }
            } catch (Throwable th) {
                k.f(DeviceUtils.TAG, th.getMessage());
            }
            if (i2 < 0) {
                return -1.0f;
            }
            return Math.round((i2 / 255.0f) * 10.0f) / 10.0f;
        }
        return invokeV.floatValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (c(context)) {
                return 3;
            }
            return b(context) ? 2 : 1;
        }
        return invokeL.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) o.a().getSystemService("accessibility");
            if (accessibilityManager == null) {
                return -1;
            }
            return accessibilityManager.isEnabled() ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Keep
    @JProtect
    public static JSONObject e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            while (true) {
                char c2 = 'F';
                char c3 = CharUtils.CR;
                while (true) {
                    switch (c2) {
                        case 'E':
                            while (true) {
                                switch (c3) {
                                    case '\n':
                                        break;
                                    case 11:
                                        while (true) {
                                        }
                                    case '\f':
                                        break;
                                    default:
                                        c3 = '\f';
                                }
                            }
                            c2 = 'G';
                            break;
                        case 'F':
                            switch (c3) {
                                case '\f':
                                case '\r':
                                    c2 = 'G';
                            }
                            break;
                        case 'G':
                            break;
                        default:
                            c2 = 'G';
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("imei", j.d(context));
                jSONObject.put(IAdRequestParam.ANDROID_ID, j.c(context));
                jSONObject.put("uuid", j.e(context));
                jSONObject.put("ssid", j.g(context));
                jSONObject.put("wifi_mac", j.h(context));
                jSONObject.put(BaseStatisContent.IMSI, j.f(context));
                jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
                jSONObject.put("rom_version", l.a());
                jSONObject.put("sys_compiling_time", j.b(context));
                jSONObject.put("type", d(context));
                jSONObject.put("os", 1);
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE + "");
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("language", Locale.getDefault().getLanguage());
                jSONObject.put("conn_type", n.b(context));
                jSONObject.put("mac", b());
                jSONObject.put("screen_width", s.c(context));
                jSONObject.put("screen_height", s.d(context));
                jSONObject.put("oaid", com.bytedance.sdk.openadsdk.q.k.a());
                jSONObject.put(PmsConstant.EnvParam.Key.FREE_SPACE, f.f69161a);
                jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
                jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.s.a().b());
                jSONObject.put("locale_language", c());
                jSONObject.put("screen_bright", Math.ceil(d() * 10.0f) / 10.0d);
                jSONObject.put("is_screen_off", a() ? 0 : 1);
                jSONObject.put("cpu_num", q.c(context));
                jSONObject.put("cpu_max_freq", q.d(context));
                jSONObject.put("cpu_min_freq", q.e(context));
                jSONObject.put("battery_remaining_pct", (int) a.b(context));
                jSONObject.put("is_charging", a.a(context));
                jSONObject.put("total_mem", String.valueOf(Long.parseLong(q.b(context)) * 1024));
                jSONObject.put("total_space", String.valueOf(q.f(context)));
                jSONObject.put("free_space_in", String.valueOf(q.g(context)));
                jSONObject.put("sdcard_size", String.valueOf(q.h(context)));
                jSONObject.put("rooted", q.i(context));
                jSONObject.put("enable_assisted_clicking", e());
                jSONObject.put("mnc", m.b());
                jSONObject.put("mcc", m.a());
                jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.c.a.b(context));
                jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
                jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.s.a().b());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void f() {
        Context a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || (a2 = o.a()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_count", q.g());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_max_frequency", q.c(q.g()));
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_min_frequency", q.d(q.g()));
        String e2 = q.e(a2, "MemTotal");
        if (e2 != null) {
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_memory", e2);
        }
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_internal_storage", q.h());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("free_internal_storage", com.bytedance.sdk.component.utils.l.a());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_sdcard_storage", q.i());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("is_root", q.j() ? 1 : 0);
    }
}
