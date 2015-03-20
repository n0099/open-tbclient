package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bnh;
    private boolean isAcceptNotify;

    public static l Tr() {
        if (bnh == null) {
            synchronized (l.class) {
                if (bnh == null) {
                    bnh = new l();
                }
            }
        }
        return bnh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
