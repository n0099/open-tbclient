package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jWS = false;

    public static void FV(String str) {
        if (jWS) {
            e.cBl().FV(str);
        }
    }

    public static void FW(String str) {
        if (jWS) {
            e.cBl().FW(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jWS && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult FX(String str) {
        return jWS ? d.a.jXa.FY(str) : SampleResult.OTHERE;
    }

    public static void sa(boolean z) {
        jWS = z;
    }
}
