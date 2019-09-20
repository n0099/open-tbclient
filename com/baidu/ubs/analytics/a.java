package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jZK = false;

    public static void HE(String str) {
        if (jZK) {
            e.cEC().HE(str);
        }
    }

    public static void HF(String str) {
        if (jZK) {
            e.cEC().HF(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jZK && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult HG(String str) {
        return jZK ? d.a.jZS.HH(str) : SampleResult.OTHERE;
    }

    public static void sv(boolean z) {
        jZK = z;
    }
}
