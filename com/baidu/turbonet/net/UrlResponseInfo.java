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
    public final List<String> f22862a;

    /* renamed from: b  reason: collision with root package name */
    public final int f22863b;

    /* renamed from: c  reason: collision with root package name */
    public final String f22864c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f22865d;

    /* renamed from: e  reason: collision with root package name */
    public final String f22866e;

    /* renamed from: f  reason: collision with root package name */
    public final String f22867f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f22868g = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    public final HeaderBlock f22869h;

    /* loaded from: classes5.dex */
    public static final class HeaderBlock {

        /* renamed from: a  reason: collision with root package name */
        public final List<Map.Entry<String, String>> f22870a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, List<String>> f22871b;

        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.f22870a = list;
        }

        public List<Map.Entry<String, String>> a() {
            return this.f22870a;
        }

        public Map<String, List<String>> b() {
            Map<String, List<String>> map = this.f22871b;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.f22870a) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> unmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.f22871b = unmodifiableMap;
            return unmodifiableMap;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.f22862a = Collections.unmodifiableList(list);
        this.f22863b = i;
        this.f22864c = str;
        this.f22869h = new HeaderBlock(Collections.unmodifiableList(list2));
        this.f22865d = z;
        this.f22866e = str2;
        this.f22867f = str3;
    }

    public Map<String, List<String>> a() {
        return this.f22869h.b();
    }

    public List<Map.Entry<String, String>> b() {
        return this.f22869h.a();
    }

    public int c() {
        return this.f22863b;
    }

    public String d() {
        return this.f22864c;
    }

    public String e() {
        return this.f22866e;
    }

    public String f() {
        return this.f22867f;
    }

    public long g() {
        return this.f22868g.get();
    }

    public String h() {
        List<String> list = this.f22862a;
        return list.get(list.size() - 1);
    }

    public List<String> i() {
        return this.f22862a;
    }

    public void j(long j) {
        this.f22868g.set(j);
    }

    public boolean k() {
        return this.f22865d;
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), h(), i().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(k()), e(), f(), Long.valueOf(g()));
    }
}
