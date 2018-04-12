package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static boolean hks = false;

    public static void va(String str) {
        if (hks) {
            e.bEV().va(str);
        }
    }

    public static void vb(String str) {
        if (hks) {
            e.bEV().vb(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hks && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult vc(String str) {
        return hks ? d.a.hkA.vd(str) : SampleResult.OTHERE;
    }

    public static void nB(boolean z) {
        hks = z;
    }
}
