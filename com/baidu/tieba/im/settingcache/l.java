package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dgY;
    private boolean isAcceptNotify;

    public static l ast() {
        if (dgY == null) {
            synchronized (l.class) {
                if (dgY == null) {
                    dgY = new l();
                }
            }
        }
        return dgY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
