package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> ljy = new HashMap();

    public static void b(String str, Set<q> set) {
        ljy.put(str, set);
    }

    public static Set<q> LV(String str) {
        return ljy.get(str);
    }

    public static void remove(String str) {
        if (ljy.get(str) != null) {
            ljy.get(str).clear();
            ljy.remove(str);
        }
    }
}
