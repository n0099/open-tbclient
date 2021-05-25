package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f28036a = "AppEnvironment";

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f28037b = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f28038d = "ad_style";

    /* renamed from: e  reason: collision with root package name */
    public static String f28039e = "ad_id";

    /* renamed from: f  reason: collision with root package name */
    public static String f28040f = "rit";

    /* renamed from: g  reason: collision with root package name */
    public static String f28041g = "request_id";

    /* renamed from: h  reason: collision with root package name */
    public static String f28042h = "ad_slot_type";

    /* renamed from: i  reason: collision with root package name */
    public static String f28043i = "net_type";
    public static String j = "low_memory";
    public static String k = "total_max_memory_rate";

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f28044c;
    public long l;
    public boolean m;

    public e() {
        HashMap hashMap = new HashMap();
        this.f28044c = hashMap;
        hashMap.put(f28038d, "default");
        this.f28044c.put(f28039e, "default");
        this.f28044c.put(f28040f, "default");
        this.f28044c.put(f28041g, "default");
        this.f28044c.put(f28042h, "default");
        this.f28044c.put(f28043i, "default");
        this.f28044c.put(j, "default");
        this.f28044c.put(k, "default");
        this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_env", "last_app_env_time", 0L);
        this.m = false;
    }

    private void d() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f2 = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) p.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
        String str = f28036a;
        com.bytedance.sdk.openadsdk.utils.u.f(str, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        String str2 = f28036a;
        com.bytedance.sdk.openadsdk.utils.u.f(str2, "maxMemory: " + maxMemory);
        String str3 = f28036a;
        com.bytedance.sdk.openadsdk.utils.u.f(str3, "totalMemory: " + f2);
        String str4 = f28036a;
        com.bytedance.sdk.openadsdk.utils.u.f(str4, "freeMemory: " + ((float) ((runtime.freeMemory() * 1.0d) / 1048576.0d)));
        int i2 = (int) ((f2 / maxMemory) * 100.0f);
        String str5 = f28036a;
        com.bytedance.sdk.openadsdk.utils.u.f(str5, "totalMaxRate: " + i2);
        this.f28044c.put(j, String.valueOf(memoryInfo.lowMemory));
        this.f28044c.put(k, String.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context a2 = p.a();
            if (a2 == null) {
                return null;
            }
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 4111);
            ApplicationInfo applicationInfo = a2.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put(Constants.APP_ID, i.d().g());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Map<String, String> b() {
        return this.f28044c;
    }

    public void c() {
        if (this.m || ak.a(this.l, System.currentTimeMillis())) {
            return;
        }
        this.m = true;
        com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("trySendAppManifestInfo") { // from class: com.bytedance.sdk.openadsdk.core.e.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject e2 = e.this.e();
                if (e2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    e.this.l = currentTimeMillis;
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_env", "last_app_env_time", Long.valueOf(currentTimeMillis));
                    com.bytedance.sdk.openadsdk.h.a.a().a(e2);
                }
                e.this.m = false;
            }
        }, 1);
    }

    public static e a() {
        if (f28037b == null) {
            synchronized (e.class) {
                if (f28037b == null) {
                    f28037b = new e();
                }
            }
        }
        return f28037b;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar == null) {
            return;
        }
        this.f28044c.put(f28039e, lVar.am());
        Map<String, String> map = this.f28044c;
        String str = f28040f;
        map.put(str, "" + ak.d(lVar.ap()));
        this.f28044c.put(f28041g, ak.h(lVar.ap()));
        Map<String, String> map2 = this.f28044c;
        String str2 = f28042h;
        map2.put(str2, "" + ak.c(lVar.ap()));
        this.f28044c.put(f28043i, com.bytedance.sdk.openadsdk.utils.x.f(p.a()));
        if (lVar.C()) {
            this.f28044c.put(f28038d, "is_playable");
        }
        d();
    }
}
