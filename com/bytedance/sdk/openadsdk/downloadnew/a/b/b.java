package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import d.o.a.b.a.a.a;
import d.o.a.b.a.a.b;
import d.o.a.b.a.a.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static c.b a(String str, String str2, l lVar, JSONObject jSONObject) {
        if (lVar == null) {
            return new c.b();
        }
        if (TextUtils.isEmpty(str)) {
            return new c.b();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str2).b(jSONObject).a(lVar).b());
        } catch (Exception unused) {
        }
        c.b bVar = new c.b();
        bVar.k(Long.valueOf(lVar.am()).longValue());
        bVar.v(lVar.aa() == null ? null : lVar.aa().a());
        bVar.u(i.d().n());
        bVar.A(!i.d().n());
        bVar.m(lVar.ap());
        bVar.n(jSONObject2);
        bVar.z(str);
        bVar.o(true);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            bVar.w(true);
        }
        if (lVar.ao() != null) {
            d.o.a.a.a.d.b bVar2 = new d.o.a.a.a.d.b();
            bVar2.b(Long.valueOf(lVar.am()).longValue());
            bVar2.e(lVar.ao().a());
            bVar2.f(lVar.aj());
            if (lVar.ao().c() != 2 || l.c(lVar)) {
                if (lVar.ao().c() == 1) {
                    bVar2.c(lVar.ao().b());
                } else {
                    bVar2.c(lVar.ac());
                }
            }
            bVar.l(bVar2);
        }
        return bVar;
    }

    public static c.b a(String str, l lVar, JSONObject jSONObject) {
        if (lVar == null) {
            return new c.b();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str).b(jSONObject).a(lVar).b());
        } catch (Exception unused) {
        }
        c.b bVar = new c.b();
        bVar.k(Double.valueOf(lVar.am()).longValue());
        bVar.v(lVar.aa() == null ? null : lVar.aa().a());
        bVar.u(i.d().n());
        bVar.A(!i.d().n());
        bVar.m(lVar.ap());
        bVar.n(jSONObject2);
        bVar.o(true);
        com.bytedance.sdk.openadsdk.core.d.b an = lVar.an();
        if (an != null) {
            bVar.z(an.b());
            bVar.B(an.c());
            bVar.t(an.d());
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            bVar.w(true);
        }
        if (lVar.ao() != null) {
            d.o.a.a.a.d.b bVar2 = new d.o.a.a.a.d.b();
            bVar2.b(Long.valueOf(lVar.am()).longValue());
            bVar2.e(lVar.ao().a());
            bVar2.f(lVar.aj());
            if (lVar.ao().c() != 2 || l.c(lVar)) {
                if (lVar.ao().c() == 1) {
                    bVar2.c(lVar.ao().b());
                } else {
                    bVar2.c(lVar.ac());
                }
            }
            bVar.l(bVar2);
        }
        return bVar;
    }

    public static a.b a(l lVar) {
        int G = lVar == null ? 1 : lVar.G();
        int H = lVar == null ? 0 : lVar.H();
        if (lVar != null && !TextUtils.isEmpty(lVar.aA())) {
            H = 2;
        }
        a.b bVar = new a.b();
        bVar.b(G);
        bVar.g(H);
        bVar.d(true);
        bVar.h(false);
        bVar.c(lVar);
        return bVar;
    }

    public static b.C1855b a(l lVar, String str) {
        b.C1855b c1855b = new b.C1855b();
        c1855b.b(str);
        c1855b.f(str);
        c1855b.i("click_start");
        c1855b.n("click_continue");
        c1855b.l("click_pause");
        c1855b.t("download_failed");
        c1855b.p("click_install");
        c1855b.c(true);
        c1855b.j(false);
        return c1855b;
    }
}
