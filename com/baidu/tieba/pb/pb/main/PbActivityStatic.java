package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class PbActivityStatic {
    private static BdAsyncTaskParallel ewD = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    static {
        adF();
        MF();
        aOn();
        aOp();
        aOr();
        aOq();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_PB_ACTIVITY, new cv());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        aod();
        aOo();
        cw cwVar = new cw();
        cwVar.setSelfExecute(true);
        cwVar.setPriority(4);
        cwVar.execute(new Void[0]);
    }

    private static void MF() {
        com.baidu.tieba.tbadkCore.a.a.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.ax("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        LocationModel.bnf();
    }

    private static void aOn() {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.PB_PAGE_CACHE_CMD, hm.class);
    }

    private static void aOo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_APPLY_COPY_THREAD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.URL_APPLY_COPY_THREAD);
        tbHttpMessageTask.setResponsedClass(ApplyCopyThreadResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void adF() {
        com.baidu.tbadk.ala.b.nv().a(2, new cx());
        com.baidu.tbadk.ala.b.nv().a(3, new cy());
        com.baidu.tbadk.ala.b.nv().a(4, new cz());
        com.baidu.tbadk.ala.b.nv().a(6, new da());
    }

    private static void aOp() {
        TbadkCoreApplication.m9getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(ewD);
        a2.setParallel(ewD);
    }

    private static void aOq() {
        TbadkCoreApplication.m9getInst().RegisterIntent(PbSearchEmotionActivityConfig.class, PbSearchEmotionActivity.class);
    }

    private static void aOr() {
        TbadkCoreApplication.m9getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }

    private static void aod() {
        com.baidu.tbadk.core.util.be.vP().a(new db());
    }
}
