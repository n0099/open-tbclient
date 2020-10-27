package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static boolean ohP = false;

    public static void Wp(String str) {
        if (ohP) {
            e.dZZ().Wp(str);
        }
    }

    public static void Wq(String str) {
        if (ohP) {
            e.dZZ().Wq(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (ohP && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Wr(String str) {
        return ohP ? d.a.ohX.Ws(str) : SampleResult.OTHERE;
    }

    public static void zo(boolean z) {
        ohP = z;
    }
}
