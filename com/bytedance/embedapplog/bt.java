package com.bytedance.embedapplog;

import android.app.Application;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bt extends bv {
    private long b;
    private final m ppP;
    private final cn ppc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(Application application, m mVar, cn cnVar) {
        super(application);
        this.ppP = mVar;
        this.ppc = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long s = this.ppc.s();
        return (s >= 600000 ? s : 600000L) + this.b;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eon() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject a2 = this.ppP.a();
        if (this.ppP.o() != 0 && a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.ppP.a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject z = aa.z(aa.a(ab.a(this.f3924a, this.ppP.a(), aa.eoj().eov(), true, b.enE()), aa.c), jSONObject);
            if (z != null) {
                b.enL().onRemoteAbConfigGet(av.a(b.enG(), z) ? false : true, z);
                if (au.b) {
                    au.a("getAbConfig " + z, null);
                }
                this.ppP.a(z);
                this.b = currentTimeMillis;
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "ab";
    }
}
