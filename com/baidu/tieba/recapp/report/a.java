package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> jGQ = new HashMap();

    public static void b(String str, Set<m> set) {
        jGQ.put(str, set);
    }

    public static Set<m> HB(String str) {
        return jGQ.get(str);
    }

    public static void remove(String str) {
        if (jGQ.get(str) != null) {
            jGQ.get(str).clear();
            jGQ.remove(str);
        }
    }
}
