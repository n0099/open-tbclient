package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean kUQ = false;

    public static void KV(String str) {
        if (kUQ) {
            e.cWg().KV(str);
        }
    }

    public static void KW(String str) {
        if (kUQ) {
            e.cWg().KW(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (kUQ && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult KX(String str) {
        return kUQ ? d.a.kUY.KY(str) : SampleResult.OTHERE;
    }

    public static void tT(boolean z) {
        kUQ = z;
    }
}
