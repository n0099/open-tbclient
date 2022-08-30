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
import com.baidu.tieba.p43;
import com.baidu.tieba.wj2;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class km2 extends jm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(km2 km2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km2Var, Long.valueOf(j)};
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
                te3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements uj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl2 a;
        public final /* synthetic */ km2 b;

        /* loaded from: classes4.dex */
        public class a implements p43.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ wj2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, wj2.g gVar) {
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

            @Override // com.baidu.tieba.p43.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    ay1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.p43.e
            public void b(int i, tc3 tc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tc3Var) == null) {
                    ay1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    tc3 tc3Var2 = new tc3();
                    tc3Var2.k(5L);
                    tc3Var2.i(38L);
                    tc3Var2.f("download subpackage fail, errcode=" + i);
                    b83 b83Var = new b83();
                    b83Var.q(t73.n(this.c.a.G()));
                    b83Var.p(tc3Var2);
                    b83Var.r(this.c.a);
                    t73.R(b83Var);
                }
            }
        }

        public b(km2 km2Var, xl2 xl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km2Var, xl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = km2Var;
            this.a = xl2Var;
        }

        @Override // com.baidu.tieba.uj2
        public void a(int i, tj2 tj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, tj2Var) == null) {
                wj2.g gVar = (wj2.g) tj2Var;
                if (p43.p(this.a, gVar)) {
                    if (a13.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = se3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(s43.b(f));
                        p43.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    ay1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl2 a;

        public c(km2 km2Var, xl2 xl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km2Var, xl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wj2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl2 a;
        public final /* synthetic */ wj2.g b;
        public final /* synthetic */ km2 c;

        public d(km2 km2Var, xl2 xl2Var, wj2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km2Var, xl2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = km2Var;
            this.a = xl2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.Y(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl2 a;

        public e(km2 km2Var, xl2 xl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {km2Var, xl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !hk2.s0().a(n, n2, n3)) {
                    return;
                }
                this.a.z("fromHost", null);
                this.a.z("spuId", null);
                this.a.z("contentId", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947917817, "Lcom/baidu/tieba/km2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947917817, "Lcom/baidu/tieba/km2;");
                return;
            }
        }
        l = kh1.a;
    }

    public km2() {
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

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    @Nullable
    public a13 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a13.M() : (a13) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    public void E(xl2 xl2Var, uj2 uj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl2Var, uj2Var) == null) {
            super.E(xl2Var, uj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + xl2Var.j0());
            }
            wj2.c(xl2Var, new b(this, xl2Var));
            u72.U().d1(xl2Var);
            u72.U().c1(xl2Var);
            u72.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? u72.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            f72.d();
            u72.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            nd3.j();
            zn2.b();
            qp2.y();
            xb3.u();
            PaymentPanelManager.F();
            za3.n();
            ma3.d();
            ib3.k();
            ge2.d();
            dd4.f();
            or2.e().o();
            q33.h();
            sa3.h();
            nr2.k();
            if (hk2.I() != null) {
                hk2.I().e();
            }
            rr1.e().n();
            jt1.b().f();
            n33.b().k();
            rf2.d();
            ms1.d().h();
            fr2.g().f();
            p72.b();
            tl2.c().a();
            uv2.g().b();
            SwanPrefetchImageRes.b().e();
            z42.g().d();
            az1.c().n();
            sg3.c().i();
        }
    }

    public final void X(int i, xl2 xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, xl2Var, gVar) == null) || i != 0 || xl2Var == null || gVar == null) {
            return;
        }
        fu2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        ue3.d0(this.k);
        d dVar = new d(this, xl2Var, gVar);
        this.k = dVar;
        ue3.g0(dVar);
    }

    public final void Y(xl2 xl2Var, wj2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, xl2Var, gVar) == null) {
            fu2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            a73.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + nm2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (xl2Var.m0()) {
                n(this.d).setVisibility(0);
                xx1.b(true);
                ay1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            ay1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            u72.U().Z0(xl2Var, gVar);
        }
    }

    public final void Z(xl2 xl2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, xl2Var) == null) || TextUtils.isEmpty(xl2Var.n("fromHost")) || TextUtils.isEmpty(xl2Var.n("spuId")) || TextUtils.isEmpty(xl2Var.n("contentId"))) {
            return;
        }
        ue3.b0(new e(this, xl2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            z03 K = z03.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    public void d(xl2 xl2Var, uj2 uj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xl2Var, uj2Var) == null) {
            super.d(xl2Var, uj2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + xl2Var.j0());
            }
            u72.U().d1(xl2Var);
            u72.U().H0(null);
            SwanAppConfigData Q = z03.K().q().Q();
            if (Q != null) {
                wj2.g gVar = new wj2.g();
                tu2.e().d(new c(this, xl2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = wj2.e.i(xl2Var.H(), xl2Var.v1()).getPath() + File.separator;
                fu2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                a73.d().i("na_post_to_main_start");
                Y(xl2Var, gVar);
            }
        }
    }

    @Override // com.baidu.tieba.lm2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = nm2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            ay1.i("SwanApp", "onAppForeground");
            String g0 = a13.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", av2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                xl2.a S = this.d.S();
                k73.v(S);
                Z(S);
            }
            u(new cb2(hashMap));
            ay1.i("SwanApp", "onAppShow");
            jt1.b().g(false);
            zn2.h(true);
            qp2.r(false);
            or2.e().h(false);
            rr1.e().j();
            nr2.i();
            if (hk2.I() != null) {
                hk2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (bv2.h()) {
                tu2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                ud3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.jm2, com.baidu.tieba.lm2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            ay1.i("SwanApp", "onAppBackground");
            String g0 = a13.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(cf3.b().a()));
            u(new cb2(contentValues));
            ay1.i("SwanApp", "onAppHide");
            cf3.b().d();
            jt1.b().g(true);
            zn2.h(false);
            qp2.r(true);
            or2.e().h(true);
            nr2.j(false);
            if (hk2.I() != null) {
                hk2.I().c();
            }
            te3.h();
            yq2.i();
        }
    }
}
