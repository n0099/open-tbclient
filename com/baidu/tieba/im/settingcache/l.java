package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l cXh;
    private boolean isAcceptNotify;

    public static l atg() {
        if (cXh == null) {
            synchronized (l.class) {
                if (cXh == null) {
                    cXh = new l();
                }
            }
        }
        return cXh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
