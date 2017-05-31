package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ y eLx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.eLx = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PersonPolymericModel personPolymericModel;
        com.baidu.tieba.personPolymeric.c.a aVar;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        PersonPolymericModel personPolymericModel2;
        PersonPolymericModel personPolymericModel3;
        personPolymericModel = this.eLx.bwC;
        if (personPolymericModel != null) {
            aVar = this.eLx.eLr;
            if (aVar != null) {
                aVar2 = this.eLx.eLr;
                if (aVar2.Nm()) {
                    personPolymericModel2 = this.eLx.bwC;
                    personPolymericModel2.resetData();
                    personPolymericModel3 = this.eLx.bwC;
                    personPolymericModel3.cd(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
                }
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
    }
}
