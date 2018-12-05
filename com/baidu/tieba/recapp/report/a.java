package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gQM = new HashMap();

    public static void b(String str, Set<h> set) {
        gQM.put(str, set);
    }

    public static Set<h> uL(String str) {
        return gQM.get(str);
    }

    public static void remove(String str) {
        if (gQM.get(str) != null) {
            gQM.get(str).clear();
            gQM.remove(str);
        }
    }
}
