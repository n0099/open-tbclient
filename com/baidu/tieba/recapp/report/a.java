package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<q>> mNb = new HashMap();

    public static void b(String str, Set<q> set) {
        mNb.put(str, set);
    }

    public static Set<q> Sl(String str) {
        return mNb.get(str);
    }

    public static void remove(String str) {
        if (mNb.get(str) != null) {
            mNb.get(str).clear();
            mNb.remove(str);
        }
    }
}
