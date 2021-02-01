package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.t;
import com.bytedance.sdk.openadsdk.d.v;
import com.bytedance.sdk.openadsdk.d.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class i implements w {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.b.c f6889a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.e f6890b;
    private final com.bytedance.sdk.openadsdk.d.b.d c;
    private final d d;
    private final com.bytedance.sdk.openadsdk.d.b.b.b e = com.bytedance.sdk.openadsdk.d.b.b.b.a();

    public i(com.bytedance.sdk.openadsdk.d.b.c cVar, com.bytedance.sdk.openadsdk.d.e eVar, com.bytedance.sdk.openadsdk.d.b.d dVar, d dVar2) {
        this.f6889a = cVar;
        this.f6890b = eVar;
        this.c = dVar;
        this.d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.c);
    }

    static boolean a(Field field, boolean z, com.bytedance.sdk.openadsdk.d.b.d dVar) {
        return (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.bytedance.sdk.openadsdk.d.a.c cVar = (com.bytedance.sdk.openadsdk.d.a.c) field.getAnnotation(com.bytedance.sdk.openadsdk.d.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f6890b.a(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String str : b2) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.d.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (!Object.class.isAssignableFrom(a2)) {
            return null;
        }
        return new a(this.f6889a.a(aVar), a(fVar, (com.bytedance.sdk.openadsdk.d.c.a<?>) aVar, (Class<?>) a2));
    }

    private b a(final com.bytedance.sdk.openadsdk.d.f fVar, final Field field, String str, final com.bytedance.sdk.openadsdk.d.c.a<?> aVar, boolean z, boolean z2) {
        final boolean a2 = com.bytedance.sdk.openadsdk.d.b.k.a(aVar.a());
        com.bytedance.sdk.openadsdk.d.a.b bVar = (com.bytedance.sdk.openadsdk.d.a.b) field.getAnnotation(com.bytedance.sdk.openadsdk.d.a.b.class);
        final v<?> vVar = null;
        if (bVar != null) {
            vVar = this.d.a(this.f6889a, fVar, aVar, bVar);
        }
        final boolean z3 = vVar != null;
        if (vVar == null) {
            vVar = fVar.a((com.bytedance.sdk.openadsdk.d.c.a) aVar);
        }
        return new b(str, z, z2) { // from class: com.bytedance.sdk.openadsdk.d.b.a.i.1
            @Override // com.bytedance.sdk.openadsdk.d.b.a.i.b
            void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                (z3 ? vVar : new m(fVar, vVar, aVar.b())).a(cVar, field.get(obj));
            }

            @Override // com.bytedance.sdk.openadsdk.d.b.a.i.b
            void a(com.bytedance.sdk.openadsdk.d.d.a aVar2, Object obj) throws IOException, IllegalAccessException {
                Object b2 = vVar.b(aVar2);
                if (b2 != null || !a2) {
                    field.set(obj, b2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.d.b.a.i.b
            public boolean a(Object obj) throws IOException, IllegalAccessException {
                return this.i && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(com.bytedance.sdk.openadsdk.d.f fVar, com.bytedance.sdk.openadsdk.d.c.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b2 = aVar.b();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    this.e.a(field);
                    Type a4 = com.bytedance.sdk.openadsdk.d.b.b.a(aVar.b(), cls, field.getGenericType());
                    List<String> a5 = a(field);
                    b bVar = null;
                    int size = a5.size();
                    int i = 0;
                    while (i < size) {
                        String str = a5.get(i);
                        if (i != 0) {
                            a2 = false;
                        }
                        b bVar2 = (b) linkedHashMap.put(str, a(fVar, field, str, com.bytedance.sdk.openadsdk.d.c.a.a(a4), a2, a3));
                        if (bVar != null) {
                            bVar2 = bVar;
                        }
                        i++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar.h);
                    }
                }
            }
            aVar = com.bytedance.sdk.openadsdk.d.c.a.a(com.bytedance.sdk.openadsdk.d.b.b.a(aVar.b(), cls, cls.getGenericSuperclass()));
            cls = aVar.a();
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static abstract class b {
        final String h;
        final boolean i;
        final boolean j;

        abstract void a(com.bytedance.sdk.openadsdk.d.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.bytedance.sdk.openadsdk.d.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean a(Object obj) throws IOException, IllegalAccessException;

        protected b(String str, boolean z, boolean z2) {
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<T> extends v<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.d.b.i<T> f6893a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, b> f6894b;

        a(com.bytedance.sdk.openadsdk.d.b.i<T> iVar, Map<String, b> map) {
            this.f6893a = iVar;
            this.f6894b = map;
        }

        @Override // com.bytedance.sdk.openadsdk.d.v
        public T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.d.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a2 = this.f6893a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f6894b.get(aVar.g());
                    if (bVar == null || !bVar.j) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, a2);
                    }
                }
                aVar.d();
                return a2;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new t(e2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.d.v
        public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.f6894b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.h);
                        bVar.a(cVar, t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
