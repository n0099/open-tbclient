package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ f dkn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dkn = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dkn.dke.awQ();
    }
}
