package com.baidu.tieba.redpackage;

import android.os.Build;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.fsg.base.statistics.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ah;
import com.xiaomi.mipush.sdk.Constants;
import org.apache.http.cookie.SM;
/* loaded from: classes9.dex */
public class a {
    public a(TbPageContext tbPageContext) {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NEW_USER_GET_MONEY, TbConfig.NEW_USER_GET_MONEY_URL);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(NewUserGetMoneyResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void cVG() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEW_USER_GET_MONEY);
        httpMessage.addParam(Constants.PHONE_BRAND, Build.BRAND);
        httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        httpMessage.addParam("client_version", TbadkCoreApplication.getInst().getVersionName());
        httpMessage.addParam("client_type", "Android");
        httpMessage.addParam("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
        httpMessage.addParam(j.c, ah.getUserAgent());
        httpMessage.addHeader(SM.COOKIE, CookieManager.getInstance().getCookie("tieba.baidu.com"));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
