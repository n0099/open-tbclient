package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class EditMarkStatic {
    private static int msgCount = 0;

    static {
        MessageManager.getInstance().registerListener(new h(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL));
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, new i());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM));
    }
}
