package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class cc extends bv {
    private m pnO;
    private ce pnP;
    static final long[] pnM = {AppStatusRules.DEFAULT_GRANULARITY, AppStatusRules.DEFAULT_GRANULARITY, AppStatusRules.DEFAULT_GRANULARITY, 120000, 120000, 120000, 180000, 180000};
    static final long[] c = {180000, 180000, 360000, 360000, 540000, 540000};
    private static final long[] d = {10000, 10000, 20000, 20000, AppStatusRules.DEFAULT_GRANULARITY, 6000, 180000, 180000, 540000, 540000};

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(Context context, m mVar, ce ceVar) {
        super(context);
        this.pnO = mVar;
        this.pnP = ceVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return (this.pnP.c() ? Constants.IM_TRACK_DURATION_MS : 43200000) + this.pnO.p();
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eoc() {
        switch (this.pnO.o()) {
            case 0:
                return d;
            case 1:
                return c;
            case 2:
                return pnM;
            default:
                au.a(null);
                return c;
        }
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = this.pnO.a();
        if (a2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject w = aa.w(ab.a(this.f5816a, this.pnO.a(), aa.enY().eoi(), true, b.enu()), jSONObject);
            if (w != null) {
                return this.pnO.a(w, w.optString("device_id", ""), w.optString("install_id", ""), w.optString("ssid", ""));
            }
        } else {
            au.a(null);
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "r";
    }
}
