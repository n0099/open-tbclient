package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eDB = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PersonPolymericModel personPolymericModel;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        PersonPolymericModel personPolymericModel2;
        PersonPolymericModel personPolymericModel3;
        personPolymericModel = this.eDB.eDv;
        if (personPolymericModel != null) {
            nVar = this.eDB.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eDB.mPersonPolymericData;
                if (nVar2.Mw()) {
                    personPolymericModel2 = this.eDB.eDv;
                    personPolymericModel2.resetData();
                    personPolymericModel3 = this.eDB.eDv;
                    personPolymericModel3.cm(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
    }
}
