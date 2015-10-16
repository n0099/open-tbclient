package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bHL;
    private boolean isAcceptNotify;

    public static l Xk() {
        if (bHL == null) {
            synchronized (l.class) {
                if (bHL == null) {
                    bHL = new l();
                }
            }
        }
        return bHL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
