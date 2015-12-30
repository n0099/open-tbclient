package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ f drv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.drv = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.drv.drm.ayX();
    }
}
