package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28099a;

    /* renamed from: b  reason: collision with root package name */
    public int f28100b;

    /* renamed from: c  reason: collision with root package name */
    public String f28101c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f28102d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f28103e;

    /* renamed from: f  reason: collision with root package name */
    public long f28104f;

    public String a() {
        return this.f28099a;
    }

    public int b() {
        return this.f28100b;
    }

    public List<l> c() {
        return this.f28102d;
    }

    public String d() {
        return this.f28103e;
    }

    public void a(String str) {
        this.f28099a = str;
    }

    public void b(String str) {
        this.f28101c = str;
    }

    public void c(String str) {
        this.f28103e = str;
    }

    public void a(int i) {
        this.f28100b = i;
    }

    public void a(l lVar) {
        this.f28102d.add(lVar);
    }

    public void a(long j) {
        this.f28104f = j;
    }

    public static Map<String, l> a(a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (l lVar : aVar.c()) {
            if (!TextUtils.isEmpty(lVar.ae())) {
                hashMap.put(lVar.ae(), lVar);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }
}
