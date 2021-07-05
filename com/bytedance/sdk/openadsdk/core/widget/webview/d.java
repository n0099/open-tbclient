package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.a.y;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f30860f;

    /* renamed from: g  reason: collision with root package name */
    public static int f30861g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static int f30862h = 3;
    public static volatile d j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<WeakReference<SSWebView>> f30863a;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<SSWebView>> f30864b;

    /* renamed from: c  reason: collision with root package name */
    public List<SSWebView> f30865c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, x> f30866d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, com.bytedance.sdk.openadsdk.i.b> f30867e;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f30868i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1282682307, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1282682307, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/d;");
                return;
            }
        }
        f30860f = new byte[0];
    }

    public d() {
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
        this.f30863a = new ArrayList();
        this.f30864b = new ArrayList();
        this.f30865c = new ArrayList();
        this.f30868i = new AtomicBoolean(false);
        this.f30863a = new ArrayList();
        this.f30864b = new ArrayList();
        this.f30865c = new ArrayList();
        this.f30866d = new HashMap();
        this.f30867e = new HashMap();
        f30861g = o.h().H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            for (int i2 = 0; i2 < f30862h; i2++) {
                SSWebView sSWebView = new SSWebView(o.a());
                sSWebView.loadUrl("about:blank");
                this.f30863a.add(new WeakReference<>(sSWebView));
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f30868i.getAndSet(true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f30869a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30869a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30869a.g();
                    }
                }
            });
        }
    }

    public WeakReference<SSWebView> c() {
        InterceptResult invokeV;
        WeakReference<SSWebView> weakReference;
        WeakReference<SSWebView> weakReference2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j.f("webviewpool", "===start getWebView available:" + this.f30863a.size() + " ,inuse:" + this.f30864b.size());
            synchronized (f30860f) {
                try {
                } catch (Exception unused) {
                    WeakReference<SSWebView> weakReference3 = new WeakReference<>(new SSWebView(o.a()));
                    this.f30864b.add(weakReference3);
                    weakReference = weakReference3;
                }
                if (this.f30863a.size() > 0 && this.f30863a.get(0) != null) {
                    weakReference = this.f30863a.get(0);
                    if (weakReference.get() != null) {
                        this.f30863a.remove(0);
                        this.f30864b.add(weakReference);
                        j.f("webviewpool", "===end getWebView available:" + this.f30863a.size() + " ,inuse:" + this.f30864b.size());
                        weakReference.get().loadUrl("about:blank");
                    } else {
                        this.f30863a.remove(0);
                        weakReference2 = new WeakReference<>(new SSWebView(o.a()));
                        this.f30864b.add(weakReference2);
                    }
                } else {
                    weakReference2 = new WeakReference<>(new SSWebView(o.a()));
                    this.f30864b.add(weakReference2);
                }
                weakReference = weakReference2;
                j.f("webviewpool", "===end getWebView available:" + this.f30863a.size() + " ,inuse:" + this.f30864b.size());
                weakReference.get().loadUrl("about:blank");
            }
            return weakReference;
        }
        return (WeakReference) invokeV.objValue;
    }

    public WeakReference<SSWebView> d() {
        InterceptResult invokeV;
        WeakReference<SSWebView> weakReference;
        SSWebView remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            j.f("webviewpool", "===start getWebView recycle:" + this.f30865c.size() + " ,inuse:" + this.f30864b.size());
            synchronized (f30860f) {
                weakReference = null;
                try {
                    if (this.f30865c.size() > 0 && this.f30865c.get(0) != null && (remove = this.f30865c.remove(0)) != null) {
                        remove.removeJavascriptInterface("SDK_INJECT_GLOBAL");
                        WeakReference<SSWebView> weakReference2 = new WeakReference<>(remove);
                        try {
                            this.f30864b.add(weakReference2);
                            weakReference = weakReference2;
                        } catch (Exception unused) {
                            weakReference = weakReference2;
                        }
                    }
                    j.f("webviewpool", "===end getWebView recycle:" + this.f30865c.size() + " ,inuse:" + this.f30864b.size());
                } catch (Exception unused2) {
                }
            }
            return weakReference;
        }
        return (WeakReference) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30865c.size() : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30865c.size() + this.f30864b.size() : invokeV.intValue;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (j == null) {
                synchronized (d.class) {
                    if (j == null) {
                        j = new d();
                    }
                }
            }
            f30861g = o.h().H();
            return j;
        }
        return (d) invokeV.objValue;
    }

    public void a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, viewGroup, weakReference, z) == null) {
            j.f("webviewpool", "==start recycleWebView:" + this.f30865c.size() + " ,inuse:" + this.f30864b.size());
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            try {
                SSWebView sSWebView = weakReference.get();
                viewGroup.removeView(sSWebView);
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
                synchronized (f30860f) {
                    this.f30864b.remove(weakReference);
                    if (this.f30863a.size() < f30862h) {
                        SSWebView sSWebView2 = new SSWebView(o.a());
                        sSWebView2.loadUrl("about:blank");
                        this.f30863a.add(new WeakReference<>(sSWebView2));
                    }
                    if (!z && this.f30865c.size() < f30861g && !this.f30865c.contains(weakReference.get())) {
                        this.f30865c.add(weakReference.get());
                    } else {
                        sSWebView.destroy();
                    }
                    a(weakReference.get());
                }
                j.f("webviewpool", "==end recycleWebView:" + this.f30865c.size() + " ,inuse:" + this.f30864b.size());
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void a(SSWebView sSWebView, w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, sSWebView, wVar) == null) || sSWebView == null || wVar == null) {
            return;
        }
        x xVar = this.f30866d.get(Integer.valueOf(sSWebView.hashCode()));
        if (xVar != null) {
            xVar.a(wVar);
        } else {
            xVar = new x(wVar);
            this.f30866d.put(Integer.valueOf(sSWebView.hashCode()), xVar);
        }
        sSWebView.addJavascriptInterface(xVar, "SDK_INJECT_GLOBAL");
    }

    public void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        x xVar = this.f30866d.get(Integer.valueOf(sSWebView.hashCode()));
        if (xVar != null) {
            xVar.a(null);
        }
        sSWebView.removeJavascriptInterface("SDK_INJECT_GLOBAL");
    }

    @SuppressLint({"JavascriptInterface"})
    public void a(WebView webView, y yVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, yVar, str) == null) || webView == null || yVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.b bVar = this.f30867e.get(Integer.valueOf(webView.hashCode()));
        if (bVar != null) {
            bVar.a(yVar);
        } else {
            bVar = new com.bytedance.sdk.openadsdk.i.b(yVar);
            this.f30867e.put(Integer.valueOf(webView.hashCode()), bVar);
        }
        webView.addJavascriptInterface(bVar, str);
    }

    public void a(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) || webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.b bVar = this.f30867e.get(Integer.valueOf(webView.hashCode()));
        if (bVar != null) {
            bVar.a(null);
        }
        webView.removeJavascriptInterface(str);
    }
}
