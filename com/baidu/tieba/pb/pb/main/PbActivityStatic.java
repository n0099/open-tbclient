package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class PbActivityStatic {
    private static void JJ() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.av("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.bio();
    }

    private static void aKR() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, gm.class);
    }

    private static void aKS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void Zi() {
        com.baidu.tbadk.ala.c.nD().a(2, new cl());
        com.baidu.tbadk.ala.c.nD().a(3, new cm());
        com.baidu.tbadk.ala.c.nD().a(4, new cn());
    }

    static {
        Zi();
        JJ();
        aKR();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new cj());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        JK();
        aKS();
        ck ckVar = new ck();
        ckVar.setSelfExecute(true);
        ckVar.setPriority(4);
        ckVar.execute(new Void[0]);
    }

    private static void JK() {
        com.baidu.tbadk.core.util.bb.vQ().a(new co());
    }
}
