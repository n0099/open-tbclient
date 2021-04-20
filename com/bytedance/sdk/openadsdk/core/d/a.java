package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f27785a;

    /* renamed from: b  reason: collision with root package name */
    public int f27786b;

    /* renamed from: c  reason: collision with root package name */
    public String f27787c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f27788d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f27789e;

    /* renamed from: f  reason: collision with root package name */
    public long f27790f;

    public String a() {
        return this.f27785a;
    }

    public int b() {
        return this.f27786b;
    }

    public List<l> c() {
        return this.f27788d;
    }

    public String d() {
        return this.f27789e;
    }

    public void a(String str) {
        this.f27785a = str;
    }

    public void b(String str) {
        this.f27787c = str;
    }

    public void c(String str) {
        this.f27789e = str;
    }

    public void a(int i) {
        this.f27786b = i;
    }

    public void a(l lVar) {
        this.f27788d.add(lVar);
    }

    public void a(long j) {
        this.f27790f = j;
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
