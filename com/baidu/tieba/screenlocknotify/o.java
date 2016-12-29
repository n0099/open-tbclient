package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i eQM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.eQM = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eQM.eQD.aYS();
    }
}
