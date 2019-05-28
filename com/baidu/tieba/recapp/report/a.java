package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> iEH = new HashMap();

    public static void d(String str, Set<m> set) {
        iEH.put(str, set);
    }

    public static Set<m> Dd(String str) {
        return iEH.get(str);
    }

    public static void remove(String str) {
        if (iEH.get(str) != null) {
            iEH.get(str).clear();
            iEH.remove(str);
        }
    }
}
