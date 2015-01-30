package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bpk;
    private boolean isAcceptNotify;

    public static l Tv() {
        if (bpk == null) {
            synchronized (l.class) {
                if (bpk == null) {
                    bpk = new l();
                }
            }
        }
        return bpk;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
