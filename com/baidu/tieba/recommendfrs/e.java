package com.baidu.tieba.recommendfrs;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static volatile List<Long> dXO = new ArrayList();

    public static void bQ(long j) {
        if (dXO.size() > 300) {
            dXO.remove(0);
        }
        dXO.add(Long.valueOf(j));
    }

    public static boolean bR(long j) {
        return dXO.contains(Long.valueOf(j));
    }
}
