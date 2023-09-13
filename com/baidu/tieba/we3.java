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
import com.baidu.tieba.du2;
import com.baidu.tieba.gm4;
import com.baidu.tieba.we2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class we3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str);

        void b(int i, an3 an3Var);
    }

    /* loaded from: classes8.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final boolean b;

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ an3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, an3 an3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), an3Var};
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
                this.b = an3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        za3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f159a).G();
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

        @Override // com.baidu.tieba.we3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                bp3.e0(new a(this, str));
            }
        }

        @Override // com.baidu.tieba.we3.e
        public void b(int i, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                bp3.e0(new b(this, i, an3Var));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends fe2 {
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

        @Override // com.baidu.tieba.fe2
        public void Q(@NonNull an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, an3Var) == null) {
                if (we3.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + an3Var);
                }
                this.h.b(2113, an3Var);
            }
        }

        @Override // com.baidu.tieba.fe2
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (we3.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements we2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ hb3 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, hb3 hb3Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), hb3Var, eVar, str, str2, str3};
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
            this.b = hb3Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.baidu.tieba.we2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                we3.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.baidu.tieba.we2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                we3.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }

        @Override // com.baidu.tieba.we2.b
        public void b(an3 an3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an3Var) == null) {
                boolean o = we3.o(this.b.b, an3Var);
                if (we3.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + an3Var);
                }
                if (o) {
                    we3.i(this.b.b, an3Var);
                    cw2.b().a(this.b.b);
                    we3.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                za3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f159a).G();
                boolean z = this.a;
                String str = this.b.b;
                if (an3Var == null) {
                    a = 0;
                } else {
                    a = an3Var.a();
                }
                we3.h(z, str, "pkg_retry_fail", String.valueOf(a));
                this.c.b(2113, an3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements ce2 {
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

        @Override // com.baidu.tieba.ce2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hb3 M = hb3.M();
                if (M != null) {
                    M.O0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.baidu.tieba.ce2
        public void b(int i, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                this.b.b(i, an3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements ce2 {
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

        @Override // com.baidu.tieba.ce2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gb3.K().q().O0(this.a, true);
                we3.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.baidu.tieba.ce2
        public void b(int i, an3 an3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                boolean o = we3.o(this.c, an3Var);
                if (we3.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + an3Var);
                }
                if (o) {
                    we3.i(this.f, an3Var);
                    cw2.b().a(this.c);
                    we3.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                boolean z = this.b;
                String str = this.c;
                if (an3Var == null) {
                    a = 0;
                } else {
                    a = an3Var.a();
                }
                we3.h(z, str, "sub_pkg_retry_fail", String.valueOf(a));
                this.d.b(i, an3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948267652, "Lcom/baidu/tieba/we3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948267652, "Lcom/baidu/tieba/we3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static boolean p(ew2 ew2Var, du2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, ew2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(ew2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static void g(hb3 hb3Var, h13 h13Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, hb3Var, h13Var, str, eVar, str2) == null) {
            if (hb3Var != null) {
                hb3Var.B().I(hb3Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (hb3Var != null && h13Var != null && !TextUtils.isEmpty(h13Var.a) && !TextUtils.isEmpty(h13Var.d)) {
                String str3 = h13Var.d;
                String c0 = hb3Var.c0(h13Var.a);
                boolean r0 = hb3Var.r0(str3);
                if (!y82.d() && !g73.H() && !g73.D()) {
                    if (o63.k(h13Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (r0) {
                        boolean A = du2.A(hb3Var.b, hb3Var.k0());
                        boolean o0 = hb3Var.o0();
                        if (A) {
                            if (!o0) {
                                eVar.a(str);
                                return;
                            }
                            Set<gm4.a> i = o63.i(hb3Var.W().f0());
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
                            k(hb3Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(c0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (hb3Var.t0(c0)) {
                        eVar.a(str);
                        return;
                    } else if (hb3Var.v0(c0) && hb3Var.u0(c0)) {
                        eVar.a(str);
                        hb3Var.O0(c0, true);
                        return;
                    } else {
                        String R = hb3Var.R(c0);
                        if (TextUtils.isEmpty(R)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean q0 = hb3Var.q0(str3);
                        if (!du2.A(hb3Var.b, hb3Var.k0()) && !q0) {
                            k(hb3Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = m43.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(hb3Var.b, hb3Var.k0(), "3", c0, R, str, new f(eVar, true));
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
            cw2.b().g(str);
            ai3.L(str2, str3);
        }
    }

    public static void i(String str, an3 an3Var) {
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, an3Var) == null) {
            if (an3Var == null) {
                h = 0;
            } else {
                h = an3Var.h();
            }
            if (h == 2205) {
                tj2.c().d().u(lp3.a(str), true, 12);
            }
        }
    }

    public static boolean o(String str, an3 an3Var) {
        InterceptResult invokeLL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, an3Var)) == null) {
            if (an3Var == null) {
                h = 0;
            } else {
                h = an3Var.h();
            }
            if (SwanAppNetworkUtils.i(ou2.c()) && cw2.b().f(str) && (h == 2101 || h == 2205)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void j(Set<gm4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            gm4 gm4Var = new gm4(set);
            gm4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            ri4.d(gm4Var, aVar);
        }
    }

    public static void k(hb3 hb3Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{hb3Var, str, str2, eVar, str3, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        if (hb3Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = m43.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        jm4 jm4Var = new jm4(hb3Var.b, gb3.K().k());
        jm4Var.q(bp3.o(hb3Var.k0()));
        jm4Var.t(str);
        ri4.c(jm4Var, new we2(hb3Var.b, new b(z, hb3Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) != null) || eVar == null) {
            return;
        }
        mm4 mm4Var = new mm4(str, str2, str5, 0);
        mm4Var.d(str3);
        ri4.h(mm4Var, new ye2(str, str2, new c(str4, eVar, str6)));
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
        String e2 = cw2.b().e(str, str4);
        mm4 mm4Var = new mm4(str, str2, str5, 0);
        mm4Var.d(str3);
        ri4.h(mm4Var, new ye2(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean q(ew2 ew2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, ew2Var, swanAppConfigData)) == null) {
            if (ew2Var != null && !TextUtils.isEmpty(ew2Var.e0()) && !y82.d() && !g73.D()) {
                String f2 = zo3.f(ew2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = ze3.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (!ej4.i().n(ew2Var.H(), ew2Var.v1(), str)) {
                            return true;
                        }
                        return !new File(du2.e.i(ew2Var.H(), ew2Var.v1()), str).exists();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
