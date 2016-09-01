package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dlh;
    private boolean isAcceptNotify;

    public static l awl() {
        if (dlh == null) {
            synchronized (l.class) {
                if (dlh == null) {
                    dlh = new l();
                }
            }
        }
        return dlh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
