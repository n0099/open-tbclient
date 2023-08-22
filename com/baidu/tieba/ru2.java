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
import com.baidu.tieba.em4;
import com.baidu.tieba.gk4;
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
/* loaded from: classes7.dex */
public class ru2 implements mi4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ gn4 b;

        /* renamed from: com.baidu.tieba.ru2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0473a extends xd2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0473a(a aVar, AtomicInteger atomicInteger) {
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

            @Override // com.baidu.tieba.xd2
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    hn4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.xd2
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    hn4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.xd2
            public void f(xj4 xj4Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xj4Var) == null) {
                    super.f(xj4Var);
                    if (xj4Var != null && (i = xj4Var.a) != 1010 && i != 1015) {
                        this.a.incrementAndGet();
                    }
                }
            }
        }

        public a(ru2 ru2Var, Set set, gn4 gn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru2Var, set, gn4Var};
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
            this.b = gn4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new em4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                t92.b(arrayList, "3", new C0473a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj3 a;
        public final /* synthetic */ JSONObject b;

        public b(ru2 ru2Var, lj3 lj3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru2Var, lj3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lj3Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z23.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements pc2<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek4 a;

        public c(ru2 ru2Var, ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru2Var, ek4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ek4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pc2
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                v63.b("download plugin result = " + bool);
                w63.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948134042, "Lcom/baidu/tieba/ru2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948134042, "Lcom/baidu/tieba/ru2;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public ru2() {
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

    @Override // com.baidu.tieba.mi4
    public nl4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ku2.r0();
        }
        return (nl4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return c73.t();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mi4
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cp3.k().m();
        }
    }

    @Override // com.baidu.tieba.mi4
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ku2.o().q();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return z72.m();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public mk4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return cb3.K().N();
        }
        return (mk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ku2.m().a();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.mi4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return or1.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return ku2.n().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return pr4.b(AppRuntime.getAppContext()).a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return ku2.q().a();
        }
        return (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ku2.h0().i(AppRuntime.getAppContext());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return xo3.D();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public fr4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return rj3.b("swan_app_pms_sp");
        }
        return (fr4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public mk4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return new pe2(cb3.K());
        }
        return (mk4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return ku2.g0().k();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return d53.b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            v63.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mi4
    public void D(sm4 sm4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, sm4Var) != null) || sm4Var == null) {
            return;
        }
        try {
            JSONObject b2 = sm4Var.b();
            JSONArray a2 = sm4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (db3.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            vq4 vq4Var = new vq4("0", jSONObject);
            vq4Var.e();
            sq4.f().o(vq4Var);
        } catch (JSONException e) {
            if (db3.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.mi4
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            ku2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.mi4
    public List<wj4> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) {
            return k63.e(str, j);
        }
        return (List) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) {
            return new op3(z).c(jSONArray);
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.mi4
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            d82.k(str, str2);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            d82.l(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            qd3.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void m(String str, String str2, gk4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            ku2.e().f(str, str2, cVar);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void H(gn4 gn4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, gn4Var) == null) && gn4Var != null && (b2 = gn4Var.b()) != null && b2.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new a(this, b2, gn4Var), "preloadPkg", 2);
        }
    }

    @Override // com.baidu.tieba.mi4
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return ik3.h(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            ku2.e().d(bArr);
        }
    }

    @Override // com.baidu.tieba.mi4
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return ml2.d(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.mi4
    public boolean r(@Nullable ek4 ek4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, ek4Var)) == null) {
            File g = k63.g(ek4Var);
            if (g != null && g.exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.mi4
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            return ml2.e(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.mi4
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            return ik3.f(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.mi4
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            ii3.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            d82.e(str, str2, str3, th, z);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void p(String str, JSONObject jSONObject, ck4 ck4Var, List<dk4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, ck4Var, list) == null) {
            h13.g(str, jSONObject, ck4Var, list);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            d82.j(str, str2, str3, z);
        }
    }

    @Override // com.baidu.tieba.mi4
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (db3.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                lj3 b2 = rj3.b(li3.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                d82.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                xn3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (db3.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.baidu.tieba.mi4
    public void t(vn4 vn4Var, lo4 lo4Var) {
        Collection<ek4> collection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, vn4Var, lo4Var) == null) && vn4Var != null && (collection = vn4Var.e) != null && lo4Var != null) {
            for (ek4 ek4Var : collection) {
                j63 j63Var = new j63(ek4Var.g, ek4Var.j, ek4Var.i, new c(this, ek4Var));
                vn4 vn4Var2 = new vn4();
                vn4Var2.e = new ArrayList();
                lo4 lo4Var2 = new lo4();
                wn4.b(ek4Var, lo4Var2);
                j63Var.G(lo4Var2);
                vn4Var2.e.clear();
                vn4Var2.e.add(ek4Var);
                ok4.e(vn4Var2, j63Var);
            }
        }
    }
}
