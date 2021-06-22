package com.baidu.tieba.tbean;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.tbean.message.GetBigTbeanWalletH5ResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiHttpResponseMessage;
import com.baidu.tieba.tbean.message.GetYinJiResponseMessage;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import d.a.n0.z0.n0;
/* loaded from: classes5.dex */
public class BuyTBeanActivityStatic {

    /* loaded from: classes5.dex */
    public static class a implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (str.contains("tdoudiscount:")) {
                    CurrencyJumpHelper.gotoBuyTBeanPage(tbPageContext.getPageActivity(), 0.0f, n0.d(str, MemberPayStatistic.REFER_PAGE), n0.d(str, MemberPayStatistic.CLICK_ZONE));
                    return 0;
                }
                Bundle i2 = n0.i(str);
                if (i2 != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && UrlSchemaHelper.PAY_TBEAN_PAGE.equalsIgnoreCase(i2.getString("path"))) {
                    CurrencyJumpHelper.gotoBuyTBeanPage(tbPageContext.getPageActivity(), 0.0f, n0.d(str, MemberPayStatistic.REFER_PAGE), n0.d(str, MemberPayStatistic.CLICK_ZONE));
                    return 0;
                }
            }
            return 3;
        }
    }

    static {
        TbadkApplication.getInst().RegisterIntent(BuyTBeanActivityConfig.class, BuyTBeanActivity.class);
        d.a.o0.e3.d0.a.f(306001, GetYinJiResponseMessage.class, false);
        c();
        a();
        b();
    }

    public static void a() {
        UrlManager.getInstance().addListener(new a());
    }

    public static void b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_BIG_TBEAN_URL, TbConfig.SERVER_ADDRESS + BuyTBeanModel.GET_BIG_TBEAN_WALLET_H5);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(GetBigTbeanWalletH5ResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_YINJI, d.a.o0.e3.d0.a.a(BuyTBeanModel.GET_ICON_URL, 306001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(GetYinJiHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
