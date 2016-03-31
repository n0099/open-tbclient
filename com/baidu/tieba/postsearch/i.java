package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
        if (customMessage == null) {
            return null;
        }
        String data = customMessage.getData();
        if (StringUtils.isNull(data)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.util.m.ob(data);
        return new CustomResponsedMessage<>(CmdConfigCustom.SAVE_SEARCH_POST_DATA);
    }
}
