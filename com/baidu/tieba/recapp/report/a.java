package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<n>> mSj = new HashMap();

    public static void c(String str, Set<n> set) {
        mSj.put(str, set);
    }

    public static Set<n> RS(String str) {
        return mSj.get(str);
    }

    public static void remove(String str) {
        if (mSj.get(str) != null) {
            mSj.get(str).clear();
            mSj.remove(str);
        }
    }
}
