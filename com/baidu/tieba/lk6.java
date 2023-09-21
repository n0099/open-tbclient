package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.browser.core.cache.prerender.WebViewMapper;
import com.baidu.tieba.browser.data.PreRenderMode;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lk6 extends al1<bo6> {
    public static /* synthetic */ Interceptable $ic;
    public static final b a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b implements bo6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends WebViewClient {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ MonitorWebView c;
            public final /* synthetic */ boolean d;

            public a(b bVar, String str, boolean z, MonitorWebView monitorWebView, boolean z2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str, Boolean.valueOf(z), monitorWebView, Boolean.valueOf(z2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = z;
                this.c = monitorWebView;
                this.d = z2;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                PreRenderMode preRenderMode;
                PreRenderMode preRenderMode2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                    super.onPageFinished(webView, str);
                    if (str.startsWith(this.a)) {
                        if (this.b) {
                            MonitorWebView monitorWebView = this.c;
                            if (this.d) {
                                preRenderMode2 = PreRenderMode.MULTI_AUTO_REMOVE;
                            } else {
                                preRenderMode2 = PreRenderMode.ONCE_AUTO_REMOVE;
                            }
                            monitorWebView.setPreRenderMode(preRenderMode2);
                        } else {
                            MonitorWebView monitorWebView2 = this.c;
                            if (this.d) {
                                preRenderMode = PreRenderMode.MULTI;
                            } else {
                                preRenderMode = PreRenderMode.ONCE;
                            }
                            monitorWebView2.setPreRenderMode(preRenderMode);
                        }
                        TbLog hybridLog = HybridLog.getInstance();
                        hybridLog.i("PrerenderManagerFetcher", "onPageFinished， 预渲染成功，url：" + str);
                        return;
                    }
                    ek6.f().k(WebViewMapper.getInstance().getAndRemove(this.a));
                    TbLog hybridLog2 = HybridLog.getInstance();
                    hybridLog2.i("PrerenderManagerFetcher", "onPageFinished， 预渲染失败，url：" + str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i, str, str2) == null) {
                    HybridLog.getInstance().i("PrerenderManagerFetcher", "onReceivedError， 预渲染失败");
                    ek6.f().k(WebViewMapper.getInstance().getAndRemove(this.a));
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                    HybridLog.getInstance().i("PrerenderManagerFetcher", "onReceivedError， 预渲染失败");
                    if (webResourceRequest.isForMainFrame()) {
                        ek6.f().k(WebViewMapper.getInstance().getAndRemove(this.a));
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, webResourceRequest, webResourceResponse) == null) {
                    HybridLog.getInstance().i("PrerenderManagerFetcher", "onReceivedHttpError， 预渲染失败");
                    ek6.f().k(WebViewMapper.getInstance().getAndRemove(this.a));
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, sslErrorHandler, sslError) == null) {
                    HybridLog.getInstance().i("PrerenderManagerFetcher", "onReceivedSslError， 预渲染失败");
                    ek6.f().k(WebViewMapper.getInstance().getAndRemove(this.a));
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, renderProcessGoneDetail)) == null) {
                    WebView andRemove = WebViewMapper.getInstance().getAndRemove(this.a);
                    if (andRemove != null) {
                        andRemove.destroy();
                    }
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                return invokeLL.booleanValue;
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.bo6
        public void a(@NonNull Activity activity, @NonNull String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && !WebViewMapper.getInstance().contain(str)) {
                MonitorWebView j = ek6.f().j(mm6.getContext());
                if (activity != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 1);
                    marginLayoutParams.topMargin = -1;
                    ((ViewGroup) activity.findViewById(16908290)).addView(j, marginLayoutParams);
                }
                j.setWebViewClient(new a(this, str, z2, j, z));
                j.loadUrl(str);
                j.setPreRenderMode(PreRenderMode.NONE);
                WebViewMapper.getInstance().save(str, j, z2);
            }
        }

        @Override // com.baidu.tieba.bo6
        @NonNull
        public WebView b(Context context, @NonNull String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
                WebView andRemove = WebViewMapper.getInstance().getAndRemove(str);
                if (andRemove == null) {
                    return ek6.f().j(context);
                }
                Context context2 = andRemove.getContext();
                if (context2 instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context2).setBaseContext(context);
                    return andRemove;
                }
                return andRemove;
            }
            return (WebView) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.bo6
        public boolean c(@NonNull String str, WebView webView) {
            InterceptResult invokeLL;
            PreRenderMode preRenderMode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, webView)) == null) {
                yn6.d(webView);
                Context context = webView.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(mm6.getContext());
                }
                boolean z = false;
                if (TextUtils.isEmpty(str) || WebViewMapper.getInstance().contain(str)) {
                    return false;
                }
                if ((webView instanceof MonitorWebView) && ((preRenderMode = ((MonitorWebView) webView).getPreRenderMode()) == PreRenderMode.ONCE_AUTO_REMOVE || preRenderMode == PreRenderMode.MULTI_AUTO_REMOVE)) {
                    z = true;
                }
                return WebViewMapper.getInstance().save(str, webView, z);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947945810, "Lcom/baidu/tieba/lk6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947945810, "Lcom/baidu/tieba/lk6;");
                return;
            }
        }
        a = new b(null);
    }

    public lk6() {
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

    public static bo6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (bo6) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.al1
    /* renamed from: a */
    public bo6 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return b();
        }
        return (bo6) invokeV.objValue;
    }
}
