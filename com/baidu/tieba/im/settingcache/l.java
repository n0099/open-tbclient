package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l doU;
    private boolean isAcceptNotify;

    public static l awe() {
        if (doU == null) {
            synchronized (l.class) {
                if (doU == null) {
                    doU = new l();
                }
            }
        }
        return doU;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
