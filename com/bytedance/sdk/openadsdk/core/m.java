package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.utils.ae;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f28188a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile TTCustomController f28189b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f28190c = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f28191d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f28192e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f28193f;

    public static void a() {
        Context a2;
        if (p.h().d() && (a2 = p.a()) != null) {
            try {
                d.b.c.b.a.f(new com.bytedance.sdk.openadsdk.i.d(a2));
                d.b.c.b.a.g(true);
                d.b.c.b.a.d(a2, (Application) a2, com.bytedance.sdk.openadsdk.multipro.b.b());
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context) {
        d.a(context).a("uuid", UUID.randomUUID().toString());
    }

    public static void c() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused) {
        }
    }

    public static Handler b() {
        HandlerThread handlerThread;
        if (f28193f == null || ((handlerThread = f28192e) != null && !handlerThread.isAlive())) {
            HandlerThread handlerThread2 = new HandlerThread("tt_pangle_thread_init", 10);
            f28192e = handlerThread2;
            handlerThread2.start();
            f28193f = new Handler(f28192e.getLooper());
        }
        return f28193f;
    }

    public static void a(Context context) {
        c();
        c(context);
        ah.a();
        al.a(context);
        b(context);
        p.i().a();
        String a2 = k.a(context);
        if (!TextUtils.isEmpty(a2)) {
            p.g().a(a2);
        }
        s.a().a(a2);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a();
        com.bytedance.sdk.openadsdk.core.g.a.a().b();
        a();
    }

    public static void c(final Context context) {
        d.b.d.b.l.a(context.getApplicationContext(), new d.b.d.b.g() { // from class: com.bytedance.sdk.openadsdk.core.m.1
            @Override // d.b.d.b.g
            public Map<String, Object> a() {
                HashMap hashMap = new HashMap();
                String a2 = k.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put(Constants.KEY_DEVICE_ID, a2);
                }
                hashMap.put("ac", com.bytedance.sdk.openadsdk.utils.x.f(context));
                hashMap.put("aid", 164362);
                hashMap.put("app_name", "unionser_slardar_applog");
                String g2 = ak.g();
                if (!TextUtils.isEmpty(g2)) {
                    hashMap.put("app_version", g2);
                }
                String f2 = ak.f();
                if (!TextUtils.isEmpty(f2)) {
                    hashMap.put("version_code", f2);
                    hashMap.put("update_version_code", f2);
                }
                hashMap.put("version_name", "3.4.5.5");
                hashMap.put("device_platform", "android");
                hashMap.put(IAdRequestParam.OS, "Android");
                hashMap.put("device_type", Build.MODEL);
                hashMap.put("device_mode", Build.MODEL);
                hashMap.put(Config.ROM, ae.a());
                hashMap.put(PmsConstant.EnvParam.Key.CPU_ABI, Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put("language", Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception unused) {
                }
                hashMap.put("openudid", k.c(context));
                hashMap.put("dpi", String.valueOf(al.f(context)));
                hashMap.put("resolution", al.c(context) + "*" + al.d(context));
                return hashMap;
            }

            @Override // d.b.d.b.g
            public String b() {
                return k.a(context);
            }

            @Override // d.b.d.b.g
            public String c() {
                return AppLogHelper.getInstance().getAppLogUserUniqueID();
            }

            @Override // d.b.d.b.g
            public String d() {
                return null;
            }

            @Override // d.b.d.b.g
            public Map<String, Integer> e() {
                return null;
            }

            @Override // d.b.d.b.g
            public List<String> f() {
                return null;
            }

            @Override // d.b.d.b.g
            public Map<String, Object> g() {
                HashMap hashMap = new HashMap();
                String g2 = i.d().g();
                if (TextUtils.isEmpty(g2)) {
                    g2 = String.valueOf(164362);
                }
                hashMap.put("host_appid", g2);
                hashMap.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.4.5.5");
                return hashMap;
            }
        }, true, false);
        d.b.d.b.l.d(new d.b.d.b.k() { // from class: com.bytedance.sdk.openadsdk.core.m.2
            /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x0014, B:7:0x0025, B:13:0x0033), top: B:17:0x0001 }] */
            @Override // d.b.d.b.k
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean a(Throwable th, Thread thread) {
                boolean z;
                try {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    if (stringWriter2 != null) {
                        if (!stringWriter2.contains(AdSlot.class.getPackage().getName()) && !stringWriter2.contains("com.bytedance.msdk")) {
                            z = false;
                            if (z) {
                                d.b.d.b.l.e(e.a().b());
                                return true;
                            }
                        }
                        z = true;
                        if (z) {
                        }
                    }
                } catch (Throwable unused) {
                }
                return false;
            }
        });
    }
}
