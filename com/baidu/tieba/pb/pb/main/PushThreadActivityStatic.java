package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PushThreadActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PushThreadActivityConfig.class, PushThreadActivity.class);
        azs();
    }

    private static void azs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.au("c/b/commit/pushThread", 309325));
        tbHttpMessageTask.setResponsedClass(PbPushHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
