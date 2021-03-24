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
    public final List<String> f22861a;

    /* renamed from: b  reason: collision with root package name */
    public final int f22862b;

    /* renamed from: c  reason: collision with root package name */
    public final String f22863c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f22864d;

    /* renamed from: e  reason: collision with root package name */
    public final String f22865e;

    /* renamed from: f  reason: collision with root package name */
    public final String f22866f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f22867g = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    public final HeaderBlock f22868h;

    /* loaded from: classes5.dex */
    public static final class HeaderBlock {

        /* renamed from: a  reason: collision with root package name */
        public final List<Map.Entry<String, String>> f22869a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, List<String>> f22870b;

        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.f22869a = list;
        }

        public List<Map.Entry<String, String>> a() {
            return this.f22869a;
        }

        public Map<String, List<String>> b() {
            Map<String, List<String>> map = this.f22870b;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.f22869a) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.f22870b = unmodifiableMap;
            return unmodifiableMap;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.f22861a = Collections.unmodifiableList(list);
        this.f22862b = i;
        this.f22863c = str;
        this.f22868h = new HeaderBlock(Collections.unmodifiableList(list2));
        this.f22864d = z;
        this.f22865e = str2;
        this.f22866f = str3;
    }

    public Map<String, List<String>> a() {
        return this.f22868h.b();
    }

    public List<Map.Entry<String, String>> b() {
        return this.f22868h.a();
    }

    public int c() {
        return this.f22862b;
    }

    public String d() {
        return this.f22863c;
    }

    public String e() {
        return this.f22865e;
    }

    public String f() {
        return this.f22866f;
    }

    public long g() {
        return this.f22867g.get();
    }

    public String h() {
        List<String> list = this.f22861a;
        return list.get(list.size() - 1);
    }

    public List<String> i() {
        return this.f22861a;
    }

    public void j(long j) {
        this.f22867g.set(j);
    }

    public boolean k() {
        return this.f22864d;
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), h(), i().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(k()), e(), f(), Long.valueOf(g()));
    }
}
