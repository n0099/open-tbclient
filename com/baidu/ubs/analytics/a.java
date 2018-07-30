package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static boolean hCa = false;

    public static void vU(String str) {
        if (hCa) {
            e.bJc().vU(str);
        }
    }

    public static void vV(String str) {
        if (hCa) {
            e.bJc().vV(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hCa && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult vW(String str) {
        return hCa ? d.a.hCi.vX(str) : SampleResult.OTHERE;
    }

    public static void nF(boolean z) {
        hCa = z;
    }
}
