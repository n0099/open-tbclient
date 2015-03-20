package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class SquareSearchActivityStatic {
    static {
        WQ();
        WR();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new as());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.b(2001194, p.class);
        com.baidu.tieba.tbadkCore.a.a.b(2001195, o.class);
        WS();
        com.baidu.tieba.tbadkCore.a.a.c(303116, HotForumSocketResponseMessage.class, false);
    }

    private static void WQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new at());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void WR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new au());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void WS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, com.baidu.tieba.tbadkCore.a.a.R(TbConfig.GET_HOT_FORUM_URL, 303116));
        tbHttpMessageTask.setResponsedClass(HotForumHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
