package com.baidu.tieba.recommendfrs;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static volatile List<Long> dDc = new ArrayList();

    public static void bG(long j) {
        if (dDc.size() > 300) {
            dDc.remove(0);
        }
        dDc.add(Long.valueOf(j));
    }

    public static boolean bH(long j) {
        return dDc.contains(Long.valueOf(j));
    }
}
