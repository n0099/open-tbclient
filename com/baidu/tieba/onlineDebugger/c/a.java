package com.baidu.tieba.onlineDebugger.c;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, Class<?>> buN = new HashMap<>();

    static {
        buN.put("TbadkCoreApplication", TbadkCoreApplication.class);
        buN.put("BdActivityStack", com.baidu.adp.base.a.class);
    }

    public static final Class<?> findClass(String str) {
        if (str == null) {
            return null;
        }
        return buN.get(str);
    }
}
