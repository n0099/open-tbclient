package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> imn = new HashMap();

    public static void d(String str, Set<m> set) {
        imn.put(str, set);
    }

    public static Set<m> BJ(String str) {
        return imn.get(str);
    }

    public static void remove(String str) {
        if (imn.get(str) != null) {
            imn.get(str).clear();
            imn.remove(str);
        }
    }
}
