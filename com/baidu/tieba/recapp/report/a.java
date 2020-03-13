package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> jLH = new HashMap();

    public static void b(String str, Set<m> set) {
        jLH.put(str, set);
    }

    public static Set<m> Ia(String str) {
        return jLH.get(str);
    }

    public static void remove(String str) {
        if (jLH.get(str) != null) {
            jLH.get(str).clear();
            jLH.remove(str);
        }
    }
}
