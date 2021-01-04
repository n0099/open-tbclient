package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bu extends bv {

    /* renamed from: b  reason: collision with root package name */
    private boolean f6112b;
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
        return this.f6112b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] epw() {
        return cc.phA;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        if (this.phu.o() != 0) {
            JSONObject a2 = this.phu.a();
            if (a2 != null) {
                this.f6112b = aa.x(ab.a(this.f6113a, this.phu.a(), aa.eps().epC(), true, b.eoO()), a2);
            } else {
                au.a(null);
            }
        }
        return this.f6112b;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "ac";
    }
}
