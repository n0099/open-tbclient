package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.ak;
/* loaded from: classes4.dex */
public class b {
    private static volatile b oqI;
    public ak brJ = new ak();

    public static b edX() {
        if (oqI == null) {
            synchronized (b.class) {
                if (oqI == null) {
                    oqI = new b();
                }
            }
        }
        return oqI;
    }

    private b() {
    }
}
