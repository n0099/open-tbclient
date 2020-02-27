package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> jLt = new HashMap();

    public static void b(String str, Set<m> set) {
        jLt.put(str, set);
    }

    public static Set<m> HZ(String str) {
        return jLt.get(str);
    }

    public static void remove(String str) {
        if (jLt.get(str) != null) {
            jLt.get(str).clear();
            jLt.remove(str);
        }
    }
}
