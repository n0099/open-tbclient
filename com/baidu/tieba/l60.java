package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes6.dex */
public class l60 implements Interceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Dns a;

    public l60(Dns dns) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dns};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dns;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        Dns dns;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            Request request = chain.request();
            com.baidu.searchbox.network.outback.core.Request request2 = (com.baidu.searchbox.network.outback.core.Request) request.tag(com.baidu.searchbox.network.outback.core.Request.class);
            if (request2 == null) {
                return chain.proceed(request);
            }
            if ((request2.getNetworkStatRecord().dnsDetail == null || (request2.getNetworkStatRecord().dnsDetail != null && "{}".equalsIgnoreCase(request2.getNetworkStatRecord().dnsDetail.toString().trim()))) && (dns = this.a) != null) {
                dns.lookup(request2.url().host());
            }
            return chain.proceed(request);
        }
        return (Response) invokeL.objValue;
    }
}
