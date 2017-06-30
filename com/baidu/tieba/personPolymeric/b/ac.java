package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ z eVB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.eVB = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PersonPolymericModel personPolymericModel;
        com.baidu.tieba.personPolymeric.c.a aVar;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        PersonPolymericModel personPolymericModel2;
        PersonPolymericModel personPolymericModel3;
        personPolymericModel = this.eVB.bzq;
        if (personPolymericModel != null) {
            aVar = this.eVB.eVv;
            if (aVar != null) {
                aVar2 = this.eVB.eVv;
                if (aVar2.Oy()) {
                    personPolymericModel2 = this.eVB.bzq;
                    personPolymericModel2.resetData();
                    personPolymericModel3 = this.eVB.bzq;
                    personPolymericModel3.cs(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
    }
}
