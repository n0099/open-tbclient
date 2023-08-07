package com.baidu.tieba;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ow4 extends CookieManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CookieManager a;

    public ow4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = CookieManager.getInstance();
    }

    @Override // android.webkit.CookieManager
    public boolean acceptCookie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.acceptCookie();
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.CookieManager
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.flush();
        }
    }

    @Override // android.webkit.CookieManager
    public boolean hasCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.hasCookies();
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.CookieManager
    public void removeAllCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.removeAllCookie();
        }
    }

    @Override // android.webkit.CookieManager
    public void removeExpiredCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.removeExpiredCookie();
        }
    }

    @Override // android.webkit.CookieManager
    public void removeSessionCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.removeSessionCookie();
        }
    }

    @Override // android.webkit.CookieManager
    public boolean acceptThirdPartyCookies(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView)) == null) {
            return this.a.acceptThirdPartyCookies(webView);
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.a.getCookie(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // android.webkit.CookieManager
    public void removeAllCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, valueCallback) == null) {
            this.a.removeAllCookies(valueCallback);
        }
    }

    @Override // android.webkit.CookieManager
    public void removeSessionCookies(@Nullable ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, valueCallback) == null) {
            this.a.removeSessionCookies(valueCallback);
        }
    }

    @Override // android.webkit.CookieManager
    public void setAcceptCookie(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a.setAcceptCookie(z);
        }
    }

    @Override // android.webkit.CookieManager
    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, webView, z) == null) {
            this.a.setAcceptThirdPartyCookies(webView, z);
        }
    }

    @Override // android.webkit.CookieManager
    public void setCookie(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.a.setCookie(str, str2);
            if (GlobalBuildConfig.isTiebaDebugTool()) {
                this.a.setCookie(".baidu-int.com", str2);
            }
        }
    }

    @Override // android.webkit.CookieManager
    public void setCookie(String str, String str2, @Nullable ValueCallback<Boolean> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, valueCallback) == null) {
            this.a.setCookie(str, str2, valueCallback);
        }
    }
}
