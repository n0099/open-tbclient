package com.baidu.tieba.nightResource;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NightResourceStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.nightResource.NightResourceStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.TRUE);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        c.Tn = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_NIGHT_PLUGIN_INSATLLED));
    }
}
