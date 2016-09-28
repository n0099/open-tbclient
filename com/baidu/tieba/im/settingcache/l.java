package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dmE;
    private boolean isAcceptNotify;

    public static l awK() {
        if (dmE == null) {
            synchronized (l.class) {
                if (dmE == null) {
                    dmE = new l();
                }
            }
        }
        return dmE;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
