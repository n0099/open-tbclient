package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes5.dex */
public class SSWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31100a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebView(Context context) {
        super(a(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f31100a = false;
        b(a(context));
    }

    public static Context a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
        }
        return (Context) invokeL.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            c(context);
            b();
            a();
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (settings = getSettings()) == null) {
                    return;
                }
                if (str.startsWith("file://")) {
                    settings.setJavaScriptEnabled(false);
                } else {
                    settings.setJavaScriptEnabled(true);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return super.canGoBack();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            try {
                return super.canGoBackOrForward(i2);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return super.canGoForward();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            try {
                super.clearCache(z);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                super.clearFormData();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                super.clearHistory();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                super.computeScroll();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return super.getContentHeight();
            } catch (Exception unused) {
                return 1;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        String url;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                String originalUrl = super.getOriginalUrl();
                return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = super.getUrl()) == null) ? originalUrl : url.startsWith("file://") ? url : originalUrl;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                return super.getProgress();
            } catch (Exception unused) {
                return 100;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return super.getUrl();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                super.goBack();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            try {
                super.goBackOrForward(i2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                super.goForward();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, str2, str3) == null) {
            try {
                super.loadData(str, str2, str3);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048592, this, str, str2, str3, str4, str5) == null) {
            try {
                setJavaScriptEnabled(str);
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public void loadUrl(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, map) == null) {
            try {
                setJavaScriptEnabled(str);
                super.loadUrl(str, map);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent a2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            try {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                if (motionEvent.getActionMasked() == 0 && this.f31100a && (a2 = a(this)) != null) {
                    a2.requestDisallowInterceptTouchEvent(true);
                }
                return onTouchEvent;
            } catch (Throwable unused) {
                return super.onTouchEvent(motionEvent);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, bArr) == null) {
            try {
                setJavaScriptEnabled(str);
                super.postUrl(str, bArr);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                super.reload();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            try {
                super.setBackgroundColor(i2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, downloadListener) == null) {
            try {
                super.setDownloadListener(downloadListener);
            } catch (Exception unused) {
            }
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f31100a = z;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setLayerType(int i2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i2, paint) == null) {
            try {
                super.setLayerType(i2, paint);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            try {
                super.setNetworkAvailable(z);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            try {
                super.setOverScrollMode(i2);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, webChromeClient) == null) {
            try {
                super.setWebChromeClient(webChromeClient);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, webViewClient) == null) {
            try {
                super.setWebViewClient(webViewClient);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            try {
                super.stopLoading();
            } catch (Exception unused) {
            }
        }
    }

    private ViewParent a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view)) == null) {
            ViewParent parent = view.getParent();
            return ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof ScrollingView) || !(parent instanceof View)) ? parent : a((View) parent);
        }
        return (ViewParent) invokeL.objValue;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            try {
                setJavaScriptEnabled(str);
                super.loadUrl(str);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31100a = false;
        b(a(context));
    }

    private void b() {
        WebSettings settings;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (settings = getSettings()) == null) {
            return;
        }
        settings.setSavePassword(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f31100a = false;
        b(a(context));
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        }
    }
}
