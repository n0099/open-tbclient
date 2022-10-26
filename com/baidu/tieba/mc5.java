package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.network.outback.IOutbackClientIPProvider;
import com.baidu.searchbox.network.outback.IOutbackContext;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.statistics.IAdditionalRecord;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.BdNetTypeSwitch;
import com.baidu.tieba.n60;
import com.baidu.tieba.o70;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import okhttp3.internal.tls.OkHostnameVerifier;
/* loaded from: classes5.dex */
public class mc5 implements IOutbackContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap a;
    public CallFactory.CallFactoryProducer b;
    public CallFactory.CallFactoryProducer c;
    public int d;

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public IOutbackClientIPProvider getClientIPProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (IOutbackClientIPProvider) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                return OkHostnameVerifier.INSTANCE.verify(str, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements IAdditionalRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public long getAppLaunchTimeStamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getClientIPV6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getHttpDnsAreaInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public long getHttpDnsAreaInfoLastUpdateTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public int getIpStack() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public int getNetworkQuality() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getProcessName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        public b(mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public mc5() {
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
        this.d = SwitchManager.getInstance().findType(BdNetTypeSwitch.KEY);
        TbadkCoreApplication.getInst().setBdNetType(this.d);
        OkHttpClient build = new OkHttpClient.Builder().hostnameVerifier(new a(this)).build();
        n60.b bVar = new n60.b();
        bVar.p(build);
        this.b = bVar.n();
        this.c = new o70.a().a();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(this.b.getEngineName(), this.b);
        this.a.put(this.c.getEngineName(), this.c);
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public CallFactory.CallFactoryProducer getBackupCallFactoryProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (CallFactory.CallFactoryProducer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public CallFactory.CallFactoryProducer getDefaultCallFactoryProducer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (BdNetTypeSwitch.isOkHttp(this.d)) {
                return this.b;
            }
            return this.c;
        }
        return (CallFactory.CallFactoryProducer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public IAdditionalRecord getIAdditionalRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new b(this);
        }
        return (IAdditionalRecord) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.IOutbackContext
    public HashMap getOutbackEngines() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (HashMap) invokeV.objValue;
    }
}
