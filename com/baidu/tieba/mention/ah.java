package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.al;
/* loaded from: classes.dex */
class ah implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.frameworkData.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.frameworkData.a> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SingleMentionActivity.class);
            customMessage.getData().getIntent().putExtra("NotifiIdKey", 16);
            al.a = true;
            customMessage.getData().startActivity();
        }
        return null;
    }
}
