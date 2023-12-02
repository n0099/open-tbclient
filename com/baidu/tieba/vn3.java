package com.baidu.tieba;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class vn3 extends mb3 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246510, "Lcom/baidu/tieba/vn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246510, "Lcom/baidu/tieba/vn3;");
                return;
            }
        }
        a = vm1.a;
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception unused) {
        }
    }

    public vn3() {
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
            if (ri3.f()) {
                CookieManager.getInstance().flush();
                return;
            }
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
            CookieSyncManager.getInstance().sync();
        }
    }

    @Override // com.baidu.tieba.mb3, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            String str2 = "";
            try {
                str2 = CookieManager.getInstance().getCookie(str);
                if (a) {
                    Log.d("RealCookieManager", "RealCookieManager:" + str2);
                }
            } catch (Exception unused) {
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            if (a) {
                Log.d("RealCookieManager", "storeCookie httpUrl: " + str);
                Log.d("RealCookieManager", "storeCookie cookies: " + list);
            }
            try {
                for (String str2 : list) {
                    CookieManager.getInstance().setCookie(str, str2);
                }
                a();
            } catch (Exception unused) {
            }
        }
    }
}
