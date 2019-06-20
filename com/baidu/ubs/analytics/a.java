package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static boolean jPi = false;

    public static void Gj(String str) {
        if (jPi) {
            e.cAu().Gj(str);
        }
    }

    public static void Gk(String str) {
        if (jPi) {
            e.cAu().Gk(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (jPi && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Gl(String str) {
        return jPi ? d.a.jPq.Gm(str) : SampleResult.OTHERE;
    }

    public static void sc(boolean z) {
        jPi = z;
    }
}
