package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static boolean oqU = false;

    public static void WS(String str) {
        if (oqU) {
            e.edH().WS(str);
        }
    }

    public static void WT(String str) {
        if (oqU) {
            e.edH().WT(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oqU && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult WU(String str) {
        return oqU ? d.a.orc.WV(str) : SampleResult.OTHERE;
    }

    public static void zz(boolean z) {
        oqU = z;
    }
}
