package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27995a;

    /* renamed from: b  reason: collision with root package name */
    public int f27996b;

    /* renamed from: c  reason: collision with root package name */
    public String f27997c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f27998d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f27999e;

    /* renamed from: f  reason: collision with root package name */
    public long f28000f;

    public String a() {
        return this.f27995a;
    }

    public int b() {
        return this.f27996b;
    }

    public List<l> c() {
        return this.f27998d;
    }

    public String d() {
        return this.f27999e;
    }

    public void a(String str) {
        this.f27995a = str;
    }

    public void b(String str) {
        this.f27997c = str;
    }

    public void c(String str) {
        this.f27999e = str;
    }

    public void a(int i2) {
        this.f27996b = i2;
    }

    public void a(l lVar) {
        this.f27998d.add(lVar);
    }

    public void a(long j) {
        this.f28000f = j;
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
