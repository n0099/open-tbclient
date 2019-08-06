package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jXn = false;

    public static void He(String str) {
        if (jXn) {
            e.cDO().He(str);
        }
    }

    public static void Hf(String str) {
        if (jXn) {
            e.cDO().Hf(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jXn && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Hg(String str) {
        return jXn ? d.a.jXv.Hh(str) : SampleResult.OTHERE;
    }

    public static void ss(boolean z) {
        jXn = z;
    }
}
