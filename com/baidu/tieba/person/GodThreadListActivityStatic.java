package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.person.god.GodThreadListActivity;
import com.baidu.tieba.person.god.GodThreadListActivityConfig;
import com.baidu.tieba.person.god.GodThreadListHttpResponseMessage;
import com.baidu.tieba.person.god.GodThreadListSocketResponseMessage;
/* loaded from: classes.dex */
public class GodThreadListActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(GodThreadListActivityConfig.class, GodThreadListActivity.class);
        aky();
        aNp();
    }

    public static void aky() {
        com.baidu.tieba.tbadkCore.a.a.a(309291, GodThreadListSocketResponseMessage.class, false, false);
    }

    private static void aNp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GOD_THREAD_LIST, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.GOD_THREAD_LIST, 309291));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GodThreadListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
