package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public interface rt0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "nativeCookieMgr");
    public static final ServiceReference b = new ServiceReference("nad.core", "sailorCookieMgr");
    public static final rt0 c = new a();
    public static final rt0 d = new b();

    String getCookie(String str);

    boolean shouldAcceptCookie(String str, String str2);

    boolean shouldSendCookie(String str, String str2);

    void storeCookie(String str, List<String> list);

    /* loaded from: classes7.dex */
    public static class a implements rt0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.rt0
        public boolean shouldAcceptCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.rt0
        public boolean shouldSendCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final rt0 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ServiceManager.getService(rt0.a) != null) {
                    return (rt0) ServiceManager.getService(rt0.a);
                }
                return rt0.d;
            }
            return (rt0) invokeV.objValue;
        }

        public final rt0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (ServiceManager.getService(rt0.b) != null) {
                    return (rt0) ServiceManager.getService(rt0.b);
                }
                return rt0.d;
            }
            return (rt0) invokeV.objValue;
        }

        @Override // com.baidu.tieba.rt0
        public String getCookie(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(b().getCookie(str))) {
                    return b().getCookie(str);
                }
                return a().getCookie(str);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.rt0
        public void storeCookie(String str, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, list) == null) {
                b().storeCookie(str, list);
                a().storeCookie(str, list);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements rt0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.rt0
        public boolean shouldAcceptCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.rt0
        public boolean shouldSendCookie(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rt0
        public String getCookie(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                try {
                    return CookieManager.getInstance().getCookie(str);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.rt0
        public void storeCookie(String str, List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) && list != null && list.size() > 0) {
                try {
                    CookieManager cookieManager = CookieManager.getInstance();
                    for (String str2 : list) {
                        cookieManager.setCookie(str, str2);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        CookieManager.getInstance().flush();
                        return;
                    }
                    CookieSyncManager.createInstance(ok0.b());
                    CookieSyncManager.getInstance().sync();
                } catch (Exception unused) {
                }
            }
        }
    }
}
