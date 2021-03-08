package com.bytedance.sdk.a.b.a.b;

import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<com.bytedance.sdk.a.b.d> f3952a = new LinkedHashSet();

    public synchronized void a(com.bytedance.sdk.a.b.d dVar) {
        this.f3952a.add(dVar);
    }

    public synchronized void b(com.bytedance.sdk.a.b.d dVar) {
        this.f3952a.remove(dVar);
    }

    public synchronized boolean c(com.bytedance.sdk.a.b.d dVar) {
        return this.f3952a.contains(dVar);
    }
}
