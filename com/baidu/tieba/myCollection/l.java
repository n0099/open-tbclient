package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.myCollection.IMyCollectionResTool;
/* loaded from: classes.dex */
class l implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IMyCollectionResTool> run(CustomMessage<String> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, new q());
    }
}
