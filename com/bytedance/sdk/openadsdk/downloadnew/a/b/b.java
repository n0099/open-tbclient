package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.ss.android.b.a.a.a;
import com.ss.android.b.a.a.b;
import com.ss.android.b.a.a.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static c.a a(String str, String str2, l lVar, JSONObject jSONObject) {
        if (lVar == null) {
            return new c.a();
        }
        if (TextUtils.isEmpty(str)) {
            return new c.a();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str2).b(jSONObject).a(lVar).b());
        } catch (Exception e) {
        }
        c.a Bz = new c.a().iV(Long.valueOf(lVar.T()).longValue()).Zz(lVar.I() == null ? null : lVar.I().a()).BA(i.c().k()).BC(!i.c().k()).Zx(lVar.W()).fa(jSONObject2).ZA(str).Bz(true);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            Bz.BB(true);
            return Bz;
        }
        return Bz;
    }

    public static c.a a(String str, l lVar, JSONObject jSONObject) {
        if (lVar == null) {
            return new c.a();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", a.a().a(str).b(jSONObject).a(lVar).b());
        } catch (Exception e) {
        }
        c.a Bz = new c.a().iV(Long.valueOf(lVar.T()).longValue()).Zz(lVar.I() == null ? null : lVar.I().a()).BA(i.c().k()).BC(!i.c().k()).Zx(lVar.W()).fa(jSONObject2).Bz(true);
        com.bytedance.sdk.openadsdk.core.d.b U = lVar.U();
        if (U != null) {
            Bz.ZA(U.b()).ZB(U.c()).Zy(U.d());
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            Bz.BB(true);
        }
        if (lVar.V() != null) {
            com.ss.android.a.a.d.b bVar = new com.ss.android.a.a.d.b();
            bVar.a(Long.valueOf(lVar.T()).longValue());
            bVar.b(lVar.V().a());
            bVar.c(lVar.Q());
            if (lVar.V().c() != 2 || lVar.X() == 5 || lVar.X() == 15) {
                if (lVar.V().c() == 1) {
                    bVar.a(lVar.V().b());
                } else {
                    bVar.a(lVar.K());
                }
            }
            Bz.a(bVar);
            return Bz;
        }
        return Bz;
    }

    public static a.C1214a a(l lVar) {
        int w = lVar == null ? 0 : lVar.w();
        int x = lVar == null ? 0 : lVar.x();
        if (lVar != null && !TextUtils.isEmpty(lVar.ag())) {
            x = 2;
        }
        return new a.C1214a().Qs(w).Qt(x).Bs(true).Bt(false).bG(lVar);
    }

    public static b.a a(l lVar, String str) {
        return new b.a().Zm(str).Zn(str).Zo("click_start").Zq("click_continue").Zp("click_pause").Zt("download_failed").Zr("click_install").Bw(true).By(false);
    }
}
