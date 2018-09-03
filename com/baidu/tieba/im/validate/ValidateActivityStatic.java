package com.baidu.tieba.im.validate;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
/* loaded from: classes3.dex */
public class ValidateActivityStatic {
    static {
        aCP();
    }

    private static void aCP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008021, new CustomMessageTask.CustomRunnable<ValidateActivityConfig>() { // from class: com.baidu.tieba.im.validate.ValidateActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ValidateActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ValidateActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
