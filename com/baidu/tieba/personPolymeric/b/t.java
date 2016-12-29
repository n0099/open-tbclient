package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q etH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.etH = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.personPolymeric.mode.c cVar;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar2;
        com.baidu.tieba.personPolymeric.mode.c cVar3;
        cVar = this.etH.etB;
        if (cVar != null) {
            nVar = this.etH.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.etH.mPersonPolymericData;
                if (nVar2.aMb()) {
                    cVar2 = this.etH.etB;
                    cVar2.resetData();
                    cVar3 = this.etH.etB;
                    cVar3.cr(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
    }
}
