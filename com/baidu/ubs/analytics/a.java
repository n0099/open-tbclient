package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean ifz = false;

    public static void yu(String str) {
        if (ifz) {
            e.bSH().yu(str);
        }
    }

    public static void yv(String str) {
        if (ifz) {
            e.bSH().yv(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (ifz && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult yw(String str) {
        return ifz ? d.a.ifH.yx(str) : SampleResult.OTHERE;
    }

    public static void oQ(boolean z) {
        ifz = z;
    }
}
