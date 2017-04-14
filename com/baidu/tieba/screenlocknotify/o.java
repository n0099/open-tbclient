package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ i fge;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.fge = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fge.ffV.bbb();
    }
}
