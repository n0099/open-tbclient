package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27793a;

    /* renamed from: b  reason: collision with root package name */
    public int f27794b;

    /* renamed from: c  reason: collision with root package name */
    public String f27795c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f27796d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f27797e;

    /* renamed from: f  reason: collision with root package name */
    public long f27798f;

    public String a() {
        return this.f27793a;
    }

    public int b() {
        return this.f27794b;
    }

    public List<l> c() {
        return this.f27796d;
    }

    public String d() {
        return this.f27797e;
    }

    public void a(String str) {
        this.f27793a = str;
    }

    public void b(String str) {
        this.f27795c = str;
    }

    public void c(String str) {
        this.f27797e = str;
    }

    public void a(int i) {
        this.f27794b = i;
    }

    public void a(l lVar) {
        this.f27796d.add(lVar);
    }

    public void a(long j) {
        this.f27798f = j;
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
