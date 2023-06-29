package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.bn4;
import com.baidu.tieba.rf2;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class rf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface e {
        void a(String str);

        void b(int i, vn3 vn3Var);
    }

    /* loaded from: classes7.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final boolean b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ f b;

            public a(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ vn3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, vn3 vn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), vn3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = fVar;
                this.a = i;
                this.b = vn3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        ub3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1559).G();
                    }
                    this.c.a.b(this.a, this.b);
                }
            }
        }

        public f(@NonNull e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = z;
        }

        @Override // com.baidu.tieba.rf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                wp3.e0(new a(this, str));
            }
        }

        @Override // com.baidu.tieba.rf3.e
        public void b(int i, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                wp3.e0(new b(this, i, vn3Var));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends af2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e h;
        public final /* synthetic */ String i;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = eVar;
            this.i = str;
        }

        @Override // com.baidu.tieba.af2
        public void Q(@NonNull vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vn3Var) == null) {
                if (rf3.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + vn3Var);
                }
                this.h.b(2113, vn3Var);
            }
        }

        @Override // com.baidu.tieba.af2
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (rf3.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements rf2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ cc3 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, cc3 cc3Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), cc3Var, eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = cc3Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.baidu.tieba.rf2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rf3.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.baidu.tieba.rf2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                rf3.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }

        @Override // com.baidu.tieba.rf2.b
        public void b(vn3 vn3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vn3Var) == null) {
                boolean o = rf3.o(this.b.b, vn3Var);
                if (rf3.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + vn3Var);
                }
                if (o) {
                    rf3.i(this.b.b, vn3Var);
                    xw2.b().a(this.b.b);
                    rf3.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                ub3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1559).G();
                boolean z = this.a;
                String str = this.b.b;
                if (vn3Var == null) {
                    a = 0;
                } else {
                    a = vn3Var.a();
                }
                rf3.h(z, str, "pkg_retry_fail", String.valueOf(a));
                this.c.b(2113, vn3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements xe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e b;
        public final /* synthetic */ String c;

        public c(String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = eVar;
            this.c = str2;
        }

        @Override // com.baidu.tieba.xe2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cc3 M = cc3.M();
                if (M != null) {
                    M.O0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.baidu.tieba.xe2
        public void b(int i, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                this.b.b(i, vn3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements xe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ e d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        public d(String str, boolean z, String str2, e eVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, eVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = eVar;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
        }

        @Override // com.baidu.tieba.xe2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bc3.K().q().O0(this.a, true);
                rf3.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.baidu.tieba.xe2
        public void b(int i, vn3 vn3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                boolean o = rf3.o(this.c, vn3Var);
                if (rf3.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + vn3Var);
                }
                if (o) {
                    rf3.i(this.f, vn3Var);
                    xw2.b().a(this.c);
                    rf3.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                boolean z = this.b;
                String str = this.c;
                if (vn3Var == null) {
                    a = 0;
                } else {
                    a = vn3Var.a();
                }
                rf3.h(z, str, "sub_pkg_retry_fail", String.valueOf(a));
                this.d.b(i, vn3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948119658, "Lcom/baidu/tieba/rf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948119658, "Lcom/baidu/tieba/rf3;");
                return;
            }
        }
        a = ms1.a;
    }

    public static boolean p(zw2 zw2Var, yu2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, zw2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(zw2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static void g(cc3 cc3Var, c23 c23Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, cc3Var, c23Var, str, eVar, str2) == null) {
            if (cc3Var != null) {
                cc3Var.B().I(cc3Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (cc3Var != null && c23Var != null && !TextUtils.isEmpty(c23Var.a) && !TextUtils.isEmpty(c23Var.d)) {
                String str3 = c23Var.d;
                String c0 = cc3Var.c0(c23Var.a);
                boolean r0 = cc3Var.r0(str3);
                if (!t92.d() && !b83.H() && !b83.D()) {
                    if (j73.k(c23Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (r0) {
                        boolean A = yu2.A(cc3Var.b, cc3Var.k0());
                        boolean o0 = cc3Var.o0();
                        if (A) {
                            if (!o0) {
                                eVar.a(str);
                                return;
                            }
                            Set<bn4.a> i = j73.i(cc3Var.W().f0());
                            if (i != null && !i.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar.a(str);
                                return;
                            } else {
                                j(i, eVar, str);
                                return;
                            }
                        } else if (o0) {
                            k(cc3Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(c0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (cc3Var.t0(c0)) {
                        eVar.a(str);
                        return;
                    } else if (cc3Var.v0(c0) && cc3Var.u0(c0)) {
                        eVar.a(str);
                        cc3Var.O0(c0, true);
                        return;
                    } else {
                        String R = cc3Var.R(c0);
                        if (TextUtils.isEmpty(R)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean q0 = cc3Var.q0(str3);
                        if (!yu2.A(cc3Var.b, cc3Var.k0()) && !q0) {
                            k(cc3Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = h53.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(cc3Var.b, cc3Var.k0(), "3", c0, R, str, new f(eVar, true));
                        return;
                    }
                } else if (!r0 && TextUtils.isEmpty(c0)) {
                    eVar.b(2111, null);
                    return;
                } else {
                    eVar.a(str);
                    return;
                }
            }
            eVar.b(2110, null);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            xw2.b().g(str);
            vi3.L(str2, str3);
        }
    }

    public static void i(String str, vn3 vn3Var) {
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, vn3Var) == null) {
            if (vn3Var == null) {
                h = 0;
            } else {
                h = vn3Var.h();
            }
            if (h == 2205) {
                ok2.c().d().u(gq3.a(str), true, 12);
            }
        }
    }

    public static boolean o(String str, vn3 vn3Var) {
        InterceptResult invokeLL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, vn3Var)) == null) {
            if (vn3Var == null) {
                h = 0;
            } else {
                h = vn3Var.h();
            }
            if (SwanAppNetworkUtils.i(jv2.c()) && xw2.b().f(str) && (h == 2101 || h == 2205)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void j(Set<bn4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            bn4 bn4Var = new bn4(set);
            bn4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            mj4.d(bn4Var, aVar);
        }
    }

    public static void k(cc3 cc3Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{cc3Var, str, str2, eVar, str3, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        if (cc3Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = h53.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        en4 en4Var = new en4(cc3Var.b, bc3.K().k());
        en4Var.q(wp3.o(cc3Var.k0()));
        en4Var.t(str);
        mj4.c(en4Var, new rf2(cc3Var.b, new b(z, cc3Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) != null) || eVar == null) {
            return;
        }
        hn4 hn4Var = new hn4(str, str2, str5, 0);
        hn4Var.d(str3);
        mj4.h(hn4Var, new tf2(str, str2, new c(str4, eVar, str6)));
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) {
            n(str, str2, str3, str4, str5, str6, eVar, false);
        }
    }

    public static void n(String str, String str2, String str3, String str4, String str5, String str6, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{str, str2, str3, str4, str5, str6, eVar, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        String e2 = xw2.b().e(str, str4);
        hn4 hn4Var = new hn4(str, str2, str5, 0);
        hn4Var.d(str3);
        mj4.h(hn4Var, new tf2(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean q(zw2 zw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, zw2Var, swanAppConfigData)) == null) {
            if (zw2Var != null && !TextUtils.isEmpty(zw2Var.e0()) && !t92.d() && !b83.D()) {
                String f2 = up3.f(zw2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = uf3.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (!zj4.i().n(zw2Var.H(), zw2Var.v1(), str)) {
                            return true;
                        }
                        return !new File(yu2.e.i(zw2Var.H(), zw2Var.v1()), str).exists();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
