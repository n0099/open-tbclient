package com.baidu.tieba.tbadvert;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes10.dex */
public class TbAdvertStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921390, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.tbadvert.TbAdvertStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.r.a> run(CustomMessage<Context> customMessage) {
                if (customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2921390, new a(customMessage.getData()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
