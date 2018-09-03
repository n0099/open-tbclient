package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static boolean hCc = false;

    public static void vY(String str) {
        if (hCc) {
            e.bJg().vY(str);
        }
    }

    public static void vZ(String str) {
        if (hCc) {
            e.bJg().vZ(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (hCc && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult wa(String str) {
        return hCc ? d.a.hCk.wb(str) : SampleResult.OTHERE;
    }

    public static void nF(boolean z) {
        hCc = z;
    }
}
