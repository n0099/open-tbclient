package com.baidu.tieba.person.post;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.person.UserPostPageHttpResponseMessage;
import com.baidu.tieba.person.UserPostPageSocketResponsedMessage;
/* loaded from: classes.dex */
public class ad {
    public static void init() {
        Rk();
        aje();
    }

    public static void Rk() {
        com.baidu.tieba.tbadkCore.a.a.a(303002, UserPostPageSocketResponsedMessage.class, false, false);
    }

    private static void aje() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.USER_POST_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.ad("c/u/feed/userpost", 303002));
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
    }
}
