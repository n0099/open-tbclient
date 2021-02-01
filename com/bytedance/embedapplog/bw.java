package com.bytedance.embedapplog;

import android.content.Context;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class bw extends bv {
    private final m png;
    private final cn pnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(Context context, m mVar, cn cnVar) {
        super(context);
        this.png = mVar;
        this.pnh = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.pnh.h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] enU() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    public boolean d() {
        JSONObject a2 = this.png.a();
        if (this.png.o() != 0 && a2 != null && this.pnh.h() + 21600000 <= System.currentTimeMillis()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject y = aa.y(aa.a(ab.a(this.f5816a, this.png.a(), aa.enQ().eob(), true, b.enm()), aa.c), jSONObject);
            b.ent().onRemoteConfigGet(!av.a(y, this.pnh.eoh()), y);
            if (y != null) {
                this.pnh.a(y);
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
