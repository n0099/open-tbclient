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
import com.baidu.tieba.cu2;
import com.baidu.tieba.dw2;
import com.baidu.tieba.ve3;
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
public class qw2 extends pw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class b implements au2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw2 a;
        public final /* synthetic */ qw2 b;

        /* loaded from: classes7.dex */
        public class a implements ve3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ cu2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, cu2.g gVar) {
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

            @Override // com.baidu.tieba.ve3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    g82.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.ve3.e
            public void b(int i, zm3 zm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zm3Var) == null) {
                    g82.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    zm3 zm3Var2 = new zm3();
                    zm3Var2.k(5L);
                    zm3Var2.i(38L);
                    zm3Var2.f("download subpackage fail, errcode=" + i);
                    hi3 hi3Var = new hi3();
                    hi3Var.q(zh3.n(this.c.a.G()));
                    hi3Var.p(zm3Var2);
                    hi3Var.r(this.c.a);
                    zh3.R(hi3Var);
                }
            }
        }

        public b(qw2 qw2Var, dw2 dw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, dw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qw2Var;
            this.a = dw2Var;
        }

        @Override // com.baidu.tieba.au2
        public void a(int i, zt2 zt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, zt2Var) == null) {
                cu2.g gVar = (cu2.g) zt2Var;
                if (ve3.p(this.a, gVar)) {
                    if (gb3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = yo3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(ye3.b(f));
                        ve3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    g82.o("SwanApp", "subpackage is invalid");
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

        public a(qw2 qw2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, Long.valueOf(j)};
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
                zo3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw2 a;

        public c(qw2 qw2Var, dw2 dw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, dw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cu2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw2 a;
        public final /* synthetic */ cu2.g b;
        public final /* synthetic */ qw2 c;

        public d(qw2 qw2Var, dw2 dw2Var, cu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, dw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qw2Var;
            this.a = dw2Var;
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
        public final /* synthetic */ dw2 a;

        public e(qw2 qw2Var, dw2 dw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, dw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && nu2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106173, "Lcom/baidu/tieba/qw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106173, "Lcom/baidu/tieba/qw2;");
                return;
            }
        }
        l = qr1.a;
    }

    public qw2() {
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

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    @Nullable
    public gb3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return gb3.M();
        }
        return (gb3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ai2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    public void E(dw2 dw2Var, au2 au2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dw2Var, au2Var) == null) {
            super.E(dw2Var, au2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + dw2Var.j0());
            }
            cu2.c(dw2Var, new b(this, dw2Var));
            ai2.U().d1(dw2Var);
            ai2.U().c1(dw2Var);
            ai2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            lh2.d();
            ai2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            tn3.j();
            fy2.b();
            wz2.y();
            dm3.u();
            PaymentPanelManager.F();
            fl3.n();
            sk3.d();
            ol3.k();
            mo2.d();
            ln4.f();
            u13.e().o();
            wd3.h();
            yk3.h();
            t13.k();
            if (nu2.I() != null) {
                nu2.I().e();
            }
            x12.e().n();
            p32.b().f();
            td3.b().k();
            xp2.d();
            s22.d().h();
            l13.g().f();
            vh2.b();
            zv2.c().a();
            a63.g().b();
            SwanPrefetchImageRes.b().e();
            ff2.g().d();
            g92.c().n();
            yq3.c().i();
        }
    }

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            g82.i("SwanApp", "onAppForeground");
            String g0 = gb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", g53.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                dw2.a S = this.d.S();
                qh3.v(S);
                Y(S);
            }
            u(new il2(hashMap));
            g82.i("SwanApp", "onAppShow");
            p32.b().g(false);
            fy2.h(true);
            wz2.r(false);
            u13.e().h(false);
            x12.e().j();
            t13.i();
            if (nu2.I() != null) {
                nu2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (h53.h()) {
                z43.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                ao3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, dw2 dw2Var, cu2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, dw2Var, gVar) == null) && i == 0 && dw2Var != null && gVar != null) {
            l43.o().F(new UbcFlowEvent("na_post_to_main_start"));
            ap3.d0(this.k);
            d dVar = new d(this, dw2Var, gVar);
            this.k = dVar;
            ap3.g0(dVar);
        }
    }

    public final void X(dw2 dw2Var, cu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dw2Var, gVar) == null) {
            l43.o().F(new UbcFlowEvent("na_post_to_main_end"));
            gh3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + tw2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (dw2Var.m0()) {
                n(this.d).setVisibility(0);
                d82.b(true);
                g82.i("AppsControllerImpl", "init sConsole for devHook");
            }
            g82.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            ai2.U().Z0(dw2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    public void d(dw2 dw2Var, au2 au2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, dw2Var, au2Var) == null) {
            super.d(dw2Var, au2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + dw2Var.j0());
            }
            ai2.U().d1(dw2Var);
            ai2.U().H0(null);
            SwanAppConfigData Q = fb3.K().q().Q();
            if (Q != null) {
                cu2.g gVar = new cu2.g();
                z43.e().d(new c(this, dw2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = cu2.e.i(dw2Var.H(), dw2Var.v1()).getPath() + File.separator;
                l43.o().F(new UbcFlowEvent("na_post_to_main_start"));
                gh3.d().i("na_post_to_main_start");
                X(dw2Var, gVar);
            }
        }
    }

    public final void Y(dw2 dw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dw2Var) == null) && !TextUtils.isEmpty(dw2Var.n("fromHost")) && !TextUtils.isEmpty(dw2Var.n("spuId")) && !TextUtils.isEmpty(dw2Var.n("contentId"))) {
            ap3.b0(new e(this, dw2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            fb3 K = fb3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.rw2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = tw2.T().R();
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

    @Override // com.baidu.tieba.pw2, com.baidu.tieba.rw2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            g82.i("SwanApp", "onAppBackground");
            String g0 = gb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(ip3.b().a()));
            u(new il2(contentValues));
            g82.i("SwanApp", "onAppHide");
            ip3.b().d();
            p32.b().g(true);
            fy2.h(false);
            wz2.r(true);
            u13.e().h(true);
            t13.j(false);
            if (nu2.I() != null) {
                nu2.I().c();
            }
            zo3.h();
            e13.i();
        }
    }
}
