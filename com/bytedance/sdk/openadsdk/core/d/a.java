package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f28100a;

    /* renamed from: b  reason: collision with root package name */
    public int f28101b;

    /* renamed from: c  reason: collision with root package name */
    public String f28102c;

    /* renamed from: d  reason: collision with root package name */
    public List<l> f28103d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f28104e;

    /* renamed from: f  reason: collision with root package name */
    public long f28105f;

    public String a() {
        return this.f28100a;
    }

    public int b() {
        return this.f28101b;
    }

    public List<l> c() {
        return this.f28103d;
    }

    public String d() {
        return this.f28104e;
    }

    public void a(String str) {
        this.f28100a = str;
    }

    public void b(String str) {
        this.f28102c = str;
    }

    public void c(String str) {
        this.f28104e = str;
    }

    public void a(int i) {
        this.f28101b = i;
    }

    public void a(l lVar) {
        this.f28103d.add(lVar);
    }

    public void a(long j) {
        this.f28105f = j;
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
