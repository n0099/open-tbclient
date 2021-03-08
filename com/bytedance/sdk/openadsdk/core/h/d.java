package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.statistics.j;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.j.g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f4453a;

    public static d a() {
        if (f4453a == null) {
            synchronized (f.class) {
                if (f4453a == null) {
                    f4453a = new d();
                }
            }
        }
        return f4453a;
    }

    private d() {
    }

    public void b() {
        com.bytedance.sdk.openadsdk.j.e.a(this, 1);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!e()) {
            try {
                wait(1000L);
            } catch (Exception e) {
            }
            List<e> I = p.h().I();
            if (I != null) {
                for (int i = 0; i < I.size(); i++) {
                    e eVar = I.get(i);
                    if (eVar != null) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (eVar.b != null && eVar.c != null && currentTimeMillis - com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", eVar.c, 0L) > eVar.d * 1000) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", eVar.c, Long.valueOf(currentTimeMillis));
                                Intent intent = new Intent();
                                intent.setAction(eVar.f4454a);
                                intent.setPackage(eVar.c);
                                p.a().startService(intent);
                                a(eVar, 1);
                            }
                        } catch (Throwable th) {
                            a(eVar, 0);
                        }
                    }
                }
            }
        }
    }

    public void a(e eVar, int i) {
        com.bytedance.sdk.openadsdk.g.a.c cVar = new com.bytedance.sdk.openadsdk.g.a.c();
        cVar.b(b(eVar, i));
        cVar.a("wk_status");
        cVar.e("3.4.0.1");
        cVar.c(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.g.a.a().m(cVar);
    }

    private String b(e eVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wk_status", i);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.i.d().f());
            jSONObject.put("package_name", aj.e());
            jSONObject.put("geo", d());
            jSONObject.put("ad_sdk_version", "3.4.0.1");
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put(j.c, aj.b());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("ad_package_name", eVar.c);
            jSONObject.put("action", eVar.f4454a);
            jSONObject.put("service", eVar.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONObject d() {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
        if (a2 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", a2.f5126a);
                jSONObject.put("longitude", a2.b);
                return jSONObject;
            } catch (Exception e) {
            }
        }
        return null;
    }

    private boolean e() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.i.d().f());
    }
}
