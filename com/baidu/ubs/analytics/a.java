package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean oNS = false;

    public static void XE(String str) {
        if (oNS) {
            e.ejF().XE(str);
        }
    }

    public static void XF(String str) {
        if (oNS) {
            e.ejF().XF(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oNS && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult XG(String str) {
        return oNS ? d.a.oOa.XH(str) : SampleResult.OTHERE;
    }

    public static void Al(boolean z) {
        oNS = z;
    }
}
