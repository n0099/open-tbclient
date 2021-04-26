package com.baidu.turbonet.net;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class UrlResponseInfo {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f23255a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23256b;

    /* renamed from: c  reason: collision with root package name */
    public final String f23257c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f23258d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23259e;

    /* renamed from: f  reason: collision with root package name */
    public final String f23260f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f23261g = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    public final HeaderBlock f23262h;

    /* loaded from: classes5.dex */
    public static final class HeaderBlock {

        /* renamed from: a  reason: collision with root package name */
        public final List<Map.Entry<String, String>> f23263a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, List<String>> f23264b;

        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.f23263a = list;
        }

        public List<Map.Entry<String, String>> a() {
            return this.f23263a;
        }

        public Map<String, List<String>> b() {
            Map<String, List<String>> map = this.f23264b;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.f23263a) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.f23264b = unmodifiableMap;
            return unmodifiableMap;
        }
    }

    public UrlResponseInfo(List<String> list, int i2, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.f23255a = Collections.unmodifiableList(list);
        this.f23256b = i2;
        this.f23257c = str;
        this.f23262h = new HeaderBlock(Collections.unmodifiableList(list2));
        this.f23258d = z;
        this.f23259e = str2;
        this.f23260f = str3;
    }

    public Map<String, List<String>> a() {
        return this.f23262h.b();
    }

    public List<Map.Entry<String, String>> b() {
        return this.f23262h.a();
    }

    public int c() {
        return this.f23256b;
    }

    public String d() {
        return this.f23257c;
    }

    public String e() {
        return this.f23259e;
    }

    public String f() {
        return this.f23260f;
    }

    public long g() {
        return this.f23261g.get();
    }

    public String h() {
        List<String> list = this.f23255a;
        return list.get(list.size() - 1);
    }

    public List<String> i() {
        return this.f23255a;
    }

    public void j(long j) {
        this.f23261g.set(j);
    }

    public boolean k() {
        return this.f23258d;
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), h(), i().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(k()), e(), f(), Long.valueOf(g()));
    }
}
