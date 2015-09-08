package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<BaseActivity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.baseEditMark.a> run(CustomMessage<BaseActivity> customMessage) {
        b bVar = null;
        if (customMessage != null && customMessage.getData() != null) {
            bVar = new b(customMessage.getData());
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MARK_MANAGER, bVar);
    }
}
