package com.bytedance.sdk.adnet.d;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, List<String>> f6357a;

    /* renamed from: b  reason: collision with root package name */
    private String f6358b;

    public i(String str) {
        this.f6357a = new LinkedHashMap();
        this.f6358b = str;
    }

    public i() {
        this.f6357a = new LinkedHashMap();
        this.f6358b = null;
    }

    public void a(String str, int i) {
        List<String> list = this.f6357a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(i));
        this.f6357a.put(str, list);
    }

    public void d(String str, double d) {
        List<String> list = this.f6357a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(d));
        this.f6357a.put(str, list);
    }

    public void a(String str, String str2) {
        List<String> list = this.f6357a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(str2));
        this.f6357a.put(str, list);
    }

    public String a() {
        if (this.f6357a.isEmpty()) {
            return this.f6358b;
        }
        String a2 = a(this.f6357a, "UTF-8");
        if (this.f6358b == null || this.f6358b.length() == 0) {
            return a2;
        }
        return this.f6358b.indexOf(63) >= 0 ? this.f6358b + ETAG.ITEM_SEPARATOR + a2 : this.f6358b + "?" + a2;
    }

    public String a(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String b2 = b(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String b3 = next != null ? b(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(b2);
                    if (!b3.isEmpty()) {
                        sb.append("=");
                        sb.append(b3);
                    }
                }
            }
        }
        return sb.toString();
    }

    private String b(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String toString() {
        return a();
    }
}
