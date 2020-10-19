package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> mfN = new HashMap();

    public static void b(String str, Set<q> set) {
        mfN.put(str, set);
    }

    public static Set<q> QP(String str) {
        return mfN.get(str);
    }

    public static void remove(String str) {
        if (mfN.get(str) != null) {
            mfN.get(str).clear();
            mfN.remove(str);
        }
    }
}
