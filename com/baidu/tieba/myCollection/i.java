package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.tbadkCore.h.a> run(CustomMessage<String> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, new n());
    }
}
