package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.am;
/* loaded from: classes10.dex */
public class b {
    private static volatile b opw;
    public am brD = new am();

    public static b dZy() {
        if (opw == null) {
            synchronized (b.class) {
                if (opw == null) {
                    opw = new b();
                }
            }
        }
        return opw;
    }

    private b() {
    }
}
