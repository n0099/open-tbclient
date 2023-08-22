package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vub;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ovb extends sub {
    public static /* synthetic */ Interceptable $ic;
    public static List<lvb> c;
    public static final Object d;
    public static final Map<String, sub> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final tub a;
    public final pvb b;

    /* loaded from: classes7.dex */
    public static class a implements vub.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.vub.a
        public String a(tub tubVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tubVar)) == null) {
                if (tubVar.b().equals(qub.c)) {
                    str = "/agcgw_all/CN";
                } else if (tubVar.b().equals(qub.e)) {
                    str = "/agcgw_all/RU";
                } else if (tubVar.b().equals(qub.d)) {
                    str = "/agcgw_all/DE";
                } else if (!tubVar.b().equals(qub.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return tubVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements vub.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.vub.a
        public String a(tub tubVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tubVar)) == null) {
                if (tubVar.b().equals(qub.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (tubVar.b().equals(qub.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (tubVar.b().equals(qub.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!tubVar.b().equals(qub.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return tubVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements vub.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.tieba.vub.a
        public String a(tub tubVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tubVar)) == null) {
                if (tubVar.b().equals(qub.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (tubVar.b().equals(qub.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (tubVar.b().equals(qub.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!tubVar.b().equals(qub.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return tubVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948047118, "Lcom/baidu/tieba/ovb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948047118, "Lcom/baidu/tieba/ovb;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public ovb(tub tubVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tubVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tubVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new pvb(c, tubVar.getContext());
        pvb pvbVar = new pvb(null, tubVar.getContext());
        this.b = pvbVar;
        if (tubVar instanceof bvb) {
            pvbVar.c(((bvb) tubVar).d(), tubVar.getContext());
        }
    }

    public static sub e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (sub) invokeV.objValue;
    }

    public static sub f(tub tubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tubVar)) == null) ? g(tubVar, false) : (sub) invokeL.objValue;
    }

    public static sub g(tub tubVar, boolean z) {
        InterceptResult invokeLZ;
        sub subVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, tubVar, z)) == null) {
            synchronized (d) {
                subVar = e.get(tubVar.getIdentifier());
                if (subVar == null || z) {
                    subVar = new ovb(tubVar);
                    e.put(tubVar.getIdentifier(), subVar);
                }
            }
            return subVar;
        }
        return (sub) invokeLZ.objValue;
    }

    public static sub h(String str) {
        InterceptResult invokeL;
        sub subVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                subVar = e.get(str);
                if (subVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return subVar;
        }
        return (sub) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (ovb.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, wub.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, tub tubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, tubVar) == null) {
            synchronized (ovb.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                avb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(tubVar, true);
                f = tubVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + tubVar.b().a());
                nvb.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            vub.b("/agcgw/url", new a());
            vub.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            vub.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.sub
    public tub c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (tub) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sub
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sub
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
