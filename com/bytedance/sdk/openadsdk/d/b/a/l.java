package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.r;
import com.bytedance.sdk.openadsdk.d.s;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class l<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    final com.bytedance.sdk.openadsdk.d.f f7197a;

    /* renamed from: b  reason: collision with root package name */
    private final s<T> f7198b;
    private final com.bytedance.sdk.openadsdk.d.k<T> c;
    private final com.bytedance.sdk.openadsdk.d.c.a<T> d;
    private final w e;
    private final l<T>.a f = new a();
    private v<T> g;

    public l(s<T> sVar, com.bytedance.sdk.openadsdk.d.k<T> kVar, com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar, w wVar) {
        this.f7198b = sVar;
        this.c = kVar;
        this.f7197a = fVar;
        this.d = aVar;
        this.e = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        if (this.c == null) {
            return b().b(aVar);
        }
        com.bytedance.sdk.openadsdk.d.l a2 = com.bytedance.sdk.openadsdk.d.b.l.a(aVar);
        if (a2.j()) {
            return null;
        }
        return this.c.a(a2, this.d.b(), this.f);
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
        if (this.f7198b == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.bytedance.sdk.openadsdk.d.b.l.a(this.f7198b.a(t, this.d.b(), this.f), cVar);
        }
    }

    private v<T> b() {
        v<T> vVar = this.g;
        if (vVar != null) {
            return vVar;
        }
        v<T> a2 = this.f7197a.a(this.e, this.d);
        this.g = a2;
        return a2;
    }

    public static w a(com.bytedance.sdk.openadsdk.d.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements w {

        /* renamed from: a  reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.d.c.a<?> f7200a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f7201b;
        private final Class<?> c;
        private final s<?> d;
        private final com.bytedance.sdk.openadsdk.d.k<?> e;

        b(Object obj, com.bytedance.sdk.openadsdk.d.c.a<?> aVar, boolean z, Class<?> cls) {
            this.d = obj instanceof s ? (s) obj : null;
            this.e = obj instanceof com.bytedance.sdk.openadsdk.d.k ? (com.bytedance.sdk.openadsdk.d.k) obj : null;
            com.bytedance.sdk.openadsdk.d.b.a.a((this.d == null && this.e == null) ? false : true);
            this.f7200a = aVar;
            this.f7201b = z;
            this.c = cls;
        }

        @Override // com.bytedance.sdk.openadsdk.d.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
            boolean isAssignableFrom;
            if (this.f7200a != null) {
                isAssignableFrom = this.f7200a.equals(aVar) || (this.f7201b && this.f7200a.b() == aVar.a());
            } else {
                isAssignableFrom = this.c.isAssignableFrom(aVar.a());
            }
            if (isAssignableFrom) {
                return new l(this.d, this.e, fVar, aVar, this);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    private final class a implements com.bytedance.sdk.openadsdk.d.j, r {
        private a() {
        }
    }
}
