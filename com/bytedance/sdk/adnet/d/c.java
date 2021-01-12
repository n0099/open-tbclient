package com.bytedance.sdk.adnet.d;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidubce.http.Headers;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.r;
import com.bytedance.sdk.adnet.e.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class c {
    public static b.a c(l lVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar.c;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        boolean z2 = false;
        String str = map.get("Date");
        if (str != null) {
            j5 = a(str);
        }
        String str2 = map.get(Headers.CACHE_CONTROL);
        if (str2 == null) {
            z = false;
        } else {
            String[] split = str2.split(",", 0);
            int i = 0;
            z = false;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    try {
                        j7 = Long.parseLong(trim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
                j7 = j7;
            }
            z2 = true;
        }
        String str3 = map.get(Headers.EXPIRES);
        if (str3 == null) {
            j = 0;
        } else {
            j = a(str3);
        }
        String str4 = map.get(Headers.LAST_MODIFIED);
        if (str4 == null) {
            j2 = 0;
        } else {
            j2 = a(str4);
        }
        String str5 = map.get(Headers.ETAG);
        if (z2) {
            j4 = currentTimeMillis + (1000 * j6);
            j3 = z ? j4 : (1000 * j7) + j4;
        } else if (j5 <= 0 || j < j5) {
            j3 = 0;
            j4 = 0;
        } else {
            long j8 = currentTimeMillis + (j - j5);
            j3 = j8;
            j4 = j8;
        }
        b.a aVar = new b.a();
        aVar.f6061a = lVar.f6040a;
        aVar.f6062b = lVar.f6041b;
        aVar.c = str5;
        aVar.g = j4;
        aVar.f = j3;
        aVar.d = j5;
        aVar.e = j2;
        aVar.h = map;
        aVar.i = lVar.d;
        return aVar;
    }

    public static long a(String str) {
        try {
            return eou().parse(str).getTime();
        } catch (Throwable th) {
            r.a(th, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static String a(long j) {
        return eou().format(new Date(j));
    }

    private static SimpleDateFormat eou() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
            return str;
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "UTF-8");
    }

    public static Map<String, String> a(List<com.bytedance.sdk.adnet.core.a> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if (list != null) {
            for (com.bytedance.sdk.adnet.core.a aVar : list) {
                treeMap.put(aVar.getName(), aVar.getValue());
            }
        }
        return treeMap;
    }

    public static List<com.bytedance.sdk.adnet.core.a> I(Map<String, String> map) {
        if (map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new com.bytedance.sdk.adnet.core.a(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
