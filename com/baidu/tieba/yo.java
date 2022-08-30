package com.baidu.tieba;

import android.content.Context;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.HttpDnsClient;
import com.baidu.tieba.xo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class yo implements HttpDnsClient.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xo a;
    public final BDHttpDns b;
    public final BDHttpDns.CachePolicy c;
    public final HttpDnsClient d;

    public yo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BDHttpDns h = BDHttpDns.h(context);
        this.b = h;
        this.a = h.e();
        this.c = this.b.c();
        this.d = this.b.f();
    }

    @Override // com.baidu.bdhttpdns.HttpDnsClient.b
    public void a(int i, HttpDnsClient.RequestParamType requestParamType, Map<String, HttpDnsClient.e> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), requestParamType, map, str}) == null) {
            if (i != -1) {
                if (i != 0) {
                    zo.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
                } else {
                    for (Map.Entry<String, HttpDnsClient.e> entry : map.entrySet()) {
                        String key = entry.getKey();
                        HttpDnsClient.e value = entry.getValue();
                        if (value != null) {
                            xo.a aVar = new xo.a();
                            aVar.i(value.c());
                            aVar.h(System.currentTimeMillis() / 1000);
                            aVar.f(value.a());
                            aVar.g(value.b());
                            this.a.e(key, aVar);
                        } else if (this.c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                            this.a.d(key);
                        }
                    }
                }
            } else if (requestParamType.equals(HttpDnsClient.RequestParamType.DNLIST_HOSTS) && this.c == BDHttpDns.CachePolicy.POLICY_TOLERANT) {
                for (String str2 : str.split(",")) {
                    this.a.d(str2);
                }
            }
            if (this.b.g() <= 0 || this.d.C()) {
                return;
            }
            this.d.M(true);
            zo.a("preResolve has finished", new Object[0]);
        }
    }
}
