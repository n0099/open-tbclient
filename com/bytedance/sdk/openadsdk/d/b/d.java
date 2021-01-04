package com.bytedance.sdk.openadsdk.d.b;

import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class d implements w, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final d f7252a = new d();
    private boolean e;

    /* renamed from: b  reason: collision with root package name */
    private double f7253b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private List<com.bytedance.sdk.openadsdk.d.b> f = Collections.emptyList();
    private List<com.bytedance.sdk.openadsdk.d.b> g = Collections.emptyList();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.w
    public <T> v<T> a(final com.bytedance.sdk.openadsdk.d.f fVar, final com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        final boolean z = false;
        Class<? super T> a2 = aVar.a();
        boolean a3 = a(a2);
        final boolean z2 = a3 || b(a2, true);
        if (a3 || b(a2, false)) {
            z = true;
        }
        if (!z2 && !z) {
            return null;
        }
        return new v<T>() { // from class: com.bytedance.sdk.openadsdk.d.b.d.1
            private v<T> f;

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.bytedance.sdk.openadsdk.d.v
            public T b(com.bytedance.sdk.openadsdk.d.d.a aVar2) throws IOException {
                if (z) {
                    aVar2.n();
                    return null;
                }
                return b().b(aVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
                if (z2) {
                    cVar.f();
                } else {
                    b().a(cVar, t);
                }
            }

            private v<T> b() {
                v<T> vVar = this.f;
                if (vVar != 0) {
                    return vVar;
                }
                v<T> a4 = fVar.a(d.this, aVar);
                this.f = a4;
                return a4;
            }
        };
    }

    public boolean a(Field field, boolean z) {
        com.bytedance.sdk.openadsdk.d.a.a aVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f7253b == -1.0d || a((com.bytedance.sdk.openadsdk.d.a.d) field.getAnnotation(com.bytedance.sdk.openadsdk.d.a.d.class), (com.bytedance.sdk.openadsdk.d.a.e) field.getAnnotation(com.bytedance.sdk.openadsdk.d.a.e.class))) && !field.isSynthetic()) {
            if (!this.e || ((aVar = (com.bytedance.sdk.openadsdk.d.a.a) field.getAnnotation(com.bytedance.sdk.openadsdk.d.a.a.class)) != null && (!z ? !aVar.b() : !aVar.a()))) {
                if ((this.d || !c(field.getType())) && !b(field.getType())) {
                    List<com.bytedance.sdk.openadsdk.d.b> list = z ? this.f : this.g;
                    if (!list.isEmpty()) {
                        com.bytedance.sdk.openadsdk.d.c cVar = new com.bytedance.sdk.openadsdk.d.c(field);
                        for (com.bytedance.sdk.openadsdk.d.b bVar : list) {
                            if (bVar.a(cVar)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean a(Class<?> cls) {
        if (this.f7253b == -1.0d || a((com.bytedance.sdk.openadsdk.d.a.d) cls.getAnnotation(com.bytedance.sdk.openadsdk.d.a.d.class), (com.bytedance.sdk.openadsdk.d.a.e) cls.getAnnotation(com.bytedance.sdk.openadsdk.d.a.e.class))) {
            return (!this.d && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean b(Class<?> cls, boolean z) {
        for (com.bytedance.sdk.openadsdk.d.b bVar : z ? this.f : this.g) {
            if (bVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.bytedance.sdk.openadsdk.d.a.d dVar, com.bytedance.sdk.openadsdk.d.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.bytedance.sdk.openadsdk.d.a.d dVar) {
        return dVar == null || dVar.a() <= this.f7253b;
    }

    private boolean a(com.bytedance.sdk.openadsdk.d.a.e eVar) {
        return eVar == null || eVar.a() > this.f7253b;
    }
}
