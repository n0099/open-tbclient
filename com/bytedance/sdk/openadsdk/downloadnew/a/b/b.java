package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.ss.android.b.a.a.a;
import com.ss.android.b.a.a.b;
import com.ss.android.b.a.a.c;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        c.a BT = new c.a().iY(Long.valueOf(lVar.T()).longValue()).aaM(lVar.I() == null ? null : lVar.I().a()).BU(i.c().k()).BW(!i.c().k()).aaK(lVar.W()).fb(jSONObject2).aaN(str).BT(true);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            BT.BV(true);
            return BT;
        }
        return BT;
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
        c.a BT = new c.a().iY(Long.valueOf(lVar.T()).longValue()).aaM(lVar.I() == null ? null : lVar.I().a()).BU(i.c().k()).BW(!i.c().k()).aaK(lVar.W()).fb(jSONObject2).BT(true);
        com.bytedance.sdk.openadsdk.core.d.b U = lVar.U();
        if (U != null) {
            BT.aaN(U.b()).aaO(U.c()).aaL(U.d());
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            BT.BV(true);
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
            BT.a(bVar);
            return BT;
        }
        return BT;
    }

    public static a.C1220a a(l lVar) {
        int w = lVar == null ? 0 : lVar.w();
        int x = lVar == null ? 0 : lVar.x();
        if (lVar != null && !TextUtils.isEmpty(lVar.ag())) {
            x = 2;
        }
        return new a.C1220a().QO(w).QP(x).BM(true).BN(false).bG(lVar);
    }

    public static b.a a(l lVar, String str) {
        return new b.a().aaz(str).aaA(str).aaB("click_start").aaD("click_continue").aaC("click_pause").aaG("download_failed").aaE("click_install").BQ(true).BS(false);
    }
}
