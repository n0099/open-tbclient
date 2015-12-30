package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
/* loaded from: classes.dex */
public class EditMarkStatic {
    private static int msgCount = 0;

    static {
        j jVar = new j(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(new k(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117));
        MessageManager.getInstance().registerListener(jVar);
        com.baidu.tieba.tbadkCore.a.a.a(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, com.baidu.tieba.tbadkCore.a.a.ak("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, new l());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_NEED_ADD_ITEM));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_COLLECTION_PLUGIN_INSTALL_SUCCESS));
    }
}
