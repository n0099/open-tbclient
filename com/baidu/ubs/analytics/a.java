package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private static boolean kRp = false;

    public static void KL(String str) {
        if (kRp) {
            e.cVd().KL(str);
        }
    }

    public static void KM(String str) {
        if (kRp) {
            e.cVd().KM(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (kRp && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult KN(String str) {
        return kRp ? d.a.kRx.KO(str) : SampleResult.OTHERE;
    }

    public static void tH(boolean z) {
        kRp = z;
    }
}
