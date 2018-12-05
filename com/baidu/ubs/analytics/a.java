package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean icm = false;

    public static void yr(String str) {
        if (icm) {
            e.bRR().yr(str);
        }
    }

    public static void ys(String str) {
        if (icm) {
            e.bRR().ys(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (icm && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult yt(String str) {
        return icm ? d.a.icu.yu(str) : SampleResult.OTHERE;
    }

    public static void oN(boolean z) {
        icm = z;
    }
}
