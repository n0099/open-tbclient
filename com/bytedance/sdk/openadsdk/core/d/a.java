package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27881a;

    /* renamed from: b  reason: collision with root package name */
    public int f27882b;

    /* renamed from: c  reason: collision with root package name */
    public String f27883c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f27884d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f27885e;

    /* renamed from: f  reason: collision with root package name */
    public long f27886f;

    public String a() {
        return this.f27881a;
    }

    public int b() {
        return this.f27882b;
    }

    public List<l> c() {
        return this.f27884d;
    }

    public String d() {
        return this.f27885e;
    }

    public void a(String str) {
        this.f27881a = str;
    }

    public void b(String str) {
        this.f27883c = str;
    }

    public void c(String str) {
        this.f27885e = str;
    }

    public void a(int i2) {
        this.f27882b = i2;
    }

    public void a(l lVar) {
        this.f27884d.add(lVar);
    }

    public void a(long j) {
        this.f27886f = j;
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
