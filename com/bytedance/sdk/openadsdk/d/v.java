package com.bytedance.sdk.openadsdk.d;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class v<T> {
    public abstract void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException;

    public abstract T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException;

    public final v<T> a() {
        return new v<T>() { // from class: com.bytedance.sdk.openadsdk.d.v.1
            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.f();
                } else {
                    v.this.a(cVar, t);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.d.v
            public T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return (T) v.this.b(aVar);
            }
        };
    }

    public final l a(T t) {
        try {
            com.bytedance.sdk.openadsdk.d.b.a.f fVar = new com.bytedance.sdk.openadsdk.d.b.a.f();
            a(fVar, t);
            return fVar.a();
        } catch (IOException e) {
            throw new m(e);
        }
    }
}
