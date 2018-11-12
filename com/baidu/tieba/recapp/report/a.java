package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gJW = new HashMap();

    public static void b(String str, Set<h> set) {
        gJW.put(str, set);
    }

    public static Set<h> uk(String str) {
        return gJW.get(str);
    }

    public static void remove(String str) {
        if (gJW.get(str) != null) {
            gJW.get(str).clear();
            gJW.remove(str);
        }
    }
}
