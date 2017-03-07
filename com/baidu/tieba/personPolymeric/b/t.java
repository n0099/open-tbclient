package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eHd = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PersonPolymericModel personPolymericModel;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        PersonPolymericModel personPolymericModel2;
        PersonPolymericModel personPolymericModel3;
        personPolymericModel = this.eHd.eGX;
        if (personPolymericModel != null) {
            nVar = this.eHd.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eHd.mPersonPolymericData;
                if (nVar2.Nj()) {
                    personPolymericModel2 = this.eHd.eGX;
                    personPolymericModel2.resetData();
                    personPolymericModel3 = this.eHd.eGX;
                    personPolymericModel3.co(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
    }
}
