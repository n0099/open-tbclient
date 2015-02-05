package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l bpj;
    private boolean isAcceptNotify;

    public static l Tq() {
        if (bpj == null) {
            synchronized (l.class) {
                if (bpj == null) {
                    bpj = new l();
                }
            }
        }
        return bpj;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
