package com.baidu.tieba.personPolymeric.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ aj eLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aj ajVar) {
        this.eLE = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.d.ac acVar;
        i iVar;
        acVar = this.eLE.eLA;
        acVar.Tx();
        iVar = this.eLE.bwJ;
        iVar.dB(true);
    }
}
