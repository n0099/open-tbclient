package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ ReplyMessageActivity ddp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ReplyMessageActivity replyMessageActivity) {
        this.ddp = replyMessageActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.ddp.ddo;
        if (bbVar != null) {
            bbVar2 = this.ddp.ddo;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(bbVar2.onBackPressed()));
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
    }
}
