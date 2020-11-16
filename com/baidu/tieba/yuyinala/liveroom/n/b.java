package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.aj;
/* loaded from: classes4.dex */
public class b {
    private static volatile b obG;
    public aj bmB = new aj();

    public static b dYs() {
        if (obG == null) {
            synchronized (b.class) {
                if (obG == null) {
                    obG = new b();
                }
            }
        }
        return obG;
    }

    private b() {
    }
}
