package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ag;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.kwai.video.player.KsMediaMeta;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: b  reason: collision with root package name */
    public static volatile TTCustomController f6908b;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f6907a = false;
    private static AtomicBoolean c = new AtomicBoolean(false);

    public static void a(Context context) {
        if (!c.get()) {
            synchronized (TTAdManagerFactory.class) {
                if (!c.get()) {
                    c(context);
                    c.set(true);
                }
            }
        }
    }

    private static void c(final Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("InitHelper", "init start: " + f6907a);
        com.bytedance.sdk.openadsdk.k.a.a(com.bytedance.sdk.openadsdk.multipro.b.b());
        p.a(context.getApplicationContext());
        if (com.bytedance.sdk.openadsdk.core.h.j.a()) {
            com.bytedance.sdk.openadsdk.multipro.d.a(context);
            e(context);
            if (f6907a) {
                com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.m.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m.d(context);
                    }
                }, 10);
            } else {
                d(context);
            }
            Log.d("InitHelper", "init over: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private static void a() {
        Context a2;
        if (p.h().e() && (a2 = p.a()) != null) {
            try {
                com.bytedance.sdk.adnet.a.a(new com.bytedance.sdk.openadsdk.i.c(a2));
                com.bytedance.sdk.adnet.a.a(true);
                com.bytedance.sdk.adnet.a.a(a2, (Application) a2, com.bytedance.sdk.openadsdk.multipro.b.b());
            } catch (Exception e) {
            }
        }
    }

    private static void b() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
                declaredField.setAccessible(true);
                declaredField.setBoolean(invoke, true);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b();
        g(context);
        ag.a();
        p.h().a();
        ak.a(context);
        f(context);
        p.c().a();
        p.e().a();
        p.d().a();
        p.j().a();
        String a2 = k.a(context);
        if (!TextUtils.isEmpty(a2)) {
            p.g().a(a2);
        }
        s.b(a2);
        com.bytedance.sdk.openadsdk.downloadnew.a.e.a(context);
        c();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a();
        com.bytedance.sdk.openadsdk.core.g.a.a().b();
        a();
        Log.d("InitHelper", "do async task: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static void e(Context context) {
        com.bytedance.embedapplog.l lVar = new com.bytedance.embedapplog.l(String.valueOf(164362), "unionser_slardar_applog");
        if (f6908b != null) {
            lVar.AK(f6908b.isCanUsePhoneState());
            if (!f6908b.isCanUsePhoneState()) {
                lVar.YB(f6908b.getDevImei());
            }
            lVar.AJ(f6908b.isCanUseWifiState());
        }
        lVar.a(new com.bytedance.embedapplog.k() { // from class: com.bytedance.sdk.openadsdk.core.m.2
            public String getImsi() {
                return (m.f6908b == null || m.f6908b.isCanUsePhoneState()) ? k.f(p.a()) : "";
            }

            @Override // com.bytedance.embedapplog.k
            public String getMac() {
                if (m.f6908b == null || m.f6908b.isCanUseWifiState()) {
                    return k.h(p.a());
                }
                return null;
            }
        });
        lVar.PC(0);
        com.bytedance.embedapplog.b.a(context, lVar);
        com.bytedance.embedapplog.b.a(new com.bytedance.embedapplog.g() { // from class: com.bytedance.sdk.openadsdk.core.m.3
            @Override // com.bytedance.embedapplog.g
            public void onIdLoaded(String str, String str2, String str3) {
            }

            @Override // com.bytedance.embedapplog.g
            public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
            }

            @Override // com.bytedance.embedapplog.g
            public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
            }

            @Override // com.bytedance.embedapplog.g
            public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
            }
        });
        com.bytedance.sdk.openadsdk.utils.y.a(context);
    }

    private static void c() {
        com.bytedance.sdk.openadsdk.core.h.b.a().b();
    }

    private static void f(Context context) {
        d.a(context).a("uuid", UUID.randomUUID().toString());
    }

    private static void g(final Context context) {
        com.bytedance.tea.crash.g.a(context.getApplicationContext(), new com.bytedance.tea.crash.d() { // from class: com.bytedance.sdk.openadsdk.core.m.4
            @Override // com.bytedance.tea.crash.d
            public Map<String, Object> a() {
                HashMap hashMap = new HashMap();
                String a2 = k.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    hashMap.put("device_id", a2);
                }
                hashMap.put("ac", com.bytedance.sdk.openadsdk.utils.x.f(context));
                hashMap.put("aid", 164362);
                hashMap.put("app_name", "unionser_slardar_applog");
                String f = aj.f();
                if (!TextUtils.isEmpty(f)) {
                    hashMap.put("app_version", f);
                }
                String e = aj.e();
                if (!TextUtils.isEmpty(e)) {
                    hashMap.put("version_code", e);
                    hashMap.put("update_version_code", e);
                }
                hashMap.put(SharedPrefConfig.VERSION_NAME, "3.2.5.1");
                hashMap.put("device_platform", HttpConstants.OS_TYPE_VALUE);
                hashMap.put("os", "Android");
                hashMap.put(HttpConstants.DEVICE_TYPE, Build.MODEL);
                hashMap.put("device_mode", Build.MODEL);
                hashMap.put(Config.ROM, ad.a());
                hashMap.put("cpu_abi", Build.CPU_ABI);
                hashMap.put("device_brand", Build.BRAND);
                hashMap.put(KsMediaMeta.KSM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
                hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String str = Build.VERSION.RELEASE;
                    if (str != null && str.length() > 10) {
                        str = str.substring(0, 10);
                    }
                    hashMap.put("os_version", str);
                } catch (Exception e2) {
                }
                hashMap.put("openudid", k.c(context));
                hashMap.put("dpi", String.valueOf(ak.f(context)));
                hashMap.put("resolution", ak.c(context) + "*" + ak.d(context));
                return hashMap;
            }

            @Override // com.bytedance.tea.crash.d
            public String b() {
                return k.a(context);
            }

            @Override // com.bytedance.tea.crash.d
            public String c() {
                return com.bytedance.embedapplog.b.eoV();
            }

            @Override // com.bytedance.tea.crash.d
            public String d() {
                return com.bytedance.embedapplog.b.getSsid();
            }

            @Override // com.bytedance.tea.crash.d
            public Map<String, Integer> e() {
                return null;
            }

            @Override // com.bytedance.tea.crash.d
            public List<String> f() {
                return null;
            }

            @Override // com.bytedance.tea.crash.d
            public Map<String, Object> g() {
                HashMap hashMap = new HashMap();
                String e = i.c().e();
                if (TextUtils.isEmpty(e)) {
                    e = String.valueOf(164362);
                }
                hashMap.put("host_appid", e);
                hashMap.put(SapiContext.KEY_SDK_VERSION, "3.2.5.1");
                return hashMap;
            }
        }, true, false);
        com.bytedance.tea.crash.g.a(new com.bytedance.tea.crash.f() { // from class: com.bytedance.sdk.openadsdk.core.m.5
            @Override // com.bytedance.tea.crash.f
            public boolean a(Throwable th, Thread thread) {
                try {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    if (stringWriter2 != null && stringWriter2.contains(AdSlot.class.getPackage().getName())) {
                        com.bytedance.tea.crash.g.a(e.a().b());
                        return true;
                    }
                } catch (Throwable th2) {
                }
                return false;
            }
        });
    }
}
