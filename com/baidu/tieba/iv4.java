package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.adBillingLog.AdBillingLogHttpResMsg;
import com.baidu.tbadk.adBillingLog.AdBillingLogReqMsg;
import com.baidu.tbadk.adBillingLog.AdBillingLogSocketResMsg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947866946, "Lcom/baidu/tieba/iv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947866946, "Lcom/baidu/tieba/iv4;");
                return;
            }
        }
        aba.f(309711, AdBillingLogSocketResMsg.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_BILLING_LOG, aba.a(TbConfig.URL_AD_BILLING_LOG, 309711));
        tbHttpMessageTask.setResponsedClass(AdBillingLogHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public iv4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
            AdBillingLogReqMsg adBillingLogReqMsg = new AdBillingLogReqMsg();
            adBillingLogReqMsg.setReqData(jv4Var);
            MessageManager.getInstance().sendMessage(adBillingLogReqMsg);
        }
    }
}
