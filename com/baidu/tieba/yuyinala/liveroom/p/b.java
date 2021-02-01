package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.aq;
/* loaded from: classes11.dex */
public class b {
    private static volatile b ozm;
    public aq bvg = new aq();

    public static b ebL() {
        if (ozm == null) {
            synchronized (b.class) {
                if (ozm == null) {
                    ozm = new b();
                }
            }
        }
        return ozm;
    }

    private b() {
    }
}
