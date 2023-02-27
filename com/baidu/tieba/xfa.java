package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.efa;
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
/* loaded from: classes6.dex */
public class xfa extends bfa {
    public static /* synthetic */ Interceptable $ic;
    public static List<ufa> c;
    public static final Object d;
    public static final Map<String, bfa> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final cfa a;
    public final yfa b;

    /* loaded from: classes6.dex */
    public static class a implements efa.a {
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

        @Override // com.baidu.tieba.efa.a
        public String a(cfa cfaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cfaVar)) == null) {
                if (cfaVar.b().equals(zea.c)) {
                    str = "/agcgw_all/CN";
                } else if (cfaVar.b().equals(zea.e)) {
                    str = "/agcgw_all/RU";
                } else if (cfaVar.b().equals(zea.d)) {
                    str = "/agcgw_all/DE";
                } else if (!cfaVar.b().equals(zea.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return cfaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements efa.a {
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

        @Override // com.baidu.tieba.efa.a
        public String a(cfa cfaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cfaVar)) == null) {
                if (cfaVar.b().equals(zea.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (cfaVar.b().equals(zea.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (cfaVar.b().equals(zea.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!cfaVar.b().equals(zea.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return cfaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements efa.a {
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

        @Override // com.baidu.tieba.efa.a
        public String a(cfa cfaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cfaVar)) == null) {
                if (cfaVar.b().equals(zea.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (cfaVar.b().equals(zea.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (cfaVar.b().equals(zea.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!cfaVar.b().equals(zea.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return cfaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948299830, "Lcom/baidu/tieba/xfa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948299830, "Lcom/baidu/tieba/xfa;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public xfa(cfa cfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cfaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cfaVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new yfa(c, cfaVar.getContext());
        yfa yfaVar = new yfa(null, cfaVar.getContext());
        this.b = yfaVar;
        if (cfaVar instanceof kfa) {
            yfaVar.c(((kfa) cfaVar).d(), cfaVar.getContext());
        }
    }

    public static bfa e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (bfa) invokeV.objValue;
    }

    public static bfa f(cfa cfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cfaVar)) == null) ? g(cfaVar, false) : (bfa) invokeL.objValue;
    }

    public static bfa g(cfa cfaVar, boolean z) {
        InterceptResult invokeLZ;
        bfa bfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, cfaVar, z)) == null) {
            synchronized (d) {
                bfaVar = e.get(cfaVar.getIdentifier());
                if (bfaVar == null || z) {
                    bfaVar = new xfa(cfaVar);
                    e.put(cfaVar.getIdentifier(), bfaVar);
                }
            }
            return bfaVar;
        }
        return (bfa) invokeLZ.objValue;
    }

    public static bfa h(String str) {
        InterceptResult invokeL;
        bfa bfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                bfaVar = e.get(str);
                if (bfaVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return bfaVar;
        }
        return (bfa) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (xfa.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, ffa.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, cfa cfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, cfaVar) == null) {
            synchronized (xfa.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                jfa.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(cfaVar, true);
                f = cfaVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + cfaVar.b().a());
                wfa.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            efa.b("/agcgw/url", new a());
            efa.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            efa.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.bfa
    public cfa c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (cfa) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bfa
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bfa
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
