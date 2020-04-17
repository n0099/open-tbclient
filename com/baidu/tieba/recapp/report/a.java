package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> kwz = new HashMap();

    public static void b(String str, Set<m> set) {
        kwz.put(str, set);
    }

    public static Set<m> JE(String str) {
        return kwz.get(str);
    }

    public static void remove(String str) {
        if (kwz.get(str) != null) {
            kwz.get(str).clear();
            kwz.remove(str);
        }
    }
}
