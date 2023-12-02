package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.tbadk.switchs.UbcAddCookieSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public final class ypa implements CookieManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public ypa() {
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
        this.a = "/ztbox?action=zubc";
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (UbcAddCookieSwitch.Companion.isOn()) {
                boolean z = true;
                if (!((str == null || !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) this.a, false, 2, (Object) null)) ? false : false)) {
                    return "";
                }
            }
            String cookie = CookieManager.WEBKIT_COOKIES.getCookie(str);
            Intrinsics.checkNotNullExpressionValue(cookie, "WEBKIT_COOKIES.getCookie(httpUrl)");
            return cookie;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) {
            if (UbcAddCookieSwitch.Companion.isOn()) {
                boolean z = true;
                if (!((str == null || !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) this.a, false, 2, (Object) null)) ? false : false)) {
                    return;
                }
            }
            CookieManager.WEBKIT_COOKIES.storeCookie(str, list);
        }
    }
}
