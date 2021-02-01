package com.baidu.tieba.setting.forbiddenforum;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes8.dex */
public class a {
    public a() {
        registerTask();
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM, TbConfig.SERVER_ADDRESS + TbConfig.URL_CANCEL_FORBIDDEN_FORUM);
        tbHttpMessageTask.setResponsedClass(CancelForbiddenForumResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cancel(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM);
        httpMessage.addParam("forum_id", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
