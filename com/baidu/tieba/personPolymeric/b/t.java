package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eCE = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PersonPolymericModel personPolymericModel;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        PersonPolymericModel personPolymericModel2;
        PersonPolymericModel personPolymericModel3;
        personPolymericModel = this.eCE.eCy;
        if (personPolymericModel != null) {
            nVar = this.eCE.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eCE.mPersonPolymericData;
                if (nVar2.Nd()) {
                    personPolymericModel2 = this.eCE.eCy;
                    personPolymericModel2.resetData();
                    personPolymericModel3 = this.eCE.eCy;
                    personPolymericModel3.bZ(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
    }
}
