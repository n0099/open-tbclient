package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class h extends v<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f7183a = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.h.1
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.f f7184b;

    h(com.bytedance.sdk.openadsdk.d.f fVar) {
        this.f7184b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public Object b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                com.bytedance.sdk.openadsdk.d.b.h hVar = new com.bytedance.sdk.openadsdk.d.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return hVar;
            case STRING:
                return aVar.h();
            case NUMBER:
                return Double.valueOf(aVar.k());
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        v a2 = this.f7184b.a((Class) obj.getClass());
        if (a2 instanceof h) {
            cVar.d();
            cVar.e();
            return;
        }
        a2.a(cVar, obj);
    }
}
