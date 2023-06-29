package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import java.util.List;
/* loaded from: classes7.dex */
public class oa2 extends eh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948025449, "Lcom/baidu/tieba/oa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948025449, "Lcom/baidu/tieba/oa2;");
                return;
            }
        }
        a = ms1.a;
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception e) {
            if (a) {
                Log.w("RealCookieManager", "static createInstance err=" + e + " trace=" + Log.getStackTraceString(e));
            }
        }
    }

    public oa2() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (jo3.f()) {
                if (a) {
                    Log.i("RealCookieManager", "syncCookie: hasLollipop flush");
                }
                CookieManager.getInstance().flush();
                android.webkit.CookieManager.getInstance().flush();
                return;
            }
            if (a) {
                Log.i("RealCookieManager", "syncCookie: noLollipop sync");
            }
            CookieSyncManager.getInstance().sync();
        }
    }

    @Override // com.baidu.tieba.eh3, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (a) {
                Log.i("RealCookieManager", "getCookie: httpUrl=" + str);
            }
            String str2 = "";
            try {
                str2 = CookieManager.getInstance().getCookie(str);
                if (a) {
                    Log.d("RealCookieManager", "RealCookieManager:" + str2);
                }
            } catch (Exception e) {
                if (a) {
                    Log.e("RealCookieManager", "getCookie: err=" + e + " trace=" + Log.getStackTraceString(e));
                }
            }
            if (a) {
                Log.i("RealCookieManager", "getCookie: ret cookie=" + str2 + " for httpUrl=" + str);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            if (a) {
                Log.d("RealCookieManager", "storeCookie: httpUrl= " + str);
                StringBuilder sb = new StringBuilder();
                sb.append("storeCookie: cookies=");
                if (list == null) {
                    size = -1;
                } else {
                    size = list.size();
                }
                sb.append(size);
                Log.i("RealCookieManager", sb.toString());
            }
            if (list != null && list.size() > 0) {
                try {
                    for (String str2 : list) {
                        if (a) {
                            Log.i("RealCookieManager", "storeCookie: cookies item=" + str2);
                        }
                        CookieManager.getInstance().setCookie(str, str2);
                        android.webkit.CookieManager.getInstance().setCookie(str, str2);
                    }
                    a();
                } catch (Exception e) {
                    if (a) {
                        Log.e("RealCookieManager", "storeCookie: err=" + e + " trace=" + Log.getStackTraceString(e));
                    }
                }
            }
        }
    }
}
