package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<n>> mSk = new HashMap();

    public static void c(String str, Set<n> set) {
        mSk.put(str, set);
    }

    public static Set<n> RT(String str) {
        return mSk.get(str);
    }

    public static void remove(String str) {
        if (mSk.get(str) != null) {
            mSk.get(str).clear();
            mSk.remove(str);
        }
    }
}
