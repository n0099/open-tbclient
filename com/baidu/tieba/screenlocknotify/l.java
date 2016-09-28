package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ f ffC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.ffC = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ffC.fft.bcF();
    }
}
