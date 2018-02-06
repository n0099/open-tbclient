package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
/* loaded from: classes3.dex */
public class UserMuteListActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016302, new CustomMessageTask.CustomRunnable<UserMuteListActivityConfig>() { // from class: com.baidu.tieba.setting.usermutelist.UserMuteListActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<UserMuteListActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(UserMuteListActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
