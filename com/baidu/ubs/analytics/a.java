package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    private static boolean npT = false;

    public static void Un(String str) {
        if (npT) {
            e.dQw().Un(str);
        }
    }

    public static void Uo(String str) {
        if (npT) {
            e.dQw().Uo(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (npT && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Up(String str) {
        return npT ? d.a.nqb.Uq(str) : SampleResult.OTHERE;
    }

    public static void xR(boolean z) {
        npT = z;
    }
}
