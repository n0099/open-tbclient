package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.ai;
/* loaded from: classes4.dex */
public class b {
    private static volatile b nSP;
    public ai bmT = new ai();

    public static b dVE() {
        if (nSP == null) {
            synchronized (b.class) {
                if (nSP == null) {
                    nSP = new b();
                }
            }
        }
        return nSP;
    }

    private b() {
    }
}
