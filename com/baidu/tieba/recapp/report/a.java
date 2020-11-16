package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> myN = new HashMap();

    public static void b(String str, Set<q> set) {
        myN.put(str, set);
    }

    public static Set<q> Rc(String str) {
        return myN.get(str);
    }

    public static void remove(String str) {
        if (myN.get(str) != null) {
            myN.get(str).clear();
            myN.remove(str);
        }
    }
}
