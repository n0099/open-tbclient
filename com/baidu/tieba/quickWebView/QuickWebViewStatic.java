package com.baidu.tieba.quickWebView;

import c.a.p0.i3.d0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class QuickWebViewStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-841247476, "Lcom/baidu/tieba/quickWebView/QuickWebViewStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-841247476, "Lcom/baidu/tieba/quickWebView/QuickWebViewStatic;");
                return;
            }
        }
        a.h(309485, WebViewCacheResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, a.a(TbConfig.WEBVIEW_CACHE_URL, 309485));
        tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
        if (TbSingleton.getInstance().isDebugToolMode()) {
            if (MessageManager.getInstance().findTask(tbHttpMessageTask.getCmd()) == null) {
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                return;
            }
            return;
        }
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public QuickWebViewStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
