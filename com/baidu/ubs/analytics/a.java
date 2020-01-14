package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean kUV = false;

    public static void KV(String str) {
        if (kUV) {
            e.cWi().KV(str);
        }
    }

    public static void KW(String str) {
        if (kUV) {
            e.cWi().KW(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (kUV && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult KX(String str) {
        return kUV ? d.a.kVd.KY(str) : SampleResult.OTHERE;
    }

    public static void tT(boolean z) {
        kUV = z;
    }
}
