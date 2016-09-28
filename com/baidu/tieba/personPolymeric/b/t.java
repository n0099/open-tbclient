package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eJJ = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.mode.c cVar;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar3;
        cVar = this.eJJ.eJD;
        if (cVar != null) {
            nVar = this.eJJ.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eJJ.mPersonPolymericData;
                if (nVar2.aQi()) {
                    cVar2 = this.eJJ.eJD;
                    cVar2.resetData();
                    cVar3 = this.eJJ.eJD;
                    cVar3.cI(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
    }
}
