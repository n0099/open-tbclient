package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static boolean nFn = false;

    public static void Vb(String str) {
        if (nFn) {
            e.dUh().Vb(str);
        }
    }

    public static void Vc(String str) {
        if (nFn) {
            e.dUh().Vc(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (nFn && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Vd(String str) {
        return nFn ? d.a.nFv.Ve(str) : SampleResult.OTHERE;
    }

    public static void yy(boolean z) {
        nFn = z;
    }
}
