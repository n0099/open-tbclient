package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    private static boolean mEu = false;

    public static void Qa(String str) {
        if (mEu) {
            e.dxm().Qa(str);
        }
    }

    public static void Qb(String str) {
        if (mEu) {
            e.dxm().Qb(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (mEu && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult Qc(String str) {
        return mEu ? d.a.mEC.Qd(str) : SampleResult.OTHERE;
    }

    public static void wl(boolean z) {
        mEu = z;
    }
}
