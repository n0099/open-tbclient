package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class bw extends bv {
    private final m pnG;
    private final cn pnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(Context context, m mVar, cn cnVar) {
        super(context);
        this.pnG = mVar;
        this.pnH = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.pnH.h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eoc() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        JSONObject a2 = this.pnG.a();
        if (this.pnG.o() != 0 && a2 != null && this.pnH.h() + 21600000 <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject y = aa.y(aa.a(ab.a(this.f5816a, this.pnG.a(), aa.enY().eok(), true, b.enu()), aa.c), jSONObject);
            b.enB().onRemoteConfigGet(!av.a(y, this.pnH.eop()), y);
            if (y != null) {
                this.pnH.a(y);
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
