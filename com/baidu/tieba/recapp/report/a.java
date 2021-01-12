package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<n>> mND = new HashMap();

    public static void c(String str, Set<n> set) {
        mND.put(str, set);
    }

    public static Set<n> QK(String str) {
        return mND.get(str);
    }

    public static void remove(String str) {
        if (mND.get(str) != null) {
            mND.get(str).clear();
            mND.remove(str);
        }
    }
}
