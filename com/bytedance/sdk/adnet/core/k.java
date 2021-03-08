package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f4046a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<a> d;
    public final boolean e;
    public final long f;

    @Deprecated
    public k(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
    }

    public k(int i, byte[] bArr, boolean z, long j, List<a> list) {
        this(i, bArr, a(list), list, z, j);
    }

    @Deprecated
    public k(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private k(int i, byte[] bArr, Map<String, String> map, List<a> list, boolean z, long j) {
        this.f4046a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
        this.f = j;
    }

    private static Map<String, String> a(List<a> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (a aVar : list) {
            treeMap.put(aVar.getName(), aVar.getValue());
        }
        return treeMap;
    }

    private static List<a> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new a(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
