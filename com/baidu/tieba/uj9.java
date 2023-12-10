package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.browser.IBrowserView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.medialive.browser.HkMWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uj9 implements IBrowserView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbWebView a;
    public FrameLayout b;
    public View c;
    public View d;
    public View e;
    public IBrowserView.OnBrowserStatusChangeCallBack f;
    public boolean g;

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDynamicDispatcherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnLongPressListener(IBrowserView.OnLongPressListener onLongPressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongPressListener) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setStateViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setUpSelect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj9 a;

        public a(uj9 uj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj9Var;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.i();
                if (this.a.f != null) {
                    this.a.f.onHideLoading();
                }
                if (this.a.g) {
                    this.a.j();
                    if (this.a.f != null) {
                        this.a.f.onLoadFailure();
                    }
                } else if (this.a.f != null) {
                    this.a.f.onLoadSuccess();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.g = false;
                this.a.k();
                this.a.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                this.a.g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                this.a.g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || (currentActivity = BdActivityStack.getInst().currentActivity()) == null) {
                    return false;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(currentActivity), new String[]{str}, true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public uj9() {
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
        this.g = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbWebView tbWebView = this.a;
            if (tbWebView != null && tbWebView.getController().a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void goBack() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tbWebView = this.a) != null) {
            tbWebView.getController().c();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tbWebView = this.a) != null) {
            tbWebView.onDestroy();
            this.a = null;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tbWebView = this.a) != null) {
            tbWebView.getController().d();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            TbWebView tbWebView = this.a;
            if (tbWebView != null) {
                return tbWebView.canScrollVertically(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(@NonNull String str) {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (tbWebView = this.a) != null) {
            tbWebView.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setErrorView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            this.c = view2;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            this.d = view2;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(@NonNull IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onBrowserStatusChangeCallBack) == null) {
            this.f = onBrowserStatusChangeCallBack;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    @NonNull
    public View getView(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.b == null) {
                this.b = new FrameLayout(context);
            }
            if (this.e == null) {
                View view2 = new View(context);
                this.e = view2;
                view2.setBackgroundColor(context.getResources().getColor(17170443));
            }
            if (this.a == null) {
                TbWebView tbWebView = new TbWebView(context);
                this.a = tbWebView;
                tbWebView.setDownloadListener(new HkMWebView.b(context));
                this.a.setWebViewClient(new a(this));
            }
            this.b.addView(this.a);
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.d != null && this.e.getParent() != null) {
                ((ViewGroup) this.e.getParent()).removeView(this.e);
            }
            View view2 = this.c;
            if (view2 != null && view2.getParent() != null) {
                ((ViewGroup) this.c.getParent()).removeView(this.c);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.d != null && this.e.getParent() != null) {
                ((ViewGroup) this.e.getParent()).removeView(this.e);
            }
            View view2 = this.d;
            if (view2 != null && view2.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
        }
    }

    public final void j() {
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.b != null && (view3 = this.e) != null && view3.getParent() == null) {
                this.b.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.b != null && (view2 = this.c) != null && view2.getParent() == null) {
                this.b.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    public final void k() {
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.b != null && (view3 = this.e) != null && view3.getParent() == null) {
                this.b.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.b != null && (view2 = this.d) != null && view2.getParent() == null) {
                this.b.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }
}
