package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PbActivityStatic {
    private static void HL() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.S("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.e.apn();
    }

    private static void abh() {
        com.baidu.tieba.tbadkCore.a.a.b(2004003, db.class);
    }

    static {
        HL();
        abh();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new be());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2004005, new bf());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        abi();
    }

    private static void abi() {
        com.baidu.tbadk.core.util.bi.tO().a(new bg());
    }
}
