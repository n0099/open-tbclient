package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static final Map<String, Set<q>> lHo = new HashMap();

    public static void b(String str, Set<q> set) {
        lHo.put(str, set);
    }

    public static Set<q> PA(String str) {
        return lHo.get(str);
    }

    public static void remove(String str) {
        if (lHo.get(str) != null) {
            lHo.get(str).clear();
            lHo.remove(str);
        }
    }
}
