package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<n>> mZC = new HashMap();

    public static void c(String str, Set<n> set) {
        mZC.put(str, set);
    }

    public static Set<n> RW(String str) {
        return mZC.get(str);
    }

    public static void remove(String str) {
        if (mZC.get(str) != null) {
            mZC.get(str).clear();
            mZC.remove(str);
        }
    }
}
