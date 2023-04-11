package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class pc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView a;

    public pc6(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = webView;
        webView.setDrawingCacheEnabled(false);
        webView.setLayerType(2, null);
        webView.setScrollBarStyle(0);
        webView.requestFocusFromTouch();
        if (Build.VERSION.SDK_INT >= 26) {
            webView.setRendererPriorityPolicy(2, false);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WebSettings c = c();
            c.setJavaScriptEnabled(true);
            c.setCacheMode(-1);
            if (Build.VERSION.SDK_INT >= 21) {
                c.setMixedContentMode(0);
            }
            c.setGeolocationEnabled(true);
            c.setLoadsImagesAutomatically(true);
            c.setBlockNetworkImage(false);
            c.setBlockNetworkLoads(false);
            c.setLoadWithOverviewMode(true);
            c.setAllowFileAccess(true);
            c.setUseWideViewPort(true);
            c.setSupportZoom(true);
            c.setBuiltInZoomControls(false);
            c.setDisplayZoomControls(false);
            c.setMediaPlaybackRequiresUserGesture(false);
            c.setDomStorageEnabled(true);
            try {
                c.setAppCacheEnabled(true);
                c.setAppCachePath(b(getContext(), "tb_web_cache").getPath());
            } catch (IOException unused) {
                c.setAppCachePath(getContext().getCacheDir().getPath());
            }
            String userAgentString = c().getUserAgentString();
            String b = bc6.b();
            if (!userAgentString.endsWith(b)) {
                c.setUserAgentString(userAgentString + " " + b);
            }
        }
    }

    public final File b(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            File file = new File(context.getCacheDir(), str);
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException(file.getAbsolutePath() + "文件夹创建失败！");
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public WebSettings c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getSettings();
        }
        return (WebSettings) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.getContext();
        }
        return (Context) invokeV.objValue;
    }
}
