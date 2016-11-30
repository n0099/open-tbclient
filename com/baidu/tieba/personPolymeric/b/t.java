package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eQi = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.mode.c cVar;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar3;
        cVar = this.eQi.eQc;
        if (cVar != null) {
            nVar = this.eQi.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eQi.mPersonPolymericData;
                if (nVar2.aSh()) {
                    cVar2 = this.eQi.eQc;
                    cVar2.resetData();
                    cVar3 = this.eQi.eQc;
                    cVar3.cJ(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
    }
}
