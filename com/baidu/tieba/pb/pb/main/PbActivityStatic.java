package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class PbActivityStatic {
    private static BdAsyncTaskParallel ekp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        ZD();
        Kj();
        aKX();
        aKZ();
        aLa();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new ch());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        Kk();
        aKY();
        ci ciVar = new ci();
        ciVar.setSelfExecute(true);
        ciVar.setPriority(4);
        ciVar.execute(new Void[0]);
    }

    private static void Kj() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.av("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.biZ();
    }

    private static void aKX() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, gk.class);
    }

    private static void aKY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void ZD() {
        com.baidu.tbadk.ala.c.oa().a(2, new cj());
        com.baidu.tbadk.ala.c.oa().a(3, new ck());
        com.baidu.tbadk.ala.c.oa().a(4, new cl());
    }

    private static void aKZ() {
        TbadkCoreApplication.m9getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(ekp);
        a2.setParallel(ekp);
    }

    private static void aLa() {
        TbadkCoreApplication.m9getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void Kk() {
        com.baidu.tbadk.core.util.bb.wn().a(new cm());
    }
}
