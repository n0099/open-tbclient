package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.am;
/* loaded from: classes11.dex */
public class b {
    private static volatile b oub;
    public am bwr = new am();

    public static b edq() {
        if (oub == null) {
            synchronized (b.class) {
                if (oub == null) {
                    oub = new b();
                }
            }
        }
        return oub;
    }

    private b() {
    }
}
