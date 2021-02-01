package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f6485a;

    /* renamed from: b  reason: collision with root package name */
    private int f6486b;
    private String c;
    private List<l> d = new ArrayList();
    private String e;
    private long f;

    public String a() {
        return this.f6485a;
    }

    public void a(String str) {
        this.f6485a = str;
    }

    public int b() {
        return this.f6486b;
    }

    public void a(int i) {
        this.f6486b = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public List<l> c() {
        return this.d;
    }

    public void a(l lVar) {
        this.d.add(lVar);
    }

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public void a(long j) {
        this.f = j;
    }

    public static Map<String, l> a(a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (l lVar : aVar.c()) {
            if (!TextUtils.isEmpty(lVar.L())) {
                hashMap.put(lVar.L(), lVar);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }
}
