package com.bytedance.embedapplog;

import android.app.Application;
import com.baidu.searchbox.websocket.WebSocketRequest;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bt extends bv {

    /* renamed from: b  reason: collision with root package name */
    private long f5812b;
    private final m pcS;
    private final cn pcf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(Application application, m mVar, cn cnVar) {
        super(application);
        this.pcS = mVar;
        this.pcf = cnVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        long s = this.pcf.s();
        return (s >= 600000 ? s : 600000L) + this.f5812b;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] elB() {
        return cc.c;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        JSONObject a2 = this.pcS.a();
        if (this.pcS.o() != 0 && a2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, this.pcS.a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject z = aa.z(aa.a(ab.a(this.f5814a, this.pcS.a(), aa.elx().elJ(), true, b.ekT()), aa.c), jSONObject);
            if (z != null) {
                b.ela().onRemoteAbConfigGet(av.a(b.ekV(), z) ? false : true, z);
                if (au.f5786b) {
                    au.a("getAbConfig " + z, null);
                }
                this.pcS.a(z);
                this.f5812b = currentTimeMillis;
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
