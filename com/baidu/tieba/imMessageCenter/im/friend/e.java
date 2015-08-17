package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
/* loaded from: classes.dex */
class e implements CustomMessageTask.CustomRunnable<IMBlackListActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IMBlackListActivityConfig> run(CustomMessage<IMBlackListActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().startActivity(IMBlackListActivity.class);
        }
        return null;
    }
}
