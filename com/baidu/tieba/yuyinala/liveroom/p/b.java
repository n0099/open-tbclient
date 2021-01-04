package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.am;
/* loaded from: classes11.dex */
public class b {
    private static volatile b ouc;
    public am bwr = new am();

    public static b edp() {
        if (ouc == null) {
            synchronized (b.class) {
                if (ouc == null) {
                    ouc = new b();
                }
            }
        }
        return ouc;
    }

    private b() {
    }
}
