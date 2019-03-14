package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jwx = false;

    public static void EN(String str) {
        if (jwx) {
            e.csy().EN(str);
        }
    }

    public static void EO(String str) {
        if (jwx) {
            e.csy().EO(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jwx && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult EP(String str) {
        return jwx ? d.a.jwF.EQ(str) : SampleResult.OTHERE;
    }

    public static void rm(boolean z) {
        jwx = z;
    }
}
