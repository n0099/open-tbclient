package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes17.dex */
public class a {
    private static boolean oHJ = false;

    public static void XW(String str) {
        if (oHJ) {
            e.ejv().XW(str);
        }
    }

    public static void XX(String str) {
        if (oHJ) {
            e.ejv().XX(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oHJ && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult XY(String str) {
        return oHJ ? d.a.oHR.XZ(str) : SampleResult.OTHERE;
    }

    public static void Ak(boolean z) {
        oHJ = z;
    }
}
