package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dev;
    private boolean isAcceptNotify;

    public static l aum() {
        if (dev == null) {
            synchronized (l.class) {
                if (dev == null) {
                    dev = new l();
                }
            }
        }
        return dev;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
