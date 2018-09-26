package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static boolean hKz = false;

    public static void wJ(String str) {
        if (hKz) {
            e.bLX().wJ(str);
        }
    }

    public static void wK(String str) {
        if (hKz) {
            e.bLX().wK(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hKz && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult wL(String str) {
        return hKz ? d.a.hKH.wM(str) : SampleResult.OTHERE;
    }

    public static void oc(boolean z) {
        hKz = z;
    }
}
