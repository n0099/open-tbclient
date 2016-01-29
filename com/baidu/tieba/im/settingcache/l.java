package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l cfL;
    private boolean isAcceptNotify;

    public static l aeV() {
        if (cfL == null) {
            synchronized (l.class) {
                if (cfL == null) {
                    cfL = new l();
                }
            }
        }
        return cfL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
