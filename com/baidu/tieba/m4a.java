package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.IClientIPProvider;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.model.MultipleConnectParams;
import com.baidu.searchbox.http.model.PreConnectParams;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.UbcAddCookieSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.WrappedEventListener;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class m4a implements IHttpContext {
    public static /* synthetic */ Interceptable $ic;
    public static boolean c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public Context b;

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
    public List<HttpUrl> getBrAllowlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IClientIPProvider getClientIPProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (IClientIPProvider) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public EventListener getEventListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (EventListener) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public int getFallbackConnectDelayMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public MultipleConnectParams getMultipleConnectParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (MultipleConnectParams) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public NetworkStat<Request> getNewNetworkStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (NetworkStat) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public String getSimOperator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean isBrAllowlistEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean isNeedAuthenticateHeader4Tunnel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean isOldHttpUseTurbonet(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean isRttLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean ok4URLConnectionEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public boolean okHttpPreConnectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924079, "Lcom/baidu/tieba/m4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924079, "Lcom/baidu/tieba/m4a;");
                return;
            }
        }
        c = AppConfig.isDebug();
        d = m4a.class.getSimpleName();
    }

    @DebugTrace
    public m4a() {
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
        this.a = false;
        this.b = AppRuntime.getAppContext();
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public CookieManager getCookieManager(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (UbcAddCookieSwitch.Companion.isOn()) {
                return new b5a();
            }
            return null;
        }
        return (CookieManager) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpRequest)) == null) {
            if (c) {
                String str = d;
                Log.i(str, "baidunetwork HttpContext getNewCloneHttpDns httpRequest:" + httpRequest);
            }
            if (httpRequest == null) {
                return null;
            }
            IHttpDns httpDns = HttpManager.getDefault(this.b).getHttpDns();
            if (!(httpDns instanceof j4a)) {
                return null;
            }
            return new j4a(((j4a) httpDns).a(), true);
        }
        return (IHttpDns) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public IHttpDns getNewHttpDns() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (c) {
                Log.i(d, "baidunetwork HttpContext getNewHttpDns!");
            }
            DnsHelper dnsHelper = new DnsHelper(this.b, true);
            dnsHelper.setHttpDnsConfig(new DnsHelper.DnsConfig(true, true, true, null));
            return new j4a(dnsHelper, false);
        }
        return (IHttpDns) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (this.a) {
                    return;
                }
                this.a = true;
                if (c) {
                    Log.i(d, "baidunetwork HttpContext init!");
                }
                WrappedEventListener.setGlobalEventListener(c5a.f());
                DnsUtil.initNetworkStackType();
                OkHttpClient.setDefaultFallbackConnectDealyMs(300);
                t4a.d();
            }
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public PreConnectParams getPreConnectParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new PreConnectParams.Builder().setPreConnectEnabled(true).setPreConnectUrlsAllowlist(Collections.singletonList(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS)).setMaxPreConnectNum(20).setMaxSingleHostPreConnectNum(3).setPreConnectDelayTimeMs(5000).setPreConnectPeriodTimeMs(31000).setPreConnectDelayUrlsWithNum(new ArrayList()).setPreConnectNoDelayUrlsWithNum(new ArrayList()).build();
        }
        return (PreConnectParams) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void prefetchDnsResult(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                r4a.a = true;
            } else {
                ((j4a) HttpManager.getDefault(this.b).getHttpDns()).a().forceUpdateDomain(str);
            }
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void uploadIllegalUrlBy850(JSONObject jSONObject) {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) && jSONObject != null && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            uBCManager.onEvent("850", jSONObject);
        }
    }

    @Override // com.baidu.searchbox.http.IHttpContext
    public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, networkInfoRecord) == null) {
            if (c) {
                String str = d;
                Log.i(str, "baidu_networksetNetworkInfoRecord networkInfoRecord:" + networkInfoRecord);
            }
            HttpManager.getDefault(this.b).setNetworkStat(null);
        }
    }
}
