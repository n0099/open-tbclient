package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.g.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class m extends b<c.a> {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f4209a = new AtomicBoolean(false);
    private boolean b;

    public m(boolean z) {
        this.b = true;
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (!this.f4209a.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(this.b);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull c.a aVar) {
        if (this.f4209a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.b);
        }
    }
}
