package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> ilS = new HashMap();

    public static void d(String str, Set<m> set) {
        ilS.put(str, set);
    }

    public static Set<m> BH(String str) {
        return ilS.get(str);
    }

    public static void remove(String str) {
        if (ilS.get(str) != null) {
            ilS.get(str).clear();
            ilS.remove(str);
        }
    }
}
