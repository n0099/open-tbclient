package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static boolean hBv = false;

    public static void vT(String str) {
        if (hBv) {
            e.bKy().vT(str);
        }
    }

    public static void vU(String str) {
        if (hBv) {
            e.bKy().vU(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hBv && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult vV(String str) {
        return hBv ? d.a.hBD.vW(str) : SampleResult.OTHERE;
    }

    public static void nR(boolean z) {
        hBv = z;
    }
}
