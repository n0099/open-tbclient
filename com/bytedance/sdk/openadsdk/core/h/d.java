package com.bytedance.sdk.openadsdk.core.h;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.l.g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f28408a;

    public d() {
        super("ProcessPushHelper");
    }

    public static d a() {
        if (f28408a == null) {
            synchronized (f.class) {
                if (f28408a == null) {
                    f28408a = new d();
                }
            }
        }
        return f28408a;
    }

    private JSONObject c() {
        com.bytedance.sdk.openadsdk.utils.c a2 = com.bytedance.sdk.openadsdk.utils.d.a(p.a());
        if (a2 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", a2.f30396a);
                jSONObject.put("longitude", a2.f30397b);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private boolean d() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.i.d().g());
    }

    public void b() {
        com.bytedance.sdk.openadsdk.l.e.a(this, 1);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (d()) {
            return;
        }
        try {
            wait(1000L);
        } catch (Exception unused) {
        }
        List<e> I = p.h().I();
        if (I != null) {
            for (int i = 0; i < I.size(); i++) {
                e eVar = I.get(i);
                if (eVar != null) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (eVar.f28410b != null && eVar.f28411c != null && currentTimeMillis - com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", eVar.f28411c, 0L) > eVar.f28412d * 1000) {
                            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_push_time", eVar.f28411c, Long.valueOf(currentTimeMillis));
                            Intent intent = new Intent();
                            intent.setAction(eVar.f28409a);
                            intent.setPackage(eVar.f28411c);
                            p.a().startService(intent);
                            a(eVar, 1);
                        }
                    } catch (Throwable unused2) {
                        a(eVar, 0);
                    }
                }
            }
        }
    }

    private String b(e eVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wk_status", i);
            jSONObject.put(Constants.APP_ID, com.bytedance.sdk.openadsdk.core.i.d().g());
            jSONObject.put("package_name", ak.e());
            jSONObject.put("geo", c());
            jSONObject.put("ad_sdk_version", "3.4.5.5");
            jSONObject.put(IXAdRequestInfo.OS, 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.i.a(true));
            jSONObject.put("ua", ak.b());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("ad_package_name", eVar.f28411c);
            jSONObject.put("action", eVar.f28409a);
            jSONObject.put("service", eVar.f28410b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void a(e eVar, int i) {
        com.bytedance.sdk.openadsdk.h.a.c cVar = new com.bytedance.sdk.openadsdk.h.a.c();
        cVar.b(b(eVar, i));
        cVar.a("wk_status");
        cVar.e("3.4.5.5");
        cVar.c(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.h.a.a().m(cVar);
    }
}
