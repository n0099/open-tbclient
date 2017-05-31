package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ j fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.fQz = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fQz.bkd();
    }
}
