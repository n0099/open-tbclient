package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> kwD = new HashMap();

    public static void b(String str, Set<m> set) {
        kwD.put(str, set);
    }

    public static Set<m> JH(String str) {
        return kwD.get(str);
    }

    public static void remove(String str) {
        if (kwD.get(str) != null) {
            kwD.get(str).clear();
            kwD.remove(str);
        }
    }
}
