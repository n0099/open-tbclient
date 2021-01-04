package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    private static volatile e f6829b;
    private Map<String, String> c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private static String f6828a = "AppEnvironment";
    private static String d = MapBundleKey.MapObjKey.OBJ_AD_STYLE;
    private static String e = LegoListActivityConfig.AD_ID;
    private static String f = "rit";
    private static String g = "request_id";
    private static String h = "ad_slot_type";
    private static String i = "net_type";
    private static String j = "low_memory";
    private static String k = "total_max_memory_rate";

    private e() {
        this.c.put(d, "default");
        this.c.put(e, "default");
        this.c.put(f, "default");
        this.c.put(g, "default");
        this.c.put(h, "default");
        this.c.put(i, "default");
        this.c.put(j, "default");
        this.c.put(k, "default");
    }

    public static e a() {
        if (f6829b == null) {
            synchronized (e.class) {
                if (f6829b == null) {
                    f6829b = new e();
                }
            }
        }
        return f6829b;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar != null) {
            this.c.put(e, lVar.T());
            this.c.put(f, "" + aj.d(lVar.W()));
            this.c.put(g, aj.h(lVar.W()));
            this.c.put(h, "" + aj.c(lVar.W()));
            this.c.put(i, com.bytedance.sdk.openadsdk.utils.x.f(p.a()));
            if (lVar.s()) {
                this.c.put(d, "is_playable");
            }
            c();
        }
    }

    private void c() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f2 = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        float freeMemory = (float) ((runtime.freeMemory() * 1.0d) / 1048576.0d);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) p.a().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        com.bytedance.sdk.openadsdk.utils.u.f(f6828a, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.openadsdk.utils.u.f(f6828a, "maxMemory: " + maxMemory);
        com.bytedance.sdk.openadsdk.utils.u.f(f6828a, "totalMemory: " + f2);
        com.bytedance.sdk.openadsdk.utils.u.f(f6828a, "freeMemory: " + freeMemory);
        int i2 = (int) ((f2 / maxMemory) * 100.0f);
        com.bytedance.sdk.openadsdk.utils.u.f(f6828a, "totalMaxRate: " + i2);
        this.c.put(j, String.valueOf(memoryInfo.lowMemory));
        this.c.put(k, String.valueOf(i2));
    }

    public Map<String, String> b() {
        return this.c;
    }
}
