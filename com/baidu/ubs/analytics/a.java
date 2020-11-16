package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes17.dex */
public class a {
    private static boolean osy = false;

    public static void WD(String str) {
        if (osy) {
            e.edG().WD(str);
        }
    }

    public static void WE(String str) {
        if (osy) {
            e.edG().WE(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (osy && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult WF(String str) {
        return osy ? d.a.osG.WG(str) : SampleResult.OTHERE;
    }

    public static void zG(boolean z) {
        osy = z;
    }
}
