package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bu extends bv {

    /* renamed from: b  reason: collision with root package name */
    private boolean f6113b;
    private final m phu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(Context context, m mVar) {
        super(context);
        this.phu = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.f6113b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] epx() {
        return cc.phA;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        if (this.phu.o() != 0) {
            JSONObject a2 = this.phu.a();
            if (a2 != null) {
                this.f6113b = aa.x(ab.a(this.f6114a, this.phu.a(), aa.ept().epD(), true, b.eoP()), a2);
            } else {
                au.a(null);
            }
        }
        return this.f6113b;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "ac";
    }
}
