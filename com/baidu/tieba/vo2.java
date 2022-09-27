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
import com.baidu.tieba.a73;
import com.baidu.tieba.hm2;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class vo2 extends uo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(vo2 vo2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo2Var, Long.valueOf(j)};
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
                eh3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io2 a;
        public final /* synthetic */ vo2 b;

        /* loaded from: classes6.dex */
        public class a implements a73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ hm2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, hm2.g gVar) {
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

            @Override // com.baidu.tieba.a73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    l02.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.a73.e
            public void b(int i, ef3 ef3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                    l02.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    ef3 ef3Var2 = new ef3();
                    ef3Var2.k(5L);
                    ef3Var2.i(38L);
                    ef3Var2.f("download subpackage fail, errcode=" + i);
                    ma3 ma3Var = new ma3();
                    ma3Var.q(ea3.n(this.c.a.G()));
                    ma3Var.p(ef3Var2);
                    ma3Var.r(this.c.a);
                    ea3.R(ma3Var);
                }
            }
        }

        public b(vo2 vo2Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo2Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vo2Var;
            this.a = io2Var;
        }

        @Override // com.baidu.tieba.fm2
        public void a(int i, em2 em2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, em2Var) == null) {
                hm2.g gVar = (hm2.g) em2Var;
                if (a73.p(this.a, gVar)) {
                    if (l33.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = dh3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(d73.b(f));
                        a73.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    l02.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io2 a;

        public c(vo2 vo2Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo2Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = io2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hm2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io2 a;
        public final /* synthetic */ hm2.g b;
        public final /* synthetic */ vo2 c;

        public d(vo2 vo2Var, io2 io2Var, hm2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo2Var, io2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vo2Var;
            this.a = io2Var;
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

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ io2 a;

        public e(vo2 vo2Var, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo2Var, io2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = io2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !sm2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948247440, "Lcom/baidu/tieba/vo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948247440, "Lcom/baidu/tieba/vo2;");
                return;
            }
        }
        l = vj1.a;
    }

    public vo2() {
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

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    @Nullable
    public l33 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l33.M() : (l33) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void E(io2 io2Var, fm2 fm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, io2Var, fm2Var) == null) {
            super.E(io2Var, fm2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + io2Var.j0());
            }
            hm2.c(io2Var, new b(this, io2Var));
            fa2.U().d1(io2Var);
            fa2.U().c1(io2Var);
            fa2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? fa2.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            q92.d();
            fa2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            yf3.j();
            kq2.b();
            bs2.y();
            ie3.u();
            PaymentPanelManager.F();
            kd3.n();
            xc3.d();
            td3.k();
            rg2.d();
            qf4.f();
            zt2.e().o();
            b63.h();
            dd3.h();
            yt2.k();
            if (sm2.I() != null) {
                sm2.I().e();
            }
            cu1.e().n();
            uv1.b().f();
            y53.b().k();
            ci2.d();
            xu1.d().h();
            qt2.g().f();
            aa2.b();
            eo2.c().a();
            fy2.g().b();
            SwanPrefetchImageRes.b().e();
            k72.g().d();
            l12.c().n();
            dj3.c().i();
        }
    }

    public final void X(int i, io2 io2Var, hm2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, io2Var, gVar) == null) || i != 0 || io2Var == null || gVar == null) {
            return;
        }
        qw2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        fh3.d0(this.k);
        d dVar = new d(this, io2Var, gVar);
        this.k = dVar;
        fh3.g0(dVar);
    }

    public final void Y(io2 io2Var, hm2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, io2Var, gVar) == null) {
            qw2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            l93.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + yo2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (io2Var.m0()) {
                n(this.d).setVisibility(0);
                i02.b(true);
                l02.i("AppsControllerImpl", "init sConsole for devHook");
            }
            l02.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            fa2.U().Z0(io2Var, gVar);
        }
    }

    public final void Z(io2 io2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, io2Var) == null) || TextUtils.isEmpty(io2Var.n("fromHost")) || TextUtils.isEmpty(io2Var.n("spuId")) || TextUtils.isEmpty(io2Var.n("contentId"))) {
            return;
        }
        fh3.b0(new e(this, io2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            k33 K = k33.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void d(io2 io2Var, fm2 fm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, io2Var, fm2Var) == null) {
            super.d(io2Var, fm2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + io2Var.j0());
            }
            fa2.U().d1(io2Var);
            fa2.U().H0(null);
            SwanAppConfigData Q = k33.K().q().Q();
            if (Q != null) {
                hm2.g gVar = new hm2.g();
                ex2.e().d(new c(this, io2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = hm2.e.i(io2Var.H(), io2Var.v1()).getPath() + File.separator;
                qw2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                l93.d().i("na_post_to_main_start");
                Y(io2Var, gVar);
            }
        }
    }

    @Override // com.baidu.tieba.wo2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = yo2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            l02.i("SwanApp", "onAppForeground");
            String g0 = l33.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", lx2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                io2.a S = this.d.S();
                v93.v(S);
                Z(S);
            }
            u(new nd2(hashMap));
            l02.i("SwanApp", "onAppShow");
            uv1.b().g(false);
            kq2.h(true);
            bs2.r(false);
            zt2.e().h(false);
            cu1.e().j();
            yt2.i();
            if (sm2.I() != null) {
                sm2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (mx2.h()) {
                ex2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                fg3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.uo2, com.baidu.tieba.wo2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            l02.i("SwanApp", "onAppBackground");
            String g0 = l33.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(nh3.b().a()));
            u(new nd2(contentValues));
            l02.i("SwanApp", "onAppHide");
            nh3.b().d();
            uv1.b().g(true);
            kq2.h(false);
            bs2.r(true);
            zt2.e().h(true);
            yt2.j(false);
            if (sm2.I() != null) {
                sm2.I().c();
            }
            eh3.h();
            jt2.i();
        }
    }
}
