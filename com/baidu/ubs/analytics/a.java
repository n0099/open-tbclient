package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean hTr = false;

    public static void xJ(String str) {
        if (hTr) {
            e.bQn().xJ(str);
        }
    }

    public static void xK(String str) {
        if (hTr) {
            e.bQn().xK(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hTr && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult xL(String str) {
        return hTr ? d.a.hTz.xM(str) : SampleResult.OTHERE;
    }

    public static void ox(boolean z) {
        hTr = z;
    }
}
