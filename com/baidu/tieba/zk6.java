package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.OfflinePkgAutoCleanSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class zk6 extends bo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zk6() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((WebChromeClient) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = OfflinePkgAutoCleanSwitch.isOn();
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = "file://" + sl6.n().m().getAbsolutePath();
            if (str.startsWith(str2)) {
                String[] split = str.substring(str2.length()).split("/");
                if (!mn6.e(split)) {
                    return split[0];
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bo6, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, consoleMessage)) == null) {
            if (this.b && consoleMessage != null && consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR && TextUtils.equals(consoleMessage.message(), "Uncaught SyntaxError: Invalid or unexpected token")) {
                String d = d(consoleMessage.sourceId());
                if (!TextUtils.isEmpty(d)) {
                    sl6.n().h(d);
                }
            }
            return super.onConsoleMessage(consoleMessage);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bo6, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, jsResult)) == null) {
            if (kg.e(im6.a(webView.getContext()))) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bo6, android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
            if (kg.e(im6.a(webView.getContext()))) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bo6, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
            if (kg.e(im6.a(webView.getContext()))) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bo6, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, webView, str, str2, str3, jsPromptResult)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (um6.a().c(webView, str2, jsPromptResult)) {
                gn6.c("newHybrid", "端能力执行完成：" + str2 + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                return true;
            }
            gn6.c("newHybrid", "端能力执行成功：" + str2 + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis));
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
