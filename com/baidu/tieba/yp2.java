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
import com.baidu.tieba.lh4;
import com.baidu.tieba.nf4;
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
/* loaded from: classes9.dex */
public class yp2 implements td4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ni4 b;

        /* renamed from: com.baidu.tieba.yp2$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0545a extends e92 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0545a(a aVar, AtomicInteger atomicInteger) {
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

            @Override // com.baidu.tieba.e92
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    oi4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.e92
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    oi4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.e92
            public void f(ef4 ef4Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef4Var) == null) {
                    super.f(ef4Var);
                    if (ef4Var != null && (i = ef4Var.a) != 1010 && i != 1015) {
                        this.a.incrementAndGet();
                    }
                }
            }
        }

        public a(yp2 yp2Var, Set set, ni4 ni4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp2Var, set, ni4Var};
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
            this.b = ni4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new lh4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                a52.b(arrayList, "3", new C0545a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se3 a;
        public final /* synthetic */ JSONObject b;

        public b(yp2 yp2Var, se3 se3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp2Var, se3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se3Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gy2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements w72<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf4 a;

        public c(yp2 yp2Var, lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yp2Var, lf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lf4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                c23.b("download plugin result = " + bool);
                d23.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948337774, "Lcom/baidu/tieba/yp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948337774, "Lcom/baidu/tieba/yp2;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public yp2() {
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

    @Override // com.baidu.tieba.td4
    public ug4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return rp2.r0();
        }
        return (ug4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return j23.t();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.td4
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jk3.k().m();
        }
    }

    @Override // com.baidu.tieba.td4
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return rp2.o().q();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return g32.m();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public tf4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return j63.K().N();
        }
        return (tf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return rp2.m().a();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.td4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return wm1.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return rp2.n().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return vm4.b(AppRuntime.getAppContext()).a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return rp2.q().a();
        }
        return (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return rp2.h0().i(AppRuntime.getAppContext());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return ek3.D();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public lm4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return ye3.b("swan_app_pms_sp");
        }
        return (lm4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public tf4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return new w92(j63.K());
        }
        return (tf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return rp2.g0().k();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return k03.b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.td4
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            c23.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.td4
    public void D(zh4 zh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, zh4Var) != null) || zh4Var == null) {
            return;
        }
        try {
            JSONObject b2 = zh4Var.b();
            JSONArray a2 = zh4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (k63.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            bm4 bm4Var = new bm4("0", jSONObject);
            bm4Var.e();
            yl4.f().o(bm4Var);
        } catch (JSONException e) {
            if (k63.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.td4
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            rp2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.td4
    public List<df4> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) {
            return r13.e(str, j);
        }
        return (List) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.td4
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) {
            return new vk3(z).c(jSONArray);
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.td4
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            k32.k(str, str2);
        }
    }

    @Override // com.baidu.tieba.td4
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            k32.l(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.td4
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            x83.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.baidu.tieba.td4
    public void m(String str, String str2, nf4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            rp2.e().f(str, str2, cVar);
        }
    }

    @Override // com.baidu.tieba.td4
    public void H(ni4 ni4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ni4Var) == null) && ni4Var != null && (b2 = ni4Var.b()) != null && b2.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new a(this, b2, ni4Var), "preloadPkg", 2);
        }
    }

    @Override // com.baidu.tieba.td4
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return pf3.h(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.td4
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            rp2.e().d(bArr);
        }
    }

    @Override // com.baidu.tieba.td4
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return tg2.d(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.td4
    public boolean r(@Nullable lf4 lf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, lf4Var)) == null) {
            File g = r13.g(lf4Var);
            if (g != null && g.exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.td4
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            return tg2.e(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.td4
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            return pf3.f(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.td4
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            pd3.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.baidu.tieba.td4
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            k32.e(str, str2, str3, th, z);
        }
    }

    @Override // com.baidu.tieba.td4
    public void p(String str, JSONObject jSONObject, jf4 jf4Var, List<kf4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, jf4Var, list) == null) {
            ow2.g(str, jSONObject, jf4Var, list);
        }
    }

    @Override // com.baidu.tieba.td4
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            k32.j(str, str2, str3, z);
        }
    }

    @Override // com.baidu.tieba.td4
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (k63.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                se3 b2 = ye3.b(sd3.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                k32.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                ej3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (k63.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.baidu.tieba.td4
    public void t(cj4 cj4Var, sj4 sj4Var) {
        Collection<lf4> collection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, cj4Var, sj4Var) == null) && cj4Var != null && (collection = cj4Var.e) != null && sj4Var != null) {
            for (lf4 lf4Var : collection) {
                q13 q13Var = new q13(lf4Var.g, lf4Var.j, lf4Var.i, new c(this, lf4Var));
                cj4 cj4Var2 = new cj4();
                cj4Var2.e = new ArrayList();
                sj4 sj4Var2 = new sj4();
                dj4.b(lf4Var, sj4Var2);
                q13Var.G(sj4Var2);
                cj4Var2.e.clear();
                cj4Var2.e.add(lf4Var);
                vf4.e(cj4Var2, q13Var);
            }
        }
    }
}
