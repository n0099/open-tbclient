package com.bytedance.pangle.f;

import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public final class h implements k {
    public final ByteBuffer a;

    public h(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.f.k
    public final long a() {
        return this.a.capacity();
    }

    @Override // com.bytedance.pangle.f.k
    public final void a(j jVar, long j, int i) {
        ByteBuffer slice;
        synchronized (this.a) {
            this.a.position(0);
            int i2 = (int) j;
            this.a.limit(i + i2);
            this.a.position(i2);
            slice = this.a.slice();
        }
        jVar.a(slice);
    }
}
