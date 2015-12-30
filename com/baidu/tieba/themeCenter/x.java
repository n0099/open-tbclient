package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class x implements CustomMessageTask.CustomRunnable<Integer> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<b> run(CustomMessage<Integer> customMessage) {
        if (customMessage == null || !(customMessage.getData() instanceof Integer)) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SKIN_FROM_DB, n.aHA().nu(customMessage.getData().intValue()));
    }
}
