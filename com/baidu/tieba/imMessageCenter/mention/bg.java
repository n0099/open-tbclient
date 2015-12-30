package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ bd cjr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bd bdVar) {
        this.cjr = bdVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ax axVar;
        ax axVar2;
        axVar = this.cjr.cjk;
        if (axVar != null) {
            axVar2 = this.cjr.cjk;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(axVar2.onBackPressed()));
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
    }
}
