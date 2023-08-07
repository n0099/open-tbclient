package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fob;
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
public class yob extends cob {
    public static /* synthetic */ Interceptable $ic;
    public static List<vob> c;
    public static final Object d;
    public static final Map<String, cob> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final dob a;
    public final zob b;

    /* loaded from: classes8.dex */
    public static class a implements fob.a {
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

        @Override // com.baidu.tieba.fob.a
        public String a(dob dobVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dobVar)) == null) {
                if (dobVar.b().equals(aob.c)) {
                    str = "/agcgw_all/CN";
                } else if (dobVar.b().equals(aob.e)) {
                    str = "/agcgw_all/RU";
                } else if (dobVar.b().equals(aob.d)) {
                    str = "/agcgw_all/DE";
                } else if (!dobVar.b().equals(aob.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return dobVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements fob.a {
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

        @Override // com.baidu.tieba.fob.a
        public String a(dob dobVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dobVar)) == null) {
                if (dobVar.b().equals(aob.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (dobVar.b().equals(aob.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (dobVar.b().equals(aob.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!dobVar.b().equals(aob.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return dobVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements fob.a {
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

        @Override // com.baidu.tieba.fob.a
        public String a(dob dobVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dobVar)) == null) {
                if (dobVar.b().equals(aob.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (dobVar.b().equals(aob.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (dobVar.b().equals(aob.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!dobVar.b().equals(aob.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return dobVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948338301, "Lcom/baidu/tieba/yob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948338301, "Lcom/baidu/tieba/yob;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public yob(dob dobVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dobVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dobVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new zob(c, dobVar.getContext());
        zob zobVar = new zob(null, dobVar.getContext());
        this.b = zobVar;
        if (dobVar instanceof lob) {
            zobVar.c(((lob) dobVar).d(), dobVar.getContext());
        }
    }

    public static cob e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (cob) invokeV.objValue;
    }

    public static cob f(dob dobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dobVar)) == null) ? g(dobVar, false) : (cob) invokeL.objValue;
    }

    public static cob g(dob dobVar, boolean z) {
        InterceptResult invokeLZ;
        cob cobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, dobVar, z)) == null) {
            synchronized (d) {
                cobVar = e.get(dobVar.getIdentifier());
                if (cobVar == null || z) {
                    cobVar = new yob(dobVar);
                    e.put(dobVar.getIdentifier(), cobVar);
                }
            }
            return cobVar;
        }
        return (cob) invokeLZ.objValue;
    }

    public static cob h(String str) {
        InterceptResult invokeL;
        cob cobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                cobVar = e.get(str);
                if (cobVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return cobVar;
        }
        return (cob) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (yob.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, gob.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, dob dobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, dobVar) == null) {
            synchronized (yob.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                kob.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(dobVar, true);
                f = dobVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + dobVar.b().a());
                xob.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            fob.b("/agcgw/url", new a());
            fob.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            fob.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.cob
    public dob c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (dob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cob
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cob
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
