package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jPf = false;

    public static void Gh(String str) {
        if (jPf) {
            e.cAv().Gh(str);
        }
    }

    public static void Gi(String str) {
        if (jPf) {
            e.cAv().Gi(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jPf && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Gj(String str) {
        return jPf ? d.a.jPn.Gk(str) : SampleResult.OTHERE;
    }

    public static void sb(boolean z) {
        jPf = z;
    }
}
