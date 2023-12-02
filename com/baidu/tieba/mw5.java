package com.baidu.tieba;

import android.app.Activity;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mw5 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public cxa b;

    public mw5(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
    }

    public void b(cxa cxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cxaVar) == null) {
            this.b = cxaVar;
        }
    }

    public final void a(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, str2) == null) && webView != null && !rd.isEmpty(str) && !rd.isEmpty(str2)) {
            webView.evaluateJavascript("javascript:" + str + "('" + str2 + "')", null);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            quotaUpdater.updateQuota(j2 * 2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, webView, str, str2, jsResult)) == null) {
            if (yb.e(this.a)) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, webView, str, str2, jsResult)) == null) {
            if (yb.e(this.a)) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, webView, str, str2, jsResult)) == null) {
            if (yb.e(this.a)) {
                return super.onJsConfirm(webView, str, str2, jsResult);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        cxa cxaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!c95.a(str) && str2.startsWith("tiebaapp")) {
                fxa fxaVar = new fxa();
                fxaVar.w(jxa.b(str2));
                fxaVar.y(301);
                a(webView, fxaVar.c(), fxaVar.d());
            }
            if (c95.a(str) && (cxaVar = this.b) != null && cxaVar.onJsPrompt(str2, jsPromptResult)) {
                return true;
            }
            jsPromptResult.cancel();
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
