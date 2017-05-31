package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class bf implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ ReplyMessageActivity dnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ReplyMessageActivity replyMessageActivity) {
        this.dnl = replyMessageActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        av avVar;
        av avVar2;
        avVar = this.dnl.dnk;
        if (avVar != null) {
            avVar2 = this.dnl.dnk;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(avVar2.onBackPressed()));
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
    }
}
