package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
/* loaded from: classes6.dex */
public class t50 implements CookieJar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieManager a;

    public t50(CookieManager cookieManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cookieManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cookieManager;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpUrl)) == null) {
            ArrayList arrayList = new ArrayList();
            CookieManager cookieManager = this.a;
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(httpUrl.toString());
                if (!Util.isTextEmpty(cookie)) {
                    arrayList.addAll(b(httpUrl, cookie));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final List<Cookie> b(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            while (i < length) {
                int delimiterOffset = Util.delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
                int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
                String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
                if (delimiterOffset2 < delimiterOffset) {
                    str2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str2 = "";
                }
                if (str2.startsWith("\"") && str2.endsWith("\"")) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
                String a = a(trimSubstring);
                String a2 = a(str2);
                if (!Util.isTextEmpty(a) && this.a.shouldSendCookie(httpUrl.toString(), a)) {
                    arrayList.add(new Cookie.Builder().name(a).value(a2).domain(httpUrl.host()).build());
                }
                i = delimiterOffset + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, httpUrl, list) == null) && this.a != null) {
            ArrayList arrayList = new ArrayList();
            String httpUrl2 = httpUrl.toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!Util.isTextEmpty(cookie2) && this.a.shouldAcceptCookie(httpUrl2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            this.a.storeCookie(httpUrl.toString(), arrayList);
        }
    }
}
