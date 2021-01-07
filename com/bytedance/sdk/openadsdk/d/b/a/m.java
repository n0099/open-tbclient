package com.bytedance.sdk.openadsdk.d.b.a;

import com.bytedance.sdk.openadsdk.d.b.a.i;
import com.bytedance.sdk.openadsdk.d.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class m<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.d.f f7202a;

    /* renamed from: b  reason: collision with root package name */
    private final v<T> f7203b;
    private final Type c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.bytedance.sdk.openadsdk.d.f fVar, v<T> vVar, Type type) {
        this.f7202a = fVar;
        this.f7203b = vVar;
        this.c = type;
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public T b(com.bytedance.sdk.openadsdk.d.d.a aVar) throws IOException {
        return this.f7203b.b(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.d.v
    public void a(com.bytedance.sdk.openadsdk.d.d.c cVar, T t) throws IOException {
        v<T> vVar = this.f7203b;
        Type a2 = a(this.c, t);
        if (a2 != this.c) {
            vVar = this.f7202a.a((com.bytedance.sdk.openadsdk.d.c.a) com.bytedance.sdk.openadsdk.d.c.a.a(a2));
            if ((vVar instanceof i.a) && !(this.f7203b instanceof i.a)) {
                vVar = this.f7203b;
            }
        }
        vVar.a(cVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }
}
