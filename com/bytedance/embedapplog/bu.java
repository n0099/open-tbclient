package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class bu extends bv {

    /* renamed from: b  reason: collision with root package name */
    private boolean f5813b;
    private final m pcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(Context context, m mVar) {
        super(context);
        this.pcT = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.f5813b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] elB() {
        return cc.pcZ;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        if (this.pcT.o() != 0) {
            JSONObject a2 = this.pcT.a();
            if (a2 != null) {
                this.f5813b = aa.x(ab.a(this.f5814a, this.pcT.a(), aa.elx().elH(), true, b.ekT()), a2);
            } else {
                au.a(null);
            }
        }
        return this.f5813b;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "ac";
    }
}
