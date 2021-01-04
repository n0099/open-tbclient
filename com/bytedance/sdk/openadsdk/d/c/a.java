package com.bytedance.sdk.openadsdk.d.c;

import com.bytedance.sdk.openadsdk.d.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f7277a;

    /* renamed from: b  reason: collision with root package name */
    final Type f7278b;
    final int c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.f7278b = a(getClass());
        this.f7277a = (Class<? super T>) b.e(this.f7278b);
        this.c = this.f7278b.hashCode();
    }

    a(Type type) {
        this.f7278b = b.d((Type) com.bytedance.sdk.openadsdk.d.b.a.a(type));
        this.f7277a = (Class<? super T>) b.e(this.f7278b);
        this.c = this.f7278b.hashCode();
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.f7277a;
    }

    public final Type b() {
        return this.f7278b;
    }

    public final int hashCode() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f7278b, ((a) obj).f7278b);
    }

    public final String toString() {
        return b.f(this.f7278b);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }
}
