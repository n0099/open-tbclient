package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.q.i;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<SSWebView> f67452a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f67453b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1282682369, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1282682369, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/b;");
        }
    }

    public b() {
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

    private void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        try {
            c.a(o.a()).a(false).a(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            WebSettings settings = sSWebView.getSettings();
            settings.setUserAgentString(i.a(sSWebView, 3703));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
        } catch (Exception e2) {
            k.f("PreLoadWebView", e2.toString());
        }
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f67453b == null) {
                synchronized (f.class) {
                    if (f67453b == null) {
                        f67453b = new b();
                    }
                }
            }
            return f67453b;
        }
        return (b) invokeV.objValue;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String e2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e();
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            SSWebView sSWebView = new SSWebView(o.a());
            f67452a = new WeakReference<>(sSWebView);
            a(sSWebView);
            Uri build = Uri.parse(e2).buildUpon().appendQueryParameter("isPreLoad", "1").build();
            w wVar = new w(o.a());
            wVar.b(sSWebView).a(this).a(sSWebView);
            if (Build.VERSION.SDK_INT >= 17) {
                f.a().a(sSWebView, wVar);
            }
            sSWebView.loadUrl(build.toString());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.a
    public void a() {
        WeakReference<SSWebView> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (weakReference = f67452a) == null || weakReference.get() == null) {
            return;
        }
        f.a().b(f67452a.get());
    }
}
