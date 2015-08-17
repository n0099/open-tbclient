package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bDQ;
    private boolean isAcceptNotify;

    public static l Wz() {
        if (bDQ == null) {
            synchronized (l.class) {
                if (bDQ == null) {
                    bDQ = new l();
                }
            }
        }
        return bDQ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
