package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jWh = false;

    public static void Hd(String str) {
        if (jWh) {
            e.cDt().Hd(str);
        }
    }

    public static void He(String str) {
        if (jWh) {
            e.cDt().He(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jWh && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Hf(String str) {
        return jWh ? d.a.jWp.Hg(str) : SampleResult.OTHERE;
    }

    public static void sr(boolean z) {
        jWh = z;
    }
}
