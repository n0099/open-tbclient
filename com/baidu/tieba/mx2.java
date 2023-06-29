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
import com.baidu.tieba.rf3;
import com.baidu.tieba.yu2;
import com.baidu.tieba.zw2;
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
public class mx2 extends lx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class b implements wu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;
        public final /* synthetic */ mx2 b;

        /* loaded from: classes6.dex */
        public class a implements rf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ yu2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, yu2.g gVar) {
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

            @Override // com.baidu.tieba.rf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    c92.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.rf3.e
            public void b(int i, vn3 vn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, vn3Var) == null) {
                    c92.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    vn3 vn3Var2 = new vn3();
                    vn3Var2.k(5L);
                    vn3Var2.i(38L);
                    vn3Var2.f("download subpackage fail, errcode=" + i);
                    dj3 dj3Var = new dj3();
                    dj3Var.q(vi3.n(this.c.a.G()));
                    dj3Var.p(vn3Var2);
                    dj3Var.r(this.c.a);
                    vi3.R(dj3Var);
                }
            }
        }

        public b(mx2 mx2Var, zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx2Var, zw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mx2Var;
            this.a = zw2Var;
        }

        @Override // com.baidu.tieba.wu2
        public void a(int i, vu2 vu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, vu2Var) == null) {
                yu2.g gVar = (yu2.g) vu2Var;
                if (rf3.p(this.a, gVar)) {
                    if (cc3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = up3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(uf3.b(f));
                        rf3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    c92.o("SwanApp", "subpackage is invalid");
                }
                this.b.W(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(mx2 mx2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx2Var, Long.valueOf(j)};
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
                vp3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;

        public c(mx2 mx2Var, zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx2Var, zw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yu2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;
        public final /* synthetic */ yu2.g b;
        public final /* synthetic */ mx2 c;

        public d(mx2 mx2Var, zw2 zw2Var, yu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx2Var, zw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mx2Var;
            this.a = zw2Var;
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

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw2 a;

        public e(mx2 mx2Var, zw2 zw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx2Var, zw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && jv2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987970, "Lcom/baidu/tieba/mx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987970, "Lcom/baidu/tieba/mx2;");
                return;
            }
        }
        l = ms1.a;
    }

    public mx2() {
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

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    @Nullable
    public cc3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return cc3.M();
        }
        return (cc3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return wi2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void E(zw2 zw2Var, wu2 wu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zw2Var, wu2Var) == null) {
            super.E(zw2Var, wu2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + zw2Var.j0());
            }
            yu2.c(zw2Var, new b(this, zw2Var));
            wi2.U().d1(zw2Var);
            wi2.U().c1(zw2Var);
            wi2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            hi2.d();
            wi2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            po3.j();
            bz2.b();
            s03.y();
            zm3.u();
            PaymentPanelManager.F();
            bm3.n();
            ol3.d();
            km3.k();
            ip2.d();
            ho4.f();
            q23.e().o();
            se3.h();
            ul3.h();
            p23.k();
            if (jv2.I() != null) {
                jv2.I().e();
            }
            t22.e().n();
            l42.b().f();
            pe3.b().k();
            tq2.d();
            o32.d().h();
            h23.g().f();
            ri2.b();
            vw2.c().a();
            w63.g().b();
            SwanPrefetchImageRes.b().e();
            bg2.g().d();
            ca2.c().n();
            ur3.c().i();
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            c92.i("SwanApp", "onAppForeground");
            String g0 = cc3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", c63.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                hashMap.put("clkid", this.d.T().L());
                hashMap.put("scene", this.d.T().T());
                zw2.a T2 = this.d.T();
                mi3.v(T2);
                Y(T2);
            }
            u(new em2(hashMap));
            c92.i("SwanApp", "onAppShow");
            l42.b().g(false);
            bz2.h(true);
            s03.r(false);
            q23.e().h(false);
            t22.e().j();
            p23.i();
            if (jv2.I() != null) {
                jv2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (d63.h()) {
                v53.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                wo3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, zw2 zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, zw2Var, gVar) == null) && i == 0 && zw2Var != null && gVar != null) {
            h53.o().F(new UbcFlowEvent("na_post_to_main_start"));
            wp3.d0(this.k);
            d dVar = new d(this, zw2Var, gVar);
            this.k = dVar;
            wp3.g0(dVar);
        }
    }

    public final void X(zw2 zw2Var, yu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, zw2Var, gVar) == null) {
            h53.o().F(new UbcFlowEvent("na_post_to_main_end"));
            ci3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + px2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (zw2Var.m0()) {
                n(this.d).setVisibility(0);
                z82.b(true);
                c92.i("AppsControllerImpl", "init sConsole for devHook");
            }
            c92.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            wi2.U().Z0(zw2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void d(zw2 zw2Var, wu2 wu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, zw2Var, wu2Var) == null) {
            super.d(zw2Var, wu2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + zw2Var.j0());
            }
            wi2.U().d1(zw2Var);
            wi2.U().H0(null);
            SwanAppConfigData Q = bc3.K().q().Q();
            if (Q != null) {
                yu2.g gVar = new yu2.g();
                v53.e().d(new c(this, zw2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = yu2.e.i(zw2Var.H(), zw2Var.v1()).getPath() + File.separator;
                h53.o().F(new UbcFlowEvent("na_post_to_main_start"));
                ci3.d().i("na_post_to_main_start");
                X(zw2Var, gVar);
            }
        }
    }

    public final void Y(zw2 zw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zw2Var) == null) && !TextUtils.isEmpty(zw2Var.n("fromHost")) && !TextUtils.isEmpty(zw2Var.n("spuId")) && !TextUtils.isEmpty(zw2Var.n("contentId"))) {
            wp3.b0(new e(this, zw2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            bc3 K = bc3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.nx2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = px2.T().R();
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

    @Override // com.baidu.tieba.lx2, com.baidu.tieba.nx2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            c92.i("SwanApp", "onAppBackground");
            String g0 = cc3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(eq3.b().a()));
            u(new em2(contentValues));
            c92.i("SwanApp", "onAppHide");
            eq3.b().d();
            l42.b().g(true);
            bz2.h(false);
            s03.r(true);
            q23.e().h(true);
            p23.j(false);
            if (jv2.I() != null) {
                jv2.I().c();
            }
            vp3.h();
            a23.i();
        }
    }
}
