package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.ak;
/* loaded from: classes4.dex */
public class b {
    private static volatile b oqG;
    public ak brJ = new ak();

    public static b edW() {
        if (oqG == null) {
            synchronized (b.class) {
                if (oqG == null) {
                    oqG = new b();
                }
            }
        }
        return oqG;
    }

    private b() {
    }
}
