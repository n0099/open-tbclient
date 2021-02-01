package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.c f6873a;

    public b(com.bytedance.sdk.openadsdk.d.b.c cVar) {
        this.f6873a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.d.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        Type b2 = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = com.bytedance.sdk.openadsdk.d.b.b.a(b2, (Class<?>) a2);
        return new a(fVar, a3, fVar.a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(a3)), this.f6873a.a(aVar));
    }

    /* loaded from: classes6.dex */
    private static final class a<E> extends v<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final v<E> f6874a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.d.b.i<? extends Collection<E>> f6875b;

        @Override // com.bytedance.sdk.openadsdk.d.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException {
            a(cVar, (Collection) ((Collection) obj));
        }

        public a(com.bytedance.sdk.openadsdk.d.f fVar, Type type, v<E> vVar, com.bytedance.sdk.openadsdk.d.b.i<? extends Collection<E>> iVar) {
            this.f6874a = new m(fVar, vVar, type);
            this.f6875b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Collection<E> b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> a2 = this.f6875b.a();
            aVar.a();
            while (aVar.e()) {
                a2.add(this.f6874a.b(aVar));
            }
            aVar.b();
            return a2;
        }

        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            for (E e : collection) {
                this.f6874a.a(cVar, e);
            }
            cVar.c();
        }
    }
}
