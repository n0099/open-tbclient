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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.aF("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.bcY();
    }

    private static void aFk() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, gb.class);
    }

    private static void aFl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    static {
        Iv();
        aFk();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new ce());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ajg();
        aFl();
        cf cfVar = new cf();
        cfVar.setSelfExecute(true);
        cfVar.setPriority(4);
        cfVar.execute(new Void[0]);
    }

    private static void ajg() {
        com.baidu.tbadk.core.util.bi.us().a(new cg());
    }
}
