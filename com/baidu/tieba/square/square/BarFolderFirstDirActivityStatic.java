package com.baidu.tieba.square.square;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
/* loaded from: classes5.dex */
public class BarFolderFirstDirActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(BarFolderFirstDirActivityConfig.class, BarFolderFirstDirActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2902026, new CustomMessageTask.CustomRunnable<BarFolderFirstDirActivityConfig>() { // from class: com.baidu.tieba.square.square.BarFolderFirstDirActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<BarFolderFirstDirActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(BarFolderFirstDirActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
