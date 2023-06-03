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
import com.baidu.tieba.nf3;
import com.baidu.tieba.uu2;
import com.baidu.tieba.vw2;
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
public class ix2 extends hx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class b implements su2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw2 a;
        public final /* synthetic */ ix2 b;

        /* loaded from: classes6.dex */
        public class a implements nf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ uu2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, uu2.g gVar) {
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

            @Override // com.baidu.tieba.nf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    y82.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.nf3.e
            public void b(int i, rn3 rn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rn3Var) == null) {
                    y82.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    rn3 rn3Var2 = new rn3();
                    rn3Var2.k(5L);
                    rn3Var2.i(38L);
                    rn3Var2.f("download subpackage fail, errcode=" + i);
                    zi3 zi3Var = new zi3();
                    zi3Var.q(ri3.n(this.c.a.G()));
                    zi3Var.p(rn3Var2);
                    zi3Var.r(this.c.a);
                    ri3.R(zi3Var);
                }
            }
        }

        public b(ix2 ix2Var, vw2 vw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var, vw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ix2Var;
            this.a = vw2Var;
        }

        @Override // com.baidu.tieba.su2
        public void a(int i, ru2 ru2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, ru2Var) == null) {
                uu2.g gVar = (uu2.g) ru2Var;
                if (nf3.p(this.a, gVar)) {
                    if (yb3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = qp3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(qf3.b(f));
                        nf3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    y82.o("SwanApp", "subpackage is invalid");
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

        public a(ix2 ix2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var, Long.valueOf(j)};
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
                rp3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw2 a;

        public c(ix2 ix2Var, vw2 vw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var, vw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uu2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vw2 a;
        public final /* synthetic */ uu2.g b;
        public final /* synthetic */ ix2 c;

        public d(ix2 ix2Var, vw2 vw2Var, uu2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var, vw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ix2Var;
            this.a = vw2Var;
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
        public final /* synthetic */ vw2 a;

        public e(ix2 ix2Var, vw2 vw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix2Var, vw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && fv2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947868806, "Lcom/baidu/tieba/ix2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947868806, "Lcom/baidu/tieba/ix2;");
                return;
            }
        }
        l = is1.a;
    }

    public ix2() {
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

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    @Nullable
    public yb3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return yb3.M();
        }
        return (yb3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return si2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    public void E(vw2 vw2Var, su2 su2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vw2Var, su2Var) == null) {
            super.E(vw2Var, su2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + vw2Var.j0());
            }
            uu2.c(vw2Var, new b(this, vw2Var));
            si2.U().d1(vw2Var);
            si2.U().c1(vw2Var);
            si2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            di2.d();
            si2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            lo3.j();
            xy2.b();
            o03.y();
            vm3.u();
            PaymentPanelManager.F();
            xl3.n();
            kl3.d();
            gm3.k();
            ep2.d();
            do4.f();
            m23.e().o();
            oe3.h();
            ql3.h();
            l23.k();
            if (fv2.I() != null) {
                fv2.I().e();
            }
            p22.e().n();
            h42.b().f();
            le3.b().k();
            pq2.d();
            k32.d().h();
            d23.g().f();
            ni2.b();
            rw2.c().a();
            s63.g().b();
            SwanPrefetchImageRes.b().e();
            xf2.g().d();
            y92.c().n();
            qr3.c().i();
        }
    }

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            y82.i("SwanApp", "onAppForeground");
            String g0 = yb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", y53.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                hashMap.put("clkid", this.d.T().L());
                hashMap.put("scene", this.d.T().T());
                vw2.a T2 = this.d.T();
                ii3.v(T2);
                Y(T2);
            }
            u(new am2(hashMap));
            y82.i("SwanApp", "onAppShow");
            h42.b().g(false);
            xy2.h(true);
            o03.r(false);
            m23.e().h(false);
            p22.e().j();
            l23.i();
            if (fv2.I() != null) {
                fv2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (z53.h()) {
                r53.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                so3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, vw2 vw2Var, uu2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, vw2Var, gVar) == null) && i == 0 && vw2Var != null && gVar != null) {
            d53.o().F(new UbcFlowEvent("na_post_to_main_start"));
            sp3.d0(this.k);
            d dVar = new d(this, vw2Var, gVar);
            this.k = dVar;
            sp3.g0(dVar);
        }
    }

    public final void X(vw2 vw2Var, uu2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, vw2Var, gVar) == null) {
            d53.o().F(new UbcFlowEvent("na_post_to_main_end"));
            yh3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + lx2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (vw2Var.m0()) {
                n(this.d).setVisibility(0);
                v82.b(true);
                y82.i("AppsControllerImpl", "init sConsole for devHook");
            }
            y82.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            si2.U().Z0(vw2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    public void d(vw2 vw2Var, su2 su2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, vw2Var, su2Var) == null) {
            super.d(vw2Var, su2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + vw2Var.j0());
            }
            si2.U().d1(vw2Var);
            si2.U().H0(null);
            SwanAppConfigData Q = xb3.K().q().Q();
            if (Q != null) {
                uu2.g gVar = new uu2.g();
                r53.e().d(new c(this, vw2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = uu2.e.i(vw2Var.H(), vw2Var.v1()).getPath() + File.separator;
                d53.o().F(new UbcFlowEvent("na_post_to_main_start"));
                yh3.d().i("na_post_to_main_start");
                X(vw2Var, gVar);
            }
        }
    }

    public final void Y(vw2 vw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, vw2Var) == null) && !TextUtils.isEmpty(vw2Var.n("fromHost")) && !TextUtils.isEmpty(vw2Var.n("spuId")) && !TextUtils.isEmpty(vw2Var.n("contentId"))) {
            sp3.b0(new e(this, vw2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            xb3 K = xb3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.jx2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = lx2.T().R();
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

    @Override // com.baidu.tieba.hx2, com.baidu.tieba.jx2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            y82.i("SwanApp", "onAppBackground");
            String g0 = yb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(aq3.b().a()));
            u(new am2(contentValues));
            y82.i("SwanApp", "onAppHide");
            aq3.b().d();
            h42.b().g(true);
            xy2.h(false);
            o03.r(true);
            m23.e().h(true);
            l23.j(false);
            if (fv2.I() != null) {
                fv2.I().c();
            }
            rp3.h();
            w13.i();
        }
    }
}
