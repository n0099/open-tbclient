package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jwF = false;

    public static void EP(String str) {
        if (jwF) {
            e.csv().EP(str);
        }
    }

    public static void EQ(String str) {
        if (jwF) {
            e.csv().EQ(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jwF && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult ER(String str) {
        return jwF ? d.a.jwN.ES(str) : SampleResult.OTHERE;
    }

    public static void rm(boolean z) {
        jwF = z;
    }
}
