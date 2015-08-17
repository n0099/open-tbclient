package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class SquareSearchActivityStatic {
    static {
        aak();
        aal();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_SQUARESEARCH, new an());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY, i.class);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY, h.class);
        aam();
        com.baidu.tieba.tbadkCore.a.a.c(303116, HotForumSocketResponseMessage.class, false);
    }

    private static void aak() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA, new ao());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aal() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA, new ap());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aam() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, com.baidu.tieba.tbadkCore.a.a.Z(TbConfig.GET_HOT_FORUM_URL, 303116));
        tbHttpMessageTask.setResponsedClass(HotForumHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
