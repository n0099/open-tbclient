package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class a<E> extends v<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f7167a = new w() { // from class: com.bytedance.sdk.openadsdk.d.b.a.a.1
        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            Type b2 = aVar.b();
            if (!(b2 instanceof GenericArrayType) && (!(b2 instanceof Class) || !((Class) b2).isArray())) {
                return null;
            }
            Type g = com.bytedance.sdk.openadsdk.d.b.b.g(b2);
            return new a(fVar, fVar.a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(g)), com.bytedance.sdk.openadsdk.d.b.b.e(g));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Class<E> f7168b;
    private final v<E> c;

    public a(com.bytedance.sdk.openadsdk.d.f fVar, v<E> vVar, Class<E> cls) {
        this.c = new m(fVar, vVar, cls);
        this.f7168b = cls;
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public Object b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.b(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f7168b, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bytedance.sdk.openadsdk.d.v<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.d.v
    public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(cVar, Array.get(obj, i));
        }
        cVar.c();
    }
}
