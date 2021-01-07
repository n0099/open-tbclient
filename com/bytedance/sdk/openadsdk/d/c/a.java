package com.bytedance.sdk.openadsdk.d.c;

import com.bytedance.sdk.openadsdk.d.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f7278a;

    /* renamed from: b  reason: collision with root package name */
    final Type f7279b;
    final int c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.f7279b = a(getClass());
        this.f7278a = (Class<? super T>) b.e(this.f7279b);
        this.c = this.f7279b.hashCode();
    }

    a(Type type) {
        this.f7279b = b.d((Type) com.bytedance.sdk.openadsdk.d.b.a.a(type));
        this.f7278a = (Class<? super T>) b.e(this.f7279b);
        this.c = this.f7279b.hashCode();
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.f7278a;
    }

    public final Type b() {
        return this.f7279b;
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f7279b, ((a) obj).f7279b);
    }

    public final String toString() {
        return b.f(this.f7279b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }
}
