package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.BdToken.NewUserGetMoneyResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jo4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jo4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_NEW_USER_GET_MONEY, TbConfig.NEW_USER_GET_MONEY_URL);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(NewUserGetMoneyResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEW_USER_GET_MONEY);
            if (lx9.b()) {
                httpMessage.addParam("brand", Build.BRAND);
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, lx9.c());
                String g = lx9.g("brand");
                if (!TextUtils.isEmpty(g)) {
                    httpMessage.addParam(g, lx9.e());
                }
            }
            httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            httpMessage.addParam("client_version", TbConfig.getVersion());
            httpMessage.addParam("client_type", "Android");
            httpMessage.addParam("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
            httpMessage.addParam("ua", WebviewHelper.getGlobalUserAgent());
            httpMessage.addHeader("Cookie", CookieManager.getInstance().getCookie("tieba.baidu.com"));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
