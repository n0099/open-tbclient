package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class bw extends bv {
    private final m ppQ;
    private final cn ppR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(Context context, m mVar, cn cnVar) {
        super(context);
        this.ppQ = mVar;
        this.ppR = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.ppR.h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eon() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        JSONObject a2 = this.ppQ.a();
        if (this.ppQ.o() != 0 && a2 != null && this.ppR.h() + 21600000 <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject y = aa.y(aa.a(ab.a(this.f3924a, this.ppQ.a(), aa.eoj().eou(), true, b.enE()), aa.c), jSONObject);
            b.enL().onRemoteConfigGet(!av.a(y, this.ppR.g()), y);
            if (y != null) {
                this.ppR.a(y);
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
