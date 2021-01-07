package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.s;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
/* loaded from: classes4.dex */
public final class d implements w {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.c f7176a;

    public d(com.bytedance.sdk.openadsdk.d.b.c cVar) {
        this.f7176a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.d.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        com.bytedance.sdk.openadsdk.d.a.b bVar = (com.bytedance.sdk.openadsdk.d.a.b) aVar.a().getAnnotation(com.bytedance.sdk.openadsdk.d.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (v<T>) a(this.f7176a, fVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v<?> a(com.bytedance.sdk.openadsdk.d.b.c cVar, com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<?> aVar, com.bytedance.sdk.openadsdk.d.a.b bVar) {
        v<?> lVar;
        Object a2 = cVar.a(com.bytedance.sdk.openadsdk.d.c.a.b(bVar.a())).a();
        if (a2 instanceof v) {
            lVar = (v) a2;
        } else if (a2 instanceof w) {
            lVar = ((w) a2).a(fVar, aVar);
        } else if ((a2 instanceof s) || (a2 instanceof com.bytedance.sdk.openadsdk.d.k)) {
            lVar = new l<>(a2 instanceof s ? (s) a2 : null, a2 instanceof com.bytedance.sdk.openadsdk.d.k ? (com.bytedance.sdk.openadsdk.d.k) a2 : null, fVar, aVar, null);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (lVar != null && bVar.b()) {
            return lVar.a();
        }
        return lVar;
    }
}
