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
import com.baidu.tieba.aw2;
import com.baidu.tieba.se3;
import com.baidu.tieba.zt2;
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
public class nw2 extends mw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes7.dex */
    public class b implements xt2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;
        public final /* synthetic */ nw2 b;

        /* loaded from: classes7.dex */
        public class a implements se3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ zt2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, zt2.g gVar) {
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

            @Override // com.baidu.tieba.se3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    d82.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.se3.e
            public void b(int i, wm3 wm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, wm3Var) == null) {
                    d82.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    wm3 wm3Var2 = new wm3();
                    wm3Var2.k(5L);
                    wm3Var2.i(38L);
                    wm3Var2.f("download subpackage fail, errcode=" + i);
                    ei3 ei3Var = new ei3();
                    ei3Var.q(wh3.n(this.c.a.G()));
                    ei3Var.p(wm3Var2);
                    ei3Var.r(this.c.a);
                    wh3.R(ei3Var);
                }
            }
        }

        public b(nw2 nw2Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nw2Var;
            this.a = aw2Var;
        }

        @Override // com.baidu.tieba.xt2
        public void a(int i, wt2 wt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, wt2Var) == null) {
                zt2.g gVar = (zt2.g) wt2Var;
                if (se3.p(this.a, gVar)) {
                    if (db3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = vo3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(ve3.b(f));
                        se3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    d82.o("SwanApp", "subpackage is invalid");
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

        public a(nw2 nw2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, Long.valueOf(j)};
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
                wo3.g(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;

        public c(nw2 nw2Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zt2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 a;
        public final /* synthetic */ zt2.g b;
        public final /* synthetic */ nw2 c;

        public d(nw2 nw2Var, aw2 aw2Var, zt2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, aw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nw2Var;
            this.a = aw2Var;
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
        public final /* synthetic */ aw2 a;

        public e(nw2 nw2Var, aw2 aw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nw2Var, aw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && ku2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016800, "Lcom/baidu/tieba/nw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016800, "Lcom/baidu/tieba/nw2;");
                return;
            }
        }
        l = nr1.a;
    }

    public nw2() {
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

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    @Nullable
    public db3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return db3.M();
        }
        return (db3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return xh2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void E(aw2 aw2Var, xt2 xt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aw2Var, xt2Var) == null) {
            super.E(aw2Var, xt2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + aw2Var.j0());
            }
            zt2.c(aw2Var, new b(this, aw2Var));
            xh2.U().d1(aw2Var);
            xh2.U().c1(aw2Var);
            xh2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            ih2.d();
            xh2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            qn3.j();
            cy2.b();
            tz2.y();
            am3.u();
            PaymentPanelManager.F();
            cl3.n();
            pk3.d();
            ll3.k();
            jo2.d();
            in4.f();
            r13.e().o();
            td3.h();
            vk3.h();
            q13.k();
            if (ku2.I() != null) {
                ku2.I().e();
            }
            u12.e().n();
            m32.b().f();
            qd3.b().k();
            up2.d();
            p22.d().h();
            i13.g().f();
            sh2.b();
            wv2.c().a();
            x53.g().b();
            SwanPrefetchImageRes.b().e();
            cf2.g().d();
            d92.c().n();
            vq3.c().i();
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            d82.i("SwanApp", "onAppForeground");
            String g0 = db3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", d53.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                aw2.a S = this.d.S();
                nh3.v(S);
                Y(S);
            }
            u(new fl2(hashMap));
            d82.i("SwanApp", "onAppShow");
            m32.b().g(false);
            cy2.h(true);
            tz2.r(false);
            r13.e().h(false);
            u12.e().j();
            q13.i();
            if (ku2.I() != null) {
                ku2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (e53.h()) {
                w43.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                xn3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, aw2 aw2Var, zt2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, aw2Var, gVar) == null) && i == 0 && aw2Var != null && gVar != null) {
            i43.o().F(new UbcFlowEvent("na_post_to_main_start"));
            xo3.d0(this.k);
            d dVar = new d(this, aw2Var, gVar);
            this.k = dVar;
            xo3.g0(dVar);
        }
    }

    public final void X(aw2 aw2Var, zt2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, aw2Var, gVar) == null) {
            i43.o().F(new UbcFlowEvent("na_post_to_main_end"));
            dh3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + qw2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (aw2Var.m0()) {
                n(this.d).setVisibility(0);
                a82.b(true);
                d82.i("AppsControllerImpl", "init sConsole for devHook");
            }
            d82.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            xh2.U().Z0(aw2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void d(aw2 aw2Var, xt2 xt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, aw2Var, xt2Var) == null) {
            super.d(aw2Var, xt2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + aw2Var.j0());
            }
            xh2.U().d1(aw2Var);
            xh2.U().H0(null);
            SwanAppConfigData Q = cb3.K().q().Q();
            if (Q != null) {
                zt2.g gVar = new zt2.g();
                w43.e().d(new c(this, aw2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = zt2.e.i(aw2Var.H(), aw2Var.v1()).getPath() + File.separator;
                i43.o().F(new UbcFlowEvent("na_post_to_main_start"));
                dh3.d().i("na_post_to_main_start");
                X(aw2Var, gVar);
            }
        }
    }

    public final void Y(aw2 aw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aw2Var) == null) && !TextUtils.isEmpty(aw2Var.n("fromHost")) && !TextUtils.isEmpty(aw2Var.n("spuId")) && !TextUtils.isEmpty(aw2Var.n("contentId"))) {
            xo3.b0(new e(this, aw2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            cb3 K = cb3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.ow2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = qw2.T().R();
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

    @Override // com.baidu.tieba.mw2, com.baidu.tieba.ow2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            d82.i("SwanApp", "onAppBackground");
            String g0 = db3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(fp3.b().a()));
            u(new fl2(contentValues));
            d82.i("SwanApp", "onAppHide");
            fp3.b().d();
            m32.b().g(true);
            cy2.h(false);
            tz2.r(true);
            r13.e().h(true);
            q13.j(false);
            if (ku2.I() != null) {
                ku2.I().c();
            }
            wo3.h();
            b13.i();
        }
    }
}
