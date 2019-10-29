package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jXJ = false;

    public static void FV(String str) {
        if (jXJ) {
            e.cBn().FV(str);
        }
    }

    public static void FW(String str) {
        if (jXJ) {
            e.cBn().FW(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jXJ && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult FX(String str) {
        return jXJ ? d.a.jXR.FY(str) : SampleResult.OTHERE;
    }

    public static void sa(boolean z) {
        jXJ = z;
    }
}
