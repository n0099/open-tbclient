package com.baidu.tieba.personPolymeric.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {
    final /* synthetic */ ak eVM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ak akVar) {
        this.eVM = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.d.ac acVar;
        i iVar;
        acVar = this.eVM.eVF;
        acVar.ahs();
        iVar = this.eVM.eVJ;
        iVar.dD(true);
    }
}
