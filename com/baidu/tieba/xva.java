package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eva;
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
public class xva extends bva {
    public static /* synthetic */ Interceptable $ic;
    public static List<uva> c;
    public static final Object d;
    public static final Map<String, bva> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final cva a;
    public final yva b;

    /* loaded from: classes7.dex */
    public static class a implements eva.a {
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

        @Override // com.baidu.tieba.eva.a
        public String a(cva cvaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cvaVar)) == null) {
                if (cvaVar.b().equals(zua.c)) {
                    str = "/agcgw_all/CN";
                } else if (cvaVar.b().equals(zua.e)) {
                    str = "/agcgw_all/RU";
                } else if (cvaVar.b().equals(zua.d)) {
                    str = "/agcgw_all/DE";
                } else if (!cvaVar.b().equals(zua.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return cvaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements eva.a {
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

        @Override // com.baidu.tieba.eva.a
        public String a(cva cvaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cvaVar)) == null) {
                if (cvaVar.b().equals(zua.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (cvaVar.b().equals(zua.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (cvaVar.b().equals(zua.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!cvaVar.b().equals(zua.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return cvaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements eva.a {
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

        @Override // com.baidu.tieba.eva.a
        public String a(cva cvaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cvaVar)) == null) {
                if (cvaVar.b().equals(zua.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (cvaVar.b().equals(zua.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (cvaVar.b().equals(zua.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!cvaVar.b().equals(zua.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return cvaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948315206, "Lcom/baidu/tieba/xva;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948315206, "Lcom/baidu/tieba/xva;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public xva(cva cvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cvaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cvaVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new yva(c, cvaVar.getContext());
        yva yvaVar = new yva(null, cvaVar.getContext());
        this.b = yvaVar;
        if (cvaVar instanceof kva) {
            yvaVar.c(((kva) cvaVar).d(), cvaVar.getContext());
        }
    }

    public static bva e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (bva) invokeV.objValue;
    }

    public static bva f(cva cvaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cvaVar)) == null) ? g(cvaVar, false) : (bva) invokeL.objValue;
    }

    public static bva g(cva cvaVar, boolean z) {
        InterceptResult invokeLZ;
        bva bvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, cvaVar, z)) == null) {
            synchronized (d) {
                bvaVar = e.get(cvaVar.getIdentifier());
                if (bvaVar == null || z) {
                    bvaVar = new xva(cvaVar);
                    e.put(cvaVar.getIdentifier(), bvaVar);
                }
            }
            return bvaVar;
        }
        return (bva) invokeLZ.objValue;
    }

    public static bva h(String str) {
        InterceptResult invokeL;
        bva bvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                bvaVar = e.get(str);
                if (bvaVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return bvaVar;
        }
        return (bva) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (xva.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, fva.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, cva cvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, cvaVar) == null) {
            synchronized (xva.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                jva.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(cvaVar, true);
                f = cvaVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + cvaVar.b().a());
                wva.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            eva.b("/agcgw/url", new a());
            eva.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            eva.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.bva
    public cva c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (cva) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bva
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bva
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
