package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    private static boolean kXs = false;

    public static void Li(String str) {
        if (kXs) {
            e.cXX().Li(str);
        }
    }

    public static void Lj(String str) {
        if (kXs) {
            e.cXX().Lj(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (kXs && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Lk(String str) {
        return kXs ? d.a.kXA.Ll(str) : SampleResult.OTHERE;
    }

    public static void ue(boolean z) {
        kXs = z;
    }
}
