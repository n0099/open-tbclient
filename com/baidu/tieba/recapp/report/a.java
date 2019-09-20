package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> iOA = new HashMap();

    public static void e(String str, Set<m> set) {
        iOA.put(str, set);
    }

    public static Set<m> Et(String str) {
        return iOA.get(str);
    }

    public static void remove(String str) {
        if (iOA.get(str) != null) {
            iOA.get(str).clear();
            iOA.remove(str);
        }
    }
}
