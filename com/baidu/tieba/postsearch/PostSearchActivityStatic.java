package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PostSearchActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PostSearchActivityConfig.class, PostSearchActivity.class);
        afX();
        afY();
        afZ();
    }

    private static void afX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_POST_SEARCH, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_SEARCH_URL);
        tbHttpMessageTask.setResponsedClass(PostSearchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void afY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009003, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void afZ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009004, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
