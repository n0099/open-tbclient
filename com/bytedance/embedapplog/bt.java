package com.bytedance.embedapplog;

import android.app.Application;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bt extends bv {

    /* renamed from: b  reason: collision with root package name */
    private long f6111b;
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
        return (s >= 600000 ? s : 600000L) + this.f6111b;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] epw() {
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
            JSONObject z = aa.z(aa.a(ab.a(this.f6113a, this.pht.a(), aa.eps().epE(), true, b.eoO()), aa.c), jSONObject);
            if (z != null) {
                b.eoV().onRemoteAbConfigGet(av.a(b.eoQ(), z) ? false : true, z);
                if (au.f6085b) {
                    au.a("getAbConfig " + z, null);
                }
                this.pht.a(z);
                this.f6111b = currentTimeMillis;
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
