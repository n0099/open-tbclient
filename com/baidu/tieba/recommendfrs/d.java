package com.baidu.tieba.recommendfrs;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile List<Long> dnU = new ArrayList();

    public static void bD(long j) {
        if (dnU.size() > 300) {
            dnU.remove(0);
        }
        dnU.add(Long.valueOf(j));
    }

    public static boolean bE(long j) {
        return dnU.contains(Long.valueOf(j));
    }
}
