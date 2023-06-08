package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.w9b;
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
public class pab extends t9b {
    public static /* synthetic */ Interceptable $ic;
    public static List<mab> c;
    public static final Object d;
    public static final Map<String, t9b> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final u9b a;
    public final qab b;

    /* loaded from: classes7.dex */
    public static class a implements w9b.a {
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

        @Override // com.baidu.tieba.w9b.a
        public String a(u9b u9bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u9bVar)) == null) {
                if (u9bVar.b().equals(r9b.c)) {
                    str = "/agcgw_all/CN";
                } else if (u9bVar.b().equals(r9b.e)) {
                    str = "/agcgw_all/RU";
                } else if (u9bVar.b().equals(r9b.d)) {
                    str = "/agcgw_all/DE";
                } else if (!u9bVar.b().equals(r9b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return u9bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements w9b.a {
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

        @Override // com.baidu.tieba.w9b.a
        public String a(u9b u9bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u9bVar)) == null) {
                if (u9bVar.b().equals(r9b.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (u9bVar.b().equals(r9b.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (u9bVar.b().equals(r9b.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!u9bVar.b().equals(r9b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return u9bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements w9b.a {
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

        @Override // com.baidu.tieba.w9b.a
        public String a(u9b u9bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u9bVar)) == null) {
                if (u9bVar.b().equals(r9b.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (u9bVar.b().equals(r9b.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (u9bVar.b().equals(r9b.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!u9bVar.b().equals(r9b.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return u9bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948056728, "Lcom/baidu/tieba/pab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948056728, "Lcom/baidu/tieba/pab;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public pab(u9b u9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u9bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = u9bVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new qab(c, u9bVar.getContext());
        qab qabVar = new qab(null, u9bVar.getContext());
        this.b = qabVar;
        if (u9bVar instanceof cab) {
            qabVar.c(((cab) u9bVar).d(), u9bVar.getContext());
        }
    }

    public static t9b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (t9b) invokeV.objValue;
    }

    public static t9b f(u9b u9bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, u9bVar)) == null) ? g(u9bVar, false) : (t9b) invokeL.objValue;
    }

    public static t9b g(u9b u9bVar, boolean z) {
        InterceptResult invokeLZ;
        t9b t9bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, u9bVar, z)) == null) {
            synchronized (d) {
                t9bVar = e.get(u9bVar.getIdentifier());
                if (t9bVar == null || z) {
                    t9bVar = new pab(u9bVar);
                    e.put(u9bVar.getIdentifier(), t9bVar);
                }
            }
            return t9bVar;
        }
        return (t9b) invokeLZ.objValue;
    }

    public static t9b h(String str) {
        InterceptResult invokeL;
        t9b t9bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                t9bVar = e.get(str);
                if (t9bVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return t9bVar;
        }
        return (t9b) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (pab.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, x9b.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, u9b u9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, u9bVar) == null) {
            synchronized (pab.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                bab.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(u9bVar, true);
                f = u9bVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + u9bVar.b().a());
                oab.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            w9b.b("/agcgw/url", new a());
            w9b.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            w9b.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.t9b
    public u9b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (u9b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t9b
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t9b
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
