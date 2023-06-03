package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.r9b;
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
public class kab extends o9b {
    public static /* synthetic */ Interceptable $ic;
    public static List<hab> c;
    public static final Object d;
    public static final Map<String, o9b> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final p9b a;
    public final lab b;

    /* loaded from: classes6.dex */
    public static class a implements r9b.a {
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

        @Override // com.baidu.tieba.r9b.a
        public String a(p9b p9bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p9bVar)) == null) {
                if (p9bVar.b().equals(m9b.c)) {
                    str = "/agcgw_all/CN";
                } else if (p9bVar.b().equals(m9b.e)) {
                    str = "/agcgw_all/RU";
                } else if (p9bVar.b().equals(m9b.d)) {
                    str = "/agcgw_all/DE";
                } else if (!p9bVar.b().equals(m9b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return p9bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements r9b.a {
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

        @Override // com.baidu.tieba.r9b.a
        public String a(p9b p9bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p9bVar)) == null) {
                if (p9bVar.b().equals(m9b.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (p9bVar.b().equals(m9b.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (p9bVar.b().equals(m9b.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!p9bVar.b().equals(m9b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return p9bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements r9b.a {
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

        @Override // com.baidu.tieba.r9b.a
        public String a(p9b p9bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p9bVar)) == null) {
                if (p9bVar.b().equals(m9b.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (p9bVar.b().equals(m9b.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (p9bVar.b().equals(m9b.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!p9bVar.b().equals(m9b.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return p9bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907773, "Lcom/baidu/tieba/kab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907773, "Lcom/baidu/tieba/kab;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public kab(p9b p9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p9bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = p9bVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new lab(c, p9bVar.getContext());
        lab labVar = new lab(null, p9bVar.getContext());
        this.b = labVar;
        if (p9bVar instanceof x9b) {
            labVar.c(((x9b) p9bVar).d(), p9bVar.getContext());
        }
    }

    public static o9b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (o9b) invokeV.objValue;
    }

    public static o9b f(p9b p9bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p9bVar)) == null) ? g(p9bVar, false) : (o9b) invokeL.objValue;
    }

    public static o9b g(p9b p9bVar, boolean z) {
        InterceptResult invokeLZ;
        o9b o9bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, p9bVar, z)) == null) {
            synchronized (d) {
                o9bVar = e.get(p9bVar.getIdentifier());
                if (o9bVar == null || z) {
                    o9bVar = new kab(p9bVar);
                    e.put(p9bVar.getIdentifier(), o9bVar);
                }
            }
            return o9bVar;
        }
        return (o9b) invokeLZ.objValue;
    }

    public static o9b h(String str) {
        InterceptResult invokeL;
        o9b o9bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                o9bVar = e.get(str);
                if (o9bVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return o9bVar;
        }
        return (o9b) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (kab.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, s9b.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, p9b p9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, p9bVar) == null) {
            synchronized (kab.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                w9b.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(p9bVar, true);
                f = p9bVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + p9bVar.b().a());
                jab.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            r9b.b("/agcgw/url", new a());
            r9b.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            r9b.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.o9b
    public p9b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (p9b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o9b
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o9b
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
