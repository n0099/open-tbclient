package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gIv = new HashMap();

    public static void b(String str, Set<h> set) {
        gIv.put(str, set);
    }

    public static Set<h> ug(String str) {
        return gIv.get(str);
    }

    public static void remove(String str) {
        if (gIv.get(str) != null) {
            gIv.get(str).clear();
            gIv.remove(str);
        }
    }
}
