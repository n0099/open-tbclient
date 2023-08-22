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
import com.baidu.tieba.cm4;
import com.baidu.tieba.se2;
import com.baidu.tieba.zt2;
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
public class se3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str);

        void b(int i, wm3 wm3Var);
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
            public final /* synthetic */ wm3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, wm3 wm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), wm3Var};
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
                this.b = wm3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        va3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1581).G();
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

        @Override // com.baidu.tieba.se3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                xo3.e0(new a(this, str));
            }
        }

        @Override // com.baidu.tieba.se3.e
        public void b(int i, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                xo3.e0(new b(this, i, wm3Var));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends be2 {
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

        @Override // com.baidu.tieba.be2
        public void Q(@NonNull wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wm3Var) == null) {
                if (se3.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + wm3Var);
                }
                this.h.b(2113, wm3Var);
            }
        }

        @Override // com.baidu.tieba.be2
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (se3.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements se2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ db3 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, db3 db3Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), db3Var, eVar, str, str2, str3};
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
            this.b = db3Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.baidu.tieba.se2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                se3.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.baidu.tieba.se2.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                se3.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }

        @Override // com.baidu.tieba.se2.b
        public void b(wm3 wm3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wm3Var) == null) {
                boolean o = se3.o(this.b.b, wm3Var);
                if (se3.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + wm3Var);
                }
                if (o) {
                    se3.i(this.b.b, wm3Var);
                    yv2.b().a(this.b.b);
                    se3.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                va3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f1581).G();
                boolean z = this.a;
                String str = this.b.b;
                if (wm3Var == null) {
                    a = 0;
                } else {
                    a = wm3Var.a();
                }
                se3.h(z, str, "pkg_retry_fail", String.valueOf(a));
                this.c.b(2113, wm3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements yd2 {
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

        @Override // com.baidu.tieba.yd2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                db3 M = db3.M();
                if (M != null) {
                    M.O0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.baidu.tieba.yd2
        public void b(int i, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                this.b.b(i, wm3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements yd2 {
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

        @Override // com.baidu.tieba.yd2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cb3.K().q().O0(this.a, true);
                se3.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.baidu.tieba.yd2
        public void b(int i, wm3 wm3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                boolean o = se3.o(this.c, wm3Var);
                if (se3.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + wm3Var);
                }
                if (o) {
                    se3.i(this.f, wm3Var);
                    yv2.b().a(this.c);
                    se3.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                boolean z = this.b;
                String str = this.c;
                if (wm3Var == null) {
                    a = 0;
                } else {
                    a = wm3Var.a();
                }
                se3.h(z, str, "sub_pkg_retry_fail", String.valueOf(a));
                this.d.b(i, wm3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948148488, "Lcom/baidu/tieba/se3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948148488, "Lcom/baidu/tieba/se3;");
                return;
            }
        }
        a = nr1.a;
    }

    public static boolean p(aw2 aw2Var, zt2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, aw2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(aw2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static void g(db3 db3Var, d13 d13Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, db3Var, d13Var, str, eVar, str2) == null) {
            if (db3Var != null) {
                db3Var.B().I(db3Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (db3Var != null && d13Var != null && !TextUtils.isEmpty(d13Var.a) && !TextUtils.isEmpty(d13Var.d)) {
                String str3 = d13Var.d;
                String c0 = db3Var.c0(d13Var.a);
                boolean r0 = db3Var.r0(str3);
                if (!u82.d() && !c73.H() && !c73.D()) {
                    if (k63.k(d13Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (r0) {
                        boolean A = zt2.A(db3Var.b, db3Var.k0());
                        boolean o0 = db3Var.o0();
                        if (A) {
                            if (!o0) {
                                eVar.a(str);
                                return;
                            }
                            Set<cm4.a> i = k63.i(db3Var.W().f0());
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
                            k(db3Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(c0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (db3Var.t0(c0)) {
                        eVar.a(str);
                        return;
                    } else if (db3Var.v0(c0) && db3Var.u0(c0)) {
                        eVar.a(str);
                        db3Var.O0(c0, true);
                        return;
                    } else {
                        String R = db3Var.R(c0);
                        if (TextUtils.isEmpty(R)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean q0 = db3Var.q0(str3);
                        if (!zt2.A(db3Var.b, db3Var.k0()) && !q0) {
                            k(db3Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = i43.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(db3Var.b, db3Var.k0(), "3", c0, R, str, new f(eVar, true));
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
            yv2.b().g(str);
            wh3.L(str2, str3);
        }
    }

    public static void i(String str, wm3 wm3Var) {
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, wm3Var) == null) {
            if (wm3Var == null) {
                h = 0;
            } else {
                h = wm3Var.h();
            }
            if (h == 2205) {
                pj2.c().d().u(hp3.a(str), true, 12);
            }
        }
    }

    public static boolean o(String str, wm3 wm3Var) {
        InterceptResult invokeLL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, wm3Var)) == null) {
            if (wm3Var == null) {
                h = 0;
            } else {
                h = wm3Var.h();
            }
            if (SwanAppNetworkUtils.i(ku2.c()) && yv2.b().f(str) && (h == 2101 || h == 2205)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void j(Set<cm4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            cm4 cm4Var = new cm4(set);
            cm4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            ni4.d(cm4Var, aVar);
        }
    }

    public static void k(db3 db3Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{db3Var, str, str2, eVar, str3, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        if (db3Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = i43.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        fm4 fm4Var = new fm4(db3Var.b, cb3.K().k());
        fm4Var.q(xo3.o(db3Var.k0()));
        fm4Var.t(str);
        ni4.c(fm4Var, new se2(db3Var.b, new b(z, db3Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) != null) || eVar == null) {
            return;
        }
        im4 im4Var = new im4(str, str2, str5, 0);
        im4Var.d(str3);
        ni4.h(im4Var, new ue2(str, str2, new c(str4, eVar, str6)));
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
        String e2 = yv2.b().e(str, str4);
        im4 im4Var = new im4(str, str2, str5, 0);
        im4Var.d(str3);
        ni4.h(im4Var, new ue2(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean q(aw2 aw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, aw2Var, swanAppConfigData)) == null) {
            if (aw2Var != null && !TextUtils.isEmpty(aw2Var.e0()) && !u82.d() && !c73.D()) {
                String f2 = vo3.f(aw2Var.e0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = ve3.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (!aj4.i().n(aw2Var.H(), aw2Var.v1(), str)) {
                            return true;
                        }
                        return !new File(zt2.e.i(aw2Var.H(), aw2Var.v1()), str).exists();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
