package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27810a;

    /* renamed from: b  reason: collision with root package name */
    public int f27811b;

    /* renamed from: c  reason: collision with root package name */
    public String f27812c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f27813d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f27814e;

    /* renamed from: f  reason: collision with root package name */
    public long f27815f;

    public String a() {
        return this.f27810a;
    }

    public int b() {
        return this.f27811b;
    }

    public List<l> c() {
        return this.f27813d;
    }

    public String d() {
        return this.f27814e;
    }

    public void a(String str) {
        this.f27810a = str;
    }

    public void b(String str) {
        this.f27812c = str;
    }

    public void c(String str) {
        this.f27814e = str;
    }

    public void a(int i2) {
        this.f27811b = i2;
    }

    public void a(l lVar) {
        this.f27813d.add(lVar);
    }

    public void a(long j) {
        this.f27815f = j;
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
