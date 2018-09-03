package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gtB = new HashMap();

    public static void b(String str, Set<h> set) {
        gtB.put(str, set);
    }

    public static Set<h> sX(String str) {
        return gtB.get(str);
    }

    public static void remove(String str) {
        if (gtB.get(str) != null) {
            gtB.get(str).clear();
            gtB.remove(str);
        }
    }
}
