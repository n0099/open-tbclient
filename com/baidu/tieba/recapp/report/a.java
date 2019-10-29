package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> iNs = new HashMap();

    public static void e(String str, Set<m> set) {
        iNs.put(str, set);
    }

    public static Set<m> CO(String str) {
        return iNs.get(str);
    }

    public static void remove(String str) {
        if (iNs.get(str) != null) {
            iNs.get(str).clear();
            iNs.remove(str);
        }
    }
}
