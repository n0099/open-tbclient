package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean hVc = false;

    public static void xO(String str) {
        if (hVc) {
            e.bPL().xO(str);
        }
    }

    public static void xP(String str) {
        if (hVc) {
            e.bPL().xP(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hVc && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult xQ(String str) {
        return hVc ? d.a.hVk.xR(str) : SampleResult.OTHERE;
    }

    public static void oL(boolean z) {
        hVc = z;
    }
}
