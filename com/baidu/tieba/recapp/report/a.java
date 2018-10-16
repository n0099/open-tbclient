package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gIu = new HashMap();

    public static void b(String str, Set<h> set) {
        gIu.put(str, set);
    }

    public static Set<h> ug(String str) {
        return gIu.get(str);
    }

    public static void remove(String str) {
        if (gIu.get(str) != null) {
            gIu.get(str).clear();
            gIu.remove(str);
        }
    }
}
