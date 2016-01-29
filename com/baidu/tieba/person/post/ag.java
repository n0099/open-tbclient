package com.baidu.tieba.person.post;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.person.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.person.god.GodThreadListHttpResponseMessage;
import com.baidu.tieba.person.god.GodThreadListSocketResponseMessage;
/* loaded from: classes.dex */
public class ag {
    public static void init() {
        Yi();
        ava();
    }

    public static void Yi() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309291, GodThreadListSocketResponseMessage.class, false, false);
    }

    private static void ava() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.am("c/u/feed/userpost", 303002));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(UserPostPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.SET_PRIVATE);
        tbHttpMessageTask2.setIsNeedLogin(true);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(CmdConfigHttp.CMD_GOD_THREAD_LIST, com.baidu.tieba.tbadkCore.a.a.am(TbConfig.GOD_THREAD_LIST, 309291));
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setResponsedClass(GodThreadListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
    }
}
