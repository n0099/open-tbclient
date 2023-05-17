package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.g1b;
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
public class z1b extends d1b {
    public static /* synthetic */ Interceptable $ic;
    public static List<w1b> c;
    public static final Object d;
    public static final Map<String, d1b> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final e1b a;
    public final a2b b;

    /* loaded from: classes8.dex */
    public static class a implements g1b.a {
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

        @Override // com.baidu.tieba.g1b.a
        public String a(e1b e1bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e1bVar)) == null) {
                if (e1bVar.b().equals(b1b.c)) {
                    str = "/agcgw_all/CN";
                } else if (e1bVar.b().equals(b1b.e)) {
                    str = "/agcgw_all/RU";
                } else if (e1bVar.b().equals(b1b.d)) {
                    str = "/agcgw_all/DE";
                } else if (!e1bVar.b().equals(b1b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return e1bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements g1b.a {
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

        @Override // com.baidu.tieba.g1b.a
        public String a(e1b e1bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e1bVar)) == null) {
                if (e1bVar.b().equals(b1b.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (e1bVar.b().equals(b1b.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (e1bVar.b().equals(b1b.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!e1bVar.b().equals(b1b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return e1bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements g1b.a {
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

        @Override // com.baidu.tieba.g1b.a
        public String a(e1b e1bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e1bVar)) == null) {
                if (e1bVar.b().equals(b1b.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (e1bVar.b().equals(b1b.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (e1bVar.b().equals(b1b.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!e1bVar.b().equals(b1b.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return e1bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948308510, "Lcom/baidu/tieba/z1b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948308510, "Lcom/baidu/tieba/z1b;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public z1b(e1b e1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e1bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = e1bVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new a2b(c, e1bVar.getContext());
        a2b a2bVar = new a2b(null, e1bVar.getContext());
        this.b = a2bVar;
        if (e1bVar instanceof m1b) {
            a2bVar.c(((m1b) e1bVar).d(), e1bVar.getContext());
        }
    }

    public static d1b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (d1b) invokeV.objValue;
    }

    public static d1b f(e1b e1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, e1bVar)) == null) ? g(e1bVar, false) : (d1b) invokeL.objValue;
    }

    public static d1b g(e1b e1bVar, boolean z) {
        InterceptResult invokeLZ;
        d1b d1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, e1bVar, z)) == null) {
            synchronized (d) {
                d1bVar = e.get(e1bVar.getIdentifier());
                if (d1bVar == null || z) {
                    d1bVar = new z1b(e1bVar);
                    e.put(e1bVar.getIdentifier(), d1bVar);
                }
            }
            return d1bVar;
        }
        return (d1b) invokeLZ.objValue;
    }

    public static d1b h(String str) {
        InterceptResult invokeL;
        d1b d1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                d1bVar = e.get(str);
                if (d1bVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return d1bVar;
        }
        return (d1b) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (z1b.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, h1b.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, e1b e1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, e1bVar) == null) {
            synchronized (z1b.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                l1b.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(e1bVar, true);
                f = e1bVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + e1bVar.b().a());
                y1b.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            g1b.b("/agcgw/url", new a());
            g1b.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            g1b.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.d1b
    public e1b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (e1b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d1b
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d1b
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
