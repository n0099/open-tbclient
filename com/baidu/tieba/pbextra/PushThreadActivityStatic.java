package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes3.dex */
public class PushThreadActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PushThreadActivityConfig.class, PushThreadActivity.class);
        bnC();
    }

    private static void bnC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PUSH_THREAD_HTTP_CMD, a.aU("c/b/commit/pushThread", 309325));
        tbHttpMessageTask.setResponsedClass(PbPushHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
