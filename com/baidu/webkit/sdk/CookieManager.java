package com.baidu.webkit.sdk;

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
/* loaded from: classes6.dex */
public class CookieManager {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final CookieManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean mFlushAsyncing;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-46691290, "Lcom/baidu/webkit/sdk/CookieManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-46691290, "Lcom/baidu/webkit/sdk/CookieManager;");
                return;
            }
        }
        mInstance = new CookieManager();
    }

    public CookieManager() {
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

    public static boolean allowFileSchemeCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? getInstance().allowFileSchemeCookiesImpl() : invokeV.booleanValue;
    }

    public static CookieManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? mInstance : (CookieManager) invokeV.objValue;
    }

    public static void setAcceptFileSchemeCookies(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) && WebViewFactory.hasProvider()) {
            getInstance().setAcceptFileSchemeCookiesImpl(z);
        }
    }

    public boolean acceptCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getCookieManager().acceptCookie();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean acceptThirdPartyCookies(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView)) == null) {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getCookieManager().acceptThirdPartyCookies(webView);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean allowFileSchemeCookiesImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getCookieManager().allowFileSchemeCookiesImpl();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new CloneNotSupportedException("doesn't implement Cloneable");
        }
        return invokeV.objValue;
    }

    public void flush() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().flush();
        }
    }

    public void flushAsync() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mFlushAsyncing) {
            return;
        }
        this.mFlushAsyncing = true;
        if (WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().flushAsync();
        }
        this.mFlushAsyncing = false;
    }

    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? !WebViewFactory.hasProvider() ? "" : WebViewFactory.getProvider().getCookieManager().getCookie(str) : (String) invokeL.objValue;
    }

    public void getCookieAsync(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, valueCallback) == null) {
            if (WebViewFactory.hasProvider()) {
                WebViewFactory.getProvider().getCookieManager().getCookieAsync(str, valueCallback);
            } else {
                valueCallback.onReceiveValue("");
            }
        }
    }

    public boolean hasCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (WebViewFactory.hasProvider()) {
                return WebViewFactory.getProvider().getCookieManager().hasCookies();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void removeAllCookie() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeAllCookie();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, valueCallback) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeAllCookies(valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeExpiredCookie();
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeSessionCookie();
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, valueCallback) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().removeSessionCookies(valueCallback);
        }
    }

    public void setAcceptCookie(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setAcceptCookie(z);
        }
    }

    public void setAcceptFileSchemeCookiesImpl(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setAcceptFileSchemeCookiesImpl(z);
        }
    }

    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048592, this, webView, z) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setAcceptThirdPartyCookies(webView, z);
        }
    }

    public void setCookie(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setCookie(str, str2);
        }
    }

    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048594, this, str, str2, valueCallback) == null) && WebViewFactory.hasProvider()) {
            WebViewFactory.getProvider().getCookieManager().setCookie(str, str2, valueCallback);
        }
    }

    public void setCookieAsync(String str, String str2, ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, str, str2, valueCallback) == null) {
            setCookie(str, str2, valueCallback);
        }
    }
}
