package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28636a;

    /* renamed from: b  reason: collision with root package name */
    public int f28637b;

    /* renamed from: c  reason: collision with root package name */
    public String f28638c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f28639d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f28640e;

    /* renamed from: f  reason: collision with root package name */
    public long f28641f;

    public String a() {
        return this.f28636a;
    }

    public int b() {
        return this.f28637b;
    }

    public List<l> c() {
        return this.f28639d;
    }

    public String d() {
        return this.f28640e;
    }

    public void a(String str) {
        this.f28636a = str;
    }

    public void b(String str) {
        this.f28638c = str;
    }

    public void c(String str) {
        this.f28640e = str;
    }

    public void a(int i2) {
        this.f28637b = i2;
    }

    public void a(l lVar) {
        this.f28639d.add(lVar);
    }

    public void a(long j) {
        this.f28641f = j;
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
