package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> msm = new HashMap();

    public static void b(String str, Set<q> set) {
        msm.put(str, set);
    }

    public static Set<q> Rn(String str) {
        return msm.get(str);
    }

    public static void remove(String str) {
        if (msm.get(str) != null) {
            msm.get(str).clear();
            msm.remove(str);
        }
    }
}
