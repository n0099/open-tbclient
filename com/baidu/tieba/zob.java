package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gob;
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
public class zob extends dob {
    public static /* synthetic */ Interceptable $ic;
    public static List<wob> c;
    public static final Object d;
    public static final Map<String, dob> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final eob a;
    public final apb b;

    /* loaded from: classes8.dex */
    public static class a implements gob.a {
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

        @Override // com.baidu.tieba.gob.a
        public String a(eob eobVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eobVar)) == null) {
                if (eobVar.b().equals(bob.c)) {
                    str = "/agcgw_all/CN";
                } else if (eobVar.b().equals(bob.e)) {
                    str = "/agcgw_all/RU";
                } else if (eobVar.b().equals(bob.d)) {
                    str = "/agcgw_all/DE";
                } else if (!eobVar.b().equals(bob.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return eobVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements gob.a {
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

        @Override // com.baidu.tieba.gob.a
        public String a(eob eobVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eobVar)) == null) {
                if (eobVar.b().equals(bob.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (eobVar.b().equals(bob.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (eobVar.b().equals(bob.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!eobVar.b().equals(bob.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return eobVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements gob.a {
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

        @Override // com.baidu.tieba.gob.a
        public String a(eob eobVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eobVar)) == null) {
                if (eobVar.b().equals(bob.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (eobVar.b().equals(bob.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (eobVar.b().equals(bob.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!eobVar.b().equals(bob.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return eobVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948368092, "Lcom/baidu/tieba/zob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948368092, "Lcom/baidu/tieba/zob;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public zob(eob eobVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eobVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = eobVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new apb(c, eobVar.getContext());
        apb apbVar = new apb(null, eobVar.getContext());
        this.b = apbVar;
        if (eobVar instanceof mob) {
            apbVar.c(((mob) eobVar).d(), eobVar.getContext());
        }
    }

    public static dob e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (dob) invokeV.objValue;
    }

    public static dob f(eob eobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eobVar)) == null) ? g(eobVar, false) : (dob) invokeL.objValue;
    }

    public static dob g(eob eobVar, boolean z) {
        InterceptResult invokeLZ;
        dob dobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, eobVar, z)) == null) {
            synchronized (d) {
                dobVar = e.get(eobVar.getIdentifier());
                if (dobVar == null || z) {
                    dobVar = new zob(eobVar);
                    e.put(eobVar.getIdentifier(), dobVar);
                }
            }
            return dobVar;
        }
        return (dob) invokeLZ.objValue;
    }

    public static dob h(String str) {
        InterceptResult invokeL;
        dob dobVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                dobVar = e.get(str);
                if (dobVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return dobVar;
        }
        return (dob) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (zob.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, hob.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, eob eobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, eobVar) == null) {
            synchronized (zob.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                lob.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(eobVar, true);
                f = eobVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + eobVar.b().a());
                yob.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            gob.b("/agcgw/url", new a());
            gob.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            gob.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.dob
    public eob c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (eob) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dob
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dob
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
