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
import com.baidu.tieba.gp2;
import com.baidu.tieba.jh4;
import com.baidu.tieba.z92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class z93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface e {
        void a(String str);

        void b(int i, di3 di3Var);
    }

    /* loaded from: classes9.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final boolean b;

        /* loaded from: classes9.dex */
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

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ di3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, di3 di3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), di3Var};
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
                this.b = di3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        c63.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f15d6).G();
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

        @Override // com.baidu.tieba.z93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ek3.e0(new a(this, str));
            }
        }

        @Override // com.baidu.tieba.z93.e
        public void b(int i, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                ek3.e0(new b(this, i, di3Var));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends i92 {
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

        @Override // com.baidu.tieba.i92
        public void Q(@NonNull di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, di3Var) == null) {
                if (z93.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + di3Var);
                }
                this.h.b(2113, di3Var);
            }
        }

        @Override // com.baidu.tieba.i92
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (z93.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements z92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ k63 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, k63 k63Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), k63Var, eVar, str, str2, str3};
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
            this.b = k63Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.baidu.tieba.z92.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z93.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.baidu.tieba.z92.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                z93.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }

        @Override // com.baidu.tieba.z92.b
        public void b(di3 di3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, di3Var) == null) {
                boolean o = z93.o(this.b.b, di3Var);
                if (z93.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + di3Var);
                }
                if (o) {
                    z93.i(this.b.b, di3Var);
                    fr2.b().a(this.b.b);
                    z93.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                c63.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f15d6).G();
                boolean z = this.a;
                String str = this.b.b;
                if (di3Var == null) {
                    a = 0;
                } else {
                    a = di3Var.a();
                }
                z93.h(z, str, "pkg_retry_fail", String.valueOf(a));
                this.c.b(2113, di3Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements f92 {
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

        @Override // com.baidu.tieba.f92
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k63 M = k63.M();
                if (M != null) {
                    M.P0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.baidu.tieba.f92
        public void b(int i, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                this.b.b(i, di3Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements f92 {
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

        @Override // com.baidu.tieba.f92
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j63.K().q().P0(this.a, true);
                z93.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.baidu.tieba.f92
        public void b(int i, di3 di3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                boolean o = z93.o(this.c, di3Var);
                if (z93.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + di3Var);
                }
                if (o) {
                    z93.i(this.f, di3Var);
                    fr2.b().a(this.c);
                    z93.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                boolean z = this.b;
                String str = this.c;
                if (di3Var == null) {
                    a = 0;
                } else {
                    a = di3Var.a();
                }
                z93.h(z, str, "sub_pkg_retry_fail", String.valueOf(a));
                this.d.b(i, di3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314741, "Lcom/baidu/tieba/z93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314741, "Lcom/baidu/tieba/z93;");
                return;
            }
        }
        a = vm1.a;
    }

    public static boolean p(hr2 hr2Var, gp2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, hr2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(hr2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static void g(k63 k63Var, kw2 kw2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, k63Var, kw2Var, str, eVar, str2) == null) {
            if (k63Var != null) {
                k63Var.B().I(k63Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (k63Var != null && kw2Var != null && !TextUtils.isEmpty(kw2Var.a) && !TextUtils.isEmpty(kw2Var.d)) {
                String str3 = kw2Var.d;
                String d0 = k63Var.d0(kw2Var.a);
                boolean s0 = k63Var.s0(str3);
                if (!b42.d() && !j23.H() && !j23.D()) {
                    if (r13.k(kw2Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (s0) {
                        boolean A = gp2.A(k63Var.b, k63Var.l0());
                        boolean p0 = k63Var.p0();
                        if (A) {
                            if (!p0) {
                                eVar.a(str);
                                return;
                            }
                            Set<jh4.a> i = r13.i(k63Var.X().g0());
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
                        } else if (p0) {
                            k(k63Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(d0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (k63Var.u0(d0)) {
                        eVar.a(str);
                        return;
                    } else if (k63Var.w0(d0) && k63Var.v0(d0)) {
                        eVar.a(str);
                        k63Var.P0(d0, true);
                        return;
                    } else {
                        String S = k63Var.S(d0);
                        if (TextUtils.isEmpty(S)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean r0 = k63Var.r0(str3);
                        if (!gp2.A(k63Var.b, k63Var.l0()) && !r0) {
                            k(k63Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = pz2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(k63Var.b, k63Var.l0(), "3", d0, S, str, new f(eVar, true));
                        return;
                    }
                } else if (!s0 && TextUtils.isEmpty(d0)) {
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
            fr2.b().g(str);
            dd3.L(str2, str3);
        }
    }

    public static void i(String str, di3 di3Var) {
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, di3Var) == null) {
            if (di3Var == null) {
                h = 0;
            } else {
                h = di3Var.h();
            }
            if (h == 2205) {
                we2.c().d().u(ok3.a(str), true, 12);
            }
        }
    }

    public static boolean o(String str, di3 di3Var) {
        InterceptResult invokeLL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, di3Var)) == null) {
            if (di3Var == null) {
                h = 0;
            } else {
                h = di3Var.h();
            }
            if (SwanAppNetworkUtils.i(rp2.c()) && fr2.b().f(str) && (h == 2101 || h == 2205)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void j(Set<jh4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            jh4 jh4Var = new jh4(set);
            jh4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            ud4.d(jh4Var, aVar);
        }
    }

    public static void k(k63 k63Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{k63Var, str, str2, eVar, str3, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        if (k63Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = pz2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        mh4 mh4Var = new mh4(k63Var.b, j63.K().k());
        mh4Var.q(ek3.o(k63Var.l0()));
        mh4Var.t(str);
        ud4.c(mh4Var, new z92(k63Var.b, new b(z, k63Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) != null) || eVar == null) {
            return;
        }
        ph4 ph4Var = new ph4(str, str2, str5, 0);
        ph4Var.d(str3);
        ud4.h(ph4Var, new ba2(str, str2, new c(str4, eVar, str6)));
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
        String e2 = fr2.b().e(str, str4);
        ph4 ph4Var = new ph4(str, str2, str5, 0);
        ph4Var.d(str3);
        ud4.h(ph4Var, new ba2(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean q(hr2 hr2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, hr2Var, swanAppConfigData)) == null) {
            if (hr2Var != null && !TextUtils.isEmpty(hr2Var.f0()) && !b42.d() && !j23.D()) {
                String f2 = ck3.f(hr2Var.f0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = ca3.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (!he4.i().n(hr2Var.I(), hr2Var.x1(), str)) {
                            return true;
                        }
                        return !new File(gp2.e.i(hr2Var.I(), hr2Var.x1()), str).exists();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
