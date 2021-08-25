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
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import c.a.e.e.p.l;
import c.a.p0.m.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
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

    /* renamed from: e  reason: collision with root package name */
    public int f53973e;

    /* renamed from: f  reason: collision with root package name */
    public int f53974f;
    public ValueCallback<Uri> mUploadMessage;
    public String mWebviewUrl;

    /* loaded from: classes7.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HkMWebView f53975c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HkMWebView hkMWebView, HkMWebView hkMWebView2, Activity activity) {
            super(hkMWebView2, activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hkMWebView, hkMWebView2, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HkMWebView) objArr2[0], (Activity) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53975c = hkMWebView;
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

        /* renamed from: a  reason: collision with root package name */
        public HkMWebView f53976a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f53977b;

        public b(HkMWebView hkMWebView, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hkMWebView, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53976a = hkMWebView;
            this.f53977b = activity;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (this.f53977b.getPackageManager().resolveActivity(intent, 0) == null) {
                    l.N(this.f53977b, "您的手机未安装任何浏览器应用，无法完成下载", 0);
                } else {
                    this.f53977b.startActivity(intent);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HkMWebView f53978a;

        /* renamed from: b  reason: collision with root package name */
        public Activity f53979b;

        public c(HkMWebView hkMWebView, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hkMWebView, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53978a = hkMWebView;
            this.f53979b = activity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f53978a.setLightTouchEnabled();
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                this.f53978a.mWebviewUrl = str;
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, renderProcessGoneDetail)) == null) {
                f.a("HkMWebView", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                try {
                    if (this.f53979b != null) {
                        if (str.startsWith("tel:")) {
                            this.f53979b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return true;
                        } else if (str.startsWith("wtai://wp/mc;")) {
                            this.f53979b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + str.substring(13))));
                            return true;
                        } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                            this.f53979b.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53973e = 16777216;
        this.f53974f = 16777216;
        initializeWebView();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mUploadMessage = null;
            super.removeAllViews();
            super.destroy();
        }
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWebviewUrl : (String) invokeV.objValue;
    }

    public void initializeWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                ((Activity) getContext()).getWindow().setFlags(this.f53973e, this.f53974f);
            }
            getSettings().setDomStorageEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                getSettings().setMixedContentMode(0);
            }
            setWebViewClient(new a(this, this, (Activity) getContext()));
            clearFocus();
            clearHistory();
            clearView();
            setScrollBarStyle(0);
            initCommonJsBridge(getContext());
        }
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, str, str2, str3, str4, str5) == null) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.loadUrl(str);
        }
    }

    public void setLightTouchEnabled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            loadUrl("javascript:eval(\"window.SetBodyStyleTapColor=function() {   var bodystyle = document.body.style.cssText;   if (bodystyle == undefined || bodystyle == null)      bodystyle = '';   var tapstylekey = '-webkit-tap-highlight-color';   if (bodystyle.indexOf(tapstylekey) < 0) {      bodystyle += (bodystyle == '' ? '' : ';') + tapstylekey + ':rgba(0,0,0,0);';      document.body.style.cssText = bodystyle;   }}\");");
            loadUrl("javascript:SetBodyStyleTapColor();");
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, map) == null) {
            super.loadUrl(str, map);
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53973e = 16777216;
        this.f53974f = 16777216;
        initializeWebView();
    }
}
