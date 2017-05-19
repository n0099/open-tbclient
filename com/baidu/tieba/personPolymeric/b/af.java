package com.baidu.tieba.personPolymeric.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ ab eCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ab abVar) {
        this.eCS = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.d.ab abVar;
        com.baidu.tieba.personPolymeric.d.ab abVar2;
        abVar = this.eCS.eCL;
        abVar.acw();
        abVar2 = this.eCS.eCL;
        abVar2.dk(true);
    }
}
