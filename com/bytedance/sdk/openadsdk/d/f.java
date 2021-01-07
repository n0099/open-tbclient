package com.bytedance.sdk.openadsdk.d;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: classes4.dex */
public final class f {
    private static final com.bytedance.sdk.openadsdk.d.c.a<?> r = com.bytedance.sdk.openadsdk.d.c.a.b(Object.class);

    /* renamed from: a  reason: collision with root package name */
    final List<w> f7288a;

    /* renamed from: b  reason: collision with root package name */
    final com.bytedance.sdk.openadsdk.d.b.d f7289b;
    final e c;
    final Map<Type, h<?>> d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;
    final boolean i;
    final boolean j;
    final boolean k;
    final String l;
    final int m;
    final int n;
    final u o;
    final List<w> p;
    final List<w> q;
    private final ThreadLocal<Map<com.bytedance.sdk.openadsdk.d.c.a<?>, a<?>>> s;
    private final Map<com.bytedance.sdk.openadsdk.d.c.a<?>, v<?>> t;
    private final com.bytedance.sdk.openadsdk.d.b.c u;
    private final com.bytedance.sdk.openadsdk.d.b.a.d v;

    public f() {
        this(com.bytedance.sdk.openadsdk.d.b.d.f7253a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, u.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.bytedance.sdk.openadsdk.d.b.d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, u uVar, String str, int i, int i2, List<w> list, List<w> list2, List<w> list3) {
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.f7289b = dVar;
        this.c = eVar;
        this.d = map;
        this.u = new com.bytedance.sdk.openadsdk.d.b.c(map);
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z6;
        this.k = z7;
        this.o = uVar;
        this.l = str;
        this.m = i;
        this.n = i2;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.Y);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.h.f7184a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.D);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.m);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.g);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.i);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.k);
        v<Number> a2 = a(uVar);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(Long.TYPE, Long.class, a2));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.x);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.o);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.q);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(AtomicLong.class, a(a2)));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.s);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.z);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.F);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.H);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(BigDecimal.class, com.bytedance.sdk.openadsdk.d.b.a.n.B));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.a(BigInteger.class, com.bytedance.sdk.openadsdk.d.b.a.n.C));
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.J);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.L);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.P);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.R);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.W);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.N);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.d);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.c.f7174a);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.U);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.k.f7195a);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.j.f7193a);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.S);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.a.f7168a);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.f7205b);
        arrayList.add(new com.bytedance.sdk.openadsdk.d.b.a.b(this.u));
        arrayList.add(new com.bytedance.sdk.openadsdk.d.b.a.g(this.u, z2));
        this.v = new com.bytedance.sdk.openadsdk.d.b.a.d(this.u);
        arrayList.add(this.v);
        arrayList.add(com.bytedance.sdk.openadsdk.d.b.a.n.Z);
        arrayList.add(new com.bytedance.sdk.openadsdk.d.b.a.i(this.u, eVar, dVar, this.v));
        this.f7288a = Collections.unmodifiableList(arrayList);
    }

    private v<Number> a(boolean z) {
        return z ? com.bytedance.sdk.openadsdk.d.b.a.n.v : new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            /* renamed from: a */
            public Double b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.doubleValue());
                cVar.a(number);
            }
        };
    }

    private v<Number> b(boolean z) {
        return z ? com.bytedance.sdk.openadsdk.d.b.a.n.u : new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            /* renamed from: a */
            public Float b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.floatValue());
                cVar.a(number);
            }
        };
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static v<Number> a(u uVar) {
        return uVar == u.DEFAULT ? com.bytedance.sdk.openadsdk.d.b.a.n.t : new v<Number>() { // from class: com.bytedance.sdk.openadsdk.d.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Long.valueOf(aVar.l());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    private static v<AtomicLong> a(final v<Number> vVar) {
        return new v<AtomicLong>() { // from class: com.bytedance.sdk.openadsdk.d.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, AtomicLong atomicLong) throws IOException {
                v.this.a(cVar, Long.valueOf(atomicLong.get()));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            /* renamed from: a */
            public AtomicLong b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
                return new AtomicLong(((Number) v.this.b(aVar)).longValue());
            }
        }.a();
    }

    private static v<AtomicLongArray> b(final v<Number> vVar) {
        return new v<AtomicLongArray>() { // from class: com.bytedance.sdk.openadsdk.d.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    v.this.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.c();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.sdk.openadsdk.d.v
            /* renamed from: a */
            public AtomicLongArray b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) v.this.b(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.a();
    }

    public <T> v<T> a(com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        Map<com.bytedance.sdk.openadsdk.d.c.a<?>, a<?>> map;
        v<T> vVar = (v<T>) this.t.get(aVar == null ? r : aVar);
        if (vVar == null) {
            Map<com.bytedance.sdk.openadsdk.d.c.a<?>, a<?>> map2 = this.s.get();
            boolean z = false;
            if (map2 == null) {
                map = new HashMap<>();
                this.s.set(map);
                z = true;
            } else {
                map = map2;
            }
            vVar = map.get(aVar);
            if (vVar == null) {
                try {
                    a<?> aVar2 = new a<>();
                    map.put(aVar, aVar2);
                    for (w wVar : this.f7288a) {
                        vVar = wVar.a(this, aVar);
                        if (vVar != null) {
                            aVar2.a((v<?>) vVar);
                            this.t.put(aVar, vVar);
                            map.remove(aVar);
                            if (z) {
                                this.s.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle " + aVar);
                } catch (Throwable th) {
                    map.remove(aVar);
                    if (z) {
                        this.s.remove();
                    }
                    throw th;
                }
            }
        }
        return vVar;
    }

    public <T> v<T> a(w wVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        if (!this.f7288a.contains(wVar)) {
            wVar = this.v;
        }
        boolean z = false;
        for (w wVar2 : this.f7288a) {
            if (!z) {
                if (wVar2 == wVar) {
                    z = true;
                }
            } else {
                v<T> a2 = wVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> v<T> a(Class<T> cls) {
        return a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.b(cls));
    }

    public String a(Object obj) {
        return obj == null ? a((l) n.f7298a) : a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(com.bytedance.sdk.openadsdk.d.b.l.a(appendable)));
        } catch (IOException e) {
            throw new m(e);
        }
    }

    public void a(Object obj, Type type, com.bytedance.sdk.openadsdk.d.d.c cVar) throws m {
        v a2 = a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(type));
        boolean g = cVar.g();
        cVar.b(true);
        boolean h = cVar.h();
        cVar.c(this.h);
        boolean i = cVar.i();
        cVar.d(this.e);
        try {
            try {
                try {
                    a2.a(cVar, obj);
                } catch (IOException e) {
                    throw new m(e);
                }
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            cVar.b(g);
            cVar.c(h);
            cVar.d(i);
        }
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(com.bytedance.sdk.openadsdk.d.b.l.a(appendable)));
        } catch (IOException e) {
            throw new m(e);
        }
    }

    public com.bytedance.sdk.openadsdk.d.d.c a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        com.bytedance.sdk.openadsdk.d.d.c cVar = new com.bytedance.sdk.openadsdk.d.d.c(writer);
        if (this.i) {
            cVar.c("  ");
        }
        cVar.d(this.e);
        return cVar;
    }

    public com.bytedance.sdk.openadsdk.d.d.a a(Reader reader) {
        com.bytedance.sdk.openadsdk.d.d.a aVar = new com.bytedance.sdk.openadsdk.d.d.a(reader);
        aVar.a(this.j);
        return aVar;
    }

    public void a(l lVar, com.bytedance.sdk.openadsdk.d.d.c cVar) throws m {
        boolean g = cVar.g();
        cVar.b(true);
        boolean h = cVar.h();
        cVar.c(this.h);
        boolean i = cVar.i();
        cVar.d(this.e);
        try {
            try {
                com.bytedance.sdk.openadsdk.d.b.l.a(lVar, cVar);
            } catch (IOException e) {
                throw new m(e);
            } catch (AssertionError e2) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } finally {
            cVar.b(g);
            cVar.c(h);
            cVar.d(i);
        }
    }

    public <T> T a(String str, Type type) throws t {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) throws m, t {
        com.bytedance.sdk.openadsdk.d.d.a a2 = a(reader);
        T t = (T) a(a2, type);
        a(t, a2);
        return t;
    }

    private static void a(Object obj, com.bytedance.sdk.openadsdk.d.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != com.bytedance.sdk.openadsdk.d.d.b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (com.bytedance.sdk.openadsdk.d.d.d e) {
                throw new t(e);
            } catch (IOException e2) {
                throw new m(e2);
            }
        }
    }

    public <T> T a(com.bytedance.sdk.openadsdk.d.d.a aVar, Type type) throws m, t {
        boolean z = true;
        boolean q = aVar.q();
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    T b2 = a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(type)).b(aVar);
                    aVar.a(q);
                    return b2;
                } catch (IOException e) {
                    throw new t(e);
                } catch (IllegalStateException e2) {
                    throw new t(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new t(e3);
                }
                aVar.a(q);
                return null;
            } catch (AssertionError e4) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e4.getMessage());
                assertionError.initCause(e4);
                throw assertionError;
            }
        } catch (Throwable th) {
            aVar.a(q);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a<T> extends v<T> {

        /* renamed from: a  reason: collision with root package name */
        private v<T> f7294a;

        a() {
        }

        public void a(v<T> vVar) {
            if (this.f7294a != null) {
                throw new AssertionError();
            }
            this.f7294a = vVar;
        }

        @Override // com.bytedance.sdk.openadsdk.d.v
        public T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (this.f7294a == null) {
                throw new IllegalStateException();
            }
            return this.f7294a.b(aVar);
        }

        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
            if (this.f7294a == null) {
                throw new IllegalStateException();
            }
            this.f7294a.a(cVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.e + ",factories:" + this.f7288a + ",instanceCreators:" + this.u + "}";
    }
}
