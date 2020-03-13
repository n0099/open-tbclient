package com.baidu.tieba.pbextra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.PushThreadActivityConfig;
import com.baidu.tieba.tbadkCore.a.a;
/* loaded from: classes9.dex */
public class PushThreadActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PushThreadActivityConfig.class, PushThreadActivity.class);
        cul();
    }

    private static void cul() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001806, a.bu(Config.PB_PUSH_THREAD_ADDRESS, CmdConfigSocket.CMD_PUSH_THREAD));
        tbHttpMessageTask.setResponsedClass(PbPushHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
