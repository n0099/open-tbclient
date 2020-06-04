package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.o;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<o>> kPF = new HashMap();

    public static void b(String str, Set<o> set) {
        kPF.put(str, set);
    }

    public static Set<o> Lu(String str) {
        return kPF.get(str);
    }

    public static void remove(String str) {
        if (kPF.get(str) != null) {
            kPF.get(str).clear();
            kPF.remove(str);
        }
    }
}
