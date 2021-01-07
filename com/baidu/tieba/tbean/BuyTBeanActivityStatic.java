package com.baidu.tieba.tbean;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.tbean.message.GetBigTbeanWalletH5ResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiResponseMessage;
/* loaded from: classes9.dex */
public class BuyTBeanActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_GET_YINJI, GetYinJiResponseMessage.class, false);
        registerGetYinJiHttpTask();
        registerBuyTbeanJump();
        dRk();
    }

    private static void registerGetYinJiHttpTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001533, com.baidu.tieba.tbadkCore.a.a.bU(BuyTBeanModel.GET_ICON_URL, CmdConfigSocket.CMD_GET_YINJI));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(GetYinJiHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void dRk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003410, TbConfig.SERVER_ADDRESS + "tbmall/getPayUrl");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(GetBigTbeanWalletH5ResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void registerBuyTbeanJump() {
        be.bwv().a(new be.a() { // from class: com.baidu.tieba.tbean.BuyTBeanActivityStatic.1
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (str.contains("tdoudiscount:")) {
                    String paramFromURL = ai.getParamFromURL(str, "refer_page");
                    String paramFromURL2 = ai.getParamFromURL(str, "click_zone");
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(paramFromURL, paramFromURL2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return 0;
                }
                Bundle parserQuery = ai.parserQuery(str);
                if (parserQuery != null && str.contains("jump_tieba_native=1") && UrlSchemaHelper.PAY_TBEAN_PAGE.equalsIgnoreCase(parserQuery.getString("path"))) {
                    String paramFromURL3 = ai.getParamFromURL(str, "refer_page");
                    String paramFromURL4 = ai.getParamFromURL(str, "click_zone");
                    BuyTBeanActivityConfig buyTBeanActivityConfig2 = new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig2.setReferPageAndClickZone(paramFromURL3, paramFromURL4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig2));
                    return 0;
                }
                return 3;
            }
        });
    }
}
