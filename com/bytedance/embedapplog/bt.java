package com.bytedance.embedapplog;

import android.app.Application;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bt extends bv {

    /* renamed from: b  reason: collision with root package name */
    private long f5814b;
    private final cn pmu;
    private final m pnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(Application application, m mVar, cn cnVar) {
        super(application);
        this.pnf = mVar;
        this.pmu = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long s = this.pmu.s();
        return (s >= 600000 ? s : 600000L) + this.f5814b;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] enU() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject a2 = this.pnf.a();
        if (this.pnf.o() != 0 && a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.pnf.a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject z = aa.z(aa.a(ab.a(this.f5816a, this.pnf.a(), aa.enQ().eoc(), true, b.enm()), aa.c), jSONObject);
            if (z != null) {
                b.ent().onRemoteAbConfigGet(av.a(b.eno(), z) ? false : true, z);
                if (au.f5788b) {
                    au.a("getAbConfig " + z, null);
                }
                this.pnf.a(z);
                this.f5814b = currentTimeMillis;
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
