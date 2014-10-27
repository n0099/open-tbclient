package com.baidu.tieba.square;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
/* loaded from: classes.dex */
class z implements CustomMessageTask.CustomRunnable<SingleSquareActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<SingleSquareActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SingleSquareActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
