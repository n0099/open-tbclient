package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(f fVar) {
        this.diG = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bf bfVar;
        bfVar = this.diG.dbl;
        bfVar.avF();
    }
}
