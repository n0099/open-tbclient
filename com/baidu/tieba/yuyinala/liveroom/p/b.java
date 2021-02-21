package com.baidu.tieba.yuyinala.liveroom.p;

import com.baidu.live.data.aq;
/* loaded from: classes11.dex */
public class b {
    private static volatile b ozM;
    public aq bvg = new aq();

    public static b ebT() {
        if (ozM == null) {
            synchronized (b.class) {
                if (ozM == null) {
                    ozM = new b();
                }
            }
        }
        return ozM;
    }

    private b() {
    }
}
