package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f67800a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67801b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67802c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67803d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67804e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67805f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67806g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67807h;

    public c(Context context) {
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
        this.f67801b = true;
        this.f67802c = true;
        this.f67803d = true;
        this.f67804e = true;
        this.f67805f = true;
        this.f67806g = true;
        this.f67807h = true;
        this.f67800a = new WeakReference<>(context);
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new c(context) : (c) invokeL.objValue;
    }

    public c b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f67802c = z;
            return this;
        }
        return (c) invokeZ.objValue;
    }

    private void b(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th) {
                k.c(th.toString());
            }
        }
    }

    public c a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f67807h = z;
            return this;
        }
        return (c) invokeZ.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x007a -> B:47:0x007d). Please submit an issue!!! */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView) == null) || webView == null || this.f67800a.get() == null) {
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
            if (this.f67802c) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f67803d);
        settings.setDomStorageEnabled(this.f67804e);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.f67806g);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.f67807h = false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 11 && !this.f67807h) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && this.f67807h) {
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
                k.c(th.toString());
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
