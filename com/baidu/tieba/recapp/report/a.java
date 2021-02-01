package com.baidu.tieba.recapp.report;

import com.baidu.adp.widget.ListView.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {
    private static final Map<String, Set<n>> mWS = new HashMap();

    public static void c(String str, Set<n> set) {
        mWS.put(str, set);
    }

    public static Set<n> RE(String str) {
        return mWS.get(str);
    }

    public static void remove(String str) {
        if (mWS.get(str) != null) {
            mWS.get(str).clear();
            mWS.remove(str);
        }
    }
}
