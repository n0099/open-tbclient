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
        c.a BR = new c.a().iY(Long.valueOf(lVar.ag()).longValue()).aaR(lVar.U() == null ? null : lVar.U().a()).BS(i.d().l()).BU(!i.d().l()).aaP(lVar.aj()).fe(jSONObject2).aaS(str).BR(true);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            BR.BT(true);
        }
        if (lVar.ai() != null) {
            com.ss.android.a.a.d.b bVar = new com.ss.android.a.a.d.b();
            bVar.a(Long.valueOf(lVar.ag()).longValue());
            bVar.b(lVar.ai().a());
            bVar.c(lVar.ad());
            if (lVar.ai().c() != 2 || l.c(lVar)) {
                if (lVar.ai().c() == 1) {
                    bVar.a(lVar.ai().b());
                } else {
                    bVar.a(lVar.W());
                }
            }
            BR.a(bVar);
            return BR;
        }
        return BR;
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
        c.a BR = new c.a().iY(Double.valueOf(lVar.ag()).longValue()).aaR(lVar.U() == null ? null : lVar.U().a()).BS(i.d().l()).BU(!i.d().l()).aaP(lVar.aj()).fe(jSONObject2).BR(true);
        com.bytedance.sdk.openadsdk.core.d.b ah = lVar.ah();
        if (ah != null) {
            BR.aaS(ah.b()).aaT(ah.c()).aaQ(ah.d());
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            BR.BT(true);
        }
        if (lVar.ai() != null) {
            com.ss.android.a.a.d.b bVar = new com.ss.android.a.a.d.b();
            bVar.a(Long.valueOf(lVar.ag()).longValue());
            bVar.b(lVar.ai().a());
            bVar.c(lVar.ad());
            if (lVar.ai().c() != 2 || l.c(lVar)) {
                if (lVar.ai().c() == 1) {
                    bVar.a(lVar.ai().b());
                } else {
                    bVar.a(lVar.W());
                }
            }
            BR.a(bVar);
            return BR;
        }
        return BR;
    }

    public static a.C1210a a(l lVar) {
        int G = lVar == null ? 1 : lVar.G();
        int H = lVar == null ? 0 : lVar.H();
        if (lVar != null && !TextUtils.isEmpty(lVar.at())) {
            H = 2;
        }
        return new a.C1210a().QS(G).QT(H).BK(true).BL(false).bI(lVar);
    }

    public static b.a a(l lVar, String str) {
        return new b.a().aaE(str).aaF(str).aaG("click_start").aaI("click_continue").aaH("click_pause").aaL("download_failed").aaJ("click_install").BO(true).BQ(false);
    }
}
