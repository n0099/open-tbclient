package com.baidu.tieba.recommendfrs;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static volatile List<Long> dUW = new ArrayList();

    public static void bQ(long j) {
        if (dUW.size() > 300) {
            dUW.remove(0);
        }
        dUW.add(Long.valueOf(j));
    }

    public static boolean bR(long j) {
        return dUW.contains(Long.valueOf(j));
    }
}
