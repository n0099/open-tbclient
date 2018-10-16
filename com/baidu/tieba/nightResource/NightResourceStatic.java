package com.baidu.tieba.nightResource;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.c;
/* loaded from: classes5.dex */
public class NightResourceStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001281, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.nightResource.NightResourceStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
                return new CustomResponsedMessage<>(2001281, Boolean.TRUE);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        c.IS_SUPPORT_NIGHT = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001354));
    }
}
