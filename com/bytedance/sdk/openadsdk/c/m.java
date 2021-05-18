package com.bytedance.sdk.openadsdk.c;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class m extends b<c.a> {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f27352a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public boolean f27353b;

    public m(boolean z) {
        this.f27353b = true;
        this.f27353b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a() {
        if (this.f27352a.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.c.a.a(this.f27353b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(@NonNull c.a aVar) {
        if (!this.f27352a.get()) {
            a();
        }
        if (this.f27352a.get()) {
            com.bytedance.sdk.openadsdk.multipro.c.a.a(aVar.a(), this.f27353b);
        }
    }
}
