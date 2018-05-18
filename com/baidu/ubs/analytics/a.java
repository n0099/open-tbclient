package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static boolean hlt = false;

    public static void vd(String str) {
        if (hlt) {
            e.bET().vd(str);
        }
    }

    public static void ve(String str) {
        if (hlt) {
            e.bET().ve(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hlt && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult vf(String str) {
        return hlt ? d.a.hlB.vg(str) : SampleResult.OTHERE;
    }

    public static void nC(boolean z) {
        hlt = z;
    }
}
