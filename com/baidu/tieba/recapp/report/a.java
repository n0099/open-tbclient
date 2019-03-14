package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> imh = new HashMap();

    public static void d(String str, Set<m> set) {
        imh.put(str, set);
    }

    public static Set<m> BI(String str) {
        return imh.get(str);
    }

    public static void remove(String str) {
        if (imh.get(str) != null) {
            imh.get(str).clear();
            imh.remove(str);
        }
    }
}
