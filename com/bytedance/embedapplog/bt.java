package com.bytedance.embedapplog;

import android.app.Application;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bt extends bv {

    /* renamed from: b  reason: collision with root package name */
    private long f6112b;
    private final cn pgH;
    private final m pht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(Application application, m mVar, cn cnVar) {
        super(application);
        this.pht = mVar;
        this.pgH = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long s = this.pgH.s();
        return (s >= 600000 ? s : 600000L) + this.f6112b;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] epx() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject a2 = this.pht.a();
        if (this.pht.o() != 0 && a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.pht.a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject z = aa.z(aa.a(ab.a(this.f6114a, this.pht.a(), aa.ept().epF(), true, b.eoP()), aa.c), jSONObject);
            if (z != null) {
                b.eoW().onRemoteAbConfigGet(av.a(b.eoR(), z) ? false : true, z);
                if (au.f6086b) {
                    au.a("getAbConfig " + z, null);
                }
                this.pht.a(z);
                this.f6112b = currentTimeMillis;
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
