package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes15.dex */
public class a {
    private static boolean oTw = false;

    public static void Xw(String str) {
        if (oTw) {
            e.eif().Xw(str);
        }
    }

    public static void Xx(String str) {
        if (oTw) {
            e.eif().Xx(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oTw && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Xy(String str) {
        return oTw ? d.a.oTE.Xz(str) : SampleResult.OTHERE;
    }

    public static void AA(boolean z) {
        oTw = z;
    }
}
