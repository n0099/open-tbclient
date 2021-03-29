package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class m extends b<c.a> {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f27588a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public boolean f27589b;

    public m(boolean z) {
        this.f27589b = true;
        this.f27589b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (this.f27588a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.a(this.f27589b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull c.a aVar) {
        if (!this.f27588a.get()) {
            a();
        }
        if (this.f27588a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.f27589b);
        }
    }
}
