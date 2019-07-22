package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> iLa = new HashMap();

    public static void e(String str, Set<m> set) {
        iLa.put(str, set);
    }

    public static Set<m> DS(String str) {
        return iLa.get(str);
    }

    public static void remove(String str) {
        if (iLa.get(str) != null) {
            iLa.get(str).clear();
            iLa.remove(str);
        }
    }
}
