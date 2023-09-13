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
import com.baidu.tieba.du2;
import com.baidu.tieba.ew2;
import com.baidu.tieba.we3;
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
public class rw2 extends qw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class b implements bu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ rw2 b;

        /* loaded from: classes7.dex */
        public class a implements we3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ du2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, du2.g gVar) {
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

            @Override // com.baidu.tieba.we3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    h82.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.we3.e
            public void b(int i, an3 an3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                    h82.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    an3 an3Var2 = new an3();
                    an3Var2.k(5L);
                    an3Var2.i(38L);
                    an3Var2.f("download subpackage fail, errcode=" + i);
                    ii3 ii3Var = new ii3();
                    ii3Var.q(ai3.n(this.c.a.G()));
                    ii3Var.p(an3Var2);
                    ii3Var.r(this.c.a);
                    ai3.R(ii3Var);
                }
            }
        }

        public b(rw2 rw2Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw2Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rw2Var;
            this.a = ew2Var;
        }

        @Override // com.baidu.tieba.bu2
        public void a(int i, au2 au2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, au2Var) == null) {
                du2.g gVar = (du2.g) au2Var;
                if (we3.p(this.a, gVar)) {
                    if (hb3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = zo3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(ze3.b(f));
                        we3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    h82.o("SwanApp", "subpackage is invalid");
                }
                this.b.W(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(rw2 rw2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw2Var, Long.valueOf(j)};
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
                ap3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;

        public c(rw2 rw2Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw2Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ew2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                du2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ du2.g b;
        public final /* synthetic */ rw2 c;

        public d(rw2 rw2Var, ew2 ew2Var, du2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw2Var, ew2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rw2Var;
            this.a = ew2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.X(this.a, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;

        public e(rw2 rw2Var, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw2Var, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ew2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && ou2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135964, "Lcom/baidu/tieba/rw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135964, "Lcom/baidu/tieba/rw2;");
                return;
            }
        }
        l = rr1.a;
    }

    public rw2() {
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

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    @Nullable
    public hb3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return hb3.M();
        }
        return (hb3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return bi2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void E(ew2 ew2Var, bu2 bu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ew2Var, bu2Var) == null) {
            super.E(ew2Var, bu2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + ew2Var.j0());
            }
            du2.c(ew2Var, new b(this, ew2Var));
            bi2.U().d1(ew2Var);
            bi2.U().c1(ew2Var);
            bi2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            mh2.d();
            bi2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            un3.j();
            gy2.b();
            xz2.y();
            em3.u();
            PaymentPanelManager.F();
            gl3.n();
            tk3.d();
            pl3.k();
            no2.d();
            mn4.f();
            v13.e().o();
            xd3.h();
            zk3.h();
            u13.k();
            if (ou2.I() != null) {
                ou2.I().e();
            }
            y12.e().n();
            q32.b().f();
            ud3.b().k();
            yp2.d();
            t22.d().h();
            m13.g().f();
            wh2.b();
            aw2.c().a();
            b63.g().b();
            SwanPrefetchImageRes.b().e();
            gf2.g().d();
            h92.c().n();
            zq3.c().i();
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            h82.i("SwanApp", "onAppForeground");
            String g0 = hb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", h53.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                ew2.a S = this.d.S();
                rh3.v(S);
                Y(S);
            }
            u(new jl2(hashMap));
            h82.i("SwanApp", "onAppShow");
            q32.b().g(false);
            gy2.h(true);
            xz2.r(false);
            v13.e().h(false);
            y12.e().j();
            u13.i();
            if (ou2.I() != null) {
                ou2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (i53.h()) {
                a53.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                bo3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, ew2 ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, ew2Var, gVar) == null) && i == 0 && ew2Var != null && gVar != null) {
            m43.o().F(new UbcFlowEvent("na_post_to_main_start"));
            bp3.d0(this.k);
            d dVar = new d(this, ew2Var, gVar);
            this.k = dVar;
            bp3.g0(dVar);
        }
    }

    public final void X(ew2 ew2Var, du2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ew2Var, gVar) == null) {
            m43.o().F(new UbcFlowEvent("na_post_to_main_end"));
            hh3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + uw2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (ew2Var.m0()) {
                n(this.d).setVisibility(0);
                e82.b(true);
                h82.i("AppsControllerImpl", "init sConsole for devHook");
            }
            h82.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            bi2.U().Z0(ew2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void d(ew2 ew2Var, bu2 bu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, ew2Var, bu2Var) == null) {
            super.d(ew2Var, bu2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + ew2Var.j0());
            }
            bi2.U().d1(ew2Var);
            bi2.U().H0(null);
            SwanAppConfigData Q = gb3.K().q().Q();
            if (Q != null) {
                du2.g gVar = new du2.g();
                a53.e().d(new c(this, ew2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = du2.e.i(ew2Var.H(), ew2Var.v1()).getPath() + File.separator;
                m43.o().F(new UbcFlowEvent("na_post_to_main_start"));
                hh3.d().i("na_post_to_main_start");
                X(ew2Var, gVar);
            }
        }
    }

    public final void Y(ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ew2Var) == null) && !TextUtils.isEmpty(ew2Var.n("fromHost")) && !TextUtils.isEmpty(ew2Var.n("spuId")) && !TextUtils.isEmpty(ew2Var.n("contentId"))) {
            bp3.b0(new e(this, ew2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            gb3 K = gb3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.sw2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = uw2.T().R();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + R);
            }
            if (this.h && R <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qw2, com.baidu.tieba.sw2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            h82.i("SwanApp", "onAppBackground");
            String g0 = hb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(jp3.b().a()));
            u(new jl2(contentValues));
            h82.i("SwanApp", "onAppHide");
            jp3.b().d();
            q32.b().g(true);
            gy2.h(false);
            xz2.r(true);
            v13.e().h(true);
            u13.j(false);
            if (ou2.I() != null) {
                ou2.I().c();
            }
            ap3.h();
            f13.i();
        }
    }
}
