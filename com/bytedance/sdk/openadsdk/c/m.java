package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.h.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class m extends b<c.a> {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f6541a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private boolean f6542b;

    public m(boolean z) {
        this.f6542b = true;
        this.f6542b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (!this.f6541a.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(this.f6542b);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull c.a aVar) {
        if (this.f6541a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.f6542b);
        }
    }
}
