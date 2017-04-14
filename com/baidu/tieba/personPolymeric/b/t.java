package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ q eEZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.eEZ = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PersonPolymericModel personPolymericModel;
        com.baidu.tieba.personPolymeric.c.n nVar;
        com.baidu.tieba.personPolymeric.c.n nVar2;
        PersonPolymericModel personPolymericModel2;
        PersonPolymericModel personPolymericModel3;
        personPolymericModel = this.eEZ.eET;
        if (personPolymericModel != null) {
            nVar = this.eEZ.mPersonPolymericData;
            if (nVar != null) {
                nVar2 = this.eEZ.mPersonPolymericData;
                if (nVar2.NH()) {
                    personPolymericModel2 = this.eEZ.eET;
                    personPolymericModel2.resetData();
                    personPolymericModel3 = this.eEZ.eET;
                    personPolymericModel3.co(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
    }
}
