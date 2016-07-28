package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l cZy;
    private boolean isAcceptNotify;

    public static l arx() {
        if (cZy == null) {
            synchronized (l.class) {
                if (cZy == null) {
                    cZy = new l();
                }
            }
        }
        return cZy;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
