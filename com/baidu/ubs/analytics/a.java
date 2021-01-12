package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean oJn = false;

    public static void Ww(String str) {
        if (oJn) {
            e.efN().Ww(str);
        }
    }

    public static void Wx(String str) {
        if (oJn) {
            e.efN().Wx(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oJn && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Wy(String str) {
        return oJn ? d.a.oJv.Wz(str) : SampleResult.OTHERE;
    }

    public static void Ah(boolean z) {
        oJn = z;
    }
}
