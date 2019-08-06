package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<m>> iMe = new HashMap();

    public static void e(String str, Set<m> set) {
        iMe.put(str, set);
    }

    public static Set<m> DT(String str) {
        return iMe.get(str);
    }

    public static void remove(String str) {
        if (iMe.get(str) != null) {
            iMe.get(str).clear();
            iMe.remove(str);
        }
    }
}
