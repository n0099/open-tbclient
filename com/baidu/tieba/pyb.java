package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wxb;
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
public class pyb extends txb {
    public static /* synthetic */ Interceptable $ic;
    public static List<myb> c;
    public static final Object d;
    public static final Map<String, txb> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final uxb a;
    public final qyb b;

    /* loaded from: classes7.dex */
    public static class a implements wxb.a {
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

        @Override // com.baidu.tieba.wxb.a
        public String a(uxb uxbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uxbVar)) == null) {
                if (uxbVar.b().equals(rxb.c)) {
                    str = "/agcgw_all/CN";
                } else if (uxbVar.b().equals(rxb.e)) {
                    str = "/agcgw_all/RU";
                } else if (uxbVar.b().equals(rxb.d)) {
                    str = "/agcgw_all/DE";
                } else if (!uxbVar.b().equals(rxb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return uxbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements wxb.a {
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

        @Override // com.baidu.tieba.wxb.a
        public String a(uxb uxbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uxbVar)) == null) {
                if (uxbVar.b().equals(rxb.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (uxbVar.b().equals(rxb.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (uxbVar.b().equals(rxb.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!uxbVar.b().equals(rxb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return uxbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements wxb.a {
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

        @Override // com.baidu.tieba.wxb.a
        public String a(uxb uxbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uxbVar)) == null) {
                if (uxbVar.b().equals(rxb.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (uxbVar.b().equals(rxb.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (uxbVar.b().equals(rxb.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!uxbVar.b().equals(rxb.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return uxbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948079792, "Lcom/baidu/tieba/pyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948079792, "Lcom/baidu/tieba/pyb;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public pyb(uxb uxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uxbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = uxbVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new qyb(c, uxbVar.getContext());
        qyb qybVar = new qyb(null, uxbVar.getContext());
        this.b = qybVar;
        if (uxbVar instanceof cyb) {
            qybVar.c(((cyb) uxbVar).d(), uxbVar.getContext());
        }
    }

    public static txb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (txb) invokeV.objValue;
    }

    public static txb f(uxb uxbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uxbVar)) == null) ? g(uxbVar, false) : (txb) invokeL.objValue;
    }

    public static txb g(uxb uxbVar, boolean z) {
        InterceptResult invokeLZ;
        txb txbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, uxbVar, z)) == null) {
            synchronized (d) {
                txbVar = e.get(uxbVar.getIdentifier());
                if (txbVar == null || z) {
                    txbVar = new pyb(uxbVar);
                    e.put(uxbVar.getIdentifier(), txbVar);
                }
            }
            return txbVar;
        }
        return (txb) invokeLZ.objValue;
    }

    public static txb h(String str) {
        InterceptResult invokeL;
        txb txbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                txbVar = e.get(str);
                if (txbVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return txbVar;
        }
        return (txb) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (pyb.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, xxb.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, uxb uxbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, uxbVar) == null) {
            synchronized (pyb.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                byb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(uxbVar, true);
                f = uxbVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + uxbVar.b().a());
                oyb.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            wxb.b("/agcgw/url", new a());
            wxb.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            wxb.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.txb
    public uxb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (uxb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.txb
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.txb
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
