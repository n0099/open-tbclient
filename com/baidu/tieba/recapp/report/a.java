package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> iEI = new HashMap();

    public static void d(String str, Set<m> set) {
        iEI.put(str, set);
    }

    public static Set<m> Df(String str) {
        return iEI.get(str);
    }

    public static void remove(String str) {
        if (iEI.get(str) != null) {
            iEI.get(str).clear();
            iEI.remove(str);
        }
    }
}
