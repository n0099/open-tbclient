package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class GetLotteryChanceActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(GetLotteryChanceActivityConfig.class, GetLotteryChanceActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_LOTTERY_ADD_COUNT, com.baidu.tieba.tbadkCore.a.a.au("c/b/commit/addLotteryCount", 309313));
        tbHttpMessageTask.setResponsedClass(AddLotteryCountHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
