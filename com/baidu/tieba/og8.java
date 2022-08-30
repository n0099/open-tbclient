package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.EventListener;
import okhttp3.Request;
@Singleton
@Service
/* loaded from: classes5.dex */
public class og8 implements IHttpContext {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948031401, "Lcom/baidu/tieba/og8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948031401, "Lcom/baidu/tieba/og8;");
                return;
            }
        }
        boolean isDebug = AppConfig.isDebug();
        b = isDebug;
        b = isDebug;
        c = og8.class.getSimpleName();
    }

    @DebugTrace
    public og8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = AppRuntime.getAppContext();
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpRequest)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public CookieManager getCookieManager(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return null;
        }
        return (CookieManager) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public EventListener getEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (EventListener) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public int getFallbackConnectDelayMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, httpRequest)) == null) {
            if (b) {
                String str = c;
                Log.i(str, "baidunetwork HttpContext getNewCloneHttpDns httpRequest:" + httpRequest);
                return null;
            }
            return null;
        }
        return (IHttpDns) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewHttpDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (b) {
                Log.i(c, "baidunetwork HttpContext getNewHttpDns!");
                return null;
            }
            return null;
        }
        return (IHttpDns) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public NetworkStat<Request> getNewNetworkStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (NetworkStat) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void init() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b) {
            Log.i(c, "baidunetwork HttpContext init!");
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void prefetchDnsResult(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, networkInfoRecord) == null) {
        }
    }
}
