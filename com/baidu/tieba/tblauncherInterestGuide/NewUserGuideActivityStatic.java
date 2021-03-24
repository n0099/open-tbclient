package com.baidu.tieba.tblauncherInterestGuide;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
/* loaded from: classes5.dex */
public class NewUserGuideActivityStatic {

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<NewUserGuideActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<NewUserGuideActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(NewUserGuideActivity.class);
            }
            return null;
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012116, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
