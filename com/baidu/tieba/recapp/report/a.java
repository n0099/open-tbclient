package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> lqT = new HashMap();

    public static void b(String str, Set<q> set) {
        lqT.put(str, set);
    }

    public static Set<q> MD(String str) {
        return lqT.get(str);
    }

    public static void remove(String str) {
        if (lqT.get(str) != null) {
            lqT.get(str).clear();
            lqT.remove(str);
        }
    }
}
