package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gTE = new HashMap();

    public static void b(String str, Set<h> set) {
        gTE.put(str, set);
    }

    public static Set<h> uO(String str) {
        return gTE.get(str);
    }

    public static void remove(String str) {
        if (gTE.get(str) != null) {
            gTE.get(str).clear();
            gTE.remove(str);
        }
    }
}
