package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.am;
/* loaded from: classes10.dex */
public class b {
    private static volatile b opv;
    public am brD = new am();

    public static b dZy() {
        if (opv == null) {
            synchronized (b.class) {
                if (opv == null) {
                    opv = new b();
                }
            }
        }
        return opv;
    }

    private b() {
    }
}
