package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ f fcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.fcU = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fcU.fcL.bbV();
    }
}
