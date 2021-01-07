package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.q;
import com.bytedance.sdk.openadsdk.d.t;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes4.dex */
public final class g implements w {

    /* renamed from: a  reason: collision with root package name */
    final boolean f7180a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.c f7181b;

    public g(com.bytedance.sdk.openadsdk.d.b.c cVar, boolean z) {
        this.f7181b = cVar;
        this.f7180a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.d.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        Type b2 = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b3 = com.bytedance.sdk.openadsdk.d.b.b.b(b2, com.bytedance.sdk.openadsdk.d.b.b.e(b2));
        return new a(fVar, b3[0], a(fVar, b3[0]), b3[1], fVar.a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(b3[1])), this.f7181b.a(aVar));
    }

    private v<?> a(com.bytedance.sdk.openadsdk.d.f fVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.f : fVar.a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(type));
    }

    /* loaded from: classes4.dex */
    private final class a<K, V> extends v<Map<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private final v<K> f7183b;
        private final v<V> c;
        private final com.bytedance.sdk.openadsdk.d.b.i<? extends Map<K, V>> d;

        @Override // com.bytedance.sdk.openadsdk.d.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException {
            a(cVar, (Map) ((Map) obj));
        }

        public a(com.bytedance.sdk.openadsdk.d.f fVar, Type type, v<K> vVar, Type type2, v<V> vVar2, com.bytedance.sdk.openadsdk.d.b.i<? extends Map<K, V>> iVar) {
            this.f7183b = new m(fVar, vVar, type);
            this.c = new m(fVar, vVar2, type2);
            this.d = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.d.v
        /* renamed from: a */
        public Map<K, V> b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            com.bytedance.sdk.openadsdk.d.d.b f = aVar.f();
            if (f == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> a2 = this.d.a();
            if (f == com.bytedance.sdk.openadsdk.d.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K b2 = this.f7183b.b(aVar);
                    if (a2.put(b2, this.c.b(aVar)) != null) {
                        throw new t("duplicate key: " + b2);
                    }
                    aVar.b();
                }
                aVar.b();
                return a2;
            }
            aVar.c();
            while (aVar.e()) {
                com.bytedance.sdk.openadsdk.d.b.f.f7258a.a(aVar);
                K b3 = this.f7183b.b(aVar);
                if (a2.put(b3, this.c.b(aVar)) != null) {
                    throw new t("duplicate key: " + b3);
                }
            }
            aVar.d();
            return a2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.bytedance.sdk.openadsdk.d.v<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.bytedance.sdk.openadsdk.d.v<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                cVar.f();
            } else if (!g.this.f7180a) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.c.a(cVar, entry.getValue());
                }
                cVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    com.bytedance.sdk.openadsdk.d.l a2 = this.f7183b.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z = (a2.g() || a2.h()) | z;
                }
                if (z) {
                    cVar.b();
                    int size = arrayList.size();
                    while (i < size) {
                        cVar.b();
                        com.bytedance.sdk.openadsdk.d.b.l.a((com.bytedance.sdk.openadsdk.d.l) arrayList.get(i), cVar);
                        this.c.a(cVar, arrayList2.get(i));
                        cVar.c();
                        i++;
                    }
                    cVar.c();
                    return;
                }
                cVar.d();
                int size2 = arrayList.size();
                while (i < size2) {
                    cVar.a(a((com.bytedance.sdk.openadsdk.d.l) arrayList.get(i)));
                    this.c.a(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.e();
            }
        }

        private String a(com.bytedance.sdk.openadsdk.d.l lVar) {
            if (lVar.i()) {
                q m = lVar.m();
                if (m.o()) {
                    return String.valueOf(m.a());
                }
                if (m.n()) {
                    return Boolean.toString(m.f());
                }
                if (m.p()) {
                    return m.b();
                }
                throw new AssertionError();
            } else if (lVar.j()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
