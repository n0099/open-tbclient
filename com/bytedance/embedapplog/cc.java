package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.kwad.sdk.collector.AppStatusRules;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class cc extends bv {
    private m ppY;
    private ce ppZ;
    static final long[] ppW = {AppStatusRules.DEFAULT_GRANULARITY, AppStatusRules.DEFAULT_GRANULARITY, AppStatusRules.DEFAULT_GRANULARITY, 120000, 120000, 120000, 180000, 180000};
    static final long[] c = {180000, 180000, 360000, 360000, 540000, 540000};
    private static final long[] d = {10000, 10000, 20000, 20000, AppStatusRules.DEFAULT_GRANULARITY, 6000, 180000, 180000, 540000, 540000};

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(Context context, m mVar, ce ceVar) {
        super(context);
        this.ppY = mVar;
        this.ppZ = ceVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return (this.ppZ.c() ? Constants.IM_TRACK_DURATION_MS : 43200000) + this.ppY.p();
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eon() {
        switch (this.ppY.o()) {
            case 0:
                return d;
            case 1:
                return c;
            case 2:
                return ppW;
            default:
                au.a(null);
                return c;
        }
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject a2 = this.ppY.a();
        if (a2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject a3 = aa.a(ab.a(this.f3924a, this.ppY.a(), aa.eoj().eos(), true, b.enE()), jSONObject);
            if (a3 != null) {
                return this.ppY.a(a3, a3.optString("device_id", ""), a3.optString("install_id", ""), a3.optString("ssid", ""));
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
