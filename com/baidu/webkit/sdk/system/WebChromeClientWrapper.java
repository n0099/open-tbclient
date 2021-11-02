package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
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
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.system.GeolocationPermissionsImpl;
import com.baidu.webkit.sdk.system.WebStorageImpl;
import com.baidu.webkit.sdk.system.WebViewImpl;
import java.util.Objects;
/* loaded from: classes11.dex */
public final class WebChromeClientWrapper extends WebChromeClient {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.baidu.webkit.sdk.WebChromeClient mClient;
    public final WebViewImpl mWebView;

    /* renamed from: com.baidu.webkit.sdk.system.WebChromeClientWrapper$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class CustomViewCallbackImpl implements WebChromeClient.CustomViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebChromeClient.CustomViewCallback mCallback;

        public CustomViewCallbackImpl(WebChromeClient.CustomViewCallback customViewCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customViewCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallback = customViewCallback;
        }

        public /* synthetic */ CustomViewCallbackImpl(WebChromeClient.CustomViewCallback customViewCallback, AnonymousClass1 anonymousClass1) {
            this(customViewCallback);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mCallback.onCustomViewHidden();
            }
        }
    }

    @TargetApi(21)
    /* loaded from: classes11.dex */
    public static class FileChooserParamsImpl extends WebChromeClient.FileChooserParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebChromeClient.FileChooserParams mImpl;

        public FileChooserParamsImpl(WebChromeClient.FileChooserParams fileChooserParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileChooserParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mImpl = fileChooserParams;
        }

        public /* synthetic */ FileChooserParamsImpl(WebChromeClient.FileChooserParams fileChooserParams, AnonymousClass1 anonymousClass1) {
            this(fileChooserParams);
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public Intent createIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mImpl.createIntent() : (Intent) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public String[] getAcceptTypes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mImpl.getAcceptTypes() : (String[]) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public String getFilenameHint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImpl.getFilenameHint() : (String) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public int getMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImpl.getMode() : invokeV.intValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public CharSequence getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImpl.getTitle() : (CharSequence) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebChromeClient.FileChooserParams
        public boolean isCaptureEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.isCaptureEnabled() : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(414042325, "Lcom/baidu/webkit/sdk/system/WebChromeClientWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(414042325, "Lcom/baidu/webkit/sdk/system/WebChromeClientWrapper;");
            }
        }
    }

    public WebChromeClientWrapper(WebViewImpl webViewImpl, com.baidu.webkit.sdk.WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webViewImpl, webChromeClient};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClient = webChromeClient;
        this.mWebView = webViewImpl;
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mClient.getDefaultVideoPoster() : (Bitmap) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mClient.getVideoLoadingProgressView() : (View) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, valueCallback) == null) {
            this.mClient.getVisitedHistory(valueCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webView) == null) {
            this.mClient.onCloseWindow(this.mWebView.getWebView());
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) {
            this.mClient.onConsoleMessage(str, i2, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, consoleMessage)) == null) ? this.mClient.onConsoleMessage(consoleMessage) : invokeL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
            WebViewImpl webViewImpl = this.mWebView;
            Objects.requireNonNull(webViewImpl);
            message.obj = new WebViewImpl.WebViewTransportImpl(webViewImpl, this.mWebView.getWebView(), (WebView.WebViewTransport) message.obj);
            boolean onCreateWindow = this.mClient.onCreateWindow(this.mWebView.getWebView(), z, z2, message);
            message.obj = (WebView.WebViewTransport) message.obj;
            return onCreateWindow;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
            this.mClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater == null ? null : new WebStorageImpl.QuotaUpdater(quotaUpdater));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mClient.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, callback) == null) {
            this.mClient.onGeolocationPermissionsShowPrompt(str, callback == null ? null : new GeolocationPermissionsImpl.CallbackWrapper(callback));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mClient.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, webView, str, str2, jsResult)) == null) ? this.mClient.onJsAlert(this.mWebView.getWebView(), str, str2, Glue.cast(jsResult)) : invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, webView, str, str2, jsResult)) == null) ? this.mClient.onJsBeforeUnload(this.mWebView.getWebView(), str, str2, Glue.cast(jsResult)) : invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, webView, str, str2, jsResult)) == null) ? this.mClient.onJsConfirm(this.mWebView.getWebView(), str, str2, Glue.cast(jsResult)) : invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048590, this, webView, str, str2, str3, jsPromptResult)) == null) ? this.mClient.onJsPrompt(this.mWebView.getWebView(), str, str2, str3, Glue.cast(jsPromptResult)) : invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mClient.onJsTimeout() : invokeV.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, permissionRequest) == null) {
            this.mClient.onPermissionRequest(PermissionRequestImpl.from(permissionRequest));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, permissionRequest) == null) {
            this.mClient.onPermissionRequestCanceled(PermissionRequestImpl.from(permissionRequest));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, webView, i2) == null) {
            this.mClient.onProgressChanged(this.mWebView.getWebView(), i2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
            this.mClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater == null ? null : new WebStorageImpl.QuotaUpdater(quotaUpdater));
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, webView, bitmap) == null) {
            this.mClient.onReceivedIcon(this.mWebView.getWebView(), bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, webView, str) == null) {
            this.mClient.onReceivedTitle(this.mWebView.getWebView(), str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048598, this, webView, str, z) == null) {
            this.mClient.onReceivedTouchIconUrl(this.mWebView.getWebView(), str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, webView) == null) {
            this.mClient.onRequestFocus(this.mWebView.getWebView());
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048600, this, view, i2, customViewCallback) == null) {
            this.mClient.onShowCustomView(view, i2, customViewCallback != null ? new CustomViewCallbackImpl(customViewCallback, null) : null);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, view, customViewCallback) == null) {
            this.mClient.onShowCustomView(view, customViewCallback != null ? new CustomViewCallbackImpl(customViewCallback, null) : null);
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, webView, valueCallback, fileChooserParams)) == null) {
            return this.mClient.onShowFileChooser(this.mWebView.getWebView(), valueCallback, fileChooserParams != null ? new FileChooserParamsImpl(fileChooserParams, null) : null);
        }
        return invokeLLL.booleanValue;
    }

    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, valueCallback, str, str2) == null) {
            this.mClient.openFileChooser(valueCallback, str, str2);
        }
    }

    public final void setupAutoFill(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, message) == null) {
            this.mClient.setupAutoFill(message);
        }
    }
}
