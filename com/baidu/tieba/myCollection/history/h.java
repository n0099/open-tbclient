package com.baidu.tieba.myCollection.history;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.tbadkCore.i.a> run(CustomMessage<String> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MY_HISTORY_RES_TOOL, new a());
    }
}
