package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> lHB = new HashMap();

    public static void b(String str, Set<q> set) {
        lHB.put(str, set);
    }

    public static Set<q> PB(String str) {
        return lHB.get(str);
    }

    public static void remove(String str) {
        if (lHB.get(str) != null) {
            lHB.get(str).clear();
            lHB.remove(str);
        }
    }
}
