package com.baidu.tieba.medialive.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.lr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class HkMWebView extends BaseWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HkMWebView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HkMWebView hkMWebView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hkMWebView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hkMWebView;
        }

        @Override // com.baidu.tieba.medialive.browser.HkMWebView.c, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.baidu.tieba.medialive.browser.HkMWebView.c, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                if (this.a.getPackageManager().resolveActivity(intent, 0) == null) {
                    BdUtilHelper.showToast("您的手机未安装任何浏览器应用，无法完成下载", 0, false);
                } else {
                    this.a.startActivity(intent);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                HkMWebView.setLightTouchEnabled(webView);
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, renderProcessGoneDetail)) == null) {
                lr4.a("HkMWebView", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                try {
                    if (this.a != null) {
                        if (str.startsWith("tel:")) {
                            this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
                            return true;
                        } else if (str.startsWith("wtai://wp/mc;")) {
                            this.a.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("tel:" + str.substring(13))));
                            return true;
                        } else if (str.startsWith("mailto:")) {
                            this.a.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HkMWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HkMWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }

    public static void setLightTouchEnabled(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, webView) == null) {
            webView.loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {   var bodystyle = document.body.style.cssText;   if (bodystyle == undefined || bodystyle == null)      bodystyle = '';   var tapstylekey = '-webkit-tap-highlight-color';   if (bodystyle.indexOf(tapstylekey) < 0) {      bodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';      document.body.style.cssText = bodystyle;   }}\");");
            webView.loadUrl("javascript:SetBodyStyleTapColor();");
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            super.loadUrl(str);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setScrollbarFadingEnabled(true);
            setVerticalScrollBarEnabled(true);
            setHorizontalScrollBarEnabled(false);
            getSettings().setLightTouchEnabled(true);
            getSettings().setDefaultTextEncodingName("UTF-8");
            getSettings().setSupportZoom(true);
            getSettings().setJavaScriptEnabled(true);
            getSettings().setAllowFileAccess(false);
            getSettings().setUseWideViewPort(true);
            getSettings().setSupportMultipleWindows(true);
            getSettings().setPluginState(WebSettings.PluginState.ON);
            getSettings().setCacheMode(-1);
            getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            getSettings().setAllowContentAccess(true);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
            }
            getSettings().setDomStorageEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                getSettings().setMixedContentMode(0);
            }
            setWebViewClient(new a(this, getContext()));
            clearFocus();
            clearHistory();
            clearView();
            setScrollBarStyle(0);
            initCommonJsBridge(getContext());
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.removeAllViews();
            super.destroy();
        }
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, str2, str3, str4, str5) == null) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, map) == null) {
            super.loadUrl(str, map);
        }
    }
}
