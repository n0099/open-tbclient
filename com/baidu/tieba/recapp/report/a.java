package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<n>> mXs = new HashMap();

    public static void c(String str, Set<n> set) {
        mXs.put(str, set);
    }

    public static Set<n> RQ(String str) {
        return mXs.get(str);
    }

    public static void remove(String str) {
        if (mXs.get(str) != null) {
            mXs.get(str).clear();
            mXs.remove(str);
        }
    }
}
