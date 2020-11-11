package com.baidu.tieba.yuyinala.liveroom.n;

import com.baidu.live.data.aj;
/* loaded from: classes4.dex */
public class b {
    private static volatile b oac;
    public aj bom = new aj();

    public static b dYt() {
        if (oac == null) {
            synchronized (b.class) {
                if (oac == null) {
                    oac = new b();
                }
            }
        }
        return oac;
    }

    private b() {
    }
}
