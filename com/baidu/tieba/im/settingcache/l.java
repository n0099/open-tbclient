package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bnN;
    private boolean isAcceptNotify;

    public static l SZ() {
        if (bnN == null) {
            synchronized (l.class) {
                if (bnN == null) {
                    bnN = new l();
                }
            }
        }
        return bnN;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
