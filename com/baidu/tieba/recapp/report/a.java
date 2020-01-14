package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> jKx = new HashMap();

    public static void b(String str, Set<m> set) {
        jKx.put(str, set);
    }

    public static Set<m> HL(String str) {
        return jKx.get(str);
    }

    public static void remove(String str) {
        if (jKx.get(str) != null) {
            jKx.get(str).clear();
            jKx.remove(str);
        }
    }
}
