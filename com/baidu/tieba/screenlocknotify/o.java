package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i fiw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.fiw = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fiw.fin.bcc();
    }
}
