package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> lQv = new HashMap();

    public static void b(String str, Set<q> set) {
        lQv.put(str, set);
    }

    public static Set<q> Qb(String str) {
        return lQv.get(str);
    }

    public static void remove(String str) {
        if (lQv.get(str) != null) {
            lQv.get(str).clear();
            lQv.remove(str);
        }
    }
}
