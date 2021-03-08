package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private static volatile e b;
    private Map<String, String> c = new HashMap();
    private long l;
    private boolean m;

    /* renamed from: a  reason: collision with root package name */
    private static String f4422a = "AppEnvironment";
    private static String d = "ad_style";
    private static String e = LegoListActivityConfig.AD_ID;
    private static String f = "rit";
    private static String g = "request_id";
    private static String h = "ad_slot_type";
    private static String i = "net_type";
    private static String j = "low_memory";
    private static String k = "total_max_memory_rate";

    private e() {
        this.c.put(d, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(e, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(f, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(g, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(h, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(i, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(j, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.c.put(k, DefaultSharedPrefsWrapper.SP_FILE_DEFAULT);
        this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_env", "last_app_env_time", 0L);
        this.m = false;
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar != null) {
            this.c.put(e, lVar.ag());
            this.c.put(f, "" + aj.d(lVar.aj()));
            this.c.put(g, aj.h(lVar.aj()));
            this.c.put(h, "" + aj.c(lVar.aj()));
            this.c.put(i, com.bytedance.sdk.openadsdk.utils.x.f(p.a()));
            if (lVar.C()) {
                this.c.put(d, "is_playable");
            }
            d();
        }
    }

    private void d() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f2 = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        float freeMemory = (float) ((runtime.freeMemory() * 1.0d) / 1048576.0d);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) p.a().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        com.bytedance.sdk.openadsdk.utils.u.f(f4422a, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.openadsdk.utils.u.f(f4422a, "maxMemory: " + maxMemory);
        com.bytedance.sdk.openadsdk.utils.u.f(f4422a, "totalMemory: " + f2);
        com.bytedance.sdk.openadsdk.utils.u.f(f4422a, "freeMemory: " + freeMemory);
        int i2 = (int) ((f2 / maxMemory) * 100.0f);
        com.bytedance.sdk.openadsdk.utils.u.f(f4422a, "totalMaxRate: " + i2);
        this.c.put(j, String.valueOf(memoryInfo.lowMemory));
        this.c.put(k, String.valueOf(i2));
    }

    public Map<String, String> b() {
        return this.c;
    }

    public void c() {
        if (!this.m && !aj.a(this.l, System.currentTimeMillis())) {
            this.m = true;
            com.bytedance.sdk.openadsdk.j.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.e.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject e2 = e.this.e();
                    if (e2 != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        e.this.l = currentTimeMillis;
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sp_app_env", "last_app_env_time", Long.valueOf(currentTimeMillis));
                        com.bytedance.sdk.openadsdk.g.a.a().a(e2);
                    }
                    e.this.m = false;
                }
            }, 1);
        }
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
            jSONObject.put("app_id", i.d().f());
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
        } catch (Throwable th) {
            return null;
        }
    }
}
