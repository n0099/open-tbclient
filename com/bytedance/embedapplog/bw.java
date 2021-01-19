package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class bw extends bv {
    private final m pcT;
    private final cn pcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(Context context, m mVar, cn cnVar) {
        super(context);
        this.pcT = mVar;
        this.pcU = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.pcU.h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] elB() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        JSONObject a2 = this.pcT.a();
        if (this.pcT.o() != 0 && a2 != null && this.pcU.h() + 21600000 <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject y = aa.y(aa.a(ab.a(this.f5814a, this.pcT.a(), aa.elx().elI(), true, b.ekT()), aa.c), jSONObject);
            b.ela().onRemoteConfigGet(!av.a(y, this.pcU.elN()), y);
            if (y != null) {
                this.pcU.a(y);
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
