package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes14.dex */
public class a {
    private static boolean oWb = false;

    public static void XP(String str) {
        if (oWb) {
            e.eiw().XP(str);
        }
    }

    public static void XQ(String str) {
        if (oWb) {
            e.eiw().XQ(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (oWb && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult XR(String str) {
        return oWb ? d.a.oWj.XS(str) : SampleResult.OTHERE;
    }

    public static void Az(boolean z) {
        oWb = z;
    }
}
