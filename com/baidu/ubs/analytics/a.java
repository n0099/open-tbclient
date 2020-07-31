package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean mMB = false;

    public static void QM(String str) {
        if (mMB) {
            e.dAC().QM(str);
        }
    }

    public static void QN(String str) {
        if (mMB) {
            e.dAC().QN(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (mMB && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult QO(String str) {
        return mMB ? d.a.mMJ.QP(str) : SampleResult.OTHERE;
    }

    public static void wQ(boolean z) {
        mMB = z;
    }
}
