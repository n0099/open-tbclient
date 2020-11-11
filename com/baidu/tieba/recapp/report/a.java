package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> myi = new HashMap();

    public static void b(String str, Set<q> set) {
        myi.put(str, set);
    }

    public static Set<q> RE(String str) {
        return myi.get(str);
    }

    public static void remove(String str) {
        if (myi.get(str) != null) {
            myi.get(str).clear();
            myi.remove(str);
        }
    }
}
