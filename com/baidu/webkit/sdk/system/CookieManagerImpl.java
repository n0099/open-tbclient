package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public final class CookieManagerImpl extends CookieManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread cookieThread;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(639417118, "Lcom/baidu/webkit/sdk/system/CookieManagerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(639417118, "Lcom/baidu/webkit/sdk/system/CookieManagerImpl;");
        }
    }

    public CookieManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @TargetApi(18)
    private void postCookieThreadTask(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, runnable) == null) {
            try {
                if (this.cookieThread == null) {
                    HandlerThread handlerThread = new HandlerThread("T7@cookie_manager_impl");
                    this.cookieThread = handlerThread;
                    handlerThread.start();
                }
                new Handler(this.cookieThread.getLooper()).post(runnable);
            } catch (Throwable unused) {
                HandlerThread handlerThread2 = this.cookieThread;
                if (handlerThread2 != null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 18) {
                            handlerThread2.quitSafely();
                        } else {
                            handlerThread2.quit();
                        }
                    } catch (Throwable unused2) {
                    }
                }
                this.cookieThread = null;
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean acceptCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? android.webkit.CookieManager.getInstance().acceptCookie() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean acceptThirdPartyCookies(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView)) == null) {
            if (Build.VERSION.SDK_INT < 21 || webView == null) {
                return false;
            }
            android.webkit.CookieManager.getInstance().acceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewProvider());
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean allowFileSchemeCookiesImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 12) {
                return android.webkit.CookieManager.allowFileSchemeCookies();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new CloneNotSupportedException("doesn't implement Cloneable");
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void flush() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        android.webkit.CookieManager.getInstance().flush();
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void flushAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            flush();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? android.webkit.CookieManager.getInstance().getCookie(str) : (String) invokeL.objValue;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void getCookieAsync(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, valueCallback) == null) || valueCallback == null) {
            return;
        }
        postCookieThreadTask(new Runnable(this, valueCallback, str) { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CookieManagerImpl this$0;
            public final /* synthetic */ ValueCallback val$fcallback;
            public final /* synthetic */ String val$furl;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, valueCallback, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$fcallback = valueCallback;
                this.val$furl = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.val$fcallback.onReceiveValue(this.this$0.getCookie(this.val$furl));
                }
            }
        });
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final boolean hasCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? android.webkit.CookieManager.getInstance().hasCookies() : invokeV.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeAllCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, valueCallback) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                android.webkit.CookieManager.getInstance().removeAllCookies(valueCallback);
            } else {
                postCookieThreadTask(new Runnable(this, valueCallback) { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CookieManagerImpl this$0;
                    public final /* synthetic */ ValueCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, valueCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = valueCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.removeAllCookie();
                            ValueCallback valueCallback2 = this.val$callback;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue(Boolean.TRUE);
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeExpiredCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeSessionCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, valueCallback) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                android.webkit.CookieManager.getInstance().removeSessionCookies(valueCallback);
            } else {
                postCookieThreadTask(new Runnable(this, valueCallback) { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CookieManagerImpl this$0;
                    public final /* synthetic */ ValueCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, valueCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = valueCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.removeSessionCookie();
                            ValueCallback valueCallback2 = this.val$callback;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue(Boolean.TRUE);
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptCookie(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            android.webkit.CookieManager.getInstance().setAcceptCookie(z);
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptFileSchemeCookiesImpl(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || Build.VERSION.SDK_INT < 12) {
            return;
        }
        android.webkit.CookieManager.setAcceptFileSchemeCookies(z);
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, webView, z) == null) || Build.VERSION.SDK_INT < 21 || webView == null) {
            return;
        }
        android.webkit.CookieManager.getInstance().setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewProvider(), z);
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setCookie(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            android.webkit.CookieManager.getInstance().setCookie(str, str2);
        }
    }

    @Override // com.baidu.webkit.sdk.CookieManager
    public final void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, str2, valueCallback) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2, valueCallback);
            } else {
                postCookieThreadTask(new Runnable(this, str, str2, valueCallback) { // from class: com.baidu.webkit.sdk.system.CookieManagerImpl.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CookieManagerImpl this$0;
                    public final /* synthetic */ ValueCallback val$callback;
                    public final /* synthetic */ String val$url;
                    public final /* synthetic */ String val$value;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, str2, valueCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$url = str;
                        this.val$value = str2;
                        this.val$callback = valueCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.setCookie(this.val$url, this.val$value);
                            ValueCallback valueCallback2 = this.val$callback;
                            if (valueCallback2 != null) {
                                valueCallback2.onReceiveValue(Boolean.TRUE);
                            }
                        }
                    }
                });
            }
        }
    }
}
