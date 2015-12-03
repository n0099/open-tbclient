package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<IntentConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().startActivity(CollectTabActivity.class);
        }
        return null;
    }
}
