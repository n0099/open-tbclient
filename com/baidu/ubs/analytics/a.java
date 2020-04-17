package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    private static boolean lNW = false;

    public static void Nx(String str) {
        if (lNW) {
            e.dlg().Nx(str);
        }
    }

    public static void Ny(String str) {
        if (lNW) {
            e.dlg().Ny(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (lNW && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Nz(String str) {
        return lNW ? d.a.lOe.NA(str) : SampleResult.OTHERE;
    }

    public static void vp(boolean z) {
        lNW = z;
    }
}
