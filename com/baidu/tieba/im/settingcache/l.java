package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bXm;
    private boolean isAcceptNotify;

    public static l aaH() {
        if (bXm == null) {
            synchronized (l.class) {
                if (bXm == null) {
                    bXm = new l();
                }
            }
        }
        return bXm;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
