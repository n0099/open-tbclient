package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.o;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<o>> kOw = new HashMap();

    public static void b(String str, Set<o> set) {
        kOw.put(str, set);
    }

    public static Set<o> Lt(String str) {
        return kOw.get(str);
    }

    public static void remove(String str) {
        if (kOw.get(str) != null) {
            kOw.get(str).clear();
            kOw.remove(str);
        }
    }
}
