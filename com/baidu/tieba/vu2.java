package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import com.baidu.tieba.im4;
import com.baidu.tieba.kk4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes8.dex */
public class vu2 implements qi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ kn4 b;

        /* renamed from: com.baidu.tieba.vu2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0511a extends be2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0511a(a aVar, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = atomicInteger;
            }

            @Override // com.baidu.tieba.be2
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    ln4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.be2
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    ln4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.be2
            public void f(bk4 bk4Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bk4Var) == null) {
                    super.f(bk4Var);
                    if (bk4Var != null && (i = bk4Var.a) != 1010 && i != 1015) {
                        this.a.incrementAndGet();
                    }
                }
            }
        }

        public a(vu2 vu2Var, Set set, kn4 kn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu2Var, set, kn4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.b = kn4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new im4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                x92.b(arrayList, "3", new C0511a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj3 a;
        public final /* synthetic */ JSONObject b;

        public b(vu2 vu2Var, pj3 pj3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu2Var, pj3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pj3Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d33.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements tc2<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik4 a;

        public c(vu2 vu2Var, ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu2Var, ik4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                z63.b("download plugin result = " + bool);
                a73.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948253206, "Lcom/baidu/tieba/vu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948253206, "Lcom/baidu/tieba/vu2;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public vu2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.qi4
    public rl4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ou2.r0();
        }
        return (rl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return g73.t();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qi4
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gp3.k().m();
        }
    }

    @Override // com.baidu.tieba.qi4
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ou2.o().q();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return d82.m();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public qk4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return gb3.K().N();
        }
        return (qk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ou2.m().a();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.qi4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return sr1.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return ou2.n().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return tr4.b(AppRuntime.getAppContext()).a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return ou2.q().a();
        }
        return (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ou2.h0().i(AppRuntime.getAppContext());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return bp3.D();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public jr4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return vj3.b("swan_app_pms_sp");
        }
        return (jr4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public qk4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return new te2(gb3.K());
        }
        return (qk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return ou2.g0().k();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return h53.b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            z63.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qi4
    public void D(wm4 wm4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, wm4Var) != null) || wm4Var == null) {
            return;
        }
        try {
            JSONObject b2 = wm4Var.b();
            JSONArray a2 = wm4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (hb3.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            zq4 zq4Var = new zq4("0", jSONObject);
            zq4Var.e();
            wq4.f().o(zq4Var);
        } catch (JSONException e) {
            if (hb3.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.qi4
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            ou2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.qi4
    public List<ak4> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) {
            return o63.e(str, j);
        }
        return (List) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) {
            return new sp3(z).c(jSONArray);
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.qi4
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            h82.k(str, str2);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            h82.l(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            ud3.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void m(String str, String str2, kk4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            ou2.e().f(str, str2, cVar);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void H(kn4 kn4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, kn4Var) == null) && kn4Var != null && (b2 = kn4Var.b()) != null && b2.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new a(this, b2, kn4Var), "preloadPkg", 2);
        }
    }

    @Override // com.baidu.tieba.qi4
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return mk3.h(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            ou2.e().d(bArr);
        }
    }

    @Override // com.baidu.tieba.qi4
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return ql2.d(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.qi4
    public boolean r(@Nullable ik4 ik4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, ik4Var)) == null) {
            File g = o63.g(ik4Var);
            if (g != null && g.exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qi4
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            return ql2.e(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.qi4
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            return mk3.f(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.qi4
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            mi3.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            h82.e(str, str2, str3, th, z);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void p(String str, JSONObject jSONObject, gk4 gk4Var, List<hk4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, gk4Var, list) == null) {
            l13.g(str, jSONObject, gk4Var, list);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            h82.j(str, str2, str3, z);
        }
    }

    @Override // com.baidu.tieba.qi4
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (hb3.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                pj3 b2 = vj3.b(pi3.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                h82.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                bo3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (hb3.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.baidu.tieba.qi4
    public void t(zn4 zn4Var, po4 po4Var) {
        Collection<ik4> collection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, zn4Var, po4Var) == null) && zn4Var != null && (collection = zn4Var.e) != null && po4Var != null) {
            for (ik4 ik4Var : collection) {
                n63 n63Var = new n63(ik4Var.g, ik4Var.j, ik4Var.i, new c(this, ik4Var));
                zn4 zn4Var2 = new zn4();
                zn4Var2.e = new ArrayList();
                po4 po4Var2 = new po4();
                ao4.b(ik4Var, po4Var2);
                n63Var.G(po4Var2);
                zn4Var2.e.clear();
                zn4Var2.e.add(ik4Var);
                sk4.e(zn4Var2, n63Var);
            }
        }
    }
}
