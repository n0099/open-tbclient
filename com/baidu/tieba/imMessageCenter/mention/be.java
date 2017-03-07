package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ ReplyMessageActivity dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ReplyMessageActivity replyMessageActivity) {
        this.dmU = replyMessageActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        au auVar;
        au auVar2;
        auVar = this.dmU.dmT;
        if (auVar != null) {
            auVar2 = this.dmU.dmT;
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, Boolean.valueOf(auVar2.onBackPressed()));
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, false);
    }
}
