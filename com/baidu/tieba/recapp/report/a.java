package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> imo = new HashMap();

    public static void d(String str, Set<m> set) {
        imo.put(str, set);
    }

    public static Set<m> BK(String str) {
        return imo.get(str);
    }

    public static void remove(String str) {
        if (imo.get(str) != null) {
            imo.get(str).clear();
            imo.remove(str);
        }
    }
}
