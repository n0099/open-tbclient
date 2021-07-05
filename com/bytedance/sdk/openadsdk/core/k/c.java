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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.r.e;
import com.bytedance.sdk.openadsdk.r.i;
import com.bytedance.sdk.openadsdk.r.k;
import com.bytedance.sdk.openadsdk.r.q;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import com.kwai.video.player.KsMediaMeta;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f30227a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f30228b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f30229c = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final IntentFilter f30230a;
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
            f30230a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        }

        public static int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                try {
                    Intent registerReceiver = context.registerReceiver(null, f30230a);
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
                    Intent registerReceiver = context.registerReceiver(null, f30230a);
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

    /* loaded from: classes6.dex */
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
                    boolean unused = c.f30229c = true;
                    j.c(DeviceUtils.TAG, "screen_on");
                } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    boolean unused2 = c.f30229c = false;
                    j.c(DeviceUtils.TAG, "screen_off");
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
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || f30228b) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                f30229c = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(bVar, intentFilter);
        f30228b = true;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            if (Build.VERSION.SDK_INT == 29 && com.bytedance.sdk.openadsdk.r.j.r()) {
                try {
                    PowerManager powerManager = (PowerManager) o.a().getSystemService("power");
                    if (powerManager != null) {
                        f30229c = powerManager.isScreenOn();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return f30229c;
        }
        return invokeV.booleanValue;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
        if (r0 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        r0 = com.bytedance.sdk.openadsdk.core.h.d().f();
        r1 = "DU:MM:YA:DD:RE:SS";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r0.isCanUseWifiState() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
        if (r0.isCanUseLocation() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
        r0 = a(com.baidu.mobads.container.util.network.NetworkInfoUtils.NETWORK_NAME);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        r0 = a("eth0");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        r0 = "DU:MM:YA:DD:RE:SS";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
        com.bytedance.sdk.openadsdk.core.k.c.f30227a = r1;
        com.bytedance.sdk.openadsdk.core.h.a("sdk_local_mac_address", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
        return com.bytedance.sdk.openadsdk.core.k.c.f30227a;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0076 A[SYNTHETIC] */
    @androidx.annotation.NonNull
    @androidx.annotation.Keep
    @com.bytedance.JProtect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String b() {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.bytedance.sdk.openadsdk.core.k.c.$ic
            if (r0 != 0) goto L7b
        L4:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.k.c.f30227a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
        La:
            r1 = 68
            r2 = 39
            r3 = 39
        L10:
            java.lang.String r4 = "sdk_local_mac_address"
            switch(r1) {
                case 68: goto L24;
                case 69: goto L1d;
                case 70: goto L16;
                default: goto L15;
            }
        L15:
            goto L76
        L16:
            switch(r3) {
                case 29: goto L1a;
                case 30: goto L1a;
                case 31: goto L39;
                default: goto L19;
            }
        L19:
            goto L27
        L1a:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.k.c.f30227a
            return r0
        L1d:
            r1 = 22
            if (r3 <= r1) goto L22
            goto La
        L22:
            r0 = 0
            goto L37
        L24:
            if (r3 == r2) goto L27
            goto L24
        L27:
            if (r0 != 0) goto L2a
            goto L76
        L2a:
            r0 = 172800000(0xa4cb800, double:8.53745436E-316)
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.h.a(r4, r0)
            com.bytedance.sdk.openadsdk.core.k.c.f30227a = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
        L37:
            if (r0 == 0) goto L73
        L39:
            com.bytedance.sdk.openadsdk.core.h r0 = com.bytedance.sdk.openadsdk.core.h.d()
            com.bytedance.sdk.openadsdk.TTCustomController r0 = r0.f()
            java.lang.String r1 = "DU:MM:YA:DD:RE:SS"
            if (r0 == 0) goto L65
            boolean r2 = r0.isCanUseWifiState()
            if (r2 == 0) goto L65
            boolean r0 = r0.isCanUseLocation()
            if (r0 == 0) goto L65
            java.lang.String r0 = "wlan0"
            java.lang.String r0 = a(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L66
            java.lang.String r0 = "eth0"
            java.lang.String r0 = a(r0)
            goto L66
        L65:
            r0 = r1
        L66:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L6d
            goto L6e
        L6d:
            r1 = r0
        L6e:
            com.bytedance.sdk.openadsdk.core.k.c.f30227a = r1
            com.bytedance.sdk.openadsdk.core.h.a(r4, r1)
        L73:
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.k.c.f30227a
            return r0
        L76:
            r1 = 70
            r3 = 30
            goto L10
        L7b:
            r2 = r0
            r3 = 65541(0x10005, float:9.1843E-41)
            r4 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeV(r3, r4)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.k.c.b():java.lang.String");
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
                j.f(DeviceUtils.TAG, th.getMessage());
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
                char c3 = '\r';
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
                jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.j.d(context));
                jSONObject.put(IAdRequestParam.ANDROID_ID, com.bytedance.sdk.openadsdk.core.j.c(context));
                jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.j.e(context));
                jSONObject.put("ssid", com.bytedance.sdk.openadsdk.core.j.g(context));
                jSONObject.put("wifi_mac", com.bytedance.sdk.openadsdk.core.j.h(context));
                jSONObject.put(BaseStatisContent.IMSI, com.bytedance.sdk.openadsdk.core.j.f(context));
                jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
                jSONObject.put("rom_version", com.bytedance.sdk.openadsdk.r.j.a());
                jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.j.b(context));
                jSONObject.put("type", d(context));
                jSONObject.put(IAdRequestParam.OS, 1);
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE + "");
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
                jSONObject.put("conn_type", m.b(context));
                jSONObject.put("mac", b());
                jSONObject.put("screen_width", q.c(context));
                jSONObject.put("screen_height", q.d(context));
                jSONObject.put("oaid", i.a());
                jSONObject.put(PmsConstant.EnvParam.Key.FREE_SPACE, e.f32212a);
                jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
                jSONObject.put("sec_did", s.a().b());
                jSONObject.put("locale_language", c());
                jSONObject.put("screen_bright", Math.ceil(d() * 10.0f) / 10.0d);
                jSONObject.put("is_screen_off", a() ? 0 : 1);
                jSONObject.put("cpu_num", com.bytedance.sdk.openadsdk.r.o.c(context));
                jSONObject.put("cpu_max_freq", com.bytedance.sdk.openadsdk.r.o.d(context));
                jSONObject.put("cpu_min_freq", com.bytedance.sdk.openadsdk.r.o.e(context));
                jSONObject.put("battery_remaining_pct", (int) a.b(context));
                jSONObject.put("is_charging", a.a(context));
                jSONObject.put("total_mem", String.valueOf(Long.parseLong(com.bytedance.sdk.openadsdk.r.o.b(context)) * 1024));
                jSONObject.put("total_space", String.valueOf(com.bytedance.sdk.openadsdk.r.o.f(context)));
                jSONObject.put("free_space_in", String.valueOf(com.bytedance.sdk.openadsdk.r.o.g(context)));
                jSONObject.put("sdcard_size", String.valueOf(com.bytedance.sdk.openadsdk.r.o.h(context)));
                jSONObject.put("rooted", com.bytedance.sdk.openadsdk.r.o.i(context));
                jSONObject.put("enable_assisted_clicking", e());
                jSONObject.put("mnc", k.b());
                jSONObject.put("mcc", k.a());
                jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.c.a.b(context));
                jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
                jSONObject.put("sec_did", s.a().b());
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
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_count", com.bytedance.sdk.openadsdk.r.o.g());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_max_frequency", com.bytedance.sdk.openadsdk.r.o.c(com.bytedance.sdk.openadsdk.r.o.g()));
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("cpu_min_frequency", com.bytedance.sdk.openadsdk.r.o.d(com.bytedance.sdk.openadsdk.r.o.g()));
        String e2 = com.bytedance.sdk.openadsdk.r.o.e(a2, "MemTotal");
        if (e2 != null) {
            com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_memory", e2);
        }
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_internal_storage", com.bytedance.sdk.openadsdk.r.o.h());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("free_internal_storage", com.bytedance.sdk.component.utils.k.a());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("total_sdcard_storage", com.bytedance.sdk.openadsdk.r.o.i());
        com.bytedance.sdk.openadsdk.core.c.a(a2).a("is_root", com.bytedance.sdk.openadsdk.r.o.j() ? 1 : 0);
    }
}
