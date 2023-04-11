package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webviewx.container.BaseNativeBrowserContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class na1 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final BaseNativeBrowserContainer b;

    @RequiresApi(21)
    /* loaded from: classes5.dex */
    public class a implements a61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebChromeClient.FileChooserParams a;

        public a(na1 na1Var, WebChromeClient.FileChooserParams fileChooserParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na1Var, fileChooserParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.a = fileChooserParams;
        }

        @Override // com.baidu.tieba.a61
        @Nullable
        public Intent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WebChromeClient.FileChooserParams fileChooserParams = this.a;
                if (fileChooserParams != null) {
                    return fileChooserParams.createIntent();
                }
                return null;
            }
            return (Intent) invokeV.objValue;
        }

        @Override // com.baidu.tieba.a61
        @Nullable
        public String[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                WebChromeClient.FileChooserParams fileChooserParams = this.a;
                if (fileChooserParams != null) {
                    return fileChooserParams.getAcceptTypes();
                }
                return null;
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.a61
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                WebChromeClient.FileChooserParams fileChooserParams = this.a;
                if (fileChooserParams != null) {
                    return fileChooserParams.getMode();
                }
                return -1;
            }
            return invokeV.intValue;
        }
    }

    public na1(Context context, BaseNativeBrowserContainer baseNativeBrowserContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseNativeBrowserContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = baseNativeBrowserContainer;
    }

    public final Activity a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webView)) == null) {
            if (webView == null) {
                return null;
            }
            if (webView.getContext() instanceof Activity) {
                return (Activity) webView.getContext();
            }
            if (!(webView.getContext() instanceof MutableContextWrapper) || !(((MutableContextWrapper) webView.getContext()).getBaseContext() instanceof Activity)) {
                return null;
            }
            return (Activity) ((MutableContextWrapper) webView.getContext()).getBaseContext();
        }
        return (Activity) invokeL.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, valueCallback, fileChooserParams)) == null) {
            this.b.s0();
            Activity a2 = a(webView);
            if (a2 != null && Build.VERSION.SDK_INT >= 21) {
                return d61.h(a2, valueCallback, new a(this, fileChooserParams));
            }
            valueCallback.onReceiveValue(null);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
