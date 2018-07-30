package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gty = new HashMap();

    public static void a(String str, Set<h> set) {
        gty.put(str, set);
    }

    public static Set<h> sT(String str) {
        return gty.get(str);
    }

    public static void remove(String str) {
        if (gty.get(str) != null) {
            gty.get(str).clear();
            gty.remove(str);
        }
    }
}
