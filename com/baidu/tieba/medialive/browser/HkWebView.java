package com.baidu.tieba.medialive.browser;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.medialive.browser.HkMWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class HkWebView extends HkMWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public HkWebView f54172g;

    /* renamed from: h  reason: collision with root package name */
    public Context f54173h;

    /* loaded from: classes7.dex */
    public class a extends HkMWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HkWebView f54174c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HkWebView hkWebView, HkMWebView hkMWebView, Activity activity) {
            super(hkMWebView, activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hkWebView, hkMWebView, activity};
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
            this.f54174c = hkWebView;
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

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                if (-10 == i2) {
                }
            }
        }

        @Override // com.baidu.tieba.medialive.browser.HkMWebView.c, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                if (str.toLowerCase().trim().startsWith("tmall://")) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HkWebView(Context context) {
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
        this.f54172g = this;
        this.f54173h = context;
        init();
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (Error e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return getSettings().getUserAgentString() + " tieba/" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    this.f54172g.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.f54172g.removeJavascriptInterface("accessibility");
                    this.f54172g.removeJavascriptInterface("accessibilityTraversal");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(this.f54173h);
            getSettings().setCacheMode(-1);
            getSettings().setUserAgentString(getUserAgent());
            setDownloadListener(new HkMWebView.b(this.f54172g, (Activity) this.f54173h));
            setWebViewClient(new a(this, this.f54172g, (Activity) this.f54173h));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HkWebView(Context context, AttributeSet attributeSet) {
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
        this.f54172g = this;
        this.f54173h = context;
        init();
    }
}
