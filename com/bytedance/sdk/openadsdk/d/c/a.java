package com.bytedance.sdk.openadsdk.d.c;

import com.bytedance.sdk.openadsdk.d.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f6978a;

    /* renamed from: b  reason: collision with root package name */
    final Type f6979b;
    final int c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.f6979b = a(getClass());
        this.f6978a = (Class<? super T>) b.e(this.f6979b);
        this.c = this.f6979b.hashCode();
    }

    a(Type type) {
        this.f6979b = b.d((Type) com.bytedance.sdk.openadsdk.d.b.a.a(type));
        this.f6978a = (Class<? super T>) b.e(this.f6979b);
        this.c = this.f6979b.hashCode();
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.f6978a;
    }

    public final Type b() {
        return this.f6979b;
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f6979b, ((a) obj).f6979b);
    }

    public final String toString() {
        return b.f(this.f6979b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }
}
