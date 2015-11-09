package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PbActivityStatic {
    private static void Iv() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.ae("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.ayx();
        agg();
    }

    private static void age() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, Cdo.class);
    }

    static {
        Iv();
        age();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new bn());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        agf();
    }

    private static void agf() {
        com.baidu.tbadk.core.util.az.uX().a(new bo());
    }

    private static void agg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_LOTTERY_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/b/commit/lottery");
        tbHttpMessageTask.setResponsedClass(PbLotteryHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
