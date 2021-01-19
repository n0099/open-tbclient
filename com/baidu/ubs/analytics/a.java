package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean oJo = false;

    public static void Wx(String str) {
        if (oJo) {
            e.efN().Wx(str);
        }
    }

    public static void Wy(String str) {
        if (oJo) {
            e.efN().Wy(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oJo && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Wz(String str) {
        return oJo ? d.a.oJw.WA(str) : SampleResult.OTHERE;
    }

    public static void Ah(boolean z) {
        oJo = z;
    }
}
