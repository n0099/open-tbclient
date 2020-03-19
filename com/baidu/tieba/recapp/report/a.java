package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> jNj = new HashMap();

    public static void b(String str, Set<m> set) {
        jNj.put(str, set);
    }

    public static Set<m> Ia(String str) {
        return jNj.get(str);
    }

    public static void remove(String str) {
        if (jNj.get(str) != null) {
            jNj.get(str).clear();
            jNj.remove(str);
        }
    }
}
