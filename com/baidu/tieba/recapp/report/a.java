package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<h>> gUK = new HashMap();

    public static void b(String str, Set<h> set) {
        gUK.put(str, set);
    }

    public static Set<h> ve(String str) {
        return gUK.get(str);
    }

    public static void remove(String str) {
        if (gUK.get(str) != null) {
            gUK.get(str).clear();
            gUK.remove(str);
        }
    }
}
