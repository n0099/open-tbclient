package com.baidu.tieba;

import android.os.Build;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.BdToken.NewUserGetMoneyResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class oq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oq4() {
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
            httpMessage.addParam(Constants.PHONE_BRAND, Build.BRAND);
            httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            httpMessage.addParam("client_version", TbConfig.getVersion());
            httpMessage.addParam("client_type", "Android");
            httpMessage.addParam("shoubai_cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
            httpMessage.addParam("ua", oq5.e());
            httpMessage.addHeader("Cookie", CookieManager.getInstance().getCookie("tieba.baidu.com"));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
