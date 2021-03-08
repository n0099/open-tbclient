package com.bytedance.sdk.adnet.d;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, List<String>> f4056a;
    private String b;

    public g(String str) {
        this.f4056a = new LinkedHashMap();
        this.b = str;
    }

    public g() {
        this.f4056a = new LinkedHashMap();
        this.b = null;
    }

    public void a(String str, int i) {
        List<String> list = this.f4056a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(i));
        this.f4056a.put(str, list);
    }

    public void d(String str, double d) {
        List<String> list = this.f4056a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(d));
        this.f4056a.put(str, list);
    }

    public void a(String str, String str2) {
        List<String> list = this.f4056a.get(str);
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(String.valueOf(str2));
        this.f4056a.put(str, list);
    }

    public String a() {
        if (this.f4056a.isEmpty()) {
            return this.b;
        }
        String a2 = a(this.f4056a, "UTF-8");
        if (this.b == null || this.b.length() == 0) {
            return a2;
        }
        return this.b.indexOf(63) >= 0 ? this.b + ETAG.ITEM_SEPARATOR + a2 : this.b + "?" + a2;
    }

    public String a(Map<String, List<String>> map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String b = b(entry.getKey(), str);
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String b2 = next != null ? b(next, str) : "";
                    if (sb.length() > 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(b);
                    if (!b2.isEmpty()) {
                        sb.append("=");
                        sb.append(b2);
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
