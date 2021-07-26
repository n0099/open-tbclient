package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.z;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f31157d;

    /* renamed from: e  reason: collision with root package name */
    public static int f31158e = 10;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f31159g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<SSWebView> f31160a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, x> f31161b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, com.bytedance.sdk.openadsdk.h.b> f31162c;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f31163f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1282682245, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1282682245, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/f;");
                return;
            }
        }
        f31157d = new byte[0];
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31163f = new AtomicBoolean(false);
        this.f31160a = new ArrayList();
        this.f31161b = new HashMap();
        this.f31162c = new HashMap();
        f31158e = o.h().H();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31159g == null) {
                synchronized (f.class) {
                    if (f31159g == null) {
                        f31159g = new f();
                    }
                }
            }
            return f31159g;
        }
        return (f) invokeV.objValue;
    }

    @Nullable
    public SSWebView b() {
        InterceptResult invokeV;
        SSWebView remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (d() > 0 && (remove = this.f31160a.remove(0)) != null) {
                k.b("WebViewPool", "get WebView from pool; current available count: " + d());
                return remove;
            }
            return null;
        }
        return (SSWebView) invokeV.objValue;
    }

    public boolean c(SSWebView sSWebView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sSWebView)) == null) {
            if (sSWebView == null) {
                return false;
            }
            k.b("WebViewPool", "WebView render fail and abandon");
            sSWebView.destroy();
            return true;
        }
        return invokeL.booleanValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31160a.size() : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31160a.size() : invokeV.intValue;
    }

    private void e(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, sSWebView) == null) {
            sSWebView.removeAllViews();
            sSWebView.stopLoading();
            sSWebView.setWebChromeClient(null);
            sSWebView.setWebViewClient(null);
            sSWebView.setDownloadListener(null);
            sSWebView.getSettings().setJavaScriptEnabled(true);
            sSWebView.getSettings().setAppCacheEnabled(false);
            sSWebView.getSettings().setSupportZoom(false);
            sSWebView.getSettings().setUseWideViewPort(true);
            sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.getSettings().setDomStorageEnabled(true);
            sSWebView.getSettings().setBuiltInZoomControls(false);
            sSWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            sSWebView.getSettings().setLoadWithOverviewMode(false);
            sSWebView.getSettings().setUserAgentString("android_client");
            sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
            sSWebView.getSettings().setDefaultFontSize(16);
        }
    }

    public void d(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        x xVar = this.f31161b.get(Integer.valueOf(sSWebView.hashCode()));
        if (xVar != null) {
            xVar.a(null);
        }
        sSWebView.removeJavascriptInterface("SDK_INJECT_GLOBAL");
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (SSWebView sSWebView : this.f31160a) {
                if (sSWebView != null) {
                    sSWebView.destroy();
                }
            }
            this.f31160a.clear();
        }
    }

    public void b(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        if (this.f31160a.size() >= f31158e) {
            k.b("WebViewPool", "WebView pool is full，destroy webview");
            sSWebView.destroy();
            return;
        }
        this.f31160a.add(sSWebView);
        k.b("WebViewPool", "recycle WebView，current available count: " + d());
    }

    @UiThread
    public void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        e(sSWebView);
        sSWebView.removeJavascriptInterface("SDK_INJECT_GLOBAL");
        d(sSWebView);
        b(sSWebView);
    }

    @SuppressLint({"JavascriptInterface"})
    public void a(SSWebView sSWebView, w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, sSWebView, wVar) == null) || sSWebView == null || wVar == null) {
            return;
        }
        x xVar = this.f31161b.get(Integer.valueOf(sSWebView.hashCode()));
        if (xVar != null) {
            xVar.a(wVar);
        } else {
            xVar = new x(wVar);
            this.f31161b.put(Integer.valueOf(sSWebView.hashCode()), xVar);
        }
        sSWebView.addJavascriptInterface(xVar, "SDK_INJECT_GLOBAL");
    }

    @SuppressLint({"JavascriptInterface"})
    public void a(WebView webView, z zVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, webView, zVar, str) == null) || webView == null || zVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.b bVar = this.f31162c.get(Integer.valueOf(webView.hashCode()));
        if (bVar != null) {
            bVar.a(zVar);
        } else {
            bVar = new com.bytedance.sdk.openadsdk.h.b(zVar);
            this.f31162c.put(Integer.valueOf(webView.hashCode()), bVar);
        }
        webView.addJavascriptInterface(bVar, str);
    }

    public void a(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) || webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.b bVar = this.f31162c.get(Integer.valueOf(webView.hashCode()));
        if (bVar != null) {
            bVar.a(null);
        }
        webView.removeJavascriptInterface(str);
    }
}
