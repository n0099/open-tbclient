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
import com.baidu.tieba.bc4;
import com.baidu.tieba.zd4;
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
/* loaded from: classes5.dex */
public class mm2 implements ha4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ bf4 b;

        /* renamed from: com.baidu.tieba.mm2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0336a extends s52 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0336a(a aVar, AtomicInteger atomicInteger) {
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

            @Override // com.baidu.tieba.s52
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    cf4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.s52
            public void f(sb4 sb4Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb4Var) == null) {
                    super.f(sb4Var);
                    if (sb4Var == null || (i = sb4Var.a) == 1010 || i == 1015) {
                        return;
                    }
                    this.a.incrementAndGet();
                }
            }

            @Override // com.baidu.tieba.s52
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    cf4.a().c(this.b.b);
                }
            }
        }

        public a(mm2 mm2Var, Set set, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm2Var, set, bf4Var};
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
            this.b = bf4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new zd4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                o12.b(arrayList, "3", new C0336a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb3 a;
        public final /* synthetic */ JSONObject b;

        public b(mm2 mm2Var, gb3 gb3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm2Var, gb3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb3Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uu2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements k42<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb4 a;

        public c(mm2 mm2Var, zb4 zb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm2Var, zb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zb4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k42
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                qy2.b("download plugin result = " + bool);
                ry2.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947977399, "Lcom/baidu/tieba/mm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947977399, "Lcom/baidu/tieba/mm2;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    public mm2() {
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

    @Override // com.baidu.tieba.ha4
    public id4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? fm2.r0() : (id4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? xy2.t() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ha4
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xg3.k().m();
        }
    }

    @Override // com.baidu.tieba.ha4
    public void D(ne4 ne4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ne4Var) == null) || ne4Var == null) {
            return;
        }
        try {
            JSONObject b2 = ne4Var.b();
            JSONArray a2 = ne4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (y23.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            qi4 qi4Var = new qi4("0", jSONObject);
            qi4Var.e();
            ni4.f().o(qi4Var);
        } catch (JSONException e) {
            if (y23.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.ha4
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? fm2.o().q() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            fm2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.ha4
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            yz1.l(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.ha4
    public void H(bf4 bf4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bf4Var) == null) || bf4Var == null || (b2 = bf4Var.b()) == null || b2.size() <= 0) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new a(this, b2, bf4Var), "preloadPkg", 2);
    }

    @Override // com.baidu.tieba.ha4
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? uz1.m() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? dc3.h(i) : (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            da3.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.baidu.tieba.ha4
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            yz1.e(str, str2, str3, th, z);
        }
    }

    @Override // com.baidu.tieba.ha4
    public hc4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x23.K().N() : (hc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? fm2.m().a() : invokeV.floatValue;
    }

    @Override // com.baidu.tieba.ha4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? jj1.a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? fm2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            fm2.e().d(bArr);
        }
    }

    @Override // com.baidu.tieba.ha4
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? kj4.b(AppRuntime.getAppContext()).a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? fm2.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? fm2.h0().i(AppRuntime.getAppContext()) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? sg3.D() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public aj4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? mb3.b("swan_app_pms_sp") : (aj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? hd2.d(i) : invokeI.longValue;
    }

    @Override // com.baidu.tieba.ha4
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            l53.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.baidu.tieba.ha4
    public List<rb4> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) ? fy2.e(str, j) : (List) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public void m(String str, String str2, bc4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            fm2.e().f(str, str2, cVar);
        }
    }

    @Override // com.baidu.tieba.ha4
    public hc4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? new k62(x23.K()) : (hc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) ? new jh3(z).c(jSONArray) : invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.ha4
    public void p(String str, JSONObject jSONObject, xb4 xb4Var, List<yb4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, xb4Var, list) == null) {
            ct2.g(str, jSONObject, xb4Var, list);
        }
    }

    @Override // com.baidu.tieba.ha4
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? fm2.g0().k() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public boolean r(@Nullable zb4 zb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, zb4Var)) == null) {
            File g = fy2.g(zb4Var);
            return g != null && g.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ha4
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (y23.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                gb3 b2 = mb3.b(ga3.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                yz1.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                sf3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (y23.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.baidu.tieba.ha4
    public void t(qf4 qf4Var, gg4 gg4Var) {
        Collection<zb4> collection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, qf4Var, gg4Var) == null) || qf4Var == null || (collection = qf4Var.e) == null || gg4Var == null) {
            return;
        }
        for (zb4 zb4Var : collection) {
            ey2 ey2Var = new ey2(zb4Var.g, zb4Var.j, zb4Var.i, new c(this, zb4Var));
            qf4 qf4Var2 = new qf4();
            qf4Var2.e = new ArrayList();
            gg4 gg4Var2 = new gg4();
            rf4.b(zb4Var, gg4Var2);
            ey2Var.G(gg4Var2);
            qf4Var2.e.clear();
            qf4Var2.e.add(zb4Var);
            jc4.e(qf4Var2, ey2Var);
        }
    }

    @Override // com.baidu.tieba.ha4
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? yw2.b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) ? hd2.e(i) : (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.ha4
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) ? dc3.f(i) : invokeI.longValue;
    }

    @Override // com.baidu.tieba.ha4
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            qy2.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ha4
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            yz1.k(str, str2);
        }
    }

    @Override // com.baidu.tieba.ha4
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            yz1.j(str, str2, str3, z);
        }
    }
}
