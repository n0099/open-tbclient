package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PostSearchActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(PostSearchActivityConfig.class, PostSearchActivity.class);
        aKG();
        aKH();
        aKI();
    }

    private static void aKG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_POST_SEARCH, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_SEARCH_URL);
        tbHttpMessageTask.setResponsedClass(PostSearchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aKH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.SAVE_SEARCH_POST_DATA, new i());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aKI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CLEAR_ALL_SEARCH_POST_DATA, new j());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
