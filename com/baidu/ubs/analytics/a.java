package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    private static boolean mhp = false;

    public static void Pn(String str) {
        if (mhp) {
            e.dst().Pn(str);
        }
    }

    public static void Po(String str) {
        if (mhp) {
            e.dst().Po(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (mhp && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Pp(String str) {
        return mhp ? d.a.mhx.Pq(str) : SampleResult.OTHERE;
    }

    public static void vN(boolean z) {
        mhp = z;
    }
}
