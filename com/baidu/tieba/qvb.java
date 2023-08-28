package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xub;
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
public class qvb extends uub {
    public static /* synthetic */ Interceptable $ic;
    public static List<nvb> c;
    public static final Object d;
    public static final Map<String, uub> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final vub a;
    public final rvb b;

    /* loaded from: classes7.dex */
    public static class a implements xub.a {
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

        @Override // com.baidu.tieba.xub.a
        public String a(vub vubVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vubVar)) == null) {
                if (vubVar.b().equals(sub.c)) {
                    str = "/agcgw_all/CN";
                } else if (vubVar.b().equals(sub.e)) {
                    str = "/agcgw_all/RU";
                } else if (vubVar.b().equals(sub.d)) {
                    str = "/agcgw_all/DE";
                } else if (!vubVar.b().equals(sub.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return vubVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements xub.a {
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

        @Override // com.baidu.tieba.xub.a
        public String a(vub vubVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vubVar)) == null) {
                if (vubVar.b().equals(sub.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (vubVar.b().equals(sub.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (vubVar.b().equals(sub.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!vubVar.b().equals(sub.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return vubVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements xub.a {
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

        @Override // com.baidu.tieba.xub.a
        public String a(vub vubVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vubVar)) == null) {
                if (vubVar.b().equals(sub.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (vubVar.b().equals(sub.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (vubVar.b().equals(sub.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!vubVar.b().equals(sub.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return vubVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106700, "Lcom/baidu/tieba/qvb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106700, "Lcom/baidu/tieba/qvb;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public qvb(vub vubVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vubVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = vubVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new rvb(c, vubVar.getContext());
        rvb rvbVar = new rvb(null, vubVar.getContext());
        this.b = rvbVar;
        if (vubVar instanceof dvb) {
            rvbVar.c(((dvb) vubVar).d(), vubVar.getContext());
        }
    }

    public static uub e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (uub) invokeV.objValue;
    }

    public static uub f(vub vubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vubVar)) == null) ? g(vubVar, false) : (uub) invokeL.objValue;
    }

    public static uub g(vub vubVar, boolean z) {
        InterceptResult invokeLZ;
        uub uubVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, vubVar, z)) == null) {
            synchronized (d) {
                uubVar = e.get(vubVar.getIdentifier());
                if (uubVar == null || z) {
                    uubVar = new qvb(vubVar);
                    e.put(vubVar.getIdentifier(), uubVar);
                }
            }
            return uubVar;
        }
        return (uub) invokeLZ.objValue;
    }

    public static uub h(String str) {
        InterceptResult invokeL;
        uub uubVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                uubVar = e.get(str);
                if (uubVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return uubVar;
        }
        return (uub) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (qvb.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, yub.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, vub vubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, vubVar) == null) {
            synchronized (qvb.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                cvb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(vubVar, true);
                f = vubVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + vubVar.b().a());
                pvb.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            xub.b("/agcgw/url", new a());
            xub.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            xub.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.uub
    public vub c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (vub) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uub
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uub
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
