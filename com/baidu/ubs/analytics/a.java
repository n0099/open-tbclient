package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    private static boolean nfz = false;

    public static void TL(String str) {
        if (nfz) {
            e.dMp().TL(str);
        }
    }

    public static void TM(String str) {
        if (nfz) {
            e.dMp().TM(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (nfz && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult TN(String str) {
        return nfz ? d.a.nfH.TO(str) : SampleResult.OTHERE;
    }

    public static void xG(boolean z) {
        nfz = z;
    }
}
