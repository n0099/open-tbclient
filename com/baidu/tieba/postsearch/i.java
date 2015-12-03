package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<Void> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Void> run(CustomMessage<Void> customMessage) {
        if (customMessage == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.util.m.aEa();
        return new CustomResponsedMessage<>(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA);
    }
}
