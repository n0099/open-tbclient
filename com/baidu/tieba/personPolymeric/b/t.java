package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eHF = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.mode.c cVar;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar3;
        cVar = this.eHF.eHz;
        if (cVar != null) {
            nVar = this.eHF.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eHF.mPersonPolymericData;
                if (nVar2.aPz()) {
                    cVar2 = this.eHF.eHz;
                    cVar2.resetData();
                    cVar3 = this.eHF.eHz;
                    cVar3.cI(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
    }
}
