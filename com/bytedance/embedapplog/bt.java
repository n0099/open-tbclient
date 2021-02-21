package com.bytedance.embedapplog;

import android.app.Application;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bt extends bv {

    /* renamed from: b  reason: collision with root package name */
    private long f5814b;
    private final cn pmU;
    private final m pnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(Application application, m mVar, cn cnVar) {
        super(application);
        this.pnF = mVar;
        this.pmU = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long s = this.pmU.s();
        return (s >= 600000 ? s : 600000L) + this.f5814b;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] eoc() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject a2 = this.pnF.a();
        if (this.pnF.o() != 0 && a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.pnF.a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject z = aa.z(aa.a(ab.a(this.f5816a, this.pnF.a(), aa.enY().eol(), true, b.enu()), aa.c), jSONObject);
            if (z != null) {
                b.enB().onRemoteAbConfigGet(av.a(b.enw(), z) ? false : true, z);
                if (au.f5788b) {
                    au.a("getAbConfig " + z, null);
                }
                this.pnF.a(z);
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
