package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27913a;

    /* renamed from: b  reason: collision with root package name */
    public int f27914b;

    /* renamed from: c  reason: collision with root package name */
    public String f27915c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f27916d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f27917e;

    /* renamed from: f  reason: collision with root package name */
    public long f27918f;

    public String a() {
        return this.f27913a;
    }

    public int b() {
        return this.f27914b;
    }

    public List<l> c() {
        return this.f27916d;
    }

    public String d() {
        return this.f27917e;
    }

    public void a(String str) {
        this.f27913a = str;
    }

    public void b(String str) {
        this.f27915c = str;
    }

    public void c(String str) {
        this.f27917e = str;
    }

    public void a(int i2) {
        this.f27914b = i2;
    }

    public void a(l lVar) {
        this.f27916d.add(lVar);
    }

    public void a(long j) {
        this.f27918f = j;
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
