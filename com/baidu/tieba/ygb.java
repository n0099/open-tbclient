package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fgb;
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
public class ygb extends cgb {
    public static /* synthetic */ Interceptable $ic;
    public static List<vgb> c;
    public static final Object d;
    public static final Map<String, cgb> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final dgb a;
    public final zgb b;

    /* loaded from: classes8.dex */
    public static class a implements fgb.a {
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

        @Override // com.baidu.tieba.fgb.a
        public String a(dgb dgbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dgbVar)) == null) {
                if (dgbVar.b().equals(agb.c)) {
                    str = "/agcgw_all/CN";
                } else if (dgbVar.b().equals(agb.e)) {
                    str = "/agcgw_all/RU";
                } else if (dgbVar.b().equals(agb.d)) {
                    str = "/agcgw_all/DE";
                } else if (!dgbVar.b().equals(agb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return dgbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements fgb.a {
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

        @Override // com.baidu.tieba.fgb.a
        public String a(dgb dgbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dgbVar)) == null) {
                if (dgbVar.b().equals(agb.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (dgbVar.b().equals(agb.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (dgbVar.b().equals(agb.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!dgbVar.b().equals(agb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return dgbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements fgb.a {
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

        @Override // com.baidu.tieba.fgb.a
        public String a(dgb dgbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dgbVar)) == null) {
                if (dgbVar.b().equals(agb.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (dgbVar.b().equals(agb.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (dgbVar.b().equals(agb.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!dgbVar.b().equals(agb.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return dgbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948330613, "Lcom/baidu/tieba/ygb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948330613, "Lcom/baidu/tieba/ygb;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public ygb(dgb dgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dgbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dgbVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new zgb(c, dgbVar.getContext());
        zgb zgbVar = new zgb(null, dgbVar.getContext());
        this.b = zgbVar;
        if (dgbVar instanceof lgb) {
            zgbVar.c(((lgb) dgbVar).d(), dgbVar.getContext());
        }
    }

    public static cgb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (cgb) invokeV.objValue;
    }

    public static cgb f(dgb dgbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dgbVar)) == null) ? g(dgbVar, false) : (cgb) invokeL.objValue;
    }

    public static cgb g(dgb dgbVar, boolean z) {
        InterceptResult invokeLZ;
        cgb cgbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, dgbVar, z)) == null) {
            synchronized (d) {
                cgbVar = e.get(dgbVar.getIdentifier());
                if (cgbVar == null || z) {
                    cgbVar = new ygb(dgbVar);
                    e.put(dgbVar.getIdentifier(), cgbVar);
                }
            }
            return cgbVar;
        }
        return (cgb) invokeLZ.objValue;
    }

    public static cgb h(String str) {
        InterceptResult invokeL;
        cgb cgbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                cgbVar = e.get(str);
                if (cgbVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return cgbVar;
        }
        return (cgb) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (ygb.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, ggb.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, dgb dgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, dgbVar) == null) {
            synchronized (ygb.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                kgb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(dgbVar, true);
                f = dgbVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + dgbVar.b().a());
                xgb.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            fgb.b("/agcgw/url", new a());
            fgb.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            fgb.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.cgb
    public dgb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (dgb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cgb
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cgb
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
