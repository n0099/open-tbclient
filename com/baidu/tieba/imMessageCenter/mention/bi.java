package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ bf deP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bf bfVar) {
        this.deP = bfVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        az azVar;
        az azVar2;
        azVar = this.deP.deI;
        if (azVar != null) {
            azVar2 = this.deP.deI;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(azVar2.onBackPressed()));
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
    }
}
