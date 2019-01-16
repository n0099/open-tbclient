package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean igG = false;

    public static void yK(String str) {
        if (igG) {
            e.bTp().yK(str);
        }
    }

    public static void yL(String str) {
        if (igG) {
            e.bTp().yL(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (igG && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult yM(String str) {
        return igG ? d.a.igO.yN(str) : SampleResult.OTHERE;
    }

    public static void oR(boolean z) {
        igG = z;
    }
}
