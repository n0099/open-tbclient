package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f30808a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30809b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30810c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30811d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30812e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30813f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30814g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30815h;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30809b = true;
        this.f30810c = true;
        this.f30811d = true;
        this.f30812e = true;
        this.f30813f = true;
        this.f30814g = true;
        this.f30815h = true;
        this.f30808a = new WeakReference<>(context);
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new a(context) : (a) invokeL.objValue;
    }

    public a b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f30810c = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    private void b(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th) {
                j.b(th.toString());
            }
        }
    }

    public a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f30815h = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x007a -> B:47:0x007d). Please submit an issue!!! */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView) == null) || webView == null || this.f30808a.get() == null) {
            return;
        }
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f30810c) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f30811d);
        settings.setDomStorageEnabled(this.f30812e);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.f30814g);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.f30815h = false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 11 && !this.f30815h) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && this.f30815h) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, webSettings) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    webSettings.setMediaPlaybackRequiresUserGesture(false);
                }
            } catch (Throwable th) {
                j.b(th.toString());
            }
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
                return null;
            }
            String replace = str.replace("{{ad_id}}", str2);
            return "javascript:(function () {    var JS_ACTLOG_URL = '" + replace + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
        }
        return (String) invokeLL.objValue;
    }
}
