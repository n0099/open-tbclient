package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    private static boolean lOa = false;

    public static void NA(String str) {
        if (lOa) {
            e.dld().NA(str);
        }
    }

    public static void NB(String str) {
        if (lOa) {
            e.dld().NB(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (lOa && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult NC(String str) {
        return lOa ? d.a.lOi.ND(str) : SampleResult.OTHERE;
    }

    public static void vp(boolean z) {
        lOa = z;
    }
}
