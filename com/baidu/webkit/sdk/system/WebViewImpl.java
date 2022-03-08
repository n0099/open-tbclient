package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.ManifestInfoCallback;
import com.baidu.webkit.sdk.PageTransformer;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebAppShortcutDataListener;
import com.baidu.webkit.sdk.WebBackForwardList;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebMessage;
import com.baidu.webkit.sdk.WebMessageListener;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.baidu.webkit.sdk.WebViewProvider;
import com.baidu.webkit.sdk.performance.PagePerformanceTiming;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.io.BufferedWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes6.dex */
public final class WebViewImpl extends WebView implements WebViewProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WebView.DelegateAdapter mDelegate;
    public WebSettings mSettings;
    public WebChromeClient mWebChromeClient;
    public final com.baidu.webkit.sdk.WebView mWebView;
    public WebViewClient mWebViewClient;
    public final WebView.PrivateAccess mWebViewPrivateAccess;

    /* loaded from: classes6.dex */
    public class FindAdapter implements WebView.FindListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebView.FindListener mListener;
        public final /* synthetic */ WebViewImpl this$0;

        public FindAdapter(WebViewImpl webViewImpl, WebView.FindListener findListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewImpl, findListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webViewImpl;
            this.mListener = findListener;
        }

        @Override // android.webkit.WebView.FindListener
        public void onFindResultReceived(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
                this.mListener.onFindResultReceived(i2, i3, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class PictureAdapter implements WebView.PictureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WebView.PictureListener mListener;
        public final /* synthetic */ WebViewImpl this$0;

        public PictureAdapter(WebViewImpl webViewImpl, WebView.PictureListener pictureListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewImpl, pictureListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webViewImpl;
            this.mListener = pictureListener;
        }

        @Override // android.webkit.WebView.PictureListener
        public void onNewPicture(android.webkit.WebView webView, Picture picture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, picture) == null) {
                this.mListener.onNewPicture(((WebViewImpl) webView).getWebView(), picture);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class WebViewTransportImpl extends WebView.WebViewTransport {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WebView.WebViewTransport mTransport;
        public com.baidu.webkit.sdk.WebView mWebViewGeneric;
        public final /* synthetic */ WebViewImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewTransportImpl(WebViewImpl webViewImpl, com.baidu.webkit.sdk.WebView webView, WebView.WebViewTransport webViewTransport) {
            super(webView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewImpl, webView, webViewTransport};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((com.baidu.webkit.sdk.WebView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webViewImpl;
            Objects.requireNonNull(webView);
            this.mTransport = webViewTransport;
        }

        public WebView.WebViewTransport getTransport() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTransport : (WebView.WebViewTransport) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebView.WebViewTransport
        public synchronized com.baidu.webkit.sdk.WebView getWebView() {
            InterceptResult invokeV;
            com.baidu.webkit.sdk.WebView webView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    webView = this.mWebViewGeneric;
                }
                return webView;
            }
            return (com.baidu.webkit.sdk.WebView) invokeV.objValue;
        }

        @Override // com.baidu.webkit.sdk.WebView.WebViewTransport
        public synchronized void setWebView(com.baidu.webkit.sdk.WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webView) == null) {
                synchronized (this) {
                    this.mWebViewGeneric = webView;
                    this.mTransport.setWebView((android.webkit.WebView) webView.getWebView());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewImpl(com.baidu.webkit.sdk.WebView webView, WebView.PrivateAccess privateAccess) {
        super(webView.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, privateAccess};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebView = webView;
        this.mWebViewPrivateAccess = privateAccess;
        Objects.requireNonNull(webView);
        this.mDelegate = new WebView.DelegateAdapter(webView, this);
    }

    private InputMethodManager getInputMethodManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mWebView.getContext() != null) {
                return (InputMethodManager) this.mWebView.getContext().getSystemService("input_method");
            }
            return null;
        }
        return (InputMethodManager) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void addEmbeddedTitleBarFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void addNoStatePrefetch(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void addWebMessageListener(WebMessageListener webMessageListener, String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webMessageListener, str, strArr) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void addZeusPluginFactory(ZeusPluginFactory zeusPluginFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zeusPluginFactory) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean canGoPrerender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean canZoomIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return super.canZoomIn();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean canZoomOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return super.canZoomOut();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void cancelCurrentNoStatePrefetch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Picture captureHistoryPicture(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4)) == null) {
            return null;
        }
        return (Picture) invokeIII.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Picture capturePicture(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) ? super.capturePicture() : (Picture) invokeCommon.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void capturePicture(int i2, int i3, ValueCallback<Picture> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, valueCallback) == null) || valueCallback == null) {
            return;
        }
        valueCallback.onReceiveValue(super.capturePicture());
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean clearDiskJsCodeCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void clearPrerender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? super.computeVerticalScrollExtent() : invokeV.intValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? super.computeVerticalScrollOffset() : invokeV.intValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public final int computeVerticalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.computeVerticalScrollRange() : invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebBackForwardList copyBackForwardListZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                return WebBackForwardListImpl.from(copyBackForwardList());
            } catch (Exception unused) {
                return null;
            }
        }
        return (WebBackForwardList) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void cutdownUserData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void disableMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, bufferedWriter, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void emulateShiftHeldOnLink() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void emulateShiftHeldOnNormalText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void enableMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(19)
    public final void evaluateJavaScript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, str, valueCallback) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(19)
    public final void evaluateJavaScriptMethod(String str, String str2, String str3, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, str, str2, str3, valueCallback) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(19)
    public final void evaluateJavaScriptOnPrerender(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, valueCallback) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void exitFullScreenMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void extendSelection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(16)
    public final void findAllAsync(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        super.findAllAsync(str);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final View findFocus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? super.findFocus() : (View) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final View findHierarchyView(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, str, i2)) == null) {
            return null;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Bitmap getCanvasCacheBmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int getContentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final String getGpuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public final Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? super.getHandler() : (Handler) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebView.HitTestResult getHitTestResultZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            try {
                return Glue.cast(getHitTestResult());
            } catch (Exception unused) {
                return null;
            }
        }
        return (WebView.HitTestResult) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void getManifestInfo(ManifestInfoCallback manifestInfoCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, manifestInfoCallback) == null) {
            manifestInfoCallback.onManifestInfoFailed();
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final float getMaxZoomScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final float getMinZoomScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final PagePerformanceTiming getPerformanceTiming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return null;
        }
        return (PagePerformanceTiming) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final String getReferer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(26)
    public final boolean getRendererPriorityWaivedWhenNotVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.getRendererPriorityWaivedWhenNotVisible();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(26)
    public final int getRendererRequestedPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.getRendererRequestedPriority();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebViewProvider.ScrollDelegate getScrollDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mDelegate : (WebViewProvider.ScrollDelegate) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean getSelectingText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebSettings getSettingsZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.mSettings == null) {
                this.mSettings = WebSettingsImpl.from(getSettings());
            }
            return this.mSettings;
        }
        return (WebSettings) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final CharSequence getTextFieldText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int getTouchMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final Object getUserData(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048624, this, i2, i3)) == null) {
            return null;
        }
        return invokeII.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebViewProvider.ViewDelegate getViewDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mDelegate : (WebViewProvider.ViewDelegate) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int getVisibleTitleHeightZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (Build.VERSION.SDK_INT < 17) {
                try {
                    Method declaredMethod = android.webkit.WebView.class.getDeclaredMethod("getVisibleTitleHeight", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return ((Integer) declaredMethod.invoke(this, new Object[0])).intValue();
                } catch (Throwable th) {
                    Log.d("huangweichai", "", th);
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void getWebAppShortcutData(WebAppShortcutDataListener webAppShortcutDataListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, webAppShortcutDataListener, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebChromeClient getWebChromeClientZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mWebChromeClient : (WebChromeClient) invokeV.objValue;
    }

    public final com.baidu.webkit.sdk.WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mWebView : (com.baidu.webkit.sdk.WebView) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebViewClient getWebViewClientZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mWebViewClient : (WebViewClient) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final ViewGroup getWebViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void goNextOrPreTextField(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void goPrerender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void hitAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void init(Map<String, Object> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048635, this, map, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void initNet() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void insertTextFieldText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, charSequence) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(23)
    public final void insertVisualStateCallback(long j2, WebView.VisualStateCallback visualStateCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048638, this, j2, visualStateCallback) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        postVisualStateCallback(j2, new WebView.VisualStateCallback(this, visualStateCallback) { // from class: com.baidu.webkit.sdk.system.WebViewImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WebViewImpl this$0;
            public final /* synthetic */ WebView.VisualStateCallback val$callback;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, visualStateCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$callback = visualStateCallback;
            }

            @Override // android.webkit.WebView.VisualStateCallback
            public void onComplete(long j3) {
                WebView.VisualStateCallback visualStateCallback2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeJ(1048576, this, j3) == null) || (visualStateCallback2 = this.val$callback) == null) {
                    return;
                }
                visualStateCallback2.onComplete(j3);
            }
        });
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isAutoShowTitlebar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isMobileSite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean isPrivateBrowsingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return super.isPrivateBrowsingEnabled();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isScrollInProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean isZeusWebViewProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void loadUrl(String str, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048646, this, str, map, z) == null) {
            super.loadUrl(str, map);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void notifyUkmPageLeave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void notifyUnsafeInvolved(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048648, this, i2, str) == null) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onCheckIsTextEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? super.onCheckIsTextEditor() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, motionEvent)) == null) ? this.mWebView.onInterceptTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        WebView.PrivateAccess privateAccess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (privateAccess = this.mWebViewPrivateAccess) == null) {
            return;
        }
        privateAccess.onOverScrolled(i2, i3, z, z2);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void onPageSwapFromWebview(com.baidu.webkit.sdk.WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048652, this, webView, str, z) == null) {
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void onPause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.onPause();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void onPauseAll() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.onResume();
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void onResumeAll() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        WebView.PrivateAccess privateAccess;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048657, this, i2, i3, i4, i5) == null) || (privateAccess = this.mWebViewPrivateAccess) == null) {
            return;
        }
        privateAccess.onScrollChanged(i2, i3, i4, i5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, motionEvent)) == null) ? this.mWebView.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void pauseMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    public final void pauseTimers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            super.pauseTimers();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean performLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.mWebView.performLongClick() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(23)
    public final void postMessageToMainFrame(WebMessage webMessage, Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048662, this, webMessage, uri) == null) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        postWebMessage(Glue.cast(webMessage), uri);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void reinjectJavascriptInterface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void removeHistoryItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void removeJavascriptInterface(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, str) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.removeJavascriptInterface(str);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void resetClearView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void resetLoadingAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebBackForwardList restoreStateZeus(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, bundle)) == null) ? WebBackForwardListImpl.from(restoreState(bundle)) : (WebBackForwardList) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void resumeMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    public final void resumeTimers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            super.resumeTimers();
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean savePageAsLocalFiles(String str, String str2, WebView.SaveAsType saveAsType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048671, this, str, str2, saveAsType)) == null) {
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final WebBackForwardList saveStateZeus(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048672, this, bundle)) == null) ? WebBackForwardListImpl.from(saveState(bundle)) : (WebBackForwardList) invokeL.objValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void saveWebArchive(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048673, this, str) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.saveWebArchive(str);
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{str, Boolean.valueOf(z), valueCallback}) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        super.saveWebArchive(str, z, valueCallback);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void selectionDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void sendFeedback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048676, this, str, str2) == null) {
            Log.v("WebViewImpl", "[houyuqi-feedback] do not upload feedback in system webview");
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setAutoShowTitlebar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setBeginScale() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setBottomControlsHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setCanvasCacheBmp(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bitmap) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setDefaultViewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048681, this, i2, i3) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setEndScale() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(16)
    public final void setFindListener(WebView.FindListener findListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048683, this, findListener) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        setFindListener(findListener != null ? new FindAdapter(findListener) : null);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048684, this, z, pageTransformer) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setPauseSyncActions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setPictureListener(WebView.PictureListener pictureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, pictureListener) == null) {
            setPictureListener(pictureListener != null ? new PictureAdapter(pictureListener) : null);
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean setPreviewZoomScale(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048687, this, f2)) == null) {
            return false;
        }
        return invokeF.booleanValue;
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(26)
    public final void setRendererPriorityPolicy(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        super.setRendererPriorityPolicy(i2, z);
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final boolean setSelectingText(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048689, this, z)) == null) {
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setStatusBar(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048690, this, view, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setTextFieldText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, charSequence) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setTopControlsHeight(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048692, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setUserData(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048693, this, i2, i3, obj) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setVideoPlayerFactory(VideoPlayerFactory videoPlayerFactory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, videoPlayerFactory) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, webChromeClient) == null) {
            super.setWebChromeClient(webChromeClient == null ? null : new WebChromeClientWrapper(this, webChromeClient));
            this.mWebChromeClient = webChromeClient;
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, webViewClient) == null) {
            super.setWebViewClient(webViewClient == null ? null : new WebViewClientWrapper(this, webViewClient));
            this.mWebViewClient = webViewClient;
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048697, this, i2, i3, i4, i5) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewPagerContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, viewGroup) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void setWebViewPagerSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048699, this, i2, i3) == null) {
        }
    }

    @Override // android.webkit.WebView, com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(11)
    public final boolean showFindDialog(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048700, this, str, z)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                return super.showFindDialog(str, z);
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void startLoadingAnimation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, str) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final int startPrerender(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, str)) == null) {
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void stopPrerender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
        }
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, motionEvent)) == null) ? super.onInterceptTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    public final void super_onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048705, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.onOverScrolled(i2, i3, z, z2);
        }
    }

    public final void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048706, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
        }
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, motionEvent)) == null) {
            boolean z = (getInputMethodManager() == null || getInputMethodManager().isActive(this)) ? false : true;
            if (motionEvent.getAction() == 0 && (!this.mWebView.isFocused() || z)) {
                this.mWebView.requestFocus();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean super_performLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? super.performLongClick() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void suspendScheduledTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void switchTitleBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void updateTopControlOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    public final void updateTopControlsState(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
        }
    }

    @Override // com.baidu.webkit.sdk.WebViewProvider
    @TargetApi(21)
    public final boolean zoomByZeus(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048713, this, f2)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                super.zoomBy(f2);
                return true;
            }
            return false;
        }
        return invokeF.booleanValue;
    }
}
