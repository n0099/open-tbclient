package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dfj;
    private boolean isAcceptNotify;

    public static l atA() {
        if (dfj == null) {
            synchronized (l.class) {
                if (dfj == null) {
                    dfj = new l();
                }
            }
        }
        return dfj;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
