package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bu extends bv {

    /* renamed from: b  reason: collision with root package name */
    private boolean f5815b;
    private final m png;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(Context context, m mVar) {
        super(context);
        this.png = mVar;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.bv
    long b() {
        return this.f5815b ? Long.MAX_VALUE : 0L;
    }

    @Override // com.bytedance.embedapplog.bv
    long[] enU() {
        return cc.pnm;
    }

    @Override // com.bytedance.embedapplog.bv
    boolean d() {
        if (this.png.o() != 0) {
            JSONObject a2 = this.png.a();
            if (a2 != null) {
                this.f5815b = aa.x(ab.a(this.f5816a, this.png.a(), aa.enQ().eoa(), true, b.enm()), a2);
            } else {
                au.a(null);
            }
        }
        return this.f5815b;
    }

    @Override // com.bytedance.embedapplog.bv
    String e() {
        return "ac";
    }
}
