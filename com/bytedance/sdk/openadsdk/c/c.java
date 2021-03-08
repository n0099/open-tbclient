package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class c extends b<a> {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f4198a = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (!this.f4198a.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.multipro.c.a.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull a aVar) {
        if (this.f4198a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a());
        }
    }
}
