package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class bw extends bv {
    private final m phu;
    private final cn phv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(Context context, m mVar, cn cnVar) {
        super(context);
        this.phu = mVar;
        this.phv = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.phv.h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] epw() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        JSONObject a2 = this.phu.a();
        if (this.phu.o() != 0 && a2 != null && this.phv.h() + 21600000 <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject y = aa.y(aa.a(ab.a(this.f6113a, this.phu.a(), aa.eps().epD(), true, b.eoO()), aa.c), jSONObject);
            b.eoV().onRemoteConfigGet(!av.a(y, this.phv.epI()), y);
            if (y != null) {
                this.phv.a(y);
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "c";
    }
}
