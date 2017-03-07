package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dgM;
    private boolean isAcceptNotify;

    public static l atH() {
        if (dgM == null) {
            synchronized (l.class) {
                if (dgM == null) {
                    dgM = new l();
                }
            }
        }
        return dgM;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
