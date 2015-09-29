package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bHA;
    private boolean isAcceptNotify;

    public static l Xk() {
        if (bHA == null) {
            synchronized (l.class) {
                if (bHA == null) {
                    bHA = new l();
                }
            }
        }
        return bHA;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
