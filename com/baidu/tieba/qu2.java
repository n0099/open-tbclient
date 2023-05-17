package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.cs2;
import com.baidu.tieba.du2;
import com.baidu.tieba.vc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class qu2 extends pu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class b implements as2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;
        public final /* synthetic */ qu2 b;

        /* loaded from: classes7.dex */
        public class a implements vc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ cs2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, cs2.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = i;
                this.b = gVar;
            }

            @Override // com.baidu.tieba.vc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    g62.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.vc3.e
            public void b(int i, zk3 zk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zk3Var) == null) {
                    g62.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    zk3 zk3Var2 = new zk3();
                    zk3Var2.k(5L);
                    zk3Var2.i(38L);
                    zk3Var2.f("download subpackage fail, errcode=" + i);
                    hg3 hg3Var = new hg3();
                    hg3Var.q(zf3.n(this.c.a.G()));
                    hg3Var.p(zk3Var2);
                    hg3Var.r(this.c.a);
                    zf3.R(hg3Var);
                }
            }
        }

        public b(qu2 qu2Var, du2 du2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var, du2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu2Var;
            this.a = du2Var;
        }

        @Override // com.baidu.tieba.as2
        public void a(int i, zr2 zr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, zr2Var) == null) {
                cs2.g gVar = (cs2.g) zr2Var;
                if (vc3.p(this.a, gVar)) {
                    if (g93.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = ym3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(yc3.b(f));
                        vc3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    g62.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(qu2 qu2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zm3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;

        public c(qu2 qu2Var, du2 du2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var, du2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cs2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;
        public final /* synthetic */ cs2.g b;
        public final /* synthetic */ qu2 c;

        public d(qu2 qu2Var, du2 du2Var, cs2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var, du2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qu2Var;
            this.a = du2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.Y(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;

        public e(qu2 qu2Var, du2 du2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu2Var, du2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && ns2.s0().a(n, n2, n3)) {
                    this.a.z("fromHost", null);
                    this.a.z("spuId", null);
                    this.a.z("contentId", null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104251, "Lcom/baidu/tieba/qu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104251, "Lcom/baidu/tieba/qu2;");
                return;
            }
        }
        l = qp1.a;
    }

    public qu2() {
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

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    @Nullable
    public g93 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return g93.M();
        }
        return (g93) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ag2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    public void E(du2 du2Var, as2 as2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du2Var, as2Var) == null) {
            super.E(du2Var, as2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + du2Var.j0());
            }
            cs2.c(du2Var, new b(this, du2Var));
            ag2.U().d1(du2Var);
            ag2.U().c1(du2Var);
            ag2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            lf2.d();
            ag2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            tl3.j();
            fw2.b();
            wx2.y();
            dk3.u();
            PaymentPanelManager.F();
            fj3.n();
            si3.d();
            oj3.k();
            mm2.d();
            ll4.f();
            uz2.e().o();
            wb3.h();
            yi3.h();
            tz2.k();
            if (ns2.I() != null) {
                ns2.I().e();
            }
            xz1.e().n();
            p12.b().f();
            tb3.b().k();
            xn2.d();
            s02.d().h();
            lz2.g().f();
            vf2.b();
            zt2.c().a();
            a43.g().b();
            SwanPrefetchImageRes.b().e();
            fd2.g().d();
            g72.c().n();
            yo3.c().i();
        }
    }

    public final void X(int i, du2 du2Var, cs2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, du2Var, gVar) == null) && i == 0 && du2Var != null && gVar != null) {
            l23.o().F(new UbcFlowEvent("na_post_to_main_start"));
            an3.d0(this.k);
            d dVar = new d(this, du2Var, gVar);
            this.k = dVar;
            an3.g0(dVar);
        }
    }

    public final void Y(du2 du2Var, cs2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, du2Var, gVar) == null) {
            l23.o().F(new UbcFlowEvent("na_post_to_main_end"));
            gf3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + tu2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (du2Var.m0()) {
                n(this.d).setVisibility(0);
                d62.b(true);
                g62.i("AppsControllerImpl", "init sConsole for devHook");
            }
            g62.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            ag2.U().Z0(du2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    public void d(du2 du2Var, as2 as2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, du2Var, as2Var) == null) {
            super.d(du2Var, as2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + du2Var.j0());
            }
            ag2.U().d1(du2Var);
            ag2.U().H0(null);
            SwanAppConfigData Q = f93.K().q().Q();
            if (Q != null) {
                cs2.g gVar = new cs2.g();
                z23.e().d(new c(this, du2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = cs2.e.i(du2Var.H(), du2Var.v1()).getPath() + File.separator;
                l23.o().F(new UbcFlowEvent("na_post_to_main_start"));
                gf3.d().i("na_post_to_main_start");
                Y(du2Var, gVar);
            }
        }
    }

    public final void Z(du2 du2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, du2Var) == null) && !TextUtils.isEmpty(du2Var.n("fromHost")) && !TextUtils.isEmpty(du2Var.n("spuId")) && !TextUtils.isEmpty(du2Var.n("contentId"))) {
            an3.b0(new e(this, du2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            f93 K = f93.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.ru2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = tu2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            if (this.h && S <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            g62.i("SwanApp", "onAppForeground");
            String g0 = g93.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", g33.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.U() != null) {
                hashMap.put("clkid", this.d.U().L());
                hashMap.put("scene", this.d.U().T());
                du2.a U = this.d.U();
                qf3.v(U);
                Z(U);
            }
            u(new ij2(hashMap));
            g62.i("SwanApp", "onAppShow");
            p12.b().g(false);
            fw2.h(true);
            wx2.r(false);
            uz2.e().h(false);
            xz1.e().j();
            tz2.i();
            if (ns2.I() != null) {
                ns2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (h33.h()) {
                z23.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                am3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.pu2, com.baidu.tieba.ru2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            g62.i("SwanApp", "onAppBackground");
            String g0 = g93.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(in3.b().a()));
            u(new ij2(contentValues));
            g62.i("SwanApp", "onAppHide");
            in3.b().d();
            p12.b().g(true);
            fw2.h(false);
            wx2.r(true);
            uz2.e().h(true);
            tz2.j(false);
            if (ns2.I() != null) {
                ns2.I().c();
            }
            zm3.h();
            ez2.i();
        }
    }
}
