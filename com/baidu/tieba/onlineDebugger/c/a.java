package com.baidu.tieba.onlineDebugger.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, Class<?>> bcd = new HashMap<>();

    static {
        bcd.put("TbadkCoreApplication", TbadkCoreApplication.class);
        bcd.put("BdActivityStack", com.baidu.adp.base.a.class);
    }

    public static final Class<?> findClass(String str) {
        if (str == null) {
            return null;
        }
        return bcd.get(str);
    }
}
