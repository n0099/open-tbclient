package com.bun.miitmdid.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f61148a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61148a = new HashMap();
    }

    private Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.f61148a.isEmpty()) {
                this.f61148a.put(com.alipay.sdk.sys.a.t, sysParamters.a().b());
                this.f61148a.put("sv", sysParamters.a().c());
                this.f61148a.put("md", sysParamters.a().d());
                this.f61148a.put("mf", sysParamters.a().e());
                this.f61148a.put("pn", sysParamters.g());
            }
            this.f61148a.put("tm", String.valueOf(System.currentTimeMillis()));
            return this.f61148a;
        }
        return (Map) invokeV.objValue;
    }

    public boolean a(boolean z, String str, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4})) == null) {
            try {
                String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
                b a3 = b.a(com.bun.miitmdid.utils.b.a());
                a3.a(a());
                a3.a("support", String.valueOf(z ? 1 : 0));
                a3.a((Object) a2);
                a3.a("http://sdk.api.bjshcw.com/stat");
                a3.a(new b.a(this) { // from class: com.bun.miitmdid.b.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f61149a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61149a = this;
                    }

                    @Override // com.bun.miitmdid.b.b.a
                    public void a(Exception exc, int i2, String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, exc, i2, str5) == null) {
                        }
                    }
                }).a();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
