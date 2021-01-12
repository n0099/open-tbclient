package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements Runnable {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f6582a;

    public static f a() {
        if (f6582a == null) {
            synchronized (i.class) {
                if (f6582a == null) {
                    f6582a = new f();
                }
            }
        }
        return f6582a;
    }

    private f() {
    }

    public void b() {
        com.bytedance.sdk.openadsdk.k.a.a().b(this, 1);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!d()) {
            try {
                wait(1000L);
            } catch (Exception e) {
            }
            List<g> J = p.h().J();
            if (J != null) {
                for (int i = 0; i < J.size(); i++) {
                    g gVar = J.get(i);
                    if (gVar != null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (gVar.f6584b != null && gVar.c != null && currentTimeMillis - com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", gVar.c, 0L) > gVar.d * 1000) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", gVar.c, Long.valueOf(currentTimeMillis));
                                Intent intent = new Intent();
                                intent.setAction(gVar.f6583a);
                                intent.setPackage(gVar.c);
                                p.a().startService(intent);
                                a(gVar, 1);
                            }
                        } catch (Throwable th) {
                            a(gVar, 0);
                        }
                    }
                }
            }
        }
    }

    public void a(g gVar, int i) {
        com.bytedance.sdk.openadsdk.h.a.d dVar = new com.bytedance.sdk.openadsdk.h.a.d();
        dVar.b(b(gVar, i));
        dVar.a("wk_status");
        dVar.e("3.2.5.1");
        dVar.c(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.h.a.a().m(dVar);
    }

    private String b(g gVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wk_status", i);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.i.c().e());
            jSONObject.put("package_name", aj.d());
            jSONObject.put("geo", c());
            jSONObject.put("ad_sdk_version", "3.2.5.1");
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put(com.baidu.fsg.base.statistics.j.c, aj.a());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("ad_package_name", gVar.c);
            jSONObject.put("action", gVar.f6583a);
            jSONObject.put("service", gVar.f6584b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject c() {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
        if (a2 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", a2.f7564a);
                jSONObject.put("longitude", a2.f7565b);
                return jSONObject;
            } catch (Exception e) {
            }
        }
        return null;
    }

    private boolean d() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.i.c().e());
    }
}
