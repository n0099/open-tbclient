package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.aq;
/* loaded from: classes10.dex */
public class b {
    private static volatile b oBR;
    public aq bwG = new aq();

    public static b ecb() {
        if (oBR == null) {
            synchronized (b.class) {
                if (oBR == null) {
                    oBR = new b();
                }
            }
        }
        return oBR;
    }

    private b() {
    }
}
