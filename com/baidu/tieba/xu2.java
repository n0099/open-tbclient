package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.ob3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
@Singleton
@Service
/* loaded from: classes8.dex */
public class xu2 implements uh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xu2() {
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

    @Override // com.baidu.tieba.uh4
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ku2.q().a();
        }
        return (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uh4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ob3.a.c(a());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uh4
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uh4
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ob3.a.c(a());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uh4
    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String g = SwanAppNetworkUtils.g();
            if (TextUtils.isEmpty(g) && hi4.g().c()) {
                return cn3.a();
            }
            return g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uh4
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ku2.g0().getSwitch("bbasm_framework_request_with_ua", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uh4
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName()) && e53.c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uh4
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return nr1.a;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uh4
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (b53.a() == 2) {
                return 128;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uh4
    public List<Interceptor> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new v23());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uh4
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return ob3.a.c(a());
        }
        return invokeV.intValue;
    }

    public final ob3.a a() {
        InterceptResult invokeV;
        ob3.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            db3 b0 = db3.b0();
            if (b0 == null) {
                if (nr1.a) {
                    Log.e("SwanNetworkImpl", "swanapp is null");
                }
                return null;
            }
            SwanAppConfigData Q = b0.Q();
            if (Q != null && (aVar = Q.h) != null) {
                return aVar;
            }
            if (nr1.a) {
                Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
            }
            return null;
        }
        return (ob3.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uh4
    public void j(String str, HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, httpRequestBuilder) == null) && z72.u(str)) {
            httpRequestBuilder.setHeader("x-u-id", pr4.b(AppRuntime.getAppContext()).a());
            try {
                httpRequestBuilder.setHeader("x-c2-id", ku2.h0().i(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
