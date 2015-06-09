package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bqd;
    private boolean isAcceptNotify;

    public static l US() {
        if (bqd == null) {
            synchronized (l.class) {
                if (bqd == null) {
                    bqd = new l();
                }
            }
        }
        return bqd;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
