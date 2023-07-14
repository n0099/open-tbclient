package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cpb;
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
/* loaded from: classes8.dex */
public class vpb extends zob {
    public static /* synthetic */ Interceptable $ic;
    public static List<spb> c;
    public static final Object d;
    public static final Map<String, zob> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final apb a;
    public final wpb b;

    /* loaded from: classes8.dex */
    public static class a implements cpb.a {
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

        @Override // com.baidu.tieba.cpb.a
        public String a(apb apbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apbVar)) == null) {
                if (apbVar.b().equals(xob.c)) {
                    str = "/agcgw_all/CN";
                } else if (apbVar.b().equals(xob.e)) {
                    str = "/agcgw_all/RU";
                } else if (apbVar.b().equals(xob.d)) {
                    str = "/agcgw_all/DE";
                } else if (!apbVar.b().equals(xob.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return apbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements cpb.a {
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

        @Override // com.baidu.tieba.cpb.a
        public String a(apb apbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apbVar)) == null) {
                if (apbVar.b().equals(xob.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (apbVar.b().equals(xob.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (apbVar.b().equals(xob.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!apbVar.b().equals(xob.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return apbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements cpb.a {
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

        @Override // com.baidu.tieba.cpb.a
        public String a(apb apbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apbVar)) == null) {
                if (apbVar.b().equals(xob.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (apbVar.b().equals(xob.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (apbVar.b().equals(xob.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!apbVar.b().equals(xob.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return apbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249889, "Lcom/baidu/tieba/vpb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249889, "Lcom/baidu/tieba/vpb;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public vpb(apb apbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = apbVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new wpb(c, apbVar.getContext());
        wpb wpbVar = new wpb(null, apbVar.getContext());
        this.b = wpbVar;
        if (apbVar instanceof ipb) {
            wpbVar.c(((ipb) apbVar).d(), apbVar.getContext());
        }
    }

    public static zob e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (zob) invokeV.objValue;
    }

    public static zob f(apb apbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, apbVar)) == null) ? g(apbVar, false) : (zob) invokeL.objValue;
    }

    public static zob g(apb apbVar, boolean z) {
        InterceptResult invokeLZ;
        zob zobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, apbVar, z)) == null) {
            synchronized (d) {
                zobVar = e.get(apbVar.getIdentifier());
                if (zobVar == null || z) {
                    zobVar = new vpb(apbVar);
                    e.put(apbVar.getIdentifier(), zobVar);
                }
            }
            return zobVar;
        }
        return (zob) invokeLZ.objValue;
    }

    public static zob h(String str) {
        InterceptResult invokeL;
        zob zobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                zobVar = e.get(str);
                if (zobVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return zobVar;
        }
        return (zob) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (vpb.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, dpb.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, apb apbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, apbVar) == null) {
            synchronized (vpb.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                hpb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(apbVar, true);
                f = apbVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + apbVar.b().a());
                upb.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            cpb.b("/agcgw/url", new a());
            cpb.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            cpb.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.zob
    public apb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (apb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zob
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zob
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
