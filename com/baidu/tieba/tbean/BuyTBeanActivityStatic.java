package com.baidu.tieba.tbean;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class BuyTBeanActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        com.baidu.tieba.tbadkCore.a.a.c(306001, GetYinJiResponseMessage.class, false);
        anF();
    }

    private static void anF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_YINJI, com.baidu.tieba.tbadkCore.a.a.R("c/e/pay/geticonlist", 306001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(GetYinJiHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
