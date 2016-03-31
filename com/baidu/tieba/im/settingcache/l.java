package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l cqq;
    private boolean isAcceptNotify;

    public static l aio() {
        if (cqq == null) {
            synchronized (l.class) {
                if (cqq == null) {
                    cqq = new l();
                }
            }
        }
        return cqq;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
