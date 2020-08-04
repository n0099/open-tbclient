package com.baidu.ubs.analytics;

import com.baidu.ubs.analytics.c.e;
import com.baidu.ubs.analytics.c.g;
import com.baidu.ubs.analytics.c.j;
import com.baidu.ubs.analytics.d;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static boolean mMD = false;

    public static void QM(String str) {
        if (mMD) {
            e.dAD().QM(str);
        }
    }

    public static void QN(String str) {
        if (mMD) {
            e.dAD().QN(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        if (mMD && str != null) {
            j.b(str, str2, str3, map);
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            g.b(cVar);
        }
    }

    public static SampleResult QO(String str) {
        return mMD ? d.a.mML.QP(str) : SampleResult.OTHERE;
    }

    public static void wQ(boolean z) {
        mMD = z;
    }
}
