package com.baidu.tieba.live.tbean;

import android.os.Build;
import android.os.Bundle;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.tieba.f.a.a;
import com.baidu.tieba.live.tbean.message.GetYinJiHttpResponseMessage;
/* loaded from: classes4.dex */
public class BuyTBeanActivityInitialize {
    static {
        if (Build.VERSION.SDK_INT == 26) {
            TbadkCoreApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanFullscreenActivity.class);
        } else {
            TbadkCoreApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        }
        registerGetYinJiHttpTask();
        registerBuyTbeanJump();
    }

    private static void registerGetYinJiHttpTask() {
        a.a(1001533, BuyTBeanModel.GET_ICON_URL, GetYinJiHttpResponseMessage.class, true, true, true, true);
    }

    private static void registerBuyTbeanJump() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanActivityInitialize.1
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (str.contains("tdoudiscount:")) {
                    String paramFromURL = WebviewHelper.getParamFromURL(str, "refer_page");
                    String paramFromURL2 = WebviewHelper.getParamFromURL(str, "click_zone");
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(paramFromURL, paramFromURL2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return 0;
                }
                Bundle parserQuery = WebviewHelper.parserQuery(str);
                if (parserQuery != null && str.contains("jump_tieba_native=1") && UrlSchemaHelper.PAY_TBEAN_PAGE.equalsIgnoreCase(parserQuery.getString("path"))) {
                    String paramFromURL3 = WebviewHelper.getParamFromURL(str, "refer_page");
                    String paramFromURL4 = WebviewHelper.getParamFromURL(str, "click_zone");
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
