package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
/* loaded from: classes.dex */
class c implements CustomMessageTask.CustomRunnable<ValidateActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ValidateActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ValidateActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
