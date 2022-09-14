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
import com.baidu.tieba.n63;
import com.baidu.tieba.ul2;
import com.baidu.tieba.vn2;
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
public class io2 extends ho2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(io2 io2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io2Var, Long.valueOf(j)};
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
                rg3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements sl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;
        public final /* synthetic */ io2 b;

        /* loaded from: classes4.dex */
        public class a implements n63.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ul2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, ul2.g gVar) {
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

            @Override // com.baidu.tieba.n63.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    yz1.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.n63.e
            public void b(int i, re3 re3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, re3Var) == null) {
                    yz1.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    re3 re3Var2 = new re3();
                    re3Var2.k(5L);
                    re3Var2.i(38L);
                    re3Var2.f("download subpackage fail, errcode=" + i);
                    z93 z93Var = new z93();
                    z93Var.q(r93.n(this.c.a.G()));
                    z93Var.p(re3Var2);
                    z93Var.r(this.c.a);
                    r93.R(z93Var);
                }
            }
        }

        public b(io2 io2Var, vn2 vn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io2Var, vn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = io2Var;
            this.a = vn2Var;
        }

        @Override // com.baidu.tieba.sl2
        public void a(int i, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, rl2Var) == null) {
                ul2.g gVar = (ul2.g) rl2Var;
                if (n63.p(this.a, gVar)) {
                    if (y23.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = qg3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(q63.b(f));
                        n63.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    yz1.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;

        public c(io2 io2Var, vn2 vn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io2Var, vn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ul2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;
        public final /* synthetic */ ul2.g b;
        public final /* synthetic */ io2 c;

        public d(io2 io2Var, vn2 vn2Var, ul2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io2Var, vn2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = io2Var;
            this.a = vn2Var;
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
        public final /* synthetic */ vn2 a;

        public e(io2 io2Var, vn2 vn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io2Var, vn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !fm2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860157, "Lcom/baidu/tieba/io2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860157, "Lcom/baidu/tieba/io2;");
                return;
            }
        }
        l = ij1.a;
    }

    public io2() {
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

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    @Nullable
    public y23 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? y23.M() : (y23) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    public void E(vn2 vn2Var, sl2 sl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vn2Var, sl2Var) == null) {
            super.E(vn2Var, sl2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + vn2Var.j0());
            }
            ul2.c(vn2Var, new b(this, vn2Var));
            s92.U().d1(vn2Var);
            s92.U().c1(vn2Var);
            s92.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? s92.U().d0() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            d92.d();
            s92.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            lf3.j();
            xp2.b();
            or2.y();
            vd3.u();
            PaymentPanelManager.F();
            xc3.n();
            kc3.d();
            gd3.k();
            eg2.d();
            df4.f();
            mt2.e().o();
            o53.h();
            qc3.h();
            lt2.k();
            if (fm2.I() != null) {
                fm2.I().e();
            }
            pt1.e().n();
            hv1.b().f();
            l53.b().k();
            ph2.d();
            ku1.d().h();
            dt2.g().f();
            n92.b();
            rn2.c().a();
            sx2.g().b();
            SwanPrefetchImageRes.b().e();
            x62.g().d();
            y02.c().n();
            qi3.c().i();
        }
    }

    public final void X(int i, vn2 vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048580, this, i, vn2Var, gVar) == null) || i != 0 || vn2Var == null || gVar == null) {
            return;
        }
        dw2.o().F(new UbcFlowEvent("na_post_to_main_start"));
        sg3.d0(this.k);
        d dVar = new d(this, vn2Var, gVar);
        this.k = dVar;
        sg3.g0(dVar);
    }

    public final void Y(vn2 vn2Var, ul2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, vn2Var, gVar) == null) {
            dw2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            y83.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + lo2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (vn2Var.m0()) {
                n(this.d).setVisibility(0);
                vz1.b(true);
                yz1.i("AppsControllerImpl", "init sConsole for devHook");
            }
            yz1.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            s92.U().Z0(vn2Var, gVar);
        }
    }

    public final void Z(vn2 vn2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, vn2Var) == null) || TextUtils.isEmpty(vn2Var.n("fromHost")) || TextUtils.isEmpty(vn2Var.n("spuId")) || TextUtils.isEmpty(vn2Var.n("contentId"))) {
            return;
        }
        sg3.b0(new e(this, vn2Var), 2000L);
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            x23 K = x23.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    public void d(vn2 vn2Var, sl2 sl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vn2Var, sl2Var) == null) {
            super.d(vn2Var, sl2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + vn2Var.j0());
            }
            s92.U().d1(vn2Var);
            s92.U().H0(null);
            SwanAppConfigData Q = x23.K().q().Q();
            if (Q != null) {
                ul2.g gVar = new ul2.g();
                rw2.e().d(new c(this, vn2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = ul2.e.i(vn2Var.H(), vn2Var.v1()).getPath() + File.separator;
                dw2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                y83.d().i("na_post_to_main_start");
                Y(vn2Var, gVar);
            }
        }
    }

    @Override // com.baidu.tieba.jo2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = lo2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            return this.h && S <= 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            yz1.i("SwanApp", "onAppForeground");
            String g0 = y23.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", yw2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                vn2.a S = this.d.S();
                i93.v(S);
                Z(S);
            }
            u(new ad2(hashMap));
            yz1.i("SwanApp", "onAppShow");
            hv1.b().g(false);
            xp2.h(true);
            or2.r(false);
            mt2.e().h(false);
            pt1.e().j();
            lt2.i();
            if (fm2.I() != null) {
                fm2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (zw2.h()) {
                rw2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                sf3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.ho2, com.baidu.tieba.jo2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            yz1.i("SwanApp", "onAppBackground");
            String g0 = y23.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(ah3.b().a()));
            u(new ad2(contentValues));
            yz1.i("SwanApp", "onAppHide");
            ah3.b().d();
            hv1.b().g(true);
            xp2.h(false);
            or2.r(true);
            mt2.e().h(true);
            lt2.j(false);
            if (fm2.I() != null) {
                fm2.I().c();
            }
            rg3.h();
            ws2.i();
        }
    }
}
